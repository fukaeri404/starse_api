package co.jp.starse.kintai.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/pub/")
public class TestingController {
	
	@GetMapping("/test")
	public ResponseEntity<Object> test(@RequestParam(name = "name", required = false) String name) {
		return ResponseEntity.ok("Testing " + name);
	}
}
