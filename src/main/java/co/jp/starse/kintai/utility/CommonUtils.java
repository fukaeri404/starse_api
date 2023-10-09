package co.jp.starse.kintai.utility;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * 共通機能クラス
 * 
 * @author チョー
 *
 */
public class CommonUtils {

	/**
	 * メールパタンチェック
	 * 
	 * @param email
	 * @return
	 */
	public static boolean isValidEmail(String email) {
		return email.matches(CommonData.MAIL_REGEX_PATTERN);
	}

	/**
	 * 性別パタンチェック アカ追加
	 * 
	 * @param email
	 * @return
	 */
	public static boolean isValidUserStatus(String status) {
		return status.matches(CommonData.USER_STATUS_REGEX_PATTERN);
	}
	
	/**
	 * 性別パタンチェック アカ追加
	 * 
	 * @param email
	 * @return
	 */
	public static boolean isValidGender(String gender) {
		return gender.matches(CommonData.GENDER_REGEX_PATTERN);
	}

	/**
	 * 権限パタンチェック アカ追加
	 * 
	 * @param email
	 * @return
	 */
	public static boolean isValidAuthority(String authority) {
		return authority.matches(CommonData.AUTHORITY_REGEX_PATTERN);
	}

	/**
	 * URLチェック
	 * 
	 * @param url
	 * @return
	 */
	public static boolean isValidUrl(String url) {
		return url.matches(CommonData.URL_REGEX_PATTERN);
	}

	/**
	 * 日付チェック
	 * 
	 * @param date
	 * @return
	 */
	public static boolean isValidDate(String date) {
		try {
			DateFormat df = new SimpleDateFormat(CommonData.DATE_FORMAT_YYYYMMDD_SLASH);
			df.setLenient(false);
			df.parse(date);
			return true;
		} catch (ParseException e) {
			return false;
		}
	}

	/**
	 * 空白チェック
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		if (str == null || CommonData.BLANK.equals(str)) {
			return true;
		}
		return false;
	}
	
	/**
	 * 空白チェック
	 * 
	 * @param date
	 * @return
	 */
	public static boolean isDateEmpty(LocalDate str) {
		if (str == null || CommonData.BLANK.equals(str)) {
			return true;
		}
		return false;
	}

	/**
	 * split
	 * 
	 * @param str
	 * @return
	 */
	public static String[] splitComman(String str) {
		String[] strArray = null;
		if (str != null) {
			strArray = str.split(",");
		}
		return strArray;
	}

	/**
	 * DateからString
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static String convertDateToString(Date date, String format) {
		String str = CommonData.BLANK;
		DateFormat df = new SimpleDateFormat(format);
		str = df.format(date);
		return str;
	}

	/**
	 * StringからDateへ
	 * 
	 * @param date
	 * @param format
	 * @return
	 * @throws ParseException
	 */
	public static Date convertStringToDate(String date, String format) throws ParseException {
		Date result;
		DateFormat df = new SimpleDateFormat(format);
		result = df.parse(date);
		return result;
	}

	/**
	 * YYYYMMDD→YYYY/MM/DD
	 * 
	 * @param date
	 * @return
	 */
	public static String changeDateFormat(String date) {
		String changeDate = CommonData.BLANK;
		DateFormat df1 = new SimpleDateFormat(CommonData.DATE_FORMAT_YYYYMMDD);
		DateFormat df2 = new SimpleDateFormat(CommonData.DATE_FORMAT_YYYYMMDD_SLASH);
		try {
			changeDate = df2.format(df1.parse(date));
		} catch (ParseException e) {
			return changeDate;
		}
		return changeDate;
	}

	/**
	 * YYYY/MM/DD→YYYYMMDD
	 * 
	 * @param date
	 * @return
	 */
	public static String changeDtFromSlashToBlank(String date) {
		String changeDate = CommonData.BLANK;
		if (!CommonUtils.isEmpty(date)) {
			DateFormat df1 = new SimpleDateFormat(CommonData.DATE_FORMAT_YYYYMMDD);
			DateFormat df2 = new SimpleDateFormat(CommonData.DATE_FORMAT_YYYYMMDD_SLASH);
			try {
				changeDate = df1.format(df2.parse(date));
			} catch (ParseException e) {
				return changeDate;
			}
		}
		return changeDate;
	}

	/**
	 * H:mm
	 * 
	 * @param date
	 * @return
	 */
	public static Date convertStringToDateTime(String date) {
		SimpleDateFormat formatter = new SimpleDateFormat(CommonData.TIME_FORMAT2);
		Date resultDate = Calendar.getInstance().getTime();
		try {
			resultDate = formatter.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return resultDate;
	}

	/**
	 * yyyyMMddHHmmss
	 * 
	 * @return
	 */
	public static String getCurrentDateTime() {
		SimpleDateFormat formatter = new SimpleDateFormat(CommonData.DATE_FORMAT_YYYYMMDDHHMMSS);

		Date resultDate = Calendar.getInstance().getTime();
		String dateStr = formatter.format(resultDate);
		return dateStr;

	}

	/**
	 * 年齢計算
	 * 
	 * @param dob
	 * @return
	 */
	public static int calculateAge(String dob) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(CommonData.BIRTHDAY_FORMAT_YYYYMMDD_SLASH);
		LocalDate birthday = LocalDate.parse(dob, formatter);
		LocalDate curDate = LocalDate.now();
		return Period.between(birthday, curDate).getYears();
	}

	/**
	 * 数字チェック
	 * 
	 * @param number
	 * @return
	 */
	public static boolean isNumeric(String number) {
		try {
			Integer.parseInt(number);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 数字変更
	 * 
	 * @param number
	 * @return
	 */
	public static Integer convertToInt(String number) {
		try {
			if (!isEmpty(number))
				return Integer.parseInt(number);
		} catch (Exception e) {
			return null;
		}
		return null;
	}

	/**
	 * 日本の日時
	 */
	public static Date getJPDate() {
		Date date = new Date();
		Date resultDate = null;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		formatter.setTimeZone(TimeZone.getTimeZone("Asia/Tokyo"));
		String tempDate = formatter.format(date);
		try {
			SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
			formatter.setTimeZone(TimeZone.getTimeZone("Asia/Tokyo"));
			resultDate = formatter2.parse(tempDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return resultDate;

	}

	/**
	 * 数字入力確認
	 */
	public static boolean isValidNumber(String number) {

		boolean flag = false;
		if (number == null || CommonData.BLANK.equals(number)) {
			flag = true;
		} else {
			for (int charIndex = 0; charIndex < number.length(); charIndex++) {
				if (number.charAt(charIndex) < '0' || number.charAt(charIndex) > '9') {
					flag = false;
				} else {
					flag = true;
				}
			}
		}
		return flag;
	}

	/**
	 * 数字入力確認 アカ追加
	 */
	public static boolean isValidPhoneNumber(String phoneNumber) {
		return phoneNumber.matches(CommonData.PHONE_REGEX_PATTERN);
	}

	/**
	 * 秒の差分計算
	 * 
	 * @param time1 HH:mm:ss
	 * @param time2 HH:mm:ss
	 * @return
	 */
	public static Long getDifferentSecond(String time1, String time2) {
		Long differentSecond = 0L;
		if (!isEmpty(time1) && !isEmpty(time2)) {
			try {
				String[] timeStr1 = time1.split(":");
				String[] timeStr2 = time2.split(":");
				if (timeStr1.length == 3 && timeStr2.length == 3) {
					Long time1Sec = (Long.parseLong(timeStr1[0]) * 60 * 60) + (Long.parseLong(timeStr1[1]) * 60)
							+ Long.parseLong(timeStr1[2]);
					Long time2Sec = (Long.parseLong(timeStr2[0]) * 60 * 60) + (Long.parseLong(timeStr2[1]) * 60)
							+ Long.parseLong(timeStr2[2]);
					if (time2Sec >= time1Sec) {
						differentSecond = time2Sec - time1Sec;
					}
				}
			} catch (Exception e) {
				return differentSecond;
			}
		}
		return differentSecond;
	}

	/**
	 * 区分値の入力確認
	 */
	public static boolean checkKubunVal(String checkKubunVal) {
		for (int i = 0; i < checkKubunVal.length(); i++) {
			if ((Character.isLetterOrDigit(checkKubunVal.charAt(i)) == false)) {
				return false;
			}
		}
		return true;
	}

}

