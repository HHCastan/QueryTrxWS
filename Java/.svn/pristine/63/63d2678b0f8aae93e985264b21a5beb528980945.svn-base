package com.fla.cotizador.servicio;

import java.rmi.RemoteException;

import com.fla.cotizador.interfaz.ManejadorConexionBytteWS;

import co.com.bytte.casb.ConsultaClienteImagenResponseDocument;
import co.com.bytte.casb.ConsultaLogClienteResponseDocument.ConsultaLogClienteResponse;

public class BytteServiceImplementation implements BytteServiceInterface {

	@Override
	public ConsultaClienteImagenResponseDocument consultaClienteImagen(String sCliente) {
		ManejadorConexionBytteWS mcb = new ManejadorConexionBytteWS();
		try {
			return mcb.consultaClienteImagen(sCliente);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ConsultaLogClienteResponse consultaLogCliente(String sCliente) {
		ManejadorConexionBytteWS mcb = new ManejadorConexionBytteWS();
		try {
			return mcb.consultaLogCliente(sCliente);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

}
