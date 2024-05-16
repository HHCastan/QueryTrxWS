package com.fla.cotizador.servicio;

import java.util.Calendar;

import co.com.flamingo.www._2018._06.RespuestaMetodo;

public interface SafixServiceInterface {
	public abstract RespuestaMetodo validaClienteSafix(String tipoID, String identificacion, Calendar fechaNacimiento, Calendar fechaExpedicion);
}
