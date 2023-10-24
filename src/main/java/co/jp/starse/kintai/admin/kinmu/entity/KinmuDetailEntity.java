package co.jp.starse.kintai.admin.kinmu.entity;

import java.sql.Timestamp;
import java.time.LocalDate;

import lombok.Data;

@Data
public class KinmuDetailEntity {
		private int kinmuhyoDetailID;
		private int kinmuhyoId;
		private int kintaiRenrakuId;
		private LocalDate date;
		private String hyojunKadoJikan;
		private String kinmuJyokyo;
		private String startTime;
		private String endTime;
		private String kyukeiTime;
		private String shoteigaiJikan;
		private int kadoJikan;
		private int zangyouJikan;
		private String biko;	
		private int createdUserId;
		private int updatedUserId;
		private Timestamp createdAt;
		private Timestamp updatedAt;
}
