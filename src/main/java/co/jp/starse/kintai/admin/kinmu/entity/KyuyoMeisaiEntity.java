package co.jp.starse.kintai.admin.kinmu.entity;

import java.sql.Timestamp;
import java.time.LocalDate;

import lombok.Data;

@Data
public class KyuyoMeisaiEntity {
	private int kyuyoMeisaiId;
	private int userId;
	private String taishoYearMonth;
	private LocalDate furikomiBi;
	private String kyuyoMeisaisyoUrl;
	private String status;
	private int createdUserId;
	private int updatedUserId;
	private Timestamp createdAt;
	private Timestamp updatedAt;
}
