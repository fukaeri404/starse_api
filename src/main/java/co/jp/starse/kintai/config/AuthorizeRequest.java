package co.jp.starse.kintai.config;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;

public class AuthorizeRequest {

	static void configureAuthorizeRequests(
			AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry request) {
		request.requestMatchers(HttpMethod.POST, Routes.LOGIN).permitAll()
				.requestMatchers(HttpMethod.POST, Routes.FORGOT_PASSWORD,Routes.CHANGE_PASSWORD).hasAnyAuthority("1","2","3","4","5","6","7","8")
				.requestMatchers(HttpMethod.GET, Routes.RESET_PASSWORD).hasAnyAuthority("1","2","3","4","5","6","7","8");
				
	}
}