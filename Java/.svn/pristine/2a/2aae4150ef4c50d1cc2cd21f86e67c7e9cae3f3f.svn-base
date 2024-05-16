package com.fla.cotizador.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.json.simple.JSONObject;

import com.fla.cotizador.controlador.TenderTableControl;
import com.fla.cotizador.modelo.Almacen;
import com.fla.cotizador.modelo.ClienteSisteCredito;
import com.fla.cotizador.modelo.Cotizacion;
import com.fla.cotizador.modelo.CreditoSisteCredito;
import com.fla.cotizador.modelo.DetalleCotizacion;
import com.fla.cotizador.modelo.Producto;
import com.fla.cotizador.modelo.ProductosTableModel;
import com.fla.cotizador.modelo.Tender;
import com.fla.cotizador.modelo.TenderTableModel;
import com.fla.cotizador.modelo.TokenSisteCredito;
import com.fla.cotizador.modelo.Usuario;
import com.fla.cotizador.servicio.DBServiceImplementation;
import com.fla.cotizador.servicio.modelo.CuotaSisteCredito;

public class Auxiliar {
	public static TenderTableModel getModeloMP(String listaMedios) {
		if(!listaMedios.isEmpty()) {
			TenderTableModel modeloMP = new TenderTableModel();
			TenderTableControl controlMP = new TenderTableControl(modeloMP);
			String[] mp = listaMedios.split(",");
			for (int i = 0; i < mp.length; i++) {
				String sTenderId = mp[i].split("~")[0];
				String sMonto = mp[i].split("~")[1];
				Tender tender = new Tender();
				tender.newTender(sTenderId, null, sMonto);
				controlMP.addRow(tender);
			}
			return modeloMP;
		}
		return null;
	}
	
	public static String obtieneListaMediosDePago(TenderTableModel modeloMP) {
		if (modeloMP.getRowCount() == 0) // Vacío, no se han ingresado medios de pago
			return "";

		StringBuilder mediosDePago = new StringBuilder("");
		for (int i = 0; i < modeloMP.getRowCount(); i++) {
			Tender tender =  (Tender) modeloMP.getRowTender(i);
			if (!contieneMedioDePago(tender.getCodigo(), mediosDePago.toString())) {
				if (i > 0)
					mediosDePago.append(",");
				mediosDePago.append(tender.getCodigo());
				mediosDePago.append("~");
				mediosDePago.append(Util.removeMoneyFormat(tender.getMonto()));
			}
		}
		return mediosDePago.toString();
	}

	private static boolean contieneMedioDePago(String codigo, String mediosDePago) {
		if (mediosDePago.isEmpty())
			return false;
		if (mediosDePago.contains(codigo))
			return true;
		return false;
	}
	
	public static boolean mediosCredito(TenderTableModel modeloMP) {
		if (modeloMP.getRowCount() == 0) // Vacío, no se han ingresado medios de pago
			return false;
		for (int i = 0; i < modeloMP.getRowCount(); i++) {
			Tender tender =  (Tender) modeloMP.getRowTender(i);
			if ( (tender.getCodigo().equals("66")) || (tender.getCodigo().equals("MFIA")) )
				return true;
		}
		return false;
	}

	public static int getGrupoArticulo(ProductosTableModel productosTableModel) {
		DBServiceImplementation serviceImpl = new DBServiceImplementation();
		int grupos [] = {20, 45, 51, 89, 93};
		Producto producto = productosTableModel.getRowProduct(0);
		String ean = producto.getItemCode();
		int grupo = serviceImpl.getGrupo(ean);
		for (int i = 0; i < grupos.length; i++) {
			if (grupo == grupos[i])
				return 1;
		}
		return 0;
	}
	
    /**
     * getIndexTienda: Retorna un indice que apunta a la tienda del usuario
     * @param usuario
     * @param stTiendasList
     * @return
     */
	public static int getIndexTienda(Usuario usuario, Almacen[] stTiendasList) {
		if (usuario == null)
			return 0;
		String tiendaUsuario = usuario.getSitio();
		tiendaUsuario = ("00" + tiendaUsuario).substring(tiendaUsuario.length() -1);
		if (tiendaUsuario.equals("98")) // El superusuario empieza en la tienda cero
			return 0;
		
		for (int i = 0; i < stTiendasList.length; i++) {
			if (tiendaUsuario.equals(stTiendasList[i].getCodigo())) {
				return i;
			}
		}
		return 0;
	}
	
	/**
	 *  getCotizacionCliente: Recupera una cotizacion desde la base de datos. Solo cotizaciones abiertas para la misma fecha
	 * @param sCliente
	 * @param sFecha
	 * @param sTienda
	 * @return
	 */
	public static Cotizacion getCotizacionCliente(String sCliente, String sFecha, String sTienda) {
		Cotizacion cotizacion = null;
		DBServiceImplementation dbServiceImpl = new DBServiceImplementation();
		cotizacion = dbServiceImpl.getCotizacionCliente(sCliente, sFecha, Util.zeroPad(sTienda, 2));
		return cotizacion;
	}
	
	public static ArrayList<DetalleCotizacion> getDetalleCotizacion(ProductosTableModel modeloPR) {
		ArrayList<DetalleCotizacion> detalle = new ArrayList<>();
        for(int i = 0; i < modeloPR.getRowCount(); i++) {
        	Producto producto = modeloPR.getRowProduct(i);
        	if (!contiene(producto.getItemCode(), producto.getQuantity(), detalle)) {
            	detalle.add(new DetalleCotizacion(producto));
        	}
        }
		return detalle;
	}
	
    private static boolean contiene(String itemCode, int cantidad, ArrayList<DetalleCotizacion> detalle) {
    	for (DetalleCotizacion dc: detalle) {
    		if(dc.getCodigo().equals(itemCode)) {
    			dc.setCantidad(dc.getCantidad() + cantidad);
    			dc.setTotal(Util.sumaFormateados(dc.getTotal(), Util.getTotalItem(dc.getValor(), cantidad), '+'));
    			return true;
    		}
    	}
    	return false;
    }
    
	public static String salvarCotizacion(Cotizacion cotizacion, ArrayList<DetalleCotizacion> detalle) {
		DBServiceImplementation dbServiceImpl = new DBServiceImplementation();
		
		// si hay una cotizacion abierta, la cierra y crea la nueva:
		String sCarritoRecuperado = existeCotizacion(cotizacion);
		if (!sCarritoRecuperado.isEmpty()) {
			dbServiceImpl.delCotizacion(sCarritoRecuperado);
			cotizacion.setCotizacionID(sCarritoRecuperado);
		} else {
			String sTienda = Util.zeroPad(cotizacion.getTienda().getCodigo(), 2);
			cotizacion.setCotizacionID(dbServiceImpl.getIDCotizacion(sTienda));
		}
		dbServiceImpl.sendCotizacion(cotizacion, detalle);
		return cotizacion.getCotizacionID();
	}
	
	public static String existeCotizacion(Cotizacion cotizacion) {
		String respuesta = "";
		String sFecha = Util.getDateTime().substring(0, 8);
		String sTienda = Util.zeroPad(cotizacion.getTienda().getCodigo(), 2);
		String sCliente = cotizacion.getCliente().getClienteID();
		Cotizacion cotizacionOld = Auxiliar.getCotizacionCliente(sCliente, sFecha, sTienda);
		if (cotizacionOld != null)
			respuesta = cotizacionOld.getCotizacionID();
		return respuesta;
	}

	public static ClienteSisteCredito jasonData2ClienteSisteCredito(JSONObject jsonData) {
		ClienteSisteCredito respuesta = new ClienteSisteCredito();
		respuesta.setCreditLimit((double) jsonData.get("creditLimit"));
		respuesta.setAvailableCreditLimit((double) jsonData.get("availableCreditLimit"));
		respuesta.setValidatedMail("1".equals(jsonData.get("validatedMail")));
		respuesta.setNewCreditButtonEnabled("1".equals(jsonData.get("newCreditButtonEnabled")));
		respuesta.setEmail((String) jsonData.get("email"));
		respuesta.setMobile((String) jsonData.get("mobile"));
		respuesta.setFullName((String) jsonData.get("fullName"));
		respuesta.setDefaulter("1".equals(jsonData.get("defaulter")));
		respuesta.setCreditLimitIncrease("1".equals(jsonData.get("creditLimitIncrease")));
		respuesta.setAvailableCreditLimit("1".equals(jsonData.get("isAvailableCreditLimit")));
		respuesta.setActive("1".equals(jsonData.get("isActive")));
		respuesta.setStatus(Integer.parseInt(jsonData.get("status").toString()));
		respuesta.setStatusName((String) jsonData.get("statusName"));
		return respuesta;
	}

	public static CuotaSisteCredito jasonData2CuotaSisteCredito(JSONObject jsonData) {
		CuotaSisteCredito respuesta = new CuotaSisteCredito();
		respuesta.setDownPayment((double) jsonData.get("downPayment"));
		respuesta.setTotalFeeValue((double) jsonData.get("totalFeeValue"));
		respuesta.setCreditValue((double) jsonData.get("creditValue"));
		respuesta.setFees(Integer.parseInt(jsonData.get("fees").toString()));
		respuesta.setAssuranceValue((double) jsonData.get("assuranceValue"));
		respuesta.setInterestRate((double) jsonData.get("interestRate"));
		respuesta.setTotalInterestValue((double) jsonData.get("totalInterestValue"));
		respuesta.setTotalDownPayment((double) jsonData.get("totalDownPayment"));
		respuesta.setFeeCreditValue((double) jsonData.get("feeCreditValue"));
		respuesta.setAssuranceFeeValue((double) jsonData.get("assuranceFeeValue"));
		respuesta.setAssuranceTotalValue((double) jsonData.get("assuranceTotalValue"));
		respuesta.setAssuranceTaxFeeValue((double) jsonData.get("assuranceTaxFeeValue"));
		respuesta.setAssuranceTaxValue((double) jsonData.get("assuranceTaxValue"));
		respuesta.setDownPaymentPercentage((double) jsonData.get("downPaymentPercentage"));
		respuesta.setAssurancePercentage((double) jsonData.get("assurancePercentage"));
		respuesta.setAssuranceTaxFeeValue((double) jsonData.get("assuranceTaxFeeValue"));
		respuesta.setTotalPaymentValue((double) jsonData.get("totalPaymentValue"));
		respuesta.setCustomerAllowPhotoSignature("1".equals(jsonData.get("customerAllowPhotoSignature")));
		return respuesta;
	}

	public static TokenSisteCredito jasonData2TokenSisteCredito(JSONObject jsonData) {
		TokenSisteCredito respuesta = new TokenSisteCredito();
		JSONObject jsonToken = (JSONObject) jsonData.get("token");
		respuesta.setTokenValue((String) jsonToken.get("tokenValue"));
		respuesta.setRemainingSeconds(((Long) jsonToken.get("remainingSeconds")).intValue());
		
		respuesta.setFormattedToken((String) jsonData.get("formattedToken"));
		respuesta.setTotalTime(((Long) jsonData.get("totalTime")).intValue());
		respuesta.setDuration((String) jsonData.get("duration"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd'T'HH:mm:ss.SSSSSSSX");
		Date expirationDate = null;
		Date generationDate = null;
		try {
			expirationDate = sdf.parse((String) jsonData.get("expirationDate"));
			generationDate = sdf.parse((String) jsonData.get("generationDate"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		respuesta.setExpirationDate(expirationDate);
		respuesta.setGenerationDate(generationDate);
		return respuesta;
	}

	public static CreditoSisteCredito jasonData2CreditoSisteCredito(JSONObject jsonData) {
		CreditoSisteCredito respuesta = new CreditoSisteCredito();
		respuesta.setTypeDocument((String) jsonData.get("typeDocument"));
		respuesta.setIdDocument((String) jsonData.get("idDocument"));
		respuesta.setCreditId((String) jsonData.get("creditId"));
		respuesta.setCreditNumber(((Long) jsonData.get("creditNumber")).intValue());
		respuesta.setEffectiveAnnualRate((double) jsonData.get("effectiveAnnualRate"));
		respuesta.setDownPaymentId((String) jsonData.get("downPaymentId"));
		respuesta.setStoreId((String) jsonData.get("storeId"));
		respuesta.setTotalPaymentValue((double) jsonData.get("totalPaymentValue"));
		respuesta.setCustomerAllowPhotoSignature("1".equals(jsonData.get("customerAllowPhotoSignature")));
		respuesta.setDownPayment((double) jsonData.get("downPayment"));
		respuesta.setTotalFeeValue((double) jsonData.get("totalFeeValue"));
		respuesta.setCreditValue((double) jsonData.get("creditValue"));
		respuesta.setFees(((Long) jsonData.get("fees")).intValue());
		respuesta.setAssuranceValue((double) jsonData.get("assuranceValue"));
		respuesta.setInterestRate((double) jsonData.get("interestRate"));
		respuesta.setTotalInterestValue((double) jsonData.get("totalInterestValue"));
		respuesta.setTotalDownPayment((double) jsonData.get("totalDownPayment"));
		respuesta.setFeeCreditValue((double) jsonData.get("feeCreditValue"));
		respuesta.setAssuranceFeeValue((double) jsonData.get("assuranceFeeValue"));
		respuesta.setAssuranceTotalValue((double) jsonData.get("assuranceTotalValue"));
		respuesta.setAssuranceTaxFeeValue((double) jsonData.get("assuranceTaxFeeValue"));
		respuesta.setAssuranceTaxValue((double) jsonData.get("assuranceTaxValue"));
		respuesta.setDownPaymentPercentage((double) jsonData.get("downPaymentPercentage"));
		respuesta.setAssurancePercentage((double) jsonData.get("assurancePercentage"));
		respuesta.setAssuranceTotalFeeValue((double) jsonData.get("assuranceTotalFeeValue"));
		return respuesta;
	}
	
	public static JTable adicionarFila(JTable jTabla, String c1, String c2) {
		int nRow = jTabla.getRowCount();
		Object[][] tableData = new Object[nRow + 1][2];
		for(int row = 0; row < nRow; row++) {
			tableData[row][0] = jTabla.getValueAt(row, 0);
			tableData[row][1] = jTabla.getValueAt(row, 1);
		}
		tableData[nRow][0] = c1;
		tableData[nRow][1] = c2;
		String[] columns = new String[] { jTabla.getColumnName(0), jTabla.getColumnName(1) };
		JTable respuesta = new JTable(tableData, columns);
		return respuesta;
	}
}
