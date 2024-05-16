package com.fla.consultaSaldos.vista;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;

import org.apache.log4j.Logger;

import com.fla.consultaSaldos.Version;
import com.fla.consultaSaldos.control.SaldosTableControl;
import com.fla.consultaSaldos.modelo.SaldosTableModel;
import com.fla.consultaSaldos.proceso.BuscaCliente;
import com.fla.consultaSaldos.proceso.BuscaSaldo;
import com.fla.consultaSaldos.service.DBServiceImplementation;
import com.fla.consultaSaldos.util.Util;
import com.fla.consultaSaldos.modelo.Almacen;
import com.fla.consultaSaldos.modelo.Saldo;

/**
 * Esta clase pinta en pantalla la ventana de consulta de saldos en los archivos keyed de las tiendas.
 * la consulta puede hacerse por número del saldo o por la cédula del cliente.
 * Permite ordenar las columnas.
 * 
 * @author hcastaneda
 * 
 * @date Junio 2018
 * 
 * @version 1.0.0
 * 
 */
public class Ventana extends JFrame implements ActionListener {

	/**
	 *  Inicia definición de variables de clase:
	 */
	private static final long serialVersionUID = 1L;
	private final String txCedula = "Documento Cliente";
	private final String txSaldo = "Número Saldo";
	private final String txDocuCedula = "Ingrese Dato:";

	/** Estiqueta para la caja de ingreso de datos */
	private JLabel lblDocuCedula;

	private JLabel lblTiendas = new JLabel("Seleccione Almacén:");

	/** caja de texto, para insertar datos */
	private JTextField bxDocuCedula;  

	/** caja de texto, para los mensajes al usuario */
	private JTextField bxMensajes = new JTextField("Ingrese el dato y haga clic en [Buscar]");

	/** caja de texto, para mostrar la cédula del saldo */
	private JTextField bxCedula = new JTextField("");  
	private JLabel lblCedula = new JLabel("Cédula:");

	/** caja de texto, para el nombre del dueño del saldo */
	private JTextField bxNombre = new JTextField("");  
	private JLabel lblNombre = new JLabel("Nombre:");

	/** boton con la accion de buscar */
	private JButton btnBuscar; 

	/** boton con la accion de salir */
	private JButton btnSalir;
	
	/** Botón para limpiar la pantalla */
	private JButton btnLimpiar;
	
	private JRadioButton rbNumeroCedula = new JRadioButton(txCedula);
	private JRadioButton rbNumeroSaldo = new JRadioButton(txSaldo, true);
	Font fontBold = new Font("SansSerif", Font.BOLD, 20);
	Font fontPlain = new Font("SansSerif", Font.PLAIN, 18);
	private List<?> saldosCliente = null;
	JComboBox<?> cbTiendas = null;

	/** Lista de las tiendas que se consultan en la BD*/
	Almacen[] stTiendasList = null;

	private Saldo saldo = null;
	
	/** Tabla que contiene los saldos consu detalle */
	private JTable tabla;

	/** Modelo de la tabla */
	private SaldosTableModel modelo = new SaldosTableModel();

	/** Para modificar el modelo */
	private SaldosTableControl control = null;
	
	/** Para ordenar la tabla por columnas */
	private TableRowSorter<SaldosTableModel> ordenar = null;

	/** Scroll que contiene el objeto tabla */
	private JScrollPane scroll;
	
	DBServiceImplementation dbServiceImpl = new DBServiceImplementation();

	private Logger log = Util.getLogger();

	/**
	 *  Finaliza definición de variables de clase:
	*/

	public Ventana() {
		super(); // usamos el contructor de la clase padre JFrame
		inicializarComponentes(); // inicializamos los atributos o componentes
		this.control= new SaldosTableControl(modelo);
		configurarVentana(); // configuramos la ventana
		bxDocuCedula.requestFocus(); // El box para ingresar el dato debe estar activo
	}

	private void configurarVentana() {
		this.setTitle(Version.getVersion()); // colocamos titulo a la ventana
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/Icono_Flamingo.png")));
		this.setSize(1024, 768); // tamaño de la ventana
		this.setLocationRelativeTo(null); // centramos la ventana en la pantalla
		this.setLayout(null); // no usamos ningun layout, solo asi podremos dar posiciones a los componentes
		this.setResizable(true); // hacemos que la ventana sea redimiensionable
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // hacemos que cuando se cierre la ventana termina todo proceso
	}

	private void inicializarComponentes() {
		// creamos los componentes
		rbNumeroCedula.setActionCommand(txCedula);
		rbNumeroSaldo.setActionCommand(txSaldo);
		ButtonGroup group = new ButtonGroup();
		group.add(rbNumeroCedula);
		group.add(rbNumeroSaldo);
		
		JPanel radioPanel = new JPanel(new GridLayout(2, 1));
		radioPanel.setBounds(190, 25, 135, 35);
		radioPanel.add(rbNumeroSaldo);
		radioPanel.add(rbNumeroCedula);
		this.getContentPane().add(radioPanel);

		lblDocuCedula = new JLabel(txDocuCedula);
		lblDocuCedula.setBounds(30, 0, 100, 40);
		lblTiendas.setBounds(390, 0, 200, 40);
		List<Almacen> tiendas = dbServiceImpl.getTiendas();
		String[] stTiendasDisp = new String[tiendas.size()];
		stTiendasList = new Almacen[tiendas.size()];
		
		for (int i = 0; i < tiendas.size(); i++) {
			String linea = tiendas.get(i).toString();
			stTiendasDisp[i] = linea;
			stTiendasList[i] = (Almacen) tiendas.get(i);
		}

		cbTiendas = new JComboBox(stTiendasDisp);
		cbTiendas.setBounds(340, 28, 240, 40);
		cbTiendas.setFont(fontPlain);
		cbTiendas.setMaximumRowCount(20);

		// configuramos los componentes de la ventana:
		
		// Caja para ingresar el dato
		bxDocuCedula = new JTextField();
		bxDocuCedula.setBounds(30, 28, 160, 30);
		bxDocuCedula.setFont(fontBold);
		
		// Caja para mensajes al usuario
		bxMensajes.setBounds(30, 74, 550, 30);
		bxMensajes.setFont(fontPlain);
		bxMensajes.setEditable(false);
		
		// Cajas informativas:
		lblCedula.setBounds(30, 110, 80, 25);
		lblCedula.setFont(fontPlain);
		bxCedula.setBounds(130, 110, 450, 25);
		bxCedula.setFont(fontPlain);
		bxCedula.setEditable(false);
		lblNombre.setBounds(30, 140, 80, 25);
		lblNombre.setFont(fontPlain);
		bxNombre.setBounds(130, 140, 450, 25);
		bxNombre.setFont(fontPlain);
		bxNombre.setEditable(false);

		// Botón para buscar:
		btnBuscar = new JButton();
		btnBuscar.setText(" Buscar "); // colocamos un texto al boton
		btnBuscar.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnBuscar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnBuscar.setIcon(new ImageIcon(this.getClass().getResource("/images/search.png")));
		btnBuscar.setBounds(600, 20, 100, 100); // colocamos posicion y tamanio al boton (x, y, ancho, alto)

		// Agregamos una acción al botón Buscar
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				buscar();
			}
		});

		// Botón para salir de la pantalla:
		btnSalir = new JButton();
		btnSalir.setText(" Salir "); // colocamos un texto al boton
		btnSalir.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnSalir.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSalir.setIcon(new ImageIcon(this.getClass().getResource("/images/Exit.png")));
		btnSalir.setBounds(880, 20, 100, 100); // colocamos posicion y tamanio al boton (x, y, ancho, alto)

		// Agregamos una acción al botón Salir
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				close();
			}
		});

		// Botón para limpiar la pantalla:
		btnLimpiar = new JButton();
		btnLimpiar.setText(" Limpiar "); // colocamos un texto al boton
		btnLimpiar.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnLimpiar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnLimpiar.setIcon(new ImageIcon(this.getClass().getResource("/images/Clear.png")));
		btnLimpiar.setBounds(740, 20, 100, 100); // colocamos posicion y tamanio al boton (x, y, ancho, alto)

		// Agregamos una acción al botón Salir
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				bxDocuCedula.setText("");
				clean();
			}
		});

		// Configura la tabla de saldos
		// Un JScrollPane con el JTable dentro.
		// Se crea el JScrollPane, el JTable y se pone la cabecera...
		tabla = new JTable(modelo);
		ordenar = new TableRowSorter<SaldosTableModel>(modelo);
		tabla.setRowSorter(ordenar);
//		ordenar.setRowFilter(RowFilter.regexFilter("A", 1));
		tabla.setFont(fontPlain);
		tabla.getTableHeader().setFont(fontBold);
		tabla.setRowHeight(30);
		
		// Organiza el ancho de las columnas
		TableColumn columna;
		// La columna de CODIGO:
		columna = tabla.getColumnModel().getColumn(0);
		columna.setPreferredWidth(60);
		// La columna de FECHA:
		columna = tabla.getColumnModel().getColumn(1);
		columna.setPreferredWidth(60);
		// La columna de VALOR:
		columna = tabla.getColumnModel().getColumn(2);
		columna.setPreferredWidth(80);
		// La columna de ESTADO es la mas ancha.
		columna = tabla.getColumnModel().getColumn(4);
		columna.setPreferredWidth(180);
		// La columna de F. RETIRO: 
		columna = tabla.getColumnModel().getColumn(5);
		columna.setPreferredWidth(60);

		scroll = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setBounds(05, 180, 1000, 495);
		scroll.setBorder(null);
		scroll.setViewportView(tabla);
		scroll.setColumnHeaderView(tabla.getTableHeader());

		//adicionamos los componentes a la ventana
		this.add(lblDocuCedula);
		this.add(bxDocuCedula);
		this.add(lblTiendas);
		this.add(cbTiendas);
		this.add(btnBuscar);
		this.add(btnLimpiar);
		this.add(btnSalir);
		this.add(bxMensajes);
		this.add(lblCedula);
		this.add(bxCedula);
		this.add(lblNombre);
		this.add(bxNombre);
		this.add(scroll);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}

	private void buscar() {
		// Se limpia la grilla
		clean();
		bxMensajes.setText("Un momento por favor. Buscando...");
		this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
	    
		// obtenemos el contenido de la caja de texto
		String nroDoc = bxDocuCedula.getText();
		int index = cbTiendas.getSelectedIndex();
		String stCodigo = stTiendasList[index].getCodigo();
		String stNombre = stTiendasList[index].getNombre();
		String stIP = stTiendasList[index].getIP();
		
		// valida que el dato sea numérico:
		if (!Util.isNumeric(nroDoc)) {
			Util.okDialog("El dato ingresado no es válido", (JFrame) this, JOptionPane.ERROR_MESSAGE);
			log.info("El dato ingresado no es válido: " + nroDoc);
			clean();
			this.setCursor(Cursor.getDefaultCursor());
			return;
		}

		// Si está seleccionada la opción de buscar por saldo
		if(rbNumeroSaldo.isSelected()) {
			saldo = BuscaSaldo.getSaldo(nroDoc, stCodigo, stIP);
			// Se agega el saldo al final de la tabla
			if (saldo != null) {
				bxMensajes.setText("Saldo " + nroDoc + " encontrado en " + stNombre);
				bxNombre.setText(saldo.getNombre() + " " + saldo.getApellido());
				bxCedula.setText(saldo.getDocid());
				control.addRow(saldo);
			} else {
				Util.okDialog("Saldo " + nroDoc + " no encontrado en " + stNombre, this, JOptionPane.ERROR_MESSAGE);
				log.info("Saldo " + nroDoc + " no encontrado en " + stNombre);
				clean();
			}
		}
		else {
			saldosCliente = BuscaCliente.getSaldosCliente(Util.zeroPad(nroDoc, 12), stCodigo, stIP);
			if (saldosCliente.size() > 0) {
				bxMensajes.setText(saldosCliente.size() + " saldos encontrados en " + stNombre + " para " + nroDoc);
				for (int i = 0; i < saldosCliente.size(); i++) {
					Saldo saldo = (Saldo) saldosCliente.get(i);
					if(bxNombre.getText() == null || bxNombre.getText().isEmpty()) 
						if(saldo.getNombre() != null && !saldo.getNombre().isEmpty())
							bxNombre.setText(saldo.getNombre() + " " + saldo.getApellido());
					if(bxCedula.getText() == null || bxCedula.getText().isEmpty()) 
						if(saldo.getDocid() != null && !saldo.getDocid().isEmpty())
							bxCedula.setText(saldo.getDocid());
					// Algunos campos requieren de formato
					saldo.setFechael(Util.dateFormat(saldo.getFechael()));
					saldo.setFechare(Util.dateFormat(saldo.getFechare()));
					saldo.setValordoc(Util.moneyFormat(saldo.getValordoc(), 0));
					// Se agega el saldo al final de la tabla
					control.addRow(saldo);
				}
			} else {
				Util.okDialog("Sin saldos para esta cédula " + nroDoc + " en " + stNombre, this, JOptionPane.ERROR_MESSAGE);
				log.info("Sin saldos para esta cédula " + nroDoc + " en " + stNombre);
				clean();
			}
		}
		this.setCursor(Cursor.getDefaultCursor());
	}

	// Método para cerrar la ventana
	private void close() {
		this.setCursor(Cursor.getDefaultCursor());
		this.dispose();
	}

	// Método para limpiar la ventana
	protected void clean() {
		// Inicializa lista
		control.clear();
		bxNombre.setText("");
		bxCedula.setText("");
		bxMensajes.setText("Ingrese el dato y haga clic en [Buscar]");
		bxDocuCedula.requestFocus(); // El box para ingresar el dato debe estar activo
	}

	@Override
	public void setVisible(boolean b) {
		if (b) {
			bxDocuCedula.requestFocus();
		}
		super.setVisible(b);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Ventana V = new Ventana(); // creamos una ventana
					V.setVisible(true); // hacemos visible la ventana creada
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
