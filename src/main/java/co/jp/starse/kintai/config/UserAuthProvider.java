package co.jp.starse.kintai.config;

import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

import co.jp.starse.kintai.dto.UsersDto;
import co.jp.starse.kintai.service.UserService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class UserAuthProvider {
	@Value("${security.jwt.token.secret-key}")
	private String secretKey;

	@Autowired
	UserService userService;

	/**
	 * キーを強くなるための エンコードする コンストラクタ
	 */
	@PostConstruct
	protected void init() {
		secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
	}

	/**
	 * デフォルトタイムアウトで Token 作成機能
	 * 
	 * @param issuer メール
	 * @return
	 */
	public String createToken(String issuer) {
		// default timeout on hour
		return this.createToken(issuer, 3600000);
	}

	/**
	 * タイムアウト ある Token 作成機能
	 * 
	 * @param issuer  メール
	 * @param timeOut ミリー秒
	 * @return
	 */
	public String createToken(String issuer, long timeOut) {
		Date now = new Date();
		Date validity = new Date(now.getTime() + timeOut);

		return JWT.create().withIssuer(issuer).withIssuedAt(now).withExpiresAt(validity)
				.sign(Algorithm.HMAC256(secretKey));
	}

	/**
	 * Token確認機能
	 * 
	 * @param token リクエストヘッダーから送った Token
	 * @return
	 */
	public Authentication validateToken(String token) {
		JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secretKey)).build();
		DecodedJWT decoded = verifier.verify(token);
		UsersDto user = userService.findByEmail(decoded.getIssuer()).toUserDto();
		// roles
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(user.getAuthority()));
		return new UsernamePasswordAuthenticationToken(user, null, authorities);
	}

	/**
	 * パスワード忘れ確認機能
	 * 
	 * @param token、 メートから送ったURLの中に運ぶToken
	 */
	public void passwordResetFromUrl(String token) {
		JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secretKey)).build();
		DecodedJWT decoded = verifier.verify(token);
		String email = decoded.getIssuer().split("<<~>>")[0];
		String password = decoded.getIssuer().split("<<~>>")[1];
		UsersDto user = userService.findByEmail(email).toUserDto();
		if (user != null) {
			// ここから ユーサのパスワードを リセットする
			//
		}
	}
}
