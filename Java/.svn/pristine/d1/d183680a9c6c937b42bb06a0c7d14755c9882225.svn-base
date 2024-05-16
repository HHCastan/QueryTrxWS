package com.flamingo.compressDerby;

import java.sql.*;

public class CompressTables {
	public static void main(String[] args) throws Exception {
		if (args.length == 0) {
			System.out.println("USO: CompressTables IP_Derby_Server");
			System.exit(0);
		}

		String stURL = "jdbc:derby://" + args[0] + ":1527/loyaltyv7;create=true";
		String sentencia = "SELECT SCHEMANAME, TABLENAME FROM sys.sysschemas s, sys.systables t WHERE s.schemaid = t.schemaid   and t.tabletype = 'T'";

		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

		try (Connection conn = DriverManager.getConnection(stURL);
				PreparedStatement ps = conn.prepareStatement(sentencia);) {
			try (ResultSet rs = ps.executeQuery();) {
				CallableStatement cs = conn.prepareCall("CALL SYSCS_UTIL.SYSCS_COMPRESS_TABLE(?, ?, ?)");
				while (rs.next()) {
					String schema = rs.getString(1);
					String table = rs.getString(2);
					System.out.println("Now compressing " + schema + " " + table);
					cs.setString(1, schema);
					cs.setString(2, table);
					cs.setShort(3, (short) 1);
					cs.execute();
				}
			}
		} catch (SQLException e) {
			System.out.println("Error consultando grupo del artículo: " + e);
		}

		System.out.println("Done.");
	}

}
