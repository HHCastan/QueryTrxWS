package com.fla.cotizador.vista;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import com.fla.cotizador.modelo.Producto;
import com.fla.cotizador.util.Util;

import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JDialog;

public class VisorItemRecord extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txCodigoArticulo;
	private JTextField txDescripcion;
	private JTextField txPrecio;
	private JTextField txTipoArticulo;
	private JTextField txDepartamento;
	private JTextField txFamilyNu01;
	private JTextField txFamilyNu02;
	private JTextField txUserData1;
	private JTextField txUserData2;
	private JTextField txEventoFenix;
	private JTextField txEventoMefia;
	private JTextField txEventoSafix;
	private Producto producto;


	/**
	 * Create the application.
	 * @param producto 
	 */
	public VisorItemRecord(JFrame ventana, Producto producto) {
		super(ventana, true);
		this.producto = producto;
		setTitle("Visor ficha de artículo POS");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setSize(465, 564);
		getContentPane().setLayout(null);
		
		JLabel lblCodigoArticulo = new JLabel("Código Artículo:");
		lblCodigoArticulo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCodigoArticulo.setBounds(10, 5, 100, 25);
		getContentPane().add(lblCodigoArticulo);
		
		txCodigoArticulo = new JTextField(producto.getItemCode());
		txCodigoArticulo.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txCodigoArticulo.setEditable(false);
		txCodigoArticulo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txCodigoArticulo.setBounds(10, 27, 100, 25);
		getContentPane().add(txCodigoArticulo);
		txCodigoArticulo.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripción:");
		lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDescripcion.setBounds(135, 5, 100, 25);
		getContentPane().add(lblDescripcion);
		
		txDescripcion = new JTextField(producto.getItemDesc());
		txDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txDescripcion.setEditable(false);
		txDescripcion.setColumns(10);
		txDescripcion.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txDescripcion.setBounds(135, 27, 280, 25);
		getContentPane().add(txDescripcion);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrecio.setBounds(10, 55, 100, 25);
		getContentPane().add(lblPrecio);
		
		txPrecio = new JTextField(producto.getItemPrice());
		txPrecio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txPrecio.setEditable(false);
		txPrecio.setColumns(10);
		txPrecio.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txPrecio.setBounds(10, 80, 100, 25);
		getContentPane().add(txPrecio);
		
		JLabel lblDepartamento = new JLabel("Departamento:");
		lblDepartamento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDepartamento.setBounds(135, 55, 100, 25);
		getContentPane().add(lblDepartamento);
		
		txDepartamento = new JTextField(producto.getDepto());
		txDepartamento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txDepartamento.setEditable(false);
		txDepartamento.setColumns(10);
		txDepartamento.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txDepartamento.setBounds(135, 80, 80, 25);
		getContentPane().add(txDepartamento);
		
		JLabel lblTipoArticulo = new JLabel("Tipo de Artículo:");
		lblTipoArticulo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTipoArticulo.setBounds(245, 55, 100, 25);
		getContentPane().add(lblTipoArticulo);
		
		txTipoArticulo = new JTextField();
		txTipoArticulo.setText("Venta Normal");
		if (producto.getIndicat2() == 40)
			txTipoArticulo.setText("Venta Miscelánea");
		txTipoArticulo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txTipoArticulo.setEditable(false);
		txTipoArticulo.setColumns(10);
		txTipoArticulo.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txTipoArticulo.setBounds(245, 80, 170, 25);
		getContentPane().add(txTipoArticulo);
		
		JPanel pnlFamilyNumber = new JPanel();
		pnlFamilyNumber.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Family Number:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlFamilyNumber.setBounds(10, 115, 429, 60);
		getContentPane().add(pnlFamilyNumber);
		pnlFamilyNumber.setLayout(null);
		
		JLabel lblFamilyNu01 = new JLabel("Actual");
		if (producto.getIndicat2() == 40)
			lblFamilyNu01.setText("Venta");
		lblFamilyNu01.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFamilyNu01.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFamilyNu01.setBounds(10, 20, 100, 17);
		pnlFamilyNumber.add(lblFamilyNu01);
		
		txFamilyNu01 = new JTextField(producto.getFamilyNu().substring(0, 3));
		txFamilyNu01.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txFamilyNu01.setEditable(false);
		txFamilyNu01.setBounds(121, 20, 60, 20);
		pnlFamilyNumber.add(txFamilyNu01);
		txFamilyNu01.setColumns(10);
		
		JLabel lblFamilyNu02 = new JLabel("Previo");
		if (producto.getIndicat2() == 40)
			lblFamilyNu02.setText("Devolución");
		lblFamilyNu02.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFamilyNu02.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFamilyNu02.setBounds(206, 20, 100, 17);
		pnlFamilyNumber.add(lblFamilyNu02);
		
		txFamilyNu02 = new JTextField(producto.getFamilyNu().substring(3));
		txFamilyNu02.setEditable(false);
		txFamilyNu02.setColumns(10);
		txFamilyNu02.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txFamilyNu02.setBounds(316, 20, 60, 20);
		pnlFamilyNumber.add(txFamilyNu02);
		
		JPanel pnlBanderas = new JPanel();
		pnlBanderas.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Banderas de art\u00EDculo:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlBanderas.setBounds(10, 375, 429, 146);
		getContentPane().add(pnlBanderas);
		pnlBanderas.setLayout(null);
		
		JCheckBox chkbKeepItemMovement = new JCheckBox("Guarda Ventas");
		chkbKeepItemMovement.setBounds(6, 17, 131, 23);
		chkbKeepItemMovement.setSelected(!Util.isBitSetOn(producto.getIndicat0(),0));
		chkbKeepItemMovement.setEnabled(false);
		pnlBanderas.add(chkbKeepItemMovement);
		
		JCheckBox chkbxPriceRequired = new JCheckBox("Requiere Precio");
		chkbxPriceRequired.setBounds(6, 41, 131, 23);
		chkbxPriceRequired.setSelected(Util.isBitSetOn(producto.getIndicat0(),4));
		chkbxPriceRequired.setEnabled(false);
		pnlBanderas.add(chkbxPriceRequired);
		
		JCheckBox chckbxRequierePrecio_peso = new JCheckBox("Requiere $/Peso");
		chckbxRequierePrecio_peso.setBounds(6, 67, 131, 23);
		chckbxRequierePrecio_peso.setSelected(Util.isBitSetOn(producto.getIndicat0(),6));
		chckbxRequierePrecio_peso.setEnabled(false);
		pnlBanderas.add(chckbxRequierePrecio_peso);
		
		JCheckBox chckbxFoodStamp = new JCheckBox("Food Stamp");
		chckbxFoodStamp.setEnabled(false);
		chckbxFoodStamp.setBounds(6, 93, 131, 23);
		chckbxFoodStamp.setSelected(Util.isBitSetOn(producto.getIndicat1(),3));
		pnlBanderas.add(chckbxFoodStamp);
		
		JCheckBox chckbxAplicaPuntos = new JCheckBox("Aplica Puntos");
		chckbxAplicaPuntos.setEnabled(false);
		chckbxAplicaPuntos.setBounds(6, 119, 131, 23);
		pnlBanderas.add(chckbxAplicaPuntos);
		
		JCheckBox chckbxDescontable = new JCheckBox("Descontable");
		chckbxDescontable.setEnabled(false);
		chckbxDescontable.setBounds(139, 17, 127, 23);
		chckbxDescontable.setSelected(!Util.isBitSetOn(producto.getIndicat1(),1));
		pnlBanderas.add(chckbxDescontable);
		
		JCheckBox chckbxCupnMultiplicador = new JCheckBox("Cupón Multiplicador");
		chckbxCupnMultiplicador.setEnabled(false);
		chckbxCupnMultiplicador.setBounds(139, 41, 140, 23);
		chckbxCupnMultiplicador.setSelected(!Util.isBitSetOn(producto.getIndicat1(),0));
		pnlBanderas.add(chckbxCupnMultiplicador);
		
		JCheckBox chckbxLogDeExcepciones = new JCheckBox("Log de Excepciones");
		chckbxLogDeExcepciones.setEnabled(false);
		chckbxLogDeExcepciones.setBounds(139, 67, 140, 23);
		pnlBanderas.add(chckbxLogDeExcepciones);
		
		JCheckBox chckbxSoloPuntos = new JCheckBox("Solo Puntos");
		chckbxSoloPuntos.setEnabled(false);
		chckbxSoloPuntos.setBounds(139, 93, 140, 23);
		pnlBanderas.add(chckbxSoloPuntos);
		
		JCheckBox chckbxCantidadPermitida = new JCheckBox("Cantidad Permitida");
		chckbxCantidadPermitida.setEnabled(false);
		chckbxCantidadPermitida.setBounds(139, 119, 140, 23);
		pnlBanderas.add(chckbxCantidadPermitida);
		
		JCheckBox chckbxCantidadRequerida = new JCheckBox("Cantidad Requerida");
		chckbxCantidadRequerida.setEnabled(false);
		chckbxCantidadRequerida.setBounds(283, 17, 140, 23);
		pnlBanderas.add(chckbxCantidadRequerida);
		
		JCheckBox chckbxVentaPermitida = new JCheckBox("Venta Autorizada");
		chckbxVentaPermitida.setEnabled(false);
		chckbxVentaPermitida.setBounds(283, 41, 140, 23);
		chckbxVentaPermitida.setSelected(!Util.isBitSetOn(producto.getIndicat0(),2));
		pnlBanderas.add(chckbxVentaPermitida);
		
		JCheckBox chckbxHorasRestringidas = new JCheckBox("Horas restringidas");
		chckbxHorasRestringidas.setEnabled(false);
		chckbxHorasRestringidas.setBounds(283, 67, 140, 23);
		chckbxHorasRestringidas.setSelected(Util.isBitSetOn(producto.getIndicat0(),1));
		pnlBanderas.add(chckbxHorasRestringidas);
		
		JCheckBox chckbxSelfLabelPrint = new JCheckBox("Self Label Print");
		chckbxSelfLabelPrint.setEnabled(false);
		chckbxSelfLabelPrint.setBounds(283, 93, 140, 23);
		chckbxSelfLabelPrint.setSelected(!Util.isBitSetOn(producto.getIndicat1a(),7));
		pnlBanderas.add(chckbxSelfLabelPrint);
		
		JCheckBox chckbxArtculoDepsito = new JCheckBox("Artículo Depósito");
		chckbxArtculoDepsito.setEnabled(false);
		chckbxArtculoDepsito.setBounds(283, 119, 140, 23);
		pnlBanderas.add(chckbxArtculoDepsito);
		
		JPanel pnlTaxPlan = new JPanel();
		pnlTaxPlan.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Plan de Impuestos:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlTaxPlan.setBounds(10, 180, 429, 45);
		getContentPane().add(pnlTaxPlan);
		pnlTaxPlan.setLayout(null);
		
		JCheckBox chckbxTaxPlanA = new JCheckBox("Tax Plan A");
		chckbxTaxPlanA.setEnabled(false);
		chckbxTaxPlanA.setBounds(6, 18, 92, 23);
		chckbxTaxPlanA.setSelected(Util.isBitSetOn(producto.getIndicat1(),7));
		pnlTaxPlan.add(chckbxTaxPlanA);
		
		JCheckBox chckbxTaxPlanB = new JCheckBox("Tax Plan B");
		chckbxTaxPlanB.setEnabled(false);
		chckbxTaxPlanB.setBounds(100, 18, 97, 23);
		chckbxTaxPlanB.setSelected(Util.isBitSetOn(producto.getIndicat1(),6));
		pnlTaxPlan.add(chckbxTaxPlanB);
		
		JCheckBox chckbxTaxPlanC = new JCheckBox("Tax Plan C");
		chckbxTaxPlanC.setEnabled(false);
		chckbxTaxPlanC.setSelected(Util.isBitSetOn(producto.getIndicat1(),5));
		chckbxTaxPlanC.setBounds(200, 18, 97, 23);
		pnlTaxPlan.add(chckbxTaxPlanC);
		
		JCheckBox chckbxTaxPlanD = new JCheckBox("Tax Plan D");
		chckbxTaxPlanD.setEnabled(false);
		chckbxTaxPlanD.setBounds(300, 18, 97, 23);
		chckbxTaxPlanD.setSelected(Util.isBitSetOn(producto.getIndicat1(),4));
		pnlTaxPlan.add(chckbxTaxPlanD);
		
		JPanel pnlUserOptions = new JPanel();
		pnlUserOptions.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Opciones de usuario:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlUserOptions.setBounds(10, 230, 429, 80);
		getContentPane().add(pnlUserOptions);
		pnlUserOptions.setLayout(null);
		
		JCheckBox chckbxOpcion1 = new JCheckBox("Opción 1");
		chckbxOpcion1.setEnabled(false);
		chckbxOpcion1.setBounds(6, 19, 97, 23);
		chckbxOpcion1.setSelected(Util.isBitSetOn(producto.getIndicat1a(),3));
		pnlUserOptions.add(chckbxOpcion1);
		
		JCheckBox chckbxOpcion2 = new JCheckBox("Opción 2");
		chckbxOpcion2.setEnabled(false);
		chckbxOpcion2.setBounds(100, 19, 97, 23);
		chckbxOpcion2.setSelected(Util.isBitSetOn(producto.getIndicat1a(),2));
		pnlUserOptions.add(chckbxOpcion2);
		
		JCheckBox chckbxOpcion3 = new JCheckBox("Opción 3");
		chckbxOpcion3.setEnabled(false);
		chckbxOpcion3.setBounds(199, 19, 97, 23);
		chckbxOpcion3.setSelected(Util.isBitSetOn(producto.getIndicat1a(),1));
		pnlUserOptions.add(chckbxOpcion3);
		
		JCheckBox chckbxOpcion4 = new JCheckBox("Opción 4");
		chckbxOpcion4.setEnabled(false);
		chckbxOpcion4.setBounds(302, 19, 97, 23);
		chckbxOpcion4.setSelected(Util.isBitSetOn(producto.getIndicat1a(),0));
		pnlUserOptions.add(chckbxOpcion4);
		
		JLabel lblUserData1 = new JLabel("Dato 1:");
		lblUserData1.setBounds(16, 49, 46, 14);
		pnlUserOptions.add(lblUserData1);
		
		txUserData1 = new JTextField();
		txUserData1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txUserData1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txUserData1.setEditable(false);
		txUserData1.setBounds(61, 49, 86, 20);
		pnlUserOptions.add(txUserData1);
		txUserData1.setColumns(10);
		
		JLabel lblUserData2 = new JLabel("Dato 2:");
		lblUserData2.setBounds(209, 52, 46, 14);
		pnlUserOptions.add(lblUserData2);
		
		txUserData2 = new JTextField();
		txUserData2.setEditable(false);
		txUserData2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txUserData2.setBounds(265, 49, 86, 20);
		pnlUserOptions.add(txUserData2);
		txUserData2.setColumns(10);
		
		JPanel pnlEventosFinancieros = new JPanel();
		pnlEventosFinancieros.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Eventos Financieros:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlEventosFinancieros.setBounds(10, 315, 429, 52);
		getContentPane().add(pnlEventosFinancieros);
		pnlEventosFinancieros.setLayout(null);
		
		JLabel lblEventoFenix = new JLabel("Fénix");
		lblEventoFenix.setBounds(21, 25, 32, 14);
		pnlEventosFinancieros.add(lblEventoFenix);
		
		txEventoFenix = new JTextField(Integer.toString(producto.getEventoFenix()));
		txEventoFenix.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txEventoFenix.setEditable(false);
		txEventoFenix.setBounds(63, 22, 60, 20);
		pnlEventosFinancieros.add(txEventoFenix);
		txEventoFenix.setColumns(10);
		
		JLabel lblEventoMefia = new JLabel("Mefía");
		lblEventoMefia.setBounds(158, 25, 36, 14);
		pnlEventosFinancieros.add(lblEventoMefia);
		
		txEventoMefia = new JTextField(Integer.toString(producto.getEventoMefia()));
		txEventoMefia.setEditable(false);
		txEventoMefia.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txEventoMefia.setBounds(194, 22, 60, 20);
		pnlEventosFinancieros.add(txEventoMefia);
		txEventoMefia.setColumns(10);
		
		JLabel lblEventoSafix = new JLabel("Safix");
		lblEventoSafix.setBounds(295, 25, 36, 14);
		pnlEventosFinancieros.add(lblEventoSafix);
		
		txEventoSafix = new JTextField(Integer.toString(producto.getEventoSafix()));
		txEventoSafix.setEditable(false);
		txEventoSafix.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txEventoSafix.setBounds(335, 22, 60, 20);
		pnlEventosFinancieros.add(txEventoSafix);
		txEventoSafix.setColumns(10);
	}
}
