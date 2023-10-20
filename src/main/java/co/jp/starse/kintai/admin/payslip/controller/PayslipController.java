package co.jp.starse.kintai.admin.payslip.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.jp.starse.kintai.admin.payslip.service.PayslipService;

@RequestMapping("${api.base-path-admin}")
@RestController
public class PayslipController {

	@Autowired
	PayslipService payslipService;

	@GetMapping("/admin-payslip")
	public ResponseEntity<Object> example() {

		return payslipService.getAllUser();
	}

}
