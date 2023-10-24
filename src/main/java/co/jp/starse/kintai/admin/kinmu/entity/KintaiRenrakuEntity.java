package co.jp.starse.kintai.admin.kinmu.entity;

import java.sql.Timestamp;
import java.time.LocalDate;

import lombok.Data;
@Data
public class KintaiRenrakuEntity {
	private int kintaiRenrakuId;
	private int userID;
	private int taityoufuyouKyukaId;
	private int kintaiRenrakuType;
	private int genbaRenrakuFlag;
	private String reason;
	private LocalDate shinseiDate;
	private int status;
	private int shoninJyokyo;
	private int createdUserId;
	private int updatedUserId;
	private Timestamp createdAt;
	private Timestamp updatedAt;
}
