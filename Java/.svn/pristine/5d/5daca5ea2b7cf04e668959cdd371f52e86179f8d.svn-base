package com.fla.cotizador.util;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.xml.datatype.XMLGregorianCalendar;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import co.com.flamingo.clienteRetanqueo.InfoAprobacion;

public class AprobacionRPT {
	private String pdfFileName;
    private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
    private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
    private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
    private static Font monoFont = new Font(Font.FontFamily.COURIER, 12, Font.BOLD);

	Document document = new Document();
	String productoBorrar;
    
    private String almacen;
	private XMLGregorianCalendar fechaAprobacion;
	private XMLGregorianCalendar fechaVencimiento;
	private String nombreCliente;
	private String numeroAprobacion;
	private BigDecimal numeroCuotas;
	private BigDecimal valorAprobacion;
	
	public AprobacionRPT (InfoAprobacion infoAprobacion) {
		
		this.almacen = infoAprobacion.getAlmacen().getValue();
		this.fechaAprobacion = infoAprobacion.getFechaAprobacion();
		this.fechaVencimiento = infoAprobacion.getFechaVence();
		this.nombreCliente = infoAprobacion.getNombreCliente().getValue();
		this.numeroAprobacion = infoAprobacion.getNumeroAprobacion().getValue();
		this.numeroCuotas = infoAprobacion.getNumeroCuotas();
		this.valorAprobacion = infoAprobacion.getValorAprobacion();
		
		pdfFileName = "c:/tmp/cotizacion_" + almacen + Util.getDateTime() + ".pdf";
		crearRPT();
	}

	private void crearRPT() {
		try {
			PdfWriter.getInstance(document, new FileOutputStream(pdfFileName));
			document.open();
            addMetaData(document);
            addTitlePage(document);
//            addContent(document);
            document.close();
		} catch (FileNotFoundException | DocumentException e) {
			e.printStackTrace();
		}
	}

    private static void addMetaData(Document document) {
        document.addTitle("Aprobación de crédito Flamingo");
        document.addSubject("Aprobación de crédito");
        document.addKeywords("Aprobación, Flamingo, Cotizador");
        document.addAuthor(System.getProperty("user.name"));
        document.addCreator("CotizadorFlamingo");
    }
    
    private void addTitlePage(Document document) throws DocumentException {
        Paragraph preface = new Paragraph();

        addEmptyLine(preface, 1);

        preface.add(new Paragraph("APROBACIÓN No. " + numeroAprobacion, catFont));
        preface.add(new Paragraph("FLAMINGO F" + almacen, catFont));

        addEmptyLine(preface, 1);
        preface.add(new Paragraph("Fecha de aprobación: " +  Util.convertXmlGregorianToString(fechaAprobacion), smallBold));

        addEmptyLine(preface, 1);
        preface.add(new Paragraph("Fecha de vigencia: " +  Util.convertXmlGregorianToString(fechaVencimiento), smallBold));

        addEmptyLine(preface, 1);
        preface.add(new Paragraph("Nombre del cliente: " + nombreCliente, smallBold));

        addEmptyLine(preface, 1);
        preface.add(new Paragraph("Valor de la aprobación: " + Util.moneyFormat(valorAprobacion.toString(), 0), smallBold));

        addEmptyLine(preface, 1);
        preface.add(new Paragraph("Número de cuotas: " + numeroCuotas, smallBold));

        String legales = "Para más información consultar en cualquier almacén Flamingo o a través de la línea 018000 181010.";

        addEmptyLine(preface, 1);
        preface.add(new Paragraph(legales, smallBold));
        
        document.add(preface);
    }
    
    private static void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }
    
	public void imprimir() {
		File fCotizacion = new File(pdfFileName);
		try {
//			Desktop.getDesktop().print(fCotizacion);
			Desktop.getDesktop().open(fCotizacion);
		} catch (FileNotFoundException e1) {
			Util.okDialog("Error imprimiendo aprobación", new JFrame(), JOptionPane.ERROR_MESSAGE);
		} catch (IOException e) {
			Util.okDialog("Error imprimiendo aprobación", new JFrame(), JOptionPane.ERROR_MESSAGE);
		}
	}
	
}
