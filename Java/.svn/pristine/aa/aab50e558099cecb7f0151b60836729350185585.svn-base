package com.fla.cotizador.interfaz;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import javax.xml.bind.JAXBElement;

import com.fla.cotizador.util.Util;

import co.com.flamingo.clienteRetanqueo.Aliado;
import co.com.flamingo.clienteRetanqueo.Aprobacion;
import co.com.flamingo.clienteRetanqueo.Autenticacion;
import co.com.flamingo.clienteRetanqueo.CrearAprobacionRes;
import co.com.flamingo.clienteRetanqueo.IRetanqueo;
import co.com.flamingo.clienteRetanqueo.ObjectFactory;
import co.com.flamingo.clienteRetanqueo.SwRetanqueo;
import co.com.flamingo.clienteRetanqueo.TokenRes;

public class ManejadorConexionRetanqueo {
	private static ManejadorConexionRetanqueo conRetanqueo;
	private Properties properties = Util.getProperties();
	private String url;
	private String user;
	private String passwd;
	private String nitAliado;

	public ManejadorConexionRetanqueo() {
		url = properties.getProperty("RETANQUEOurl");
		user = properties.getProperty("RETANQUEOusr");
		passwd = properties.getProperty("RETANQUEOpasswd");
		nitAliado = properties.getProperty("RETANQUEOnitAliado");
	}

	public ManejadorConexionRetanqueo getInstance() {
		if (conRetanqueo == null)
			conRetanqueo = new ManejadorConexionRetanqueo();
		return conRetanqueo;
	}

	public CrearAprobacionRes crearAprobacion(Aprobacion aprobacion) throws MalformedURLException {
		Autenticacion ingreso = getAutenticacion();

		SwRetanqueo service = new SwRetanqueo(new URL(url));
		IRetanqueo retanqueo = service.getIRetanqueo();
		
		CrearAprobacionRes retanqueoRes = retanqueo.crearAprobacion(ingreso, aprobacion);

		return retanqueoRes;
	}
	
	private TokenRes generarToken() throws MalformedURLException {
		SwRetanqueo service = new SwRetanqueo(new URL(url));
		IRetanqueo retanqueo = service.getIRetanqueo();
		ObjectFactory factory = new ObjectFactory();
		JAXBElement<String> jbeIdAliado = factory.createAutenticacionIdAliado(nitAliado);
		JAXBElement<String> jbeTipoIdAliado = factory.createAutenticacionTipoIdAliado("NI");
		
		Aliado aliado = new Aliado();
		aliado.setIdAliado(jbeIdAliado);
		aliado.setTipoIdAliado(jbeTipoIdAliado);
		
		TokenRes generarTokenRes = retanqueo.generarToken(aliado, user, passwd);
		return generarTokenRes;
		
	}
	
	private Autenticacion getAutenticacion() throws MalformedURLException {
		ObjectFactory factory = new ObjectFactory();
		JAXBElement<String> jbeUser = factory.createAutenticacionUsuario(user);
		JAXBElement<String> jbePasswd = factory.createAutenticacionContrasena(passwd);
		JAXBElement<String> jbeIdAliado = factory.createAutenticacionIdAliado(nitAliado);
		JAXBElement<String> jbeTipoIdAliado = factory.createAutenticacionTipoIdAliado("NI");
		JAXBElement<String> jbeToken = generarToken().getToken();
		
		Autenticacion autenticacion = new Autenticacion();
		autenticacion.setUsuario(jbeUser);
		autenticacion.setContrasena(jbePasswd);
		autenticacion.setIdAliado(jbeIdAliado);
		autenticacion.setTipoIdAliado(jbeTipoIdAliado);
		autenticacion.setToken(jbeToken);
		
		System.out.println("Borrar HHC - Datos Ingreso: User:" + jbeUser.getValue() + ", Pass: " + jbePasswd.getValue() + ", Aliado: " + jbeIdAliado.getValue() + ", Tipo: " + jbeTipoIdAliado.getValue() + ", Token: " + jbeToken.getValue());
		
		return autenticacion;
		
	}
}
