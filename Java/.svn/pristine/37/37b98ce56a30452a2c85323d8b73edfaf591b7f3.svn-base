package com.fla.cotizador.interfaz;

import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Properties;

import org.apache.axis2.client.Options;
import org.apache.axis2.transport.http.impl.httpclient4.HttpTransportPropertiesImpl;
import org.apache.log4j.Logger;
import com.fla.cotizador.util.Util;

import co.com.bytte.casb.ConsultaClienteImagenDocument;
import co.com.bytte.casb.ConsultaClienteImagenDocument.ConsultaClienteImagen;
import co.com.bytte.casb.ConsultaClienteImagenRequest;
import co.com.bytte.casb.ConsultaClienteImagenResponseDocument;
import co.com.bytte.casb.ConsultaLogClienteDocument;
import co.com.bytte.casb.ConsultaLogClienteDocument.ConsultaLogCliente;
import co.com.bytte.casb.ConsultaLogClienteRequest;
import co.com.bytte.casb.ConsultaLogClienteResponseDocument.ConsultaLogClienteResponse;
import co.com.bytte.casb.WSCASBServiceStub;

public class ManejadorConexionBytteWS {
	private Logger log = Util.getLogger();
	private static final String CLASSNAME = "[ManejadorConexionBytteWS] ";
	private static ManejadorConexionBytteWS bytteServiceImpl; 
	private String usr;
	private String passwd;
	private String url;
	private Properties properties = Util.getProperties();
	private WSCASBServiceStub stub;
	
	public ManejadorConexionBytteWS getInstance() {
		if (bytteServiceImpl == null) 
			bytteServiceImpl = new ManejadorConexionBytteWS();
		return bytteServiceImpl;
	}
	
	public ManejadorConexionBytteWS() {
		usr = properties.getProperty("BYTTEusr");
		passwd = properties.getProperty("BYTTEpasswd");
		url = properties.getProperty("BYTTEurl");
	}
	
	public ConsultaClienteImagenResponseDocument consultaClienteImagen(String sCliente) throws RemoteException {
		ConsultaClienteImagenResponseDocument clienteImagen = ConsultaClienteImagenResponseDocument.Factory.newInstance();
		ConsultaClienteImagenDocument clienteImagenDocument = ConsultaClienteImagenDocument.Factory.newInstance();
		clienteImagenDocument.addNewConsultaClienteImagen();
		ConsultaClienteImagen consultaClienteImagen = ConsultaClienteImagen.Factory.newInstance();
		ConsultaClienteImagenRequest request = ConsultaClienteImagenRequest.Factory.newInstance();
		request.setNoDocumento(sCliente);
		request.setReturnImageByte(false);
		consultaClienteImagen.setRequest(request);
		clienteImagenDocument.setConsultaClienteImagen(consultaClienteImagen);
		HttpTransportPropertiesImpl.Authenticator auth = new HttpTransportPropertiesImpl.Authenticator();
		auth.setUsername(usr);
		auth.setPassword(passwd);
		auth.setHost(url);
		auth.setPreemptiveAuthentication(true);
		stub = new WSCASBServiceStub();
		
		Options options = stub._getServiceClient().getOptions();
		options.setProperty(org.apache.axis2.transport.http.HTTPConstants.AUTHENTICATE, auth);
		stub._getServiceClient().setOptions(options);
		try {
			clienteImagen = stub.consultaClienteImagen(clienteImagenDocument);
		} catch (RemoteException e) {
			log.error(CLASSNAME + "RemoteException al momento de consultar imagen de cédula");
			return null;
		}
		return clienteImagen;
		
	}

	public ConsultaLogClienteResponse consultaLogCliente(String sCliente) throws RemoteException {
		ConsultaLogClienteResponse LogCliente = ConsultaLogClienteResponse.Factory.newInstance();
		ConsultaLogCliente consultaLog = ConsultaLogCliente.Factory.newInstance();
		consultaLog.addNewRequest();
		ConsultaLogClienteDocument logClienteDocument = ConsultaLogClienteDocument.Factory.newInstance();
		logClienteDocument.addNewConsultaLogCliente();
		ConsultaLogClienteRequest request = ConsultaLogClienteRequest.Factory.newInstance();
		Calendar ini = new GregorianCalendar();
//		ini.add(Calendar.MINUTE, -30); // 30 minutos atrás
//		ini.add(Calendar.DATE, -1); // 1 día atrás
		ini.add(Calendar.YEAR, -1); // 1 año atrás
		request.setFechaFinal(new GregorianCalendar());
		request.setFechaInicial(ini);
		request.setNoDocumento(sCliente);
		consultaLog.setRequest(request);
		System.out.println("Consulta enrolamiento de cédula: Cédula = " + sCliente + ", Fecha Ini = " + ini.getTime());
		logClienteDocument.setConsultaLogCliente(consultaLog);
		HttpTransportPropertiesImpl.Authenticator auth = new HttpTransportPropertiesImpl.Authenticator();
		auth.setUsername(usr);
		auth.setPassword(passwd);
		auth.setPreemptiveAuthentication(true);
		stub = new WSCASBServiceStub();
		
		Options options = stub._getServiceClient().getOptions();
		options.setProperty(org.apache.axis2.transport.http.HTTPConstants.AUTHENTICATE, auth);
		stub._getServiceClient().setOptions(options);
		try {
			LogCliente = stub.consultaLogCliente(logClienteDocument).getConsultaLogClienteResponse();
		} catch (RemoteException e) {
			log.error(CLASSNAME + "RemoteException al momento de consultar imagen de cédula");
			return null;
		}
		return LogCliente;
	}

}
