package co.com.flamingo.queryTRX.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import co.com.flamingo.queryTRX.types.Almacen;
import co.com.flamingo.queryTRX.types.ItemDetail;
import co.com.flamingo.queryTRX.types.ItemList;
import co.com.flamingo.queryTRX.types.POSTransaction;
import co.com.flamingo.queryTRX.types.TenderDetail;
import co.com.flamingo.queryTRX.types.TenderList;
import co.com.flamingo.queryTRX.util.Util;

public class ServiceDAO {
	private static Connection connINFPOS;
	private static Connection connLyty;
	private static Connection connSICAF;
	private static Properties properties = Util.getProperties();

	public static void conectarInformesPOS() {
		try {
//			String url = properties.getProperty("InformesPOSUrl");
			String url = "jdbc:jtds:sqlserver://172.16.8.115:1433;databaseName=INFORMESPOS";
			System.out.println("URL: " + url);
			String driver = "net.sourceforge.jtds.jdbc.Driver";
			String user = "saldospos";
			String pass = "saldospos";
			System.out.println("Conectando. URL: " + url + ", DRIVER: " + driver);
			connINFPOS = DriverManager.getConnection(url, user, pass);
			Class.forName(driver);
			System.out.println("Conexion exitosa con la base de datos INFORMESPOS.");
		} catch (Exception e) {
			System.out.println("Error: ");
		}
	}

	public static Connection getConnSICAF() {
		if (connSICAF == null)
			conectarSicaf();
		return connSICAF;
	}
	
	public static void conectarSicaf() {
		try {
			String url = properties.getProperty("SICAFdburl");
			String driver = properties.getProperty("SICAFdriver");
			System.out.println("Conectando. URL: " + url + ", DRIVER: " + driver);
			DriverManager.setLoginTimeout(20);
			connSICAF = DriverManager.getConnection(url);
			Class.forName(driver);
			System.out.println("Conexion exitosa con la base de datos SICAF.");
		} catch (Exception e) {
			System.out.println("Error: " + e.getStackTrace());
		}
	}

	public static void desconectarSicaf() {
		try {
			connSICAF.close();
		} catch (Exception e) {
			System.out.println("Error cerrando conexion: " + e.getStackTrace());
		}
		System.out.println("Desconexión exitosa con la base de datos SICAF");
	}
	
	public static void desconectarInformesPOS() {
		try {
			connINFPOS.close();
		} catch (Exception e) {
			System.out.println("Error cerrando conexion: ");
		}
		System.out.println("Desconexión exitosa con la base de datos INFORMESPOS");
	}

	public static Connection getConnINFPOS() {
		if (connINFPOS == null)
			conectarInformesPOS();
		return connINFPOS;
	}

	public static void conectarLoyalty() {
		try {
			String url = properties.getProperty("LYTYdburl");
			String driver = "net.sourceforge.jtds.jdbc.Driver";
			System.out.println("Conectando. URL: " + url + ", DRIVER: " + driver);
			connLyty = DriverManager.getConnection(url);
			Class.forName(driver);
			System.out.println("Conexion exitosa con la base de datos.");
		} catch (Exception e) {
			System.out.println("Error: ");
			e.printStackTrace();
		}
	}

	public static void desconectarLoyalty() {
		try {
			connLyty.close();
		} catch (Exception e) {
			System.out.println("Error cerrando conexion: ");
			e.printStackTrace();
		}
		System.out.println("Desconexión exitosa con la base de datos");
	}

	public static String getSentenceLoyaltyPayment(String tienda, String caja, String transaccion) {
		tienda = String.format("%05d", Integer.parseInt(tienda));
		String sql = "SELECT '0' SIGNO,P.PAYMENT_ID MEDIO_PAGO,P.LOGP_AMOUNT VALOR,L.CARD_NO DOCID,'0' TARJETA, L.LOG_OPE OPERADOR ";
		sql = sql + "FROM LOG_HEADER L INNER JOIN LOG_PAYMENT P ON L.LOG_AUDIT = P.LOG_AUDIT WHERE L.SITE_CODE = '" + tienda;
		sql = sql + "' AND L.LOG_TERMINAL='" + caja.substring(caja.length() - 3) + "' AND L.LOG_TRXNO='" + transaccion + "'";
		sql = sql + " AND CONVERT(varchar,L.LOG_TRXDATE,12) = CONVERT(varchar,GETDATE(),12)";
		System.out.println("Consulta de medios de pago: " + sql);
		return sql;
	}

	public static String getSentenceLoyaltyProduct(String tienda, String caja, String transaccion) {
		tienda = String.format("%05d", Integer.parseInt(tienda));
		String sql = "SELECT '0' SIGNO,D.PRD_CODE CODIGO,D.PRDQTE CANTIDAD,D.PRDPV PRECIO,D.LOGD_REMISE DESCUENTO,'0' REMISION ";
		sql = sql + "FROM LOG_HEADER L INNER JOIN LOG_DETAIL D ON L.LOG_AUDIT = D.LOG_AUDIT WHERE L.SITE_CODE = '" + tienda;
		sql = sql + "' AND L.LOG_TERMINAL='" + caja.substring(caja.length() - 3) + "' AND L.LOG_TRXNO='" + transaccion + "'";
		sql = sql + " AND CONVERT(varchar,L.LOG_TRXDATE,12) = CONVERT(varchar,GETDATE(),12)";
		sql = sql + " AND L.LOG_AMOUNT <> 0 AND D.PRDPV <> 0 AND L.MTI_ID = 9220";

		System.out.println("Detalles de articulos: " + sql);
		return sql;
	}

	public static String getSentenceInformesPOSPayment(String tienda, String caja, String transaccion, String fecha) {
		String sql = "SELECT SIGNO, MEDIO_PAGO, VALOR, DOCID, TARJETA, OPERADOR FROM VTAXMPTUCAN_NEW_ALL WHERE FECHA_HORA_ALMACEN LIKE '";
		sql = sql + fecha + "%" + tienda + "' AND TERMINAL='" + caja + "' AND TRANSACCION='" + transaccion + "'";
		System.out.println("Consulta de medios de pago: " + sql);
		return sql;
	}

	public static String getSentenceInformesPOSProduct(String tienda, String caja, String transaccion, String fecha) {
		String sql = "SELECT SIGNO, CODIGO, CANTIDAD, CAST(PRECIO AS NUMERIC) / CAST(CANTIDAD AS NUMERIC) * 1000 PRECIO, DESCUENTO, REMISION, INDICAT1 ";
		sql = sql + "FROM VTAXDEPTONEW_ALL WHERE FECHA_HORA_ALMACEN LIKE '";
		sql = sql + fecha + "%" + tienda + "' AND TERM='" + caja.substring(caja.length() - 3) + "' AND TRX='" + transaccion + "'";
		System.out.println("Detalles de articulos: " + sql);
		return sql;
	}

	public static POSTransaction getTransactionLoyalty(String tienda, String caja, String transaccion, String fecha) {
		POSTransaction trn = new POSTransaction();
		trn.setStore(tienda);
		trn.setTerminal(caja);
		trn.setTransactionNmbr(transaccion);
		trn.setDate(fecha);
		List<TenderDetail> tenders = new LinkedList<TenderDetail>();
		String sql = getSentenceLoyaltyPayment(tienda, caja, transaccion);
		System.out.println("Consulta transaccción Engage: " + sql);
		conectarLoyalty();
		try {
			PreparedStatement ps = connLyty.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				TenderDetail tender = new TenderDetail();
				tender.setTenderCode(rs.getString("MEDIO_PAGO"));
				tender.setSigno(rs.getString("SIGNO"));
				tender.setTenderAmnt(rs.getInt("VALOR"));
				tender.setTenderSerial(rs.getString("TARJETA"));
				tenders.add(tender);
				trn.setCustomer(rs.getString("DOCID"));
				trn.setOperator(rs.getString("OPERADOR"));
			}
			TenderList tenderList = new TenderList();
			tenderList.setTenderDetail(tenders);
			trn.setTenderList(tenderList);

			List<ItemDetail> items = new LinkedList<ItemDetail>();
			sql = getSentenceLoyaltyProduct(tienda, caja, transaccion);
			PreparedStatement ps2 = connLyty.prepareStatement(sql);
			ResultSet rs2 = ps2.executeQuery();
			ProductService productService = new ProductService();
			while (rs2.next()) {
				ItemDetail item = new ItemDetail();
				item.setItemCode(rs2.getString("CODIGO").trim());
				item.setSigno(rs2.getString("SIGNO"));
				item.setItemQty(rs2.getInt("CANTIDAD") * 1000);
				item.setItemPrice(rs2.getInt("PRECIO"));
				item.setItemDiscount(rs2.getInt("DESCUENTO"));
				item.setRemision(getItemRemision(tienda, caja, transaccion, item.getItemCode()));
				item.setIndicat1(productService.getIndicat1(item.getItemCode(), tienda));
				items.add(item);
			}
			ItemList itemList = new ItemList();
			itemList.setItemDetail(items);
			trn.setItemList(itemList);
		} catch (SQLException e) {
			System.out.println("Error trayendo info de la transaccción: ");
			e.printStackTrace();
		}
		desconectarLoyalty();
		return trn;

	}

	public static POSTransaction getTransactionInformesPOS(String tienda, String caja, String transaccion, String fecha) {
		POSTransaction trn = new POSTransaction();
		trn.setStore(tienda);
		trn.setTerminal(caja);
		trn.setTransactionNmbr(transaccion);
		trn.setDate(fecha);
		List<TenderDetail> tenders = new LinkedList<TenderDetail>();
		String sql = "SELECT SIGNO, MEDIO_PAGO, VALOR, DOCID, TARJETA, OPERADOR FROM VTAXMPTUCAN_NEW_ALL WHERE FECHA_HORA_ALMACEN LIKE '";
		sql = sql + fecha + "%" + tienda + "' AND TERMINAL='" + caja + "' AND TRANSACCION='" + transaccion + "'";
		System.out.println("Consulta transaccción InformesPOS: " + sql);
		conectarInformesPOS();
		try {
			PreparedStatement ps = connINFPOS.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				TenderDetail tender = new TenderDetail();
				tender.setTenderCode(rs.getString("MEDIO_PAGO"));
				tender.setSigno(rs.getString("SIGNO"));
				tender.setTenderAmnt(rs.getInt("VALOR"));
				tender.setTenderSerial(rs.getString("TARJETA"));
				tenders.add(tender);
				trn.setCustomer(rs.getString("DOCID"));
				trn.setOperator(rs.getString("OPERADOR"));
			}
			TenderList tenderList = new TenderList();
			tenderList.setTenderDetail(tenders);
			trn.setTenderList(tenderList);

			List<ItemDetail> items = new LinkedList<ItemDetail>();
			sql = getSentenceInformesPOSProduct(tienda, caja, transaccion, fecha);
			PreparedStatement ps2 = connINFPOS.prepareStatement(sql);
			ResultSet rs2 = ps2.executeQuery();
			while (rs2.next()) {
				ItemDetail item = new ItemDetail();
				item.setItemCode(rs2.getString("CODIGO"));
				item.setSigno(rs2.getString("SIGNO"));
				item.setItemQty(rs2.getInt("CANTIDAD"));
				item.setItemPrice(rs2.getInt("PRECIO"));
				item.setItemDiscount(rs2.getInt("DESCUENTO"));
				item.setRemision(rs2.getString("REMISION"));
				item.setIndicat1(rs2.getString("INDICAT1"));
				items.add(item);
			}
			ItemList itemList = new ItemList();
			itemList.setItemDetail(items);
			trn.setItemList(itemList);
		} catch (SQLException e) {
			System.out.println("Error trayendo info de la transaccción: ");
			e.printStackTrace();
		}
		desconectarInformesPOS();
		return trn;
	}

	public static POSTransaction getTransaction(String tienda, String caja, String transaccion, String fecha) {
		POSTransaction trn = new POSTransaction();
		String pattern = "yyMMdd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());
		if (date.compareTo(fecha) == 0) // la transacción es de hoy, se consulta al motor
			trn = getTransactionLoyalty(tienda, caja, transaccion, fecha);
		else
			trn = getTransactionInformesPOS(tienda, caja, transaccion, fecha);
		return trn;

	}

	public static List<Almacen> getTiendas() {
		List<Almacen> lista = new LinkedList<Almacen>();
		String sql = "SELECT ID, Nombre, IP, tomcatServer, UserData1, UserData2, UserData3, UserData4, UserData5 FROM TIENDAS_POS ORDER BY ID";
		conectarInformesPOS();
		try {
			PreparedStatement ps = connINFPOS.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
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
		} catch (SQLException e) {
			System.out.println("Error trayendo las tiendas: ");
		}
		desconectarInformesPOS();
		return lista;
	}
	
	public static String getItemRemision(String sTienda, String sCaja, String sTrx, String sEan) {
		String remision = "0";
		conectarSicaf();
		String sql = "SELECT TOP 1 REMISION FROM TREMISIONES_TRAZABILIDAD WHERE FECHA=CONVERT(varchar,GETDATE(),112)";
		sql = sql + " AND CAST(CALMACEN AS INT) = CAST('" + sTienda + "' AS INT)";
		sql = sql + " AND CAST(TERMINAL AS INT) = CAST('" + sCaja + "' AS INT)";
		sql = sql + " AND CAST(TRANSACCION AS INT) = CAST('" + sTrx + "' AS INT)";
		sql = sql + " AND CAST(EAN AS BIGINT) LIKE '" + removeLeadingZeros(sEan) + "%' AND CESTADO = '02'";
		System.out.println("Consulta para remisión del artículo: " + sql);
		try {
			Connection con = getConnSICAF();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();
			if (rs != null) {
				remision = rs.getString("REMISION");
			}
			
		} catch (SQLException e) {
			System.out.println("Error trayendo la remision del producto " + sEan);
		}

		desconectarSicaf();
		return remision;
	}
	
	public static String removeLeadingZeros(String str) {
        // Regex to remove leading
        // zeros from a string
        String regex = "^0+(?!$)";
 
        // Replaces the matched
        // value with given string
        return str.replaceAll(regex, "");
  
	}

}
