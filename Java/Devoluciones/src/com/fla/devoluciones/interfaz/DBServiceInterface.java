package com.fla.devoluciones.interfaz;

import java.util.List;

import com.fla.devoluciones.model.Almacen;
import com.fla.devoluciones.model.EngageTransaction;

public interface DBServiceInterface {
	public abstract List<Almacen> getTiendas();
	public abstract void conectarInformesPOS();
	public abstract void desconectarInformesPOS();
	public abstract void conectarLoyalty();
	public abstract void desconectarLoyalty();
	public abstract EngageTransaction getEngageTransaction(String stFecha, String stSiteCode, String stCaja, String stTrxNo, String stCardNo);
}
