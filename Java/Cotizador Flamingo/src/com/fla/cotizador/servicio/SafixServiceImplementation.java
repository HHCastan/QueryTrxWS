package com.fla.cotizador.servicio;

import java.net.MalformedURLException;
import java.util.Calendar;

import org.apache.axis.AxisFault;
import org.apache.log4j.Logger;

import com.fla.cotizador.interfaz.ManejadorConexionSafixWS;
import com.fla.cotizador.util.Util;

import co.com.flamingo.www._2018._06.RespuestaMetodo;

public class SafixServiceImplementation implements  SafixServiceInterface {

	private Logger log = Util.getLogger();

	@Override
	public RespuestaMetodo validaClienteSafix(String tipoID, String identificacion, Calendar fechaNacimiento, Calendar fechaExpedicion) {
		try {
			ManejadorConexionSafixWS conSafix = new ManejadorConexionSafixWS();
			return conSafix.validarClienteSafix(tipoID, identificacion, fechaNacimiento, fechaExpedicion);
		} catch (Exception e) {
			log.info("Error validando cliente");
			e.printStackTrace();
		}
		return null;
	}

}
