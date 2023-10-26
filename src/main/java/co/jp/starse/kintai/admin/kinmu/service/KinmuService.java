package co.jp.starse.kintai.admin.kinmu.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import co.jp.starse.kintai.admin.kinmu.dto.KinmuDto;
import co.jp.starse.kintai.admin.kinmu.repository.KinmuRepository;
import co.jp.starse.kintai.common.Messages;
import co.jp.starse.kintai.config.UserAuthProvider;
import co.jp.starse.kintai.config.UserAuthProvider.AuthUser;
import co.jp.starse.kintai.response.ApiErrorResponse;
import co.jp.starse.kintai.response.ApiResponse;

@Service
public class KinmuService {

	@Autowired
	KinmuRepository kinmuRepository;
	
	@Autowired
	UserAuthProvider userAuthProvider;

	public ResponseEntity<Object> getAllUser() {
		return new ApiResponse(HttpStatus.OK, "アカウントデータ取得は完了しました。", kinmuRepository.getAllUser()).response();
	}
	
	public ResponseEntity<Object> register(KinmuDto dto, Authentication auth){
		Map<String, Object> errors = dto.validate();
		AuthUser authUser = userAuthProvider.getAuthUser(auth);
		
		if(errors.size()>0) {
			System.out.println(errors.size());
			return new ApiErrorResponse(errors, HttpStatus.BAD_REQUEST, Messages.REGISTER_FAIL).response();
		}
		
		kinmuRepository.register(dto.toEntity(authUser));
		
		return new ApiResponse(HttpStatus.CREATED, Messages.REGISTER_SUCCESS).response();
	}
}
