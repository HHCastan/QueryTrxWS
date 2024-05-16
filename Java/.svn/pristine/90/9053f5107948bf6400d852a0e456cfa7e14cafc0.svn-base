package com.fla.consultaSaldos.control;

import com.fla.consultaSaldos.modelo.Saldo;
import com.fla.consultaSaldos.modelo.SaldosTableModel;

/**
 * Clase para controlar el modelo en SaldosTableModel utilizado en la ventana de
 * saldos.
 * 
 * @author hcastaneda
 * 
 */

public class SaldosTableControl {
	/** El modelo de la tabla */
	private SaldosTableModel modelo = null;

	/**
	 * Numero que nos servirá para construir personas distintas para la tabla
	 */
	private static int numero = 0;

	public SaldosTableControl(SaldosTableModel modelo) {
		this.modelo = modelo;
	}

	/**
	 * Adiciona una fila al final del modelo
	 */
	public void addRow(Saldo dato) {
		this.modelo.addSaldo(dato);
		numero++;
	}

	/** Elimina la fila indicada del modelo */
	public void delRow(int iRow) {
	}

	public void clear() {
		if (numero > 0)
			modelo.clear();
		numero = 0;
	}
}
