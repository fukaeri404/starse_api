package co.jp.starse.kintai.admin.kubun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.jp.starse.kintai.admin.kubun.service.KubunService;

@RequestMapping("${api.base-path-admin}")
@RestController
public class KubunController {
	@Autowired
	KubunService kubunService;

	// API CALL : localhost:8080/api/v1/admin/admin-kubun

	@GetMapping("/admin-kubun")
	public ResponseEntity<Object> example() {

		return kubunService.getAllUser();
	}
}
