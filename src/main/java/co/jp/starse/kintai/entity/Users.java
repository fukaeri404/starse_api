package co.jp.starse.kintai.entity;

import java.sql.Timestamp;

import co.jp.starse.kintai.dto.LoginResponseDto;
import lombok.Data;

@Data
public class Users {
	private int userId;
	private int kubunId;
	private String userName;
	private String userNameKana;
	private String userNameRyaku;
	private String email;
	private String password;
	private String userImgPath;
	private int groupId;
	private String yakushoku;
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

	public LoginResponseDto toLoginResponseDto() {
		LoginResponseDto dto = new LoginResponseDto();
		dto.setId(userId);
		dto.setLogin(email);
		dto.setRole(yakushoku);
		return dto;
	}
}
