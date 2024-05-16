package com.fla.cotizador.modelo;

import com.fla.cotizador.util.Util;

public class DetalleCotizacion {
	private String codigo;
	private String descripcion;
	private String valor;
	private int cantidad;
	private String total;
	private boolean descontable;
	private String vendedor;
	private int evento;

	
	public DetalleCotizacion(Producto producto) {
		this.codigo = producto.getItemCode();
		this.descripcion = producto.getItemDesc();
		this.valor = producto.getItemPrice();
		this.cantidad = producto.getQuantity();
		this.total = Util.getTotalItem(producto);
		this.setDescontable(producto.isDescontable());
		this.vendedor = producto.getVendedor();
		this.evento = producto.getEventoFenix();
	}

	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public int getCantidad() {
		return cantidad;
	}
	
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public boolean isDescontable() {
		return descontable;
	}

	public void setDescontable(boolean descontable) {
		this.descontable = descontable;
	}

	public String getVendedor() {
		return vendedor;
	}

	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}

	public int getEvento() {
		return evento;
	}

	public void setEvento(int evento) {
		this.evento = evento;
	}

	public String toPrint() {
		return String.format("%12s %20s %11s %4d %11s %11s", codigo, descripcion, valor, cantidad, total, vendedor);
	}
	
	public String toSendDB() {
		String sDescontable = descontable == true ? "S" : "N";
		// Elimina comillas sencillas que puedan estar en la descripción:
		return codigo + ", " + cantidad  + ", " +  Util.removeMoneyFormat(valor)  + ", '" + sDescontable + "', '" + vendedor + "', '" + descripcion.replace("'", "''")+ "', " + evento ;
	}
	
}
