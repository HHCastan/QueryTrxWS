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

import com.fla.cotizador.dto.CuotaMefia;
import com.fla.cotizador.modelo.Cotizacion;
import com.fla.cotizador.modelo.ProductosTableModel;
import com.fla.cotizador.modelo.Usuario;
import com.fla.cotizador.servicio.DBServiceImplementation;
import com.fla.cotizador.util.CotizacionFinanciacionRPT;
import com.fla.cotizador.util.SendEMail;
import com.fla.cotizador.util.Util;

public class SimuladorDeCuotaMefia extends JDialog implements MouseListener {
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
	private final int MAX_MES = 60;
	private List<Integer> lNroMeses;
	private JComboBox<String> cbxMeses;
	/** Panel para desplegar Información */
	private JPanel jpCuotas;
	private JLabel lblCuotaMefia = new JLabel("Valor cuota Mefía*:");
	private JTextField bxCuotaMefia;
	private JLabel lblCuotaManejoSeguro = new JLabel("Cuota manejo+seguro**:");
	private JTextField bxCuotaManejoSeguro;
	private JLabel lblObservaMefia = new JLabel("* Primero debe calcular la cuota");

	/** Casillas para las observaciones */
	private JTextField bxObservaciones;

	/** otros datos para imprimir la cotización */
	private Cotizacion cotizacion;

	private JButton btnConsultar;
	private JButton btnImprimir;
	private JButton btnRegresar;
	private JButton btnUpCupoMefia;
	private JButton btnEnviarXcorreo;

	ProductosTableModel modeloPR;

	/** Para mostrar un popup con el teclado numérico */
	VirtualNumPad kp;

	Font fontBold = new Font("SansSerif", Font.BOLD, 20);
	Font fontPlain = new Font("SansSerif", Font.PLAIN, 16);

	Border raisedBorder = new SoftBevelBorder(SoftBevelBorder.RAISED);
	Border loweredBorder = new SoftBevelBorder(SoftBevelBorder.LOWERED);

	DBServiceImplementation dbServiceImpl = new DBServiceImplementation();

	private final String MEFIA_EXPRESS = "8.1.1.0.1";
	private final String TC_MEFIA = "8.1.1.0";
	private final String MEFIA_MOTOS = "8.1.3.0";

	private boolean blnPrinted;
	
	private int nivel = 0; // Nivel al que llegó la cotización. Queda en 1 si se calculó la cuota

	private Usuario usuario;

	public SimuladorDeCuotaMefia(JFrame ventanaPadre) {
		super(ventanaPadre, true);
		inicializarComponentes(ventanaPadre);
		configurarVentana();
		componerVentana();

		adicionarListeners();
		adicionarComponentes();
	}

	private void configurarVentana() {
		setTitle("Flamingo - Simulador del valor de la cuota Mefía");
		setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/Icono_Flamingo.png")));
		setModal(true);
		setSize(700, 550); // tamaño de la ventana
		setLayout(null); // no usamos ningun layout, solo asi podremos dar posiciones a los componentes
		setResizable(true); // hacemos que la ventana sea redimiensionable
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE); // hacemos que cuando se cierre la ventana termina todo
															// proceso
	}

	private void inicializarComponentes(JFrame ventanaPadre) {
		kp = new VirtualNumPad(ventanaPadre);
		bxValor = new JTextField();
		bxCuotaMefia = new JTextField("$ 0");
		bxCuotaManejoSeguro = new JTextField("$ 0");
		bxObservaciones = new JTextField("Observaciones: ");
		jpDatosIn = new JPanel();
		jpCuotas = new JPanel();
		btnConsultar = new JButton();
		btnImprimir = new JButton();
		btnEnviarXcorreo = new JButton();
		btnRegresar = new JButton();
		btnUpCupoMefia = new JButton();

		// Inicializa el combo box de número de meses:
		lNroMeses = new ArrayList<Integer>();
		for (int i = 1; i <= MAX_MES; i++)
			lNroMeses.add(i);
		cbxMeses = new JComboBox(lNroMeses.toArray());
		cbxMeses.setSelectedIndex(11);

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

		// Información del valor de la cuota
		jpCuotas.setBorder(
				BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), " Valor de la cuota mensual: "));
		jpCuotas.setBounds(15, 185, 420, 230);
		jpCuotas.setLayout(null);

		lblCuotaMefia.setBounds(20, 30, 150, 30);
		lblCuotaMefia.setFont(fontPlain);
		lblCuotaMefia.setHorizontalAlignment(SwingConstants.RIGHT);
		
		bxCuotaMefia.setBounds(200, 30, 150, 30);
		bxCuotaMefia.setBorder(loweredBorder);
		bxCuotaMefia.setEditable(false);
		bxCuotaMefia.setFont(fontBold);

		lblCuotaManejoSeguro.setBounds(20, 90, 170, 30);
		lblCuotaManejoSeguro.setFont(fontPlain);
		lblCuotaManejoSeguro.setHorizontalAlignment(SwingConstants.RIGHT);

		bxCuotaManejoSeguro.setBounds(200, 90, 150, 30);
		bxCuotaManejoSeguro.setBorder(loweredBorder);
		bxCuotaManejoSeguro.setEditable(false);
		bxCuotaManejoSeguro.setFont(fontBold);
		
		// Botón para solicitar aumento de cupo en Mefia
		btnUpCupoMefia.setBounds(360, 87, 40, 40);
		btnUpCupoMefia.setIcon(new ImageIcon(this.getClass().getResource("/images/Arrow_Up_32.png")));
		btnUpCupoMefia.setBorder(raisedBorder);
		btnUpCupoMefia.setVisible(false);
		btnUpCupoMefia.setToolTipText("Solicitar aumento de cupo");
		lblObservaMefia.setBounds(5, 142, 390, 80);
		lblObservaMefia.setFont(fontPlain);

		// casilla para las observaciones
		bxObservaciones.setBounds(15, 430, 420, 60);
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
		btnEnviarXcorreo.setBounds(470, 340, 80, 60);
		btnEnviarXcorreo.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnEnviarXcorreo.setHorizontalTextPosition(SwingConstants.CENTER);
		btnEnviarXcorreo.setIcon(new ImageIcon(this.getClass().getResource("/images/Correo32.png")));
		btnEnviarXcorreo.setBorder(raisedBorder);

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

		btnRegresar.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseReleased(java.awt.event.MouseEvent evt) {
				close();
			}
		});

		btnUpCupoMefia.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseReleased(java.awt.event.MouseEvent evt) {
				SolicitarAmpliacionMefia();
			}
		});

	}

	private void adicionarComponentes() {
		jpDatosIn.add(lblValor);
		jpDatosIn.add(bxValor);
		jpDatosIn.add(lblMeses);
		jpDatosIn.add(cbxMeses);
		jpCuotas.add(lblCuotaMefia);
		jpCuotas.add(bxCuotaMefia);
		jpCuotas.add(lblCuotaManejoSeguro);
		jpCuotas.add(bxCuotaManejoSeguro);
		jpCuotas.add(btnUpCupoMefia);
		jpCuotas.add(lblObservaMefia);

		add(jpDatosIn);
		add(jpCuotas);
		add(bxObservaciones);
		add(btnConsultar);
		add(btnImprimir);
		add(btnEnviarXcorreo);
		add(btnRegresar);
	}

	protected void consultar() {
		int index = cbxMeses.getSelectedIndex();
		String sNromeses = index + 1 + "";
		String sValor = Util.removeMoneyFormat(bxValor.getText());
		String sCuotaMefia = dbServiceImpl.getCuotaMefia(new CuotaMefia(sValor, sNromeses, TC_MEFIA));
		bxCuotaMefia.setText(Util.moneyFormat(sCuotaMefia, 0));
		int cuotaManejo = dbServiceImpl.getCuotaManejo(cotizacion.getCliente().getClienteID());
		bxCuotaManejoSeguro.setText(Util.moneyFormat(Integer.toString(cuotaManejo), 0));
		int cuotaTotal = Integer.parseInt(sCuotaMefia) + cuotaManejo;
		String sObservacionMefia;
		int disponible = cotizacion.getCliente().getCupoMefia();
		int nroCreditos = cotizacion.getCliente().getCreditosMefia();
		sObservacionMefia = "<html>* El valor no incluye cuota de manejo ni seguro.<br/>";
		if (disponible >= Integer.parseInt(sValor)) 
			sObservacionMefia = sObservacionMefia + "El cliente tiene cupo disponible para esta compra.<br/>";
		else
			sObservacionMefia = sObservacionMefia + "El cliente no tiene cupo disponible para esta compra.<br/>";
		
		sObservacionMefia = sObservacionMefia + "Actualmente tiene " + nroCreditos + " créditos activos<br/>";
		sObservacionMefia = sObservacionMefia + "**Se suma si no tiene créditos activos ( <b>";
		sObservacionMefia = sObservacionMefia + Util.moneyFormat(Integer.toString(cuotaTotal), 0) +"</b>)</html>";
		lblObservaMefia.setText(sObservacionMefia);
		lblObservaMefia.repaint();
		this.nivel = 1;
	}

	protected void imprimir() {
		if (!Util.tienePermiso(19, usuario)) { // El bit 19 corresponde a la opción de impresión
			Util.okDialog("No tiene autorización para esta acción", new JFrame(), JOptionPane.ERROR_MESSAGE);
			return;
		}

		if (blnPrinted) {
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
		cotizacion.setCuotaSafix("0");
		cotizacion.setCuotaMefia(bxCuotaMefia.getText());
		cotizacion.setObservaciones(bxObservaciones.getText());
		cotizacion.setModalidad("0");
		cotizacion.setVlrFinanciar(bxValor.getText());
		cotizacion.setNivel(this.nivel);
	}

	protected void bxValorClic() {
		kp.setLocationRelativeTo(SimuladorDeCuotaMefia.this);
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
			this.usuario = usuario;
			clean();
			int valorAfinanciar = Integer.parseInt(Util.removeMoneyFormat(cotizacion.getValor()));
			if( (cotizacion.getCliente().getCupoMefia() < valorAfinanciar) && (cotizacion.getCliente().getClienteID().compareTo("9999999999999999999") != 0) )
				btnUpCupoMefia.setVisible(true);
		}
		super.setVisible(b);
	}

	protected void SolicitarAmpliacionMefia() {
		int valorSolicitud = Integer.parseInt(Util.removeMoneyFormat(cotizacion.getValor())) - cotizacion.getCliente().getClienteCupo();
		String mensaje = "Solicitud aumento de cupo en Mefia por $" + valorSolicitud;
		if(dbServiceImpl.sendeMailAlert( cotizacion,  mensaje) == 0)
			System.out.println("Correo enviado");
		
	}

	public void close() {
		bxValor.setText("321");
		lblObservaMefia.setText("* Primero debe calcular la cuota");
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

	public void clean() {
		bxCuotaMefia.setText("$ 0");
		bxCuotaManejoSeguro.setText("$ 0");
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

	public boolean isBlnPrinted() {
		return blnPrinted;
	}

	public void setValor(String valor) {
		bxValor.setText(valor);
	}

}
