package com.fla.cotizador.modelo;

import com.fla.cotizador.util.Util;

/**
 * Clase donde se define el objeto Item que se pinta en la pantalla de escaneo
 * 
 * @author hugo.castaneda@flamingo.com.co
 * 
 */
public class Producto {
	private String itemCode;
	private String itemDepto;
	private String itemPrice;
	private String itemDesc;
	private String vendedor;
	private int indicat0;
	private int indicat1;
	private int indicat1a;
	private int indicat2;
	private String familyNu;
	private String mpGroup;
	private String linkedTo;
	private int saleQuan;
	private int userExit1;
	private int userExit2;
	private int itemQty;
	private int eventoFenix;
	private int eventoMefia;
	private int eventoSafix;
	private String userData;

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getDepto() {
		return itemDepto;
	}

	public void setDepto(String depto) {
		this.itemDepto = depto;
	}

	public String getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(String salePric) {
		this.itemPrice = salePric;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public int getIndicat1() {
		return indicat1;
	}

	public void setIndicat1(int indicat1) {
		this.indicat1 = indicat1;
	}

	public int getQuantity() {
		return itemQty;
	}

	public void setQuantity(int itemQty) {
		this.itemQty = itemQty;
	}

	public int getIndicat0() {
		return indicat0;
	}

	public void setIndicat0(int indicat0) {
		this.indicat0 = indicat0;
	}

	public int getIndicat1a() {
		return indicat1a;
	}

	public void setIndicat1a(int indicat1a) {
		this.indicat1a = indicat1a;
	}

	public int getIndicat2() {
		return indicat2;
	}

	public void setIndicat2(int indicat2) {
		this.indicat2 = indicat2;
	}

	public String getFamilyNu() {
		return familyNu;
	}

	public void setFamilyNu(String familyNu) {
		this.familyNu = familyNu;
	}

	public String getMpGroup() {
		return mpGroup;
	}

	public void setMpGroup(String mpGroup) {
		this.mpGroup = mpGroup;
	}

	public String getLinkedTo() {
		return linkedTo;
	}

	public void setLinkedTo(String linkedTo) {
		this.linkedTo = linkedTo;
	}

	public int getSaleQuan() {
		return saleQuan;
	}

	public void setSaleQuan(int saleQuan) {
		this.saleQuan = saleQuan;
	}

	public int getUserExit1() {
		return userExit1;
	}

	public void setUserExit1(int userExit1) {
		this.userExit1 = userExit1;
	}

	public int getUserExit2() {
		return userExit2;
	}

	public void setUserExit2(int userExit2) {
		this.userExit2 = userExit2;
	}

	public int getEventoFenix() {
		return eventoFenix;
	}

	public void setEventoFenix(int eventoFenix) {
		this.eventoFenix = eventoFenix;
	}

	public int getEventoMefia() {
		return eventoMefia;
	}

	public void setEventoMefia(int eventoMefia) {
		this.eventoMefia = eventoMefia;
	}

	public int getEventoSafix() {
		return eventoSafix;
	}

	public void setEventoSafix(int eventoSafix) {
		this.eventoSafix = eventoSafix;
	}

	public String getUserData() {
		return userData;
	}

	public void setUserData(String userData) {
		this.userData = userData;
	}

	public String toString() {
		String respuesta = "";
		respuesta = respuesta + "itemCode: " + this.itemCode + "; ";
		respuesta = respuesta + "itemDepto: " + this.itemDepto + "; ";
		respuesta = respuesta + "itemPrice: " + this.itemPrice + "; ";
		respuesta = respuesta + "itemDesc: " + this.itemDesc + "; ";
		respuesta = respuesta + "itemQty: " + this.itemQty + "; ";

		return respuesta;
	}

	public boolean isDescontable() {
		return Util.isBitOn(indicat1, 2);
	}

	public String getVendedor() {
		return vendedor;
	}

	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}

	public String getTarifaIVA() {
		return Util.getTarifaIVA(this.indicat1);
	}

}