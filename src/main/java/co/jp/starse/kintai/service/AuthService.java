package co.jp.starse.kintai.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import co.jp.starse.kintai.common.Messages;
import co.jp.starse.kintai.config.UserAuthProvider;
import co.jp.starse.kintai.dto.LoginDto;
import co.jp.starse.kintai.dto.LoginResponseDto;
import co.jp.starse.kintai.dto.PwdChangeDto;
import co.jp.starse.kintai.dto.SignUpDto;
import co.jp.starse.kintai.dto.UsersDto;
import co.jp.starse.kintai.entity.Users;
import co.jp.starse.kintai.repository.AuthMapper;
import co.jp.starse.kintai.response.ApiErrorResponse;
import co.jp.starse.kintai.response.ApiResponse;

@Service
public class AuthService {
	@Autowired
	UserService userService;

	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	AuthMapper authMapper;

	@Autowired
	UserAuthProvider userAuthProvider;
	
	public ResponseEntity<Object> login(LoginDto dto) {
		Users user = userService.findByEmail(dto.getLogin());
		Map<String, Object> errors = dto.validate();
		if (errors.size() > 0) {
			return new ApiErrorResponse(errors, HttpStatus.UNAUTHORIZED, "Login is not successful!").response();
		}

		if (user != null && passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
			LoginResponseDto loginResponse = new LoginResponseDto();
			loginResponse.setCode(200);
			loginResponse.setMessage(Messages.LOGIN_SUCCESS);
			loginResponse.setToken(userAuthProvider.createToken(dto.getLogin()));
			loginResponse.setUser(user.toUserDto());
			return ResponseEntity.ok(loginResponse);
		}
		return new ApiResponse(Messages.LOGIN_FAIL, HttpStatus.CONFLICT).response();
	}
	
	public ResponseEntity<Object> pwdChange(PwdChangeDto dto){
		Users user = userService.findByEmail(dto.getLogin());
		if (user != null && passwordEncoder.matches(dto.getOldPassword(), user.getPassword())) {
			user.setPassword(passwordEncoder.encode(dto.getNewPassword()));
			userService.changePassword(user);
			return new ApiResponse(Messages.PASSWORD_CHANGE_SUCCESS, HttpStatus.OK).response();
		}
		return new ApiResponse(Messages.PASSWORD_CHANGE_FAIL, HttpStatus.CONFLICT).response();
	}

	public ResponseEntity<Object> register(UsersDto dto){
		Users user = userService.findByEmail(dto.getMail());
		if(user == null ) {
			user=new Users();
			dto.setPassword(passwordEncoder.encode(dto.getPassword()));
			try {
				authMapper.register(dto);
				UsersDto registeredUserDto = userService.findByEmail(dto.getMail()).toUserDto();
				LoginResponseDto loginResponse = new LoginResponseDto();
				loginResponse.setCode(200);
				loginResponse.setMessage(Messages.REGISTER_SUCCESS);
				loginResponse.setUser(registeredUserDto);
				loginResponse.setToken(userAuthProvider.createToken(dto.getMail()));
				return new ResponseEntity<Object>(loginResponse, HttpStatus.CREATED);
			} catch (Exception e) {
				return new ApiResponse(Messages.REGISTER_FAIL, HttpStatus.BAD_REQUEST).response();
			}
		}else {
			return new ApiResponse(Messages.REGISTER_MAIL_DUPLICATE, HttpStatus.CONFLICT).response();
			}
	}
}
