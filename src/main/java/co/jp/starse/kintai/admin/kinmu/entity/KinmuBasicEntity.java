package co.jp.starse.kintai.admin.kinmu.entity;

import java.sql.Timestamp;


import co.jp.starse.kintai.admin.kinmu.dto.KinmuDto;
import lombok.Data;

@Data
public class KinmuBasicEntity {
	
	private Long basicKinmuInfoId;
	private String startTime;
	private String endTime;
	private String kyukeiJikan;
	private Double basicKinmuTime;
	private Double shoteigaiTime;
	private Integer createdUserId;
	private Integer updatedUserId;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	
	public KinmuDto toDto() {
		KinmuDto dto = new KinmuDto();
		dto.setBasicKinmuInfoId(basicKinmuInfoId);
		dto.setStartTime(startTime);
		dto.setEndTime(endTime);
		dto.setKyukeiJikan(kyukeiJikan);
		dto.setBasicKinmuTime(String.valueOf(basicKinmuTime));
		dto.setShoteigaiTime(String.valueOf(shoteigaiTime));
		dto.setCreatedUserId(createdUserId);
		dto.setCreatedAt(createdAt);
		return dto;
	}
	
	
}
