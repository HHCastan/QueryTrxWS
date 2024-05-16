package co.com.flamingo.canopus.implementacion;

import java.net.MalformedURLException;

import org.apache.axis2.AxisFault;

import com.fal.ws.BasketRequest;
import com.fal.ws.RewardsResponse;

import co.com.flamingo.canopus.connection.ManejadorConexionFalWS;
import co.com.flamingo.canopus.interfaz.FalServiceInterface;

public class FalServiceImplementation implements FalServiceInterface {
	private static ManejadorConexionFalWS mcf;

	public FalServiceImplementation(String ip) throws MalformedURLException {
		mcf = new ManejadorConexionFalWS(ip);
	}
	
	@Override
	public RewardsResponse requestRewards(BasketRequest rewardsRequest) throws MalformedURLException, AxisFault {
		return mcf.requestRewards(rewardsRequest);
	}

}
