package com.fla.consultaSaldos.principal;

import com.fla.consultaSaldos.vista.Ventana;
import com.fla.consultaSaldos.Version;
import java.util.Properties;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Inicio {

	private static Properties properties;
	private static Logger log;
	public static Properties getProperties() {
		if (properties == null)
			loadProperties();
		return properties;
	}

	public static void loadProperties() {
		properties = new Properties();
		
		try {
			System.out.println("HHC Antes de cargar propiedades");
			properties.load(Inicio.class.getResourceAsStream("/properties/consultaSaldos.properties"));
//				log.debug("Archivo de propiedades cargado correctamente");
		}
		catch (IOException e) {
			log.error("No se pudo cargar archivo de propiedades.", e);
			e.printStackTrace();
		}
	}
	
	public void loadLogConfig(){
		Properties l4jPro = new Properties();
		try {
			l4jPro.load(this.getClass().getResourceAsStream("/consSaldos4j.properteis"));
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		PropertyConfigurator.configure(l4jPro);
	}
	
	public void ejecutar() {
		loadLogConfig();
		log = Logger.getLogger(getClass());
		
		loadProperties();
		log.info("Consulta Saldos: Inicia ejecución del módulo Versión: " + Version.getVersion());
		
		Ventana ventana = new Ventana();
		ventana.setVisible(true);
		
	}
}
