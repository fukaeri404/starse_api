package co.jp.starse.kintai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import co.jp.starse.kintai.config.UserAuthProvider;
import co.jp.starse.kintai.dto.LoginDto;
import co.jp.starse.kintai.dto.LoginResponseDto;
import co.jp.starse.kintai.entity.Users;

@Service
public class LoginService {
	@Autowired
	UserService userService;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	UserAuthProvider userAuthProvider;
	
	
	
	public ResponseEntity<Object> login(LoginDto dto){
		Users users = userService.findByEmail(dto.getLogin());
		if(users!=null && passwordEncoder.matches(dto.getPassword(), users.getPassword())) {
			LoginResponseDto responseDto=users.toLoginResponseDto();
			responseDto.setToken(userAuthProvider.createToken(dto.getLogin()));
			return ResponseEntity.ok(responseDto);
		}
		return new ResponseEntity<Object>("username or password does not mathch",HttpStatus.BAD_REQUEST);
	}

}
