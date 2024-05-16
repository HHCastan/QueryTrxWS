package co.com.flamingo.sincronizadorClientes.interfaz;

import java.util.List;

import co.com.flamingo.sincronizadorClientes.modelo.Almacen;

public interface DBServiceInterface {
	public abstract List<Almacen> getTiendas();
	public abstract void conectarInformesPOS();
	public abstract void desconectarInformesPOS();
	public abstract void conectarLoyalty();
	public abstract void desconectarLoyalty();
	public abstract String[ ] getDatosCliente(String sCliente);
	public abstract List<String> getSitiosReconocido(String sCliente);
}
