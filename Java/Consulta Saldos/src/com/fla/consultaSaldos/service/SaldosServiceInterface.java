package com.fla.consultaSaldos.service;

import java.util.List;

import com.fla.consultaSaldos.modelo.Saldo;

public abstract interface SaldosServiceInterface {

	public abstract Saldo getSaldo(String paramString1, String paramString2, String paramString3);

	public abstract List<?> getSaldos(String paramString1, String paramString2, String paramString3);

}
