package com.fla.cotizador.servicio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.fla.cotizador.modelo.Producto;
import com.fla.cotizador.util.Util;

import lineai.base.data.exceptions.InvalidMaosFrameException;
import lineai.base.util.MaosFrame;

public class ProductosServiceImplementation implements ProductosServiceInterface {
	private Logger log = Util.getLogger();
	private String host;
	private int port;
	private Socket socket;
	static ProductosServiceImplementation productosServiceImpl;

	public static ProductosServiceImplementation getInstance() {
		if (productosServiceImpl == null) {
			productosServiceImpl = new ProductosServiceImplementation();
		}
		return productosServiceImpl;
	}

	public ProductosServiceImplementation() {
		Properties properties = Util.getProperties();
		try {
			this.host = properties.getProperty("pafserver");
			this.port = Integer.parseInt(properties.getProperty("pafport"));
		} catch (Exception localException) {
            log.error(localException);
		}
	}

	@Override
	public Producto getProducto(String itemCode, String stIP) {
		// Si el producto es un Paper Coupon:
		if(itemCode.length() > 6 && itemCode.startsWith("99999")) {
			return Util.setPaperCoupon(itemCode);
		}
		
		if (stIP.length() != 0) 
			this.host = stIP;
		
		try {
			String frame = "000000000000100|" + itemCode + "|";
			MaosFrame maosFrame = MaosFrame.getMaosFrame(frame);

			MaosFrame answerFrame = queryPaF(maosFrame);
			System.out.println("answerFrame.toString().charAt(0) " + answerFrame.toString().charAt(0));
			if (answerFrame.toString().charAt(0) == '#')
				answerFrame = queryPaF(maosFrame);
			if ((answerFrame.getMessage().length() > 0) && (!answerFrame.getMessage().equals("UndefinedException"))) {
				try {
					String mensaje = answerFrame.toString();
					if (mensaje.startsWith("|")) {
						mensaje = mensaje.substring(1, mensaje.length());
					}
					if (mensaje.endsWith("|")) {
						mensaje = mensaje.substring(0, mensaje.length() - 1);
					}
					Producto productox = maosToProducto(answerFrame);
					if (productox != null)
						return productox;
				} catch (Exception e) {
					log.error("Error: ", e);
				}
			}
			return null;
		} catch (UnknownHostException e) {
			log.error("No se encuenta el servidor.", e);
		} catch (IOException e) {
			log.error("Error.", e);
		} catch (InvalidMaosFrameException e) {
			log.error("No se reconoce la cadena.", e);
		} finally {
			try {
				this.socket.close();
			} catch (Exception localException1) {
			}
		}
		return null;

	}

	public MaosFrame queryPaF(MaosFrame maos) throws IOException, InvalidMaosFrameException {
		log.info("Mensaje Enviado a IP y Puerto: " +  host + ", " + port);
		socket = new Socket(host, port);
		OutputStream os = socket.getOutputStream();
		os.write(maos.toString().getBytes());
		InputStream is = socket.getInputStream();
		byte[] buffer = new byte['?'];
		String cadena = "";
		try {
			int bytes;
			while ((bytes = is.read(buffer)) != -1) {
				cadena = cadena + new String(buffer, 0, bytes);
			}
		} catch (Exception localException) {

		}
		MaosFrame respuesta = MaosFrame.getMaosFrame(cadena.trim());
		return respuesta;
	}

	public Producto maosToProducto(MaosFrame frame) {
		log.info("frame: " + frame);
		String[] array = frame.getMessagebyTokens();
		Producto producto = null;
		if (array.length > 10) {
			producto = new Producto();
			producto.setItemCode(getValue(array[0]));
			producto.setIndicat0(Integer.parseInt(getValue(array[1])));
			producto.setIndicat1(Integer.parseInt(getValue(array[2])));
			producto.setIndicat1a(Integer.parseInt(getValue(array[3])));
			producto.setIndicat2(Integer.parseInt(getValue(array[4])));
			producto.setDepto(getValue(array[5]));
			producto.setFamilyNu(getValue(array[6]));
			producto.setMpGroup(getValue(array[7]));
			producto.setSaleQuan(Integer.parseInt(getValue(array[8])));
			producto.setItemPrice(Util.moneyFormat(getValue(array[9]), 0));
			producto.setLinkedTo(getValue(array[10]));
			producto.setQuantity(1);
			producto.setItemDesc(getValue(array[11]));
			producto.setUserExit1(Integer.parseInt(getValue(array[12])));
			producto.setUserExit2(Integer.parseInt(getValue(array[13])));
			producto.setEventoFenix(Integer.parseInt(getValue(array[14])));
			producto.setEventoMefia(Integer.parseInt(getValue(array[15])));
			producto.setEventoSafix(Integer.parseInt(getValue(array[16])));
			producto.setUserData(getValue(array[17]));
			log.info("Producto: " + producto.getItemCode() + ", Evento Fenix: " + producto.getEventoFenix());
		}
		return producto;
	}
	
	public String getValue(String stKeyValue) {
		String[] keyValueSplit = stKeyValue.split("=", 2);
		return keyValueSplit[1];
	}

}
