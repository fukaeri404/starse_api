package co.jp.starse.kintai.user.notification.entity;

import java.sql.Timestamp;
import java.time.LocalDate;

import lombok.Data;

@Data
public class UserNotificationEntity {
	private String userName;
	// kin_mu
	private String riyuu;
	// kinmu_detail
	private String hyojunKadoJikan;
	// kinmu_shoninsha
	private String shoninJyokyo;
	// kyuuo_meisai
	private String taishoYearMonth;
	private LocalDate furikomiBi;
	private String kyuyoMeisaisyoUrl;
	private String status;
	private int createdUserId;
	private int updatedUserId;
	// kintai_renraku
	private int kintaiRenrakuType;
	private int genbaRenrakuFlag;
	private LocalDate shinseiDate;
	private Timestamp createdAt;
	// kintai_renraku_detail
	private LocalDate date;
	private int kyukaType;
	// taityou_fuyou
	private String syojyoKakuninnJikan;
	private String bodyTempature;
	private String normalTempature;
	private String cough;
	private String noodonoItami;
	private String headache;
	private String ikiGurushisa;
	private String munenoItami;
	private String fukutsuu;
	private String senakaKanetsunoItami;
	private String hanadzumari;
	private String outo;
	private String geri;
	private String memai;
	private String pcrKougenKensaJyokyo;
	private int taityofuyouCreatedUserId;
	private int taityofuyouUpdatedUserId;
}
