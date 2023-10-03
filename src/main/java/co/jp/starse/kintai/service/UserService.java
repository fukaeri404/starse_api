package co.jp.starse.kintai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.jp.starse.kintai.entity.Users;
import co.jp.starse.kintai.repository.AuthRepository;

@Service
public class UserService {

	@Autowired
	AuthRepository authRepository;
	
	public Users findByEmail(String mail) {
		return authRepository.findByEmail(mail);	
	}
}