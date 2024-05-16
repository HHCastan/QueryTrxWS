package com.fla.cotizador.modelo;

import javax.swing.table.*;
import javax.swing.event.*;

import java.util.LinkedList;

/**
 * Modelo de tenders. Cada fila es un medio de pago y las columnas son sus atributos. Implements TableModel y
 * todos sus metodos.
 * 
 * @author hugo.castaneda@flamingo.com.co
 * 
 */
public class TenderTableModel implements TableModel {

	/**
	 * Lista con los datos. Cada elemento de la lista es una instancia de Tender
	 */
	private LinkedList<Tender> datosMP = new LinkedList<Tender>();

	/**
	 * Lista de suscriptores. El JTable será un suscriptor de este modelo de datos
	 */
	private LinkedList<TableModelListener> listenersMP = new LinkedList<TableModelListener>();

	public int getRowCount() {
		return datosMP.size();
	}

	public int getColumnCount() {
		return 2;
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
			return "DESCRIPCIÓN";
		case 1:
			return "MONTO";
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
	public Class<?> getColumnClass(int columnIndex) {
		// Devuelve la clase que hay en cada columna.
		switch (columnIndex) {
//		case 0:
//			// La columna uno contiene el código del Tender, que es un String
//			return String.class;
		case 0:
			// La columna dos contine la descripción del Tender, que es un String
			return String.class;
		case 1:
			// La columna dos contine el valor del Tender, que es un String
			return String.class;
		default:
			// Devuelve una clase Object por defecto.
			return Object.class;
		}
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
		Tender aux;

		// Se obtiene el Tender de la fila indicada
		aux = (Tender) (datosMP.get(rowIndex));

		// Se obtiene el campo apropiado según el valor de columnIndex
		switch (columnIndex) {
//		case 0:
//			return aux.getCodigo();
		case 0:
			return aux.getDescripcion();
		case 1:
			return aux.getMonto();
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
		Tender aux;
		aux = (Tender) (datosMP.get(rowIndex));
		// Cambia el campo del tender que indica columnIndex, poniendole el
		// aValue que se nos pasa.
		switch (columnIndex) {
//		case 0:
//			aux.setCodigo((String) aValue);
//			break;
		case 0:
			aux.setDescripcion((String) aValue);
			break;
		case 1:
			aux.setMonto((String) aValue);
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
		listenersMP.add(l);
	}

	public void removeTableModelListener(TableModelListener l) {
		// Elimina un suscriptor.
		listenersMP.remove(l);
	}

	/**
	 * Borra del modelo el tender en la fila indicada
	 */
	public void delTender(int fila) {
		// Se borra la fila
		datosMP.remove(fila);

		// Y se avisa a los suscriptores, creando un TableModelEvent...
		TableModelEvent evento = new TableModelEvent(this, fila, fila, TableModelEvent.ALL_COLUMNS,
				TableModelEvent.DELETE);

		// ... y pasándoselo a los suscriptores
		avisaSuscriptores(evento);
	}

	/**
	 * Limpia la tabla de tenders:
	 */
	public void clear() {
		while (getRowCount() > 0) {
			delTender(getRowCount() -1);
		}
	}

	/**
	 * Añade un tender al final de la tabla
	 */
	public void addTender(Tender newTender) {
		// Añade el tender al modelo
		datosMP.add(newTender);

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
		for (i = 0; i < listenersMP.size(); i++) 
			((TableModelListener) listenersMP.get(i)).tableChanged(evento);
		
	}

	/**
	 *  Entrega el tender en la posición indicada de la tabla
	 * 
	 */
	public Tender getRowTender(int rowIndex) {
		return ((Tender) (datosMP.get(rowIndex)));

	}
}
