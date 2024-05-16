package com.fla.devoluciones.implementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.fla.devoluciones.interfaz.DBServiceInterface;
import com.fla.devoluciones.model.Almacen;
import com.fla.devoluciones.model.EngageTransaction;
import com.fla.devoluciones.model.Producto;
import com.fla.devoluciones.util.Util;

public class DBServiceImplementation  implements DBServiceInterface {
	private static DBServiceImplementation dbServiceImpl;
	private Properties properties = Util.getProperties();
	private Connection connINFPOS;
	private Connection connLyty;
	private Logger log = Util.getLogger();

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
	public EngageTransaction getEngageTransaction(String stFecha, String stSiteCode, String stCaja, String stTrxNo, String stCardNo) {
		ResultSet rs = null;
		EngageTransaction engageTransaction = new EngageTransaction();
		conectarLoyalty();
		// Primero se consulta el header de la transacción:
		String headerSentence = "Select L.LOG_AUDIT, L.LOG_TRXDATE, L.LOG_OPE, L.LOG_AMOUNT, L.LOG_REMISE, C.CARD_NAME, C.CARD_FNAME";
		headerSentence = headerSentence + " from LOG_HEADER L Left Join CARD C On L.CARD_NO = C.CARD_NO";
		headerSentence = headerSentence + " Where LOG_TRXDATE > '" + stFecha + " 00:00:00' And LOG_TRXDATE < '" + stFecha + " 23:59:00' ";
		headerSentence = headerSentence + "And SITE_CODE='" + Util.zeroPad(stSiteCode, 5) + "' ";
		headerSentence = headerSentence + "And LOG_VALIDED = 1 And LOG_TRXNO Like '" + stTrxNo + "' ";
		headerSentence = headerSentence + "And LOG_TERMINAL = '" + stCaja + "' And L.CARD_NO Like '" + stCardNo + "%'";
		System.out.println("headerSentence: " + headerSentence);
		
		// Conaulta para el detalle de los artículos
		String productSentence = "Select L.PRD_CODE, L.PRDQTE, L.PRDPV, L.LOGF_TOTAL, L.LOGD_REMISE, P.PRD_DESC ";
		productSentence = productSentence + "From LOG_DETAIL L Left Join PRODUCT P On L.PRD_CODE=P.PRD_CODE ";
		try {
			Statement st = connLyty.createStatement();
			rs = st.executeQuery(headerSentence);
			if (rs.next()) {
				String sAuditNumber = rs.getString("LOG_AUDIT");
				String sTRXDate = rs.getString("LOG_TRXDATE");
				String sOperador = rs.getString("LOG_OPE");
				Double dAmount = Double.parseDouble(rs.getString("LOG_AMOUNT"));
				Double dRemise = Double.parseDouble(rs.getString("LOG_REMISE"));
				String sCardName = rs.getString("CARD_NAME");
				String sCardFName = rs.getString("CARD_FNAME");
				engageTransaction.setAuditNumber(sAuditNumber);
				engageTransaction.setCardNo(stCardNo);
				engageTransaction.setCardFName(sCardFName);
				engageTransaction.setCardName(sCardName);
				engageTransaction.setSiteCode(stSiteCode);
				engageTransaction.setTrxDate(sTRXDate);
				engageTransaction.setTerminal(stCaja);
				engageTransaction.setTrxNo(stTrxNo);
				engageTransaction.setOpe(sOperador);
				engageTransaction.setAmount(dAmount.longValue());
				engageTransaction.setRemise(dRemise.longValue());
				productSentence = productSentence + "Where L.LOG_AUDIT = '" + sAuditNumber + "' ";
				System.out.println("productSentence: " + productSentence);
				rs.close();
				rs = st.executeQuery(productSentence);
				List<Producto> productList = new LinkedList<Producto>();
				while (rs.next()) {
					Producto producto = new Producto();
					String sPrdCode = rs.getString("PRD_CODE");
					Double dPrdQte = Double.parseDouble(rs.getString("PRDQTE"));
					Double dPrdPv = Double.parseDouble(rs.getString("PRDPV"));
					Double dLogdRemise =  Double.parseDouble(rs.getString("LOGD_REMISE"));
					Double dTotal =  Double.parseDouble(rs.getString("LOGF_TOTAL")) - dLogdRemise;
					String sDescrip = rs.getString("PRD_DESC");
					producto.setItemCode(sPrdCode);
					producto.setItemPrice(dPrdPv.longValue());
					producto.setItemRemise(dLogdRemise.longValue());
					producto.setQuantity(dPrdQte.intValue());
					producto.setItemTotal(dTotal.longValue());
					producto.setItemDesc(sDescrip);
					productList.add(producto);
				}
				
				engageTransaction.setProductList(productList);
			} else
				return null;

			
		} catch (Exception e) {
			log.error("Error:", e);
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException localSQLException) {
					return null;
				}
		}
		desconectarLoyalty();
		return engageTransaction;
	}

	@Override
	public void conectarLoyalty() {
		try {
			String url = properties.getProperty("LYTYdburl");
			String driver = properties.getProperty("LYTYdriver");
			String user = properties.getProperty("LYTYdbuser");
			String pass = properties.getProperty("LYTYdbpassword");
			log.debug("Conectando. URL: " + url + ", DRIVER: " + driver + ", user: " + user + ", pass: " + pass);
			System.out.println("Conectando. URL: " + url + ", DRIVER: " + driver + ", user: " + user + ", pass: " + pass);
			connLyty = DriverManager.getConnection(url);
			Class.forName(driver);
			log.debug("Conexion exitosa con la base de datos.");
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
		log.debug("Desconexión exitosa con la base de datos");
	}

}
