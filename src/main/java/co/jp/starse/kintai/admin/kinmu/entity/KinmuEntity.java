package co.jp.starse.kintai.admin.kinmu.entity;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class KinmuEntity {
	private int kinmuhyoID;
	private String taisho_year_month;
	private int kubun_id;
	private int user_id;
	private int status;
	private int genbaKadoBi;
	private String riyuu;
	private int createdUserId;
	private int updatedUserId;
	private Timestamp createdAt;
	private Timestamp updatedAt;
}
