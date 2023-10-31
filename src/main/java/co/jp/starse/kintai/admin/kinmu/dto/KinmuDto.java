package co.jp.starse.kintai.admin.kinmu.dto;

import java.sql.Timestamp;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import co.jp.starse.kintai.admin.kinmu.entity.KinmuBasicEntity;
import co.jp.starse.kintai.utility.CommonUtils;
import co.jp.starse.kintai.utility.StdRequestDto;
import lombok.Data;

@Data
public class KinmuDto implements StdRequestDto {

	@JsonProperty("basic_kinmu_info_id")
	private Long basicKinmuInfoId;
	@JsonProperty("start_time")
	private String startTime;
	@JsonProperty("end_time")
	private String endTime;
	@JsonProperty("kyukei_jikan")
	private String kyukeiJikan;
	@JsonProperty("basic_kinmu_time")
	private String basicKinmuTime;
	@JsonProperty("shoteigai_time")
	private String shoteigaiTime;
	@JsonProperty("created_user_id")
	private Integer createdUserId;
	@JsonProperty("updated_user_id")
	private Integer updatedUserId;
	@JsonProperty("created_at")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
	private Timestamp createdAt;
	@JsonProperty("updated_at")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
	private Timestamp updatedAt;

	@Override
	public Map<String, Object> validate() {
		Map<String, Object> errors = new LinkedHashMap<String, Object>();

		if (CommonUtils.isEmpty(startTime)) {
			errors.put("start_time", "出勤時間が必要です");
		} else if (!isValidTime(startTime)) {
			errors.put("start_time", "出勤時間フォーマットが正しくありません。例（０９：００）");
		}

		if (CommonUtils.isEmpty(endTime)) {
			errors.put("end_time", "退勤時間が必要です");
		} else if (!isValidTime(endTime)) {
			errors.put("end_time", "退勤時間フォーマットが正しくありません。例（０９：００）");
		}

		if (CommonUtils.isEmpty(kyukeiJikan)) {
			errors.put("kyukei_jikan", "休憩時間が必要です");
		}else if (!isValidTime(kyukeiJikan)) {
			errors.put("kyukei_jikan", "休憩時間フォーマットが正しくありません。例（０９：００）");
		}

		if (CommonUtils.isEmpty(basicKinmuTime)) {
			errors.put("basic_kinmuTime", "基本勤務時間が必要です");
		}else if (!isNumeric(basicKinmuTime)) {
			errors.put("basic_kinmuTime", "基本勤務時間1か1.5か2か2.5など入力してください");
		}

		if (CommonUtils.isEmpty(shoteigaiTime)) {
			errors.put("shoteigai_time", "所定外時間が必要です");
		}else if (!isNumeric(shoteigaiTime)) {
			errors.put("shoteigai_time", "所定外時間は1か1.5か2か2.5など入力してください");
		}

		return errors;
	}

	private boolean isValidTime(String input) {
		String pattern = "^(0[0-9]|1[0-9]|2[0-4]):[0-5][0-9]$";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(input);
		return m.matches();
	}

	private boolean isNumeric(String input) {
		String pattern = "^\\d+(\\.\\d+)?$";
		return input.matches(pattern);
	}

	public KinmuBasicEntity toEntity() {
		KinmuBasicEntity kinmuBasic = new KinmuBasicEntity();
		kinmuBasic.setBasicKinmuInfoId(basicKinmuInfoId);
		kinmuBasic.setStartTime(startTime);
		kinmuBasic.setEndTime(endTime);
		kinmuBasic.setKyukeiJikan(kyukeiJikan);
		kinmuBasic.setBasicKinmuTime(Double.parseDouble(basicKinmuTime));
		kinmuBasic.setShoteigaiTime(Double.parseDouble(shoteigaiTime));
		kinmuBasic.setCreatedUserId(createdUserId);
		kinmuBasic.setCreatedAt(createdAt);
		kinmuBasic.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
		return kinmuBasic;
	}

}
