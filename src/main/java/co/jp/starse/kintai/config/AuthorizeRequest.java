package co.jp.starse.kintai.config;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;

public class AuthorizeRequest {

	static void configureAuthorizeRequests(
			AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry request) {
		request.requestMatchers(HttpMethod.POST, Routes.LOGIN).permitAll()
		        .requestMatchers(HttpMethod.POST, Routes.REGISTER).hasAnyAuthority("1","2")
				.requestMatchers(Routes.User, Routes.CHANGE_PASSWORD).hasAnyAuthority("1", "2", "3")
				.requestMatchers(Routes.PUBLIC, Routes.FORGOT_PASSWORD).permitAll()
				.requestMatchers(Routes.RESET_PASSWORD).hasAnyAuthority("1", "2", "3");
	}
}