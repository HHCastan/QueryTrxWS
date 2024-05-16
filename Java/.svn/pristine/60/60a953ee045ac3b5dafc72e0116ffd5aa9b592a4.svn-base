package com.fla.cotizador.servicio;

import java.net.MalformedURLException;

import javax.xml.rpc.ServiceException;

import org.apache.axis.AxisFault;
import org.datacontract.schemas._2004._07.WcfRemisionesRegistroPos_Servicio.RemisionEN;

import com.fla.cotizador.interfaz.ManejadorConexionRemisionesWS;

public class RemisionServiceImplementation implements RemisionServiceInterface {

	@Override
	public RemisionEN getRemision(String remision) {
		// TODO Auto-generated method stub
		ManejadorConexionRemisionesWS mcr = new ManejadorConexionRemisionesWS();
		try {
			return mcr.getRemision(remision);
		} catch (AxisFault | MalformedURLException | ServiceException e) {
			e.printStackTrace();
		}
		return null;
	}

}
