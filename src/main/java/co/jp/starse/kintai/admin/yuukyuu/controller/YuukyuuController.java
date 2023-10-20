package co.jp.starse.kintai.admin.yuukyuu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.jp.starse.kintai.admin.yuukyuu.service.YuukyuuService;

@RequestMapping("${api.base-path-admin}")
@RestController
public class YuukyuuController {

	@Autowired
	YuukyuuService yuukyuuService;

	// API CALL : localhost:8080/api/v1/admin/admin-yuukyuu
	@GetMapping("/admin-yuukyuu")
	public ResponseEntity<Object> example() {

		return yuukyuuService.getAllUser();
	}

}
