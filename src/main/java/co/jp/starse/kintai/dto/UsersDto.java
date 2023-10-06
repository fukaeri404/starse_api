package co.jp.starse.kintai.dto;

import java.sql.Timestamp;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UsersDto {
	@JsonProperty("user_id")
	private int userId;
	private int kubunId;
	@JsonProperty("user_name")
	private String userName;
	@JsonProperty("user_name_kana")
	private String userNameKana;
	@JsonProperty("user_name_ryaku")
	private String userNameRyaku;
	private String mail;
	private String password;
	@JsonProperty("user_img_path")
	private String userImgPath;
	@JsonProperty("group_id")
	private int groupId;
	private String role;
	@JsonProperty("shoninsha_kubun")
	private String shoninshaKubun;
	private LocalDate birthday;
	@JsonProperty("user_kubun")
	private String userKubun;
	@JsonProperty("nyusha_date")
	private LocalDate nyushaDate;
	private String status;
	@JsonProperty("remain_leave")
	private int remainLeave;
	@JsonProperty("last_get_leave_dt")
	private LocalDate lastGetLeaveDt;
	@JsonProperty("next_get_leave_dt")
	private LocalDate nextGetLeaveDt;
	@JsonProperty("created_user_id")
	private int createdUserId;
	@JsonProperty("updated_user_id")
	private int updatedUserId;
	@JsonProperty("created_at")
	private Timestamp createdAt;
	@JsonProperty("updated_at")
	private Timestamp updatedAt;
}
