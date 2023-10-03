package co.jp.starse.kintai.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.jp.starse.kintai.entity.Users;

@CrossOrigin
@RequestMapping("${api.base-path}")
@RestController
public class UserController {

	@PostMapping("/admin/account/registration")
	public Users createUsers() {
		return null;
	}
}
