package co.com.flamingo.queryTRX.publish;

import javax.xml.ws.Endpoint;

import co.com.flamingo.queryTRX.implementation.QueryTrxWSImplementation;
import co.com.flamingo.queryTRX.util.Util;

import java.util.Properties;


public class QueryTrxPublish {
	private static Properties properties = Util.getProperties();

	public static void main(String[] args) {
		String endPoint = properties.getProperty("EndPoint");
		Endpoint.publish(endPoint, new QueryTrxWSImplementation());
	}
}
