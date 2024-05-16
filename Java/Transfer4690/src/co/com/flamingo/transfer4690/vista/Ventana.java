package co.com.flamingo.transfer4690.vista;

import java.util.concurrent.TimeUnit;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.log4j.Logger;

import co.com.flamingo.transfer4690.controlador.Controlador;
import co.com.flamingo.transfer4690.implementation.DBServiceImplementation;
import co.com.flamingo.transfer4690.implementation.FTPServiceImplementation;
import co.com.flamingo.transfer4690.modelo.Almacen;
import co.com.flamingo.transfer4690.util.Util;

import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextField;
import javax.swing.JFileChooser;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

public class Ventana extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DefaultListModel<String> dlmTiendas;
	private Logger log = Util.getLogger();

	/** Lista de las tiendas que se consultan en la BD */
	Almacen[] stTiendasList = null;
	List<Almacen> tiendas = null;
	JList<String> lstTiendas1 = null;

	/** Servicio para conexion con bases de datos */
	DBServiceImplementation dbServiceImpl = new DBServiceImplementation();

	/** Servicio para concernientes al FTP */
	FTPServiceImplementation ftpServiceImpl;
	private JScrollPane scrollTiendas;
	private JList<String> lstTiendas;
	private JTextField txArchivo;
	private JFileChooser fileChooser;
	private ButtonGroup groupDistribucion = new ButtonGroup();

	/**
	 * @wbp.nonvisual location=332,139
	 */
	private JRadioButton jrbDistribucion1;
	private JRadioButton jrbDistribucion4;
	private JRadioButton jrbDistribucion5;
	private JLabel lblCarpetaDestino;
	private JTextField txCarpetaDestino;
	private JLabel lblNombreDestino;
	private JTextField txNombreDestino;
	private JPanel pnlDescarga;
	private JTextArea textAreaLog;
	private JCheckBox chBoxBak;
	private JCheckBox chBoxAnt;
	private JCheckBox chBoxOld;
	private JTextField txArchivoTraer;
	private JTextField txCarpetaLocal;

	/**
	 * Create the frame.
	 */
	public Ventana() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(Ventana.class.getResource("/co/com/flamingo/transfer4690/images/transfer32.png")));
		setTitle("Transferencia de archivos OS4690");
		tiendas = dbServiceImpl.getTiendas(); // Consulta las tiendas en la BD
		if (tiendas.size() < 1) {
			Util.okDialog("Error consultando los almacenes. Cierre y vuelva a abrir la aplicación", (JFrame) this,
					JOptionPane.ERROR_MESSAGE);
		}
		stTiendasList = new Almacen[tiendas.size()];
		dlmTiendas = new DefaultListModel<String>();
		for (int i = 0; i < tiendas.size(); i++) { // Llena los arreglos de tiendas
			String linea = tiendas.get(i).toString();
			dlmTiendas.addElement(linea);
			stTiendasList[i] = (Almacen) tiendas.get(i);
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 519);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		scrollTiendas = new JScrollPane();
		scrollTiendas.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollTiendas.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null),
				"Seleccione la(s) Tienda(s):", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		scrollTiendas.setBounds(10, 11, 240, 459);
		contentPane.add(scrollTiendas);

		lstTiendas = new JList<String>();
		lstTiendas.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lstTiendas.setModel(dlmTiendas);
		scrollTiendas.setViewportView(lstTiendas);

		txArchivo = new JTextField();
		txArchivo.setFont(new Font("SansSerif", Font.PLAIN, 12));
		txArchivo.setBounds(270, 62, 328, 20);
		contentPane.add(txArchivo);
		txArchivo.setColumns(10);

		fileChooser = new JFileChooser();
//		fileChooser.setBounds(41, 61, 623, 397);
		contentPane.add(fileChooser);

		JButton btnBrowse = new JButton("Explorar...");
		btnBrowse.setFont(new Font("SansSerif", Font.PLAIN, 12));
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				fileChooser.setAcceptAllFileFilterUsed(false);
				int iVal = fileChooser.showOpenDialog(null);
				if (iVal == JFileChooser.APPROVE_OPTION) {
					txArchivo.setText(fileChooser.getSelectedFile().toString());
					txNombreDestino.setText(fileChooser.getSelectedFile().getName());
				}
			}
		});
		btnBrowse.setBounds(608, 60, 98, 23);
		contentPane.add(btnBrowse);

		txCarpetaDestino = new JTextField();
		txCarpetaDestino.setFont(new Font("SansSerif", Font.PLAIN, 12));
		txCarpetaDestino.setBounds(270, 117, 224, 20);
		contentPane.add(txCarpetaDestino);
		txCarpetaDestino.setColumns(10);

		txNombreDestino = new JTextField();
		txNombreDestino.setFont(new Font("SansSerif", Font.PLAIN, 12));
		txNombreDestino.setColumns(10);
		txNombreDestino.setBounds(270, 164, 224, 20);
		contentPane.add(txNombreDestino);

		jrbDistribucion1 = new JRadioButton("Distribución 1");
		jrbDistribucion1.setBounds(500, 108, 108, 23);
		contentPane.add(jrbDistribucion1);

		jrbDistribucion4 = new JRadioButton("Distribución 4");
		jrbDistribucion4.setBounds(500, 135, 108, 23);
		contentPane.add(jrbDistribucion4);

		jrbDistribucion5 = new JRadioButton("Distribución 5");
		jrbDistribucion5.setBounds(500, 161, 108, 23);
		jrbDistribucion5.setSelected(true);
		contentPane.add(jrbDistribucion5);

		groupDistribucion.add(jrbDistribucion1);
		groupDistribucion.add(jrbDistribucion4);
		groupDistribucion.add(jrbDistribucion5);

		chBoxBak = new JCheckBox(".BAK");
		chBoxBak.setSelected(false);
		chBoxBak.setBounds(496, 191, 57, 23);
		contentPane.add(chBoxBak);

		chBoxAnt = new JCheckBox(".ANT");
		chBoxAnt.setSelected(true);
		chBoxAnt.setBounds(551, 191, 57, 23);
		contentPane.add(chBoxAnt);

		chBoxOld = new JCheckBox(".OLD");
		chBoxOld.setSelected(true);
		chBoxOld.setBounds(608, 191, 57, 23);
		contentPane.add(chBoxOld);

		JLabel lblRespaldos = new JLabel("Respaldos:");
		lblRespaldos.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblRespaldos.setBounds(416, 192, 80, 19);
		contentPane.add(lblRespaldos);

		JButton btnSubir = new JButton("");
		btnSubir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Object[] options = { "Si, enviar archivo", "No, cancelar proceso" };
				String msg = "¿Desea continuar con el proceso de enviar el archivo a la(s) tienda(s) seleccionada(s)?";
				int h = Util.sigaPareMessage(msg, new JDialog(), JOptionPane.QUESTION_MESSAGE, options);
				if (h == 0) {
					subirArchivo();
				}
			}
		});
		btnSubir.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnSubir.setIcon(new ImageIcon(Ventana.class.getResource("/co/com/flamingo/transfer4690/images/upload64.png")));
		btnSubir.setBounds(626, 108, 80, 70);
		contentPane.add(btnSubir);

		JPanel panelSubida = new JPanel();
		panelSubida.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Subir archivo:",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelSubida.setBounds(257, 11, 466, 222);
		contentPane.add(panelSubida);
		panelSubida.setLayout(null);

		JLabel lblSeleccioneArchivoA = new JLabel("Seleccione archivo a subir:");
		lblSeleccioneArchivoA.setBounds(10, 30, 147, 16);
		panelSubida.add(lblSeleccioneArchivoA);
		lblSeleccioneArchivoA.setFont(new Font("SansSerif", Font.PLAIN, 12));

		lblCarpetaDestino = new JLabel("Carpeta destino:");
		lblCarpetaDestino.setBounds(10, 85, 114, 19);
		panelSubida.add(lblCarpetaDestino);

		lblNombreDestino = new JLabel("Nombre destino:");
		lblNombreDestino.setBounds(10, 133, 114, 19);
		panelSubida.add(lblNombreDestino);

		textAreaLog = new JTextArea();

		JScrollPane scrollHuella = new JScrollPane();
		scrollHuella.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null),
				"Huella de ejecuci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		scrollHuella.setBounds(733, 11, 341, 459);
		scrollHuella.setViewportView(textAreaLog);
		contentPane.add(scrollHuella);

		pnlDescarga = new JPanel();
		pnlDescarga.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Descargar archivos:",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlDescarga.setBounds(260, 257, 463, 213);
		contentPane.add(pnlDescarga);
		pnlDescarga.setLayout(null);

		JLabel lblArchivoRemotofull = new JLabel("Archivo remoto (ruta completa):");
		lblArchivoRemotofull.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblArchivoRemotofull.setBounds(10, 24, 253, 20);
		pnlDescarga.add(lblArchivoRemotofull);

		txArchivoTraer = new JTextField();
		txArchivoTraer.setBounds(10, 49, 422, 20);
		pnlDescarga.add(txArchivoTraer);
		txArchivoTraer.setColumns(10);

		JLabel lblCarpetaLocal = new JLabel("Carpeta local:");
		lblCarpetaLocal.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblCarpetaLocal.setBounds(10, 92, 153, 14);
		pnlDescarga.add(lblCarpetaLocal);

		txCarpetaLocal = new JTextField();
		txCarpetaLocal.setFont(new Font("SansSerif", Font.PLAIN, 12));
		txCarpetaLocal.setBounds(10, 117, 226, 20);
		pnlDescarga.add(txCarpetaLocal);
		txCarpetaLocal.setColumns(10);

		JButton bttnExploraDescarga = new JButton("Explorar...");
		bttnExploraDescarga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				fileChooser.setAcceptAllFileFilterUsed(false);
				if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					txCarpetaLocal.setText(fileChooser.getSelectedFile().toString());
				}
			}
		});
		bttnExploraDescarga.setFont(new Font("SansSerif", Font.PLAIN, 12));
		bttnExploraDescarga.setBounds(246, 117, 98, 23);
		pnlDescarga.add(bttnExploraDescarga);

		JButton btnBajar = new JButton("");
		btnBajar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Object[] options = { "Si, traer archivo", "No, cancelar proceso" };
				String msg = "¿Desea continuar con el proceso de traer el archivo desde la(s) tienda(s) seleccionada(s)?";
				int h = Util.sigaPareMessage(msg, new JDialog(), JOptionPane.QUESTION_MESSAGE, options);
				if (h == 0) {
					bajarArchivo();
				}
			}
		});
		btnBajar.setIcon(
				new ImageIcon(Ventana.class.getResource("/co/com/flamingo/transfer4690/images/download64.png")));
		btnBajar.setFont(new Font("SansSerif", Font.PLAIN, 12));
		btnBajar.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnBajar.setBounds(365, 92, 80, 70);
		pnlDescarga.add(btnBajar);

		JLabel lblNota = new JLabel(
				"Nota: A los archivos se les anexa prefijo al nombre (Fxxx), donde xxx es el número de la tienda");
		lblNota.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblNota.setBounds(10, 171, 453, 31);
		pnlDescarga.add(lblNota);

	}

	protected void bajarArchivo() {
		String remoto = txArchivoTraer.getText(); 
		int index = txArchivoTraer.getText().lastIndexOf("\\");
		String origen = txArchivoTraer.getText().substring(index + 1);
		
		int[] storesSelected = lstTiendas.getSelectedIndices();

		// Debe seleccionar al menos una tienda
		if (storesSelected.length < 1) {
			Util.okDialog("Debe seleccionar al menos una tienda", (JFrame) this, JOptionPane.ERROR_MESSAGE);
			return;
		}
		// El archivo remoto debe ser full path
		if (txArchivoTraer.getText().isEmpty()) {
			if (remoto.indexOf(':') != 1) {
				Util.okDialog("En la casilla del archivo remoto debe especificar full path", (JFrame) this, JOptionPane.ERROR_MESSAGE);
				txArchivoTraer.requestFocusInWindow();
				return;
			}
		}
		// Debe seleccionar una carpeta de destino
		if (txCarpetaLocal.getText().indexOf(':') != 1) {
			Util.okDialog("Debe seleccionar una carpeta de destino", (JFrame) this, JOptionPane.ERROR_MESSAGE);
			txArchivoTraer.requestFocusInWindow();
			return;
		}
		
		// La carpeta temporal del usuario en el S.O.
		String tDir = System.getProperty("java.io.tmpdir");

		/** Servicio para concernientes al FTP */
		FTPServiceImplementation ftpServiceImpl = null;
		textAreaLog.setText("");

		for (int i = 0; i < storesSelected.length; i++) {
			int indice = storesSelected[i];
			String destino = txCarpetaLocal.getText() + "\\F" + stTiendasList[indice].getCodigo() + "_" + origen;
			ftpServiceImpl = new FTPServiceImplementation();
			ftpServiceImpl.setHost(stTiendasList[indice].getIP());
			ftpServiceImpl.conectar();
			log.info("Conectado con controlador: " + stTiendasList[indice].getNombre());
			
			ftpServiceImpl.bajarArchivo(remoto, destino);
			log.info("Copiado exitoso de archivo: " + destino);
			ftpServiceImpl.desconectar();
			textAreaLog.setText(textAreaLog.getText() + ftpServiceImpl.getMensaje());
			ftpServiceImpl = null;
		}
		Util.okDialog("Descarga finalizada. Revise la huella de ejecuión", (JFrame) this,
				JOptionPane.INFORMATION_MESSAGE);
	}

	public void setControlador(Controlador controlador) {
	}

	protected void subirArchivo() {
		String origen = fileChooser.getSelectedFile().toString();
		String destino = txCarpetaDestino.getText() + "/" + txNombreDestino.getText();
		int[] storesSelected = lstTiendas.getSelectedIndices();
		// Debe seleccionar al menos una tienda
		if (storesSelected.length < 1) {
			Util.okDialog("Debe seleccionar al menos una tienda", (JFrame) this, JOptionPane.ERROR_MESSAGE);
			return;
		}
		// El directorio destino tiene que ser full path
		if (destino.indexOf(':') != 1) {
			Util.okDialog("Directorio destino debe ser full path", (JFrame) this, JOptionPane.ERROR_MESSAGE);
			txCarpetaDestino.requestFocusInWindow();
			return;
		}
		// El nombre destino debe ser formato 8.3
		if ((txNombreDestino.getText().length() > 12)
				&& ((txCarpetaDestino.getText().charAt(0) == 'C') || (txCarpetaDestino.getText().charAt(0) == 'c'))) {
			Util.okDialog("Nombre de archivo destino no es válido", (JFrame) this, JOptionPane.ERROR_MESSAGE);
			txNombreDestino.requestFocusInWindow();
			return;
		}

		// La carpeta temporal del usuario en el S.O.
		String tDir = System.getProperty("java.io.tmpdir");

		try {
			File ufcommand = new File(tDir, "UFCOMMAND.DAT");
			creaPreFile(ufcommand, destino);
			File ufcommand2 = new File(tDir, "UFCOMMAND2.DAT");
			creaPostFile(ufcommand2, destino);

			/** Servicio para concernientes al FTP */
			FTPServiceImplementation ftpServiceImpl = null;
			textAreaLog.setText("");

			for (int i = 0; i < storesSelected.length; i++) {
				int indice = storesSelected[i];
				ftpServiceImpl = new FTPServiceImplementation();
				ftpServiceImpl.setHost(stTiendasList[indice].getIP());
				ftpServiceImpl.conectar();
				log.info("Conectado con controlador: " + stTiendasList[indice].getNombre());
				ftpServiceImpl.subirArchivo(ufcommand.getAbsolutePath(), "C:/ADX_UDT1/UFREMOTO.BAT");
				ftpServiceImpl.ejecutarComando("ADXSTART", "ADX_UPGM:UDREMOTO.286");
				log.info("Se envía comando remoto previo");
				TimeUnit.SECONDS.sleep(1); // Espera un segundo a que el comando termine.
				ftpServiceImpl.subirArchivo(origen, destino);
				log.info("Copiado exitoso de archivo: " + destino);
				esperar(5000);
				ftpServiceImpl.subirArchivo(ufcommand2.getAbsolutePath(), "C:/ADX_UDT1/UFREMOTO.BAT");
				ftpServiceImpl.ejecutarComando("ADXSTART", "ADX_UPGM:UDREMOTO.286");
				log.info("Se envía comando remoto posterior");
				ftpServiceImpl.desconectar();
				textAreaLog.setText(textAreaLog.getText() + ftpServiceImpl.getMensaje());
				ftpServiceImpl = null;
			}
			Util.okDialog("Envío finalizado. Revise la huella de ejecuión", (JFrame) this,
					JOptionPane.INFORMATION_MESSAGE);
		} catch (IOException e1) {
			log.error("Error creando archivo temporal: " + e1);
		} catch (InterruptedException e) {
			log.error("Error en comando previo: " + e);
		}
	}

	private void esperar(int i) {
		try {

			Thread.sleep(i);
		} catch (InterruptedException ex) {
		}
	}

	private void creaPostFile(File ufcommand, String destino) throws IOException {
		String linea = "";
		if (jrbDistribucion1.isSelected())
			linea = "adxcsu0l 3 1 " + destino;
		if (jrbDistribucion4.isSelected())
			linea = "adxcsu0l 3 4 " + destino;
		if (jrbDistribucion5.isSelected())
			linea = "adxcsu0l 3 5 " + destino;
		BufferedWriter bw = new BufferedWriter(new FileWriter(ufcommand));
		bw.write(linea);
		bw.newLine();
		log.info("Se agrega comando posterior: " + linea);
		bw.close();
	}

	private void creaPreFile(File ufcommand, String destino) throws IOException {
		String linea = "";
		BufferedWriter bw = new BufferedWriter(new FileWriter(ufcommand));

		if (chBoxOld.isSelected()) { // Respaldo como .BAK
			String antFile = destino.substring(0, destino.indexOf('.') + 1) + "ANT";
			String oldFile = destino.substring(0, destino.indexOf('.') + 1) + "OLD";
			linea = "if exist " + oldFile + " del " + oldFile;
			bw.write(linea);
			bw.newLine();
			log.info("Se agrega comando pevio: " + linea);
			linea = "ren " + antFile + " " + oldFile;
			bw.write(linea);
			bw.newLine();
			log.info("Se agrega comando pevio: " + linea);
		}
		
		if (chBoxAnt.isSelected()) { // Respaldo como .BAK
			String antFile = destino.substring(0, destino.indexOf('.') + 1) + "ANT";
			linea = "if exist " + antFile + " del " + antFile;
			bw.write(linea);
			bw.newLine();
			log.info("Se agrega comando pevio: " + linea);
			linea = "ren " + destino + " " + antFile;
			bw.write(linea);
			bw.newLine();
			log.info("Se agrega comando pevio: " + linea);
		}

		if (chBoxBak.isSelected()) { // Respaldo como .BAK
			String bakFile = destino.substring(0, destino.indexOf('.') + 1) + "BAK";
			linea = "if exist " + bakFile + " del " + bakFile;
			bw.write(linea);
			bw.newLine();
			log.info("Se agrega comando pevio: " + linea);
			linea = "ren " + destino + " " + bakFile;
			bw.write(linea);
			bw.newLine();
			log.info("Se agrega comando pevio: " + linea);
		}
		bw.close();
	}
}
