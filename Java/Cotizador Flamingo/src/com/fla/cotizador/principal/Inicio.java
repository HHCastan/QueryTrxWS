package com.fla.cotizador.principal;

import com.fla.cotizador.vista.Ventana;
import com.fla.cotizador.Version;
import com.fla.cotizador.controlador.Cotizador;
import com.fla.cotizador.util.Util;

import java.util.Properties;

import javax.swing.SwingUtilities;

import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.lf5.viewer.LogFactor5LoadingDialog;

public class Inicio {

	public static void ejecutar() {
		Cotizador cotizador = new Cotizador();
		cotizador.iniciarSistema();
	}

	/**
	 * main
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ejecutar();
	}
}
