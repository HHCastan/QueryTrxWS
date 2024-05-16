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
import com.fgo.gui.tools.stuffs.Util;
import com.ibm.OS4690.jiop.IOPInitStatus;
import com.ibm.OS4690.jiop.IOPInputQueue;
import com.ibm.OS4690.jiop.IOPReadyEvent;
import com.ibm.OS4690.jiop.IOPReadyListener;
import com.ibm.OS4690.jiop.JIOProcessor;
import com.ibm.OS4690.jiop.LabelInputEvent;
import com.ibm.OS4690.jiop.LabelInputListener;
import com.ibm.OS4690.jiop.POSKeyListenerEx;
import com.ibm.OS4690.jiop.PromptChangeEvent;
import com.ibm.OS4690.jiop.PromptChangeListener;
import com.ibm.OS4690.jiop.QueueStatusChangeEvent;
import com.ibm.OS4690.jiop.QueueStatusChangeListener;

public class InputLabelBox extends JDialog implements Runnable, POSKeyListenerEx, IOPReadyListener, PromptChangeListener, LabelInputListener, QueueStatusChangeListener {

	/**
	 * INICIA DECLARACION DE VARIABLES DE CLASE
	 */
	private static final long serialVersionUID = 1L;

	private static final String CLASS_NAME = "[InputLabelBox]";

	/** Panel donde está la casilla de ingreso del valor */
	private JPanel jpGetData = new JPanel();	
	

	/** Text fiel donde se ingresa el dato leido */
	private JTextField txtDataInput;

	/** Variable para registrar las entradas al log */
	private org.apache.log4j.Logger log = Util.getLogger();

	JPosKeyboard posKeyboard = new JPosKeyboard();

	public JIOProcessor iop;
	public IOPInputQueue iopInputQueue ;
	public static String out = "r::mijiop.out";
	
	/**
	 * FINALIZA DECLARACION DE VARIABLES DE CLASE
	 */

	/**
	 * Create the dialog.
	 */

	public InputLabelBox() {
		super(new JFrame(), true);
		
		construyeVentana();
		
		write(CLASS_NAME + " - Clase instanciada correctamente");
		
	}
	
	
	public void activate(String dato) {
		Thread mainThread = new Thread();
		mainThread.start();
	}
	
	public void run() {

		write ("Input Labe Box starting");
		// Construct the JIOP and listen for Ready
		IOPReadyListener[] iopRListener = new IOPReadyListener[1];
		iopRListener[0] = this;
		iop = new JIOProcessor(iopRListener);
		iopInputQueue = iop.getInputQueue();
		
		iop.addPromptChangeListener(this);
		iopInputQueue.addLabelInputListener(this);
		iopInputQueue.addPOSKeyListenerEx(this);
		iopInputQueue.addQueueStatusListener(this);		
		activateWindowAction();
		super.setVisible(true);
	}
	
	
	/**
	 * Construye la ventana donde se lee el dato
	 */
	private void construyeVentana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 10, 168, 350);
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
				}
			}
		});
		
		// Se añade al panel
		jpGetData.add(txtDataInput);
		// Se añaden los subPaneles al panel principal.
//		getContentPane().add(jpGetData, BorderLayout.NORTH);
		getContentPane().add(jpGetData, BorderLayout.CENTER);
//		getContentPane().add(jpGetData, BorderLayout.SOUTH);
	}

	
	private void activateWindowAction() {
		this.txtDataInput.requestFocus();
	}

	public boolean dataKeyPress(String dato) {
		write("Se presiona: " + dato);
		return false;
	}

	public boolean functionKeyPress(int dato) {
		write("Llega Funcion: " + dato);
		return false;
	}


	public void iopReady(IOPReadyEvent arg0) {
		write("JIOP Ready");
		
	}


	public void iopStatus(IOPInitStatus iops) {
		write(iops.getStatus());
		
	}


	public void invalidKeyedLabel(String ikl) {
		write("Entrada no valida:[" + ikl +"]");
		
	}


	public void labelInput(LabelInputEvent lie) {
		String data = lie.getData();
		if (lie.isScannerInput()){
			write("Entrada desde scaner:[" + data +"]");	
		}else{
			write("Entrada desde teclado:[" + data +"]");
		}
		
	}


	public void promptChanged(PromptChangeEvent pce) {
		write(pce.getPrompt());
		
	}


	public void queueStatusChange(QueueStatusChangeEvent qstatus) {
		if(qstatus.isLocked()){
			write("Cola locked");
		}
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
}
