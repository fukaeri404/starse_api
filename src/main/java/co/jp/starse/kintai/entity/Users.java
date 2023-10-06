package co.jp.starse.kintai.entity;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import co.jp.starse.kintai.dto.UsersDto;
import lombok.Data;

@Data
public class Users {
	private int userId;
	private int kubunId;
	private String userName;
	private String userNameKana;
	private String userNameRyaku;
	private String mail;
	private String password;
	private String userImgPath;
	private int groupId;
	private String role;
	private String shoninshaKubun;
	private String birthday;
	private String userKubun;
	private String nyushaDate;
	private String status;
	private int remainLeave;
	private String lastGetLeaveDt;
	private String nextGetLeaveDt;
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
		userDto.setKubunId(kubunId); 
		userDto.setUserNameKana(userNameKana);
		userDto.setUserNameRyaku(userNameRyaku);
		userDto.setUserImgPath(userImgPath);
		userDto.setGroupId(groupId);
		userDto.setShoninshaKubun(shoninshaKubun);
		userDto.setBirthday(LocalDate.parse(birthday, dateFormatter));
		userDto.setUserKubun(userKubun);
		userDto.setNyushaDate(LocalDate.parse(nyushaDate, dateFormatter));
		userDto.setStatus(status);
		userDto.setRemainLeave(remainLeave);
		userDto.setLastGetLeaveDt(LocalDate.parse(lastGetLeaveDt, dateFormatter));
		userDto.setNextGetLeaveDt(LocalDate.parse(nextGetLeaveDt, dateFormatter));
		userDto.setCreatedUserId(createdUserId);
		userDto.setUpdatedUserId(updatedUserId);
		userDto.setCreatedAt(createdAt);
		userDto.setUpdatedAt(updatedAt);
		return userDto;
	}
}
