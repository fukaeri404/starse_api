package co.jp.starse.kintai.utility;

import java.util.Map;

/**
 * 共有データ
 * 
 * @author チョー
 *
 */
public class CommonData {

	public static final String PHONE_REGEX_PATTERN = "\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}";

	public static final String GENDER_REGEX_PATTERN = "[123]";

	public static final String AUTHORITY_REGEX_PATTERN = "[1234]";
	
	public static final String USER_STATUS_REGEX_PATTERN = "[12]";

	public static final String COMPANY_NM = "STAR SE(株)";

	public static final String BLANK = "";

	public static final String MAIL_REGEX_PATTERN = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

	public static final String URL_REGEX_PATTERN = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";

	public static final String PASSWORD_CHAR_PATTERN = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

	public static final String DATE_FORMAT_YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

	public static final String DATE_FORMAT_YYYYMMDD = "yyyyMMdd";

	public static final String DATE_FORMAT_YYYYMM = "yyyyMM";

	public static final String DATE_FORMAT_YYYYMMDD_SLASH = "yyyy/MM/dd";

	public static final String BIRTHDAY_FORMAT_YYYYMMDD_SLASH = "yyyy/MM/dd";

	public static final String PERIOD_YYYYMM_SLASH = "yyyy/MM";

	public static final String DATE_FORMAT_YYYYMM_SLASH = "yyyy/MM";

	public static final String DATE_FORMAT_YYYYMM_NIHON = "yyyy年MM月";

	public static final String TIME_FORMAT = "yyyy/MM/dd H:mm:ss";

	public static final String TIME_FORMAT2 = "H:mm";

	public static final String TIME_FORMAT3 = "HH:mm:ss";

	public static final String STR_ZERO = "0";

	public static final String STR_ONE = "1";

	public static final String STR_TWO = "2";

	public static final String STR_THREE = "3";

	public static final String STR_FOUR = "4";

	public static final String CONTRACT_YES = "有";

	public static final String CONTRACT_NO = "無";

	public static final String HYPHEN = "-";

	public static final String SLASH = "/";

	public static final String MARU = "◎";

	public static final String BATSU = "×";

	public static final String KADOU = "稼働中";

	public static final String EGYOU = "営業中";

	/** 権限区分 */
	public static final String KENGEN = "KENGEN";

	/** 分野区分 */
	public static final String KAIBUNYA = "KAIBUNYA";

	/** 役割区分 */
	public static final String YAKUWARI = "YAKUWARI";

	/** 稼働ステータス区分 */
	public static final String KADOSTS = "KADOSTS";

	/** 業務分野区分 */
	public static final String GYOMUBY = "GYOMUBY";

	/** 日本語力区分 */
	public static final String NIHONGOLVL = "NIHONGOLVL";

	/** 評価区分 */
	public static final String HYOKA = "HYOKA";

	/** 性別 */
	public static final String GENDER = "GENDER";

	/** 確認ステータス */
	public static final String COMSTATUS = "COMSTATUS";

	/** カレンシー */
	public static final String CURRENCY = "CURRENCY";

	public static final String NAME = "NAME";

	/** システム向け */
	public static final String SYSMUKEI = "SYSMUKEI";

	/** ドキュメント */
	public static final String DOCUMENT = "DOCUMENT";

	/** 日本語能力 */
	public static final String NIHONGOSKL = "NIHONGOSKL";

	/** 在職ステータス */
	public static final String ZAISHOKU = "ZAISHOKU";

	/** スキル種類 */
	public static final String SKILLSRI = "SKILLSRI";

	/** 進捗 */
	public static final String PROGRESS = "PROGRESS";

	// ----------------------------------------- スキル
	// --------------------------------------
	/** スキル:開発言語 */
	public static final String SKILL_DEV_VAL = "1";
	public static final String SKILL_DEV_TXT = "開発言語";
	/** スキル：OS */
	public static final String SKILL_OS_VAL = "2";
	public static final String SKILL_OS_TXT = "OS";
	/** スキル：DB */
	public static final String SKILL_DB_VAL = "3";
	public static final String SKILL_DB_TXT = "DB";
	/** スキル：ツール */
	public static final String SKILL_TOOL_VAL = "4";
	public static final String SKILL_TOOL_TXT = "ツール";
	/** スキル：フレームワーク */
	public static final String SKILL_FRAME_VAL = "5";
	public static final String SKILL_FRAME_TXT = "フレームワーク";
	/** スキル：対応フェーズ */
	public static final String SKILL_FACE_VAL = "6";
	public static final String SKILL_FACE_TXT = "対応フェーズ";
	/** スキル：フレームワーク */
	public static final String SKILL_APP_VAL = "7";
	public static final String SKILL_APP_TXT = "アプリ";
	// ----------------------------------------- スキル
	// --------------------------------------

	// ----------------------------------------- スキル種類
	// --------------------------------------
	/** スキル種類:フロント側 */
	public static final String SKILLSRI_FRONT_VAL = "1";
	public static final String SKILLSRI_FRONT_TXT = "フロント側";
	/** スキル種類:バックエンド側 */
	public static final String SKILLSRI_BACK_VAL = "2";
	public static final String SKILLSRI_BACK_TXT = "バックエンド側";
	// ----------------------------------------- スキル種類
	// --------------------------------------

	/** 国籍区分 */
	public static final String COUNTRY = "COUNTRY";

	/** 可否 > 可 */
	public static final String KAHI_KA = "可";

	/** 可否 > 否 */
	public static final String KAHI_HI = "否";

	/** ステータス > 有効 */
	public static final String STATUS_OK = "有効";

	/** ステータス > 無効 */
	public static final String STATUS_NG = "無効";

	/** 全て */
	public static final String ALL = "全て";

	/** 初期パスワード */
	public static final String PWD = "$2a$12$knH1EdtbqrP9sL8T.Xk7bukv3pF.T3q.BdtbTIqcIXqHVqPdU.qoC";

	/** 権限区分：システム管理者 */
	public static final String KENGEN_KANRI = "1";

	/** 権限区分：営業管理者 */
	public static final String KENGEN_EIGYOUKANRI = "2";

	/** 権限区分：営業担当者 */
	public static final String KENGEN_EIGYOUTANTO = "3";

	/** 権限区分：お客様 */
	public static final String KENGEN_CUST = "4";

	/** 権限区分：社員 */
	public static final String KENGEN_EMP = "5";

	/** モード：登録 */
	public static final String MODE_INSERT = "1";

	/** モード：更新 */
	public static final String MODE_UPDATE = "2";

	/** モード：詳細 */
	public static final String MODE_DETAIL = "3";

	/** 件名 */
	public static final String MAIL_PWD_SET_SUBJECT = "MAIL_PWD_SET_SUBJECT";

	/** 本本 */
	public static final String MAIL_PWD_SET_BODY = "MAIL_PWD_SET_BODY";

	/** ステータス > 有効 */
	public static final String PUB_OK = "〇";

	/** ステータス > 無効 */
	public static final String PUB_NG = "X";

	// ----------------------------------------- 開発期間
	// --------------------------------------

	/** 年 */
	public static final String YR = "年";

	/** ヶ月 */
	public static final String MONTHS = "ヶ月";

	// ----------------------------------------- 作業内容
	// --------------------------------------

	/** 要件定義 */
	public static final String REQ_DEF = "要件定義";

	/** 基本設計 */
	public static final String BS_DS = "基本設計";

	/** 詳細設計 */
	public static final String DT_DS = "詳細設計";

	/** 製造 */
	public static final String PRD = "製造";

	/** 単体試験 */
	public static final String UT = "単体試験";

	/** 結合試験 */
	public static final String IT = "結合試験";

	/** 総合試験 */
	public static final String CT = "総合試験";

	/** 保守運用 */
	public static final String MT_OPR = "保守運用";

	// ----------------------------------------- メニュー
	// --------------------------------------

	/** お客様アカウント */
	public static final String MENU_ACC_CUSTOMER = "MENU_ACC_CUSTOMER";

	/** 社員 */
	public static final String MENU_ACC_EMPLOYEE = "MENU_ACC_EMPLOYEE";

	/** 営業 */
	public static final String MENU_ACC_EIGYOU = "MENU_ACC_EIGYOU";

	/** 営業中一覧 */
	public static final String MENU_EIG_EIGYOU = "MENU_EIG_EIGYOU";

	/** 要員紹介 */
	public static final String MENU_EIG_INTRO = "MENU_EIG_INTRO";

	/** いいね */
	public static final String MENU_EIG_GOOD = "MENU_EIG_GOOD";

	/** アクセスログ */
	public static final String MENU_EIG_LOG = "MENU_EIG_LOG";

	/** メールテンプレート */
	public static final String MENU_SETTING_MASTER_MAIL = "MENU_SETTING_MASTER_MAIL";

	/** cc メール */
	public static final String MENU_SETTING_MASTER_CCMAIL = "MENU_SETTING_MASTER_CCMAIL";

	/** スキルマスタ */
	public static final String MENU_SETTING_SKILL = "MENU_SETTING_SKILL";

	/** 履歴書テンプレート */
	public static final String MENU_SETTING_MASTER_CV = "MENU_SETTING_MASTER_CV";

	/** 権限 */
	public static final String MENU_SETTING_KENGEN = "MENU_SETTING_KENGEN";

	/** 会社情報 */
	public static final String MENU_SETTING_MASTER_COMPANY = "MENU_SETTING_MASTER_COMPANY";

	/** 区分 */
	public static final String MENU_SETTING_MASTER_KUBUN = "MENU_SETTING_MASTER_KUBUN";

	/** パスワード変更 */
	public static final String MENU_SETTING_PWDCHANGE = "MENU_SETTING_PWDCHANGE";

	/** 区分名 */
	public static final Map<String, String> KUBUN_NAMES = Map.of("1", "PG", "2", "SE", "3", "PL", "4", "PM");

	/** 稼働可能 */
	public static final String WORK_AVAI_1 = "即日～";
	public static final String WORK_AVAI_2 = "翌月の1日〜";

	/** 所属 */
	public static final String SHOZOKU_1 = "弊社社員";
	public static final String SHOZOKU_2 = "パートナ社員";

	// ----------------------------------------- メールテンプレート
	// --------------------------------------
	/** お客様系 */
	/** 会社名 */
	public static final String C1 = "@@C1@@";

	/** 担当者名 */
	public static final String C2 = "@@C2@@";

	/** 営業系 */
	/** 営業名 */
	public static final String E1 = "@@E1@@";

	/** 社員系 */
	/** 氏名 */
	public static final String EM1 = "@@EM1@@";

	/** 国籍 */
	public static final String EM2 = "@@EM2@@";

	/** 性別 */
	public static final String EM3 = "@@EM3@@";

	/** 年齢 */
	public static final String EM4 = "@@EM4@@";

	/** 所属 */
	public static final String EM5 = "@@EM5@@";

	/** 業務開始 */
	public static final String EM6 = "@@EM6@@";

	/** 実務経験 */
	public static final String EM7 = "@@EM7@@";

	/** 稼働可能 */
	public static final String EM8 = "@@EM8@@";

	/** スキル */
	public static final String EM9 = "@@EM9@@";

	/** 日本語 */
	public static final String EM10 = "@@EM10@@";

	/** 来日日期 */
	public static final String EM11 = "@@EM11@@";

	/** 最寄駅 */
	public static final String EM12 = "@@EM12@@";

	/** 単金 */
	public static final String EM13 = "@@EM13@@";

	/** 人物像 */
	public static final String EM14 = "@@EM14@@";

	/** アピールポイント */
	public static final String EM15 = "@@EM15@@";

	// ----------------------------------------- ログタイプ
	// --------------------------------------
	/** 紹介動画 */
	public static final String LOG_TYPE_10 = "10";
	public static final String LOG_TYPE_10_NM = "紹介動画";

	/** PDF */
	public static final String LOG_TYPE_20 = "20";
	public static final String LOG_TYPE_20_NM = "PDFダウロード";

	/** 社員情報 */
	public static final String LOG_TYPE_30 = "30";
	public static final String LOG_TYPE_30_NM = "社員情報";

	/** スキル */
	public static final String LOG_TYPE_40 = "40";
	public static final String LOG_TYPE_40_NM = "スキル";

	/** 業務経歴 */
	public static final String LOG_TYPE_50 = "50";
	public static final String LOG_TYPE_50_NM = "業務経歴書";

	// ----------------------------------------- 時、分、秒
	// --------------------------------------
	public static final String TIME_HOUR = "時";
	public static final String TIME_MINUTE = "分";
	public static final String TIME_SECOND = "秒";

	public static final String FULL_COLUMN = ":";

}
