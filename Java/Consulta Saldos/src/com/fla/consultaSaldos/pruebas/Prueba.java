package com.fla.consultaSaldos.pruebas;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

import com.fla.consultaSaldos.modelo.Saldo;
import com.fla.consultaSaldos.service.SaldosServiceImplementacion;

import lineai.base.data.exceptions.InvalidMaosFrameException;
import lineai.base.objects.Field;
import lineai.base.objects.Record;
import lineai.base.util.MaosFrame;

public class Prueba {
	private Logger log = Logger.getLogger(Prueba.class);
	private Socket socket;
	private String host = "172.16.153.114";
	private int port = 2500;
	private List<Saldo> saldos;

	public static void testGetSaldos() {
		SaldosServiceImplementacion saldosImpl = new SaldosServiceImplementacion();
		List<?> lista = saldosImpl.getSaldos("000071746198", "922", "");
		for (int i = 0; i < lista.size(); i++) {
			Saldo saldo = (Saldo) lista.get(i);
			System.out.println("getNdoc:" + saldo.getNdoc());
			System.out.println("getValordoc:" + saldo.getValordoc());
			System.out.println("getAlmorigen:" + saldo.getAlmorigen());
		}
	}

	public MaosFrame consultaPAFII(MaosFrame maos) throws IOException, InvalidMaosFrameException {
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
		}
		catch (Exception localException) {
			
		}
		MaosFrame respuesta = MaosFrame.getMaosFrame(cadena.trim());
		return respuesta;
	}
	
	public List<Saldo> getSaldos(String cedula, String tienda) {
		saldos = new LinkedList<Saldo>();
		try {
			String frame = "000000000001000|000071746198|01|03|922|";
			MaosFrame maos = MaosFrame.getMaosFrame(frame);
			MaosFrame respuesta = consultaPAFII(maos);
			if ((respuesta.getMessage().length() > 0) && (!respuesta.getMessage().equals("UndefinedException"))) {
				try {
					String mensaje = respuesta.getMessage();
					if (mensaje.startsWith("|")) {
						mensaje = mensaje.substring(1, mensaje.length());
					}
					if (mensaje.endsWith("|")) {
						mensaje = mensaje.substring(0,mensaje.length() -1);
					}
					Object[] objeto = mensaje.split(",");
					for (int i = 0; i > objeto.length; i++) {
						String record = (String)objeto[i];
						if (record.indexOf(";") > 0) {
							String[] tuplas = record.split(";");
							Record bean = (Record)Class.forName("lineai.base.objects.Record").newInstance();
							for (int j = 0; j < tuplas.length; j++) {
								String tupla = tuplas[j];
								if ((tupla.length() > 0) && (tupla.indexOf("=") >0)) {
									String[] keyValue = tupla.split("=");
									bean.addField(new Field(keyValue[0], 0, "", 0, keyValue[1]));
								}
							}
							Saldo saldo = convertSaldo(bean, tienda);
							if((saldo.getTipo().startsWith("1")) || (saldo.getTipo().startsWith("2")) || (saldo.getTipo().startsWith("4"))) {
								saldos.add(saldo);
							}
						}
					}
				}
				catch (Exception e) {
					log.error("Error en proceso: ", e);
				}
			}
			return saldos;
		}
		catch (UnknownHostException e) {
			log.error("No se encuentra el servidor ", e);
		}
		catch (IOException e) {
			log.error("Error en proceso. ", e);
		}
		catch (InvalidMaosFrameException e) {
			log.error("Cadena con errores. ", e);
		}
		finally {
			try {
				socket.close();
			}
			catch (Exception localException1) {
				
			}
		}
		return saldos;
	}

	  private Saldo convertSaldo(Record bean, String tienda)
	  {
	    Saldo saldo = new Saldo();
	    for (int i = 0; i < bean.getFields().size(); i++) {
	      try
	      {
	        BeanUtils.copyProperty(saldo, ((Field)bean.getFields().get(i)).getName(), 
	          ((Field)bean.getFields().get(i)).getValue());
	      }
	      catch (Exception e)
	      {
	        e.printStackTrace();
	      }
	    }
	    saldo.setTienda(tienda);
	    return saldo;
	  }

	public static void main(String[] args) {
		testGetSaldos();
	}

}
