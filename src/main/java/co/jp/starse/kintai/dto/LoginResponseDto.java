package co.jp.starse.kintai.dto;


import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class LoginResponseDto {
	private int code;
	private String message;
	private String token;
	private UsersDto user;
	public LoginResponseDto(HttpStatus status) {
		this.code = status.value();
	}
}
