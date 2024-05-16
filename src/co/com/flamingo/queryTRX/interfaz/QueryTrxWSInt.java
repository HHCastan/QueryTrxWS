package co.com.flamingo.queryTRX.interfaz;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import co.com.flamingo.queryTRX.types.POSTransaction;

@WebService(
		targetNamespace="http://queryTrxWS",
		name="transactionRequest")
public interface QueryTrxWSInt {
	@WebMethod
	@WebResult(name = "POSTransactionResponse")
	public POSTransaction transactionRequest(
			@WebParam(name = "tienda") String tienda,
			@WebParam(name = "caja") String caja,
			@WebParam(name = "transaccion") String transaccion,
			@WebParam(name = "fecha") String fecha);


	@WebMethod
	@WebResult(name = "POSTransactionResponse")
	public POSTransaction transactionRequestGrouped(
			@WebParam(name = "tienda") String tienda,
			@WebParam(name = "caja") String caja,
			@WebParam(name = "transaccion") String transaccion,
			@WebParam(name = "fecha") String fecha);
}
