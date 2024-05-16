package com.fla.devoluciones.model;

import java.util.List;

public class EngageTransaction {
	private String auditNumber;
	private String trxDate;
	private String siteCode;
	private String cardNo;
	private String cardName;
	private String cardFName;
	private String trxNo;
	private String ope;
	private String terminal;
	private long amount;
	private long remise;
	private List<Producto> productList;

	public String getAuditNumber() {
		return auditNumber;
	}
	public void setAuditNumber(String auditNumber) {
		this.auditNumber = auditNumber;
	}
	public String getTrxDate() {
		return trxDate;
	}
	public void setTrxDate(String trxDate) {
		this.trxDate = trxDate;
	}
	public String getSiteCode() {
		return siteCode;
	}
	public void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public String getCardName() {
		return cardName;
	}
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	public String getCardFName() {
		return cardFName;
	}
	public void setCardFName(String cardFName) {
		this.cardFName = cardFName;
	}
	public String getTrxNo() {
		return trxNo;
	}
	public void setTrxNo(String trxNo) {
		this.trxNo = trxNo;
	}
	public String getOpe() {
		return ope;
	}
	public void setOpe(String ope) {
		this.ope = ope;
	}
	public String getTerminal() {
		return terminal;
	}
	public void setTerminal(String terminal) {
		this.terminal = terminal;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public long getRemise() {
		return remise;
	}
	public void setRemise(long remise) {
		this.remise = remise;
	}
	public List<Producto> getProductList() {
		return productList;
	}
	public void setProductList(List<Producto> productList2) {
		this.productList = productList2;
	}
}
