package com.fla.cotizador.interfaz;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.Properties;

import org.apache.axis.AxisFault;
import org.apache.log4j.Logger;

import org.tempuri.EndPoint1Stub;

import co.com.flamingo.www._2018._06.RespuestaMetodo;
import co.com.flamingo.www._2018._06.SwLiteClientesLocator;
import co.com.flamingo.www.contratos.ValidacionDatosClienteRes;

import javax.xml.namespace.QName;
import javax.xml.rpc.Service;
import javax.xml.rpc.ServiceException;
import javax.xml.rpc.ServiceFactory;

import com.fla.cotizador.util.Util;

public class ManejadorConexionSafixWS {
	private Logger log = Util.getLogger();
	private static final String CLASSNAME = "ManejadorConexionSafixWS";
	private static ManejadorConexionSafixWS  safixServiceImpl;
	private String url = "http://172.16.8.24/SwLiteClientes/SwLiteClientes.svc";
	private String portName = "EndPoint1";
	private Properties properties = Util.getProperties();
	private EndPoint1Stub stub;
	private QName qName;
	private ServiceFactory serviceFactory;
	private Service service;


	public ManejadorConexionSafixWS() {
//		url = properties.getProperty("SAFIXurl");
		portName = properties.getProperty("SAIFXportName");
	}
	
	public ManejadorConexionSafixWS getInstance () throws AxisFault, MalformedURLException, ServiceException {
		if (safixServiceImpl == null)
			safixServiceImpl = new ManejadorConexionSafixWS();
		return safixServiceImpl;
	}
	
	public RespuestaMetodo validarClienteSafix(String tipoID, String identificacion, Calendar fechaNacimiento, Calendar fechaExpedicion) throws AxisFault, MalformedURLException, ServiceException {
		RespuestaMetodo respuesta = null;
		log.debug("Inicia consulta de cliente válido: " + identificacion);
		
		SwLiteClientesLocator locator = new SwLiteClientesLocator();
		locator.setEndpointAddress(portName, url);
		qName = new QName("http://www.flamingo.com.co/2018/06", "ValidacionDatosCliente");
		serviceFactory = ServiceFactory.newInstance();
		service =  serviceFactory.createService(qName);
		stub = new EndPoint1Stub(new URL(url), service);
		
		try {
			ValidacionDatosClienteRes validacionClienteRes = stub.validarClienteSafix(tipoID, identificacion, fechaNacimiento, fechaExpedicion);
			respuesta = validacionClienteRes.getRespuestaMetodo();
		} catch (RemoteException e) {
			log.error(CLASSNAME + "RemoteException al momento de validar el cliente en Safix");
		}
		
		return respuesta;
	}
}
