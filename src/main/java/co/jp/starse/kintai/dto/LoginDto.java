package co.jp.starse.kintai.dto;

import java.util.LinkedHashMap;
import java.util.Map;

import co.jp.starse.kintai.utility.CommonUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class LoginDto {
	private String login;
	private String password;
	
	public Map<String,Object> validate(){
		Map<String,Object> errors = new LinkedHashMap<String, Object>();
		
		if(CommonUtils.isEmpty(login)) {
			errors.put("login", "login is required");
		}
		
		if(CommonUtils.isEmpty(password)) {
			errors.put("password", "password is required");
		}
		
		return errors;
	}
}
