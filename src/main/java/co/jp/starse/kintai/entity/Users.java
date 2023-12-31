package co.jp.starse.kintai.entity;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import co.jp.starse.kintai.dto.UsersDto;
import lombok.Data;

@Data
public class Users {
	private int userId;
	private int kubunDetailId;
	private String userName;
	private String userNameKana;
	private String userNameRyaku;
	private String mail;
	private String password;
	private String userImgPath;
	private int groupId;
	private String role;
	private String birthday;
	private String userKubun;
	private LocalDate nyushaDate;
	private String status;
	private int remainLeave;
	private LocalDate lastGetLeaveDt;
	private LocalDate nextGetLeaveDt;
	private int createdUserId;
	private int updatedUserId;
	private Timestamp createdAt;
	private Timestamp updatedAt;

	public UsersDto toUserDto() {
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		UsersDto userDto = new UsersDto();
		userDto.setUserId(userId);
	    userDto.setUserName(userName);
		userDto.setMail(mail);
		userDto.setPassword(password);
		userDto.setRole(role);
		userDto.setKubunDetailId(kubunDetailId); 
		userDto.setUserNameKana(userNameKana);
		userDto.setUserNameRyaku(userNameRyaku);
		userDto.setUserImgPath(userImgPath);
		userDto.setGroupId(groupId);
		userDto.setBirthday(birthday);
		userDto.setUserKubun(userKubun);
		userDto.setNyushaDate(nyushaDate.format(dateFormatter));
		userDto.setStatus(status);
		userDto.setRemainLeave(remainLeave);
		userDto.setLastGetLeaveDt(lastGetLeaveDt.format(dateFormatter));
		userDto.setNextGetLeaveDt(nextGetLeaveDt.format(dateFormatter));
		userDto.setCreatedUserId(createdUserId);
		userDto.setUpdatedUserId(updatedUserId);
		userDto.setCreatedAt(createdAt);
		userDto.setUpdatedAt(updatedAt);
		return userDto;
	}
}
