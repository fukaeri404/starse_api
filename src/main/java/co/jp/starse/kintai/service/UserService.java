package co.jp.starse.kintai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.jp.starse.kintai.repository.UsersRepository;

@Service
public class UserService {

	@Autowired
	UsersRepository userRepository;
}
