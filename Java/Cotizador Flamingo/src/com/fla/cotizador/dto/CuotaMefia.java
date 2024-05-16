package com.fla.cotizador.dto;

public class CuotaMefia {
	private String monto;
	private String meses;
	private String modalidad;
	private String cuota;
	private String ok;

	public CuotaMefia(String monto, String meses, String modalidad) {
		super();
		this.monto = monto;
		this.meses = meses;
		this.modalidad = modalidad;
	}
	public String getMonto() {
		return monto;
	}
	public void setMonto(String monto) {
		this.monto = monto;
	}
	public String getMeses() {
		return meses;
	}
	@Override
	public String toString() {
		return "CuotaMefia [monto=" + monto + ", meses=" + meses + ", modalidad=" + modalidad + "]";
	}
	public void setMeses(String meses) {
		this.meses = meses;
	}
	public String getModalidad() {
		return modalidad;
	}
	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}
	public String getCuota() {
		return cuota;
	}
	public void setCuota(String cuota) {
		this.cuota = cuota;
	}
	public String getOk() {
		return ok;
	}
	public void setOk(String ok) {
		this.ok = ok;
	}

}
