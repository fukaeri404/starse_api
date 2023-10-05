package co.jp.starse.kintai.dto;

import co.jp.starse.kintai.entity.Users;
import lombok.Data;

@Data
public class SignUpDto {
	private String login;
	private String password;
	private String role;

	public Users toUserEntity() {
		Users user = new Users();
		user.setMail(login);
		user.setPassword(password);
		user.setRole(role);
		return user;
	}
}
