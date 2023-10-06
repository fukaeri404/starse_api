package co.jp.starse.kintai.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("${api.base-path-shoninsha}")
@RestController
public class ShoninshaController {
	@GetMapping("/testing")
	public ResponseEntity<Object> testing(){
		return ResponseEntity.ok("Shoninsha Testing successful!");
	}
}
