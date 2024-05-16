package co.com.flamingo.sincronizadorClientes.implementacion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;

import co.com.flamingo.sincronizadorClientes.interfaz.DBServiceInterface;
import co.com.flamingo.sincronizadorClientes.modelo.Almacen;
import co.com.flamingo.sincronizadorClientes.util.Util;

public class DBServiceImplementation implements DBServiceInterface {
	private static DBServiceImplementation dbServiceImpl;
	private Properties properties = Util.getProperties();
	private Connection connINFPOS;
	private Connection connLyty;
	private Logger log = co.com.flamingo.sincronizadorClientes.util.Util.getLogger();

	public static DBServiceImplementation getInstance() {
		if (dbServiceImpl == null)
			dbServiceImpl = new DBServiceImplementation();
		return dbServiceImpl;
	}

	@Override
	public List<Almacen> getTiendas() {
		List<Almacen> lista = new LinkedList<Almacen>();
		ResultSet rs = null;
		conectarInformesPOS();
		try {
			Statement st = connINFPOS.createStatement();
			rs = st.executeQuery("SELECT ID, Nombre, IP, tomcatServer FROM TIENDAS_POS ORDER BY ID");
			while (rs.next()) {
				Almacen almacen = new Almacen();
				String sID = rs.getString("ID");
				String sNombre = rs.getString("Nombre");
				String sIP = rs.getString("IP");
				String sTomcatServer = rs.getString("tomcatServer");
				almacen.setCodigo(sID);
				almacen.setNombre(sNombre);
				almacen.setIP(sIP);
				almacen.setTomcatServer(sTomcatServer);
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
		desconectarInformesPOS();

		return lista;
	}

	@Override
	public void conectarInformesPOS() {
		try {
			String url = properties.getProperty("dburl");
			String driver = properties.getProperty("driver");
			String user = properties.getProperty("dbuser");
			String pass = properties.getProperty("dbpassword");
			log.debug("Conectando. URL: " + url + ", DRIVER: " + driver + ", user: " + user + ", pass: " + pass);
			System.out.println("Conectando. URL: " + url + ", DRIVER: " + driver + ", user: " + user + ", pass: " + pass);
			connINFPOS = DriverManager.getConnection(url, user, pass);
			Class.forName(driver);
			log.debug("Conexion exitosa con la base de datos.");
		} catch (Exception e) {
			log.error("Error: ", e);
		}
	}

	@Override
	public void desconectarInformesPOS() {
		try {
			connINFPOS.close();
		} catch (Exception e) {
			log.error("Error cerrando conexion: ", e);
		}
		log.debug("Desconexión exitosa con la base de datos");
	}

	@Override
	public void conectarLoyalty() {
		try {
			String url = properties.getProperty("LYTYdburl");
			String driver = properties.getProperty("LYTYdriver");
			log.info("Conectando. URL: " + url + ", DRIVER: " + driver);
			connLyty = DriverManager.getConnection(url);
			Class.forName(driver);
			log.info("Conexion exitosa con la base de datos.");
		} catch (Exception e) {
			log.error("Error: ", e);
		}
	}

	@Override
	public void desconectarLoyalty() {
		try {
			connLyty.close();
		} catch (Exception e) {
			log.error("Error cerrando conexion: ", e);
		}
		log.info("Desconexión exitosa con la base de datos");
	}

	@Override
	public String[ ] getDatosCliente(String sCliente) {
		String[ ] nombre = new String[2];
		log.info("Consulta de cliente: " +"SELECT CARD_FNAME, CARD_NAME FROM CARD WHERE CARD_NO = "+ sCliente);
		ResultSet rs = null;
		conectarLoyalty();
		try {
			Statement st = connLyty.createStatement();
			rs = st.executeQuery("SELECT CARD_FNAME, CARD_NAME FROM CARD WHERE CARD_NO = "+ sCliente);
			while (rs.next()) {
				nombre[0] = rs.getString("CARD_FNAME");
				nombre[1] = rs.getString("CARD_NAME");
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
		return nombre;
	}

	@Override
	public List<String> getSitiosReconocido(String sCliente) {
		List<String> sitiosReconocido = new LinkedList<String>();
		
		ResultSet rs = null;
		conectarLoyalty();
		try {
			Statement st = connLyty.createStatement();
			rs = st.executeQuery("SELECT DISTINCT SITE_CODE FROM LOG_HEADER WHERE LOG_VALIDED=1 AND CST_CODE=" + sCliente);
			while (rs.next()) {
				sitiosReconocido.add(rs.getString("SITE_CODE"));
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
		desconectarLoyalty();
		return sitiosReconocido;
	}

}
