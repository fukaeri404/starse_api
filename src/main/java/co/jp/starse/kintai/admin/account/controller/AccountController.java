package co.jp.starse.kintai.admin.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.jp.starse.kintai.admin.account.service.AccountService;

@RequestMapping("${api.base-path-admin}")
@RestController
public class AccountController {
	
	@Autowired
	AccountService accountService;
	
	// API CALL : localhost:8080/api/v1/admin/admin-account
	
	@GetMapping("/admin-account")
	public ResponseEntity<Object> example() {
		
		return accountService.getAllUser();
	}
}