package co.jp.starse.kintai.user.salary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import co.jp.starse.kintai.response.ApiResponse;
import co.jp.starse.kintai.user.salary.repository.UserSalaryRepository;

@Service
public class SalaryService {
	
	@Autowired
	UserSalaryRepository userSalaryRepository;
	
	public ResponseEntity<Object> getAllUser() {
		return new ApiResponse(HttpStatus.OK,"アカウントデータ取得は完了しました。",userSalaryRepository.getAllUser()).response();
	}
}
