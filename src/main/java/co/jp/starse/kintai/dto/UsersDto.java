package co.jp.starse.kintai.dto;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import co.jp.starse.kintai.entity.Users;
import co.jp.starse.kintai.utility.CommonUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UsersDto {
	@JsonProperty("user_id")
	private int userId;
	private int kubunId;
	@JsonProperty("user_name")
	private String userName;
	@JsonProperty("user_name_kana")
	private String userNameKana;
	@JsonProperty("user_name_ryaku")
	private String userNameRyaku;
	private String mail;
	private String password;
	@JsonProperty("user_img_path")
	private String userImgPath;
	@JsonProperty("group_id")
	private int groupId;
	private String role;
	@JsonProperty("shoninsha_kubun")
	private String shoninshaKubun;
	private String birthday;
	@JsonProperty("user_kubun")
	private String userKubun;
	@JsonProperty("nyusha_date")
	private String nyushaDate;
	private String status;
	@JsonProperty("remain_leave")
	private int remainLeave;
	@JsonProperty("last_get_leave_dt")
	private String lastGetLeaveDt;
	@JsonProperty("next_get_leave_dt")
	private String nextGetLeaveDt;
	@JsonProperty("created_user_id")
	private int createdUserId;
	@JsonProperty("updated_user_id")
	private int updatedUserId;
	@JsonProperty("created_at")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
	private Timestamp createdAt;
	@JsonProperty("updated_at")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
	private Timestamp updatedAt;

	public Map<String, Object> validate() {
		Map<String, Object> errors = new LinkedHashMap<String, Object>();

		if (CommonUtils.isEmpty(userName)) {
			errors.put("userName", "お利用者名が必要です。");
		}
		
		if (CommonUtils.isEmpty(userNameKana)) {
			errors.put("userNameKana", "利用者名カナが必要です。");
		} 
		
		if (CommonUtils.isEmpty(nyushaDate)) {
			errors.put("nyushaDate", "おメールが必要です。");
		} 
		if (CommonUtils.isEmpty(password)) {
			errors.put("password", "おパスワードが必要です。");
		} 
		
		if (CommonUtils.isEmpty(birthday)) {
			errors.put("birthday", "お生年月日が必要です。");
			if (CommonUtils.calculateAge(birthday.toString()) < 16) {
				errors.put("birthday", "生年月日は16歳以上が必要です。");
			}
		} 
		
		if (CommonUtils.isEmpty(shoninshaKubun)) {
			errors.put("shoninshaKubun", "お承認者区分が必要です。");
		} 
		
		if (CommonUtils.isEmpty(userKubun)) {
			errors.put("userKubun", "お利用者区分が必要です。");
		} 
		return errors;
	}
	
	public Users toUser() {
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		Users user = new Users();
		user.setUserId(userId);
		user.setUserName(userName);
		user.setMail(mail);
		user.setPassword(password);
		user.setRole(role);
		user.setKubunId(kubunId); 
		user.setUserNameKana(userNameKana);
		user.setUserNameRyaku(userNameRyaku);
		user.setUserImgPath(userImgPath);
		user.setGroupId(groupId);
		user.setShoninshaKubun(shoninshaKubun);
		user.setBirthday(LocalDate.parse(birthday,dateFormatter));
		user.setUserKubun(userKubun);
		user.setNyushaDate(LocalDate.parse(nyushaDate,dateFormatter));
		user.setStatus(status);
		user.setRemainLeave(remainLeave);
		user.setLastGetLeaveDt(LocalDate.parse(lastGetLeaveDt,dateFormatter));
		user.setNextGetLeaveDt(LocalDate.parse(nextGetLeaveDt,dateFormatter));
		user.setCreatedUserId(createdUserId);
		user.setUpdatedUserId(updatedUserId);
		user.setCreatedAt(createdAt);
		user.setUpdatedAt(updatedAt);
		return user;
	}

}
