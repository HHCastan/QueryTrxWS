package com.fla.devoluciones.control;

import com.fla.devoluciones.model.Producto;
import com.fla.devoluciones.model.ProductosTableModel;

/**
 * Clase para controlar el modelo en ProductosTableModel utilizado en la ventana de
 * cotizacion.
 * 
 * @author hugo.castaneda@flamingo.com.co
 * 
 */

public class ProductosTableControl {
	/** El modelo de la tabla */
	private ProductosTableModel modelo = null;

	/**
	 * Numero que nos servirĂ¡ para construir personas distintas para la tabla
	 */
	private static int numero = 0;

	public ProductosTableControl(ProductosTableModel modelo) {
		this.modelo = modelo;
	}

	/**
	 * Adiciona una fila al final del modelo
	 */
	public void addRow(Producto dato) {
		this.modelo.addItem(dato);
		numero++;
	}

	/** Elimina la fila indicada del modelo */
	public void delRow(int iRow) {
		this.modelo.delItem(iRow);
		numero--;
	}

	public void clear() {
		if (numero > 0)
			modelo.clear();
		numero = 0;
	}

}
