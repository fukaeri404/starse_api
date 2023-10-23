package co.jp.starse.kintai.admin.kinmu.entity;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class KinmuShoninshaEntity {
	private int kinmuhyoShoninshaId;
	private int kinmuhyoId;
	private int shoninUserId;
	private String shoninJyokyo;
	private String henkyakuRiyuu;
	private Timestamp createdAt;
	private Timestamp updatedAt;
}
