package co.jp.starse.kintai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.jp.starse.kintai.dto.LoginDto;
import co.jp.starse.kintai.dto.PwdChangeDto;
import co.jp.starse.kintai.entity.Users;
import co.jp.starse.kintai.service.AuthService;
import co.jp.starse.kintai.service.UserService;

@CrossOrigin
@RequestMapping("${api.base-path}")
@RestController
public class AuthController {
	@Autowired
	AuthService loginService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@PostMapping("/login")
	public ResponseEntity<Object> login(@RequestBody LoginDto dto){
		return loginService.login(dto);
	}
	
	@PostMapping("/change-password")
	public ResponseEntity<Object> pwdChange(@RequestBody PwdChangeDto pwdChangeDto){
		return loginService.pwdChange(pwdChangeDto);
	}
}
