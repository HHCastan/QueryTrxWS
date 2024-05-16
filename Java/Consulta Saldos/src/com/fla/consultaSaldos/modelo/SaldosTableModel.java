package com.fla.consultaSaldos.modelo;

import javax.swing.table.*;
import javax.swing.event.*;

import java.util.LinkedList;

/**
 * Modelo de items. Cada fila es un saldo y las columnas son sus atributos. Implements TableModel y
 * todos sus metodos.
 * 
 * @author hcastaneda
 * 
 */
public class SaldosTableModel implements TableModel {

	/**
	 * Lista con los datos. Cada elemento de la lista es una instancia de Saldo
	 */
	private LinkedList<Saldo> datos = new LinkedList<Saldo>();

	/**
	 * Lista de suscriptores. El JTable será un suscriptor de este modelo de datos
	 */
	private LinkedList<TableModelListener> listeners = new LinkedList<TableModelListener>();

	public int getRowCount() {
		return datos.size();
	}

	public int getColumnCount() {
		return 7;
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
			return "FECHA";
		case 2:
			return "VALOR";
		case 3:
			return "TIPO";
		case 4:
			return "ESTADO";
		case 5:
			return "F. RETIRO";
		case 6:
			return "DOC.ORIGEN";
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
		case 0:
			// La columna cero contiene el codigo del saldo, que es un String
			return String.class;
		case 1:
			// La columna uno contiene la fecha del saldo, que es un String
			return String.class;
		case 2:
			// La columna dos contine el valor del saldo, que es un String
			return String.class;
		case 3:
			// La columna tres contine el tipo del saldo, que es un String
			return String.class;
		case 4:
			// La columna cuatro contine el estado del saldo, que es un String
			return String.class;
		case 5:
			// La columna cinco contine la fecha de retiro, que es un String
			return String.class;
		case 6:
			// La columna cinco contine el documento origen, que es un String
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
		Saldo aux;

		// Se obtiene el saldo de la fila indicada
		aux = (Saldo) (datos.get(rowIndex));

		// Se obtiene el campo apropiado según el valor de columnIndex
		switch (columnIndex) {
		case 0:
			return aux.getNdoc();
		case 1:
			return aux.getFechael();
		case 2:
			return aux.getValordoc();
		case 3:
			return aux.getTipoDescription();
		case 4:
			return aux.getEstadoDescription();
		case 5:
			return aux.getFechare();
		case 6:
			return aux.getDocorigen();
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
		// No se implementa porque es una pantalla de solo consulta
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
	 * Añade un saldo al final de la tabla
	 */
	public void addSaldo(Saldo newSaldo) {
		// Añade el item al modelo
		datos.add(newSaldo);

		// Avisa a los suscriptores creando un TableModelEvent...
		TableModelEvent evento;
		evento = new TableModelEvent(this, this.getRowCount() - 1, this.getRowCount() - 1, TableModelEvent.ALL_COLUMNS,
				TableModelEvent.INSERT);

		// ... y avisando a los suscriptores
		avisaSuscriptores(evento);
	}

	/**
	 * Limpia la Pantalla
	 */
	public void clear() {
		while (getRowCount() > 0) {
			delSaldo(getRowCount() -1);
		}
	}


	/**
	 * Borra del modelo el saldo en la fila indicada
	 */
	public void delSaldo(int fila) {
		// Se borra la fila
		datos.remove(fila);

		// Y se avisa a los suscriptores, creando un TableModelEvent...
		TableModelEvent evento = new TableModelEvent(this, fila, fila, TableModelEvent.ALL_COLUMNS,
				TableModelEvent.DELETE);

		// ... y pasándoselo a los suscriptores
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

}
