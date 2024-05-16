package com.fla.consultaSaldos.service;

import java.util.List;

public interface DBServiceInterface {
	public abstract void ejecutar(String paramString);
	public abstract void conectar();
	public abstract void desconectar();
	public abstract List getTiendas();

}
