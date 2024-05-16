package com.fla.cotizador.servicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.swing.JTable;

import org.datacontract.schemas._2004._07.WcfRemisionesRegistroPos_Servicio.ArticuloRem;

import com.fla.cotizador.dto.CuotaMefia;
import com.fla.cotizador.modelo.Almacen;
import com.fla.cotizador.modelo.ClienteSicaf;
import com.fla.cotizador.modelo.Cotizacion;
import com.fla.cotizador.modelo.DetalleCotizacion;
import com.fla.cotizador.modelo.EventoCredito;
import com.fla.cotizador.modelo.NewCustomer;
import com.fla.cotizador.modelo.OpcionesAplicacion;
import com.fla.cotizador.modelo.Producto;
import com.fla.cotizador.modelo.Tender;
import com.fla.cotizador.modelo.Usuario;

import co.com.flamingo.clienteRetanqueo.InfoAprobacion;

public interface DBServiceInterface {
	public abstract void ejecutar(String paramString);
	public abstract void conectarInformesPOS();
	public abstract void conectarLoyalty();
	public abstract void conectarSicaf();
	public abstract void conectarMercadeo();
	public abstract void conectarExternal();
	public abstract void conectarFenix();
	public abstract void conectarTucan();
	public abstract void conectarProspectos();
	public abstract void desconectarInformesPOS();
	public abstract void desconectarLoyalty();
	public abstract void desconectarSicaf();
	public abstract void desconectarMercadeo();
	public abstract void desconectarExternal();
	public abstract void desconectarFenix();
	public abstract void desconectarTucan();
	public abstract void desconectarProspectos();
	public abstract String getExternalProperty(String modulo, String clave);
	public abstract List<Almacen> getTiendas();
	public abstract List<Tender> getTenders();
	public abstract String getCuotaSafix(String sPlazo, String sValor, String sModalidad, String sTienda);
	public abstract ClienteSicaf getClienteSicaf(String cliente, String tipoDoc);
	public abstract void sendNewCustomer(NewCustomer newCustomer);
	public abstract JTable getPromos(String sCodigo, String sTienda);
	public abstract String getCuotaMefia(CuotaMefia cuotaMefia);
	public abstract String getDisponibleMefia(String sCliente);
	public abstract JTable getInventario(String sCodigo, String sTienda);
	public abstract String getPrecioFuturo(String sCodigo, String sFecha, String stCodigoAlmacen);
	public abstract String getDescricionArticulo(String sCodigo);
	public abstract JTable getHistoriaCliente(String sCliente);
	public abstract JTable getResumenCliente(String sCliente);
	public abstract JTable getVista360Cliente(String sCliente);
	public abstract JTable getReferenciasCliente(String sCliente);
	public abstract Usuario getUsuario(String sUsuario, String sPassword);
	public abstract List<OpcionesAplicacion> getOpcionesAplicacion();
	public abstract int getOpcionesPerfil(int perfil);
	public abstract String getIDCotizacion(String sTienda);
	public abstract boolean sendCotizacion(Cotizacion cotizacion, ArrayList<DetalleCotizacion> detalle);
	public abstract void closeCotizacion(String sCarritoRecuperado);
	public abstract void delCotizacion(String sCarritoRecuperado);
	public abstract Cotizacion getCotizacionCliente(String sCliente, String sFecha, String sTienda);
	public abstract boolean existeCotizacion(String sCotizacion, String sCliente);
	public abstract void sendOTP(String eMail);
	public abstract void sendEmailAprobacion(String eMail, InfoAprobacion infoAprobacion);
	public abstract List<EventoCredito> getEventosCredito(String sTienda, String sModalidad, String sCliente);
	public abstract int getGrupo(String sCodigo);
	public abstract String getEventosFinancieros();
	public abstract int sendeMailAlert(Cotizacion cotizacion, String mensaje);
	public abstract JTable getSegmentosClienteMotor(String sCliente);
	public abstract JTable getProductAttrib(String sCodigo);
	public abstract int getCuotaManejo(String sCliente);
	public abstract Properties getPropertiesDB();
	public abstract String getSisteCreditoStore(String sTienda);
	public abstract List<ArticuloRem> getSegurosProducto(String sCodigo, String sPrecio);
}
