package co.jp.starse.kintai.admin.kinmu.entity;

import java.sql.Timestamp; 

import lombok.Data;
@Data
public class TaityofuyoEntity {
	private int taityoufuyouID;
	private Timestamp syojyoKakuninnJikan;
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
	private String sonotaSyoujyoHosoku;
	private int createdUserId;
	private int updatedUserId;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	
}
