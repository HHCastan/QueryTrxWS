package com.fla.consultaSaldos.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import org.apache.log4j.Logger;

import com.fla.consultaSaldos.modelo.Almacen;
import com.fla.consultaSaldos.util.Util;

public class DBServiceImplementation implements DBServiceInterface {
	private Logger log = Util.getLogger();
	private static DBServiceImplementation dbServiceImpl;
	private Connection conn;
	private Properties properties = Util.getProperties();
	
	public static DBServiceImplementation getInstance() {
		if (dbServiceImpl == null)
			dbServiceImpl = new DBServiceImplementation();
		return dbServiceImpl;
	}

	@Override
	public void ejecutar(String query) {
		try {
			Statement st = conn.createStatement();
			log.debug("Ejecutando query: " + query);
			st.executeUpdate(query);
		} catch (Exception e) {
			log.error("Error: " + e);
		}
	}

	@Override
	public void conectar() {
		try {
			String url = properties.getProperty("dburl");
			String driver = properties.getProperty("driver");
			String user = properties.getProperty("dbuser");
			String pass = properties.getProperty("dbpassword");
			log.debug("Conectando. URL: " + url + ", DRIVER: " + driver + ", user: " + user + ", pass: " + pass);
			System.out.println("Conectando. URL: " + url + ", DRIVER: " + driver + ", user: " + user + ", pass: " + pass);
			conn = DriverManager.getConnection(url, user, pass);
			Class.forName(driver);
			log.debug("Conexion exitosa con la base de datos.");
		} catch (Exception e) {
			log.error("Error: ", e);
		}
		
	}

	@Override
	public void desconectar() {
		try {
			conn.close();
		} catch (Exception e) {
			log.error("Error cerrando conexion: ", e);
		}
		log.debug("Desconexión exitosa con la base de datos");
	}

	@Override
	public List<Almacen> getTiendas() {
		List<Almacen> lista = new LinkedList<Almacen>();
		ResultSet rs = null;
		conectar();
		try {
			Statement st = conn.createStatement();
			rs = st.executeQuery("SELECT ID, Nombre, IP FROM TIENDAS_POS ORDER BY ID");
			while (rs.next()) {
				Almacen almacen = new Almacen();
				String sID = rs.getString("ID");
				String sNombre = rs.getString("Nombre");
				String sIP = rs.getString("IP");
				almacen.setCodigo(sID);
				almacen.setNombre(sNombre);
				almacen.setIP(sIP);
				lista.add(almacen);
			}
		} catch (Exception e) {
			log.error("Error:", e);
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException localSQLException) {
				}
		}
		desconectar();
		
		return lista;
	}
	

}
