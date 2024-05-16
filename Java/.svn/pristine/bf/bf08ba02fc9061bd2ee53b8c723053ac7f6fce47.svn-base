package com.fla.cotizador.util;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.fla.cotizador.Version;
import com.fla.cotizador.modelo.Almacen;
import com.fla.cotizador.modelo.Cotizacion;
import com.fla.cotizador.modelo.DetalleCotizacion;
import com.fla.cotizador.modelo.ProductosTableModel;
import com.fla.cotizador.modelo.Tender;
import com.fla.cotizador.modelo.TenderTableModel;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;


public class CotizacionFinanciacionRPT {
	private static String pdfFileName;
    private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
    private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
    private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
    private static Font monoFont = new Font(Font.FontFamily.COURIER, 12, Font.BOLD);

    private String cotizacionID;
    private Almacen tienda;
    private String fecha;
    private String nombre;
    private String clienteID;
    private ProductosTableModel modeloPR;
    private TenderTableModel modeloMP;
    private String total;
    private String descuento;
    private String cuotas;
    private String safix;
    private String observaciones;
    private String modalidad;
    private String vlrFinanciar;
    private ArrayList<DetalleCotizacion> detalle = new ArrayList<>();
    private PdfWriter writer;
    
    public String getFecha() {
		return fecha;
	}

	private String mefia;
	Document document = new Document(PageSize.LEGAL);
	String productoBorrar;

	public CotizacionFinanciacionRPT(Cotizacion cotizacion) {
		this.tienda = cotizacion.getTienda();
		this.fecha = cotizacion.getFechaPrecio();
		this.nombre = cotizacion.getCliente().getClienteName();
		this.clienteID = cotizacion.getCliente().getClienteID();
		this.total = cotizacion.getValor();
		this.descuento = cotizacion.getDescuento();
		this.cuotas = cotizacion.getMeses();
		this.safix = cotizacion.getCuotaSafix();
		this.mefia = cotizacion.getCuotaMefia();
		this.observaciones = cotizacion.getObservaciones();
		this.modalidad = cotizacion.getModalidad(); 
		this.modeloPR = cotizacion.getModeloPR();
		this.modeloMP = cotizacion.getModeloMP();
		this.vlrFinanciar = cotizacion.getVlrFinanciar();

        detalle = Auxiliar.getDetalleCotizacion(modeloPR);
//		cotizacion.setCotizacionID(Auxiliar.salvarCotizacion(cotizacion, detalle));
		this.cotizacionID = cotizacion.getCotizacionID();
		
		pdfFileName = "c:/tmp/cotizacion_" + tienda.getNombre() + Util.getDateTime() + ".pdf";
//		System.out.println("File name: " + pdfFileName);

		CrearCotizacion();
	}

	private void CrearCotizacion() {
		try {
			writer = PdfWriter.getInstance(document, new FileOutputStream(pdfFileName));
			document.open();
            addMetaData(document);
            addTitlePage(document);
//            addContent(document);
            document.close();
		} catch (FileNotFoundException | DocumentException e) {
			e.printStackTrace();
		}
	}

	public void imprimir() {
		File fCotizacion = new File(pdfFileName);
		try {
//			Desktop.getDesktop().print(fCotizacion);
			Desktop.getDesktop().open(fCotizacion);
		} catch (FileNotFoundException e1) {
			Util.okDialog("Error generando cotización", new JFrame(), JOptionPane.ERROR_MESSAGE);
		} catch (IOException e) {
			Util.okDialog("Error generando cotización", new JFrame(), JOptionPane.ERROR_MESSAGE);
		}
	}
	
    // iText allows to add metadata to the PDF which can be viewed in your Adobe
    // Reader
    // under File -> Properties
    private static void addMetaData(Document document) {
        document.addTitle("Cotización Flamingo");
        document.addSubject("Cotización de productos Flamingo");
        document.addKeywords("Cotización, Flamingo, Descuentos");
        document.addAuthor("hcastaneda");
        document.addCreator("CotizadorFlamingo");
    }

    private void addTitlePage(Document document) throws DocumentException {
    	Image logoFlamingo = Util.getLogoFlamingo();
        PdfPCell cell1 = new PdfPCell(logoFlamingo, true);
        cell1.setBorder(Rectangle.NO_BORDER);
        Paragraph preface = new Paragraph();

        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(100);
        table.setWidths(new int[]{15, 70, 15});
        addEmptyLine(preface, 1);
        preface.add(new Paragraph("COTIZACIÓN No. " + cotizacionID, catFont));
        PdfPCell cell2 = new PdfPCell(preface);
        cell2.setBorder(Rectangle.NO_BORDER);
        cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
        Barcode128 code128 = new Barcode128();
        code128.setFont(null);
        code128.setCodeType(Barcode128.CODE128);
        code128.setCode(cotizacionID);
        PdfPCell cell3 = new PdfPCell(code128.createImageWithBarcode(writer.getDirectContent(), null, null));
        cell3.setBorder(Rectangle.NO_BORDER);

        table.addCell(cell1);
        table.addCell(cell2);
        table.addCell(cell3);
        document.add(table);

        preface = new Paragraph();
        addEmptyLine(preface, 1);
        preface.add(new Paragraph("Cotizador Ver." + Version.getVersionNumber(), smallBold));
        preface.add(new Paragraph("FLAMINGO " + tienda.getNombre(), catFont));

        addEmptyLine(preface, 1);
        preface.add(new Paragraph("Cotización generada por: " + System.getProperty("user.name"), smallBold));

        addEmptyLine(preface, 1);
        preface.add(new Paragraph("Fecha de generación: " +  Util.getDate(), smallBold));
        preface.add(new Paragraph("Fecha de vigencia: " +  fecha, smallBold));

        addEmptyLine(preface, 1);
        preface.add(new Paragraph( "Cédula del cliente: " + clienteID, smallBold));
        preface.add(new Paragraph("Nombre del cliente: " + nombre, smallBold));
        
        addEmptyLine(preface, 2);
        preface.add(new Paragraph("Productos Cotizados: "));
        addEmptyLine(preface, 2);
//        preface.add(new Paragraph("Código          Descripción            Precio      Cant.   Total", monoFont));
        preface.add(new Paragraph("CÓDIGO         DESCRIPCIÓN           PRECIO    CANT.  TOTAL       VENDEDOR", monoFont));
        addEmptyLine(preface, 1);
        
        for (DetalleCotizacion dc: detalle) {
        	preface.add(new Paragraph(dc.toPrint(), monoFont));
        	
        }

        addEmptyLine(preface, 1);
        preface.add(new Paragraph( "Descuentos otorgados: " + descuento, smallBold));

        addEmptyLine(preface, 1);
        preface.add(new Paragraph( "Total cotización: " + total, smallBold));

        addEmptyLine(preface, 1);
        preface.add(new Paragraph( "Medios de pago cotizados: ", smallBold));
        for (int a = 0; a < modeloMP.getRowCount(); a++) {
        	Tender tender = (Tender) modeloMP.getRowTender(a);
        	preface.add(new Paragraph("     " + tender.getMonto() + " a " + tender.getDescripcion(), smallBold));
        }

        addEmptyLine(preface, 1);
        preface.add(new Paragraph( "Valor a financiar: " + vlrFinanciar, smallBold));

        addEmptyLine(preface, 1);
        preface.add(new Paragraph( "Número de cuotas: " + cuotas, smallBold));

        if(safix.compareTo("0") != 0) {
            addEmptyLine(preface, 1);
//          preface.add(new Paragraph( "Valor cuota " + modalidad + ": " + safix, smallBold));
          preface.add(new Paragraph( "Valor cuota Crédito: " + safix, smallBold));
        }

        if(mefia.compareTo("0") != 0) {
            addEmptyLine(preface, 1);
            preface.add(new Paragraph( "Valor cuota Tarjeta Mefía: " + mefia, smallBold));
        }
        
        addEmptyLine(preface, 1);
        preface.add(new Paragraph( "Observaciones: " + observaciones, smallBold));
        
        addEmptyLine(preface, 1);
        preface.add(new Paragraph( "Nombre y firma del vendedor: _________________________________________________________", smallBold));
        
        String legales = "El valor de la cuota calculada para MEFIA es aproximada. No tiene en cuenta costos de manejo ni seguros. "
        		+ "La presente cuota de referencia tiene como fecha de corte el 1 de cada mes y fecha de pago el 16, "
        		+ "por lo tanto, el valor de la cuota de pago puede variar de acuerdo a la fecha de corte de cada cliente."
        		+ " Para más información consultar en cualquier almacén Flamingo o a través de la línea (4) 604 0000.";

        addEmptyLine(preface, 1);
        preface.add(new Paragraph(legales, smallBold));
        
        addEmptyLine(preface, 1);
        preface.add(new Paragraph( "La información suministrada en la presente cotización sólo estará vigente el día de hoy.", smallBold));
        
        document.add(preface);
        // Start a new page
//        document.newPage();
    }

    private static void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }

	public String getPdfFileName() {
		return pdfFileName;
	}

}
