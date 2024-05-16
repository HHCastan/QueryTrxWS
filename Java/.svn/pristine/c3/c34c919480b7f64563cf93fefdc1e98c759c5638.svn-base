package com.fla.cotizador.servicio;

import java.net.Socket;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.fla.cotizador.modelo.Cliente;
import com.fla.cotizador.util.Util;

public class ClientesServiceImplementation implements ClientesServiceInterface {
	private Logger log = Util.getLogger();
	private String host;
	private int port;
	private Socket socket;
	private String ruta;
	private int espera;
	private int reintentos;
	static ClientesServiceImplementation clientesServiceImplementacion;

	public ClientesServiceImplementation getInstance() {
		if (clientesServiceImplementacion == null) {
			clientesServiceImplementacion = new ClientesServiceImplementation();
		}
		return clientesServiceImplementacion;
	}

	public ClientesServiceImplementation() {
		Properties properties = Util.getProperties();
		try {
			this.host = properties.getProperty("pafserver");
			this.port = Integer.parseInt(properties.getProperty("pafport"));
			this.ruta = properties.getProperty("ruta");
			this.espera = Integer.parseInt(properties.getProperty("espera"));
			this.reintentos = Integer.parseInt(properties.getProperty("reintentos"));
		} catch (Exception localException) {
            log.error(localException);
		}
	}

	@Override
	public Cliente getCliente(String paramString1, String paramString2, String paramString3) {
		// TODO Auto-generated method stub
		return null;
	}
}
