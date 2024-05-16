package com.fgo.gui.tools.keyboard;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import com.fgo.gui.tools.listener.KeyPadEvent;
import com.fgo.gui.tools.listener.KeyPadListener;

public class AlphaNumericSigKeyPad extends JTabbedPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3417470286151267750L;

	private String tabLettersName = "Letras";
	private String tabNumbresName = "Numeros";
	private AlphaSigKeyPad alphaSigKeyPad;
	private NumericSigKeyPad numericSigKeyPad;

	/**
	 * 
	 */
	public AlphaNumericSigKeyPad() {
		super();
		setTabPlacement(JTabbedPane.BOTTOM);
		alphaSigKeyPad = new AlphaSigKeyPad();
		numericSigKeyPad = new NumericSigKeyPad();
		
		addTab(tabLettersName, alphaSigKeyPad);
		addTab(tabNumbresName, numericSigKeyPad);
	}

	/**
	 * 
	 * @param keyPadListener
	 */
	public void addKeyPadListener(final KeyPadListener keyPadListener) {

		alphaSigKeyPad.addKeyPadListener(new KeyPadListener() {
			public void keyPadAction(KeyPadEvent event) {
				keyPadListener.keyPadAction(event);
			}
		});

		numericSigKeyPad.addKeyPadListener(new KeyPadListener() {
			public void keyPadAction(KeyPadEvent event) {
				keyPadListener.keyPadAction(event);
			}
		});
	}

	/**
	 * 
	 * @param tabLettersName
	 */
	public void setTabLettersName(String tabLettersName) {
		this.tabLettersName = tabLettersName;
	}

	/**
	 * 
	 * @param tabNumbresName
	 */
	public void setTabNumbresName(String tabNumbresName) {
		this.tabNumbresName = tabNumbresName;
	}

	/**
	 * 
	 * 
	 * /**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(400, 400);
		frame.setUndecorated(true);
		frame.getContentPane().setLayout(new BorderLayout());
		final JTextField text = new JTextField();
		frame.getContentPane().add(text, BorderLayout.NORTH);

		AlphaNumericSigKeyPad keypad = new AlphaNumericSigKeyPad();
		keypad.addKeyPadListener(new KeyPadListener() {

			public void keyPadAction(KeyPadEvent event) {
				System.out.println(event.getLabel());
			}
		});
		frame.setLocationRelativeTo(null);
		((JPanel)frame.getContentPane()).setBorder(BorderFactory.createLineBorder(Color.black,2));

		frame.getContentPane().add(keypad, BorderLayout.CENTER);
		frame.setVisible(true);
	}

}
