package co.jp.starse.kintai.admin.kinmu.entity;

import java.sql.Timestamp;

import co.jp.starse.kintai.admin.kinmu.dto.CalendarDto;
import lombok.Data;

@Data
public class CalendarEntity {
	private Long calendarId;
	private String taishoYearMonth;
	private Integer calenderDays;
	private Timestamp createdAt;
	private Timestamp updatedAt;

	public CalendarDto calendarDto() {
		CalendarDto dto = new CalendarDto();
		dto.setCalendarId(calendarId);
		dto.setTaishoYearMonth(taishoYearMonth);
		dto.setCalenderDays(String.valueOf(calenderDays));
		dto.setCreatedAt(createdAt);
		dto.setUpdatedAt(updatedAt);
		return dto;
	}
}
