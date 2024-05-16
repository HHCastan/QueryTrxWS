package com.fla.remoteCommand.vista;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.SoftBevelBorder;

import org.apache.log4j.Logger;

import com.fla.remoteCommand.controlador.Controlador;
import com.fla.remoteCommand.implementation.DBServiceImplementation;
import com.fla.remoteCommand.implementation.FTPServiceImplementation;
import com.fla.remoteCommand.modelo.Almacen;
import com.fla.remoteCommand.util.Util;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

public class Ventana extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frmComandoRemoto;
	private JTextField txtComando;
	private DefaultListModel<String> dlmComandos;
	private DefaultListModel<String> dlmTiendas;
	private Logger log = Util.getLogger();

	/** Lista de las tiendas que se consultan en la BD*/
	Almacen[] stTiendasList = null;
	List<Almacen> tiendas = null;
	JList<String> lstTiendas = null;
	
	/** Lista de comando */
	JList<String> lstComandos = null;

	/** Servicio para conexion con bases de datos */
	DBServiceImplementation dbServiceImpl = new DBServiceImplementation();

	/** Servicio para concernientes al FTP */
	FTPServiceImplementation ftpServiceImpl;

	/** Scroll para la lista de tiendas */
	private JScrollPane scrollTiendas;
	
	/** Scrill para los mensajes de salida */
	private JScrollPane scrollMensajes;
	
	/*** Directorio temporal */
	private static final String tDir = System.getProperty("java.io.tmpdir");
	
	/** Para el log de la ejecución */
	JTextArea textAreaLog;
	
	private Controlador controlador;


	/**
	 * Create the application.
	 */
	public Ventana() {
		initialize();
		iniciar();
	}

	private void iniciar() {
		ftpServiceImpl = new FTPServiceImplementation();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		tiendas = dbServiceImpl.getTiendas(); // Consulta las tiendas en la BD
		if (tiendas.size() < 1) {
			Util.okDialog("Error consultando los almacenes. Cierre y vuelva a abrir la aplicación", (JFrame) this, JOptionPane.ERROR_MESSAGE);
		}
		stTiendasList = new Almacen[tiendas.size()];
		dlmTiendas = new DefaultListModel<String>();
		for (int i = 0; i < tiendas.size(); i++) { // Llena los arreglos de tiendas
			String linea = tiendas.get(i).toString();
			dlmTiendas.addElement(linea);
			stTiendasList[i] = (Almacen) tiendas.get(i);
		}

//		frmComandoRemoto = new JFrame();
		setTitle("Comando Remoto - Controladores POS");
		setBounds(100, 100, 900, 530);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		lstTiendas = new JList<String>();
		lstTiendas.setModel(dlmTiendas);
		scrollTiendas = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollTiendas.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Tiendas:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		scrollTiendas.setBounds(30, 30, 350, 450);
		scrollTiendas.setViewportView(lstTiendas);
		getContentPane().add(scrollTiendas);
		
		txtComando = new JTextField();
		txtComando.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtComando.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				txtComando.setBackground(Color.WHITE);
			}
			
			
		});
		txtComando.setBounds(417, 30, 400, 30);
		getContentPane().add(txtComando);
		txtComando.setColumns(10);
		
		JButton btnAdd = new JButton("");
		btnAdd.setIcon(new ImageIcon(Ventana.class.getResource("/com/fla/remoteCommand/image/check16.png")));
		btnAdd.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!txtComando.getText().trim().equals("")) {
					dlmComandos.addElement(txtComando.getText().trim().toUpperCase());
					txtComando.setText("");
					txtComando.grabFocus();
				} else {
					txtComando.setBackground(Color.YELLOW);
				}
			}
		});
		btnAdd.setBounds(831, 28, 30, 30);
		getContentPane().add(btnAdd);
		
		dlmComandos = new DefaultListModel<String>();
		lstComandos = new JList<String>();
		lstComandos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lstComandos.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lstComandos.setModel(dlmComandos);
		lstComandos.setBounds(417, 88, 400, 150);
		getContentPane().add(lstComandos);
		
		JButton btnDel = new JButton("");
		btnDel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnDel.setIcon(new ImageIcon(Ventana.class.getResource("/com/fla/remoteCommand/image/BackSpace16.png")));
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(dlmComandos.getSize() != 0) {
					if (lstComandos.getSelectedIndex() != -1) {
						dlmComandos.removeElementAt(lstComandos.getSelectedIndex());
						txtComando.grabFocus();
					}
				}
			}
		});
		btnDel.setBounds(831, 86, 30, 30);
		getContentPane().add(btnDel);
		
		JButton btnUp = new JButton("");
		btnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(lstComandos.getSelectedIndex() > 0) {
					int currentIndex = lstComandos.getSelectedIndex();
					String selectedItem = lstComandos.getSelectedValue();
					dlmComandos.remove(currentIndex);
					dlmComandos.add(currentIndex - 1, selectedItem);
					lstComandos.setSelectedIndex(currentIndex - 1);
				}
			}
		});
		btnUp.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnUp.setIcon(new ImageIcon(Ventana.class.getResource("/com/fla/remoteCommand/image/up16.png")));
		btnUp.setBounds(831, 167, 30, 30);
		getContentPane().add(btnUp);
		
		JButton btnDown = new JButton("");
		btnDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(lstComandos.getSelectedIndex() < dlmComandos.getSize() -1) {
					int currentIndex = lstComandos.getSelectedIndex();
					String selectedItem = lstComandos.getSelectedValue();
					dlmComandos.remove(currentIndex);
					dlmComandos.add(currentIndex + 1, selectedItem);
					lstComandos.setSelectedIndex(currentIndex + 1);
				}
			}
		});
		btnDown.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnDown.setIcon(new ImageIcon(Ventana.class.getResource("/com/fla/remoteCommand/image/Down16.png")));
		btnDown.setBounds(831, 208, 30, 30);
		getContentPane().add(btnDown);

		scrollMensajes  = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollMensajes.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Mensajes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		scrollMensajes.setBounds(417, 340, 444, 140);
		textAreaLog = new JTextArea();
		scrollMensajes.setViewportView(textAreaLog);
		getContentPane().add(scrollMensajes);
		
		JButton btnDelAll = new JButton("");
		btnDelAll.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnDelAll.setIcon(new ImageIcon(Ventana.class.getResource("/com/fla/remoteCommand/image/Clear16.png")));
		btnDelAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(dlmComandos.getSize() != 0) {
					dlmComandos.clear();
					textAreaLog.setText("");
					txtComando.grabFocus();
				}
			}
		});
		btnDelAll.setBounds(831, 126, 30, 30);
		getContentPane().add(btnDelAll);
		
		JButton btnIniciar = new JButton("");
		btnIniciar.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] options = { "Si, enviar comandos", "No, cancelar proceso" };
				String msg = "¿Desea continuar con el proceso de enviar comandos a la(s) tienda(s) seleccionada(s)?";
				int h = Util.sigaPareMessage(msg, new JDialog(), JOptionPane.QUESTION_MESSAGE, options);
				if (h == 0) {
					iniciarProceso();
				}

			}
		});
		btnIniciar.setIcon(new ImageIcon(Ventana.class.getResource("/com/fla/remoteCommand/image/Start32.png")));
		btnIniciar.setBounds(597, 249, 60, 60);
		getContentPane().add(btnIniciar);
		
	}

	protected void iniciarProceso() {
		
		try {
			File file = new File(tDir, "UFCOMMAN.DAT");
			System.out.println("Archivo temporal: " + file.getAbsolutePath());
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			for (int i = 0; i < lstComandos.getModel().getSize(); i++) { 
				bw.write(lstComandos.getModel().getElementAt(i));
				bw.newLine();
			}
			bw.close();

			int[] storesSelected = lstTiendas.getSelectedIndices();
			for (int i = 0; i < storesSelected.length; i++)	{
				int indice = storesSelected[i];
				ftpServiceImpl.setHost(stTiendasList[indice].getIP());
				ftpServiceImpl.conectar();
				ftpServiceImpl.subirArchivo(file.getAbsolutePath(), "C:/ADX_UDT1/UFREMOTO.BAT");
				ftpServiceImpl.ejecutarComando("ADXSTART", "ADX_UPGM:UDREMOTO.286");
				ftpServiceImpl.desconectar();
			}
			textAreaLog.setText(ftpServiceImpl.getMensaje());
		} catch (IOException e1) {
			log.error("Error creando archivo temporal");
		}	}

	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
		
	}
}
