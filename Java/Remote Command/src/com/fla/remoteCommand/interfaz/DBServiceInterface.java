package com.fla.remoteCommand.interfaz;

import java.util.List;

import com.fla.remoteCommand.modelo.Almacen;

public interface DBServiceInterface {
	public abstract List<Almacen> getTiendas();
	public abstract void conectarInformesPOS();
	public abstract void desconectarInformesPOS();
}
