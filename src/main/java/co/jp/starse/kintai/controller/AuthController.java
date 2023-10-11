package co.jp.starse.kintai.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.jp.starse.kintai.config.UserAuthProvider;
import co.jp.starse.kintai.dto.LoginDto;
import co.jp.starse.kintai.dto.PwdChangeDto;
import co.jp.starse.kintai.dto.UsersDto;
import co.jp.starse.kintai.service.AuthService;
import co.jp.starse.kintai.service.UserService;

@CrossOrigin
@RequestMapping("${api.base-path}")
@RestController
public class AuthController {

	@Autowired
	UserAuthProvider userAuthProvider;

	@Autowired
	AuthService loginService;

	@Autowired
	UserService userService;

	@Autowired
	PasswordEncoder passwordEncoder;
    
	//Register
	@PostMapping("/admin/users")
	public ResponseEntity<Object> register(@RequestParam("user_name") String userName,
			@RequestParam("user_name_kana") String userNameKana, @RequestParam("user_name_ryaku") String userNameRyaKu,
			@RequestParam("group_id") int groupId,
			@RequestParam("role") String role, @RequestParam("mail") String mail,
			@RequestParam("password") String password, @RequestParam("user_image_path") String userImgPath,
			@RequestParam("birthday") String birthday, @RequestParam("shoninsha_kubun") String shoninshaKubun,
			@RequestParam("user_kubun") String userKubun, @RequestParam("last_get_leave_dt") String lastGetLeaveDt,
			@RequestParam("next_get_leave_dt") String nextGetLeaveDt, @RequestParam("nyusha_date") String nyushaDate,
			@RequestParam("status") String status, @RequestParam("created_user_id") int createdUserId,
			@RequestParam("updated_user_id") int updatedUserId) {
		UsersDto dto = new UsersDto();
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		dto.setUserName(userName);
		dto.setUserNameKana(userNameKana);
		dto.setUserNameRyaku(userNameRyaKu);
		dto.setRole(role);
		dto.setGroupId(groupId);
		dto.setMail(mail);
		dto.setPassword(password);
		dto.setUserImgPath(userImgPath);
		dto.setBirthday(LocalDate.parse(birthday, dateFormatter));
		dto.setShoninshaKubun(shoninshaKubun);
		dto.setUserKubun(userKubun);
		dto.setLastGetLeaveDt(LocalDate.parse(lastGetLeaveDt, dateFormatter));
		dto.setNextGetLeaveDt(LocalDate.parse(nextGetLeaveDt, dateFormatter));
		dto.setNyushaDate(LocalDate.parse(nyushaDate, dateFormatter));
		dto.setStatus(status);
		dto.setCreatedUserId(createdUserId);
		dto.setUpdatedUserId(updatedUserId);
		return loginService.register(dto);
	}

	@PostMapping("/login")
	public ResponseEntity<Object> login(@RequestBody LoginDto dto) {
		return loginService.login(dto);
	}

	@PostMapping("/change-password")
	public ResponseEntity<Object> pwdChange(@RequestBody PwdChangeDto pwdChangeDto) {
		return loginService.pwdChange(pwdChangeDto);
	}

	@PostMapping("/forget-password")
	public ResponseEntity<Object> forgetPassword(@RequestBody LoginDto dto) {
		String token = userAuthProvider.createToken(dto.getEmail() + "<<~>>" + dto.getPassword());
		String link = "http://localhost:8080/api/v1/confirm-password-reset/" + token;
		return new ResponseEntity<Object>(link, HttpStatus.OK);
	}

	@GetMapping("/confirm-password-reset/{token}")
	public ResponseEntity<Object> confirmPassword(@PathVariable("token") String token) {
		userAuthProvider.passwordResetFromUrl(token);
		return new ResponseEntity<Object>("successiful password change", HttpStatus.OK);
	}
}
