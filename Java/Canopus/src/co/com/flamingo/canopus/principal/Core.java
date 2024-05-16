package co.com.flamingo.canopus.principal;

import java.net.MalformedURLException;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.axis2.AxisFault;
import org.apache.log4j.Logger;

import com.fal.ws.BasketRequest;
import com.fal.ws.CustomerDetails;
import com.fal.ws.RewardsField;
import com.fal.ws.RewardsResponse;
import co.com.flamingo.canopus.Version;
import co.com.flamingo.canopus.implementacion.FalServiceImplementation;
import co.com.flamingo.canopus.transformadores.TransformadorTramas;

public class Core {
	private static FalServiceImplementation falImpl = null;
	private final static Logger log = Logger.getLogger(co.com.flamingo.canopus.principal.Core.class);

	public Core(String ip) {
		super();
		log.info(Version.getVersion());
		log.info("Nueva instancia de Canopus - con: " + ip);
		try {
			falImpl = new FalServiceImplementation(ip);
			log.info("Instancia exitosa");
		} catch (MalformedURLException e) {
			log.error("Error instanciando Canopus");
			e.printStackTrace();
		}
	}

	public String getCustomer(String trama) {
		String respuesta = null;
		BasketRequest rewardsRequest = TransformadorTramas.trama2Basket(trama);
		rewardsRequest.setFunctionID("0302");
		log.info("Hay llamado para consulta de cliente");

		try {
			RewardsResponse requestResponse = falImpl.requestRewards(rewardsRequest);
			CustomerDetails customerdetails = requestResponse.getCustomerDetails();
			String nombre = "";
			String apellido = "";
			if (customerdetails != null) {
				nombre = customerdetails.getCustomerName().getFirstName();
				apellido = customerdetails.getCustomerName().getLastName();
				if (nombre == null || nombre.equals("")) {
					nombre = " ";
				}
				if (apellido == null || apellido.equals("")) {
					apellido = " ";
				}
				String sexo = customerdetails.getCustomerName().getSex();
				if (sexo == null || sexo.equals("")) {
					sexo = " ";
				}
				String titulo = customerdetails.getCustomerName().getTitle();
				if (titulo == null || titulo.equals("")) {
					titulo = " ";
				}
				XMLGregorianCalendar act = customerdetails.getCustomerName().getLastUpdated();
				String actualizacion = "Nunca";
				if (act != null) {
					actualizacion = "" + act;
				}

				log.info("Respueta: " + nombre + "|" + apellido + "|" + sexo + "|" + titulo + "|" + actualizacion);
				respuesta = nombre + "|" + apellido + "|" + sexo + "|" + titulo + "|" + actualizacion;
			}
		} catch (AxisFault | MalformedURLException e) {
			log.error("Error invocando WS: ");
			e.printStackTrace();
		}
		return respuesta;
	}

	public String getRewards(String trama) {
		String respuesta = null;
		BasketRequest rewardsRequest = TransformadorTramas.trama2Basket(trama);
		rewardsRequest.setFunctionID("9000");

		try {
			log.info("Inicia llamado al WS del Motor");
			RewardsResponse requestResponse = falImpl.requestRewards(rewardsRequest);
			log.info("Procesando respuesta del Motor");
			RewardsField regardsGranted = requestResponse.getRewardsGranted();
			if (regardsGranted != null) {
				int totalDiscount = regardsGranted.getTotalDiscountAmount();

				log.info("Respueta Descuentos: " + totalDiscount);
				respuesta = String.valueOf(totalDiscount / 100);
			}
		} catch (AxisFault | MalformedURLException e) {
			log.error("Error invocando WS: ");
			e.printStackTrace();
		}
		return respuesta;
	}
	
	public String returnRequest(String trama) {
		String respuesta = null;
		BasketRequest rewardsRequest = TransformadorTramas.trama2Return(trama);
		rewardsRequest.setFunctionID("9101");
		try {
			log.info("Inicia llamado al WS del Motor");
			RewardsResponse requestResponse = falImpl.requestRewards(rewardsRequest);
			log.info("Procesando respuesta del Motor");
			RewardsField regardsGranted = requestResponse.getRewardsGranted();
			if (regardsGranted != null) {
				int totalDiscount = regardsGranted.getTotalDiscountAmount();

				log.info("Respueta Descuentos: " + totalDiscount);
				respuesta = String.valueOf(totalDiscount / 100);
			}
		} catch (AxisFault | MalformedURLException e) {
			log.error("Error invocando WS: ");
			e.printStackTrace();
		}
		return respuesta;
	}

}
