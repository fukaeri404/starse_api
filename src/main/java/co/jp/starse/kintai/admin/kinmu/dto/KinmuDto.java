package co.jp.starse.kintai.admin.kinmu.dto;

import java.sql.Timestamp;
import java.util.LinkedHashMap;
import java.util.Map;

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
	private Timestamp createdAt;
	@JsonProperty("updated_at")
	private Timestamp updatedAt;
	
	@Override
	public Map<String, Object> validate() {
		Map<String, Object> errors = new LinkedHashMap<String, Object>();

		if (CommonUtils.isEmpty(startTime)) {
			errors.put("startTime", "出勤時間が必要です");
		}
		
		if (CommonUtils.isEmpty(endTime)) {
			errors.put("endTime", "退勤時間が必要です");
		}
		
		if (CommonUtils.isEmpty(kyukeiJikan)) {
			errors.put("kyukeiJikan", "休憩時間が必要です");
		}
		
		if (CommonUtils.isEmpty(basicKinmuTime)) {
			errors.put("basicKinmuTime", "基本勤務時間が必要です");
		}
		
		if (CommonUtils.isEmpty(shoteigaiTime)) {
			errors.put("shoteigaiTime", "所定外時間が必要です");
		}

		return errors;
	}
	
	public KinmuBasicEntity toEntity() {
		KinmuBasicEntity kinmuBasic = new KinmuBasicEntity();
		kinmuBasic.setBasicKinmuInfoId(basicKinmuInfoId);
		kinmuBasic.setStartTime(startTime);
		kinmuBasic.setEndTime(endTime);
		kinmuBasic.setKyukeiJikan(kyukeiJikan);
		kinmuBasic.setBasicKinmuTime(Integer.parseInt(basicKinmuTime));
		kinmuBasic.setShoteigaiTime(Integer.parseInt(shoteigaiTime));
		kinmuBasic.setCreatedUserId(createdUserId);
		kinmuBasic.setUpdatedUserId(updatedUserId);
		kinmuBasic.setCreatedAt(createdAt);
		kinmuBasic.setUpdatedAt(updatedAt);
		return kinmuBasic;
	}

}
