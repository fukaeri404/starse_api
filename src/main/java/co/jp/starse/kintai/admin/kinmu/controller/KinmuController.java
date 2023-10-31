package co.jp.starse.kintai.admin.kinmu.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.jp.starse.kintai.admin.kinmu.dto.CalendarDto;
import co.jp.starse.kintai.admin.kinmu.dto.KinmuDto;
import co.jp.starse.kintai.admin.kinmu.service.KinmuService;

@RequestMapping("${api.base-path-admin}")
@RestController
public class KinmuController {

	@Autowired
	KinmuService kinmuService;

	// API CALL : localhost:8080/api/v1/admin/admin-kinmu

	@GetMapping("/admin-kinmu")
	public ResponseEntity<Object> example() {
		return kinmuService.getAllUser();
	}
	
	// API CALL : localhost:8080/api/v1/admin/kinmuhyo
	
	@PostMapping("/kinmuhyo")
	public ResponseEntity<Object> register(@RequestBody KinmuDto kinmuDto, Authentication auth){
//		System.out.println(">>>>>>>>>"+kinmuDto);
		return kinmuService.register(kinmuDto, auth);
	}
	
	// API CALL : localhost:8080/api/v1/admin/kinmuhyo/calendar
	
	@PostMapping("/kinmuhyo/calendar")
	public ResponseEntity<Object> registerCalendar(@RequestBody CalendarDto calendarDto){
		return kinmuService.registerCalendar(calendarDto);
	}
	
}
