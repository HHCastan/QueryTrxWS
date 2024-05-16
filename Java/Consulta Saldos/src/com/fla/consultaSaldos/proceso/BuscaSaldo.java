package com.fla.consultaSaldos.proceso;

import com.fla.consultaSaldos.modelo.Saldo;
import com.fla.consultaSaldos.service.SaldosServiceImplementacion;

public class BuscaSaldo {

	public BuscaSaldo() {
		
	}
	public static Saldo getSaldo(String saldo, String tienda, String IP) {
		SaldosServiceImplementacion saldosImpl = new SaldosServiceImplementacion();
		return saldosImpl.getSaldo(saldo, tienda, IP);
		
	}
}
