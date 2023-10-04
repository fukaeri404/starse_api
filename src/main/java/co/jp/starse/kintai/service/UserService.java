package co.jp.starse.kintai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.jp.starse.kintai.entity.Users;
import co.jp.starse.kintai.repository.AuthMapper;

@Service
public class UserService {

	@Autowired
	AuthMapper authRepository;
	
	public Users findByEmail(String mail) {
		return authRepository.findByEmail(mail);	
	}
	
	public void changePassword(Users user) {
		authRepository.changePassword(user.getPassword(), user.getMail());
	}
}