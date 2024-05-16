package com.fla.cotizador.proceso;

import com.fla.cotizador.modelo.Cliente;
import com.fla.cotizador.servicio.ClientesServiceImplementation;

public class BuscaCliente {

	public BuscaCliente() {
		
	}
	
	public static Cliente getCliente(String cedula, String tienda, String stIP) {
		ClientesServiceImplementation clientesImpl = new ClientesServiceImplementation();
		Cliente cliente = clientesImpl.getCliente(cedula, tienda, stIP);
		return cliente;

	}
}
