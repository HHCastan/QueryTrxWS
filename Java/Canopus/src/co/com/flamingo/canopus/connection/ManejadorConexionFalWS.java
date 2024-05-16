package co.com.flamingo.canopus.connection;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.Properties;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;

import org.apache.axis2.AxisFault;
import org.apache.log4j.Logger;

import com.fal.ws.BasketRequest;
import com.fal.ws.FALWebServicesImpl;
import com.fal.ws.FALWebServicesImplService;
import com.fal.ws.RewardsResponse;
import com.sun.xml.internal.ws.client.BindingProviderProperties;
import com.sun.xml.internal.ws.wsdl.writer.document.Port;

import co.com.flamingo.canopus.util.Util;

public class ManejadorConexionFalWS {
	private static final String CLASSNAME = "[ManejadorConexionFalWS] ";
	private static ManejadorConexionFalWS falServiceImpl;
	static FALWebServicesImplService service = new FALWebServicesImplService();
	private URL url;
	private Properties properties = Util.getProperties();
	private final static Logger log = Logger.getLogger(co.com.flamingo.canopus.connection.ManejadorConexionFalWS.class);

	public ManejadorConexionFalWS getInstance() throws MalformedURLException {
		if (falServiceImpl == null)
			falServiceImpl = new ManejadorConexionFalWS();
		return falServiceImpl;
	}

	public ManejadorConexionFalWS() throws MalformedURLException {
		this.url = new URL(properties.getProperty("LYTYWSurl"));
	}

	public ManejadorConexionFalWS(String ip) throws MalformedURLException {
		this.url = new URL("http://" + ip + ":8080/falws/falws?WSDL");
		log.info("Iniciando instancia con " + url);
		service = new FALWebServicesImplService(url);
//		FALWebServicesImpl port = service.getPort(new QName("http://impl.ws.fal.com/", "FALWebServicesImplPort"), FALWebServicesImpl.class);
//		((BindingProvider) port).getRequestContext().put(BindingProviderProperties.REQUEST_TIMEOUT, 10);
	}

	public RewardsResponse requestRewards(BasketRequest rewardsRequest) throws MalformedURLException, AxisFault {
		return service.getFALWebServicesImplPort().requestRewards(rewardsRequest);
	}

}
