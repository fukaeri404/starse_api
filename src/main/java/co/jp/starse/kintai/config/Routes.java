package co.jp.starse.kintai.config;

public class Routes {

	// 共通
	static String LOGIN = "api/v1/login";
	static String FORGOT_PASSWORD = "api/v1/forget-password";
	static String PUBLIC = "api/v1/pub/**";

	// システム管理者 1 
	static String Admin = "api/v1/admin/**";
	static String REGISTER = "api/v1/admin/register";

	// グループ主任 2 
	static String Shoninsha = "api/v1/shonin_sha/**";


	// 一般社員３
	static String User = "api/v1/user/**";

	// システム管理者1, 運用管理者２, 一般社員３
	static String RESET_PASSWORD = "api/v1/confirm-password-reset";

	// システム管理者1, 運用管理者２, 一般社員３, お客様4
	static String CHANGE_PASSWORD = "api/v1/change-password";
}
