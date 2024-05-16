package com.fla.cotizador.interfaz;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.Properties;

import org.apache.axis.AxisFault;
import org.apache.log4j.Logger;
import org.datacontract.schemas._2004._07.WcfRemisionesRegistroPos_Servicio.RemisionEN;
import org.tempuri.BasicHttpBinding_IRemisionesPosServiceStub;
import org.tempuri.RemisionesPosServiceLocator;

import javax.xml.namespace.QName;
import javax.xml.rpc.Service;
import javax.xml.rpc.ServiceException;
import javax.xml.rpc.ServiceFactory;

import com.fla.cotizador.util.Util;

public class ManejadorConexionRemisionesWS {
	private Logger log = com.fla.cotizador.util.Util.getLogger();
	private static final String CLASSNAME = "[ManejadorConexionRemisionesSW] ";
	private static ManejadorConexionRemisionesWS remisionServiceImpl;
	private String url = "http://172.16.8.206/WcfRemisionesRegistroPosMpAuto/RemisionesPosService.svc"; // Producción
	private String portName = "BasicHttpBinding_IRemisionesPosService";
	private String usr = "USR_POS";
	private String passwd = "USR_P0S";
	private Properties properties = Util.getProperties();
	private BasicHttpBinding_IRemisionesPosServiceStub stub;
	private QName qName;
	private ServiceFactory serviceFactory;
	private Service service;

	public ManejadorConexionRemisionesWS getInstance() throws AxisFault, MalformedURLException, ServiceException {
		if (remisionServiceImpl == null)
			remisionServiceImpl = new ManejadorConexionRemisionesWS();
		return remisionServiceImpl;
	}

	public ManejadorConexionRemisionesWS() {
		url = properties.getProperty("REMISIONESurl");
		portName = properties.getProperty("REMISIONESportName");
		usr = properties.getProperty("REMISIONESusr");
		passwd = properties.getProperty("REMISIONESpasswd");
	}

	public RemisionEN getRemision(String remision) throws AxisFault, MalformedURLException, ServiceException {
		RemisionesPosServiceLocator locator = new RemisionesPosServiceLocator();
		locator.setEndpointAddress(portName, url);
		qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/WcfRemisionesRegistroPos.Servicio", "RemisionDevolEN");
		serviceFactory = ServiceFactory.newInstance();
		service =  serviceFactory.createService(qName);
		stub = new BasicHttpBinding_IRemisionesPosServiceStub(new URL(url), service);
		
		try {
			RemisionEN remisionResponse = stub.consultarVentaRemision(usr, passwd, remision);
			int tipoRemision = 0;
			tipoRemision = remisionResponse.getMpAutomatico();
			if (tipoRemision != 0) {
				return remisionResponse;
			}
		} catch (RemoteException e) {
			log.error(CLASSNAME + "RemoteException al momento de consultar Remision");
			return null;
		}
	return null;
}

}
