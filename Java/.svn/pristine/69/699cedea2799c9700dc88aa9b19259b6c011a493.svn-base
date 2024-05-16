package co.com.flamingo.sincronizadorClientes.vista;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;

import org.apache.log4j.Logger;

import co.com.flamingo.sincronizadorClientes.controlador.Controlador;
import co.com.flamingo.sincronizadorClientes.implementacion.DBServiceImplementation;
import co.com.flamingo.sincronizadorClientes.modelo.Almacen;
import co.com.flamingo.sincronizadorClientes.modelo.Cliente;
import co.com.flamingo.sincronizadorClientes.transformadores.TransformadorTrama2Canopus;
import co.com.flamingo.sincronizadorClientes.util.Util;
import co.com.flamingo.canopus.principal.Core;

public class SincronizadorClientesVentana extends JFrame {
	/**
	 * Definición de variables de clase 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txDocumentoNro;
	private JTextField txNombres;
	private JTextField txApellidos;
	
	/** Número previo para controlar cambio de cédula */
	private String txPrevNroDoc = "0";

	/** Instancia de Canopus para consultas al motor */
	private Core canopus = null;

	/** Lista de las tiendas que se consultan en la BD*/
	Almacen[] stTiendasList = null;
	
	/** Servicio para conexion con bases de datos */
	DBServiceImplementation dbServiceImpl = new DBServiceImplementation();
	private Logger log;
	private boolean blnBuscar = false;
	
	public SincronizadorClientesVentana() {
		super();
		
		List<Almacen> tiendas = dbServiceImpl.getTiendas(); // Consulta las tiendas en la BD
		if (tiendas.size() < 1) {
			Util.okDialog("Error consultando los almacenes. Cierre y vuelva a abrir la aplicación", (JFrame) this, JOptionPane.ERROR_MESSAGE);
			close();
		}
		stTiendasList = new Almacen[tiendas.size()];
		for (int i = 0; i < tiendas.size(); i++) { // Llena el arreglo de tiendas
			stTiendasList[i] = (Almacen) tiendas.get(i);
		}
		
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				SincronizadorClientesVentana.class.getResource("/co/com/flamingo/sincronizadorClientes/imagenes/Sync32.png")));
		setTitle("Sincronizador de datos de clientes del Motor de promociones. By HHC");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 100, 800, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDocumentoNro = new JLabel("Documento Número:");
		lblDocumentoNro.setBounds(14, 20, 120, 30);
		contentPane.add(lblDocumentoNro);
		txDocumentoNro = new JTextField();
		txDocumentoNro.setBounds(14, 50, 120, 30);
		txDocumentoNro.setFont(new Font("SansSerif", Font.BOLD, 16));
		txDocumentoNro.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txDocumentoNro.addKeyListener(keyListener);
		contentPane.add(txDocumentoNro);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscar();
			}
		});
		btnBuscar.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnBuscar.setFont(new Font("SansSerif", Font.BOLD, 16));
		btnBuscar.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnBuscar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnBuscar.setBounds(160, 30, 80, 50);
		contentPane.add(btnBuscar);

		JLabel lblNombres = new JLabel("Nombres:");
		lblNombres.setBounds(260, 20, 250, 30);
		contentPane.add(lblNombres);
		txNombres = new JTextField();
		txNombres.setBounds(260, 50, 250, 30);
		txNombres.setFont(new Font("SansSerif", Font.BOLD, 16));
		txNombres.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txNombres.setEditable(false);
		contentPane.add(txNombres);

		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(520, 20, 250, 30);
		contentPane.add(lblApellidos);
		txApellidos = new JTextField();
		txApellidos.setBounds(520, 50, 250, 30);
		txApellidos.setFont(new Font("SansSerif", Font.BOLD, 16));
		txApellidos.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txApellidos.setEditable(false);
		contentPane.add(txApellidos);

		JButton btnVerificar = new JButton("Verificar");
		btnVerificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sincronizarDatos(e);
			}
		});
		btnVerificar.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnVerificar.setFont(new Font("SansSerif", Font.BOLD, 16));
		btnVerificar.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnVerificar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnVerificar.setBounds(200, 120, 80, 50);
		contentPane.add(btnVerificar);

		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpiar();
			}
		});
		btnLimpiar.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnLimpiar.setFont(new Font("SansSerif", Font.BOLD, 16));
		btnLimpiar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnLimpiar.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnLimpiar.setBounds(330, 120, 80, 50);
		contentPane.add(btnLimpiar);

		JButton btnSalir = new JButton("Salir");
		btnSalir.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnSalir.setFont(new Font("SansSerif", Font.BOLD, 16));
		btnSalir.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnSalir.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				close();
			}
		});
		btnSalir.setBounds(600, 120, 80, 50);
		contentPane.add(btnSalir);

	}

	
	protected void buscar() {
		String [] nombre = dbServiceImpl.getDatosCliente(txDocumentoNro.getText());
		if (nombre[0] == null) {
			Util.okDialog("No se pudo recuperar la información del cliente", (JFrame) this, JOptionPane.ERROR_MESSAGE);
			return;
		}
		txNombres.setText(nombre[0]);
		txApellidos.setText(nombre[1]);
		blnBuscar = true;
		txPrevNroDoc = txDocumentoNro.getText();
	}


	protected void close() {
		this.dispose();
	}


	protected void limpiar() {
		txDocumentoNro.setText("");
		txNombres.setText("");
		txApellidos.setText("");
		blnBuscar = false;
		txDocumentoNro.requestFocus();
	}


	protected void sincronizarDatos(ActionEvent e) {
		if (!blnBuscar) {
			Util.okDialog("Primero debe lograr una búsqueda exitosa", (JFrame) this, JOptionPane.ERROR_MESSAGE);
			return;
		}
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
		String fDate = formatter.format(new Date());
		String txHora = Util.getTime();
		List<String> sitiosReconocido = dbServiceImpl.getSitiosReconocido(txDocumentoNro.getText());
		if (sitiosReconocido.size() < 1) {
			Util.okDialog("Este cliente no ha tenido presencia en las tiendas", (JFrame) this, JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		// Recorre cada tienda en la que es reconocido y verifica que la información esté actualizada
		for (int i = 0; i < sitiosReconocido.size(); i++) {
			String sTienda = sitiosReconocido.get(i);
			initCanopus(sTienda);
			String sTramaReqCanopus = TransformadorTrama2Canopus.transformCliente("12345", txDocumentoNro.getText(), Util.zeroPad(sTienda, 5), fDate, txHora);
			String sResponse = canopus.getCustomer(sTramaReqCanopus);
			log.info("Datos de cliente recuperados: " + sResponse);
			if(sResponse != null) {
				Cliente cliente = TransformadorTrama2Canopus.canopusResponse2Cliente(sResponse);
				// compara nombres
				log.info("Compara " + cliente.getFirstName() + " con " + txNombres.getText());
				log.info("Compara " + cliente.getLastName() + " con " + txApellidos.getText());
				if (cliente.getFirstName().compareTo(txNombres.getText()) !=0 || cliente.getLastName().compareTo(txApellidos.getText()) != 0) {
					Util.okDialog("Diferencia encontrada en " + sTienda, (JFrame) this, JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		Util.okDialog("Proceso finalizado, vuelva a verificar si hubo diferencias reportadas", (JFrame) this, JOptionPane.INFORMATION_MESSAGE);
		limpiar();
	}

	public void initCanopus(String sTienda) {
		String sTomcatServer;

		for (int index = 0; index < stTiendasList.length; index++) {
			log.info("Comparando tiendas: " + Util.zeroPad(sTienda, 3) + " con " + stTiendasList[index].getCodigo());
			if (stTiendasList[index].getCodigo().compareTo(Util.zeroPad(sTienda, 3)) == 0) {
				sTomcatServer = stTiendasList[index].getTomcatServer();
				log.info("Instanciando Canopus con " + sTomcatServer);
				canopus = new Core(sTomcatServer);
				log.info("Se ha instanciado Canopus");
				break;
			}
		}
	}
	
	KeyListener keyListener = new KeyListener() {
        public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				if (!txDocumentoNro.getText().isEmpty()) {
					buscar();
				}
			}
			else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
				txDocumentoNro.setText("");
			}
		}        
        public void keyReleased(KeyEvent e) {
        }
        public void keyTyped(KeyEvent e) {
        }
      };

    @Override
  	public void setVisible(boolean b) {
    	if (b) {
    	  txDocumentoNro.requestFocus();
    	}
  		super.setVisible(b);
      }

	public void setControlador(Controlador controlador) {
	}


	public void setLog(Logger log) {
		this.log = log;
	}

}
