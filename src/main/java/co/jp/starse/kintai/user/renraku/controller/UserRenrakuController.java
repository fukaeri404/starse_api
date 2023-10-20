package co.jp.starse.kintai.user.renraku.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.jp.starse.kintai.user.renraku.service.UserRenrakuService;

@RequestMapping("${api.base-path-user}")
@RestController
public class UserRenrakuController {
	
	@Autowired
	UserRenrakuService userRenrakuService;
	
	@GetMapping("/user-renraku")
	public ResponseEntity<Object> example() {
		
		return userRenrakuService.getAllUser();
	}
}
