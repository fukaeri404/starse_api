package co.jp.starse.kintai.admin.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import co.jp.starse.kintai.admin.account.repository.AccountRepository;
import co.jp.starse.kintai.repository.AuthMapper;
import co.jp.starse.kintai.response.ApiResponse;

@Service
public class AccountService {
	
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	AuthMapper auth;
	
	public ResponseEntity<Object> getAllUser() {
		return new ApiResponse(HttpStatus.OK,"アカウントデータ取得は完了しました。",accountRepository.getAllUser()).response();
	}
}
