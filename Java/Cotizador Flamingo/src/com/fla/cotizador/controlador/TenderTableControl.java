package com.fla.cotizador.controlador;

import com.fla.cotizador.modelo.Tender;
import com.fla.cotizador.modelo.TenderTableModel;

/**
 * Clase para controlar el modelo en TenderTableModel utilizado en la ventana de
 * cotizacion.
 * 
 * @author hugo.castaneda@flamingo.com.co
 * 
 */

public class TenderTableControl {
	/** El modelo de la tabla */
	private TenderTableModel modelo = null;

	/**
	 * Numero que nos servirá para construir tenders distintos para la tabla
	 */
	private static int numero = 0;

	public TenderTableControl(TenderTableModel modelo) {
		this.modelo = modelo;
	}

	/**
	 * Adiciona una fila al final del modelo
	 */
	public void addRow(Tender dato) {
		this.modelo.addTender(dato);
		numero++;
	}

	/** Elimina la fila indicada del modelo */
	public void delRow(int iRow) {
		this.modelo.delTender(iRow);
		numero--;
	}

	public void clear() {
		if (numero > 0)
			modelo.clear();
		numero = 0;
	}
}
