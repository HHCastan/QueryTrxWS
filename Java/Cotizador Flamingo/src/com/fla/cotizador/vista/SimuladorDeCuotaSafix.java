package com.fla.cotizador.vista;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

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

import com.fla.cotizador.modelo.ClienteSicaf;
import com.fla.cotizador.modelo.Cotizacion;
import com.fla.cotizador.modelo.DetalleCotizacion;
import com.fla.cotizador.modelo.ProductosTableModel;
import com.fla.cotizador.modelo.Usuario;
import com.fla.cotizador.servicio.DBServiceImplementation;
import com.fla.cotizador.util.Auxiliar;
import com.fla.cotizador.util.CotizacionFinanciacionRPT;
import com.fla.cotizador.util.SendEMail;
import com.fla.cotizador.util.Util;

public class SimuladorDeCuotaSafix extends JDialog implements MouseListener {
	/**
	 * INICIA DEFINICIÓN DE VARIABLES DE CLASE
	 */
	private static final long serialVersionUID = 1L;

	/** Panel para ingreso de datos */
	private JPanel jpDatosIn;
	private JLabel lblValor = new JLabel("Valor a financiar:");
	private JTextField bxValor;
	private String sPrevValor = null; // para controlar si se cambia el valor a financiar

	/** Máximo número de meses: */
	private JLabel lblMeses = new JLabel("Cantidad de meses:");
	private final int MAX_MES = 48;
	private List<Integer> lNroMeses;
	private JComboBox<String> cbxMeses;
	private String sNromeses;
	/** Modalidad de Crédito: */
	private JComboBox<String> cbxModalidad;
	private String[] arModalidadCode = { "24", "28" };
	private String sModalidad;
	private JLabel lblModalidad = new JLabel("Modalidad de crédito:");
	/** Panel para desplegar Información */
	private JPanel jpCuotas;
	private JLabel lblCuotaSafix = new JLabel("Valor cuota Safix:");
	private JTextField bxCuotaSafix;

	/** Casillas para las observaciones */
	private JTextField bxObservaciones;

	/** otros datos para imprimir la cotización */
	private Cotizacion cotizacion;

	private JButton btnConsultar;
	private JButton btnImprimir;
	private JButton btnCredito;
	private JButton btnRegresar;
	private JButton btnBloqueo;
	private JButton btnEnviarXcorreo;
	private JButton btnUpCupoSafix;

	ProductosTableModel modeloPR;

	/** Para mostrar un popup con el teclado numérico */
	VirtualNumPad kp;

	Font fontBold = new Font("SansSerif", Font.BOLD, 20);
	Font fontPlain = new Font("SansSerif", Font.PLAIN, 16);

	Border raisedBorder = new SoftBevelBorder(SoftBevelBorder.RAISED);
	Border loweredBorder = new SoftBevelBorder(SoftBevelBorder.LOWERED);

	DBServiceImplementation dbServiceImpl = new DBServiceImplementation();

	private boolean blnPrinted;
	private boolean blnCreditoGenerado = false;
	
	private int nivel = 0; // Nivel al que llegó la cotización. Queda en 1 si se calculó la cuota

	private Usuario usuario;

	public SimuladorDeCuotaSafix(JFrame ventanaPadre) {
		super(ventanaPadre, true);
		inicializarComponentes(ventanaPadre);
		configurarVentana();
		componerVentana();

		adicionarListeners();
		adicionarComponentes();
	}

	private void configurarVentana() {
		setTitle("Flamingo - Simulador del valor de la cuota del Fiao");
		setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/Icono_Flamingo.png")));
		setModal(true);
		setSize(700, 450); // tamaño de la ventana
		setLayout(null); // no usamos ningun layout, solo asi podremos dar posiciones a los componentes
		setResizable(true); // hacemos que la ventana sea redimiensionable
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE); // hacemos que cuando se cierre la ventana termina todo
															// proceso
	}

	private void inicializarComponentes(JFrame ventanaPadre) {
		kp = new VirtualNumPad(ventanaPadre);
		bxValor = new JTextField();
		bxCuotaSafix = new JTextField("$ 0");
		bxObservaciones = new JTextField("Observaciones: ");
		jpDatosIn = new JPanel();
		jpCuotas = new JPanel();
		btnConsultar = new JButton();
		btnImprimir = new JButton();
		btnEnviarXcorreo = new JButton();
		btnCredito = new JButton();
		btnBloqueo = new JButton();
		btnRegresar = new JButton();
		btnUpCupoSafix = new JButton();

		// Inicializa el combo box de número de meses:
		lNroMeses = new ArrayList<Integer>();
		for (int i = 1; i <= MAX_MES; i++)
			lNroMeses.add(i);
		cbxMeses = new JComboBox(lNroMeses.toArray());
		cbxMeses.setSelectedIndex(11);

		// Inicia el combo box para las modalidades:
		String[] arModalidadDesc = { "CREDITO FLAMINGO", "CREDITO FLAMINGO HOGAR" };
		cbxModalidad = new JComboBox<String>(arModalidadDesc);
	}

	private void componerVentana() {
		// Valor a financiar
		jpDatosIn.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), " Datos de Entrada: "));
		jpDatosIn.setBounds(15, 5, 550, 170);
		jpDatosIn.setLayout(null);

		lblValor.setBounds(10, 20, 200, 30);
		lblValor.setFont(fontPlain);
		lblValor.setHorizontalAlignment(SwingConstants.RIGHT);
		bxValor.setBounds(220, 20, 200, 30);
		bxValor.setBorder(loweredBorder);
		bxValor.setFont(fontBold);

		// cantidad de meses a financiar
		lblMeses.setBounds(10, 70, 200, 30);
		lblMeses.setFont(fontPlain);
		lblMeses.setHorizontalAlignment(SwingConstants.RIGHT);
		cbxMeses.setBounds(220, 70, 100, 30);
		cbxMeses.setFont(fontBold);

		// Modalidad de Crédito
		lblModalidad.setBounds(10, 120, 200, 30);
		lblModalidad.setFont(fontPlain);
		lblModalidad.setHorizontalAlignment(SwingConstants.RIGHT);
		cbxModalidad.setBounds(220, 120, 300, 30);
		cbxModalidad.setFont(fontPlain);
		cbxModalidad.setEnabled(false);

		// Información del valor de la cuota
		jpCuotas.setBorder(
				BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), " Valor de la cuota mensual: "));
		jpCuotas.setBounds(15, 185, 420, 100);
		jpCuotas.setLayout(null);

		lblCuotaSafix.setBounds(20, 30, 150, 30);
		lblCuotaSafix.setFont(fontPlain);
		lblCuotaSafix.setHorizontalAlignment(SwingConstants.RIGHT);
		bxCuotaSafix.setBounds(200, 30, 150, 30);
		bxCuotaSafix.setBorder(loweredBorder);
		bxCuotaSafix.setFont(fontPlain);
		bxCuotaSafix.setEditable(false);
		bxCuotaSafix.setFont(fontBold);
		// Botón para solicitar aumento de cupo en Safix
		btnUpCupoSafix.setBounds(360, 27, 40, 40);
		btnUpCupoSafix.setIcon(new ImageIcon(this.getClass().getResource("/images/Arrow_Up_32.png")));
		btnUpCupoSafix.setBorder(raisedBorder);
		btnUpCupoSafix.setVisible(false);
		btnUpCupoSafix.setToolTipText("Solicitar aumento de cupo");

		// casilla para las observaciones
		bxObservaciones.setBounds(15, 330, 420, 60);
		bxObservaciones.setFont(fontPlain);
		bxObservaciones.setBorder(loweredBorder);

		// Botón para ejecutar la consulta
		btnConsultar.setText("Consultar");
		btnConsultar.setBounds(470, 190, 80, 60);
		btnConsultar.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnConsultar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnConsultar.setIcon(new ImageIcon(this.getClass().getResource("/images/check32.png")));
		btnConsultar.setBorder(raisedBorder);

		// Botón para imprimir la cotización
		btnImprimir.setText("Imprimir");
		btnImprimir.setBounds(470, 265, 80, 60);
		btnImprimir.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnImprimir.setHorizontalTextPosition(SwingConstants.CENTER);
		btnImprimir.setIcon(new ImageIcon(this.getClass().getResource("/images/print32.png")));
		btnImprimir.setBorder(raisedBorder);

		// Botón para enviar por correo la cotización
		btnEnviarXcorreo.setText("Enviar");
		btnEnviarXcorreo.setBounds(590, 190, 80, 60);
		btnEnviarXcorreo.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnEnviarXcorreo.setHorizontalTextPosition(SwingConstants.CENTER);
		btnEnviarXcorreo.setIcon(new ImageIcon(this.getClass().getResource("/images/Correo32.png")));
		btnEnviarXcorreo.setBorder(raisedBorder);

		// Botón para generar el crédito
		btnCredito.setText("Crédito");
		btnCredito.setBounds(590, 265, 80, 60);
		btnCredito.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnCredito.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCredito.setIcon(new ImageIcon(this.getClass().getResource("/images/cheque32.png")));
		btnCredito.setBorder(raisedBorder);

		// Botón para generar el crédito
		btnBloqueo.setText("Bloqueado");
		btnBloqueo.setBounds(590, 265, 80, 60);
		btnBloqueo.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnBloqueo.setHorizontalTextPosition(SwingConstants.CENTER);
		btnBloqueo.setIcon(new ImageIcon(this.getClass().getResource("/images/Stop32.png")));
		btnBloqueo.setBorder(raisedBorder);
		btnBloqueo.setVisible(false);

		// Botón para ejecutar la consulta
		btnRegresar.setText("Regresar");
		btnRegresar.setBounds(590, 340, 80, 60);
		btnRegresar.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnRegresar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnRegresar.setIcon(new ImageIcon(this.getClass().getResource("/images/return32.png")));
		btnRegresar.setBorder(raisedBorder);
	}

	/**
	 * adicionarListeners()
	 * 
	 */
	private void adicionarListeners() {
		// para activar el teclado numérico
		bxValor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				bxValorClic();
			}
		});

		// para determinar si cambio el valor de financiamieto
		bxValor.addKeyListener(keyListenerVlr);
		bxValor.addFocusListener(focusListenerVlr);

		// Agregamos un listener para saber número de meses fue cambiado
		cbxMeses.addItemListener(new NroMesesChangeListener());

		// Agregamos un listener para saber si modalidad de crédito fue cambiada
		cbxModalidad.addItemListener(new ModalidadChangeListener());

		// Agregamos listener para cambiar el texto de las observaciones
		bxObservaciones.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				bxObservacionesClic();
			}
		});

		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				consultar();
			}
		});

		btnImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				imprimir();
			}
		});

		btnEnviarXcorreo.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseReleased(java.awt.event.MouseEvent evt) {
				enviarXcorreo();
			}
		});

		btnCredito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				credito();
			}

		});

		btnRegresar.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseReleased(java.awt.event.MouseEvent evt) {
				close();
			}
		});

		btnBloqueo.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseReleased(java.awt.event.MouseEvent evt) {
				mostrarBloqueo();
			}
		});

		btnUpCupoSafix.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseReleased(java.awt.event.MouseEvent evt) {
				SolicitarAmpliacionSafix();
			}
		});

	}

	private void adicionarComponentes() {
		jpDatosIn.add(lblValor);
		jpDatosIn.add(bxValor);
		jpDatosIn.add(lblMeses);
		jpDatosIn.add(cbxMeses);
		jpDatosIn.add(lblModalidad);
		jpDatosIn.add(cbxModalidad);

		jpCuotas.add(lblCuotaSafix);
		jpCuotas.add(bxCuotaSafix);
		jpCuotas.add(btnUpCupoSafix);

		add(jpDatosIn);
		add(jpCuotas);
		add(bxObservaciones);
		add(btnConsultar);
		add(btnImprimir);
		add(btnCredito);
		add(btnEnviarXcorreo);
		add(btnBloqueo);
		add(btnRegresar);
	}
	
	protected void consultar() {
		int index = cbxMeses.getSelectedIndex();
		sNromeses = index + 1 + "";
		index = cbxModalidad.getSelectedIndex();
		sModalidad = arModalidadCode[index];
		String sValor = Util.removeMoneyFormat(bxValor.getText());
		String sTienda = Util.zeroPad(cotizacion.getTienda().getCodigo(), 3);
		if(Integer.parseInt(sTienda) < 100) 
			sTienda = sTienda.substring(1);
		String sCuotaSafix = dbServiceImpl.getCuotaSafix(sNromeses, sValor, sModalidad,	sTienda);
		bxCuotaSafix.setText(Util.moneyFormat(sCuotaSafix, 0));
		this.nivel = 1;
	}

	protected void imprimir() {
		if (!Util.tienePermiso(19, usuario)) { // El bit 19 corresponde a la opción de impresión
			Util.okDialog("No tiene autorización para esta acción", new JFrame(), JOptionPane.ERROR_MESSAGE);
			return;
		}

		if ((bxCuotaSafix.getText().compareTo("$ 0") == 0) && (Auxiliar.mediosCredito(cotizacion.getModeloMP()))) {
			Util.okDialog("Primero debe consultar la cuota", new JFrame(), JOptionPane.ERROR_MESSAGE);
			return;
		}

		if (isBlnPrinted()) {
			Util.okDialog("Ya hizo una impresión de esta cotización", new JFrame(), JOptionPane.ERROR_MESSAGE);
			return;
		}

		fillCotizacion();
		CotizacionFinanciacionRPT rpt = new CotizacionFinanciacionRPT(cotizacion);
		rpt.imprimir();
		blnPrinted = true;
	}

	protected void enviarXcorreo() {
		if (!Util.tienePermiso(20, usuario)) { // El bit 20 corresponde a la opción de enviar x correo
			Util.okDialog("No tiene autorización para esta acción", new JFrame(), JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		fillCotizacion();
		String correo = cotizacion.getCliente().geteMail();
		if (correo == null) {
			Util.okDialog("El cliente es genérico o no tiene correo configurado. Debe ir a crédito", new JFrame(), JOptionPane.ERROR_MESSAGE);
			return;			
		}

		Object[] options = { "Si, enviar correo", "No, cancela acción" };
		String msg = "Se enviará cotización al correo " + Util.ofuscarCorreo(correo) + ". ¿Desea continuar?";
		int h = Util.sigaPareMessage(msg, new JDialog(), JOptionPane.QUESTION_MESSAGE, options);
		if (h == 0) {
			CotizacionFinanciacionRPT rpt = new CotizacionFinanciacionRPT(cotizacion);
			String pdfFileName = rpt.getPdfFileName();
			Properties properties = Util.getProperties();
			String smtp = properties.getProperty("eMailSMTP");
			String port = properties.getProperty("eMailPort");
			String pwd = properties.getProperty("eMailPwd");
			String from = properties.getProperty("eMailFrom");
			String subject = "Cotización Flamingo";
			String text = "Te enviamos la cotizacion solicitada";
			if (!SendEMail.sendEMail(smtp, port, pwd, from, correo, subject, text, pdfFileName) ) {
				Util.okDialog("Ocurrió un error enviando el correo. Intente nuevamente o reporte a la Mesa de ayuda", new JFrame(), JOptionPane.ERROR_MESSAGE);
			} else {
				Util.okDialog("El correo fue enviado satisfactoriamente", new JFrame(), JOptionPane.INFORMATION_MESSAGE);
			}
		} else {
			Util.okDialog("Si el correo no es el indicado, debe ir a crédito", new JFrame(), JOptionPane.ERROR_MESSAGE);
		}
	}

	private void fillCotizacion() {
		cotizacion.setMeses(cbxMeses.getSelectedIndex() + 1 + "");
		cotizacion.setCuotaSafix(bxCuotaSafix.getText());
		cotizacion.setCuotaMefia("0");
		cotizacion.setObservaciones(bxObservaciones.getText());
		cotizacion.setModalidad(sModalidad);
		cotizacion.setVlrFinanciar(bxValor.getText());
		cotizacion.setNivel(this.nivel);
	}

	protected void bxValorClic() {
		kp.setLocationRelativeTo(SimuladorDeCuotaSafix.this);
		kp.setVisible(true, Util.removeMoneyFormat(bxValor.getText()));
		bxValor.setText(Util.moneyFormat(kp.getValue(), 0));
		clean();
	}

	protected void bxObservacionesClic() {
		bxObservaciones.setText("");
	}

	/**
	 * Al editar el valor del monto a financiar
	 */
	KeyListener keyListenerVlr = new KeyListener() {
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				if (sPrevValor.compareTo(bxValor.getText()) != 0) {
					sPrevValor = bxValor.getText();
				}
			} else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
				bxValor.setText(sPrevValor);
			}
		}

		public void keyReleased(KeyEvent e) {
		}

		public void keyTyped(KeyEvent e) {
		}
	};

	/**
	 * Si el valor cambia al dejar la casilla
	 */
	FocusListener focusListenerVlr = new FocusListener() {
		public void focusGained(FocusEvent e) {
			sPrevValor = bxValor.getText();
		}

		public void focusLost(FocusEvent e) {
			if (!e.isTemporary() && isEnabled()) {
				if (sPrevValor.compareTo(bxValor.getText()) != 0) {
					sPrevValor = bxValor.getText();
					clean();
				}
			}
		}
	};

	protected void credito() {
		if (!Util.tienePermiso(23, usuario)) { // El bit 23 es la opción de generar crédito
			Util.okDialog("Usuario no autorizado para otorgar crédito. El cliente debe ir a Crédito", new JFrame(), JOptionPane.ERROR_MESSAGE);
			return;
		}

		int valor = Integer.valueOf(Util.removeMoneyFormat(bxValor.getText()));
		int disponible = cotizacion.getCliente().getClienteCupo();
		fillCotizacion();
		Object[] options = { "Cliente acepta", "Cliente rechaza" };
		if (valor >= disponible) {
			StringBuilder msg = new StringBuilder(
					"Cupo disponible: " + Util.moneyFormat(Integer.toString(disponible), 0));
			msg.append(". Diferencia: " + Util.moneyFormat(Integer.toString(valor - disponible), 0));
			msg.append("\nDesea obtener un crédito por el valor del cupo disponible?");
			int x = Util.sigaPareMessage(msg.toString(), this, JOptionPane.QUESTION_MESSAGE, options);
			if (x != 0) {
				return;
			}
			cotizacion.setVlrFinanciar(Integer.toString(disponible));
		} else {
			String message = "El cliente tiene cupo disponible. ¿Desea solicitar el crédito?";
			int x = Util.sigaPareMessage(message, this, JOptionPane.QUESTION_MESSAGE, options);
			if (x != 0) {
				return;
			}
			/**
			 * Las siguientes líneas se colocan mientras no se permita que el asesor genere el crédito
			 */
//			Util.okDialog("Usuario no autorizado para otorgar crédito. El cliente debe ir a Crédito", new JFrame(), JOptionPane.ERROR_MESSAGE);
//			return;
		}

		final ValidarClienteSafix vcs = new ValidarClienteSafix(new JFrame());
		vcs.setVisible(true, cotizacion);
		this.setBlnCreditoGenerado(vcs.isBlnCreditoGenerado());
		if(this.isBlnCreditoGenerado()) {
			cotizacion.setNivel(2);
			ArrayList<DetalleCotizacion> detalle = new ArrayList<>();
			detalle = Auxiliar.getDetalleCotizacion(modeloPR);
			Auxiliar.salvarCotizacion(cotizacion, detalle);
		}
		close();

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

	public void setVisible(boolean b, Cotizacion cotizacion, Usuario usuario) {
		if (b) {
			bxValor.setText(cotizacion.getValor());
			this.cotizacion = cotizacion;
			// 20210422 La siguiente línea se omite por requerimiento del negocio ya que no se tendrá más modalidad credi Hogar
            // cbxModalidad.setSelectedIndex(Auxiliar.getGrupoArticulo(cotizacion.getModeloPR()));
			this.usuario = usuario;
			clean();
			btnCredito.setVisible(true);
			btnBloqueo.setVisible(false);

			if (isBloqueado()) {
				btnCredito.setVisible(false);
				btnBloqueo.setVisible(true);
			} else {
				if(cotizacion.getCliente().getClienteCupo() < Integer.parseInt(Util.removeMoneyFormat(cotizacion.getValor())))
					btnUpCupoSafix.setVisible(true);
			}
			
		}
		super.setVisible(b);
	}

	private boolean isBloqueado() {
		Properties propDB = Util.getPropertiesDB();
		int maxDiasSinActualizar = Integer.parseInt(propDB.getProperty("SAFIX.maxDiasSinActualizar"));
//		int maxDiasSinActualizar = 180;
		ClienteSicaf cliente = cotizacion.getCliente();
		if ((cliente.getClienteCupo() < 1) || (cliente.getClienteBloqueo() != null)
				|| (cliente.getDocumentacionImpresa().compareTo("S") != 0)
				|| (cliente.getDocumentosCustodia().compareTo("S") != 0) 
				|| (cliente.getApto().compareTo("S") != 0)
				|| (cliente.getNug() == null) || (cliente.getNroCelular() == null)
				|| (diasActualizado(cliente.getFechaActualizado()) > maxDiasSinActualizar))
			return true;
		return false;
	}

	private long diasActualizado(Date fechaActualizado) {
		long startTime = fechaActualizado.getTime();
		long endTime = System.currentTimeMillis();
		;
		long diffTime = endTime - startTime;
		long diffDays = diffTime / (1000 * 60 * 60 * 24);
		System.out.println("Días desde última actualización: " + diffDays);
		return diffDays;
	}

	protected void SolicitarAmpliacionSafix() {
		int valorSolicitud = Integer.parseInt(Util.removeMoneyFormat(cotizacion.getValor())) - cotizacion.getCliente().getClienteCupo();
		String mensaje = "Solicitud aumento de cupo en Safix por $" + valorSolicitud;
		if(dbServiceImpl.sendeMailAlert( cotizacion,  mensaje) == 0)
			System.out.println("Correo enviado");
		
	}

	public void close() {
		bxValor.setText("321");
		setVisible(false);
		super.dispose();
	}

	/**
	 * Clase para controlar el item seleccionado en el combo box
	 * 
	 * @author hcastaneda
	 *
	 */
	class NroMesesChangeListener implements ItemListener {
		@Override
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				clean();
			}

		}
	}

	/**
	 * Clase para controlar el item seleccionado en el combo box
	 * 
	 * @author hcastaneda
	 *
	 */
	class ModalidadChangeListener implements ItemListener {
		@Override
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				bxCuotaSafix.setText("$ 0");
			}

		}
	}

	public void clean() {
		bxCuotaSafix.setText("$ 0");
		blnPrinted = false;
	}

	public void mostrarBloqueo() {
		StringBuilder msg = new StringBuilder("Mensaje de bloqueo: " + cotizacion.getCliente().getClienteBloqueo());
		int valor = Integer.valueOf(Util.removeMoneyFormat(bxValor.getText()));
		int disponible = cotizacion.getCliente().getClienteCupo();
		if (valor >= disponible)
			msg.append("\nCupo insuficiente");
		else
			msg.append("\nCupo suficiente");
		Util.okDialog(msg.toString(), new JFrame(), JOptionPane.WARNING_MESSAGE);
	}

	public boolean isBlnCreditoGenerado() {
		return blnCreditoGenerado;
	}

	public void setBlnCreditoGenerado(boolean blnCreditoGenerado) {
		this.blnCreditoGenerado = blnCreditoGenerado;
	}

	public boolean isBlnPrinted() {
		return blnPrinted;
	}

	public String getBxCuotaSafix() {
		return this.bxCuotaSafix.getText();
	}

	public String getNroMeses() {
		return sNromeses;
	}

}
