package co.com.flamingo.queryTRX.services;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import co.com.flamingo.queryTRX.util.Util;
import lineai.base.data.exceptions.InvalidMaosFrameException;
import lineai.base.util.MaosFrame;

public class ProductService {
	private String host;
	private int port = 2502;
	private Socket socket;

	static ProductService productService = null;
	
	public static ProductService getInstance() {
		if (productService == null)
			productService = new ProductService();
		return productService;
	}
	
	public ProductService() {
		
	}
	
	public String getIndicat1(String itemCode, String sTienda) {
		this.host = Util.getTiendaIP(sTienda);
		System.out.println("Tienda IP: " + host + ", itemCode: [" + itemCode + "]");
		String indicat1 = "0000000000000000";
		try {
			String frame = "000000000000100|" + itemCode + "|";
			MaosFrame maosFrame = MaosFrame.getMaosFrame(frame);
			MaosFrame answerFrame = queryPaF(maosFrame);
			if (answerFrame.toString().charAt(0) == '#')
				answerFrame = queryPaF(maosFrame);
			if ((answerFrame.getMessage().length() > 0) && (!answerFrame.getMessage().equals("UndefinedException"))) {
				String[] array = answerFrame.getMessagebyTokens();
				if (array.length > 10) {
					int ind1 = Integer.parseInt(getValue(array[2]));
					indicat1 = Util.decimal2binario(ind1);
				}
				return indicat1;
			}
		} catch (UnknownHostException e) {
			System.out.println("No se encuenta el servidor.");
		} catch (IOException e) {
			System.out.println("Error.");
		} catch (InvalidMaosFrameException e) {
			System.out.println("No se reconoce la cadena.");
		} finally {
			try {
				this.socket.close();
			} catch (Exception localException1) {
			}
		}
		return null;
		
	}

	public MaosFrame queryPaF(MaosFrame maos) throws IOException, InvalidMaosFrameException {
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

	public String getValue(String stKeyValue) {
		String[] keyValueSplit = stKeyValue.split("=", 2);
		return keyValueSplit[1];
	}
}
