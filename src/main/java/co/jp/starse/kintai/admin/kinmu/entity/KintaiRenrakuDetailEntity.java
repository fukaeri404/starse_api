package co.jp.starse.kintai.admin.kinmu.entity;

import java.sql.Timestamp;
import java.time.LocalDate;

import lombok.Data;

@Data
public class KintaiRenrakuDetailEntity {
	private int kintaiRenrakuDetailId;
	private int kintaiRenrakuId;
	private LocalDate date;
	private int kyukaType;
	private Timestamp createdAt;
	private Timestamp updatedAt;
}
