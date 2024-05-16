package com.fla.remoteCommand.implementation;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.enterprisedt.net.ftp.FTPClient;
import com.enterprisedt.net.ftp.FTPException;
import com.enterprisedt.net.ftp.FTPMessageCollector;
import com.fla.remoteCommand.interfaz.FTPServiceInterface;
import com.fla.remoteCommand.util.Util;

public class FTPServiceImplementation implements FTPServiceInterface {
	private Logger log = Util.getLogger();
	private static FTPServiceImplementation ftpServiceImpl;
	private Properties properties = Util.getProperties();
	FTPClient ftp = new FTPClient();
	private static String host;
	private String user = "ftpuser";
	private String password = "4690tcpip";
	FTPMessageCollector listener = new FTPMessageCollector();

	public static FTPServiceImplementation getInstance() {
		if (ftpServiceImpl == null)
			ftpServiceImpl = new FTPServiceImplementation();
		return ftpServiceImpl;
	}

	public FTPServiceImplementation() {
		log.info("Servicio FTP instanciado");
	}
	
	public void setHost(String host) {
		try {
			ftp.setRemoteHost(host);
			ftp.setRemotePort(21);
		} catch (FTPException e) {
			e.printStackTrace();
		} catch (IOException e) {
			log.error("Error conectando con servidor " + host + ". " + e);
		}
	}

	@Override
	public void conectar() {
		user = properties.getProperty("FTPUser");
		password = properties.getProperty("FTPPassword");
		try {
			System.out.println("Conectando con host: " + ftp.getRemoteHost());
			ftp.setMessageListener(listener);
			ftp.connect();
			ftp.login(user, password);
		} catch (IOException e) {
			log.error("Error conectando con servidor " + host + ". " + e);
		} catch (FTPException e) {
			log.error("Error conectando con servidor " + host + ". " + e);
		}

	}

	@Override
	public void desconectar() {
		try {
			ftp.quit();
		} catch (IOException | FTPException e) {
			log.error("Error desconectando del servidor " + host + ". " + e);
		}

	}

	@Override
	public void subirArchivo(String stOrigen, String stDestino) {
		try {
			ftp.put(stOrigen, stDestino);
		} catch (FileNotFoundException e) {
			log.error("Error leyendo archivo de subida: " + stOrigen);
		} catch (IOException e1) {
			log.error("Error leyendo archivo de subida: " + stOrigen);
		} catch (Exception e2) {
			log.error("Excepción en subida de archivo: " + stOrigen);
		}
	}

	@Override
	public void bajarArchivo(String stOrigen, String stDestino) {
		// TODO Auto-generated method stub

	}

	@Override
	public void ejecutarComando(String stComando, String stParametros) {
		try {
			ftp.quote("ADXSTART ADX_UPGM:UDREMOTO.286");
			String mensaje = listener.getLog();
			System.out.println("Respuesta: " + mensaje);
		} catch (IOException e) {
			log.error("Error ejecutando comando remoto: " + stComando);
		} catch (FTPException e) {
			log.error("Error ejecutando comando remoto: " + stComando);
		}
	}
	
	public String getMensaje() {
		return listener.getLog();
	}

}
