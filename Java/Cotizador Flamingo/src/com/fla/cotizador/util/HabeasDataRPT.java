package com.fla.cotizador.util;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.apache.log4j.Logger;

import com.fla.cotizador.modelo.NewCustomer;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;

public class HabeasDataRPT {
	private String pdfFileName;
    private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
    private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
    private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 11, Font.BOLD);
    private static Font normalFont = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL);

    private String nombre;
    private String clienteID;
    
    private Logger log = Util.getLogger();

    Document document = new Document(PageSize.LEGAL);
	
	public HabeasDataRPT(NewCustomer newCustomer) {
		this.clienteID = newCustomer.getCliente();
		this.nombre = newCustomer.getNombreCompleto();
		pdfFileName = "c:/tmp/" + clienteID + "_HabeasData_" + Util.getDateTime() + ".pdf";
		crearDocumentoHabeasData();
	}
	
	public void imprimir() {
		File fHabeasData = new File(pdfFileName);
		Util.backupFile(pdfFileName);
		try {
			Desktop.getDesktop().open(fHabeasData);
		} catch (FileNotFoundException e1) {
			Util.okDialog("Error generando archivo de Habeas Data", new JFrame(), JOptionPane.ERROR_MESSAGE);
		} catch (IOException e) {
			Util.okDialog("Error generando archivo de Habeas Data", new JFrame(), JOptionPane.ERROR_MESSAGE);
		}
	}

	private void crearDocumentoHabeasData() {
		try {
			HeaderFooterPageEvent event = new HeaderFooterPageEvent();
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(pdfFileName));
			writer.setPageEvent(event);
			
			document.open();
			document.newPage();
			document.add(new Chunk(""));
            addMetaData();
            addTitlePage();
            addContent();
            document.close();
		} catch (FileNotFoundException | DocumentException e) {
			log.error("No puede abrir texto guía del Habeas Daata");
		} catch (IOException e) {
			log.error("No puede abrir archivo con la fuente");
		}
		
	}
	
	// iText allows to add metadata to the PDF which can be viewed in your Adobe
    // Reader
    // under File -> Properties
    private void addMetaData() {
        document.addTitle("Habeas Data Flamingo");
        document.addSubject("Formato de autorización para la administración de información comercial, creditica, financiera, personal y de servicios");
        document.addKeywords("Cotización, Flamingo, habeas data");
        document.addAuthor("hcastaneda");
        document.addCreator("CotizadorFlamingo");
    }
    
    private  void addTitlePage() throws DocumentException {
    	Image logoFlamingo = Util.getLogoFlamingo();
    	
        Paragraph preface = new Paragraph();
        preface.add(new Paragraph("FORMATO DE AUTORIZACIÓN PARA LA ADMINISTRACIÓN\nDE INFORMACIÓN COMERCIAL, CREDITICIA, FINANCIERA, PERSONAL Y DE SERVICIOS", smallBold));

        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(100);
        table.setWidths(new int[]{15, 70, 15});
        PdfPCell cell1 = new PdfPCell(logoFlamingo, true);
        cell1.setBorder(Rectangle.NO_BORDER);
        PdfPCell cell2 = new PdfPCell(preface);
        cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell2.setBorder(Rectangle.NO_BORDER);
        PdfPCell cell3 = new PdfPCell(new Paragraph(Util.getDate() + " " + Util.getTime(), smallBold));
        cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell3.setVerticalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell1);
        table.addCell(cell2);
        table.addCell(cell3);
        document.add(table);

    }

    private void addContent() throws DocumentException {
    	Paragraph preface = new Paragraph();
    	preface.setAlignment(Element.ALIGN_JUSTIFIED);
    	preface.setLeading(0, 1);
    	String line;
        try {
        	BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/properties/HabeasData.txt"),"UTF-8"));
			while ((line = br.readLine()) != null) {
				preface.add(new Paragraph(line, normalFont));
			}
	        br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
        addEmptyLine(preface, 3);
        preface.add(new Paragraph( "Firma Cliente:  ___________________________", smallBold));
        addEmptyLine(preface, 1);
        preface.add(new Paragraph( "Nombre: " + this.nombre, smallBold));
        addEmptyLine(preface, 1);
        preface.add(new Paragraph( "C.C:    " + this.clienteID + " de ____________", smallBold));
        addEmptyLine(preface, 1);
        preface.add(new Paragraph( "Ciudad: __________________________________", smallBold));
        addEmptyLine(preface, 3);
        preface.add(new Paragraph( "Firma Asesor:  ___________________________", smallBold));
        addEmptyLine(preface, 1);
        preface.add(new Paragraph( "Usuario Asesor: " + System.getProperty("user.name"), smallBold));
        document.add(preface);
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
