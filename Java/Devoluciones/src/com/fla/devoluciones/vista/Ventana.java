package com.fla.devoluciones.vista;

import java.awt.EventQueue;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.fla.devoluciones.control.ProductosTableControl;
import com.fla.devoluciones.implementation.DBServiceImplementation;
import com.fla.devoluciones.model.Almacen;
import com.fla.devoluciones.model.EngageTransaction;
import com.fla.devoluciones.model.Producto;
import com.fla.devoluciones.model.ProductosTableModel;
import com.fla.devoluciones.util.Util;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import com.toedter.calendar.JDateChooser;

public class Ventana {

	private JFrame frmDevolucinMercanciaVaria;
	private JTextField txtCaja;
	private JTextField txtTransaccion;
	private JTextField txtClienteOri;
	private JTextField txtNombreOri;
	private JTextField txtCliente;
	private JTextField txtNombre;
	private JScrollPane scrollItem;
	private JTable tablaPR;
	private JTextField txtBarCode;
	private JCheckBox chckbxgenrico;
	JDateChooser dateChooser = new JDateChooser();
	SimpleDateFormat formatter2 = new SimpleDateFormat("yyyyMMdd");
	int iTiendaIndex = 0;
	JComboBox<String> cbxTiendas = null;

	/** Lista de las tiendas que se consultan en la BD*/
	Almacen[] stTiendasList = null;

	/** Servicio para conexion con bases de datos */
	DBServiceImplementation dbServiceImpl = new DBServiceImplementation();

	/** Modelo de la tabla detalle de artículos */
	private ProductosTableModel modeloPR = new ProductosTableModel();

	/** Para modificar el modelo */
	private ProductosTableControl controlPR = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana window = new Ventana();
					window.frmDevolucinMercanciaVaria.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ventana() {
		initialize();
		txtBarCode.grabFocus();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDevolucinMercanciaVaria = new JFrame();
		frmDevolucinMercanciaVaria.setIconImage(Toolkit.getDefaultToolkit().getImage(Ventana.class.getResource("/com/fla/devoluciones/images/CashBack01.png")));
		frmDevolucinMercanciaVaria.setTitle("Devolución Mercancía Varia");
		frmDevolucinMercanciaVaria.setBounds(1, 1, 1024, 768);
		frmDevolucinMercanciaVaria.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDevolucinMercanciaVaria.getContentPane().setLayout(null);
		controlPR= new ProductosTableControl(modeloPR); // Inicializa la tabla de productos

		List<Almacen> tiendas = dbServiceImpl.getTiendas(); // Consulta las tiendas en la BD
		if (tiendas.size() < 1) {
			Util.okDialog("Error consultando los almacenes. Cierre y vuelva a abrir la aplicación", frmDevolucinMercanciaVaria, JOptionPane.ERROR_MESSAGE);
		}
		stTiendasList = new Almacen[tiendas.size()];
		String[] stTiendasDisp = new String[tiendas.size()];
		for (int i = 0; i < tiendas.size(); i++) { // Llena los arreglos de tiendas
			String linea = tiendas.get(i).toString();
			stTiendasDisp[i] = linea;
			stTiendasList[i] = (Almacen) tiendas.get(i);
		}
		
		JPanel pnlTrnOriginal = new JPanel();
		pnlTrnOriginal.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Transacción original:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlTrnOriginal.setBounds(10, 11, 750, 147);
		frmDevolucinMercanciaVaria.getContentPane().add(pnlTrnOriginal);
		pnlTrnOriginal.setLayout(null);

		txtBarCode = new JTextField();
		txtBarCode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				codigoLeido();
			}
		});
		txtBarCode.setColumns(10);
		txtBarCode.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtBarCode.setBounds(10, 53, 240, 25);
		txtBarCode.requestFocus();
		pnlTrnOriginal.add(txtBarCode);
		
		JLabel lblBarCode = new JLabel("Código de barras de la tirilla:");
		lblBarCode.setBounds(10, 32, 190, 20);
		pnlTrnOriginal.add(lblBarCode);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(260, 32, 43, 20);
		pnlTrnOriginal.add(lblFecha);
		
		JLabel lblTienda = new JLabel("Tienda:");
		lblTienda.setBounds(360, 35, 46, 14);
		pnlTrnOriginal.add(lblTienda);
		
		cbxTiendas = new JComboBox(stTiendasDisp);
		cbxTiendas.setBounds(360, 53, 140, 27);
		cbxTiendas.setMaximumRowCount(20);
		pnlTrnOriginal.add(cbxTiendas);
		
		txtCaja = new JTextField();
		txtCaja.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtCaja.setBounds(510, 53, 43, 25);
		pnlTrnOriginal.add(txtCaja);
		txtCaja.setColumns(10);
		
		JLabel lblCaja = new JLabel("Caja:");
		lblCaja.setBounds(510, 35, 46, 14);
		pnlTrnOriginal.add(lblCaja);
		
		txtTransaccion = new JTextField();
		txtTransaccion.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtTransaccion.setBounds(565, 53, 43, 25);
		pnlTrnOriginal.add(txtTransaccion);
		txtTransaccion.setColumns(10);
		
		JLabel lblTransaccin = new JLabel("Trn.:");
		lblTransaccin.setBounds(565, 35, 31, 14);
		pnlTrnOriginal.add(lblTransaccin);
		
		txtClienteOri = new JTextField();
		txtClienteOri.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtClienteOri.setEditable(false);
		txtClienteOri.setBounds(10, 105, 100, 25);
		pnlTrnOriginal.add(txtClienteOri);
		txtClienteOri.setColumns(10);
		
		JLabel lblClienteOri = new JLabel("Cliente:");
		lblClienteOri.setBounds(10, 87, 55, 14);
		pnlTrnOriginal.add(lblClienteOri);
		
		txtNombreOri = new JTextField();
		txtNombreOri.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtNombreOri.setEditable(false);
		txtNombreOri.setBounds(120, 105, 300, 25);
		pnlTrnOriginal.add(txtNombreOri);
		txtNombreOri.setColumns(10);
		
		JLabel lblNombreOri = new JLabel("Nombre:");
		lblNombreOri.setBounds(120, 87, 80, 14);
		pnlTrnOriginal.add(lblNombreOri);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buscarTransaccion();
			}
		});
		btnBuscar.setBounds(628, 18, 100, 100);
		pnlTrnOriginal.add(btnBuscar);
		btnBuscar.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnBuscar.setIcon(new ImageIcon(Ventana.class.getResource("/com/fla/devoluciones/images/Search48.png")));
		btnBuscar.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnBuscar.setHorizontalTextPosition(SwingConstants.CENTER);
		
		dateChooser.setBounds(260, 53, 95, 25);
		dateChooser.setDateFormatString("dd-MM-yyyy");
		pnlTrnOriginal.add(dateChooser);
		
		JPanel pnlCliente = new JPanel();
		pnlCliente.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Cliente que hace el cambio:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlCliente.setBounds(10, 169, 581, 100);
		frmDevolucinMercanciaVaria.getContentPane().add(pnlCliente);
		pnlCliente.setLayout(null);
		
		txtCliente = new JTextField();
		txtCliente.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtCliente.setText("9999999999999999999");
		txtCliente.setBounds(120, 45, 130, 25);
		pnlCliente.add(txtCliente);
		txtCliente.setColumns(10);
		
		JComboBox<String> cbxTipoDoc = new JComboBox<String>();
		cbxTipoDoc.setToolTipText("Tipo");
		cbxTipoDoc.setModel(new DefaultComboBoxModel<String>(new String[] {"TI", "CC", "NI", "CE"}));
		cbxTipoDoc.setSelectedIndex(1);
		cbxTipoDoc.setBounds(52, 30, 46, 20);
		pnlCliente.add(cbxTipoDoc);
		
		JLabel lblTipoDoc = new JLabel("Tipo:");
		lblTipoDoc.setBounds(23, 32, 30, 14);
		pnlCliente.add(lblTipoDoc);
		
		chckbxgenrico = new JCheckBox("¿Genérico?");
		chckbxgenrico.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		chckbxgenrico.setSelected(true);
		chckbxgenrico.setBounds(21, 58, 92, 23);
		pnlCliente.add(chckbxgenrico);
		
		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setBounds(120, 30, 70, 14);
		pnlCliente.add(lblCliente);
		
		txtNombre = new JTextField();
		txtNombre.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtNombre.setBounds(262, 45, 300, 25);
		pnlCliente.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(263, 30, 70, 14);
		pnlCliente.add(lblNombre);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnSalir.setIcon(new ImageIcon(Ventana.class.getResource("/com/fla/devoluciones/images/Exit.png")));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				close();
			}
		});
		btnSalir.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnSalir.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSalir.setBounds(898, 29, 100, 100);
		frmDevolucinMercanciaVaria.getContentPane().add(btnSalir);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clean();
			}
		});
		btnLimpiar.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnLimpiar.setIcon(new ImageIcon(Ventana.class.getResource("/com/fla/devoluciones/images/Clear48.png")));
		btnLimpiar.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnLimpiar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnLimpiar.setBounds(779, 29, 100, 100);
		frmDevolucinMercanciaVaria.getContentPane().add(btnLimpiar);
		
		scrollItem = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollItem.setBounds(5, 292, 800, 368);
		
		tablaPR = new JTable(modeloPR);
		scrollItem.setViewportView(tablaPR);
		scrollItem.setColumnHeaderView(tablaPR.getTableHeader());
		frmDevolucinMercanciaVaria.getContentPane().add(scrollItem);
		
		
	}

	protected void codigoLeido() {
		if( (txtBarCode.getText().length() != 32) || (!Util.isNumeric(txtBarCode.getText())) ) {
			Util.okDialog("Código de barras no es válido. Por favor verifique", frmDevolucinMercanciaVaria, JOptionPane.ERROR_MESSAGE);
			return;
		}
		String stCliente = txtBarCode.getText().substring(0, 12);
		txtClienteOri.setText(stCliente.replaceFirst("^0*", ""));
		txtCliente.setText(stCliente.replaceFirst("^0*", ""));
		chckbxgenrico.setSelected(false);
		String stFecha = "20" + txtBarCode.getText().substring(12, 18);
		Date dtFecha;
		try {
			dtFecha = formatter2.parse(stFecha);
			dateChooser.setDate(dtFecha);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String stTienda = txtBarCode.getText().substring(22, 25);
		iTiendaIndex = 0;
		while ( (stTienda.compareTo(stTiendasList[iTiendaIndex].getCodigo()) != 0) && (iTiendaIndex < stTiendasList.length -1) ) 
			iTiendaIndex++;
		cbxTiendas.setSelectedIndex(iTiendaIndex);
		txtCaja.setText(txtBarCode.getText().substring(25, 28));
		txtTransaccion.setText(txtBarCode.getText().substring(28, 32));
		buscarTransaccion();
	}

	protected void close() {
		frmDevolucinMercanciaVaria.dispose();
		
	}

	protected void clean() {
//		controlPR.clear();
		txtBarCode.setText("");
		txtClienteOri.setText("");
		txtNombreOri.setText("");
		txtCliente.setText("");
		txtNombre.setText("");
		txtCaja.setText("");
		txtTransaccion.setText("");
		controlPR.clear();
		txtBarCode.grabFocus();
		chckbxgenrico.setSelected(true);
		txtCliente.setText("9999999999999999999");
	}

	protected void buscarTransaccion() {
		String stFecha = formatter2.format(dateChooser.getDate());
		int index = cbxTiendas.getSelectedIndex();
		String stSiteCode = stTiendasList[index].getCodigo();
		String stCaja = Util.zeroPad(txtCaja.getText(), 3);
		String stTrxNo = Util.zeroPad(txtTransaccion.getText(), 4);
		String stCardNo = txtClienteOri.getText();
		EngageTransaction engageTransaction = dbServiceImpl.getEngageTransaction(stFecha, stSiteCode, stCaja, stTrxNo, stCardNo);
		if (engageTransaction == null) {
			Util.okDialog("Error buscando transacción", frmDevolucinMercanciaVaria, JOptionPane.ERROR_MESSAGE);
			clean();
			return;
		}
		txtNombreOri.setText(engageTransaction.getCardFName() + " " + engageTransaction.getCardName());
		txtNombre.setText(engageTransaction.getCardFName() + " " + engageTransaction.getCardName());
		for (int i = 0; i < engageTransaction.getProductList().size(); i++) {
			Producto producto = engageTransaction.getProductList().get(i);
			addItem(producto);
		}
	}

	private void addItem(Producto producto) {
		controlPR.addRow(producto);
		
	}
}
