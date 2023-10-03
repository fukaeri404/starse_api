package co.jp.starse.kintai.dto;

import java.sql.Timestamp;

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
	private int userId;
	private int kubunId;
	@JsonProperty("user_name")
	private String userName;
	@JsonProperty("user_name_kana")
	private String userNameKana;
	private String userNameRyaku;
	private String email;
	private String userImgPath;
	private int groupId;
	private String authority;
	private String shoninshaKubun;
	private String birthday;
	private String userKubun;
	private String nyushaDate;
	private String status;
	private int remainLeave;
	private String lastGetLeaveDt;
	private String nextGetLeaveDt;
	private int createdUserId;
	private int updatedUserId;
	private Timestamp createdAt;
	private Timestamp updatedAt;
}
