package com.fla.consultaSaldos.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

import com.fla.consultaSaldos.modelo.Saldo;
import com.fla.consultaSaldos.principal.Inicio;
import com.fla.consultaSaldos.util.Util;

import lineai.base.data.exceptions.InvalidMaosFrameException;
import lineai.base.objects.Field;
import lineai.base.objects.Record;
import lineai.base.util.MaosFrame;

public class SaldosServiceImplementacion implements SaldosServiceInterface {
	private Logger log = Util.getLogger();
	private String host;
	private int port;
	private Socket socket;
	static SaldosServiceImplementacion saldosServiceImpl;

	public static SaldosServiceImplementacion getInstance() {
		if (saldosServiceImpl == null) {
			saldosServiceImpl = new SaldosServiceImplementacion();
		}
		return saldosServiceImpl;
	}

	public SaldosServiceImplementacion() {
		Properties properties = Inicio.getProperties();
		try {
			this.host = properties.getProperty("pafserver");
			this.port = Integer.parseInt(properties.getProperty("pafport"));
		} catch (Exception localException) {
            log.error(localException);
		}
	}


	@Override
	public Saldo getSaldo(String saldo, String tienda, String stIP) {
		if (stIP.length() != 0) 
			this.host = stIP;
		
		try {
			String frame = "000000000001000|" + saldo + "|01|01|" + tienda + "|";
			MaosFrame maosFrame = MaosFrame.getMaosFrame(frame);

			MaosFrame answerFrame = queryPaF(maosFrame);
			if ((answerFrame.getMessage().length() > 0) && (!answerFrame.getMessage().equals("UndefinedException"))) {
				try {
					String mensaje = answerFrame.toString();
					if (mensaje.startsWith("|")) {
						mensaje = mensaje.substring(1, mensaje.length());
					}
					if (mensaje.endsWith("|")) {
						mensaje = mensaje.substring(0, mensaje.length() - 1);
					}
					Saldo saldox = maosToSaldo(answerFrame, tienda);
					if ((saldox.getTipo().startsWith("1")) || (saldox.getTipo().startsWith("2"))
							|| (saldox.getTipo().startsWith("4"))) {
						log.debug("Respuesta: " + saldox);
						return saldox;
					}
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

	@Override
	public List<?> getSaldos(String cedula, String tienda, String stIP) {
		List saldos = new LinkedList();

		if (stIP.length() != 0) 
			this.host = stIP;

		try {
			String frame = "000000000001000|" + cedula + "|01|03|" + tienda + "|";
			MaosFrame maosFrame = MaosFrame.getMaosFrame(frame);

			MaosFrame answerFrame = queryPaF(maosFrame);
			if ((answerFrame.getMessage().length() > 0) && (!answerFrame.getMessage().equals("UndefinedException"))) {
				try {
					String mensaje = answerFrame.getMessage();
					if (mensaje.startsWith("|")) {
						mensaje = mensaje.substring(1, mensaje.length());
					}
					if (mensaje.endsWith("|")) {
						mensaje = mensaje.substring(0, mensaje.length() - 1);
					}
					Object[] objects = mensaje.split(",");
					for (int i = 0; i < objects.length; i++) {
						String record = (String) objects[i];
						if (record.indexOf(";") > 0) {
							String[] pairs = record.split(";");
							Record bean = (Record) Class.forName("lineai.base.objects.Record").newInstance();
							for (int j = 0; j < pairs.length; j++) {
								String pair = pairs[j];
								if ((pair.length() > 0) && (pair.indexOf("=") > 0)) {
									String[] keyValue = pair.split("=");
									bean.addField(new Field(keyValue[0], 0, "", 0, keyValue[1]));
								}
							}
							Saldo saldo = convertSaldo(bean, tienda);
							if ((saldo.getTipo().startsWith("1")) || (saldo.getTipo().startsWith("2"))
									|| (saldo.getTipo().startsWith("4"))) {
								saldos.add(saldo);
							}
						}
					}
				} catch (Exception e) {
					log.error("Error: ", e);
				}
			}
			return saldos;
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
		return saldos;
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

	public Saldo maosToSaldo(MaosFrame frame, String tienda) {
		log.info("frame: " + frame);
		String[] array = frame.getMessagebyTokens();
		Saldo saldo = null;
		if (array.length > 10) {
			saldo = new Saldo();
			saldo.setNdoc(array[1]);
			saldo.setFechael(Util.dateFormat(array[2]));
			saldo.setFechare(Util.dateFormat(array[3]));
			saldo.setValordoc(Util.moneyFormat(array[4], 0));
			saldo.setDocid(array[5]);
			saldo.setNombre(array[6]);
			saldo.setApellido(array[7]);
			saldo.setTipo(array[8]);
			saldo.setAlmcob(array[9]);
			saldo.setDocorigen(array[10]);
			saldo.setAux(array[11]);
			saldo.setTienda(tienda);
		}
		return saldo;
	}

	private Saldo convertSaldo(Record bean, String tienda) {
		Saldo saldo = new Saldo();
		for (int i = 0; i < bean.getFields().size(); i++) {
			try {
				BeanUtils.copyProperty(saldo, ((Field) bean.getFields().get(i)).getName(),
						((Field) bean.getFields().get(i)).getValue());
			} catch (Exception e) {
				log.error("Error convietiendo saldo.", e);
			}
		}
		saldo.setTienda(tienda);
		return saldo;
	}

}
