package com.fla.cotizador.modelo;

public class NewCustomer {
	String cajero;
	String cliente;
	String apellido1;
	String apellido2;
	String nombre1;
	String nombre2;
	String telefono;
	String eMail;
	String prioridad;
	String tienda;

	public NewCustomer(String sUsuario, String documento, String apellido1, String apellido2, String nombre1,
			String nombre2, String telefono, String email, int prioridad, String tienda) {
		setCajero(sUsuario);
		setCliente(documento);
		setApellido1(apellido1);
		setApellido2(apellido2);
		setNombre1(nombre1);
		setNombre2(nombre2);
		setTelefono(telefono);
		seteMail(email);
		setPrioridad(prioridad + "");
		setTienda(tienda);
	}

	public String getCajero() {
		return cajero;
	}

	public void setCajero(String cajero) {
		this.cajero = cajero;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getNombre1() {
		return nombre1;
	}

	public void setNombre1(String nombre1) {
		this.nombre1 = nombre1;
	}

	public String getNombre2() {
		return nombre2;
	}

	public void setNombre2(String nombre2) {
		this.nombre2 = nombre2;
	}
	
	public String getNombreCompleto() {
		String nombreCompleto = nombre1.trim();
		if (!nombre2.isEmpty())
			nombreCompleto = nombreCompleto + " " + nombre2.trim();
		nombreCompleto = nombreCompleto + " " + apellido1.trim();
		if (!apellido2.isEmpty())
			nombreCompleto = nombreCompleto + " " + apellido2.trim();
		return nombreCompleto;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(String prioridad) {
		this.prioridad = prioridad;
	}

	public String getTienda() {
		return tienda;
	}

	public void setTienda(String tienda) {
		this.tienda = tienda;
	}
}
