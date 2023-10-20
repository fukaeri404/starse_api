package co.jp.starse.kintai.admin.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.jp.starse.kintai.admin.account.service.AccountService;
import co.jp.starse.kintai.config.UserAuthProvider;
import co.jp.starse.kintai.config.UserAuthProvider.AuthUser;
import co.jp.starse.kintai.response.ApiResponse;

@RequestMapping("${api.base-path-admin}")
@RestController
public class AccountController {
	
	@Autowired
	AccountService accountService;
	
	@Autowired
	UserAuthProvider userAuthProvider;
	
	// API CALL : localhost:8080/api/v1/admin/admin-account
	
	@GetMapping("/admin-account")
	public ResponseEntity<Object> example(Authentication auth) {
		
		// AuthUser authUser = userAuthProvider.getAuthUser(auth);
		
		// return new ApiResponse(HttpStatus.OK,"This is message",authUser).response();
		
		return accountService.getAllUser();
	}
	
}