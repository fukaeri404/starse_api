package co.jp.starse.kintai.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.jp.starse.kintai.entity.Users;

@CrossOrigin
@RequestMapping("${api.base-path-user}")
@RestController
public class UserController {
	
	@GetMapping("/testing")
	public ResponseEntity<Object> testing(){
		return ResponseEntity.ok("User Testing successful!");
	}

	@PostMapping("/admin/account/registration")
	public Users createUsers() {
		return null;
	}
}
