package com.fla.cotizador.interfaz;

import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.xml.namespace.QName;
import javax.xml.rpc.Service;
import javax.xml.rpc.ServiceException;
import javax.xml.rpc.ServiceFactory;

import org.apache.axis.AxisFault;
import org.apache.log4j.Logger;

import com.fla.cotizador.dto.CuotaMefia;
import com.fla.cotizador.util.Util;
import com.mefia.omnia.portal.services.PortalWebServiceImplPortBindingStub;
import com.mefia.omnia.portal.services.PortalWebServiceLocator;

import omnia.mefia.com.SimulationResponse;

public class ManejadorConexionMefiaWS {
	private Logger log = com.fla.cotizador.util.Util.getLogger();
	private static final String CLASSNAME = "[ManejadorConexionWSMFIA] ";
	private static ManejadorConexionMefiaWS mfiaServiceImpl;
	private String url = "https://plataformacomercial.flamingo.com.co:7103/omnia-services/portalWebService"; // Producción
	private String portName = "PortalWebServiceImplPort";
	private Properties properties = Util.getProperties();
	private PortalWebServiceImplPortBindingStub stub;
	private QName qName;
	private ServiceFactory serviceFactory;
	private Service service;

	public static ManejadorConexionMefiaWS getInstance() throws AxisFault, MalformedURLException, ServiceException {
		if (mfiaServiceImpl == null) 
			mfiaServiceImpl = new ManejadorConexionMefiaWS();
		return mfiaServiceImpl;
	}
	
	public ManejadorConexionMefiaWS()  {
		url = properties.getProperty("MFIAurl");
		portName = properties.getProperty("MFIAportName");
	}
	
	public String getCuotaMefia(CuotaMefia cuotaMefia) throws AxisFault, MalformedURLException, ServiceException {
		PortalWebServiceLocator locator = new PortalWebServiceLocator();
		locator.setEndpointAddress(portName, url);
		qName = new javax.xml.namespace.QName("http://com.mefia.omnia", "simulationResponse");
		serviceFactory = ServiceFactory.newInstance();
		service =  serviceFactory.createService(qName);
		stub = new PortalWebServiceImplPortBindingStub(new URL(url), service);
		
		try {
			BigDecimal monto = new BigDecimal(cuotaMefia.getMonto());
			BigDecimal numeroCuotas = new BigDecimal(cuotaMefia.getMeses());
			String producto = cuotaMefia.getModalidad();
			log.info(CLASSNAME + "Inicia consulta => " + cuotaMefia.toString());
			SimulationResponse response = stub.simuladorCredito(monto, numeroCuotas, producto);
			if (response.getMensajeRespuesta().compareTo("OK") == 0)
				return response.getValorCuota().toString();
			else
				return response.getMensajeRespuesta();
		} catch (RemoteException e) {
			log.error("RemoteException al momento de consultar cuota a Mefia");
			e.printStackTrace();
			Util.okDialog("Ocurrió un error conectando con Mefia. Vuelva a intentarlo en un minuto", new JFrame(), JOptionPane.ERROR_MESSAGE);
		}
		return "0";
	}
}
