package com.linea;

import org.apache.derby.drda.NetworkServerControl;

import com.linea.loadLib.AddLibraries;

public class StartDerby {
	/**
	 * @param args
	 */

	public static void main(String args[]) {
		System.out.println("Cargando librerias...");
		AddLibraries.init();
		System.out.println("Librerias cargadas");
		String params[] = { "start", "-h", "0.0.0.0" };
		System.setProperty("java.security.manager", "");
		System.setProperty("java.security.policy", "/cdrive/f_drive/derby/falpolicy.policy");
		System.setProperty("derby.system.home", "/cdrive/f_drive/derby/");
		System.setProperty("derby.storage.pageSize", "8192");

		System.out.println("Levantando NetworkServerControl");
		try {
			// Se llama a la clase NetworkServerControl.
			NetworkServerControl.main(params);
			System.out.println("NetworkServerControl.main() invocado");
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}
}
