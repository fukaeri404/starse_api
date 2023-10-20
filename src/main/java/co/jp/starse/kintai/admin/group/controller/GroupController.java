package co.jp.starse.kintai.admin.group.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.jp.starse.kintai.admin.group.service.GroupService;

@RequestMapping("${api.base-path-admin}")
@RestController
public class GroupController {

	@Autowired
	GroupService groupService;

	@GetMapping("/admin-group")
	public ResponseEntity<Object> example() {

		return groupService.getAllUser();
	}
}
