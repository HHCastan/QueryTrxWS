package co.com.flamingo.queryTRX.util;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Properties;
import java.util.List;


import co.com.flamingo.queryTRX.publish.QueryTrxPublish;
import co.com.flamingo.queryTRX.types.Almacen;
import co.com.flamingo.queryTRX.services.ServiceDAO;

public class Util {
	private static Properties properties = null;

	public static Properties getProperties() {
		if (properties == null)
			loadProperties();
		return properties;
	}

	public static void loadProperties() {
		properties = new Properties();

		try {
			properties.load(QueryTrxPublish.class.getResourceAsStream("/properties/queryTrx.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static int binario2decimal(String numero) {
		long numeroDecimal = Long.parseLong(numero, 2);
		return (int)numeroDecimal;
	}
	
	public static String decimal2binario(int i) {
		String binario = String.format("%016d", new BigInteger(Integer.toBinaryString(i)));
		return (String) binario;
		//String s3 = bi3.toString(2);
	}
	
	public static String getTiendaIP(String sTienda) {
		String ip = "172.16.214.40";
		List<Almacen> tiendas = ServiceDAO.getTiendas();
		if (tiendas.size() < 1) {
			System.out.println("Error consultando los almacenes");
		}
		
		/** Lista de las tiendas que se consultan en la BD*/
		Almacen almacen = null;
		for (int i = 0; i < tiendas.size(); i++) { 
			almacen = (Almacen) tiendas.get(i);
			if(Integer.parseInt(sTienda) == Integer.parseInt(almacen.getCodigo()) ) {
				ip = almacen.getIP();
				break;
			}
		}
		
		return ip;
	}
	
}
