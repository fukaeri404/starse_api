package co.jp.starse.kintai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.jp.starse.kintai.dto.LoginDto;
import co.jp.starse.kintai.service.LoginService;

@CrossOrigin
@RequestMapping("${api.base-path}")
@RestController
public class LoginController {
	@Autowired
	LoginService loginService;
	
	@PostMapping("/login")
	public ResponseEntity<Object> login(@RequestBody LoginDto dto){
		return loginService.login(dto);
	}

}
