package com.fla.cotizador.modelo;

public class Tender {
	private String codigo;
	private String descripcion;
	private String Monto;

	public String getCodigo() {
		return codigo;
	}

	public void newTender(String codigo, String descripcion, String monto) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.Monto = monto;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getMonto() {
		return Monto;
	}

	public void setMonto(String monto) {
		this.Monto = monto;
	}
	
	public String toString() {
		return getDescripcion();
	}

}
