package co.com.flamingo.queryTRX.logic;

import co.com.flamingo.queryTRX.services.ServiceDAO;
import co.com.flamingo.queryTRX.types.POSTransaction;

public class QueryTransaction {

	public static POSTransaction getTransaction(String tienda, String caja, String transaccion, String fecha) {
		ServiceDAO sDao = new ServiceDAO();
		tienda = String.format("%03d", Integer.parseInt(tienda));
		caja = String.format("%04d", Integer.parseInt(caja));
		transaccion = String.format("%04d", Integer.parseInt(transaccion));
		return sDao.getTransaction(tienda, caja, transaccion, fecha);
	}

}
