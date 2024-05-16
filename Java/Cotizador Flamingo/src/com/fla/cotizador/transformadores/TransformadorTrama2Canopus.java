package com.fla.cotizador.transformadores;

import com.fla.cotizador.modelo.Cliente;
import com.fla.cotizador.modelo.Producto;
import com.fla.cotizador.modelo.ProductosTableModel;
import com.fla.cotizador.modelo.Tender;
import com.fla.cotizador.modelo.TenderTableModel;
import com.fla.cotizador.util.Util;

public class TransformadorTrama2Canopus {
	public static String transformCliente(String sUser, String sCustomer, String sStore, String sFecha, String sHora) {
		String respuesta = sCustomer + "|" + sUser + "|" + sStore + "|0099|0001|" + sFecha.replaceAll("/", "") + "|" + sHora.substring(0, 2) + sHora.substring(3, 5) + "00" + "|null|null|";
		return respuesta ;
	}

	public static String transformProductosMedios(ProductosTableModel modeloPR, TenderTableModel modeloMP, String sUser, String sCustomer, String sStore, String sFecha, String sHora) {
		String respuesta = sCustomer + "|" + sUser + "|" + sStore + "|0099|0001|" + sFecha.replaceAll("/", "") + "|" + sHora.substring(0, 2) + sHora.substring(3, 5) + "00" + "|";
		// Prouctos:
		for (int a = 0; a < modeloPR.getRowCount(); a++) {
			Producto producto =  (Producto) modeloPR.getRowProduct(a);
			respuesta = respuesta + producto.getItemCode() + ",";
			respuesta = respuesta + Util.removeMoneyFormat(producto.getItemPrice()) + ",";
			respuesta = respuesta + producto.getQuantity()  + "," + producto.getDepto() + ",";
			if(producto.isDescontable())
				respuesta = respuesta + "0~";
			else
				respuesta = respuesta + "1~";
		}
		// Quita la última ~ y agrega el PIPE de cierre:
		respuesta = respuesta.substring(0, respuesta.length() -1) + "|";
		// Medios de pago:
		for (int a = 0; a < modeloMP.getRowCount(); a++) {
			Tender tender =  (Tender) modeloMP.getRowTender(a);
			respuesta = respuesta + tender.getCodigo() + ",";
			respuesta = respuesta + Util.removeMoneyFormat(tender.getMonto()) + "~"; 
		}
		return respuesta.substring(0, respuesta.length() -1) + "|null|";
	}
	
	public static Cliente canopusResponse2Cliente(String sResponse) {
		Cliente cliente = new Cliente();
		cliente.setFirstName(Util.getToken(sResponse, 0, "\\|"));
		cliente.setLastName(Util.getToken(sResponse, 1, "\\|"));
		cliente.setSex(Util.getToken(sResponse, 2, "\\|"));
		cliente.setOptionalTicketMessage(Util.getToken(sResponse, 3, "\\|"));

		return cliente;
	}

	public static Cliente getClienteGenerico() {
		Cliente cliente = new Cliente();
		cliente.setPAN("9999999999999999999");
		cliente.setFirstName("ESTIMADO");
		cliente.setLastName("CLIENTE");
		cliente.setSex("M");
		cliente.setOptionalTicketMessage("");
		return cliente;
	}

}
