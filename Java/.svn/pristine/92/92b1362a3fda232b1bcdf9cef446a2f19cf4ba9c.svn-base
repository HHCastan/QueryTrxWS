package com.fla.cotizador.servicio;

import java.math.BigDecimal;
import java.util.GregorianCalendar;
import javax.xml.bind.JAXBElement;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.log4j.Logger;

import com.fla.cotizador.interfaz.ManejadorConexionRetanqueo;
import com.fla.cotizador.util.Util;

import co.com.flamingo.clienteRetanqueo.Aprobacion;
import co.com.flamingo.clienteRetanqueo.CrearAprobacionRes;
import co.com.flamingo.clienteRetanqueo.ObjectFactory;

public class RetanqueoServiceImplementation implements RetanqueoServiceInterface {
	private Logger log = Util.getLogger();
	@Override
	public CrearAprobacionRes crearAprobacion(String almacen, String codigoOTP, String idCliente, String tipoIdCliente,
			BigDecimal valor, BigDecimal nroCuotas, String evento, String formaPago) {
		Aprobacion aprobacion = new Aprobacion();
		ObjectFactory factory = new ObjectFactory();

		GregorianCalendar gcal = new GregorianCalendar();
		XMLGregorianCalendar today = null;
		try {
			today = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);
		} catch (DatatypeConfigurationException e1) {
			log.error("Error obteniendo fecha del sistema");
		}
		
		// Si el código de la tienda es menor que 100 viaja de dos dígitos:
		if(Integer.parseInt(almacen) < 100)
			almacen = almacen.substring(almacen.length() - 2);
		
		JAXBElement<String> jbeAfianzadora = factory.createAprobacionAfianzadora("8600418721");
		JAXBElement<String> jbeAlmacen = factory.createAprobacionAlmacen(almacen);
		JAXBElement<String> jbeCodigoOTP = factory.createAprobacionCodigoOtp(codigoOTP);
		JAXBElement<String> jbeFormaPago = factory.createAprobacionFormaPago(formaPago);
		JAXBElement<String> jbeEvento = factory.createAprobacionEvento(evento);
		JAXBElement<String> jbeIdCliente = factory.createAprobacionIdCliente(idCliente);
		JAXBElement<String> jbeNug = factory.createAprobacionNug("S");
		JAXBElement<String> jbePeriodicidad = factory.createAprobacionPeriodicidad("M");
		JAXBElement<String> jbeSucursalCliente = factory.createAprobacionSucursalCliente(almacen);
		JAXBElement<String> jbeTipoIdCliente = factory.createAprobacionTipoIdCliente(tipoIdCliente);
		JAXBElement<String> jbeUsuario = factory.createAprobacionUsuario(System.getProperty("user.name"));

		aprobacion.setAfianzadora(jbeAfianzadora);
		aprobacion.setAlmacen(jbeAlmacen);
		aprobacion.setCodigoOtp(jbeCodigoOTP);
		aprobacion.setEvento(jbeEvento);
		aprobacion.setFechaAprobacion(today);
		aprobacion.setFormaPago(jbeFormaPago);
		aprobacion.setIdCliente(jbeIdCliente);
		aprobacion.setNug(jbeNug);
		aprobacion.setNumeroCuotas(nroCuotas);
		aprobacion.setPeriodicidad(jbePeriodicidad);
		aprobacion.setSucursalCliente(jbeSucursalCliente);
		aprobacion.setTipoIdCliente(jbeTipoIdCliente);
		// 2020-12-02 La siguiente línea se comentarea porque al campo usuario se le dará otro uso a futuro
        // aprobacion.setUsuario(jbeUsuario);
		aprobacion.setValorProyecto(valor);
		
		log.info("Datos Ingreso: Alm: "+ jbeAlmacen.getValue()  + ", Otp: " + jbeCodigoOTP.getValue()
		 + ", Evento: " + jbeEvento.getValue() + ", Fecha: " +  today + ", Pago: " + jbeFormaPago.getValue()
		 + ", Cliente: " + jbeIdCliente.getValue() + ", NUG: " + jbeNug.getValue() + ", Meses: " + nroCuotas
		 + ", Periodicidad: " + jbePeriodicidad.getValue() + ", Sucursal: " + jbeSucursalCliente.getValue() + ", Tipo: " + jbeTipoIdCliente.getValue()
		 + ", Usuario: " + jbeUsuario.getValue() + ", Valor: " + valor);

		try {
			ManejadorConexionRetanqueo conRetanqueo = new ManejadorConexionRetanqueo();
			return conRetanqueo.crearAprobacion(aprobacion);
		} catch (Exception e) {
			log.info("Error Creando aprobación");
			e.printStackTrace();
		}
		return null;

	}
}
