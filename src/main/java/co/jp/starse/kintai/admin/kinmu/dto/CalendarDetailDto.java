package co.jp.starse.kintai.admin.kinmu.dto;

import java.sql.Timestamp;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import co.jp.starse.kintai.admin.kinmu.entity.CalendarDetailEntity;
import lombok.Data;

@Data
public class CalendarDetailDto {
	@JsonProperty("calender_detail_id")
	private Long calenderDetailId;
	@JsonProperty("calender_id")
	private Long calenderId;
	@JsonProperty("kyujitsu_date")
	private String kyujitsuDate;
	@JsonProperty("kyujitsu_type")
	private String kyujitsuType;
	@JsonProperty("kyujitsu_name")
	private String kyujitsuName;
	@JsonProperty("created_user_id")
	private Long createdUserId;
	@JsonProperty("updated_user_id")
	private Long updatedUserId;
	@JsonProperty("created_at")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
	private Timestamp createdAt;
	@JsonProperty("updated_at")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
	private Timestamp updatedAt;
	
	public CalendarDetailEntity toEntity() {
		CalendarDetailEntity entity = new CalendarDetailEntity();
		entity.setCalenderDetailId(calenderDetailId);
		entity.setCalenderId(calenderId);
		entity.setKyujitsuDate(LocalDate.parse(kyujitsuDate));
		entity.setKyujitsuType(kyujitsuType);
		entity.setKyujitsuName(kyujitsuName);
		entity.setCreatedUserId(createdUserId);
		entity.setUpdatedUserId(updatedUserId);
		entity.setCreatedAt(createdAt);
		entity.setUpdatedAt(updatedAt);
		return entity;
	}
}
