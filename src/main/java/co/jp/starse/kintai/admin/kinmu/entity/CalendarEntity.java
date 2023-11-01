package co.jp.starse.kintai.admin.kinmu.entity;

import java.sql.Timestamp;

import co.jp.starse.kintai.admin.kinmu.dto.CalendarDto;
import lombok.Data;

@Data
public class CalendarEntity {
	private Long calenderId;
	private String taishoYearMonth;
	private Integer calenderDays;
	private Timestamp createdAt;
	private Timestamp updatedAt;

	public CalendarDto toDto() {
		CalendarDto dto = new CalendarDto();
		dto.setCalenderId(calenderId);
		dto.setTaishoYearMonth(taishoYearMonth);
		dto.setCalenderDays(String.valueOf(calenderDays));
		dto.setCreatedAt(createdAt);
		dto.setUpdatedAt(updatedAt);
		return dto;
	}
}
