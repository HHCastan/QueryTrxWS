package com.fla.cotizador.modelo;

import com.fla.cotizador.servicio.DBServiceImplementation;

public class Cotizacion {
	private String cotizacionID;
	private Almacen tienda;
	private ClienteSicaf cliente;
	private String fechaPrecio;
	private String valorMcia;
	private String descuento;
	private String vlrFinanciar;
	private String meses;
	private String cuotaSafix;
	private String cuotaMefia;
	private String observaciones;
	private String modalidad;
	private int estado;
	private int nivel;
	private String registradoTienda;
	private String registradoTrm;
	private String registradoTrx;
	private String registradoFecha;
	private String registradoFactura;
	private boolean clienteNuevo;
	private TenderTableModel modeloMP;
	private ProductosTableModel modeloPR;
	private String mDecisiones;

	public Cotizacion(ClienteSicaf clienteSicaf, Almacen tienda, String fechaPrecio,
			String valor, String descuento, String meses, String cuotaSafix, String cuotaMefia,
			String observaciones, String modalidad, boolean clienteNuevo,
			TenderTableModel modeloMP, ProductosTableModel modeloPR, String sCarritoRecuperado, String mDecisiones) {
		super();
		this.cliente = clienteSicaf;
		this.tienda = tienda;
		this.fechaPrecio = fechaPrecio;
		this.valorMcia = valor;
		this.descuento = descuento;
		this.meses = meses;
		this.cuotaSafix = cuotaSafix;
		this.cuotaMefia = cuotaMefia;
		this.observaciones = observaciones;
		this.modalidad = modalidad;
		this.clienteNuevo = clienteNuevo;
		this.modeloPR = modeloPR;
		this.estado = 1;
		this.setModeloMP(modeloMP);
		this.mDecisiones = mDecisiones;
		
		if (sCarritoRecuperado.isEmpty()) {
			/** Servicio para conexion con bases de datos */
			DBServiceImplementation dbServiceImpl = new DBServiceImplementation();
			this.cotizacionID = dbServiceImpl.getIDCotizacion(tienda.getCodigo());
		} else {
			this.cotizacionID = sCarritoRecuperado;
		}

	}

	public String getCotizacionID() {
		return cotizacionID;
	}

	public void setCotizacionID(String cotizacionID) {
		this.cotizacionID = cotizacionID;
	}

	public ClienteSicaf getCliente() {
		return cliente;
	}

	public void setCliente(ClienteSicaf cliente) {
		this.cliente = cliente;
	}

	public Almacen getTienda() {
		return tienda;
	}

	public void setTienda(Almacen tienda) {
		this.tienda = tienda;
	}

	public String getFechaPrecio() {
		return fechaPrecio;
	}

	public void setFechaPrecio(String fechaPrecio) {
		this.fechaPrecio = fechaPrecio;
	}

	public String getValor() {
		return valorMcia;
	}

	public void setValor(String valor) {
		this.valorMcia = valor;
	}

	public String getDescuento() {
		return descuento;
	}

	public void setDescuento(String descuento) {
		this.descuento = descuento;
	}

	public String getVlrFinanciar() {
		return vlrFinanciar;
	}

	public void setVlrFinanciar(String vlrFinanciar) {
		this.vlrFinanciar = vlrFinanciar;
	}

	public String getMeses() {
		return meses;
	}

	public void setMeses(String meses) {
		this.meses = meses;
	}

	public String getCuotaSafix() {
		return cuotaSafix;
	}

	public void setCuotaSafix(String cuotaSafix) {
		this.cuotaSafix = cuotaSafix;
	}

	public String getCuotaMefia() {
		return cuotaMefia;
	}

	public void setCuotaMefia(String cuotaMefia) {
		this.cuotaMefia = cuotaMefia;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getModalidad() {
		return modalidad;
	}

	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}

	public ProductosTableModel getModeloPR() {
		return modeloPR;
	}

	public void setModeloPR(ProductosTableModel modeloPR) {
		this.modeloPR = modeloPR;
	}

	public boolean isClienteNuevo() {
		return clienteNuevo;
	}

	public void setClienteNuevo(boolean clienteNuevo) {
		this.clienteNuevo = clienteNuevo;
	}

	public TenderTableModel getModeloMP() {
		return modeloMP;
	}

	public void setModeloMP(TenderTableModel modeloMP) {
		this.modeloMP = modeloMP;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public String getRegistradoTienda() {
		return registradoTienda;
	}

	public void setRegistradoTienda(String registradoTienda) {
		this.registradoTienda = registradoTienda;
	}

	public String getRegistradoTrm() {
		return registradoTrm;
	}

	public void setRegistradoTrm(String registradoTrm) {
		this.registradoTrm = registradoTrm;
	}

	public String getRegistradoTrx() {
		return registradoTrx;
	}

	public void setRegistradoTrx(String registradoTrx) {
		this.registradoTrx = registradoTrx;
	}

	public String getRegistradoFecha() {
		return registradoFecha;
	}

	public void setRegistradoFecha(String registradoFecha) {
		this.registradoFecha = registradoFecha;
	}

	public String getRegistradoFactura() {
		return registradoFactura;
	}

	public void setRegistradoFactura(String registradoFactura) {
		this.registradoFactura = registradoFactura;
	}

	public String getmDecisiones() {
		return mDecisiones;
	}

	public void setmDecisiones(String mDecisiones) {
		this.mDecisiones = mDecisiones;
	}

}
