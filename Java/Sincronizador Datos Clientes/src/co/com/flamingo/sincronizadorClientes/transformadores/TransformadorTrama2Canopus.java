package co.com.flamingo.sincronizadorClientes.transformadores;

import co.com.flamingo.sincronizadorClientes.modelo.Cliente;
import co.com.flamingo.sincronizadorClientes.util.Util;

public class TransformadorTrama2Canopus {
	public static String transformCliente(String sUser, String sCustomer, String sStore, String sFecha, String sHora) {
		String respuesta = sCustomer + "|" + sUser + "|" + sStore + "|0099|0001|" + sFecha.replaceAll("/", "") + "|" + sHora.substring(0, 2) + sHora.substring(3, 5) + "00" + "|null|null|";
		return respuesta ;
	}

	
	public static co.com.flamingo.sincronizadorClientes.modelo.Cliente canopusResponse2Cliente(String sResponse) {
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
