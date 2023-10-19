package co.jp.starse.kintai.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.jp.starse.kintai.config.UserAuthProvider;
import co.jp.starse.kintai.response.ApiResponse;

@RestController
@RequestMapping("api/v1/admin/")
public class TestingController {
	
	@Autowired
	UserAuthProvider userAuthProvider;
	
	@GetMapping("/test")
	public ResponseEntity<Object> test(@RequestParam(name = "name", required = false) String name,Authentication auth) {
		
		return new ApiResponse(
				"This is auth user",
				HttpStatus.OK,
				userAuthProvider.getAuthUser(auth)
		).response();
	}
}
