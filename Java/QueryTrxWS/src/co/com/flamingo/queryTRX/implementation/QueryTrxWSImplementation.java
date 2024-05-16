package co.com.flamingo.queryTRX.implementation;

import javax.jws.WebService;

import co.com.flamingo.queryTRX.interfaz.QueryTrxWSInt;
import co.com.flamingo.queryTRX.logic.QueryTransaction;
import co.com.flamingo.queryTRX.types.POSTransaction;

@WebService(
		targetNamespace="http://queryTrxWS",
		serviceName="queryTrx",
		endpointInterface="co.com.flamingo.queryTRX.interfaz.QueryTrxWSInt")
public class QueryTrxWSImplementation implements QueryTrxWSInt {

	@Override
	public POSTransaction transactionRequest(String tienda, String caja, String transaccion, String fecha) {
		return QueryTransaction.getTransaction(tienda, caja, transaccion, fecha);
	}

}
