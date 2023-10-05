package co.jp.starse.kintai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.jp.starse.kintai.config.UserAuthProvider;
import co.jp.starse.kintai.dto.LoginDto;
import co.jp.starse.kintai.dto.PwdChangeDto;
import co.jp.starse.kintai.dto.SignUpDto;
import co.jp.starse.kintai.dto.UsersDto;
import co.jp.starse.kintai.entity.Users;
import co.jp.starse.kintai.service.AuthService;
import co.jp.starse.kintai.service.UserService;

@CrossOrigin
@RequestMapping("${api.base-path}")
@RestController
public class AuthController {
	
	@Autowired
	UserAuthProvider userAuthProvider;
	
	@Autowired
	AuthService loginService;

	@Autowired
	UserService userService;

	@Autowired
	PasswordEncoder passwordEncoder;
	
	@PostMapping("/admin/users")
	public ResponseEntity<Object> register(@RequestBody UsersDto dto) {
		return loginService.register(dto);
	}

	@PostMapping("/login")
	public ResponseEntity<Object> login(@RequestBody LoginDto dto) {
		return loginService.login(dto);
	}

	@PostMapping("/change-password")
	public ResponseEntity<Object> pwdChange(@RequestBody PwdChangeDto pwdChangeDto) {
		return loginService.pwdChange(pwdChangeDto);
	}

	@PostMapping("/forget-password")
	public ResponseEntity<Object> forgetPassword(@RequestBody LoginDto dto) {
		String token = userAuthProvider.createToken(dto.getLogin() + "<<~>>" + dto.getPassword());
		String link = "http://localhost:8080/api/v1/confirm-password-reset/" + token;
		return new ResponseEntity<Object>(link, HttpStatus.OK);
	}

	@GetMapping("/confirm-password-reset/{token}")
	public ResponseEntity<Object> confirmPassword(@PathVariable("token") String token) {
		userAuthProvider.passwordResetFromUrl(token);
		return new ResponseEntity<Object>("successiful password change", HttpStatus.OK);
	}
}
