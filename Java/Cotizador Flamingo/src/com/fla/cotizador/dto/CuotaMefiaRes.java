package com.fla.cotizador.dto;

public class CuotaMefiaRes {
	private CuotaMefia cuotaMefia;

	public CuotaMefiaRes(CuotaMefia cuotaMefia) {
		this.cuotaMefia = cuotaMefia;
	}
	
	public CuotaMefia getCuotaMefia () {
		return this.cuotaMefia;
	}
	
	public void setCuotaMefia (CuotaMefia cuotaMefia) {
		this.cuotaMefia = cuotaMefia;
	}
}
