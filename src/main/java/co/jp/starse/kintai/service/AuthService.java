package co.jp.starse.kintai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import co.jp.starse.kintai.common.Messages;
import co.jp.starse.kintai.config.UserAuthProvider;
import co.jp.starse.kintai.dto.LoginDto;
import co.jp.starse.kintai.dto.LoginResponseDto;
import co.jp.starse.kintai.entity.Users;
import co.jp.starse.kintai.exception.ApiResponse;

@Service
public class AuthService {
	@Autowired
	UserService userService;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	UserAuthProvider userAuthProvider;

	public ResponseEntity<Object> login(LoginDto dto) {
		Users user = userService.findByEmail(dto.getLogin());
		if (user != null && passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
			LoginResponseDto loginResponse = new LoginResponseDto();
			loginResponse.setCode(200);
			loginResponse.setMessage(Messages.LOGIN_SUCCESS);
			loginResponse.setUser(user.toUserDto());
			return ResponseEntity.ok(loginResponse);
		}
		return new ApiResponse(Messages.LOGIN_FAIL, HttpStatus.CONFLICT).response();
	}
}
