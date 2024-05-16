package com.fla.cotizador.servicio;

import com.fla.cotizador.modelo.Producto;

public abstract interface ProductosServiceInterface {

	public abstract Producto getProducto(String paramString1, String paramString2);

}
