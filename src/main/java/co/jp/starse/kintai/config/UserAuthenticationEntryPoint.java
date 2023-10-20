package co.jp.starse.kintai.config;

import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.jp.starse.kintai.common.Messages;
import co.jp.starse.kintai.response.ApiResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class UserAuthenticationEntryPoint implements AuthenticationEntryPoint {

	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

	@SuppressWarnings("deprecation")
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		response.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE);
        String jsonResponse = OBJECT_MAPPER.writeValueAsString( new ApiResponse(Messages.UNAUTHORIZED,HttpStatus.UNAUTHORIZED));
        PrintWriter out = response.getWriter();
        out.print(jsonResponse);
        out.flush();     
		OBJECT_MAPPER.writer();
	}
}
