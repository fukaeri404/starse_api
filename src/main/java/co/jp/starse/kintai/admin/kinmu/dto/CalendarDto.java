package co.jp.starse.kintai.admin.kinmu.dto;

import java.sql.Timestamp;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import co.jp.starse.kintai.admin.kinmu.entity.CalendarEntity;
import co.jp.starse.kintai.utility.CommonUtils;
import co.jp.starse.kintai.utility.StdRequestDto;
import lombok.Data;

@Data
public class CalendarDto implements StdRequestDto{
	@JsonProperty("calendar_id")
	private Long calendarId;
	@JsonProperty("taisho_year_month")
	private String taishoYearMonth;
	@JsonProperty("calender_days")
	private String calenderDays;
	@JsonProperty("created_at")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
	private Timestamp createdAt;
	@JsonProperty("updated_at")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
	private Timestamp updatedAt;
	
	@Override
	public Map<String, Object> validate() {
		Map<String, Object> errors = new LinkedHashMap<String, Object>();
		if(CommonUtils.isEmpty(taishoYearMonth)) {
			errors.put("taisho_year_month", "対象年月が必要です");
		}else if(!isValidYear_Month(taishoYearMonth)) {
			errors.put("taisho_year_month", "対象年月フォーマットが正しくありません（例：”２０２３－０２”");
		}
		
		if(CommonUtils.isEmpty(calenderDays)) {
			errors.put("calender_days", "カレンダー日数が必要です");
		}else if(!CommonUtils.isNumeric(calenderDays)) {
			errors.put("calender_days", "カレンダー日数フォーマットが正しくありません");
		}
		
		return errors;
	}
	
	private boolean isValidYear_Month(String input) {
		String pattern = "^(\\d{4})-(0[1-9]|1[0-2])$";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(input);
		return m.matches();
	}
	
	public CalendarEntity toEntity() {
		CalendarEntity calendar = new CalendarEntity();
		calendar.setCalendarId(calendarId);
		calendar.setTaishoYearMonth(taishoYearMonth);
		calendar.setCalenderDays(Integer.parseInt(calenderDays));
		calendar.setCreatedAt(createdAt);
		calendar.setUpdatedAt(updatedAt);
		return calendar; 
	}
}
