package com.fla.cotizador.vista;

import java.awt.Desktop;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.UnknownHostException;
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

import org.apache.log4j.Logger;

import com.fla.cotizador.modelo.NewCustomer;
import com.fla.cotizador.modelo.Usuario;
import com.fla.cotizador.servicio.DBServiceImplementation;
import com.fla.cotizador.util.HabeasDataRPT;
import com.fla.cotizador.util.SendEMail;
import com.fla.cotizador.util.Util;

import jcifs.smb.NtlmPasswordAuthentication;
import jcifs.smb.SmbException;
import jcifs.smb.SmbFile;
import jcifs.smb.SmbFileOutputStream;

public class CapturaDatosCliente extends JDialog implements MouseListener {

	/**
	 * INICIA DEFINICIÓN DE VARIABLES DE CLASE
	 */
	private static final long serialVersionUID = 1L;

	private Logger log = Util.getLogger();

	/** Panel para el ingreso de los datos */
	private JPanel jpDatosIn;
	private JLabel lblTipoDoc = new JLabel(" Tipo Documento:");
	private JComboBox<?> cbxTipoDoc;
	private JLabel lblDocumento = new JLabel("Documento Nro.:");
	private JTextField bxDocumento;
	private JLabel lblApellido1 = new JLabel("Primer Apellido:");
	private JTextField bxApellido1;
	private JLabel lblApellido2 = new JLabel("Segundo Apellido:");
	private JTextField bxApellido2;
	private JLabel lblNombre1 = new JLabel("Primer Nombre:");
	private JTextField bxNombre1;
	private JLabel lblNombre2 = new JLabel("Segundo Nombre:");
	private JTextField bxNombre2;
	private JLabel lblTelefono = new JLabel("Telefono:");
	private JTextField bxTelefono;
	private JLabel lblEmail = new JLabel("e-Mail:");
	private JTextField bxEmail;
	private JLabel lblPrioridad = new JLabel("Prioridad (1/2):");
	private JComboBox<?> cbxPrioridad;

	private String sTienda;
	private Usuario usuario;

	private JButton btnScan;
	private JButton btnHabeas;
	private JButton btnEnviar;
	private JButton btnRegresar;
	private JButton btnHolaVendedor;

	/** Para mostrar un popup con el teclado numérico */
	VirtualNumPad kp;

	private String pdfFileName = "";

	Font fontBold = new Font("SansSerif", Font.BOLD, 20);
	Font fontPlain = new Font("SansSerif", Font.PLAIN, 16);

	Border raisedBorder = new SoftBevelBorder(SoftBevelBorder.RAISED);
	Border loweredBorder = new SoftBevelBorder(SoftBevelBorder.LOWERED);

	DBServiceImplementation dbServiceImpl = new DBServiceImplementation();

	public CapturaDatosCliente(JFrame ventanaPadre) {
		super(ventanaPadre, true);
		inicializarComponentes(ventanaPadre);
		configurarVentana();
		componerVentana();
		adicionarListeners();
		adicionarComponentes();
	}

	private void configurarVentana() {
		setTitle("Flamingo - Captura datos de Cliente nuevo");
		setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/Icono_Flamingo.png")));
		setModal(true);
		setSize(700, 500); // tamaño de la ventana
		setLayout(null); // no usamos ningun layout, solo asi podremos dar posiciones a los componentes
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE); // hacemos que cuando se cierre la ventana termina todo proceso
	}

	private void inicializarComponentes(JFrame ventanaPadre) {
		kp = new VirtualNumPad(ventanaPadre);
		jpDatosIn = new JPanel();
		btnScan = new JButton();
		btnHabeas = new JButton();
		btnEnviar = new JButton();
		btnRegresar = new JButton();
		btnHolaVendedor = new JButton();
		bxDocumento = new JTextField();
		bxApellido1 = new JTextField();
		bxApellido2 = new JTextField();
		bxNombre1 = new JTextField();
		bxNombre2 = new JTextField();
		bxTelefono = new JTextField();
		bxEmail = new JTextField();

		// Inicia el combo box para las modalidades:
		String[] arTipoDoc = { "TI", "CC", "NI", "CE" };
		cbxTipoDoc = new JComboBox(arTipoDoc);
		cbxTipoDoc.setSelectedIndex(1);

		// Inicia el combo box para las modalidades:
		String[] arPrioridad = { "1", "2" };
		cbxPrioridad = new JComboBox(arPrioridad);
		cbxPrioridad.setSelectedIndex(1);

	}

	private void componerVentana() {
		// Ubica los componentes en pantalla
		jpDatosIn.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), " Datos Cliente Nuevo: "));
		jpDatosIn.setBounds(15, 5, 545, 430);
		jpDatosIn.setLayout(null);

		// Tipo de documento
		lblTipoDoc.setBounds(10, 20, 170, 30);
		lblTipoDoc.setFont(fontPlain);
		lblTipoDoc.setHorizontalAlignment(SwingConstants.RIGHT);
		cbxTipoDoc.setBounds(200, 20, 50, 30);
		cbxTipoDoc.setFont(fontPlain);
		lblDocumento.setBounds(260, 20, 130, 30);
		lblDocumento.setFont(fontPlain);
		lblDocumento.setHorizontalAlignment(SwingConstants.RIGHT);
		bxDocumento.setBounds(400, 20, 130, 30);
		bxDocumento.setBorder(loweredBorder);
		bxDocumento.setFont(fontBold);
		bxDocumento.setEditable(false);

		lblApellido1.setBounds(10, 70, 170, 30);
		lblApellido1.setFont(fontPlain);
		lblApellido1.setHorizontalAlignment(SwingConstants.RIGHT);
		bxApellido1.setBounds(190, 70, 340, 30);
		bxApellido1.setBorder(loweredBorder);
		bxApellido1.setFont(fontBold);

		lblApellido2.setBounds(10, 120, 170, 30);
		lblApellido2.setFont(fontPlain);
		lblApellido2.setHorizontalAlignment(SwingConstants.RIGHT);
		bxApellido2.setBounds(190, 120, 340, 30);
		bxApellido2.setBorder(loweredBorder);
		bxApellido2.setFont(fontBold);

		lblNombre1.setBounds(10, 170, 170, 30);
		lblNombre1.setFont(fontPlain);
		lblNombre1.setHorizontalAlignment(SwingConstants.RIGHT);
		bxNombre1.setBounds(190, 170, 340, 30);
		bxNombre1.setBorder(loweredBorder);
		bxNombre1.setFont(fontBold);

		lblNombre2.setBounds(10, 220, 170, 30);
		lblNombre2.setFont(fontPlain);
		lblNombre2.setHorizontalAlignment(SwingConstants.RIGHT);
		bxNombre2.setBounds(190, 220, 340, 30);
		bxNombre2.setBorder(loweredBorder);
		bxNombre2.setFont(fontBold);

		lblTelefono.setBounds(10, 270, 170, 30);
		lblTelefono.setFont(fontPlain);
		lblTelefono.setHorizontalAlignment(SwingConstants.RIGHT);
		bxTelefono.setBounds(190, 270, 340, 30);
		bxTelefono.setBorder(loweredBorder);
		bxTelefono.setFont(fontBold);

		lblEmail.setBounds(10, 320, 170, 30);
		lblEmail.setFont(fontPlain);
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		bxEmail.setBounds(190, 320, 340, 30);
		bxEmail.setBorder(loweredBorder);
		bxEmail.setFont(fontPlain);

		lblPrioridad.setBounds(10, 370, 170, 30);
		lblPrioridad.setFont(fontPlain);
		lblPrioridad.setHorizontalAlignment(SwingConstants.RIGHT);
		cbxPrioridad.setBounds(190, 370, 50, 30);
		cbxPrioridad.setFont(fontPlain);

		// Botón para firmar escanear la cédula
		btnScan.setText("Escanear");
		btnScan.setBounds(580, 20, 80, 60);
		btnScan.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnScan.setHorizontalTextPosition(SwingConstants.CENTER);
		btnScan.setIcon(new ImageIcon(this.getClass().getResource("/images/CedulaBack64.png")));
		btnScan.setBorder(raisedBorder);

		// Botón para firmar el Habeas data
		btnHabeas.setText("Firmar");
		btnHabeas.setBounds(580, 100, 80, 60);
		btnHabeas.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnHabeas.setHorizontalTextPosition(SwingConstants.CENTER);
		btnHabeas.setIcon(new ImageIcon(this.getClass().getResource("/images/Firma32.png")));
		btnHabeas.setBorder(raisedBorder);

		// Botón para ejecutar la consulta
		btnEnviar.setText("Enviar");
		btnEnviar.setBounds(580, 180, 80, 60);
		btnEnviar.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnEnviar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnEnviar.setIcon(new ImageIcon(this.getClass().getResource("/images/check32.png")));
		btnEnviar.setBorder(raisedBorder);

		// Botón para ejecutar la consulta
		btnRegresar.setText("Regresar");
		btnRegresar.setBounds(580, 260, 80, 60);
		btnRegresar.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnRegresar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnRegresar.setIcon(new ImageIcon(this.getClass().getResource("/images/return32.png")));
		btnRegresar.setBorder(raisedBorder);

		// Botón para enlazar con página de hola dendedores
		btnHolaVendedor.setText("<html>Hola<br/>Vendedores</html>");
		btnHolaVendedor.setBounds(580, 380, 80, 60);
		btnHolaVendedor.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnHolaVendedor.setHorizontalTextPosition(SwingConstants.CENTER);
		btnHolaVendedor.setBorder(raisedBorder);
	}

	private void adicionarListeners() {
//		bxDocumento.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				bxDocumentoClic();
//			}
//		});

		bxApellido1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				bxAlfanumeriClic();
			}
		});

		bxApellido2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				bxAlfanumeriClic();
			}
		});

		bxNombre1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				bxAlfanumeriClic();
			}
		});

		bxNombre2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				bxAlfanumeriClic();
			}
		});

		bxTelefono.addFocusListener(focusListenerTelefono);
		bxEmail.addFocusListener(focusListenerEmail);

		btnScan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				scanCedula();
			}
		});

		btnHabeas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				if (habeas()) {
					Util.okDialog("Haga firmar documento de tratamiento de datos y proceda a enviar los datos", new JFrame(),
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});

		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				if (enviar()) {
					Util.okDialog("Datos correctamente enviados", new JFrame(), JOptionPane.INFORMATION_MESSAGE);
					close();
				}
			}
		});

		btnRegresar.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseReleased(java.awt.event.MouseEvent evt) {
				close();
			}
		});

		btnHolaVendedor.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseReleased(java.awt.event.MouseEvent evt) {
				holaVendedores();
			}
		});
	}

	protected void scanCedula() {
		String datosCedula = JOptionPane.showInputDialog(null, "Escanee la cédula");
		if (datosCedula.indexOf("|") == -1) {
			Util.okDialog("No se leyó correctamente la cédula", new JFrame(), JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		String[] datos = datosCedula.split("\\|");
		//quita los ceros a la izquierda 
		datos[0] = datos[0].replaceFirst("^0+(?!$)", "");
		if (bxDocumento.getText().compareTo(datos[0]) != 0) {
			Util.okDialog("No se leyó la misma cédula", new JFrame(), JOptionPane.ERROR_MESSAGE);
			return;
		}
		bxDocumento.setText(datos[0].toUpperCase());
		bxApellido1.setText(datos[1].toUpperCase());
		bxApellido2.setText(datos[2].toUpperCase());
		bxNombre1.setText(datos[3].toUpperCase());
		bxNombre2.setText(datos[4].toUpperCase());
	}
	
	private String toCapitalLetter(String cadena) {
		char[] caracteres = cadena.toLowerCase().toCharArray();
//		caracteres[0] = Character.toUpperCase(caracteres[0]);
		for (int i = 0; i < cadena.length()- 2; i++)
			if (caracteres[i] == ' ' || caracteres[i] == '.' || caracteres[i] == ',')
				caracteres[i + 1] = Character.toUpperCase(caracteres[i + 1]);
		return new String(caracteres);
	}

	protected void holaVendedores() {
		try {
			Properties properties = Util.getProperties();
			URI uri = new URI(properties.getProperty("HOLAVLink"));
			Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
			desktop.browse(uri);
		} catch (Exception e) {
			log.error("Error invocando página de Hola Vendedores");
		}
	}

	protected boolean habeas() {
		if (validaCampos()) {
			NewCustomer newCustomer = fillCustomer();
			if (habeasData(newCustomer)) {
				return true;
			}
		}
		return false;
	}

	protected void bxDocumentoClic() {
		kp.setLocationRelativeTo(CapturaDatosCliente.this);
		kp.setVisible(true, bxDocumento.getText());
		bxDocumento.setText(kp.getValue());
	}

	protected boolean enviar() {
		if ((pdfFileName.isEmpty()) || (!validaFirmado())) {
			Util.okDialog("No se ha firmado el archivo de autorización de tratamiento de datos personales", new JFrame(), JOptionPane.ERROR_MESSAGE);
			return false;
		}

		Properties properties = Util.getProperties();
		boolean esPruebas = "true".equals(properties.getProperty("VersionPrueba"));
		if (esPruebas) {
			Util.okDialog("Esta es una versión de pruebas. No se enviarán datos a otros sistemas", new JFrame(), JOptionPane.ERROR_MESSAGE);
			return false;
		}

		if (validaCampos()) {
			enviarXcorreo();
			enviarCustodia();
			DBServiceImplementation dbServiceImpl = new DBServiceImplementation();
			NewCustomer newCustomer = fillCustomer();
			dbServiceImpl.sendNewCustomer(newCustomer);
		} else {
			return false;
		}
		return true;
	}

	private void enviarCustodia() {
		Properties properties = Util.getProperties();
		final String userName = properties.getProperty("CUSTODIAusr");
		final String password = properties.getProperty("CUSTORIApasswd");
		final String destinationPath = properties.getProperty("CUSTODIAurl");
		copyFileUsingJcifs(userName, password, pdfFileName, destinationPath);

	}

	private void copyFileUsingJcifs(String userName, String password, String sourcePath, String destinationPath) {
		final String user = userName + ":" + password;
		final NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication(user);
		SmbFile sFile;
		try {
			File f = new File(sourcePath);
			sFile = new SmbFile(destinationPath + f.getName(), auth);
			final SmbFileOutputStream smbFileOutputStream = new SmbFileOutputStream(sFile);
			final FileInputStream fileInputStream = new FileInputStream(f);

			final byte[] buf = new byte[16 * 1024 * 1024];
			int len;
			while ((len = fileInputStream.read(buf)) > 0) {
				smbFileOutputStream.write(buf, 0, len);
			}
			fileInputStream.close();
			smbFileOutputStream.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (SmbException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void enviarXcorreo() {
		Properties properties = Util.getProperties();
		String smtp = properties.getProperty("eMailSMTP");
		String port = properties.getProperty("eMailPort");
		String pwd = properties.getProperty("eMailPwd");
		String from = properties.getProperty("eMailFrom");
		String subject = "Flamingo: Autorización tratamiento de datos personales";
		String text = "Te enviamos el archivo firmado";
		if (!SendEMail.sendEMail(smtp, port, pwd, from, bxEmail.getText(), subject, text, pdfFileName)) {
			Util.okDialog("Ocurrió un error enviando el correo. Intente nuevamente o reporte a la Mesa de ayuda", new JFrame(),
					JOptionPane.ERROR_MESSAGE);
		} else {
			Util.okDialog("El correo fue enviado satisfactoriamente", new JFrame(), JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private boolean validaFirmado() {
		String fileBak = pdfFileName.substring(0, pdfFileName.length() - 3).concat("BAK");
		// Si son iguales es porque no se firmó y retorna falso.
		return !Util.compareFiles(pdfFileName, fileBak);
	}

	private boolean validaCampos() {
		if (bxDocumento.getText().isEmpty()) {
			Util.okDialog("El documento ingresado no es válido", new JFrame(), JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (bxApellido1.getText().isEmpty()) {
			Util.okDialog("El Primer apellido ingresado no es válido", new JFrame(), JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (bxNombre1.getText().isEmpty()) {
			Util.okDialog("El Primer nombre ingresado no es válido", new JFrame(), JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (bxTelefono.getText().isEmpty()) {
			Util.okDialog("El teléfono ingresado no es válido", new JFrame(), JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (!Util.isValidEmailAddress(bxEmail.getText())) {
			Util.okDialog("El correo ingresado no es válido", new JFrame(), JOptionPane.ERROR_MESSAGE);
			bxEmail.requestFocus();
			return false;
		}
		return true;
	}

	private NewCustomer fillCustomer() {
		NewCustomer newCustomer = new NewCustomer(usuario.getCedula(), bxDocumento.getText(), bxApellido1.getText(), bxApellido2.getText(), bxNombre1.getText(),
				bxNombre2.getText(), bxTelefono.getText(), bxEmail.getText(), cbxPrioridad.getSelectedIndex() + 1, sTienda);
		return newCustomer;
	}

	private boolean habeasData(NewCustomer newCustomer) {
		HabeasDataRPT hdRPT = new HabeasDataRPT(newCustomer);
		this.pdfFileName = hdRPT.getPdfFileName();
		hdRPT.imprimir();
		return true;
	}

	protected void bxNombre2Clic() {
	}

	protected void bxNombre1Clic() {
	}

	protected void bxApellido2Clic() {
	}

	protected void bxAlfanumeriClic() {
//		try {
//			Runtime.getRuntime().exec("cmd /c osk");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}

	private void adicionarComponentes() {
		jpDatosIn.add(lblTipoDoc);
		jpDatosIn.add(cbxTipoDoc);
		jpDatosIn.add(lblDocumento);
		jpDatosIn.add(bxDocumento);
		jpDatosIn.add(lblApellido1);
		jpDatosIn.add(bxApellido1);
		jpDatosIn.add(lblApellido2);
		jpDatosIn.add(bxApellido2);
		jpDatosIn.add(lblNombre1);
		jpDatosIn.add(bxNombre1);
		jpDatosIn.add(lblNombre2);
		jpDatosIn.add(bxNombre2);
		jpDatosIn.add(lblTelefono);
		jpDatosIn.add(bxTelefono);
		jpDatosIn.add(lblEmail);
		jpDatosIn.add(bxEmail);
		jpDatosIn.add(lblPrioridad);
		jpDatosIn.add(cbxPrioridad);

		add(jpDatosIn);
		add(btnScan);
		add(btnHabeas);
		add(btnEnviar);
		add(btnRegresar);
		add(btnHolaVendedor);
	}

	public void close() {
		setVisible(false);
		super.dispose();
	}

	public void setVisible(boolean b, String sDocumento, String sTienda, Usuario usuario) {
		if (b) {
			bxDocumento.setText(sDocumento);
			this.sTienda = sTienda;
			this.usuario = usuario;
		}
		super.setVisible(b);
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

	FocusListener focusListenerTelefono = new FocusListener() {
		public void focusGained(FocusEvent e) {
		}

		public void focusLost(FocusEvent e) {
			if (!e.isTemporary() && isEnabled()) {
				if (!Util.isNumeric(bxTelefono.getText())) {
					Util.okDialog("El teléfono ingresado no es válido. Solo se aceptan números y sin espacios", new JFrame(),
							JOptionPane.ERROR_MESSAGE);
					bxTelefono.requestFocus();
				}
				if ( (bxTelefono.getText().length() < 7) || (bxTelefono.getText().length() > 10) ) {
					Util.okDialog("El teléfono ingresado no es válido. El tamaño no es consistente", new JFrame(), JOptionPane.ERROR_MESSAGE);
					bxTelefono.requestFocus();
				}
			}
		}
	};

	FocusListener focusListenerEmail = new FocusListener() {
		public void focusGained(FocusEvent e) {
		}

		public void focusLost(FocusEvent e) {
			if (!e.isTemporary() && isEnabled()) {
				if (!Util.isValidEmailAddress(bxEmail.getText())) {
					Util.okDialog("El correo ingresado no es válido", new JFrame(), JOptionPane.ERROR_MESSAGE);
					bxEmail.requestFocus();
				}
			}
		}
	};

	public static void main(String[] args) {
		CapturaDatosCliente dc = new CapturaDatosCliente(new JFrame());
		dc.setVisible(true, "1035440018", "01", new Usuario());
	}
}
