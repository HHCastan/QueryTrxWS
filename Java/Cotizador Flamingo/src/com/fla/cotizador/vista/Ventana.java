package com.fla.cotizador.vista;

import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.EventQueue;
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
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.border.Border;
import javax.swing.border.SoftBevelBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;

import org.apache.log4j.Logger;
import org.datacontract.schemas._2004._07.WcfRemisionesRegistroPos_Servicio.ArticuloRem;
import org.datacontract.schemas._2004._07.WcfRemisionesRegistroPos_Servicio.RemisionEN;
import org.jdesktop.swingx.JXDatePicker;

import com.fla.cotizador.Version;
import com.fla.cotizador.controlador.Coordinador;
import com.fla.cotizador.controlador.ProductosTableControl;
import com.fla.cotizador.controlador.TenderTableControl;
import com.fla.cotizador.modelo.Almacen;
import com.fla.cotizador.modelo.Cliente;
import com.fla.cotizador.modelo.ClienteSicaf;
import com.fla.cotizador.modelo.ClienteSisteCredito;
import com.fla.cotizador.modelo.Cotizacion;
import com.fla.cotizador.modelo.DetalleCotizacion;
import com.fla.cotizador.modelo.OpcionesAplicacion;
import com.fla.cotizador.modelo.Producto;
import com.fla.cotizador.modelo.ProductosTableModel;
import com.fla.cotizador.modelo.Tender;
import com.fla.cotizador.modelo.TenderTableModel;
import com.fla.cotizador.modelo.Usuario;
import com.fla.cotizador.proceso.BuscaProducto;
import com.fla.cotizador.servicio.DBServiceImplementation;
import com.fla.cotizador.servicio.RemisionServiceImplementation;
import com.fla.cotizador.servicio.SisteCreditoServiceImplementation;
import com.fla.cotizador.transformadores.TransformadorTrama2Canopus;
import com.fla.cotizador.transformadores.TransformadorTrama2MotorDecisiones;
import com.fla.cotizador.util.Auxiliar;
import com.fla.cotizador.util.BoundsPopupMenuListener;
import com.fla.cotizador.util.CapturaCodigoCamara;
import com.fla.cotizador.util.CotizacionProductosRPT;
import com.fla.cotizador.util.SendEMail;
import com.fla.cotizador.util.Util;

import co.com.flamingo.canopus.principal.Core;
import com.flamingo.motor.decisiones.Operador;

/**
 * Esta clase pinta en pantalla la ventana de consulta de cotización de productos y sus promociones
 * las tiendas. la consulta requiere una identificación válida del operador. Seleccionar una tienda,
 * ingresar información del cliente, ingresar los productos y consultar el total según el precio
 * de los artículos en el sistema POS y los descuentos entregados por el motor de promociones.
 * 
 * @author hcastaneda
 * 
 * @date Agosto 2018
 * 
 * @version 1.0.0
 * 
 */
public class Ventana extends JFrame implements ActionListener {

	/**
	 *  Inicia definición de variables de clase:
	 */
	
	private Coordinador setCoordinador;	
	private static final long serialVersionUID = 1L;
	private final String txIsGenerico = "¿Genérico?:";

	/** Para setear el tamaño de la ventana principal */
//	private Dimension tamanoPantalla;
//	private Rectangle pantalla;

	/** Estiqueta para la caja de ingreso de datos */
	private JLabel lblGenerico;

	private JLabel lblTiendas = new JLabel("Seleccione Almacén:");

	/** caja de texto, para cliente */
	private JPanel jpCustomerPanel = new JPanel();
	private JTextField bxCliente;  
	private JLabel lblTipoDoc = new JLabel(" Tipo Documento:");
	String[] arTipoDoc = {"TI", "CC", "NI", "CE"};
	private JComboBox<?> cbxTipoDoc;
	
	/** caja de chequeo para cliente genérco */
	private JCheckBox chbGenerico;
	
	/** Cliente Genérico */
	private final String GENERICO = "9999999999999999999";
	
	/** Cliente anterior para detectar cambios de cédual */
	private String sClientePrev = GENERICO;
	
	private JButton btnAcercaDe;

//	private JTextField bxMensajes = new JTextField("Ingrese la información y haga clic en botón [Procesar]");
	
	/** cajas de texto para mensajes generales */
	private JXDatePicker picker = new JXDatePicker(); 
	private String txFecha = Util.getDate();
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
	SimpleDateFormat formatter2 = new SimpleDateFormat("dd/MM/yyyy");
	private Date dtPrevDate = null;
	private JTextField bxHora = new JTextField(Util.getTime());

	/** caja de texto, para los mensajes al usuario */
	private JLabel lblUser = new JLabel("Usuario:");
	private JTextField bxUser = new JTextField(System.getProperty("user.name"));

	/** caja de texto, para la cédula del vendedor */
	private JLabel lblVendedor = new JLabel("Vendedor:");
	private JTextField bxVendedor = new JTextField();

	/** caja de texto, para mostrar la cédula del cliente */
	private JLabel lblCliente = new JLabel("Cliente:");

	/** caja de texto, para el nombre del cliente */
	private JTextField bxNombre = new JTextField("");  
	private JLabel lblNombre = new JLabel("Nombre:");

	/** Sección para datos del artículo leído */
	private JPanel jpItemPanel = new JPanel();
	private JTextField bxItemCode;
	private JLabel lblItemCode = new JLabel("Código:");
	private JTextField bxItemDesc;
	private JLabel lblItemDesc = new JLabel("Descripción:");
	private JTextField bxItemPrice;
	private JLabel lblItemPrice = new JLabel("Precio:");
	private String stPrevItemCode = null;
	/** Botón para adicionar artículos a la tabla */
	private JButton btnAddItem;
	/** Botón para capturar código de barras con la cámara */
	private JButton btnCodCamara;
	/** Botón para capturar código de remisión */
	private JButton btnRemision;
	/** Boleano para determinar si se ingresó una remisión: */
	private boolean isRemision = false;
	/** Botón para capturar una lista de artículos */
	private JButton btnProductList;
	
	/** Sección para los medios de pago */
	private JPanel jpTenderPanel = new JPanel();
	private JTextField bxTenderDesc;
	private JLabel lblTenderDesc = new JLabel("Medio de pago:");
	private JTextField bxTenderAmnt;
	private JLabel lblTenderAmnt = new JLabel("Monto:");
	public static String sTomcatServer = null;
	
	/** Sección para los totales */
	private JPanel jpTotalPanel = new JPanel();
	private JTextField bxCantidadTotal;
	private JLabel lblCantidadTotal = new JLabel("Cantidad:");
	private JTextField bxTotalBruto;
	private JLabel lblTotalBruto = new JLabel("Valor Artículos:");
	private JTextField bxTotalDescuento;
	private JLabel lblTotalDescuento = new JLabel("Descuentos Motor:");
	private JTextField bxTotalDecisiones;
	private JLabel lblTotalDecisiones = new JLabel("Otros Descuentos:");
	private JTextField bxTotalMP;
	private JLabel lblSubTotal = new JLabel("SubTotal:");
	private JTextField bxSubTotal;
	private JLabel lblTotalMP = new JLabel("Medios de pago:");
	private JTextField bxBalance;
	private JLabel lblBalance = new JLabel("Balance:");
	
	/** Botón para adicionar medios de pago a la tabla */
	private JButton btnAddTender;

	/** boton con la accion de procesar */
	private JButton btnProcesar; 

	/** boton con la accion de salir */
	private JButton btnSalir;
	
	/** Botón para limpiar la pantalla */
	private JButton btnLimpiar;
	
	/** Botón para imprimir cotización de artículos */
	private JButton btnImprimir;
	
	/** Botón para la venta de seguros */
	private JButton btnSeguros = new JButton("Seguro/Garantía");
	
	/** Botón para enviar cotización por correo */
	private JButton btnCorreo;
	
	private Font fontBold = new Font("SansSerif", Font.BOLD, 20);
	private Font fontPlain = new Font("SansSerif", Font.PLAIN, 16);


	JComboBox<?> cbTiendas = null; // ComboBox para las tiendas
	private int prevStore = -1;  // Para controlar si la tienda ha cambiado
	private boolean bStoreChanged = true;
	private String stCodigoAlmacen = null;
	
	private boolean bCustomerChanged = false;  // para controlar si el cliente fue cambiado con carrito
	
	JComboBox<?> cbTenders = null;

	/** Lista de las tiendas que se consultan en la BD*/
	Almacen[] stTiendasList = null;
	
	/** Lista de los medios de pago del motor */
	Tender[] stTendersList = null;

	private Producto producto = null;
	
	private Tender tender = null;
	
	private Cliente cliente = null;
	
	/** Tabla que contiene los artículos con su detalle */
	private JTable tablaPR;

	/** Modelo de la tabla */
	private ProductosTableModel modeloPR = new ProductosTableModel();

	/** Para modificar el modelo */
	private ProductosTableControl controlPR = null;
	
	/** Para ordenar la tabla por columnas */
	private TableRowSorter<ProductosTableModel> ordenarPR = null;

	/** Scroll que contiene el objeto tabla */
	private JScrollPane scrollItem;
	
	/** Tabla que contiene los artículos con su detalle */
	private JTable tablaMP;

	/** Modelo de la tabla */
	private TenderTableModel modeloMP = null;

	/** Para modificar el modelo */
	private TenderTableControl controlMP = null;
	
	/** Para ordenar la tabla por columnas */
	private TableRowSorter<TenderTableModel> ordenarMP = null;

	/** Scroll que contiene el objeto tabla */
	private JScrollPane scrollTender;
	
	/** Instancia de Canopus para consultas al motor */
	private Core canopus = null;
	
	/** Flag que indica que se recuperó una contización */
	private String sCarritoRecuperado = "";
	
	// El cliente recuperado:
	private String sClienteRecuperado = "";
	
	/** Menú contextual sobre las tablas */
	private final JPopupMenu ppMenuMP = new JPopupMenu();
	private final JPopupMenu ppMenuPR = new JPopupMenu();
	private final JPopupMenu ppMenuCL = new JPopupMenu();
	private JMenuItem jmiBorrarMP = new JMenuItem("Quitar Medio de pago de la lista");
	private JMenuItem jmiSisteCredito = new JMenuItem("Simular cuota SisteCrédito");
	private JMenuItem jmiBorrarPR = new JMenuItem("Quitar Artículo de la lista");
	private JMenuItem jmiConsultaPromos = new JMenuItem("Consultar promociones asociadas a este artículo");
	private JMenuItem jmiConsultaInventario = new JMenuItem("Consultar inventario asociado a este artículo");
	private JMenuItem jmiModificarPrecio = new JMenuItem("Modificar el precio a este artículo");
	private JMenuItem jmiModificarCantidad = new JMenuItem("Modificar cantidad a este artículo");
	private JMenuItem jmiFichaEamitemr = new JMenuItem("Ver información del Controlador");
	private JMenuItem jmiProductAttrib = new JMenuItem("Ver atributos del artículo");
	
	private JMenuItem jmiVista360Cliente = new JMenuItem("Consultar Vista 360 Cliente");
	private JMenuItem jmiConsultaHistorial = new JMenuItem("Consultar historial de beneficios recibidos");
	private JMenuItem jmiResumenBeneficios = new JMenuItem("Consultar resumen de beneficios recibidos");
	private JMenuItem jmiReferenciasCliente = new JMenuItem("Consultar Referencias del Cliente");
	private JMenuItem jmiSegmentosClienteMotor = new JMenuItem("Consultar pertenencia a segmentos en motor de promociones");
	private JMenuItem jmiVentaAsistidaCredito = new JMenuItem("Venta Asistida del crédito");
	private JMenuItem jmiConsultaCuposWeb = new JMenuItem("Consulta de cupos de crédito desde la WEB");
//	private JMenuItem jmiConsultaCuposLoc = new JMenuItem("Consulta de cupo Mefía y NUG");
	
	private JButton btnSimulaCuotaFiao = new JButton("Calcular Cuota");
	private JButton btnSimulaCuotaMefia = new JButton("Calcular Cuota");
	SimuladorDeCuotaSafix scs;
	SimuladorDeCuotaMefia scm;
	SimuladorSisteCredito ssc;
	
	private JButton btnSaveCart = new JButton("Guardar Carrito");
	private boolean blnCarSaved = false;
	private boolean blnProcessed = false;
	
	/** Para alinear las columnas numéricas de la tabla a la derecha */
	DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
	
	/** Para centrar las columnas de la tabla */
	DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
	
	/** Para mostrar un popup con el teclado numérico */
	VirtualNumPad kp;
	
	/** Servicio para conexion con bases de datos */
	DBServiceImplementation dbServiceImpl = new DBServiceImplementation();
	
	/** Servicio para conexion con el sistema de remisiones */
	RemisionServiceImplementation remisionImpl = new RemisionServiceImplementation(); 
	
    Border raisedBorder = new SoftBevelBorder(SoftBevelBorder.RAISED);
    Border loweredBorder = new SoftBevelBorder(SoftBevelBorder.LOWERED);
    
    /** Manejo de perfiles*/
    List<OpcionesAplicacion> opcionesAplicacion;

	private Logger logCotizador;
//	private int cupoCredito = 0;
	private Usuario usuario;
	private boolean isClienteNuevo = false;
	private ClienteSicaf clienteSicaf;
	private boolean blnPrinted;
	private String sPrevCliente = "";
	
	private Cotizacion cotizacion = null;
	

	/**
	 * *
	 *  Finaliza definición de variables de clase
	 * *
	 * @param log 
	*/

	public Ventana(Logger log) {
		super(); // usamos el constructor de la clase padre JFrame
		setLog(log);
		inicializarComponentes(); // inicializamos los atributos o componentes
		configurarVentana(); // configuramos la ventana
		clean(); // Se inicia con una ventana libre de datos
		componerVentana();
		adicionarListeners();
		adicionarComponentes();
		activateGenerico();
	}

	private void adicionarListeners() {
		bxCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				bxClienteClic();
			}
		});
		
		jmiBorrarMP.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				delTender(e);
			}
		});
		
		jmiSisteCredito.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sisteCredito(e);
			}
		});
		
		jmiBorrarPR.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				delItem(e);
			}
		});
		
		jmiConsultaPromos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				consultaPromos(e);
			}
		});
		
		jmiConsultaInventario.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				consultaInventario(e);
			}
		});
		
		jmiModificarPrecio.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				modificarPrecio(e);
			}
		});
		
		jmiModificarCantidad.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				modificarCantidad(e);
			}
		});
		
		jmiFichaEamitemr.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fichaEamitemr(e);
			}
		});
		
		jmiProductAttrib.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				productAttrib(e);
			}
		});
		
		jmiVista360Cliente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				vista360Cliente(e);
			}
		});
		
		jmiConsultaHistorial.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				consultaHistorialCliente(e);
			}
		});
		
		jmiResumenBeneficios.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				consultaResumenBeneficios(e);
			}
		});
		
		jmiReferenciasCliente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				referenciasCliente(e);
			}
		});
		
		jmiSegmentosClienteMotor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				segmentosClienteMotor(e);
			}
		});
		
		jmiVentaAsistidaCredito.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				autoGestionDelCredito(e);
			}
		});
		
		jmiConsultaCuposWeb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				consultaCuposCredito(e);
			}
		});
		
//		jmiConsultaCuposLoc.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				consultaCuposLocal(e);
//			}
//		});
		
		// Agregamos un listener para saber si la tienda fue cambiada
		cbTiendas.addItemListener(new StoreChangeListener());

		// Agregamos una acción al check box:
		chbGenerico.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				checkingGenerico(event); 
			}
		});


		bxItemPrice.addFocusListener(focusListenerProductPrice);
		
		bxItemCode.addKeyListener(keyListener);

		bxItemCode.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				bxItemClic();
			}
		});

		bxItemCode.addFocusListener(focusListenerPR);

		// Agregamos una acción al botón Adicionar Item
		btnAddItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				addItem();
			}
		});
		
		// Agregamos una acción al botón código camara
		btnCodCamara.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				capturarCodigoCamara();
			}
		});

		// Agregamos una acción al botón código de remisión
		btnRemision.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				capturarRemision();
			}
		});

		// Agregamos una acción al botón código de pegar lista de productos
		btnProductList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				pegarListaArticulos();
			}
		});

		btnAddTender.addKeyListener(keyListener);
		// Agregamos una acción al botón Adicionar Item

		btnAddTender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				addTender();
			}
		});
		
		bxTenderAmnt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				bxTenderClic();
			}
		});

		// Agregamos una acción al botón procesar
		btnProcesar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				procesar();
			}
		});

		// Agregamos una acción al botón Salir
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				if ((tablaPR.getRowCount() > 0) && (blnProcessed) && (bxCliente.getText().compareTo(GENERICO) != 0) ) {
					String msg = "¿Desea guardar esta cotización antes de limpiar?";
					Object[] options = { "Si, guardar cotización actual", "No, iniciar nueva cotización" };
					int h = Util.sigaPareMessage(msg, new JDialog(), JOptionPane.QUESTION_MESSAGE, options);
					if (h == 0) {
						// Valida si hay mezcla de eventos financieros:
						if (Util.isMixEvents(modeloPR)) {
							Object[] options2 = { "SI, continuar", "NO, continuar" };
							msg = "Hay productos con diferentes beneficios financieros en esta cotización. ¿Desea continuar con la grabación?";
							if(( Util.sigaPareMessage(msg, new JDialog(), JOptionPane.QUESTION_MESSAGE, options2)) == 0) {
								saveCart();
							} else {
								Util.okDialog("No se ha guardado el carrito de ventas", new JFrame(), JOptionPane.ERROR_MESSAGE);
							}
						} else {
							saveCart();
						}
					}
				}
				bxCliente.setText("");
				clean();
			}
		});

		// Agregamos una acción al botón Salir
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				close();
			}
		});

		btnImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				imprimir();
			}
		});

		btnSimulaCuotaFiao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				simulaCuotaFiao();
			}
		});

		btnSimulaCuotaMefia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				simulaCuotaMefia();
			}
		});

		btnSaveCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				if (bxCliente.getText().compareTo(GENERICO) != 0) {
					if (blnCarSaved) {
						Util.okDialog("No hay cambios para guardar", new JFrame(), JOptionPane.ERROR_MESSAGE);
						return;
					}
					// Valida si hay mezcla de eventos financieros:
					if (Util.isMixEvents(modeloPR)) {
						Object[] options2 = { "SI, continuar", "NO, continuar" };
						String msg = "Hay productos con diferentes beneficios financieros en esta cotización. ¿Desea continuar con la grabación?";
						if(( Util.sigaPareMessage(msg, new JDialog(), JOptionPane.QUESTION_MESSAGE, options2)) == 0) {
							saveCart();
						} else {
							Util.okDialog("No se ha guardado el carrito de ventas", new JFrame(), JOptionPane.ERROR_MESSAGE);
						}
					} else {
						saveCart();
					}
				} else {
					Util.okDialog("Cliente genérico no guarda carrito", new JFrame(), JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		btnCorreo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				enviarXcorreo();
			}
		});

		btnSeguros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				ventaSeguros();
			}
		});

		tablaPR.addMouseListener (new TableMouseListener(tablaPR));

		tablaMP.addMouseListener (new TableMouseListener(tablaMP));
		
		picker.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				cambioFecha();
			}
		});

		// Agregamos una acción al botón Acerca de
		btnAcercaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				Util.imageDialog(new JFrame(), "/images/Huvo de Pascua.png");
			}
		});
		
	}  //Fin adicionarListeners()

	protected void imprimir() {
		if (!Util.tienePermiso(15, usuario)) // Si no tiene permiso segun bit 15 del perfil
			return;

		if(bxSubTotal.getText().compareTo("$ 0") == 0) {
			Util.okDialog("Primero debe agregar artículos", new JFrame(), JOptionPane.ERROR_MESSAGE);
			return;
		}

		if (blnPrinted) {
			Util.okDialog("Ya hizo una impresión de esta cotización", new JFrame(), JOptionPane.ERROR_MESSAGE);
			return;			
		}
		
		fillCotizacion();
    	if(!blnCarSaved) 
    		saveCart();
		CotizacionProductosRPT cpRPT = new CotizacionProductosRPT(cotizacion);
		cpRPT.imprimir();
    	blnPrinted = true;
	}

	private void componerVentana() {
		// configuramos los componentes y sus distribuciones en la pantalla:
		
		// Caja para ingresar el cliente
		jpCustomerPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), " Datos del Cliente: "));
		jpCustomerPanel.setBounds(5, 45, 620, 100);
		jpCustomerPanel.setLayout(null);

		lblCliente.setBounds(10, 20, 80, 25);
		lblCliente.setFont(fontPlain);
		bxCliente.setBounds(80, 20, 215, 30);
		bxCliente.setBorder(loweredBorder);
		bxCliente.setFont(fontBold);
		bxCliente.requestFocus(); // El box para ingresar el dato debe estar activo
		ppMenuCL.add(jmiVista360Cliente);
		ppMenuCL.add(jmiConsultaHistorial);
		ppMenuCL.add(jmiResumenBeneficios);
//		ppMenuCL.add(jmiReferenciasCliente); // Se quita por petición del Negocio
		ppMenuCL.add(jmiSegmentosClienteMotor);
		ppMenuCL.add(jmiVentaAsistidaCredito);
		ppMenuCL.add(jmiConsultaCuposWeb);
//		ppMenuCL.add(jmiConsultaCuposLoc);
		
		bxCliente.setComponentPopupMenu(ppMenuCL);

		lblTipoDoc.setBounds(300, 20, 130, 30);
		lblTipoDoc.setFont(fontPlain);
		lblTipoDoc.setHorizontalAlignment(SwingConstants.RIGHT);
		cbxTipoDoc.setBounds(440, 20, 50, 30);
		cbxTipoDoc.setFont(fontPlain);

		lblGenerico.setBounds(500, 15, 100, 40);
		chbGenerico.setBounds(570, 20, 40, 30);
		chbGenerico.setToolTipText("Cambiar cliente genérico / no genérico");
		
		// Cajas informativas:
		lblNombre.setBounds(10, 60, 80, 25);
		lblNombre.setFont(fontPlain);
		bxNombre.setBounds(80, 60, 500, 25);
		bxNombre.setHorizontalAlignment(SwingConstants.LEFT);
		bxNombre.setFont(fontPlain);
		bxNombre.setBorder(loweredBorder);
		bxNombre.setEditable(false);

		jpCustomerPanel.add(lblCliente);
		jpCustomerPanel.add(bxCliente);
		jpCustomerPanel.add(lblNombre);
		jpCustomerPanel.add(bxNombre);
		jpCustomerPanel.add(lblTipoDoc);
		jpCustomerPanel.add(cbxTipoDoc);
		jpCustomerPanel.add(lblGenerico);
		jpCustomerPanel.add(chbGenerico);
		
		// Caja para ingresar el producto
		jpItemPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), " Datos Artículo: "));
		jpItemPanel.setBounds(5, 150, 590, 100);
		jpItemPanel.setLayout(null);
//		btnCodCamara.setVerticalTextPosition(SwingConstants.BOTTOM);
//		btnCodCamara.setHorizontalTextPosition(SwingConstants.CENTER);
//		btnCodCamara.setIcon(new ImageIcon(this.getClass().getResource("/images/camara32.png")));
//		btnCodCamara.setBorder(raisedBorder);
//		btnCodCamara.setBounds(155, 40, 30, 30); 
		lblItemCode.setBounds(10, 20, 100, 25);
		bxItemCode.setBounds(10, 40, 140, 30);
		bxItemCode.setFont(fontBold);
		bxItemCode.setBorder(loweredBorder);
		lblItemDesc.setBounds(155, 20, 100, 25);
		bxItemDesc.setBounds(155, 40, 245, 30);
		bxItemDesc.setFont(fontPlain);
		bxItemDesc.setBorder(loweredBorder);
		bxItemDesc.setEditable(false);
		lblItemPrice.setBounds(405, 20, 100, 25);
		bxItemPrice.setBounds(405, 40, 100, 30);
		bxItemPrice.setFont(fontPlain);
		bxItemPrice.setBorder(loweredBorder);
		bxItemPrice.setHorizontalAlignment(SwingConstants.RIGHT);
//		bxItemPrice.setEditable(false);
		btnAddItem.setText("Agregar");
		btnAddItem.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnAddItem.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAddItem.setIcon(new ImageIcon(this.getClass().getResource("/images/check32.png")));
		btnAddItem.setBorder(raisedBorder);
		btnAddItem.setBounds(515, 20, 60, 60); 

		jpItemPanel.add(lblItemCode);
		jpItemPanel.add(bxItemCode);
		jpItemPanel.add(lblItemDesc);
		jpItemPanel.add(bxItemDesc);
		jpItemPanel.add(lblItemPrice);
		jpItemPanel.add(bxItemPrice);
//		jpItemPanel.add(btnCodCamara);
		jpItemPanel.add(btnAddItem);

		BoundsPopupMenuListener listener = new BoundsPopupMenuListener(true, false);cbTenders.setBounds(10, 40, 180, 30);
		cbTenders.setFont(fontPlain);
		cbTenders.addPopupMenuListener(listener);
		cbTenders.setMaximumRowCount(20);
		
		
		jpTenderPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), " Medios de pago: "));
		jpTenderPanel.setBounds(635, 150, 370, 100);
		jpTenderPanel.setLayout(null);
		lblTenderDesc.setBounds(10, 20, 100, 25);
		bxTenderDesc.setBounds(10, 40, 300, 30);
		bxTenderDesc.setFont(fontBold);
		bxTenderDesc.setBorder(loweredBorder);
		lblTenderAmnt.setBounds(200, 20, 90, 25);
		bxTenderAmnt.setBounds(200, 40, 90, 30);
		bxTenderAmnt.setFont(fontPlain);
		bxTenderAmnt.setBorder(loweredBorder);
		btnAddTender.setText("Agregar");
		btnAddTender.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnAddTender.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAddTender.setIcon(new ImageIcon(this.getClass().getResource("/images/check32.png")));
		btnAddTender.setBorder(raisedBorder);
		btnAddTender.setBounds(300, 20, 60, 60); 
		jpTenderPanel.add(lblTenderDesc);
		jpTenderPanel.add(cbTenders);
		jpTenderPanel.add(lblTenderAmnt);
		jpTenderPanel.add(bxTenderAmnt);
		jpTenderPanel.add(btnAddTender);

		// Cajas para los totales:
		jpTotalPanel.setBounds(3, 570, 1005, 85);
		jpTotalPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), " Totales: "));
		jpTotalPanel.setLayout(null);

		lblCantidadTotal.setBounds(10, 20, 60, 25);
		bxCantidadTotal.setBounds(10, 40, 60, 30);
		bxCantidadTotal.setFont(fontBold);
		bxCantidadTotal.setBorder(loweredBorder);
		bxCantidadTotal.setEditable(false);
		bxCantidadTotal.setHorizontalAlignment(SwingConstants.RIGHT);

		lblTotalBruto.setBounds(90, 20, 130, 25);
		bxTotalBruto.setBounds(90, 40, 130, 30);
		bxTotalBruto.setFont(fontBold);
		bxTotalBruto.setBorder(loweredBorder);
		bxTotalBruto.setEditable(false);
		bxTotalBruto.setHorizontalAlignment(SwingConstants.RIGHT);

		lblTotalDescuento.setBounds(240, 20, 130, 25);
		bxTotalDescuento.setBounds(240, 40, 130, 30);
		bxTotalDescuento.setFont(fontBold);
		bxTotalDescuento.setBorder(loweredBorder);
		bxTotalDescuento.setEditable(false);
		bxTotalDescuento.setHorizontalAlignment(SwingConstants.RIGHT);

		lblTotalDecisiones.setBounds(390, 20, 130, 25);
		bxTotalDecisiones.setBounds(390, 40, 130, 30);
		bxTotalDecisiones.setFont(fontBold);
		bxTotalDecisiones.setBorder(loweredBorder);
		bxTotalDecisiones.setEditable(false);
		bxTotalDecisiones.setHorizontalAlignment(SwingConstants.RIGHT);

		lblSubTotal.setBounds(540, 20, 130, 25);
		bxSubTotal.setBounds(540, 40, 130, 30);
		bxSubTotal.setFont(fontBold);
		bxSubTotal.setBorder(loweredBorder);
		bxSubTotal.setEditable(false);
		bxSubTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		
		lblTotalMP.setBounds(690, 20, 130, 25);
		bxTotalMP.setBounds(690, 40, 130, 30);
		bxTotalMP.setFont(fontBold);
		bxTotalMP.setBorder(loweredBorder);
		bxTotalMP.setEditable(false);
		bxTotalMP.setHorizontalAlignment(SwingConstants.RIGHT);

		lblBalance.setBounds(840, 20, 130, 25);
		bxBalance.setBounds(840, 40, 130, 30);
		bxBalance.setFont(fontBold);
		bxBalance.setBorder(loweredBorder);
		bxBalance.setEditable(false);
		bxBalance.setHorizontalAlignment(SwingConstants.RIGHT);

		jpTotalPanel.add(lblCantidadTotal);
		jpTotalPanel.add(bxCantidadTotal);
		jpTotalPanel.add(lblTotalBruto);
		jpTotalPanel.add(bxTotalBruto);
		jpTotalPanel.add(lblTotalDescuento);
		jpTotalPanel.add(bxTotalDescuento);
		jpTotalPanel.add(lblTotalDecisiones);
		jpTotalPanel.add(bxTotalDecisiones);
		jpTotalPanel.add(lblSubTotal);
		jpTotalPanel.add(bxSubTotal);
		jpTotalPanel.add(lblTotalMP);
		jpTotalPanel.add(bxTotalMP);
		jpTotalPanel.add(lblBalance);
		jpTotalPanel.add(bxBalance);
		
		// Caja para mensajes al usuario
//		bxMensajes.setBounds(05, 665, 500, 25);
//		bxMensajes.setFont(fontPlain);
//		bxMensajes.setBorder(loweredBorder);
//		bxMensajes.setEditable(false);
		
        picker.setDate(Calendar.getInstance().getTime());
        picker.setFormats(formatter);
        picker.setBounds(455, 10, 125, 30);
        picker.setFont(fontPlain);
        picker.setBorder(loweredBorder);
        dtPrevDate = picker.getDate();
		
		bxHora.setBounds(595, 10, 80, 30);
		bxHora.setFont(fontPlain);
		bxHora.setBorder(loweredBorder);
		bxHora.setEditable(false);

		lblUser.setBounds(695, 10, 80, 30);
		lblUser.setFont(fontPlain);
		bxUser.setBounds(770, 10, 100, 25);
		bxUser.setFont(fontPlain);
		bxUser.setBorder(loweredBorder);
		bxUser.setEditable(false);
		
		lblVendedor.setBounds(895, 10, 80, 30);
		lblVendedor.setFont(fontPlain);
		bxVendedor.setBounds(975, 10, 100, 25);
		bxVendedor.setFont(fontPlain);
		bxVendedor.setBorder(loweredBorder);
		bxVendedor.setEditable(false);
		
		// Botón para consultar remisión:
		btnRemision.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnRemision.setHorizontalTextPosition(SwingConstants.CENTER);
		btnRemision.setIcon(new ImageIcon(this.getClass().getResource("/images/R32.png")));
		btnRemision.setBorder(raisedBorder);
		btnRemision.setBounds(600, 162, 30, 30);
		btnRemision.setToolTipText("Consultar una remisión");
		
		// Botón para pegar una lista de productos
		btnProductList.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnProductList.setHorizontalTextPosition(SwingConstants.CENTER);
		btnProductList.setIcon(new ImageIcon(this.getClass().getResource("/images/Paste32.png")));
		btnProductList.setBorder(raisedBorder);
		btnProductList.setBounds(600, 210, 30, 30); 
		btnProductList.setToolTipText("Pegar contenido del porta papeles");

		// Botón para procesar:
		btnProcesar.setText(" Procesar "); // colocamos un texto al boton
		btnProcesar.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnProcesar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnProcesar.setIcon(new ImageIcon(this.getClass().getResource("/images/execute_01.png")));
		btnProcesar.setBorder(raisedBorder);
		btnProcesar.setBounds(1030, 50, 100, 100); // colocamos posicion y tamanio al boton (x, y, ancho, alto)

		// Botón para limpiar la pantalla:
		btnLimpiar.setText(" Limpiar "); // colocamos un texto al boton
		btnLimpiar.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnLimpiar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnLimpiar.setIcon(new ImageIcon(this.getClass().getResource("/images/Clear.png")));
		btnLimpiar.setBorder(raisedBorder);
		btnLimpiar.setBounds(1150, 50, 100, 100); // colocamos posicion y tamanio al boton (x, y, ancho, alto)

		btnSimulaCuotaFiao.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnSimulaCuotaFiao.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSimulaCuotaFiao.setBorder(raisedBorder);
		btnSimulaCuotaFiao.setIcon(new ImageIcon(this.getClass().getResource("/images/Fiao64.png")));
		btnSimulaCuotaFiao.setBounds(1150, 180, 100, 100);

		btnSimulaCuotaMefia.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnSimulaCuotaMefia.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSimulaCuotaMefia.setBorder(raisedBorder);
		btnSimulaCuotaMefia.setIcon(new ImageIcon(this.getClass().getResource("/images/Mefía64.png")));
		btnSimulaCuotaMefia.setBounds(1030, 180, 100, 100);

		// Botón para imprimir cotización de artículos:
		btnImprimir.setText("Imprimir"); // colocamos un texto al boton
		btnImprimir.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnImprimir.setHorizontalTextPosition(SwingConstants.CENTER);
		btnImprimir.setIcon(new ImageIcon(this.getClass().getResource("/images/print64.png")));
		btnImprimir.setBorder(raisedBorder);
		btnImprimir.setBounds(1030, 310, 100, 100); // colocamos posicion y tamanio al boton (x, y, ancho, alto)

		btnSaveCart.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnSaveCart.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSaveCart.setBorder(raisedBorder);
		btnSaveCart.setIcon(new ImageIcon(this.getClass().getResource("/images/shoppingcart64.png")));
		btnSaveCart.setBounds(1150, 310, 100, 100);

		btnCorreo.setText("Envíar Correo");
		btnCorreo.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnCorreo.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCorreo.setBorder(raisedBorder);
		btnCorreo.setIcon(new ImageIcon(this.getClass().getResource("/images/Correo64.png")));
		btnCorreo.setBounds(1150, 440, 100, 100);

		btnSeguros.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnSeguros.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSeguros.setBorder(raisedBorder);
		btnSeguros.setIcon(new ImageIcon(this.getClass().getResource("/images/insurance64.png")));
		btnSeguros.setBounds(1030, 440, 100, 100);

		// Botón para salir de la pantalla:
		btnSalir.setText(" Salir "); // colocamos un texto al boton
		btnSalir.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnSalir.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSalir.setIcon(new ImageIcon(this.getClass().getResource("/images/Exit.png")));
		btnSalir.setBorder(raisedBorder);
		btnSalir.setBounds(1150, 555, 100, 100); // colocamos posicion y tamanio al boton (x, y, ancho, alto)

		// Configura la tabla de artículos
		// Un JScrollPane con el JTable dentro.
		// Se crea el JScrollPane, el JTable y se pone la cabecera...
		tablaPR.setRowSorter(ordenarPR);
		tablaPR.setFont(fontPlain);
		tablaPR.getTableHeader().setFont(fontBold);
		tablaPR.setRowHeight(30);
		tablaPR.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		
		// Organiza el ancho de las columnas
		TableColumn columna;
		// La columna de CODIGO:
		columna = tablaPR.getColumnModel().getColumn(0);
		columna.setPreferredWidth(115);
		// La columna de DESCRIPCIÓN:
		columna = tablaPR.getColumnModel().getColumn(1);
		columna.setPreferredWidth(200);
		// La columna de VALOR:
		columna = tablaPR.getColumnModel().getColumn(2);
		columna.setPreferredWidth(95);
		columna.setCellRenderer(rightRenderer);
		// La columna de D (Descontable):
		columna = tablaPR.getColumnModel().getColumn(3);
		columna.setPreferredWidth(73);
		columna.setCellRenderer(centerRenderer);
		// La columna de VENDEDOR:
		columna = tablaPR.getColumnModel().getColumn(4);
		columna.setPreferredWidth(118);
		columna.setCellRenderer(centerRenderer);

		scrollItem.setBounds(05, 260, 620, 300);
		scrollItem.setBorder(null);
		scrollItem.setViewportView(tablaPR);
		scrollItem.setColumnHeaderView(tablaPR.getTableHeader());
		ppMenuPR.add(jmiBorrarPR);
		ppMenuPR.add(jmiConsultaPromos);
		ppMenuPR.add(jmiConsultaInventario);
		ppMenuPR.add(jmiModificarPrecio);
		ppMenuPR.add(jmiModificarCantidad);
		ppMenuPR.add(jmiFichaEamitemr);
		ppMenuPR.add(jmiProductAttrib);
		tablaPR.setComponentPopupMenu(ppMenuPR);

		// Configura la tabla de artículos
		// Un JScrollPane con el JTable dentro.
		// Se crea el JScrollPane, el JTable y se pone la cabecera...
		tablaMP = new JTable(modeloMP);
		ordenarMP = new TableRowSorter<TenderTableModel>(modeloMP);
		tablaMP.setRowSorter(ordenarMP);
		tablaMP.setFont(fontPlain);
		tablaMP.getTableHeader().setFont(fontBold);
		tablaMP.setRowHeight(30);
		rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
		columna = tablaMP.getColumnModel().getColumn(0);
		columna.setPreferredWidth(180);
		columna = tablaMP.getColumnModel().getColumn(1);
//		columna.setPreferredWidth(30);
		columna.setCellRenderer(rightRenderer);
		scrollTender = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollTender.setBounds(635, 260, 370, 300);
		scrollTender.setBorder(null);
		scrollTender.setViewportView(tablaMP);
		scrollTender.setColumnHeaderView(tablaMP.getTableHeader());
		ppMenuMP.add(jmiBorrarMP);
		ppMenuMP.add(jmiSisteCredito);
		tablaMP.setComponentPopupMenu(ppMenuMP);
		
		btnAcercaDe.setBorder(raisedBorder);
		btnAcercaDe.setBounds(1250, 20, 10, 10);

	}  // Fin componerVentana()

	private void adicionarComponentes() {
		//adicionamos los componentes a la ventana
		this.add(lblTiendas);
		this.add(cbTiendas);
		this.add(jpCustomerPanel);
		this.add(jpItemPanel);
		this.add(btnRemision);
		this.add(btnProductList);
		this.add(scrollItem);
		this.add(jpTenderPanel);
		this.add(scrollTender);
		this.add(jpTotalPanel);
//		this.add(bxMensajes);
		this.add(picker);
		this.add(bxHora);
		this.add(lblUser);
		this.add(bxUser);
		this.add(lblVendedor);
		this.add(bxVendedor);
		this.add(btnAcercaDe);
		this.add(btnProcesar);
		this.add(btnLimpiar);
		this.add(btnSimulaCuotaFiao);
		this.add(btnSimulaCuotaMefia);
		this.add(btnImprimir);
		this.add(btnSaveCart);
		this.add(btnSeguros);
		this.add(btnCorreo);
		this.add(btnSalir);
	}

	private void configurarVentana() {
		this.setTitle(Version.getVersion()); // colocamos titulo a la ventana
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/Icono_Flamingo.png")));
//		tamanoPantalla = Toolkit.getDefaultToolkit().getScreenSize(); // Tamaño máximo de la pantalla
//		pantalla = new Rectangle(tamanoPantalla);
		this.setSize(1280, 700);
//		this.setBounds(pantalla); // tamaño de la ventana
		this.setLayout(null); // no usamos ningun layout, solo asi podremos dar posiciones a los componentes
		this.setResizable(true); // hacemos que la ventana sea redimiensionable
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // hacemos que cuando se cierre la ventana termina todo proceso
	}

	private void inicializarComponentes() {
		modeloPR = new ProductosTableModel();
		controlPR= new ProductosTableControl(modeloPR); // Inicializa la tabla de productos
		modeloMP = new TenderTableModel();
		controlMP= new TenderTableControl(modeloMP); // Inicializa la tabla de medios de pago
		kp = new VirtualNumPad(this);
		scs = new SimuladorDeCuotaSafix(this);
		scm = new SimuladorDeCuotaMefia(this);
		ssc = new SimuladorSisteCredito(this);
	    Timer t = new Timer(60000, this);
	    t.start();
	    
		List<Almacen> tiendas = dbServiceImpl.getTiendas(); // Consulta las tiendas en la BD
		if (tiendas.size() < 1) {
			Util.okDialog("Error consultando los almacenes. Cierre y vuelva a abrir la aplicación", (JFrame) this, JOptionPane.ERROR_MESSAGE);
			close();
		}
		String[] stTiendasDisp = new String[tiendas.size()];
		stTiendasList = new Almacen[tiendas.size()];
		
		// Inicia el combo box para los tipos de documento:
		cbxTipoDoc = new JComboBox(arTipoDoc);
		cbxTipoDoc.setSelectedIndex(1);
		
		for (int i = 0; i < tiendas.size(); i++) { // Llena los arreglos de tiendas
			String linea = tiendas.get(i).toString();
			stTiendasDisp[i] = linea;
			stTiendasList[i] = (Almacen) tiendas.get(i);
		}
		bxItemCode = new JTextField();
		bxItemDesc = new JTextField();
		bxItemPrice = new JTextField();
		btnCodCamara = new JButton();
		btnRemision = new JButton();
		btnProductList = new JButton();
		btnAddItem = new JButton();

		/** Pobla el check Box para los medios de pago: */
		List<Tender> tenders = dbServiceImpl.getTenders(); // Trae los MP desde Engage
		String[] stTendersDisp = new String[tenders.size()];
		stTendersList = new Tender[tenders.size()];
		
		for (int i = 0; i < tenders.size(); i++) { // Llena los arreglos de MP
			String linea = tenders.get(i).toString();
			stTendersDisp[i] = linea;
			stTendersList[i] = (Tender) tenders.get(i);
		}
		
		cbTenders = new JComboBox(stTendersDisp);

		bxTenderDesc = new JTextField();
		bxTenderAmnt = new JTextField();
		btnAddTender = new JButton();
		bxCantidadTotal = new JTextField();
		bxTotalBruto = new JTextField();
		bxTotalDescuento = new JTextField();
		bxTotalDecisiones = new JTextField();
		bxSubTotal = new JTextField();
		bxTotalMP = new JTextField();
		bxBalance = new JTextField();
		
		lblTiendas.setBounds(10, 0, 220, 40);
		cbTiendas = new JComboBox(stTiendasDisp);
		cbTiendas.setBounds(145, 10, 290, 30);
		cbTiendas.setFont(fontPlain);
		cbTiendas.setMaximumRowCount(20);
		cbTiendas.setSelectedIndex(Auxiliar.getIndexTienda(usuario, stTiendasList));
		cbTiendas.setPreferredSize(new Dimension(1,75));

		bxCliente = new JTextField();
		
		// Check Box de cliente genérico:
		lblGenerico = new JLabel(txIsGenerico);
		chbGenerico = new JCheckBox();

		btnProcesar = new JButton();
		btnLimpiar = new JButton();
		btnSalir = new JButton();
		btnImprimir = new JButton();
		btnCorreo = new JButton();
		btnAcercaDe = new JButton();
		tablaPR = new JTable(modeloPR);
		ordenarPR = new TableRowSorter<ProductosTableModel>(modeloPR);
		scrollItem = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

	}

	/*
	 *  Agrega un MP a la cesta
	 */
	protected void addTender() {
		String sTenderAmnt = bxTenderAmnt.getText();
		if(!Util.isNumeric(sTenderAmnt)) {
			Util.okDialog("El monto ingresado no es válido", (JFrame) this, JOptionPane.ERROR_MESSAGE);
			bxTenderAmnt.requestFocus();
			return;
		}
		int index = cbTenders.getSelectedIndex();
		String sTenderId = stTendersList[index].getCodigo();
		String sTenderDesc = stTendersList[index].getDescripcion();
		tender = new Tender();
		tender.newTender(sTenderId, sTenderDesc, Util.moneyFormat(sTenderAmnt, 0));
		controlMP.addRow(tender);
		bxTotalMP.setText(Util.sumaFormateados(bxTotalMP.getText(), sTenderAmnt, '+'));
		recalculaBalance();
	}
	
	/*
	 *  Quita un MP de la cesta
	 */
	protected void delTender(ActionEvent e) {
		// si la acción corresponde al borrado de una fila
		JMenuItem menu = (JMenuItem) e.getSource();
		if (menu == jmiBorrarMP) {
			int selectedRow = tablaMP.getSelectedRow();
			String valor = (String) tablaMP.getValueAt(selectedRow, 1);
			controlMP.delRow(selectedRow);
			bxTotalMP.setText(Util.sumaFormateados(bxTotalMP.getText(), valor, '-'));
			bxTotalDescuento.setText("$ 0");
			bxTotalDecisiones.setText("$ 0");
			recalculaBalance();
		}
	}

	/*
	 *  Emulador de cuotas y gestion de sisteCrédito:
	 */
	protected void sisteCredito(ActionEvent e) {
		// si la acción corresponde al borrado de una fila
		JMenuItem menu = (JMenuItem) e.getSource();
		if (menu == jmiSisteCredito) {
			int selectedRow = tablaMP.getSelectedRow();
			Tender tender =  (Tender) modeloMP.getRowTender(selectedRow);
			if (tender.getCodigo().compareTo("5204") == 0) {
				if (blnProcessed)
					simulaSisteCredito(tender);
//					Util.okDialog("Opción no implementada aún", (JFrame) this, JOptionPane.ERROR_MESSAGE);
				else
					Util.okDialog("Primero debe procesar la información ingresada", (JFrame) this, JOptionPane.ERROR_MESSAGE);
			} else {
				Util.okDialog("Esta opción solo es válida para SisteCrétido", (JFrame) this, JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
	}

	/** Busca en EAMITEMR productos sacados de una remisión */ 
	private Producto searchItem(String stItemCode) {
		int index = cbTiendas.getSelectedIndex();
		String stIP = stTiendasList[index].getIP();
		producto = BuscaProducto.getProducto(stItemCode, stIP);
		if (producto == null) {
			Util.okDialog("El código " + stItemCode + " no existe en el POS", (JFrame) this, JOptionPane.ERROR_MESSAGE);
			return null;
		} else {
			// Le adiciona la cédula del vendedor
			producto.setVendedor(usuario.getCedula());
			if(formatter.format(picker.getDate()).compareTo(Util.getDate()) != 0) {
				stCodigoAlmacen = stTiendasList[index].getCodigo();
				String precioFuturo = dbServiceImpl.getPrecioFuturo(stItemCode, formatter2.format(picker.getDate()), stCodigoAlmacen);
				if(precioFuturo != null) {
					precioFuturo = Util.moneyFormat(precioFuturo, 2);
					logCotizador.info("Precio futuro: " + precioFuturo);
					if(precioFuturo.compareTo("$ 0") != 0) {
						bxItemPrice.setText(precioFuturo);
						producto.setItemPrice(precioFuturo);
					}
				}
			}
			return producto;
		}
	}
	
	/** Busca en EAMITEMR productos ingresados manualmente (escáner y teclado) */ 
	private void searchItem() {
		bxItemCode.setText(Util.quitaCheckDigit(bxItemCode.getText()));
		String stItemCode = bxItemCode.getText();
		// valida que el código sea numérico:
		if(Util.isNumeric(stItemCode)) {
			Util.startWaitCursor(this.getRootPane());
			int index = cbTiendas.getSelectedIndex();
			String stIP = stTiendasList[index].getIP();
			stCodigoAlmacen = stTiendasList[index].getCodigo();
			producto = BuscaProducto.getProducto(stItemCode, stIP);
			if (producto == null) {
				Util.okDialog("El código ingresado no existe en el POS", (JFrame) this, JOptionPane.ERROR_MESSAGE);
				bxItemCode.requestFocus();
				Util.stopWaitCursor(this.getRootPane());
				return;
			} else {
				// Le adiciona el la cédula del vendedor
				producto.setVendedor(usuario.getCedula());
				bxItemDesc.setText(producto.getItemDesc());
				bxItemPrice.setText(producto.getItemPrice());
				if(formatter.format(picker.getDate()).compareTo(Util.getDate()) != 0) {
					String precioFuturo = dbServiceImpl.getPrecioFuturo(stItemCode, formatter2.format(picker.getDate()), stCodigoAlmacen);
					if(precioFuturo != null) {
						precioFuturo = Util.moneyFormat(precioFuturo, 2);
						logCotizador.info("Precio futuro: " + precioFuturo);
						if(precioFuturo.compareTo("$ 0") != 0) {
							bxItemPrice.setText(precioFuturo);
							producto.setItemPrice(precioFuturo);
						}
					}
				}
//				bxMensajes.setText("Código Encontrado");
				addItem();
			}
		} else {
			Util.okDialog("El código ingresado no es válido", (JFrame) this, JOptionPane.ERROR_MESSAGE);
			bxItemCode.requestFocus();
			Util.stopWaitCursor(this.getRootPane());
//			bxMensajes.setText("El código ingresado no es válido");
			return;
		}
		Util.stopWaitCursor(this.getRootPane());
	}

	protected void capturarCodigoCamara() {
		final CapturaCodigoCamara ccc = new CapturaCodigoCamara(Ventana.this);
    	SwingUtilities.invokeLater(new Runnable() {
    		public void run() {
    	    	ccc.setLocationRelativeTo(Ventana.this);
    			ccc.setVisible(true);
    			bxItemCode.setText(Util.quitaCheckDigit(ccc.getRespuesta()));
    			searchItem();
    			stPrevItemCode = bxItemCode.getText();
    		}
    	});		
	}

	protected void capturarRemision() {
		kp.setLocationRelativeTo(Ventana.this);
		kp.setVisible(true, "");
		Util.startWaitCursor(this.getRootPane());
		bxItemDesc.setText("Remisión: " + kp.getValue());
		RemisionEN remision = remisionImpl.getRemision(kp.getValue());
		if (remision == null) {
			Util.okDialog("El código ingresado no es válido", (JFrame) this, JOptionPane.ERROR_MESSAGE);
			Util.stopWaitCursor(this.getRootPane());
			return;
		}
		procesaRespuestaRemision(remision);
	}

	private void procesaRespuestaRemision(RemisionEN remision) {
		bxCliente.setText(remision.getCedula());
		bxNombre.setText(remision.getNombre());
		ArticuloRem[] listaArticulos = remision.getListaArticulos();
		// Recorre el arreglo de artículos y los lleva a la tabla
		for (int i = 0; i < listaArticulos.length; i++) {
			ArticuloRem articulo = listaArticulos[i];
			producto = searchItem(Util.quitaCheckDigit(articulo.getEan()));
			if (producto != null) 
				for (int j = 0; j < articulo.getCantidad().intValue(); j++) {
					producto.setItemPrice(articulo.getPrecio().toString());
					addItem();
				}
		}
		
		// Determina si es tipo medio de pago automático
		int tipo = Double.valueOf(remision.getMpAutomatico() / 10000).intValue();
		if ( (tipo == 2) || (tipo == 4) ) {  // es de pago automático
			tender = searchTender(remision);
			controlMP.addRow(tender);
			bxTotalMP.setText(Util.sumaFormateados(bxTotalMP.getText(), tender.getMonto(), '+'));
			recalculaBalance();
			
			if (remision.getDocumentoMp().isEmpty()) // si es pago automático, debe tener nro de documento
				Util.okDialog("Remisión de pago automático pero sin número de tarjeta. Debe informar a Crédito", (JFrame) this, JOptionPane.ERROR_MESSAGE);
		}

		if (tablaPR.getRowCount() > 0)
			isRemision = true;

		Util.stopWaitCursor(this.getRootPane());

	}

	private Tender searchTender(RemisionEN remision) {
		tender = new Tender();
		int index = 0;
		String sTenderId = remision.getMedioPago();
		String valorMax = remision.getValorMax().toString();

		// busca el medio de pago en el arreglo de medios
		for (Tender tender : stTendersList) {
			if (tender.getCodigo().equals(sTenderId))
				break;
			else
				if (tender.getCodigo().equals("MFIA") && sTenderId.compareTo("45") == 0) {
					sTenderId = "MFIA";
					break;
				}
			index++;
		}
		
		String sTenderDesc = "Medio";
		if (stTendersList.length > index) 
			sTenderDesc = stTendersList[index].getDescripcion();
		
		tender.newTender(sTenderId, sTenderDesc, Util.moneyFormat(valorMax, 0));
		
		return tender;
	}

	private Tender searchTenderCarrito(Tender inTender) {
		tender = new Tender();
		int index = 0;
		String sTenderId = inTender.getCodigo();
		String valorMax = inTender.getMonto();

		// busca el medio de pago en el arreglo de medios
		for (Tender tender : stTendersList) {
			if (tender.getCodigo().equals(sTenderId))
				break;
			else
				if (tender.getCodigo().equals("MFIA") && sTenderId.compareTo("45") == 0) {
					sTenderId = "MFIA";
					break;
				}
			index++;
		}
		
		String sTenderDesc = "Medio";
		if (stTendersList.length > index) 
			sTenderDesc = stTendersList[index].getDescripcion();
		
		tender.newTender(sTenderId, sTenderDesc, Util.moneyFormat(valorMax, 0));
		
		return tender;
	}
	
	protected void addItem() {
		controlPR.addRow(producto);
		String txBruto = Util.sumaFormateados(bxTotalBruto.getText(), Util.getTotalItem(producto), '+');
		bxTotalBruto.setText(txBruto);
		bxCantidadTotal.setText(String.valueOf(Integer.parseInt(bxCantidadTotal.getText()) + producto.getQuantity()));
		recalculaBalance();
		bxItemCode.setText("");
		bxItemDesc.setText("");
		bxItemPrice.setText("");
		bxItemCode.grabFocus();
	}

	protected void delItem(ActionEvent e) {
		// si la acción corresponde al borrado de una fila
		JMenuItem menu = (JMenuItem) e.getSource();
		if (menu == jmiBorrarPR) {
			int selectedRow = tablaPR.getSelectedRow();
			String valor = (String) tablaPR.getValueAt(selectedRow, 2);
			int cantidad = (int) tablaPR.getValueAt(selectedRow, 3);
			controlPR.delRow(selectedRow);
			bxCantidadTotal.setText(String.valueOf(Integer.parseInt(bxCantidadTotal.getText()) - producto.getQuantity()));
			bxTotalBruto.setText(Util.sumaFormateados(bxTotalBruto.getText(), Util.getTotalItem(valor, cantidad), '-'));
			bxTotalDescuento.setText("$ 0");
			bxTotalDecisiones.setText("$ 0");
			recalculaBalance();
			logCotizador.info("Se elimina artículo de la lista " + producto.getItemCode());
		}
	}
	
	protected void consultaPromos(ActionEvent e) {
		// si la acción corresponde a consulta de promociones asociadas
		JMenuItem menu = (JMenuItem) e.getSource();
		if (menu == jmiConsultaPromos) {
			if (!Util.tienePermiso(11, usuario)) // Si no tiene permiso segun bit 11 del perfil
				return;
			int index = cbTiendas.getSelectedIndex();
			stCodigoAlmacen = stTiendasList[index].getCodigo();
			int selectedRow = tablaPR.getSelectedRow();
			String producto = (String) tablaPR.getValueAt(selectedRow, 0);
			JTable msg = dbServiceImpl.getPromos(producto, stCodigoAlmacen);
			//define los anchos de las columnas:
			int widths[] = { 500, 380, 190, 190 };
			Util.gridDialog(msg, (JFrame) this, "Promociones asociadas al artículo en la fecha consultada", widths);
		}
	}

	protected void modificarPrecio(ActionEvent e) {
		// si la acción corresponde a modificar el precio del artículo
		JMenuItem menu = (JMenuItem) e.getSource();
		if (menu == jmiModificarPrecio) {
			kp.setLocationRelativeTo(Ventana.this);
			kp.setVisible(true, "");
			String nuevoValor = kp.getValue();
			
			int selectedRow = tablaPR.getSelectedRow();
			int cantidad = (int) tablaPR.getValueAt(selectedRow, 3);
		
			String valor = (String) tablaPR.getValueAt(selectedRow, 2);
			tablaPR.setValueAt( Util.moneyFormat(nuevoValor, 0), selectedRow, 2);
			// Resta valor * cantidad anterior:
			bxTotalBruto.setText(Util.sumaFormateados(bxTotalBruto.getText(), Util.getTotalItem(valor, cantidad), '-'));

			// Suma valor * cantidad nuevos:
			bxTotalBruto.setText(Util.sumaFormateados(bxTotalBruto.getText(), Util.getTotalItem(nuevoValor, cantidad), '+'));
			bxTotalDescuento.setText("$ 0");
			bxTotalDecisiones.setText("$ 0");
			logCotizador.info("Se cambia precio de artículo de " + valor + " a " + nuevoValor);
			recalculaBalance();
		}
	}
	
	protected void modificarCantidad(ActionEvent e) {
		// si la acción corresponde a modificar el precio del artículo
		JMenuItem menu = (JMenuItem) e.getSource();
		if (menu == jmiModificarCantidad) {
			kp.setLocationRelativeTo(Ventana.this);
			kp.setVisible(true, "");
			int newQty = kp.getIntegerValue();
			if (newQty > 99) {
				Util.okDialog("99 es la cantidad máxima", (JFrame) this, JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			int selectedRow = tablaPR.getSelectedRow();
			int cantidad = (int) tablaPR.getValueAt(selectedRow, 3);
			String valor = (String) tablaPR.getValueAt(selectedRow, 2);
			tablaPR.setValueAt( newQty, selectedRow, 3);
			// Resta valor * cantidad anterior:
			bxTotalBruto.setText(Util.sumaFormateados(bxTotalBruto.getText(), Util.getTotalItem(valor, cantidad), '-'));
			bxCantidadTotal.setText(String.valueOf(Integer.parseInt(bxCantidadTotal.getText()) - cantidad));
			
			// Suma valor * cantidad nuevos:
			bxTotalBruto.setText(Util.sumaFormateados(bxTotalBruto.getText(), Util.getTotalItem(valor, newQty), '+'));
			bxCantidadTotal.setText(String.valueOf(Integer.parseInt(bxCantidadTotal.getText()) + newQty));
			bxTotalDescuento.setText("$ 0");
			bxTotalDecisiones.setText("$ 0");
			recalculaBalance();
		}
	}	
	private void fichaEamitemr(ActionEvent e) {
		// si la acción corresponde a ver la ficha del producto en el Eamitemr
		JMenuItem menu = (JMenuItem) e.getSource();
		if (menu == jmiFichaEamitemr) {
			if (!Util.tienePermiso(11, usuario)) // Si no tiene permiso segun bit 11 del perfil
				return;
			int index = cbTiendas.getSelectedIndex();
			stCodigoAlmacen = stTiendasList[index].getCodigo();
			String stIP = stTiendasList[index].getIP();
			int selectedRow = tablaPR.getSelectedRow();
			String stItemCode = (String) tablaPR.getValueAt(selectedRow, 0);
			producto = BuscaProducto.getProducto(stItemCode, stIP);
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						VisorItemRecord vir = new VisorItemRecord(new JFrame(), producto);
						vir.setVisible(true);
					} catch (Exception e) {
						logCotizador.error("Error mostrando ficha del artículo");
					}
				}
			});
		}
		
	}
	
	private void productAttrib(ActionEvent e) {
		// si la acción corresponde a ver atributos del artículo
		JMenuItem menu = (JMenuItem) e.getSource();
		if (menu == jmiProductAttrib) {
			if (!Util.tienePermiso(11, usuario)) // Si no tiene permiso segun bit 11 del perfil
				return;
			int selectedRow = tablaPR.getSelectedRow();
			String stItemCode = (String) tablaPR.getValueAt(selectedRow, 0);
			JTable msg = dbServiceImpl.getProductAttrib(stItemCode);
			// define los anchos del as columnas:
			int widths[] = {300, 600};
			Util.gridDialog(msg, (JFrame) this, "Atributos del artículo", widths);
		}
		
	}

	protected void consultaHistorialCliente(ActionEvent e) {
	// Si la acción corresponde a consulta de historial del cliente
		JMenuItem menu = (JMenuItem) e.getSource();
		if (menu == jmiConsultaHistorial && bxCliente.getText().compareTo(GENERICO) != 0) {
			if (!Util.tienePermiso(7, usuario)) // Si no tiene permiso segun bit 7 del perfil
				return;
			JTable msg = dbServiceImpl.getHistoriaCliente(bxCliente.getText());
			// define los anchos del as columnas:
			int widths[] = {300, 210, 210, 250};
			Util.gridDialog(msg, (JFrame) this, "Promociones obtenidas por el cliente", widths);
		}
	}

	protected void consultaResumenBeneficios(ActionEvent e) {
	// Si la acción corresponde a consulta de historial del cliente
		JMenuItem menu = (JMenuItem) e.getSource();
		if (menu == jmiResumenBeneficios && bxCliente.getText().compareTo(GENERICO) != 0) {
			if (!Util.tienePermiso(7, usuario)) // Si no tiene permiso segun bit 7 del perfil
				return;
			JTable msg = dbServiceImpl.getResumenCliente(bxCliente.getText());
			// define los anchos del as columnas:
			int widths[] = {80, 60, 200};
			Util.gridDialog(msg, (JFrame) this, "Promociones obtenidas por el cliente", widths);
		}
	}

	protected void referenciasCliente(ActionEvent e) {
		// Si la acción corresponde a consulta de referencias del cliente
		JMenuItem menu = (JMenuItem) e.getSource();
		if (menu == jmiReferenciasCliente && bxCliente.getText().compareTo(GENERICO) != 0) {
			if (!Util.tienePermiso(9, usuario))  // Verifica el permiso segun Bit 9 del perfil
				return;
			JTable msg = dbServiceImpl.getReferenciasCliente(bxCliente.getText());
			// define los anchos del as columnas:
			int widths[] = {300, 150, 300};
			Util.gridDialog(msg, (JFrame) this, "Referencias solicitadas para el cliente", widths);
		}
	}
	
	protected void segmentosClienteMotor(ActionEvent e) {
		// Si la acción corresponde a consulta de referencias del cliente
		JMenuItem menu = (JMenuItem) e.getSource();
		if (menu == jmiSegmentosClienteMotor && bxCliente.getText().compareTo(GENERICO) != 0) {
			JTable msg = dbServiceImpl.getSegmentosClienteMotor(bxCliente.getText());
			// define los anchos del as columnas:
			int widths[] = {600};
			Util.gridDialog(msg, (JFrame) this, "Promociones por segmentos en las que está el cliente:", widths);
		}
	}

	protected void autoGestionDelCredito(ActionEvent e) {
		// Si la acción corresponde a consulta de referencias del cliente
		JMenuItem menu = (JMenuItem) e.getSource();
		if (menu == jmiVentaAsistidaCredito && bxCliente.getText().compareTo(GENERICO) != 0) {
			if (!Util.tienePermiso(10, usuario))  // Verifica el permiso segun Bit 10 del perfil
				return;
			try {
				Properties properties = Util.getProperties();
				int index = cbTiendas.getSelectedIndex();
				stCodigoAlmacen = stTiendasList[index].getCodigo();
				URI uri = new URI(properties.getProperty("VTAASISTIDALink"));
				Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
				desktop.browse(uri);
			} catch (Exception x) {
				logCotizador.error("Error invocando página de Auto gestión del crédito");
			}
		}
	}
	
	protected void consultaCuposCredito(ActionEvent e) {
		// Si la acción corresponde a consulta de cupos disponibles
		JMenuItem menu = (JMenuItem) e.getSource();
		if (menu == jmiConsultaCuposWeb && bxCliente.getText().compareTo(GENERICO) != 0) {
			if (!Util.tienePermiso(7, usuario))  // Verifica el permiso segun Bit 7 del perfil
				return;
			try {
				Properties properties = Util.getProperties();
//				URI uri = new URI(properties.getProperty("VTAASISTIDALink"));
				URI uri = new URI(properties.getProperty("CONSULTACUPOLink"));
				Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
				desktop.browse(uri);
			} catch (Exception x) {
				logCotizador.error("Error invocando página de consulta de saldos de crédito");
				x.printStackTrace();
				Util.okDialog("Error invocando página de consulta de saldos de crédito", (JFrame) this, JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}

//	protected void consultaCuposLocal(ActionEvent e) {
//		// Si la acción corresponde a consulta de cupos disponibles
//		
//		JMenuItem menu = (JMenuItem) e.getSource();
//		if (menu == jmiConsultaCuposLoc && bxCliente.getText().compareTo(GENERICO) != 0) {
//			if (!Util.tienePermiso(7, usuario))  // Verifica el permiso segun Bit 7 del perfil
//				return;
//			try {
//				Properties properties = Util.getProperties();
//				URI uri = new URI(properties.getProperty("CONSULTACUPOLink"));
//				Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
//				desktop.browse(uri);
//			} catch (Exception x) {
//				logCotizador.error("Error invocando página de consulta de saldos de crédito");
//				x.printStackTrace();
//				Util.okDialog("Error invocando página de consulta de saldos de crédito", (JFrame) this, JOptionPane.ERROR_MESSAGE);
//			}
//		}
//		
//	}

	protected void vista360Cliente(ActionEvent e) {
		// Si la acción corresponde a consulta de referencias del cliente
		JMenuItem menu = (JMenuItem) e.getSource();
		if (menu == jmiVista360Cliente && bxCliente.getText().compareTo(GENERICO) != 0) {
			if (!Util.tienePermiso(5, usuario))  // Verifica el permiso segun Bit 5 del perfil
				return;
			JTable msg = dbServiceImpl.getVista360Cliente(bxCliente.getText());
			if (msg.getRowCount() < 1) {
				Util.okDialog("No se obtuvo información del cliente", (JFrame) this, JOptionPane.ERROR_MESSAGE);
				return;
			}
			String s;
//			// Octubre 26 de 2021: Adiciona el cupo de mefía
//			s = Util.moneyFormat(Integer.toString(clienteSicaf.getCupoMefia()), 0);
//			msg = Auxiliar.adicionarFila(msg, "CUPO MEFIA (+ Extracupo)", s);
			// Julio 02 de 2021: Operaciones solicita agregar campos:
			s = clienteSicaf.getDocumentacionImpresa().compareTo("S") == 0 ? "Si" : "No";
			msg = Auxiliar.adicionarFila(msg, "¿TIENE DOCUMENTACIÓN IMPRESA?", s);
			s = clienteSicaf.getDocumentosCustodia().compareTo("S") == 0 ? "Si" : "No";
			msg = Auxiliar.adicionarFila(msg, "¿TIENE DOCUMENTOS EN CUSTODIA?", s);
			// adiciona estado del NUG
			s = clienteSicaf.getNug() == null ? "No" : "Si";
			msg = Auxiliar.adicionarFila(msg, "¿TIENE NUG?", s);
//			// Octubre 26 de 2021: Adiciona el cupo del NUG
//			s = Util.moneyFormat(Integer.toString(clienteSicaf.getClienteCupo()), 0);
//			msg = Auxiliar.adicionarFila(msg, "CUPO NUG", s);
			
			// define los anchos del as columnas:
			int widths[] = {350, 300};
			Util.gridDialog(msg, (JFrame) this, "Actividad del cliente con Flamingo", widths);
		}
	}

	protected void consultaInventario(ActionEvent e) {
		// si la acción corresponde a consulta de inventario
		JMenuItem menu = (JMenuItem) e.getSource();
		if (menu == jmiConsultaInventario) {
			if (!Util.tienePermiso(13, usuario)) // Si no tiene permiso segun bit 13 del perfil
				return;
			int index = cbTiendas.getSelectedIndex();
			stCodigoAlmacen = stTiendasList[index].getCodigo();
			int selectedRow = tablaPR.getSelectedRow();
			String producto = (String) tablaPR.getValueAt(selectedRow, 0);
			JTable msg = dbServiceImpl.getInventario(producto, stCodigoAlmacen);
			//define los anchos de las columnas:
			int widths[] = { 300, 250 };
			Util.gridDialog(msg, (JFrame) this, "Inventario del artículo en los diferentes almacenes", widths);
		}
	}

	private void recalculaBalance() {
		String sBalance = Util.sumaFormateados(bxTotalBruto.getText(), bxTotalMP.getText(), '-');
		sBalance  = Util.sumaFormateados(sBalance, bxTotalDescuento.getText(), '-');
		sBalance  = Util.sumaFormateados(sBalance, bxTotalDecisiones.getText(), '-');
//		bxCantidadTotal.setText("" + modeloPR.getRowCount());
		bxBalance.setText(sBalance);
		String sSubTotal = Util.sumaFormateados(bxTotalBruto.getText(), bxTotalDescuento.getText(), '-');
		sSubTotal = Util.sumaFormateados(sSubTotal, bxTotalDecisiones.getText(), '-');
		bxSubTotal.setText(sSubTotal);
		btnImprimir.setVisible(false);
		btnSimulaCuotaFiao.setVisible(false);
		btnSimulaCuotaMefia.setVisible(false);
		btnSaveCart.setVisible(false);
		btnCorreo.setVisible(false);
		blnPrinted = false;
		blnProcessed = false;
		blnCarSaved = false;
		jpTotalPanel.invalidate();
		jpTotalPanel.validate();
		jpTotalPanel.repaint();
	}

	protected void checkingGenerico(ActionEvent event) {
		JCheckBox chb = (JCheckBox) event.getSource();
		if( (tablaPR.getRowCount() > 0) && (blnProcessed) ) {
			Object[] options = { "Si, cambiar cliente", "No, Mantener cliente" };
			String msg = "El cambio de cliente implica reprocesar la información. ¿Desea cambiar de cliente?";
			int h = Util.sigaPareMessage(msg, new JDialog(), JOptionPane.QUESTION_MESSAGE, options);
			if (h == 0) {
				if (chb.isSelected()) {
					activateGenerico();
				} else {
					deactivateGenerico();
				}
				logCotizador.info("Se hizo cambio de cliente de " + sPrevCliente + " a " + bxCliente.getText());
				sPrevCliente = bxCliente.getText();
				bCustomerChanged = true;
				procesar();
			} else {
				bxCliente.setText(sPrevCliente);
				chbGenerico.setSelected(!chb.isSelected());
			}
			
		} else {
			if (chb.isSelected()) {
				activateGenerico();
			} else {
				deactivateGenerico();
			}
		}
	}

	public void actionPerformed(ActionEvent e) {
		txFecha = Util.getDate();
		bxHora.setText(Util.getTime());
	}
	
	public void initCanopusContingency() {
		try {
			connectEngage("172.16.8.205");
		} catch (Exception e) {
			
		}
	}
	
	public void initCanopus() {
		logCotizador.info("Iniciando Canopus...");
		int index = cbTiendas.getSelectedIndex();
		stCodigoAlmacen = stTiendasList[index].getCodigo();
		sTomcatServer = stTiendasList[index].getTomcatServer();
		logCotizador.info("Canopus iniciado correctamente");
		try {
			connectEngage(sTomcatServer);
		} catch (Exception e) {
			
		}
	}
	
	private void connectEngage(String sTomcatServer) throws Exception {
		try {
		canopus = new Core(sTomcatServer);
		} catch (Exception e) {
			Util.stopWaitCursor(this.getRootPane());
			Util.okDialog("Error consultando al Motor de promociones", (JFrame) this, JOptionPane.ERROR_MESSAGE);
			logCotizador.error("Error consultando al Motor de promociones");
			return;
		}
	}

	private void consultaClienteMotor() {
		String nroDoc = bxCliente.getText();
        String fDate = formatter.format(picker.getDate());
		if (canopus == null)
			initCanopus();
		String sTramaReqCanopus = TransformadorTrama2Canopus.transformCliente(bxUser.getText(), nroDoc, Util.zeroPad(stCodigoAlmacen, 5), fDate, bxHora.getText());
		String sResponse = null;
		logCotizador.info("Inicia consulta del cliente en el motor. " + nroDoc);
		// Lanza la consulta del cliente al motor de promociones
		sResponse = canopus.getCustomer(sTramaReqCanopus);

		if(sResponse != null) {
			cliente = TransformadorTrama2Canopus.canopusResponse2Cliente(sResponse);
			if ( (cliente.getFirstName().isEmpty()) || (chbGenerico.isSelected()) )
				cliente = TransformadorTrama2Canopus.getClienteGenerico();
			cliente.setPAN(nroDoc);
		} 

		if (cliente != null) {
//			bxNombre.setText(cliente.getFirstName() + " " + cliente.getLastName());
			logCotizador.info("Cliente encontrado: " + cliente.getFirstName() + " " + cliente.getLastName());
		} 
	}

	private String consultaDescuentoMotor() {
        String fDate = formatter.format(picker.getDate());
		String nroDoc = bxCliente.getText();
		if (canopus == null)
			initCanopus();
		String sTramaReqCanopus = null;
		String sResponse = "$ 0";
		sTramaReqCanopus = TransformadorTrama2Canopus.transformProductosMedios(modeloPR, modeloMP, bxUser.getText(), nroDoc, Util.zeroPad(stCodigoAlmacen, 5), fDate, bxHora.getText());
		logCotizador.info("sRequest: " + sTramaReqCanopus);
		logCotizador.info("Inicia consulta de artículos al motor");
		try {
			sResponse = canopus.getRewards(sTramaReqCanopus);
			logCotizador.info("sResponse: " + sResponse);
			return sResponse;
		} catch (Exception e) {
			return null;
		}
	}

	private String consultarMotorDecisiones() {
		// TODO Auto-generated method stub
		String nroDoc = bxCliente.getText();
		String sTramaReqMotorDecisiones = null;
		String sResponse = "$ 0";
		sTramaReqMotorDecisiones = TransformadorTrama2MotorDecisiones.transformRequest(modeloPR, modeloMP, nroDoc, Util.zeroPad(stCodigoAlmacen, 5));
		logCotizador.info("sRequest: " + sTramaReqMotorDecisiones);
		logCotizador.info("Inicia consulta al motor de decisiones");
		try {
			Operador operadorMotorDecisiones = new Operador();
			sResponse = operadorMotorDecisiones.ejecutar(sTramaReqMotorDecisiones);
			logCotizador.info("sResponse: " + sResponse);
			return sResponse;
		} catch (Exception e) {
			return null;
		}
		
	}

	/**
	 * Función procesar()
	 * Se encarga de consultar el cliente, los productos, los medios de pago y actualiza los valores en la pantalla
	 */
	private void procesar() {
		if(modeloPR.getRowCount() < 1) {
			Util.okDialog("Debe incluir al menos un producto", (JFrame) this, JOptionPane.ERROR_MESSAGE);
			logCotizador.info("Debe incluir al menos un producto");
			return;
		}

		//Se blanquean los descuentos para traer los nuevos:
		bxTotalDescuento.setText("$ 0");
		bxTotalDecisiones.setText("$ 0");
		
		// Coloca el cursor en forma de espera
		Util.startWaitCursor(this.getRootPane());

		// Organiza la lista de artículos para enviar enviar al motor:
		if(tablaPR.getRowCount() > 0) {
			String sResponse = consultaDescuentoMotor();
			
			if(sResponse == null) {
				// Se prueba contra el central
				initCanopusContingency();
				sResponse = consultaDescuentoMotor();
				if(sResponse == null) {
					Util.stopWaitCursor(this.getRootPane());
					Util.okDialog("Error conectando con el Motor de promociones. Intente más tarde", (JFrame) this, JOptionPane.ERROR_MESSAGE);
					logCotizador.error("Error  conectando con el Motor de promociones");
					return;
				}
			}
			bxTotalDescuento.setText(Util.moneyFormat(sResponse, 0));
			logCotizador.info("Detalle de descuentos: "  + canopus.getDetalleDescuentos() );
			String sResponseMotorDecisiones = consultarMotorDecisiones();
			logCotizador.info("Respuesta Motor deciciones: " + sResponseMotorDecisiones);
			if (sResponseMotorDecisiones == null)
				sResponseMotorDecisiones = "0";
			bxTotalDecisiones.setText(Util.moneyFormat(sResponseMotorDecisiones, 0));
			recalculaBalance();
		}
		Util.stopWaitCursor(this.getRootPane());
		if (bxTotalDescuento.getText().compareTo("$ 0") == 0)
			Util.okDialog("Los demás sistemas no otorgaron otros descuentos", (JFrame) this, JOptionPane.INFORMATION_MESSAGE);
		if (bxTotalDecisiones.getText().compareTo("$ 0") == 0)
			Util.okDialog("Los demás sistemas no otorgaron otros descuentos", (JFrame) this, JOptionPane.INFORMATION_MESSAGE);
		blnProcessed = true;
		btnImprimir.setVisible(true);
		btnSimulaCuotaFiao.setVisible(true);
		btnSimulaCuotaMefia.setVisible(true);
		btnSaveCart.setVisible(true);
		btnCorreo.setVisible(true);
	}  // fin procesar()

	
	// Método para cerrar la ventana
	public void close() {
		Util.stopWaitCursor(this.getRootPane());
		this.setVisible(false);
		super.dispose();
	}

	// Método para limpiar la ventana
	protected void clean() {

		// Inicializa lista
		controlPR.clear();
		controlMP.clear();
		bxNombre.setText("");
		activateGenerico();
		bxCliente.requestFocus(); // El box para ingresar el dato debe estar activo
		bxItemCode.setText("");
		bxItemDesc.setText("");
		bxItemPrice.setText("");
		bxTenderAmnt.setText("");
		bxCantidadTotal.setText("0");
		bxTotalBruto.setText("$ 0");
		bxTotalDecisiones.setText("$ 0");
		bxTotalDescuento.setText("$ 0");
		bxTotalMP.setText("$ 0");
		bxBalance.setText("$ 0");
		bxSubTotal.setText("$ 0");
		isRemision = false;
		isClienteNuevo = false;
		sCarritoRecuperado = "";
		btnImprimir.setVisible(false);
		btnSimulaCuotaFiao.setVisible(false);
		btnSimulaCuotaMefia.setVisible(false);
		btnSaveCart.setVisible(false);
		btnCorreo.setVisible(false);
		picker.setDate(Calendar.getInstance().getTime());
		cotizacion = null;
		logCotizador.info("Se hizo limpieza de pantalla");
	}

	private void activateGenerico() {
		chbGenerico.setSelected(true);
		bxNombre.setText("Cliente Genérico");
		bxCliente.setText(GENERICO);
		bxCliente.setEnabled(false);
		clienteSicaf = new ClienteSicaf(GENERICO, "CC", "ESTIMADO CLIENTE", 0, null);
		logCotizador.info("Se activó cliente genérico");
	}

	private void deactivateGenerico() {
		chbGenerico.setSelected(false);
		bxNombre.setText("");
		bxCliente.setText("");
//		bxCliente.setEnabled(true);
		bxCliente.requestFocus(); // El box para ingresar el dato debe estar activo
		kp.setLocationRelativeTo(Ventana.this);
		kp.setVisible(true);
		bxCliente.setText(kp.getValue());
		logCotizador.info("Se cambia de cliente genérico a: " + bxCliente.getText());
		existeCliente();
		new Thread(new Runnable() {
		    public void run() {
				consultaClienteMotor();
		    }
		}).start();
		restCart();
	}

	private void restCart() {
		String fDate = formatter.format(picker.getDate());
		int index = cbTiendas.getSelectedIndex();
		cotizacion = Auxiliar.getCotizacionCliente(bxCliente.getText(), fDate.replaceAll("/", ""), stTiendasList[index].getCodigo());
		if(cotizacion != null) {
			logCotizador.info("El cliente tiene una cotización iniciada que se recupera. Cliente: " + bxCliente.getText());
			Object[] options = { "Si, recuperar cotización guardada", "No, iniciar nueva cotización" };
			String msg = "Se ha encontrado una cotización guardada para " + bxCliente.getText() + ". ¿Desea continuar con esta cotización?";
			int h = Util.sigaPareMessage(msg, new JDialog(), JOptionPane.QUESTION_MESSAGE, options);
			if (h == 0) {
				ProductosTableModel newModeloPR = cotizacion.getModeloPR();
				for (int i = 0; i < newModeloPR.getRowCount(); i++) {
					producto = (Producto) newModeloPR.getRowProduct(i);
					addItem();
				}
				TenderTableModel newModeloMP = cotizacion.getModeloMP();
				if (newModeloMP != null) {
					for (int i = 0; i < newModeloMP.getRowCount(); i++) {
						tender = searchTenderCarrito(newModeloMP.getRowTender(i));
						controlMP.addRow(tender);
						bxTotalMP.setText(Util.sumaFormateados(bxTotalMP.getText(), tender.getMonto(), '+'));
						recalculaBalance();
					}
				}
				sCarritoRecuperado = cotizacion.getCotizacionID();
				sClienteRecuperado = cotizacion.getCliente().getClienteID();
				blnCarSaved = true;
				logCotizador.info("El asesor opta por recuperar el carrito guardado para el cliente");
			} else {
				dbServiceImpl.closeCotizacion(cotizacion.getCotizacionID());
				cotizacion = null;
				logCotizador.info("El asesor opta por no recuperar el carrito guardado para el cliente y este es cerrado");
			}
		} else {
			logCotizador.info("El cliente no tiene cotizaciones, se inicia una nueva. Cliente: " + bxCliente.getText());
		}
		
	}

	private void existeCliente() {
		int indice = cbxTipoDoc.getSelectedIndex();
		sPrevCliente = bxCliente.getText();
		String tipoDoc = arTipoDoc[indice];
		clienteSicaf = dbServiceImpl.getClienteSicaf(tipoDoc, bxCliente.getText());
		if(clienteSicaf.getClienteName() == null) {
			logCotizador.info("Cliente no encontrado en Sicaf: " + bxCliente.getText());
			clienteSicaf.setClienteName("ESTIMADO CLIENTE");
			// Valida perfil bit 3 con permiso de captura de clientes
			if (Util.tienePermiso(3, usuario)) {
				// Las siguientes líneas se comentan mientras no se utilice la tablet como medio de captura de clientes
				logCotizador.info("Cliente " + bxCliente.getText() + ", se procede a solicitar datos");
				int index = cbTiendas.getSelectedIndex();
				stCodigoAlmacen = stTiendasList[index].getCodigo();

				Object[] options = { "Cliente acepta", "Cliente rechaza" };
				String msg = "El cliente es nuevo. ¿Desea capturar los datos?";
				int h = Util.sigaPareMessage(msg, new JDialog(), JOptionPane.QUESTION_MESSAGE, options);
				if (h == 0) {
					isClienteNuevo =true;
					final CapturaDatosCliente dc = new CapturaDatosCliente(new JFrame());
					SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							dc.setLocationRelativeTo(Ventana.this);
							dc.setVisible(true, bxCliente.getText(), stCodigoAlmacen, usuario);
						}
					});
				} else {
					bxNombre.setText("ESTIMADO CLIENTE");
				}
				// Fin comentariar líneas
			}

		} else {
			String mefiaInfo = dbServiceImpl.getDisponibleMefia(clienteSicaf.getClienteID());
			clienteSicaf.setCreditosMefia(Integer.parseInt(mefiaInfo.substring(0, mefiaInfo.indexOf('|'))));
//			clienteSicaf.setCupoMefia(Integer.parseInt(mefiaInfo.substring(mefiaInfo.indexOf('|') + 1, mefiaInfo.length())));
		}
		bxNombre.setText(clienteSicaf.getClienteName());
	}

	protected void pegarListaArticulos() {
		List<String> productList = Util.getProductosFromClipboard();
		for (int i = 0; i < productList.size(); i++) {
			String linea = productList.get(i).toString();
			producto = searchItem(Util.quitaCheckDigit(linea));
			if (producto != null) {
				// Le adiciona el la cédula del vendedor
				producto.setVendedor(usuario.getCedula());
				addItem();
			}
		}
	}

	@Override
	public void setVisible(boolean b) {
		if (b) {
			bxCliente.requestFocus();
		}
		super.setVisible(b);
	}
	
    DocumentListener documentListener = new DocumentListener() {
        public void changedUpdate(DocumentEvent documentEvent) {
    		insertUpdate(documentEvent);
        }
        public void insertUpdate(DocumentEvent documentEvent) {
        	logCotizador.info("Cambió el código: " + bxItemCode.getText());
        }
        public void removeUpdate(DocumentEvent documentEvent) {
    		insertUpdate(documentEvent);
        }
    };	

    FocusListener focusListenerPR= new FocusListener() {
		public void focusGained(FocusEvent e) {
			stPrevItemCode = bxItemCode.getText();
		}
		public void focusLost(FocusEvent e) {
			if (!e.isTemporary() && isEnabled()) {
				if (stPrevItemCode.compareTo(bxItemCode.getText()) != 0) {
					searchItem();
					stPrevItemCode = bxItemCode.getText();
				}
			}
		}
	};

    FocusListener focusListenerProductPrice= new FocusListener() {
		public void focusGained(FocusEvent e) {
		}
		public void focusLost(FocusEvent e) {
			if (!e.isTemporary() && isEnabled()) {
				 producto.setItemPrice(bxItemPrice.getText());
			}
		}
	};

	protected void bxClienteClic() {
		if (bxCliente.getText().compareTo(GENERICO) == 0) {
			chbGenerico.setSelected(false);
		} else 
			sClientePrev = bxCliente.getText();
		kp.setLocationRelativeTo(Ventana.this);
		kp.setVisible(true, bxCliente.getText());
		bxCliente.setText(kp.getValue());
		if (bxCliente.getText().compareTo(sClientePrev) != 0) {
			logCotizador.info("Cliente cambió de :" + sClientePrev + " a :" + bxCliente.getText());
			
			// Se pide guardar carrito siempre que detecte cambio de cliente
			Object[] options = { "Si, guardar carrito de compra", "No, descartar carrito de compra" };
			String msg = "Cambio de cliente con carrito activo para " + sClientePrev + ". ¿Desea guardar carrito de compra antes de continuar?";
			int h = Util.sigaPareMessage(msg, new JDialog(), JOptionPane.QUESTION_MESSAGE, options);
			if (h == 0) {
				saveCart();
			}
			
//			// Se pregunta por limpiar pantalla por el cambio de cliente
//			msg = "¿Desea limpiar carrito de compra antes de continuar?";
//			Object[] options2 = { "Si, limpiar carrito de compra", "No, conservar carrito de compra" };
//			h = Util.sigaPareMessage(msg, new JDialog(), JOptionPane.QUESTION_MESSAGE, options2);
//			if (h == 0) {
//				clean();
//				bxCliente.setText(kp.getValue());
//			}

			clean();
			bxCliente.setText(kp.getValue());
			existeCliente();
			restCart();
		}
	}

	protected void bxItemClic() {
		kp.setLocationRelativeTo(Ventana.this);
		kp.setVisible(true, "");
		bxItemCode.setText(kp.getValue());
		searchItem();
		stPrevItemCode = bxItemCode.getText();
	}

	protected void bxTenderClic() {
		kp.setLocationRelativeTo(Ventana.this);
		kp.setVisible(true, "");
		bxTenderAmnt.setText(kp.getValue());
	}

	protected void simulaCuotaFiao() {
		if (!Util.tienePermiso(17, usuario)) // Si no tiene permiso segun bit 17 del perfil
			return;
		if(bxSubTotal.getText().compareTo("$ 0") != 0) {
			fillCotizacion();
	    	SwingUtilities.invokeLater(new Runnable() {
	    		public void run() {
	    	    	scs.setLocationRelativeTo(Ventana.this);
	    			scs.setVisible(true, cotizacion, usuario);
	    			if(scs.isBlnCreditoGenerado())
	    				clean();
	    			if(scs.isBlnPrinted()) {
	    				cotizacion.setCuotaSafix(scs.getBxCuotaSafix());
	    				cotizacion.setMeses(scs.getNroMeses());
	    				saveCart();
	    			}
	    		}
	    	});
		} else
			Util.okDialog("Debe agregar al menos un artículo a la cesta", (JFrame) this, JOptionPane.ERROR_MESSAGE);
	}

	protected void simulaCuotaMefia() {
		if (!Util.tienePermiso(17, usuario)) // Si no tiene permiso segun bit 17 del perfil
			return;
		if(bxSubTotal.getText().compareTo("$ 0") != 0) {
			fillCotizacion();
	    	SwingUtilities.invokeLater(new Runnable() {
	    		public void run() {
	    	    	scm.setLocationRelativeTo(Ventana.this);
	    			scm.setVisible(true, cotizacion, usuario);
	    			if(scs.isBlnPrinted()) {
	    				saveCart();
	    			}
	    		}
	    	});
		} else
			Util.okDialog("Debe agregar al menos un artículo a la cesta", (JFrame) this, JOptionPane.ERROR_MESSAGE);
	}
	
	protected void simulaSisteCredito(Tender tenderSC) {
		String sValor_aux = tenderSC.getMonto();
		if ((Util.ComparaFormateados(tenderSC.getMonto(), bxSubTotal.getText())) > 0) 
			sValor_aux = bxSubTotal.getText();
		final String sValor = sValor_aux; 
			
		
		if (!Util.tienePermiso(17, usuario)) // Si no tiene permiso segun bit 17 del perfil
			return;
		if(bxSubTotal.getText().compareTo("$ 0") != 0) {
			fillCotizacion();
			SisteCreditoServiceImplementation sCreditoImpl = new SisteCreditoServiceImplementation();
			Util.startWaitCursor(this.getRootPane());
			final ClienteSisteCredito clienteSisteCredito = sCreditoImpl.validaClienteSisteCredito(cotizacion.getCliente().getClienteID(), cotizacion.getTienda().getUserData1());
			Util.stopWaitCursor(this.getRootPane());
			if(clienteSisteCredito == null) {
				String msg = "No es cliente SisteCrédito o hubo error en la consulta. ¿Desea continuar con la similación?";
				Object[] options = { "Si, simular cuota", "No, cancelar operación" };
				int h = Util.sigaPareMessage(msg, new JDialog(), JOptionPane.QUESTION_MESSAGE, options);
				if (h == 1) {
					return;
				}
			}
	    	SwingUtilities.invokeLater(new Runnable() {
	    		public void run() {
	    	    	ssc.setLocationRelativeTo(Ventana.this);
	    	    	ssc.setValor(sValor);
	    	    	ssc.setVisible(true, cotizacion, clienteSisteCredito, usuario);
	    			if(ssc.isBlnPrinted()) {
	    				saveCart();
	    			}
	    		}
	    	});
		} else
			Util.okDialog("Debe agregar al menos un artículo a la cesta", (JFrame) this, JOptionPane.ERROR_MESSAGE);
	}

    private void fillCotizacion() {
		int index = cbTiendas.getSelectedIndex();
		String cotizID = sCarritoRecuperado;
		if(cotizacion != null)
			cotizID = cotizacion.getCotizacionID();
    	cotizacion = new Cotizacion(
    			clienteSicaf,
    			stTiendasList[index],
    			formatter.format(picker.getDate()),
    			bxSubTotal.getText(),
    			bxTotalDescuento.getText(),
    			"0",
    			"0",
    			"0",
    			null,
    			null,
    			isClienteNuevo,
    			modeloMP,
    			modeloPR,
    			cotizID,
    			bxTotalDecisiones.getText());
    	logCotizador.info("Se hizo llenado de la cotización " + cotizID);
	}

	protected void cambioFecha() {
		if( (dtPrevDate.compareTo(picker.getDate()) != 0) && (tablaPR.getRowCount() > 0) ) {
			if (!isRemision) { // Si es una remisión, no tiene sentido cambiar los precios
				if (blnProcessed) {
					Object[] options = { "Si, cambiar fecha", "No, Mantener fecha" };
					String msg = "El cambio de fecha implica reprocesar la información ¿Desea cambiar la fecha?";
					int h = Util.sigaPareMessage(msg, new JDialog(), JOptionPane.QUESTION_MESSAGE, options);
					if (h == 0) {
						procesar();
						dtPrevDate = picker.getDate();
					} else {
						picker.setDate(dtPrevDate);
					}
				}
			}
		}
	}

	KeyListener keyListener = new KeyListener() {
        public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				if (stPrevItemCode.compareTo(bxItemCode.getText()) != 0) {
					searchItem();
					stPrevItemCode = bxItemCode.getText();
				}
			}
			else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
				bxItemCode.setText(stPrevItemCode);
			}
		}        
        public void keyReleased(KeyEvent e) {
        }
        public void keyTyped(KeyEvent e) {
        }
      };
      
    class StoreChangeListener implements ItemListener {
    	@Override
    	public void itemStateChanged(ItemEvent e) {
    		// Control del perfil ID_opcion 1:
    		if ( (e.getStateChange() == ItemEvent.SELECTED) && !Util.tienePermiso(1, usuario)) {
    			cbTiendas.setSelectedIndex(Auxiliar.getIndexTienda(usuario, stTiendasList));
    			return;
    		}
    		// con getStateChange se controla que no haga la pregunta dos veces seguidas
    		// esto es debido que el Item siempre cambia así se opte por cancelar ya que
    		// el cotrol es posterior.
	    		if ( (e.getStateChange() == ItemEvent.SELECTED) && (tablaPR.getRowCount() > 0)) {
	        		if(bStoreChanged && blnProcessed) {
	            		
		    			Object[] options = { "SI, Cambiar Tienda", "NO, cambiar Tienda" };
		    			String msg = "Si cambia de tienda debe reprocesar la información. ¿Desea continuar?";
		    			if(( Util.sigaPareMessage(msg, new JDialog(), JOptionPane.QUESTION_MESSAGE, options)) == 0) {
		        			prevStore = cbTiendas.getSelectedIndex();
		        			bStoreChanged = true;
		        			initCanopus();
		    				procesar();
		    			} else {
		    				bStoreChanged = false;
		    				if (prevStore < 0) 
		    					cbTiendas.setSelectedIndex(0);
		    				else
		    					cbTiendas.setSelectedIndex(prevStore);
		    				bStoreChanged = true;
		    			}
	        		}
	    		}
    	}
    }

	protected void enviarXcorreo() {
		if (!Util.tienePermiso(16, usuario)) // Si no tiene permiso segun bit 16 del perfil
			return;

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
			CotizacionProductosRPT cpRPT = new CotizacionProductosRPT(cotizacion);
			String pdfFileName = cpRPT.getPdfFileName();
			Properties properties = Util.getProperties();
			String smtp = properties.getProperty("eMailSMTP");
			String port = properties.getProperty("eMailPort");
			String pwd = properties.getProperty("eMailPwd");
			String from = properties.getProperty("eMailFrom");
			String subject = "Cotización Flamingo";
			String text = "Te enviamos la cotizacion";
			if (!SendEMail.sendEMail(smtp, port, pwd, from, correo, subject, text, pdfFileName) ) {
				Util.okDialog("Ocurrió un error enviando el correo. Intente nuevamente o reporte a la Mesa de ayuda", new JFrame(), JOptionPane.ERROR_MESSAGE);
			} else {
				Util.okDialog("El correo fue enviado satisfactoriamente", new JFrame(), JOptionPane.INFORMATION_MESSAGE);
		    	if(!blnCarSaved) 
		    		saveCart();
			}
		} else {
			Util.okDialog("Si el correo no es el indicado, debe ir a crédito", new JFrame(), JOptionPane.ERROR_MESSAGE);
		}

	}

	protected void ventaSeguros() {
		// TODO Auto-generated method stub
		int selectedRow = tablaPR.getSelectedRow();
		if(selectedRow == -1) {
			Util.okDialog("Primero debe seleccionar un artículo", new JFrame(), JOptionPane.ERROR_MESSAGE);
			return;
		}
		String codigo = (String) tablaPR.getValueAt(selectedRow, 0);
		String valor = (String) tablaPR.getValueAt(selectedRow, 2);
		
		List<ArticuloRem> articulos = dbServiceImpl.getSegurosProducto(codigo, valor);
		
		if(articulos.size() < 1) {
			Util.okDialog("No hay posible seguro o garantía para este producto", new JFrame(), JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if(articulos.size() == 1) {
			ArticuloRem articulo = (ArticuloRem) articulos.get(0);
			producto = searchItem(Util.quitaCheckDigit(articulo.getEan()));
			producto.setItemPrice(Util.moneyFormat(articulo.getPrecio().toString(), 0));
			addItem();
			return;
		}
		
		Object[] seguros = new Object[articulos.size()];
		
		for(int i = 0; i < articulos.size(); i++) {
			ArticuloRem articulo = (ArticuloRem) articulos.get(i);
			seguros[i] = i + 1 + ". " + articulo.getDescripcion() + ": " + Util.moneyFormat(articulo.getPrecio().toString(), 0);
		}
		
		String sel = (String) JOptionPane.showInputDialog(null, "Seleccione un producto", "SEGURO / GARANTÍA", JOptionPane.QUESTION_MESSAGE, null, seguros, "Selecione");
		
		if(sel == null) {
			Util.okDialog("No seleccionó seguro o garantía para este producto", new JFrame(), JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		char c = sel.charAt(0);
		int index = Integer.parseUnsignedInt(String.valueOf(c)) - 1; 
		
		ArticuloRem articulo = (ArticuloRem) articulos.get(index);
		
		producto = searchItem(Util.quitaCheckDigit(articulo.getEan()));
		
		if (producto != null)  {
			producto.setItemPrice(Util.moneyFormat(articulo.getPrecio().toString(), 0));
			addItem();
		} else {
			Util.okDialog("Seleccionó seguro o garantía que no existe en el POS", new JFrame(), JOptionPane.ERROR_MESSAGE);
			return;
		}
//		addSeguroCelulares();

	}


	protected void saveCart() {
		if(blnCarSaved) {
			Util.okDialog("el Carrito ya había sido guardado antes", (JFrame) this, JOptionPane.ERROR_MESSAGE);
			logCotizador.info("No se graba carrito porque ya había sido guardado antes");
			return;
		}
		if (!Util.tienePermiso(8, usuario)) {// Si no tiene permiso segun bit 8 del perfil
			Util.okDialog("No tiene privilegios para guardar carrito", (JFrame) this, JOptionPane.ERROR_MESSAGE);
			logCotizador.info("No se graba carrito porque el perfil del usuario no lo permite");
			return;
		}
		if(bxCliente.getText().compareTo(GENERICO) == 0) {
			Util.okDialog("El cliente generico no es apto para guardar carrito", (JFrame) this, JOptionPane.ERROR_MESSAGE);
			logCotizador.info("No se graba carrito porque es un cliente genérico");
			return;
		}
		ArrayList<DetalleCotizacion> detalle = new ArrayList<>();
		detalle = Auxiliar.getDetalleCotizacion(modeloPR);
		if (!blnPrinted)
			fillCotizacion();
		// si el carrito había sido recuperado, entonces borra los datos anteriores:
		if (!sCarritoRecuperado.isEmpty()) {
			if ((sClienteRecuperado.compareTo(bxCliente.getText()) == 0)) {
				dbServiceImpl.delCotizacion(sCarritoRecuperado);
				logCotizador.info("Se borra carrito porque había sido recuperado con datos");
				cotizacion.setCotizacionID(sCarritoRecuperado);
				logCotizador.info("Se asigna ID del carrito recuperado a la cotizacion: " + sCarritoRecuperado);
			} 
		} 
		// Si el carrito había sido salvado una vez, pero tuvo cambios, entonces borra los datos anteriores:
		if (dbServiceImpl.existeCotizacion(cotizacion.getCotizacionID(), cotizacion.getCliente().getClienteID())) {
			dbServiceImpl.delCotizacion(cotizacion.getCotizacionID());
			logCotizador.info("El carrito había sido salvado una vez, pero tuvo cambios, entonces borra los datos anteriores");
		}
		
		if(dbServiceImpl.sendCotizacion(cotizacion, detalle)) {
			Util.okDialog("El carrito ha sido guardado", (JFrame) this, JOptionPane.INFORMATION_MESSAGE);
			logCotizador.info("El carrito ha sido guardado");
		}
		else {
			Util.okDialog("El carrito NO ha sido guardado. Verifique los datos e intente de nuevo", (JFrame) this, JOptionPane.ERROR_MESSAGE);
			logCotizador.info("El carrito NO ha sido guardado. Error");
		}
		
		blnCarSaved = true;
	}

	public void asignarPrivilegios(Usuario usuario) {
	    opcionesAplicacion = dbServiceImpl.getOpcionesAplicacion();
	    this.usuario = usuario;
	    // selecciona la tienda asignada en el perfil
	    cbTiendas.setSelectedIndex(Auxiliar.getIndexTienda(usuario, stTiendasList));
		bxVendedor.setText(usuario.getCedula());
	}

	public void setCoordinador(Coordinador coordinador) {
		this.setCoordinador = coordinador;
	}

	public void setLog(Logger log) {
		this.logCotizador = log;
	}    
    
}
