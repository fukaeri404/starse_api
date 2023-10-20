package co.jp.starse.kintai.shunin.renraku.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.jp.starse.kintai.shunin.renraku.service.RenrakuService;

@RequestMapping("${api.base-path-shoninsha}")
@RestController
public class RenrakuController {

	@Autowired
	RenrakuService renrakuService;
	
	@GetMapping("/shunin-renraku")
	public ResponseEntity<Object> example() {
		
		return renrakuService.getAllUser();
	}
}
