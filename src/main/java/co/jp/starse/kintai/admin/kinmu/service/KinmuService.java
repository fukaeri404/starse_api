package co.jp.starse.kintai.admin.kinmu.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import co.jp.starse.kintai.admin.kinmu.dto.CalendarDetailDto;
import co.jp.starse.kintai.admin.kinmu.dto.CalendarDto;
import co.jp.starse.kintai.admin.kinmu.dto.KinmuDto;
import co.jp.starse.kintai.admin.kinmu.entity.CalendarDetailEntity;
import co.jp.starse.kintai.admin.kinmu.entity.CalendarEntity;
import co.jp.starse.kintai.admin.kinmu.repository.KinmuRepository;
import co.jp.starse.kintai.common.Messages;
import co.jp.starse.kintai.config.UserAuthProvider;
import co.jp.starse.kintai.config.UserAuthProvider.AuthUser;
import co.jp.starse.kintai.response.ApiErrorResponse;
import co.jp.starse.kintai.response.ApiResponse;
import co.jp.starse.kintai.utility.CommonUtils;

@Service
public class KinmuService {

	@Autowired
	KinmuRepository kinmuRepository;

	@Autowired
	UserAuthProvider userAuthProvider;

	public ResponseEntity<Object> getAllUser() {
		return new ApiResponse(HttpStatus.OK, "アカウントデータ取得は完了しました。", kinmuRepository.getAllUser()).response();
	}

	public ResponseEntity<Object> register(KinmuDto dto, Authentication auth) {
		Map<String, Object> errors = dto.validate();
		AuthUser authUser = userAuthProvider.getAuthUser(auth);

		if (errors.size() > 0) {
			System.out.println(errors.size());
			return new ApiErrorResponse(errors, HttpStatus.BAD_REQUEST, Messages.REGISTER_FAIL).response();
		}

		dto.setCreatedAt(new Timestamp(System.currentTimeMillis()));
		dto.setCreatedUserId(authUser.getId());

		kinmuRepository.register(dto.toEntity());

		return new ApiResponse(HttpStatus.CREATED, Messages.REGISTER_SUCCESS).response();
	}

	public ResponseEntity<Object> registerCalendar(CalendarDto dto) {
		Map<String, Object> errors = dto.validate();
		boolean isRepeat = false;
		if (errors.size() > 0) {
			System.out.println(errors.size());
			return new ApiErrorResponse(errors, HttpStatus.BAD_REQUEST, Messages.REGISTER_FAIL).response();
		}

		dto.setCreatedAt(new Timestamp(System.currentTimeMillis()));
		ArrayList<CalendarDto> cdto = new ArrayList<>();
		if (kinmuRepository.getAllCalendars().size() > 0) {
			for (CalendarEntity c : kinmuRepository.getAllCalendars())
				cdto.add(c.toDto());

			for (CalendarDto d : cdto) {
				if (d.getTaishoYearMonth().equals(dto.getTaishoYearMonth())) {
					isRepeat = true;
					errors.put("taisho_year_month", "入力された対象年月はもうあります");
					break;
				}
			}
		}

		if (isRepeat)
			return new ApiErrorResponse(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.getReasonPhrase(), errors)
					.response();
		else
			kinmuRepository.registerCalendar(dto.toEntity());

		return new ApiResponse(HttpStatus.CREATED, Messages.REGISTER_SUCCESS).response();
	}

	public ResponseEntity<Object> getCalendarDetails(String year) {
		Map<String, Object> errors = new LinkedHashMap<String, Object>();
		if (!CommonUtils.isNumeric(year)) {
			errors.put("path_year", "ほしい年とフォーマットが正しくありません（例：「２０２３」）");
			return new ApiErrorResponse(errors, HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.getReasonPhrase())
					.response();
		}

		ArrayList<CalendarDetailEntity> cDetailEntity = kinmuRepository
				.getAllCalendarDetailsByYear(Integer.parseInt(year));
		ArrayList<CalendarEntity> cEntity = kinmuRepository.getAllCalendars();

		ArrayList<CalendarDetailDto> cDetailDtoAll = new ArrayList<>();
		ArrayList<CalendarDto> cDtoAll = new ArrayList<>();

		for (CalendarDetailEntity c : cDetailEntity) {
			cDetailDtoAll.add(c.toDto());
		}

		for (CalendarEntity ce : cEntity) {
			cDtoAll.add(ce.toDto());
		}

		ArrayList<Map<String, ArrayList<CalendarDetailDto>>> bigg = new ArrayList<>();
		Map<String, ArrayList<CalendarDetailDto>> cDetailMonthMap = new LinkedHashMap<>();

		for (CalendarDto cDto : cDtoAll) {
			ArrayList<CalendarDetailDto> cDetailMonth = new ArrayList<>();
			for (CalendarDetailDto cDetaildto : cDetailDtoAll) {
				if (cDto.getCalenderId() == cDetaildto.getCalenderId()) {
					cDetailMonth.add(cDetaildto);
//					cDetailMonthMap.put(cDto.getTaishoYearMonth(), cDetailMonth); /* here if you don't want to show other months which doesn't have holidays */
				}
			}
			if(cDto.getTaishoYearMonth().substring(0,4).equals(year)) {
				cDetailMonthMap.put(cDto.getTaishoYearMonth(), cDetailMonth);
			}
		}
		bigg.add(cDetailMonthMap);
		return new ApiResponse(bigg, HttpStatus.OK, HttpStatus.OK.getReasonPhrase()).response();
	}
}
