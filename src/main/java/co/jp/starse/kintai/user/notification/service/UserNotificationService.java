package co.jp.starse.kintai.user.notification.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import co.jp.starse.kintai.response.ApiResponse;
import co.jp.starse.kintai.user.notification.repository.UserNotificationRepository;

@Service
public class UserNotificationService {
	@Autowired
	UserNotificationRepository userNotificationRepository;
	
	public ResponseEntity<Object> getAllUser() {
		return new ApiResponse(HttpStatus.OK,"アカウントデータ取得は完了しました。",userNotificationRepository.getAllUser()).response();
	}
}
