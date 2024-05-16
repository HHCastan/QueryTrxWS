package com.fla.cotizador.servicio;

import java.io.IOException;
import java.io.StringReader;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import javax.swing.JTable;
import javax.xml.rpc.ServiceException;

import org.apache.axis.AxisFault;
import org.apache.log4j.Logger;
import org.apache.xmlbeans.impl.xb.xsdschema.LengthDocument;
import org.datacontract.schemas._2004._07.WcfRemisionesRegistroPos_Servicio.ArticuloRem;

import com.fla.cotizador.controlador.ProductosTableControl;
import com.fla.cotizador.dto.CuotaMefia;
import com.fla.cotizador.interfaz.ManejadorConexionMefiaWS;
import com.fla.cotizador.modelo.Almacen;
import com.fla.cotizador.modelo.ClienteSicaf;
import com.fla.cotizador.modelo.Cotizacion;
import com.fla.cotizador.modelo.DetalleCotizacion;
import com.fla.cotizador.modelo.EventoCredito;
import com.fla.cotizador.modelo.NewCustomer;
import com.fla.cotizador.modelo.OpcionesAplicacion;
import com.fla.cotizador.modelo.Producto;
import com.fla.cotizador.modelo.ProductosTableModel;
import com.fla.cotizador.modelo.Tender;
import com.fla.cotizador.modelo.TenderTableModel;
import com.fla.cotizador.modelo.Usuario;
import com.fla.cotizador.util.Auxiliar;
import com.fla.cotizador.util.Util;

import co.com.flamingo.clienteRetanqueo.InfoAprobacion;
import oracle.jdbc.OracleConnection;
import oracle.jdbc.pool.OracleDataSource;

public class DBServiceImplementation implements DBServiceInterface {
	private Logger log = com.fla.cotizador.util.Util.getLogger();
	private static DBServiceImplementation dbServiceImpl;
	private Connection connSICAF;
	private Connection connLyty;
	private Connection connINFPOS;
	private Connection connMERCADEO;
	private Connection connExternal;
	private Connection connProspectos;
	private OracleConnection connFenix;
	private OracleConnection connTucan;
	private Properties properties = Util.getProperties();
	private Properties propertiesDB = Util.getPropertiesDB();
	

	public static DBServiceImplementation getInstance() {
		if (dbServiceImpl == null)
			dbServiceImpl = new DBServiceImplementation();
		return dbServiceImpl;
	}

	@Override
	public void ejecutar(String query) {
		try {
			Statement st = connSICAF.createStatement();
			log.info("Ejecutando query: " + query);
			st.executeUpdate(query);
		} catch (Exception e) {
			log.error("Error: " + e);
		}
	}

	public Connection getConnINFPOS() {
		if (connINFPOS == null)
			conectarInformesPOS();
		return connINFPOS;
	}

	public OracleConnection getConnFenix() {
		if (connFenix == null)
			conectarFenix();
		return connFenix;
	}

	public OracleConnection getConnTucan() {
		if (connTucan == null)
			conectarTucan();
		return connTucan;
	}

	public Connection getConnSICAF() {
		if (connSICAF == null)
			conectarSicaf();
		return connSICAF;
	}

	@Override
	public void conectarInformesPOS() {
		try {
			String url = properties.getProperty("dburl");
			String driver = properties.getProperty("driver");
			String user = properties.getProperty("dbuser");
			String pass = properties.getProperty("dbpassword");
			log.info("Conectando. URL: " + url + ", DRIVER: " + driver);
			connINFPOS = DriverManager.getConnection(url, user, pass);
			Class.forName(driver);
			log.info("Conexion exitosa con la base de datos.");
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
		log.info("Desconexión exitosa con la base de datos");
	}

	@Override
	public List<Almacen> getTiendas() {
		List<Almacen> lista = new LinkedList<Almacen>();
//		conectarInformesPOS();
		String sql = "SELECT ID, Nombre, IP, tomcatServer, UserData1, UserData2, UserData3, UserData4, UserData5 FROM TIENDAS_POS ORDER BY ID";

		// try-with-resources: cierra automáticamente las conexiones
		try (Connection con = getConnINFPOS(); PreparedStatement ps = con.prepareStatement(sql);) {
			try (ResultSet rs = ps.executeQuery();) {
				while (rs.next()) {
					Almacen almacen = new Almacen();
					String sID = rs.getString("ID");
					String sNombre = rs.getString("Nombre");
					String sIP = rs.getString("IP");
					String sTomcatServer = rs.getString("tomcatServer");
					String sUserData1 = rs.getString("UserData1");
					String sUserData2 = rs.getString("UserData2");
					String sUserData3 = rs.getString("UserData3");
					String sUserData4 = rs.getString("UserData4");
					String sUserData5 = rs.getString("UserData5");
					almacen.setCodigo(sID);
					almacen.setNombre(sNombre);
					almacen.setIP(sIP);
					almacen.setTomcatServer(sTomcatServer);
					almacen.setUserData1(sUserData1);
					almacen.setUserData2(sUserData2);
					almacen.setUserData3(sUserData3);
					almacen.setUserData4(sUserData4);
					almacen.setUserData5(sUserData5);
					lista.add(almacen);
				}
			}
		} catch (SQLException e) {
			log.error("Error trayendo las tiendas: ", e);
		}

		return lista;
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
	public void conectarTucan() {
		String url = properties.getProperty("TUCANurl");
		String user = properties.getProperty("TUCANusr");
		String passwd = properties.getProperty("TUCANpasswd");
		Properties info = new Properties();
	    info.put(OracleConnection.CONNECTION_PROPERTY_USER_NAME, user);
	    info.put(OracleConnection.CONNECTION_PROPERTY_PASSWORD, passwd);          
	    info.put(OracleConnection.CONNECTION_PROPERTY_DEFAULT_ROW_PREFETCH, "20");    

		try {
		    OracleDataSource ods = new OracleDataSource();
		    ods.setURL(url);    
		    ods.setConnectionProperties(info);
			connTucan = (OracleConnection) ods.getConnection();
			log.info("Conexion exitosa con la base de datos TUCAN.");
		} catch (Exception e) {
			log.error("Error Conectando con TUCAN: ", e);
		}
	}

	@Override
	public void desconectarTucan() {
		try {
			connTucan.close();
		} catch (Exception e) {
			log.error("Error cerrando conexion con TUCAN: ", e);
		}
		log.info("Desconexión exitosa con la base de datos TUCAN");
	}

	@Override
	public void conectarProspectos() {
		String url = properties.getProperty("HUELLASdburl");
		String driver = properties.getProperty("HUELLASdriver");
		String user = properties.getProperty("HUELLASdbuser");
		String passwd = properties.getProperty("HUELLASdbpassword");

		try {
			log.info("Conectando. URL: " + url + ", DRIVER: " + driver);
			connProspectos = DriverManager.getConnection(url, user, passwd);
			Class.forName(driver);
			log.info("Conexion exitosa con la base de datos ProspectosXcanal.");
		} catch (Exception e) {
			log.error("Error: ", e);
		}
	}

	@Override
	public void desconectarProspectos() {
		try {
			connProspectos.close();
		} catch (Exception e) {
			log.error("Error cerrando conexion con ProspectosXcanal: ", e);
		}
		log.info("Desconexión exitosa con la base de datos ProspectosXcanal");
	}

	@Override
	public List<Tender> getTenders() {
		List<Tender> lista = new LinkedList<Tender>();
		ResultSet rs = null;
		conectarLoyalty();
		try {
			Statement st = connLyty.createStatement();
			rs = st.executeQuery("select PAYMENT_ID, PAYMENT_DESC from PAYMENTDESC WHERE LNG_CODE = 'ES  '");
			while (rs.next()) {
				Tender tender = new Tender();
				String sID = rs.getString("PAYMENT_ID");
				String sNombre = rs.getString("PAYMENT_DESC");
				tender.setCodigo(sID);
				tender.setDescripcion(sNombre);
				lista.add(tender);
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

		return lista;
	}

	@Override
	public void conectarSicaf() {
		try {
			String url = properties.getProperty("SICAFdburl");
			String driver = properties.getProperty("SICAFdriver");
			log.info("Conectando. URL: " + url + ", DRIVER: " + driver);
			DriverManager.setLoginTimeout(10);
			connSICAF = DriverManager.getConnection(url);
			Class.forName(driver);
			log.info("Conexion exitosa con la base de datos SICAF.");
		} catch (Exception e) {
			log.error("Error: ", e);
		}
	}

	@Override
	public void desconectarSicaf() {
		try {
			connSICAF.close();
		} catch (Exception e) {
			log.error("Error cerrando conexion: ", e);
		}
		log.info("Desconexión exitosa con la base de datos SICAF");
	}

	@Override
	public void conectarMercadeo() {
		try {
			String url = properties.getProperty("MERCADEOdburl");
			String driver = properties.getProperty("MERCADEOdriver");
			log.info("Conectando. URL: " + url + ", DRIVER: " + driver);
			connMERCADEO = DriverManager.getConnection(url);
			Class.forName(driver);
			log.info("Conexion exitosa con la base de datos MERCADEO.");
		} catch (Exception e) {
			log.error("Error: ", e);
		}
	}

	@Override
	public void desconectarMercadeo() {
		try {
			connMERCADEO.close();
		} catch (Exception e) {
			log.error("Error cerrando conexion: ", e);
		}
		log.info("Desconexión exitosa con la base de datos MERCADEO");
	}

	@Override
	public void conectarFenix() {
		String url = properties.getProperty("FENIXurl");
		String user = properties.getProperty("FENIXusr");
		String passwd = properties.getProperty("FENIXpasswd");
		Properties info = new Properties();
	    info.put(OracleConnection.CONNECTION_PROPERTY_USER_NAME, user);
	    info.put(OracleConnection.CONNECTION_PROPERTY_PASSWORD, passwd);          
	    info.put(OracleConnection.CONNECTION_PROPERTY_DEFAULT_ROW_PREFETCH, "20");    

		try {
		    OracleDataSource ods = new OracleDataSource();
		    ods.setURL(url);    
		    ods.setConnectionProperties(info);
			connFenix = (OracleConnection) ods.getConnection();
			log.info("Conexion exitosa con la base de datos FÉNIX.");
		} catch (Exception e) {
			log.error("Error Conectando con Fénix: ", e);
		}
	}

	@Override
	public void desconectarFenix() {
		try {
			connFenix.close();
		} catch (Exception e) {
			log.error("Error cerrando conexion con FÉNIX: ", e);
		}
		log.info("Desconexión exitosa con la base de datos FÉNIX");
	}	

	@Override
	public String getPrecioFuturo(String sCodigo, String sFecha, String stCodigoAlmacen) {
		String respuesta = null;

		ResultSet rs = null;
		String sVista = "SELECT " + properties.getProperty("FENIXVistaPrecioFuturo");
		sVista = sVista + "("+  Integer.parseInt(stCodigoAlmacen) + "," + sCodigo + ", TO_DATE('" + sFecha + "', 'DD/MM/YYYY')) PVP FROM DUAL;";
		log.info("Consulta precio futuro: " + sVista);
		conectarFenix();
		try {
			Statement st = connFenix.createStatement();
			rs = st.executeQuery(sVista);
			rs.next();
			respuesta = rs.getString("PVP");
			if(Integer.parseInt(respuesta) < 0)
				return "0";
		} catch (Exception e) {
			return "0";
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException localSQLException) {
				}
		}
		desconectarFenix();

		return respuesta;
	}

	@Override
	public String getDescricionArticulo(String sCodigo) {
		String respuesta = null;

		ResultSet rs = null;
		String sql = "SELECT DESCRIPCION FROM TARTICULOS WHERE EAN LIKE '" + sCodigo + "%'";
		conectarSicaf();
		try {
			Statement st = connSICAF.createStatement();
			rs = st.executeQuery(sql);
			rs.next();
			respuesta = rs.getString("DESCRIPCION");
		} catch (Exception e) {
			return "0";
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException localSQLException) {
				}
		}
		desconectarSicaf();

		return respuesta;
	}

	@Override
	public String getCuotaSafix(String sPlazo, String sValor, String sModalidad, String sTienda) {
		String respuesta = "0";
		ResultSet rs = null;
		String sVista = "EXECUTE " + properties.getProperty("SICAFVistaCuota");
		sVista = sVista + " '" + sPlazo + "', '" + sValor + "', '" + sModalidad + "', '" + sTienda + "'";
		log.info("Consulta cuota Safix: " + sVista);
		conectarSicaf();
		try {
			Statement st = connSICAF.createStatement();
			rs = st.executeQuery(sVista);
			rs.next();
			respuesta = rs.getString("VALOR");
		} catch (Exception e) {
			log.error("Error:", e);
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException localSQLException) {
				}
		}
		desconectarSicaf();

		return respuesta;
	}

	@Override
	public String getCuotaMefia(CuotaMefia cuotaMefia) {
		String respuesta = "0";
		try {
			ManejadorConexionMefiaWS conMefiaSW = new ManejadorConexionMefiaWS();
			return conMefiaSW.getCuotaMefia(cuotaMefia);
		} catch (AxisFault | MalformedURLException | ServiceException e) {
			log.info("Error calculando cuota Mefia");
		}
		return respuesta;

	}

	@Override
	public String getDisponibleMefia(String sCliente) {
		String respuesta = "0|0";
		ResultSet rs = null;
		String sVista = "EXECUTE " + properties.getProperty("SICAFVistaDisponible") + " '" + sCliente + "'";
		log.info("Consulta disponible Mefia: " + sVista);
		conectarSicaf();
		try {
			Statement st = connSICAF.createStatement();
			rs = st.executeQuery(sVista);
			rs.next();
			respuesta = rs.getString("CONSUMOS_ACTIVOS") + "|" + rs.getString("DISPONIBLE");
		} catch (Exception e) {
			log.error("Error:", e);
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException localSQLException) {
				}
		}
		desconectarSicaf();

		return respuesta;
	}

	@Override
	public ClienteSicaf getClienteSicaf(String tipoDoc, String cliente) {
		ClienteSicaf clienteSicaf = new ClienteSicaf();
		clienteSicaf.setClienteID(cliente);
		clienteSicaf.setTipoDoc(tipoDoc);
		ResultSet rs = null;
		String sVista = "EXECUTE " + properties.getProperty("SICAFVistaCliente");
		sVista = sVista + " '" + tipoDoc + "', '" + cliente + "'";
		log.info("Vista getClienteSicaf: " + sVista);
		conectarSicaf();
		try {
			Statement st = connSICAF.createStatement();
			rs = st.executeQuery(sVista);
			rs.next();
			if (rs != null) {
				clienteSicaf.setClienteName(rs.getString("NOMBRE"));
				clienteSicaf.setClienteCupo(rs.getInt("DISPONIBLE"));
				clienteSicaf.setClienteBloqueo(rs.getString("BLOQUEO"));
				clienteSicaf.setDocumentacionImpresa(rs.getString("documentacionImpresa"));
				clienteSicaf.setDocumentosCustodia(rs.getString("documentosCustodia"));
				clienteSicaf.setActualizado(rs.getString("ACTUALIZADO"));
				clienteSicaf.setFechaActualizado(rs.getDate("FechaActualizacion"));
				clienteSicaf.setNroCelular(rs.getString("CELULAR"));
				clienteSicaf.seteMail(rs.getString("EMAIL"));
				clienteSicaf.setNug(rs.getString("NUG"));
				clienteSicaf.setApto(rs.getString("APTO"));
				clienteSicaf.setCupoMefia(getCupoMefia(cliente));
				clienteSicaf.setProximaCuota(rs.getDate("PROX_CUOTA"));
			}
		} catch (Exception e) {
			log.error("Error:", e);
			clienteSicaf.setClienteName(null);
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException localSQLException) {
				}
		}
		desconectarSicaf();

		return clienteSicaf;
	}

	private int getCupoMefia(String sCliente) {
		ResultSet rs = null;
		int cupo = 0;
		String vista = properties.getProperty("TUCANVistaCuotaManejo");
		String sentencia = "SELECT DIS_MAS_EXTRACUPO FROM " + vista + " WHERE CEDULA = '" + Util.zeroPad(sCliente,12) + "'";
		log.info("Vista getCupoMefia: " + sentencia);
		conectarTucan();
		try {
			Statement st = connTucan.createStatement();
			rs = st.executeQuery(sentencia);
			rs.next();
			cupo = rs.getInt("DIS_MAS_EXTRACUPO");
		} catch (Exception e) {
			log.error("Error trayendo cupo de Mefia: " + e);
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException se) {
					
				}
		}
		desconectarTucan();
		log.info("Cupo con extracupo: " + cupo);
		return cupo;
	}

	@Override
	public void sendNewCustomer(NewCustomer newCustomer) {
		ResultSet rs = null;
		String sentencia = "EXECUTE " + properties.getProperty("HUELLASVistaClienteNuevo");
		sentencia = sentencia + " '" + newCustomer.getCajero() + "', '" + newCustomer.getCliente() + "','" + newCustomer.getApellido1() + "','"
				+ newCustomer.getApellido2() + "','" + newCustomer.getNombre1() + "','" + newCustomer.getNombre2() + "','" + newCustomer.getTelefono()
				+ "','" + newCustomer.geteMail() + "','" + newCustomer.getPrioridad() + "','" + newCustomer.getTienda() + "','" + "101'";
		System.out.println("Vista: " + sentencia);
		conectarProspectos();
		try {
			Statement st = connProspectos.createStatement();
			rs = st.executeQuery(sentencia);
		} catch (Exception e) {
			log.error("Error:", e);
		}

		desconectarProspectos();
	}

	@Override
	public JTable getInventario(String sCodigo, String sTienda) {
		ResultSet rs = null;

		String[] columns = new String[] { "DESCRIPCIÓN", "INVENTARIO" };
		int i = 0;
		String vista = properties.getProperty("FENIXVistaInventario");

		JTable respuesta = null;
		String sentencia = "SELECT NOMBRESUCURSAL, STOCKDISPONIBLE FROM " + vista + " WHERE CODIGOEANPOS = " + sCodigo;
		sentencia = sentencia + " UNION SELECT '_TOTAL COMPAÑÍA', SUM(STOCKDISPONIBLE) FROM " + vista + " WHERE CODIGOEANPOS = " + sCodigo;
		log.info("Vista: " + sentencia);
		conectarFenix();
		try {
			Statement st = connFenix.createStatement();
			rs = st.executeQuery(sentencia);

			Object[][] inventario = new Object[80][2];

			while (rs.next() && i < 80) {
				inventario[i][0] = rs.getString(1);
				inventario[i][1] = rs.getString(2);
				i++;
			}
			respuesta = new JTable(inventario, columns);
			return respuesta;
		} catch (Exception e) {
			System.out.println("Error: " + e);
			log.error("Error:", e);
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException localSQLException) {
				}
		}
		desconectarFenix();
		return respuesta;
	}

	@Override
	public JTable getPromos(String sCodigo, String sTienda) {
		ResultSet rs = null;

		String[] columns = new String[] { "PROMOCIÓN", "TIPO BENEFICIO", "FECHA INICIO", "FECHA FIN" };
		Object[][] promos = new Object[35][4];
		int i = 0;
		JTable respuesta = null;

		String sentencia = "EXECUTE " + properties.getProperty("LTYTVistaPromos");
		sentencia = sentencia + " '" + sCodigo + "', '" + Util.zeroPad(sTienda, 5) + "', '" + "001'"; // caja 1
		conectarLoyalty();
		try {
			Statement st = connLyty.createStatement();
			rs = st.executeQuery(sentencia);
			while (rs.next() && i < 35) {
				promos[i][0] = rs.getString(1);
				promos[i][1] = rs.getString(2);
				promos[i][2] = rs.getString(3);
				promos[i][3] = rs.getString(4);
				i++;
			}
			respuesta = new JTable(promos, columns);
			return respuesta;
		} catch (Exception e) {
			System.out.println("Error recuperando promociones: " + e);
			log.error("Error recuperando promociones: ", e);
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException localSQLException) {
				}
		}
		desconectarLoyalty();
		return respuesta; // vale null si llega hasta acá
	}

	@Override
	public JTable getHistoriaCliente(String sCliente) {
		String sentencia = "SELECT C.CMP_DESC, CMP_STARTDATE, CMP_ENDDATE, SUM(AMOUNT) "
				+ "FROM CAMPAIGN C, ADVANTAGE A, AGR_LOYALTYCST AGR  LEFT JOIN TOTALSDEFDESC T ON T.CSTTOT_KEY = AGR.CSTTOT_KEY "
				+ "AND LNG_CODE = 'ENG' " + "WHERE C.CMP_ID=AGR.CMP_ID AND A.ADV_ID=AGR.ADV_ID AND AGR.CST_CODE='" + sCliente
				+ "' GROUP BY C.CMP_DESC, CMP_STARTDATE, CMP_ENDDATE, TOTALSDEF_DESC " + "ORDER BY CMP_STARTDATE DESC";
		ResultSet rs = null;
		String[] columns = new String[] { "CAMPAÑA", "FECHA INICIO", "FECHA FIN", "VALOR BENEFICIO" };
		Object[][] promos = new Object[100][4];
		int i = 0;
		double totalBeneficios = 0;
		JTable respuesta = null;

		System.out.println("Consulta historial: " + sentencia);
		conectarLoyalty();
		try {
			Statement st = connLyty.createStatement();
			rs = st.executeQuery(sentencia);
			while (rs.next() && i < 50) {
				promos[i][0] = rs.getString(1);
				promos[i][1] = rs.getString(2);
				promos[i][2] = rs.getString(3);
				promos[i][3] = Util.moneyFormat(rs.getString(4), 0);
				totalBeneficios = totalBeneficios + Double.parseDouble(rs.getString(4));
				i++;
			}
			promos[i][0] = "Cantidad Beneficios Obtenidos:";
			promos[i][1] = i;
			promos[i][2] = "Total Beneficios Obtenidos:";
			promos[i][3] = Util.moneyFormat(Double.toString(totalBeneficios), 2);
			respuesta = new JTable(promos, columns);
			return respuesta;
		} catch (Exception e) {
			System.out.println("Error recuperando promociones: " + e);
			log.error("Error recuperando promociones: ", e);
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException localSQLException) {
				}
		}
		desconectarLoyalty();
		return respuesta; // vale null si llega hasta acá
	}

	@Override
	public JTable getResumenCliente(String sCliente) {
		String sentencia = "SELECT YEAR( LOG_TRXDATE), MONTH( LOG_TRXDATE), SUM(LOG_REMISE) FROM LOG_HEADER "
				+ "WHERE CST_CODE = '" + sCliente + "' AND LOG_REMISE <> 0 AND YEAR(LOG_TRXDATE) > 2013"
				+ "GROUP BY YEAR( LOG_TRXDATE), MONTH( LOG_TRXDATE)"
		        + "ORDER BY YEAR( LOG_TRXDATE), MONTH( LOG_TRXDATE)";
		ResultSet rs = null;
		String[] columns = new String[] { "AÑO", "MES", "BENEFICIOS" };
		Object[][] promos = new Object[100][3];
		int i = 0;
		double totalBeneficios = 0;
		JTable respuesta = null;

		System.out.println("Consulta historial: " + sentencia);
		conectarLoyalty();
		try {
			Statement st = connLyty.createStatement();
			rs = st.executeQuery(sentencia);
			while (rs.next() && i < 100) {
				promos[i][0] = rs.getString(1);
				promos[i][1] = rs.getString(2);
				promos[i][2] = Util.moneyFormat(rs.getString(3), 0);
				totalBeneficios = totalBeneficios + Double.parseDouble(rs.getString(3));
				i++;
			}
			promos[i][0] = "TOTAL";
			promos[i][1] = "=";
			promos[i][2] = Util.moneyFormat(Double.toString(totalBeneficios), 2);
			respuesta = new JTable(promos, columns);
			return respuesta;
		} catch (Exception e) {
			System.out.println("Error recuperando promociones: " + e);
			log.error("Error recuperando promociones: ", e);
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException localSQLException) {
				}
		}
		desconectarLoyalty();
		return respuesta; // vale null si llega hasta acá
	}

	public JTable getReferenciasCliente(String sCliente) {
		ResultSet rs = null;

		String[] columns = new String[] { "ALMACÉN", "CANTIDAD", "ÚLTIMA REFERENCIA" };
		Object[][] refes = new Object[20][3];
		int i = 0;
		JTable respuesta = null;

		String sentencia = "EXECUTE " + properties.getProperty("MERCADEOVistaReferenciasCliente");
		sentencia = sentencia + " '" + sCliente + "'";
		conectarMercadeo();
		try {
			Statement st = connMERCADEO.createStatement();
			rs = st.executeQuery(sentencia);
			while (rs.next() && i < 20) {
				refes[i][0] = rs.getString(1);
				refes[i][1] = rs.getString(2);
				refes[i][2] = rs.getString(3);
				i++;
			}
			respuesta = new JTable(refes, columns);
			return respuesta;
		} catch (Exception e) {
			System.out.println("Error recuperando referencias: " + e);
			log.error("Error recuperando referencias: ", e);
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException localSQLException) {
				}
		}
		desconectarMercadeo();
		return respuesta; // vale null si llega hasta acá
	}

	@Override
	public JTable getVista360Cliente(String sCliente) {
		ResultSet rs = null;
		JTable respuesta = null;
		String[] columns = new String[] { "ACTIVIDAD", "VALOR" };

		String sentencia = "EXECUTE " + properties.getProperty("INFORMESPOSVista360Cliente");
		sentencia = sentencia + " '" + sCliente + "'";
		log.debug("Consulta Vista 360: " + sentencia);
		conectarInformesPOS();
		try {
			Statement st = connINFPOS.createStatement();
			rs = st.executeQuery(sentencia);
			ResultSetMetaData rsmd = rs.getMetaData();
			rs.next();
			int columnCount = rsmd.getColumnCount();
			Object[][] actividad = new String[columnCount][2];

			for (int i = 1; i <= columnCount; i++) {
				actividad[i - 1][0] = rsmd.getColumnName(i);
				actividad[i - 1][1] = rs.getString(i);
			}

			respuesta = new JTable(actividad, columns);
			return respuesta;
		} catch (Exception e) {
			log.error("Error recuperando información del cliente: ", e);
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException localSQLException) {
				}
		}
		desconectarInformesPOS();
		return respuesta; // vale null si llega hasta acá }
	}

	@Override
	public Usuario getUsuario(String sUsuario, String sPassword) {
		Usuario usuario = new Usuario();
		String sentencia = "EXECUTE PRC_VALIDAR_USUARIO_GENERICO '" + sUsuario + "', '" + sPassword + "', 'COTIZADOR'";
		log.debug("Validación del login: " + sentencia);
		ResultSet rs = null;
		conectarSicaf();
		try {
			Statement st = connSICAF.createStatement();
			rs = st.executeQuery(sentencia);
			rs.next();
			String estado = rs.getString("ESTADO");
			if (estado.equals("A")) {
				sentencia = "SELECT CEDULA, PERFIL, NOMBRE, APELLIDO, ALMACEN FROM TUSUARIOS WHERE CEDULA = '";
				sentencia = sentencia + sUsuario + "' AND APLICACION = 'COTIZADOR'";
				log.debug("Validación del perfil: " + sentencia);
				rs.close();
				rs = st.executeQuery(sentencia);
				rs.next();
				if (rs != null) {
					usuario.setCedula(rs.getString("CEDULA").trim());
					usuario.setNombre(rs.getString("NOMBRE").trim());
					usuario.setApellido(rs.getString("APELLIDO").trim());
					usuario.setSitio(rs.getString("ALMACEN").trim());
					usuario.setPerfil(Integer.parseInt(rs.getString("PERFIL").trim()));
					usuario.setOpcionesPerfil(getOpcionesPerfil(usuario.getPerfil()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException localSQLException) {
				}
		}

		desconectarSicaf();
		return usuario;
	}

	@Override
	public int getOpcionesPerfil(int perfil) {
		int accesos = 0;
		String sentencia = "SELECT PERMISOS FROM TPERFILES WHERE CAPLICACION = '01' AND PERFIL = " + perfil;
		ResultSet rs = null;
		conectarSicaf();
		try {
			Statement st = connSICAF.createStatement();
			rs = st.executeQuery(sentencia);
			rs.next();
			accesos = rs.getInt("PERMISOS");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException localSQLException) {
				}
		}
		desconectarSicaf();
		return accesos;
	}

	@Override
	public List<OpcionesAplicacion> getOpcionesAplicacion() {
		List<OpcionesAplicacion> lista = new LinkedList<OpcionesAplicacion>();
		ResultSet rs = null;
		conectarSicaf();
		try {
			Statement st = connSICAF.createStatement();
			rs = st.executeQuery("SELECT ID_OPCION, DESCRIPCION, BIT FROM TAPLICACIONES_OPCIONES WHERE caplicacion = '01'");
			while (rs.next()) {
				OpcionesAplicacion opciones = new OpcionesAplicacion();
				opciones.setIdOpcion(rs.getInt("ID_OPCION"));
				opciones.setDescripcion(rs.getString("DESCRIPCION"));
				opciones.setBit(rs.getInt("BIT"));
				lista.add(opciones);
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
		desconectarSicaf();
		return lista;
	}

	@Override
	public String getIDCotizacion(String sTienda) {
		String consecutivo = "0";
		String sentenciaConsecutivo = "EXECUTE PRC_GENERAR_CONSECUTIVO_COTIZACION '" + Util.zeroPad(sTienda, 4) + "'";
		String cotizacionID = "9" + Util.zeroPad(sTienda, 3) + "000000";

		ResultSet rs = null;
		log.info("Consulta consecutivo de cotizacion: " + sentenciaConsecutivo);
		conectarSicaf();
		try {
			Statement st = connSICAF.createStatement();
			rs = st.executeQuery(sentenciaConsecutivo);
			rs.next();
			consecutivo = rs.getString("CONSENUM");
			cotizacionID = "9" + Util.zeroPad(sTienda, 3) + Util.zeroPad(consecutivo, 6);
		} catch (Exception e) {
			log.error("Error:", e);
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException localSQLException) {
				}
		}
		desconectarSicaf();
		log.info("ID obtenido: " + cotizacionID);
		return cotizacionID;
	}

	@Override
	public Cotizacion getCotizacionCliente(String sCliente, String sFecha, String sTienda) {
		Cotizacion cotizacion = null;
		ClienteSicaf clienteSicaf = getClienteSicaf("CC", sCliente);
		Almacen almacen = new Almacen(sTienda);
		conectarSicaf();
		String sql = "SELECT * FROM TCOTIZACION_ENC WHERE CEDULA = '" + sCliente + "' AND FECHA = '" + sFecha + "' AND CALMACEN = '" + sTienda + "' AND ESTADO = 1";
		log.info("Consulta cotizacion cliente con esta consulta " + sql);
		try {
			Connection con = getConnSICAF();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();
			if (rs != null) {
				String cotizacionID = rs.getString("COTIZACION");
				String meses = rs.getString("CUOTAS");
				int nivel = rs.getInt("NIVEL");
				String valor = Util.moneyFormat(rs.getString("VALOR"), 0);
				String descuento = Util.moneyFormat(rs.getString("DESCUENTO"), 0);
				String listaMedios = rs.getString("MEDIOS_PAGO");
				TenderTableModel modeloMP = Auxiliar.getModeloMP(listaMedios);
				ProductosTableModel modeloPR = getCotizacionDetalle(cotizacionID);
				cotizacion = new Cotizacion(clienteSicaf, almacen, sFecha, valor, descuento, meses, "0", "0", null, null, false, modeloMP, modeloPR, cotizacionID, "0");
				cotizacion.setCotizacionID(cotizacionID);
				cotizacion.setNivel(nivel);
				cotizacion.setEstado(1);
			}
		} catch (SQLException e) {
			log.error("Error trayendo informacion de la cotizacion del cliente " + sCliente);
		}

		desconectarSicaf();
		return cotizacion;
	}

	private ProductosTableModel getCotizacionDetalle(String cotizacionID) {
		ProductosTableModel modeloPR = new ProductosTableModel();
		ProductosTableControl controlPR = null;
		controlPR = new ProductosTableControl(modeloPR);
		String sql = "SELECT * FROM TCOTIZACION_DET WHERE COTIZACION = '" + cotizacionID + "'";
		log.info("Consulta detalle cotizacion con esta consulta " + sql);
		try (Connection con = getConnSICAF(); PreparedStatement ps = con.prepareStatement(sql);) {
			try (ResultSet rs = ps.executeQuery();) {
				while (rs.next()) {
					Producto producto = new Producto();
					producto.setItemCode(rs.getString("CODIGO"));
					producto.setQuantity(rs.getInt("CANTIDAD"));
					producto.setItemPrice(Util.moneyFormat(rs.getString("PRECIO"), 0));
					producto.setItemDesc(rs.getString("DESCRIPCION"));
					producto.setEventoFenix(rs.getInt("EVENTO"));
					producto.setVendedor(rs.getString("VENDEDOR"));
					controlPR.addRow(producto);
				}
			}
		} catch (SQLException e) {
			log.error("Error consultando detalle de la cotizacion: " + cotizacionID, e);
		}
		return modeloPR;
	}

	@Override
	public boolean sendCotizacion(Cotizacion cotizacion, ArrayList<DetalleCotizacion> detalle) {
		boolean estado = false;
		if(cotizacion.getCliente().getClienteID().compareTo("9999999999999999999") == 0)
			return estado; // no se guardan cotizaciones de clientes genéricos
		ResultSet rs = null;
		conectarSicaf();
		try {
			Statement st = connSICAF.createStatement();
			String cotizacionID = cotizacion.getCotizacionID();
			String esClienteNuevo = cotizacion.isClienteNuevo() == true ? "S" : "N";
			String mediosDePago = Auxiliar.obtieneListaMediosDePago(cotizacion.getModeloMP());
			String sCliente = Util.zeroPad(cotizacion.getCliente().getClienteID(), 12);
			String sFecha = Util.getDateTime().substring(0, 8);
			String sTienda = Util.zeroPad(cotizacion.getTienda().getCodigo(), 2);
			
			String sentenciaHeader = "INSERT INTO TCOTIZACION_ENC (COTIZACION, CEDULA, FECHA, HORA, CALMACEN,"
					+ "CUOTAS, MEDIOS_PAGO, VALOR, DESCUENTO, REMISION, EVENTO, INGRESO_DATOS, CUSUARIO," + "ESTADO, NIVEL) " + "VALUES ("
					+ cotizacionID + ", " + sCliente + ", '" + sFecha
					+ "', '" + Util.getTime().substring(0, 5) + "', '" + sTienda + "', "
					+ cotizacion.getMeses() + ", '" + mediosDePago + "', " + Util.removeMoneyFormat(cotizacion.getValor()) + ", "
					+ Util.removeMoneyFormat(cotizacion.getDescuento()) + ", null, null, '" + esClienteNuevo + "', '"
					+ System.getProperty("user.name") + "', " + cotizacion.getEstado() + ", " + cotizacion.getNivel() + ")";
			log.info("Se inserta Encabezado de cotización: " + sentenciaHeader);

			st.executeUpdate(sentenciaHeader);
			for (DetalleCotizacion dc : detalle) {
				String sentenciaDetail = "INSERT INTO TCOTIZACION_DET (COTIZACION, CODIGO, CANTIDAD, PRECIO, DESCONTABLE, VENDEDOR, DESCRIPCION, EVENTO)" + "VALUES ("
						+ cotizacionID + ", " + dc.toSendDB() + ")";
				log.info("Se inserta Detalle de cotización: " + sentenciaDetail);
				st.executeUpdate(sentenciaDetail);
			}
			estado = true;

		} catch (Exception e) {
			log.error("Error:", e);
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException localSQLException) {
				}
		}
		desconectarSicaf();
		return estado;
	}

	@Override
	public void closeCotizacion(String sCarritoRecuperado) {
		ResultSet rs = null;
		conectarSicaf();
		try {
			Statement st = connSICAF.createStatement();
			
			String sentenciaClose = "UPDATE TCOTIZACION_ENC SET ESTADO = 2 WHERE COTIZACION = '" + sCarritoRecuperado + "'";
			log.info("Se cierra cotización: " + sentenciaClose);
			st.executeUpdate(sentenciaClose);

		} catch (Exception e) {
			log.error("Error:", e);
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException localSQLException) {
				}
		}
		desconectarSicaf();
	}

	@Override
	public void delCotizacion(String sCarritoRecuperado) {
		ResultSet rs = null;
		conectarSicaf();
		try {
			Statement st = connSICAF.createStatement();
			
			String sentenciaClose = "DELETE FROM TCOTIZACION_DET WHERE COTIZACION = '" + sCarritoRecuperado + "'";
			st.executeUpdate(sentenciaClose);
			sentenciaClose = "DELETE FROM TCOTIZACION_ENC WHERE COTIZACION = '" + sCarritoRecuperado + "'";
			st.executeUpdate(sentenciaClose);
			log.info("Se borra cotización: " + sentenciaClose);

		} catch (Exception e) {
			log.error("Error:", e);
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException localSQLException) {
				}
		}
		desconectarSicaf();
	}
	
	@Override
	public boolean existeCotizacion(String sCotizacion, String sCliente) {
		boolean existe = false;
		conectarSicaf();
		try {
			String sentencia = "SELECT COTIZACION FROM TCOTIZACION_ENC WHERE COTIZACION = '" + sCotizacion + "' AND CEDULA = '" + sCliente + "'";
			log.info("¿Existe cotización?: " + sentencia);
			Connection con = getConnSICAF();
			Statement st = connSICAF.createStatement();
			PreparedStatement ps = con.prepareStatement(sentencia);
			ResultSet rs = ps.executeQuery();
			rs.next();
			if (rs != null) {
				existe = true;
			}
		} catch (Exception e) {
			log.error("Error:", e);
			e.printStackTrace();
		}
		desconectarSicaf();
		return existe;
	}

	@Override
	public void sendOTP(String eMail) {
		ResultSet rs = null;
		conectarSicaf();
		try {
			Statement st = connSICAF.createStatement();
			String sentencia = "EXECUTE " + properties.getProperty("SICAFCorreoOTP") + " '" + eMail + "'";
			log.info("Envío OTP: " + sentencia);
			st.execute(sentencia);
		} catch (Exception e) {
			log.error("Error:", e);
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException localSQLException) {
				}
		}
		desconectarSicaf();
	}

	@Override
	public void sendEmailAprobacion(String eMail, InfoAprobacion infoAprobacion) {
		ResultSet rs = null;
		conectarSicaf();
		String numeroAprobacion = infoAprobacion.getNumeroAprobacion().getValue();
		BigDecimal numeroCuotas = infoAprobacion.getNumeroCuotas();
		BigDecimal valorAprobacion = infoAprobacion.getValorAprobacion();
		try {
			Statement st = connSICAF.createStatement();
			String sentencia = "EXECUTE " + properties.getProperty("SICAFCorreoAprobacion") + " '" + eMail + "', '" + numeroAprobacion + "', '"
					+ valorAprobacion + "', '" + numeroCuotas + "'";
			log.info("Envío OTP: " + sentencia);
			st.execute(sentencia);
		} catch (Exception e) {
			log.error("Error:", e);
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException localSQLException) {
				}
		}
		desconectarSicaf();
	}

	@Override
	public List<EventoCredito> getEventosCredito(String sTienda, String sModalidad, String sCliente) {
		List<EventoCredito> lista = new LinkedList<EventoCredito>();
		if(Integer.parseInt(sTienda) < 100) 
			sTienda = sTienda.substring(1);

		String sql = "EXECUTE " + properties.getProperty("SICAFVistaEventos") + " '" + sTienda + "', '" + sModalidad + "', '"
				+ sCliente + "'";

		// try-with-resources: cierra automáticamente las conexiones
		try (Connection con = getConnSICAF(); PreparedStatement ps = con.prepareStatement(sql);) {
			try (ResultSet rs = ps.executeQuery();) {
				while (rs.next()) {
					EventoCredito evento = new EventoCredito();
					evento.setZona(rs.getString("ZONA"));
					evento.setCodigo(rs.getString("CEVENTO"));
					evento.setDescripcion(rs.getString("EVENTO"));
					evento.setFechaInicio(rs.getDate("INICIO"));
					evento.setFechaFin(rs.getDate("FIN"));
					evento.setMeses(rs.getShort("MESES"));
					evento.setDefecto(rs.getString("DEFECTO"));
					evento.setAutomatico(rs.getString("AUTOMATICO"));
					evento.setSegmento(rs.getString("SEGMENTO"));
					evento.setValor(rs.getLong("VALOR"));
					lista.add(evento);
				}
			}
		} catch (SQLException e) {
			log.error("Error trayendo los eventos de crédito: ", e);
		}
		return lista;
	}

	@Override
	public int getGrupo(String sCodigo) {
		String sentencia = "SELECT A.EAN,ASO.CGRUPO FROM TARTICULOS A INNER JOIN TASOCIACION ASO";
		sentencia = sentencia + " ON (A.CASOCIACION = ASO.CASOCIACION) WHERE A.EAN LIKE '" + sCodigo + "%'";
		int respuesta = 0;
		try (Connection con = getConnSICAF(); PreparedStatement ps = con.prepareStatement(sentencia);) {
			try (ResultSet rs = ps.executeQuery();) {
				rs.next();
				respuesta = rs.getInt("CGRUPO");
			}
		} catch (SQLException e) {
			log.error("Error consultando grupo del artículo: ", e);
		}
		return respuesta;
	}

	@Override
	public void conectarExternal() {
		  try {
			String url = properties.getProperty("ExternalDBUrl");
			String driver = properties.getProperty("ExternalDBDriver");
			String user = properties.getProperty("ExternalDBUser");
			String pass = properties.getProperty("ExternalDBPassword");
			log.info("Conectando. URL: " + url + ", DRIVER: " + driver);
			org.postgresql.Driver.isRegistered();
			connExternal = DriverManager.getConnection(url, user, pass);
//			Class.forName(driver);
			log.info("Conexion exitosa con la base de datos External.");
		} catch (SQLException e) {
			log.error("Error: ", e);
		}
	}

	public Connection getConnExternal() {
		if (connExternal == null)
			conectarExternal();
		return connExternal;
	}

	@Override
	public void desconectarExternal() {
		try {
			connExternal.close();
		} catch (Exception e) {
			log.error("Error cerrando conexion: ", e);
		}
		log.info("Desconexión exitosa con la base de datos External");
	}

	@Override
	public String getExternalProperty(String modulo, String clave) {
		String sentencia = "SELECT VALOR FROM PROPIEDADES_APLICACIONES WHERE APLICACION = 'COTIZADOR' AND MODULO = '";
		sentencia = sentencia + modulo + "' AND CLAVE = '" + clave + "' AND ESTADO = 0";
		String respuesta = null;
		conectarExternal();
		try (Connection con = getConnExternal(); PreparedStatement ps = con.prepareStatement(sentencia);) {
			try (ResultSet rs = ps.executeQuery();) {
				rs.next();
				respuesta = rs.getString("valor");
			}
		} catch (SQLException e) {
			log.error("Error consultando llave externa: " + modulo + " - " + clave, e);
		}
		return respuesta;
	}

	@Override
	public String getEventosFinancieros() {
		try {
			return properties.getProperty("EventosFinancierosComodin");
		} catch (Exception e) {
			log.error("Error: ", e);
		}
		return null;
	}

	@Override
	public int sendeMailAlert(Cotizacion cotizacion, String mensaje) {
		String correo = "hcastaneda@flamingo.com.co";
		String bandeja = "COTIZADOR_F" + Util.zeroPad(cotizacion.getTienda().getCodigo(), 3);
		String tienda = cotizacion.getTienda().getNombre();
		String cedula = cotizacion.getCliente().getClienteID();
		String nombre = cotizacion.getCliente().getClienteName();
		String celular = cotizacion.getCliente().getNroCelular();
		String sentencia = "EXECUTE " + properties.getProperty("SICAFVistaCorreoAlerta") + " '" + correo + "', '" + mensaje + "', 'Alerta generada por Cotizador en ";
		sentencia = sentencia + tienda + "', '" + bandeja + "', '" + cedula + " " + nombre + " Celular:" + celular + "'";
		log.info("Envío de alerta de aumento de cupo: " + sentencia);
		int respuesta = 0;
		try (Connection con = getConnSICAF();) {
			try (Statement st = connSICAF.createStatement();) {
				st.executeUpdate(sentencia);
			}
		} catch (SQLException e) {
			log.error("Error consultando grupo del artículo: ", e);
			respuesta = -1;
		}
		return respuesta;
	}

	@Override
	public JTable getSegmentosClienteMotor(String sCliente) {
		ResultSet rs = null;

		String[] columns = new String[] { "PROMOCIÓN" };
		Object[][] promos = new Object[20][1];
		int i = 0;
		JTable respuesta = null;

		String sentencia = "EXECUTE " + properties.getProperty("LTYTVistaSegmentosClienteMotor");
		sentencia = sentencia + " '" + sCliente + "'" ;
		conectarLoyalty();
		try {
			Statement st = connLyty.createStatement();
			rs = st.executeQuery(sentencia);
			while (rs.next() && i < 20) {
				promos[i][0] = rs.getString(1);
				i++;
			}
			respuesta = new JTable(promos, columns);
			return respuesta;
		} catch (Exception e) {
			System.out.println("Error recuperando promociones por segmento: " + e);
			log.error("Error recuperando promociones por segmento: ", e);
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException localSQLException) {
				}
		}
		desconectarLoyalty();
		return respuesta; // vale null si llega hasta acá
	}

	@Override
	public JTable getProductAttrib(String sCodigo) {
		JTable respuesta = null;
		conectarFenix();
		String sql = "SELECT NOMBREATRIBUTO, VALOR FROM FENIX_CENTRAL.ATRIBUTOS_ARTICULOS_POS WHERE CODIGOEANPOS = " + sCodigo ;
		log.info("Consulta detalle cotizacion con esta consulta " + sql);
		try {
			String[] columns = new String[] { "ATRIBUTO", "VALOR" };
			int i = 0;
			Object[][] atributos = new Object [50][2];
			Connection con = getConnFenix();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				atributos[i][0] = rs.getString("NOMBREATRIBUTO");
				atributos[i][1] = rs.getString("VALOR");
				i++;
			}
			respuesta = new JTable(atributos, columns);
		} catch (SQLException e) {
			log.error("Error consultando atributos del artículo: " + sCodigo, e);
			desconectarSicaf();
		}
		desconectarFenix();
		return respuesta;
	}

	@Override
	public int getCuotaManejo(String sCliente) {
		ResultSet rs = null;
		int cuotaManejo = 0;
		String vista = properties.getProperty("TUCANVistaCuotaManejo");
		String sentencia = "SELECT CUOTA_MANEJO, VALOR_SEGURO FROM " + vista + " WHERE CEDULA = '" + Util.zeroPad(sCliente,12) + "'";
		log.info("Vista: " + sentencia);
		conectarTucan();
		try {
			Statement st = connTucan.createStatement();
			rs = st.executeQuery(sentencia);
			rs.next();
			cuotaManejo = rs.getInt("CUOTA_MANEJO") + rs.getInt("VALOR_SEGURO");
		} catch (Exception e) {
			log.error("Error trayendo cuota Manejo de Mefia: " + e);
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException se) {
					
				}
		}
		desconectarTucan();
		return cuotaManejo;	}

	@Override
	public Properties getPropertiesDB() {
	    Properties propertiesDB = new Properties();
		String datos = "";
		String sentencia = "SELECT MODULO, CLAVE, VALOR FROM PROPIEDADES_APLICACIONES WHERE APLICACION = 'COTIZADOR'";
		log.info("Consulta parámetros a PostgreSQL: " + sentencia);
		
		try (Connection con = getConnExternal(); PreparedStatement ps = con.prepareStatement(sentencia);) {
			try (ResultSet rs = ps.executeQuery();) {
				while (rs.next()) {
					datos = datos + rs.getString("MODULO") + "." + rs.getString("CLAVE") + "=" + rs.getString("VALOR") + "\n";
				}
			}
		} catch (SQLException e) {
			log.error("Error trayendo propiedades desde PostgerSQL: ", e);
		}
		
		try {
			StringReader input = new StringReader(datos);
			propertiesDB.load(input);
		} catch (IOException e) {
			log.error("Error trayendo propiedades desde PostgerSQL: ", e);
//			e.printStackTrace();
		}

		return propertiesDB;
	}

	@Override
	public String getSisteCreditoStore(String sTienda) {
		String sisteCreditoStore = "";
		String sql = "SELECT UserData1 FROM TIENDAS_POS WHERE ID = " + sTienda;
		conectarInformesPOS();
		try {
			Connection con = getConnINFPOS();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();
			sisteCreditoStore = rs.getString("UserData1");
		} catch (SQLException e) {
			log.error("Error trayendo ID SisteCrédito de la tienda: ", e);
		}
		desconectarInformesPOS();

		return sisteCreditoStore;
	}

	@Override
	public List<ArticuloRem> getSegurosProducto(String sCodigo, String sPrecio) {
		List<ArticuloRem> lista = new LinkedList<ArticuloRem>();
		
		int l = sCodigo.length();
		switch (l) {
		case 12: // EAN13 incompleto
			sCodigo = Util.getCompleteEAN13(sCodigo);
		case 11:
			sCodigo = sCodigo + Util.getCheckDigitUPC(Long.parseLong(sCodigo));
		case 7:
			sCodigo = sCodigo + Util.getCheckDigitUPC(Long.parseLong(sCodigo));
		}

		String sql = "EXECUTE PRC_CONSULTA_SERVICIOS '" + sCodigo + "', '" + Util.removeMoneyFormat(sPrecio) + "'";
		log.info("Consulta parámetros a PostgreSQL: " + sql);
		
		conectarSicaf();
		try (Connection con = getConnSICAF(); PreparedStatement ps = con.prepareStatement(sql);) {
			try (ResultSet rs = ps.executeQuery();) {
				while(rs.next()) {
					ArticuloRem articulo = new ArticuloRem();
					articulo.setPrecio(rs.getBigDecimal("PRECIO"));
					articulo.setEan(rs.getString("EAN"));
					articulo.setCantidad(new BigDecimal("1"));
					articulo.setDescripcion(rs.getString("DESCRIPCION"));
					lista.add(articulo);
				}
			}
		} catch (SQLException e ) {
			log.error("Error trayendo seguros: ", e);
		}
		desconectarSicaf();
		return lista;
	}
}
