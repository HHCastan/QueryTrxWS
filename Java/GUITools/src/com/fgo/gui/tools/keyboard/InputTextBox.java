package com.fgo.gui.tools.keyboard;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.fgo.gui.tools.stuffs.JPosKeyboard;

public class InputTextBox extends JDialog {


	/**
	 * INICIA DECLARACION DE VARIABLES DE CLASE
	 */

	private static final long serialVersionUID = 1L;

	private static final String CLASS_NAME = "[InputTextBox]";

	/** Panel donde está la casilla de ingreso del valor */
	private JPanel jpGetData = new JPanel();	
	

	/** Text fiel donde se ingresa el dato leido */
	private JTextField txtDataInput;
	
	JPosKeyboard posKeyboard = new JPosKeyboard();

	public static String out = "r::mijiop.out";
//	public static String out = "s:/tmp/mijiop.out";

	/**
	 * FINALIZA DECLARACION DE VARIABLES DE CLASE
	 */

	/**
	 * Create the dialog.
	 */

	public InputTextBox() {
		super(new JFrame(), true);
		
		construyeVentana();
		
		write(CLASS_NAME + " - Clase instanciada correctamente");
		
	}
	
	public String activate(String dato) {
		String txRespuesta = "";
		setTitle(dato);
		posKeyboard.openKeyboard();
		setVisible(true);
		return txRespuesta;
	}
	
	/**
	 * Construye la ventana donde se lee el dato
	 */
	private void construyeVentana() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 10, 268, 100);
		setModal(true);
		
		// El enfoque inicial lo debe tener la casilla de ingreso de datos. Se toma control del Scanner y teclado
		addWindowListener(new WindowAdapter() {
			public void windowActivated(WindowEvent evt) {
				activateWindowAction();
			}
		});
		
		// Se crea casilla para ingreso de codigo
		txtDataInput = new JTextField(20);
		txtDataInput.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
			}

			public void keyReleased(KeyEvent e) {
			}

			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				if (key == KeyEvent.VK_ENTER) {
					write("Se presiona: " + key);
					posKeyboard.closeKeyboard();
					close();
				}
			}
		});
		
		// Se añade al panel
		jpGetData.add(txtDataInput);

		// Se añaden los subPaneles al panel principal.
		getContentPane().add(jpGetData, BorderLayout.CENTER);
	}

	private void activateWindowAction() {
		this.txtDataInput.requestFocus();
	}

	private void close() {
		setVisible(false);
		super.dispose();
	}

	public static void write(String msg) {
		System.out.println(msg);
		BufferedWriter bw = null;
		try {
			FileOutputStream fos = new FileOutputStream(out,true);
			bw = new BufferedWriter(new OutputStreamWriter(fos, "ISO-8859-1"));
			bw.write(msg+"\r\n");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * main
	 * @param args
	 */
	public static void main(String[] args) {
		InputTextBox nkp = new InputTextBox();
		nkp.activate("Ingrese dato: ");
//		write("Valor: [" + nkp.getValue() + "]");
	}
}
