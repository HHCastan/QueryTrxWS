package com.fla.cotizador.modelo;

import org.apache.log4j.Logger;

import com.fla.cotizador.controlador.Coordinador;
import com.fla.cotizador.servicio.DBServiceImplementation;

public class Proceso {
	
	/** Servicio para conexion con bases de datos */
	DBServiceImplementation dbServiceImpl = new DBServiceImplementation();	

	private Coordinador coordinador;

	public void setCoordinador(Coordinador coordinador) {
		this.coordinador = coordinador;
		
	}

	public Usuario validarIngreso(String sUsuario, String sPasswd, String sAplicacion) {
		return dbServiceImpl.getUsuario(sUsuario, sPasswd);
	}

}
 