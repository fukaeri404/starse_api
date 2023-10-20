package co.jp.starse.kintai.admin.kubun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.jp.starse.kintai.admin.kinmu.service.KinmuService;

@RequestMapping("${api.base-path-admin}")
@RestController
public class KubunController {
	@Autowired
	KinmuService kinmuService;
	
	@GetMapping("/admin-kinmu")
	public ResponseEntity<Object> example() {
		
		return kinmuService.getAllUser();
	}
}
