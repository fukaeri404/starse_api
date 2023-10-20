package co.jp.starse.kintai.user.profile.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import co.jp.starse.kintai.response.ApiResponse;
import co.jp.starse.kintai.user.profile.repository.UserProfileRepository;

@Service
public class ProfileService {
	@Autowired
	UserProfileRepository userProfileRepository;
	
	public ResponseEntity<Object> getAllUser() {
		return new ApiResponse(HttpStatus.OK,"アカウントデータ取得は完了しました。",userProfileRepository.getAllUser()).response();
	}
}
