package co.jp.starse.kintai.user.salary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.jp.starse.kintai.user.salary.service.SalaryService;

@RequestMapping("${api.base-path-user}")
@RestController
public class SalaryController {

	@Autowired
	SalaryService salaryService;
	
	// localhost:8080/api/v1/user/user-salary
	
	@GetMapping("/user-salary")
	public ResponseEntity<Object> example() {
		
		return salaryService.getAllUser();
	}
}
