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
	private String email;
	private String password;
	
	public Map<String,Object> validate(){
		Map<String,Object> errors = new LinkedHashMap<String, Object>();
		
		if(CommonUtils.isEmpty(email)) {
			errors.put("email", "メールアドレスが必要です。");
		}else if (!CommonUtils.isValidEmail(email)) {
			errors.put("email", "メールアドレスのフォーマットが間違っています。");
		}
		
		if(CommonUtils.isEmpty(password)) {
			errors.put("password", "パスワードが必要です。");
		}
		
		return errors;
	}
}
