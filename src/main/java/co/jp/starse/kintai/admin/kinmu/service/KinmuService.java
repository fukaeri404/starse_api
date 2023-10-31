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
	
	public ResponseEntity<Object> register(KinmuDto dto, Authentication auth){
		Map<String, Object> errors = dto.validate();
		AuthUser authUser = userAuthProvider.getAuthUser(auth);
		
		if(errors.size()>0) {
			System.out.println(errors.size());
			return new ApiErrorResponse(errors, HttpStatus.BAD_REQUEST, Messages.REGISTER_FAIL).response();
		}
		
		dto.setCreatedAt(new Timestamp(System.currentTimeMillis()));
		dto.setCreatedUserId(authUser.getId());
		
		kinmuRepository.register(dto.toEntity());
		
		return new ApiResponse(HttpStatus.CREATED, Messages.REGISTER_SUCCESS).response();
	}
	
	public ResponseEntity<Object> registerCalendar(CalendarDto dto){
		Map<String, Object> errors = dto.validate();
		
		if(errors.size()>0) {
			System.out.println(errors.size());
			return new ApiErrorResponse(errors, HttpStatus.BAD_REQUEST, Messages.REGISTER_FAIL).response();
		}
		
		dto.setCreatedAt(new Timestamp(System.currentTimeMillis()));
		kinmuRepository.registerCalendar(dto.toEntity());
		
		return new ApiResponse(HttpStatus.CREATED, Messages.REGISTER_SUCCESS).response();
	}

	public ResponseEntity<Object> getCalendarDetails(String year) {
		Map<String, Object> errors = new LinkedHashMap<String, Object>();
		if(!CommonUtils.isNumeric(year)) {
			errors.put("year", "ほしい年とフォーマットが正しくありません（例：「２０２３」）");
			return new ApiErrorResponse(errors, HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.getReasonPhrase()).response();
		}
		
		ArrayList<CalendarDetailEntity> cDetailEntity = kinmuRepository.getCalendarDetailByYear(Integer.parseInt(year));
		ArrayList<CalendarDetailDto> cDetailDto = new ArrayList<>();
		for(CalendarDetailEntity c : cDetailEntity) {
			cDetailDto.add(c.toDto());
		}
		
		ArrayList<Map<String, ArrayList<CalendarDetailDto>>> bigg = new ArrayList<>();
		Map<String, ArrayList<CalendarDetailDto>> smalll = new LinkedHashMap<>();
		smalll.put(year, cDetailDto);
		bigg.add(smalll);
		
		return new ApiResponse(bigg, HttpStatus.OK, HttpStatus.OK.getReasonPhrase()).response();
	}
}
