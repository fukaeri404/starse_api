package co.jp.starse.kintai.admin.kubun.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import co.jp.starse.kintai.admin.kubun.repository.KubunRepository;
import co.jp.starse.kintai.response.ApiResponse;

@Service
public class KubunService {

	@Autowired
	KubunRepository kubunRepository;

	public ResponseEntity<Object> getAllUser() {
		return new ApiResponse(HttpStatus.OK, "アカウントデータ取得は完了しました。", kubunRepository.getAllUser()).response();
	}
}
