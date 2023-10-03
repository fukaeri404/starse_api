package co.jp.starse.kintai.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class LoginResponseDto {
	private int id;
	private String login;
	private String token;
	private String role;

}
