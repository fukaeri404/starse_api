package co.jp.starse.kintai.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("${api.base-path-admin}")
@RestController
public class AdminController {
	@GetMapping("/testing")
	public ResponseEntity<Object> testing(){
		return ResponseEntity.ok("Admin Testing successful!");
	}
}
