package com.fla.cotizador.vista;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.SoftBevelBorder;

import org.apache.log4j.Logger;

import com.fla.cotizador.modelo.Cotizacion;
import com.fla.cotizador.servicio.BytteServiceImplementation;
import com.fla.cotizador.servicio.DBServiceImplementation;
import com.fla.cotizador.servicio.RetanqueoServiceImplementation;
import com.fla.cotizador.servicio.SafixServiceImplementation;
import com.fla.cotizador.util.AprobacionRPT;
import com.fla.cotizador.util.Util;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JSpinnerDateEditor;

import co.com.bytte.casb.ConsultaClienteEnrolamientoArchivo;
import co.com.bytte.casb.ConsultaClienteImagenResponseDocument;
import co.com.bytte.casb.ConsultaLogClienteResponseDocument.ConsultaLogClienteResponse;
import co.com.bytte.casb.LogResponseImage;
import co.com.flamingo.clienteRetanqueo.CrearAprobacionRes;
import co.com.flamingo.clienteRetanqueo.InfoAprobacion;
import co.com.flamingo.www._2018._06.RespuestaMetodo;

public class ValidarClienteSafix extends JDialog implements MouseListener {
	/**
	 * INICIA DEFINICIÓN DE VARIABLES DE CLASE
	 */
	private static final long serialVersionUID = 1L;
	/** Panel para ingreso de datos */
	private JPanel jpDatosIn;
	private JLabel lblTipoDocumento = new JLabel("Tipo documento:");
	private JLabel lblNumeroDocumento = new JLabel("Número documento:");
	private JLabel lblFechaExpedicion = new JLabel("Fecha expedición:");
	private JLabel lblFechaNacimiento = new JLabel("Fecha nacimiento:");
	private JComboBox<?> cbxTipoDoc;
	private JTextField txNumeroDocumento;
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
	SimpleDateFormat formatter2 = new SimpleDateFormat("yyyyMMdd");
	private Logger log = Util.getLogger();

	private JDateChooser chooserExpedicion = new JDateChooser(null, null, null, new JSpinnerDateEditor());
	private JDateChooser chooserNacimiento = new JDateChooser(null, null, null, new JSpinnerDateEditor());

	String[] arTipoDoc = { "TI", "CC", "NI", "CE" };
	private JButton btnValidar;
	private JButton btnRegresar;
	private JButton btnVerImgnCed;

	/** Para mostrar un popup con el teclado numérico */
	VirtualNumPad kp;

	Font fontBold = new Font("SansSerif", Font.BOLD, 20);
	Font fontPlain = new Font("SansSerif", Font.PLAIN, 16);

	Border raisedBorder = new SoftBevelBorder(SoftBevelBorder.RAISED);
	Border loweredBorder = new SoftBevelBorder(SoftBevelBorder.LOWERED);

	SafixServiceImplementation safixServiceImpl = new SafixServiceImplementation();
	private Cotizacion cotizacion;
	private boolean blnCreditoGenerado = false;

	public ValidarClienteSafix(JFrame ventanaPadre) {
		super(ventanaPadre, true);
		inicializarComponentes(ventanaPadre);
		configurarVentana();
		componerVentana();

		adicionarListeners();
		adicionarComponentes();
	}

	private void configurarVentana() {
		setTitle("Flamingo - Validación del cliente");
		setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/Icono_Flamingo.png")));
		setModal(true);
		setSize(580, 380); // tamaño de la ventana
		setLayout(null); // no usamos ningun layout, solo asi podremos dar posiciones a los componentes
		setResizable(true); // hacemos que la ventana sea redimiensionable
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE); // hacemos que cuando se cierre la ventana termina todo proceso
//		addWindowListener(new WindowAdapter() {
//			public void windowOpened(WindowEvent e) {
//				mostrarCedula();
//			}
//		} );
	}

	private void inicializarComponentes(JFrame ventanaPadre) {
		kp = new VirtualNumPad(ventanaPadre);
		jpDatosIn = new JPanel();
		txNumeroDocumento = new JTextField("");
		btnValidar = new JButton();
		btnRegresar = new JButton();
		btnVerImgnCed = new JButton();

		// Inicia el combo box para los tipos de documento:
		cbxTipoDoc = new JComboBox(arTipoDoc);
		cbxTipoDoc.setSelectedIndex(1);

		// Inicaliza las fechas de los pickers
		Calendar calendar = Calendar.getInstance();
		chooserExpedicion.setDate(calendar.getTime());

		calendar.add(Calendar.YEAR, -18);
		chooserNacimiento.setDate(calendar.getTime());
	}

	private void componerVentana() {
		jpDatosIn.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), " Datos de Entrada: "));
		jpDatosIn.setBounds(15, 5, 500, 220);
		jpDatosIn.setLayout(null);

		lblTipoDocumento.setBounds(10, 20, 200, 30);
		lblTipoDocumento.setFont(fontPlain);
		lblTipoDocumento.setHorizontalAlignment(SwingConstants.RIGHT);
		cbxTipoDoc.setBounds(220, 20, 200, 30);
		cbxTipoDoc.setFont(fontPlain);

		lblNumeroDocumento.setBounds(10, 70, 200, 30);
		lblNumeroDocumento.setFont(fontPlain);
		lblNumeroDocumento.setHorizontalAlignment(SwingConstants.RIGHT);
		txNumeroDocumento.setBounds(220, 70, 200, 30);
		txNumeroDocumento.setBorder(loweredBorder);
		txNumeroDocumento.setFont(fontBold);

		lblFechaExpedicion.setBounds(10, 120, 200, 30);
		lblFechaExpedicion.setFont(fontPlain);
		lblFechaExpedicion.setHorizontalAlignment(SwingConstants.RIGHT);
		chooserExpedicion.setBounds(220, 120, 200, 30);
		chooserExpedicion.setFont(fontPlain);
		chooserExpedicion.setBorder(loweredBorder);
		chooserExpedicion.setEnabled(true);

		lblFechaNacimiento.setBounds(10, 170, 200, 30);
		lblFechaNacimiento.setFont(fontPlain);
		lblFechaNacimiento.setHorizontalAlignment(SwingConstants.RIGHT);
		chooserNacimiento.setBounds(220, 170, 200, 30);
		chooserNacimiento.setFont(fontPlain);
		chooserNacimiento.setBorder(loweredBorder);

		btnVerImgnCed.setText("Cédula");
		btnVerImgnCed.setBounds(200, 260, 80, 60);
		btnVerImgnCed.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnVerImgnCed.setHorizontalTextPosition(SwingConstants.CENTER);
		btnVerImgnCed.setIcon(new ImageIcon(this.getClass().getResource("/images/userId32.png")));
		btnVerImgnCed.setBorder(raisedBorder);

		btnValidar.setText("Validar");
		btnValidar.setBounds(300, 260, 80, 60);
		btnValidar.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnValidar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnValidar.setIcon(new ImageIcon(this.getClass().getResource("/images/check32.png")));
		btnValidar.setBorder(raisedBorder);

		btnRegresar.setText("Cancelar");
		btnRegresar.setBounds(400, 260, 80, 60);
		btnRegresar.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnRegresar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnRegresar.setIcon(new ImageIcon(this.getClass().getResource("/images/return32.png")));
		btnRegresar.setBorder(raisedBorder);

	}

	private void adicionarComponentes() {
		jpDatosIn.add(lblTipoDocumento);
		jpDatosIn.add(cbxTipoDoc);
		jpDatosIn.add(lblNumeroDocumento);
		jpDatosIn.add(txNumeroDocumento);
		jpDatosIn.add(lblFechaExpedicion);
//		jpDatosIn.add(pickerExpedicion);
		jpDatosIn.add(chooserExpedicion);
		jpDatosIn.add(lblFechaNacimiento);
		jpDatosIn.add(chooserNacimiento);

		add(jpDatosIn);
		add(btnVerImgnCed);
		add(btnValidar);
		add(btnRegresar);
	}

	/**
	 * adicionarListeners()
	 * 
	 */
	private void adicionarListeners() {
		txNumeroDocumento.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txDocumentoClic();
			}
		});

		btnVerImgnCed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
//				mostrarCedula();
			}
		});

		btnValidar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				validar();
			}
		});

		btnRegresar.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseReleased(java.awt.event.MouseEvent evt) {
				close();
			}
		});
	}

	protected void mostrarCedula() {
		Image image = null;
		BytteServiceImplementation bytteImpl = new BytteServiceImplementation();
		ConsultaLogClienteResponse consultaLogResponseImagen = bytteImpl.consultaLogCliente(cotizacion.getCliente().getClienteID());
		if (consultaLogResponseImagen == null) {
			Util.okDialog("Error consultando imagen del documento.", new JFrame(), JOptionPane.ERROR_MESSAGE);
			close();
			return;
		}
		try {
			LogResponseImage[] arTransacciones = consultaLogResponseImagen.getConsultaLogClienteResult().getListaTransacciones()
					.getLogResponseImageArray();

			for (int i = 0; i < arTransacciones.length; i++) {
				ConsultaClienteEnrolamientoArchivo[] arArchivos = arTransacciones[i].getLISTAARCHIVOS().getConsultaClienteEnrolamientoArchivoArray();
				if (!cumplePeriodoEnrolamiento(arTransacciones[i].getFECHAPROCESO().getTime())) {
					Util.okDialog("El cliente no cumple con periodo mínimo desde último enrolamiento", new JFrame(), JOptionPane.ERROR_MESSAGE);
					close();
				}
					
				for (int j = 0; j < arArchivos.length; j++) {
					if (arArchivos[j].getTIPOARCHIVOID() == 9) {
						String sUrl = arArchivos[j].getURL();
						try {
							URL url = new URL(sUrl);
							image = ImageIO.read(url);
							JPanel pnlCedula = new JPanel();
							pnlCedula.add(new JLabel(new ImageIcon(image)));
							int c = JOptionPane.showConfirmDialog(null, pnlCedula);
							if (c != 0)
								close();
							return;
						} catch (MalformedURLException e) {
							Util.okDialog("Error procesando la imagen del documento.", new JFrame(), JOptionPane.ERROR_MESSAGE);
						} catch (IOException e) {
							Util.okDialog("Error procesando la imagen del documento.", new JFrame(), JOptionPane.ERROR_MESSAGE);
						}
					}
				}
				log.info("No hay archivo de imagen con la cédula");
				break;
			}

		} catch (NullPointerException e) {
			Util.okDialog("Cliente no enrolado aún.", new JFrame(), JOptionPane.ERROR_MESSAGE);
			close();
		}
		close();
		return;
	}

	private boolean cumplePeriodoEnrolamiento(Date fechaEnrolamiento) {
		log.info("Ultimo enrolamiento ocurrió el " + fechaEnrolamiento);
		Date fechaActual = new Date();
		int diasTranscurridos = (int) ((fechaActual.getTime() - fechaEnrolamiento.getTime()) / 86400000);
		log.info("Días transcurridos desde ultimo enrolamiento: " + diasTranscurridos);
		Properties propDB = Util.getPropertiesDB();
		int maxDiasSinEnrolar = Integer.parseInt(propDB.getProperty("BYTTE_WS.maxDiasSinEnrolar"));
//		int maxDiasSinEnrolar = 960;
		if (diasTranscurridos > maxDiasSinEnrolar)
			return false;
		return true;
	}

	/**
	 * Mini-evidente para validar que el cliente si es la persona que está en la
	 * base de datos
	 */
	protected void validar() {
		int indice = cbxTipoDoc.getSelectedIndex();
		String tipoDoc = arTipoDoc[indice];
		Calendar fechaNacimiento = Calendar.getInstance();
		fechaNacimiento.setTime(chooserNacimiento.getDate());
		Calendar fechaExpedicion = Calendar.getInstance();
		fechaExpedicion.setTime(chooserExpedicion.getDate());
		RespuestaMetodo respuesta = safixServiceImpl.validaClienteSafix(tipoDoc, txNumeroDocumento.getText(), fechaNacimiento, fechaExpedicion);
		BigDecimal idRetorno = respuesta.getIdRetorno();
		if (idRetorno.intValue() == 1) { // Los datos coinciden
			Object[] options = { "Si, generar aprobación", "No, regresar a la consulta" };
			String msg = "Verificación exitosa. ¿Desea generar aprobación por el valor de la mercancía?";
			int h = Util.sigaPareMessage(msg, this, JOptionPane.QUESTION_MESSAGE, options);
			if (h == 0) { // Cliente acepta generar el crédito
				gestionaOTP();
			}
		} else {
			Util.okDialog("Datos ingresados no coinciden. Por favor verifique", new JFrame(), JOptionPane.ERROR_MESSAGE);
		}

		close();

	}

	private void gestionaOTP() {
		/** Servicio para conexion con bases de datos */
		DBServiceImplementation dbServiceImpl = new DBServiceImplementation();
		dbServiceImpl.sendOTP(cotizacion.getCliente().geteMail());
		Object[] optionsOPT = { "Si, ingresar código de verificación", "No, el cliente desiste de la operación" };
		String msg = "Se enviará código de verificación como SMS al celular del cliente. ¿Continúa con la operación?";
		int h = Util.sigaPareMessage(msg, this, JOptionPane.QUESTION_MESSAGE, optionsOPT);
		if (h == 0) { // se continúa con la operación
			String codigoOTP = Util.inputNumeric(new JFrame());
			generaAprobacion(codigoOTP);

		}
	}

	private void generaAprobacion(String codigoOTP) {
		String vlrFinanciar = Util.removeMoneyFormat(cotizacion.getVlrFinanciar());
		RetanqueoServiceImplementation retanqueoImpl = new RetanqueoServiceImplementation();
		String tienda = Util.zeroPad(cotizacion.getTienda().getCodigo(), 3);
		CrearAprobacionRes retanqueoRes = retanqueoImpl.crearAprobacion(tienda, codigoOTP, cotizacion.getCliente().getClienteID(), "CC",
				new BigDecimal(vlrFinanciar), new BigDecimal(cotizacion.getMeses()), null, cotizacion.getModalidad());
		InfoAprobacion infoAprobacion = retanqueoRes.getDatosAprobacion().getValue();
		co.com.flamingo.clienteRetanqueo.RespuestaMetodo respuestaMetodo = retanqueoRes.getRespuestaMetodo().getValue();

		BigDecimal idRetorno = respuestaMetodo.getIdRetorno();
		if (idRetorno.intValue() == 0) {
			String nroAprobacion = retanqueoRes.getDatosAprobacion().getValue().getNumeroAprobacion().getValue();
			Util.okDialog("Aprobación generada con éxito: " + nroAprobacion, new JFrame(), JOptionPane.PLAIN_MESSAGE);
			AprobacionRPT rpt = new AprobacionRPT(infoAprobacion);
			rpt.imprimir();
			DBServiceImplementation dbServiceImpl = new DBServiceImplementation();
			dbServiceImpl.sendEmailAprobacion(cotizacion.getCliente().geteMail(), infoAprobacion);
			this.setBlnCreditoGenerado(true);
		} else {
			String msg = "Error generando aprobación. Por favor verifique: " + respuestaMetodo.getIdRetorno() + ", "
					+ respuestaMetodo.getMensajeRetorno().getValue();
			Util.okDialog(msg, new JFrame(), JOptionPane.ERROR_MESSAGE);
		}
	}

	protected void txDocumentoClic() {
		kp.setLocationRelativeTo(ValidarClienteSafix.this);
		kp.setVisible(true, txNumeroDocumento.getText());
	}

	public void setVisible(boolean b, Cotizacion cotizacion) {
		if (b) {
			txNumeroDocumento.setText(cotizacion.getCliente().getClienteID());
			this.cotizacion = cotizacion;
			super.setVisible(b);
		}
	}

	protected void close() {
		setVisible(false);
		super.dispose();
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
	}

	public boolean isBlnCreditoGenerado() {
		return blnCreditoGenerado;
	}

	public void setBlnCreditoGenerado(boolean blnCreditoGenerado) {
		this.blnCreditoGenerado = blnCreditoGenerado;
	}

}
