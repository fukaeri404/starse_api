package co.jp.starse.kintai.shunin.notification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.jp.starse.kintai.shunin.notification.service.ShuninNotificationService;

@RequestMapping("${api.base-path-shoninsha}")
@RestController
public class NotificationController {

	@Autowired
	ShuninNotificationService shuninNotificationService;
	
	// localhost:8080/api/v1/shunin/shunin-notification
	
	@GetMapping("/shunin-notification")
	public ResponseEntity<Object> example() {
		
		return shuninNotificationService.getAllUser();
	}
}
