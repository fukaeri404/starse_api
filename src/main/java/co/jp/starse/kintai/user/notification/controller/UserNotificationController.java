package co.jp.starse.kintai.user.notification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.jp.starse.kintai.user.notification.service.UserNotificationService;

@RequestMapping("${api.base-path-user}")
@RestController
public class UserNotificationController {

	@Autowired
	UserNotificationService userNotificationService;
	
	// localhost:8080/api/v1/user/user-noti
	
	@GetMapping("/user-noti")
	public ResponseEntity<Object> example() {
		
		return userNotificationService.getAllUser();
	}
}
