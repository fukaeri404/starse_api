package co.jp.starse.kintai.admin.kinmu.entity;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import co.jp.starse.kintai.admin.kinmu.dto.CalendarDetailDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CalendarDetailEntity {
	private Long calenderDetailId;
	private Long calenderId;
	private LocalDate kyujitsuDate;
	private String kyujitsuType;
	private String kyujitsuName;
	private Long createdUserId;
	private Long updatedUserId;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	
	public CalendarDetailDto toDto() {
		CalendarDetailDto dto = new CalendarDetailDto();
		dto.setCalenderDetailId(calenderDetailId);
		dto.setCalenderId(calenderId);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		dto.setKyujitsuDate(kyujitsuDate.format(formatter));
		dto.setKyujitsuType(kyujitsuType);
		dto.setKyujitsuName(kyujitsuName);
		dto.setCreatedUserId(createdUserId);
		dto.setUpdatedUserId(updatedUserId);
		dto.setCreatedAt(createdAt);
		dto.setUpdatedAt(updatedAt);
		return dto;
	}
}
