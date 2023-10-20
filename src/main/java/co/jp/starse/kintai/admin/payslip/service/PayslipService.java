package co.jp.starse.kintai.admin.payslip.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import co.jp.starse.kintai.admin.payslip.repository.PayslipRepository;
import co.jp.starse.kintai.response.ApiResponse;

@Service
public class PayslipService {
	
	@Autowired
	PayslipRepository payslipRepository;
	
	public ResponseEntity<Object> getAllUser() {
		return new ApiResponse(HttpStatus.OK,"アカウントデータ取得は完了しました。",payslipRepository.getAllUser()).response();
	}

}
