package com.fla.devoluciones.model;

import javax.swing.table.*;
import javax.swing.event.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Modelo de items. Cada fila es un item y las columnas son sus atributos. Implements TableModel y
 * todos sus metodos.
 * 
 * @author hugo.castaneda@flamingo.com.co
 * 
 */
public class ProductosTableModel implements TableModel {

	/**
	 * Lista con los datos. Cada elemento de la lista es una instancia de Producto
	 */
	private LinkedList<Producto> datos = new LinkedList<Producto>();

	/**
	 * Lista de suscriptores. El JTable será un suscriptor de este modelo de datos
	 */
	private LinkedList<TableModelListener> listeners = new LinkedList<TableModelListener>();

	public int getRowCount() {
		return datos.size();
	}

	public int getColumnCount() {
		return 6;
	}

	/**
	 * 
	 * @param columnIndex
	 *            the index of the column
	 * @return the name of the column
	 * 
	 */
	public String getColumnName(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return "CÓDIGO";
		case 1:
			return "DESCRIPCIÓN";
		case 2:
			return "PRECIO";
		case 3:
			return "DESCUENTO";
		case 4:
			return "CANTIDAD";
		case 5:
			return "TOTAL";
		default:
			return null;
		}
	}

	/**
	 * @param columnIndex
	 *            the index of the column
	 * @return the common ancestor class of the object values in the model.
	 * 
	 */
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// Devuelve la clase que hay en cada columna.
		return getValueAt(0, columnIndex).getClass();
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	/**
	 * Returns the value for the cell at <code>columnIndex</code> and <code>rowIndex</code>.
	 * 
	 * @param rowIndex
	 *            the row whose value is to be queried
	 * @param columnIndex
	 *            the column whose value is to be queried
	 * @return the value Object at the specified cell
	 * 
	 */
	public Object getValueAt(int rowIndex, int columnIndex) {
		Producto aux;

		// Se obtiene el producto de la fila indicada
		aux = (Producto) (datos.get(rowIndex));

		// Se obtiene el campo apropiado según el valor de columnIndex
		switch (columnIndex) {
		case 0:
			return aux.getItemCode();
		case 1:
			return aux.getItemDesc();
		case 2:
			return aux.getItemPrice();
		case 3:
			return aux.getItemRemise();	
		case 4:
			return aux.getQuantity();	
		case 5:
			return aux.getItemTotal();	
		default:
			return null;
		}
	}

	/**
	 * Sets the value in the cell at <code>columnIndex</code> and <code>rowIndex</code> to <code>aValue</code>.
	 * 
	 * @param aValue
	 *            the new value
	 * @param rowIndex
	 *            the row whose value is to be changed
	 * @param columnIndex
	 *            the column whose value is to be changed
	 * @see #getValueAt
	 * @see #isCellEditable
	 * 
	 */
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		Producto aux;
		aux = (Producto) (datos.get(rowIndex));
		// Cambia el campo del Item que indica columnIndex, poniendole el
		// aValue que se nos pasa.
		switch (columnIndex) {
		case 0:
			aux.setItemCode((String) aValue);
			break;
		case 1:
			aux.setItemDesc((String) aValue);
			break;
		case 2:
			aux.setItemPrice(Long.parseLong((String) aValue));
			break;
		case 3:
			aux.setItemRemise(Long.parseLong((String) aValue));
			break;
		case 4:
			aux.setQuantity(Integer.valueOf((String) aValue));
			break;
		case 5:
			aux.setItemTotal(Long.parseLong((String) aValue));
			break;
		default:
			break;
		}

		// Avisa a los suscriptores del cambio, creando un TableModelEvent ...
		TableModelEvent evento = new TableModelEvent(this, rowIndex, rowIndex, columnIndex);

		// ... y pasándoselo a los suscriptores.
		avisaSuscriptores(evento);
	}

	public void addTableModelListener(TableModelListener l) {
		// Adiciona un suscriptor
		listeners.add(l);
	}

	public void removeTableModelListener(TableModelListener l) {
		// Elimina un suscriptor.
		listeners.remove(l);
	}

	/**
	 * Borra del modelo el item en la fila indicada
	 */
	public void delItem(int fila) {
		// Se borra la fila
		datos.remove(fila);

		// Y se avisa a los suscriptores, creando un TableModelEvent...
		TableModelEvent evento = new TableModelEvent(this, fila, fila, TableModelEvent.ALL_COLUMNS,
				TableModelEvent.DELETE);

		// ... y pasándoselo a los suscriptores
		avisaSuscriptores(evento);
	}

	/**
	 * Limpia la tabla de productos:
	 */
	public void clear() {
		while (getRowCount() > 0) {
			delItem(getRowCount() -1);
		}
	}

	/**
	 * Añade un item al final de la tabla
	 */
	public void addItem(Producto newItem) {
		// Añade el item al modelo
		datos.add(newItem);

		// Avisa a los suscriptores creando un TableModelEvent...
		TableModelEvent evento;
		evento = new TableModelEvent(this, this.getRowCount() - 1, this.getRowCount() - 1, TableModelEvent.ALL_COLUMNS,
				TableModelEvent.INSERT);

		// ... y avisando a los suscriptores
		avisaSuscriptores(evento);
	}


	/**
	 * Pasa a los suscriptores el evento.
	 */
	private void avisaSuscriptores(TableModelEvent evento) {
		int i;

		// Bucle para todos los suscriptores en la lista, se llama al metodo tableChanged() de los mismos, pasándole el
		// evento.
		for (i = 0; i < listeners.size(); i++)
			((TableModelListener) listeners.get(i)).tableChanged(evento);
	}

	/**
	 *  Entrega el producto en la posición indicada de la tabla
	 * 
	 */
	public Producto getRowProduct(int rowIndex) {
		return ((Producto) (datos.get(rowIndex)));

	}
	
	/**
	 * Devuelve una lista con todos los productos
	 */
	public List<Producto> getProductList() {
		List<Producto> productList = new ArrayList<Producto>(getRowCount());
		for (int i = 0; i < getRowCount(); i++) {
			productList.add(getRowProduct(i));
		}
		return productList;
	}
}
