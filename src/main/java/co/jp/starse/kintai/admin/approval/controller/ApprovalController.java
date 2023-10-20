package co.jp.starse.kintai.admin.approval.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.jp.starse.kintai.admin.approval.service.ApprovalService;

@RequestMapping("${api.base-path-admin}")
@RestController
public class ApprovalController {

	@Autowired
	ApprovalService approvalService;
	
	// API CALL : localhost:8080/api/v1/admin/admin-approval
	
	@GetMapping("/admin-approval")
	public ResponseEntity<Object> example() {
		
		return approvalService.getAllUser();
	}
}
