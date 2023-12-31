package co.jp.starse.kintai.admin.group.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import co.jp.starse.kintai.admin.group.repository.GroupRepository;
import co.jp.starse.kintai.response.ApiResponse;

@Service
public class GroupService {

	@Autowired
	GroupRepository groupRepository;

	public ResponseEntity<Object> getAllUser() {
		return new ApiResponse(HttpStatus.OK, "アカウントデータ取得は完了しました。", groupRepository.getAllUser()).response();
	}
}
