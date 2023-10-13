package co.jp.starse.kintai.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class PwdChangeDto {
	private String email;
	@JsonProperty("old_password")
	private String oldPassword;
	@JsonProperty("new_password")
	private String newPassword;
	@JsonProperty("user_id")
	private int userId;
}
