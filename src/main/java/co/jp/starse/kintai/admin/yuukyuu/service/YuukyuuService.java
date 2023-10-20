package co.jp.starse.kintai.admin.yuukyuu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import co.jp.starse.kintai.admin.yuukyuu.repository.YuukyuuRepository;
import co.jp.starse.kintai.response.ApiResponse;

@Service
public class YuukyuuService {
	
	@Autowired
	YuukyuuRepository yuukyuuRepository;
	
	public ResponseEntity<Object> getAllUser() {
		return new ApiResponse(HttpStatus.OK,"アカウントデータ取得は完了しました。",yuukyuuRepository.getAllUser()).response();
	}

}
