package com.fla.consultaSaldos.proceso;

import java.util.List;

import com.fla.consultaSaldos.service.SaldosServiceImplementacion;

public class BuscaCliente {

	public BuscaCliente() {
		
	}
	
	public static List<?> getSaldosCliente(String cedula, String tienda, String stIP) {
		SaldosServiceImplementacion saldosImpl = new SaldosServiceImplementacion();
		List<?> lista = saldosImpl.getSaldos(cedula, tienda, stIP);
		return lista;

	}
}
