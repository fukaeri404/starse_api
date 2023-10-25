package co.jp.starse.kintai.user.notification.dto;

import java.sql.Timestamp;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserNotificationDto {
	@JsonProperty("user_name")
	private String userName;
	// kin_mu
	private String riyuu;
	// kinmu_detail
	@JsonProperty("hyojun_kado_jikan")
	private String hyojunKadoJikan;
	// kinmu_shoninsha
	@JsonProperty("shonin_jyokyo")
	private String shoninJyokyo;
	// kyuuo_meisai
	@JsonProperty("taisho_year_month")
	private String taishoYearMonth;
	@JsonProperty("furikomi_bi")
	private LocalDate furikomiBi;
	@JsonProperty("kyuyo_meisaisyo_url")
	private String kyuyoMeisaisyoUrl;
	private String status;
	@JsonProperty("created_user_id")
	private int createdUserId;
	@JsonProperty("updated_user_id")
	private int updatedUserId;
	// kintai_renraku
	@JsonProperty("kintai_renraku_type")
	private int kintaiRenrakuType;
	@JsonProperty("genba_renraku_flag")
	private int genbaRenrakuFlag;
	@JsonProperty("shinsei_date")
	private LocalDate shinseiDate;
	@JsonProperty("created_at")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
	private Timestamp createdAt;
	// kintai_renraku_detail
	private LocalDate date;
	@JsonProperty("kyuka_type")
	private int kyukaType;
	// taityou_fuyou
	@JsonProperty("syojyo_kakuninn_jikan")
	private String syojyoKakuninnJikan;
	@JsonProperty("body_tempature")
	private String bodyTempature;
	@JsonProperty("normal_tempature")
	private String normalTempature;
	private String cough;
	@JsonProperty("noodono_itami")
	private String noodonoItami;
	private String headache;
	@JsonProperty("iki_gurushisa")
	private String ikiGurushisa;
	@JsonProperty("muneno_itami")
	private String munenoItami;
	private String fukutsuu;
	@JsonProperty("senaka_kanetsuno_itami")
	private String senakaKanetsunoItami;
	private String hanadzumari;
	private String outo;
	private String geri;
	private String memai;
	@JsonProperty("pcr_kougen_kensa_jyokyo")
	private String pcrKougenKensaJyokyo;
	@JsonProperty("created_user_id")
	private int taityofuyouCreatedUserId;
	@JsonProperty("updated_user_id")
	private int taityofuyouUpdatedUserId;
}
