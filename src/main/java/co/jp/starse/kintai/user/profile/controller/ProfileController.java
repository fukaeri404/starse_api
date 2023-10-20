package co.jp.starse.kintai.user.profile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.jp.starse.kintai.user.profile.service.ProfileService;

@RequestMapping("${api.base-path-user}")
@RestController
public class ProfileController {
	@Autowired
	ProfileService profileService;
	
	// localhost:8080/api/v1/user/user-profile
	
	@GetMapping("/user-profile")
	public ResponseEntity<Object> example() {
		
		return profileService.getAllUser();
	}
}
