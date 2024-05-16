package com.fgo.gui.tools.keyboard;

import java.awt.GridBagConstraints;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.fgo.gui.tools.listener.KeyPadListener;

/**
 * 
 * @author fvelez
 * 
 */
public class NumericSigKeyPad extends SigKeyPad {

	public static final String ENTER_LABEL = "ENTER";
	public static final String BKSPACE_LABEL = "BKSPACE";
	public static final String LABEL_1 = "1";
	public static final String LABEL_2 = "2";
	public static final String LABEL_3 = "3";
	public static final String LABEL_4 = "4";
	public static final String LABEL_5 = "5";
	public static final String LABEL_6 = "6";
	public static final String LABEL_7 = "7";
	public static final String LABEL_8 = "8";
	public static final String LABEL_9 = "9";
	public static final String LABEL_0 = "0";
	public static final String LABEL_00 = "00";
	public static final String LABEL_P = ".";

	/**
	 * 
	 */
	private static final long serialVersionUID = 1089240451718555654L;

	private JButton button0;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	private JButton button6;
	private JButton button7;
	private JButton button8;
	private JButton button9;
	private JButton button00;
	private JPanel margen;
	private JButton buttonE;
	private JButton buttonP;
	private JButton buttonBkSpa;

	/**
	 * 
	 */
	public NumericSigKeyPad() {
		super();
	}

	/**
	 * 
	 */
	public void buildButons() {
		button7 = new JButton("7");
		button8 = new JButton("8");
		button9 = new JButton("9");
		button4 = new JButton("4");
		button5 = new JButton("5");
		button6 = new JButton("6");
		button1 = new JButton("1");
		button2 = new JButton("2");
		button3 = new JButton("3");
		buttonP = new JButton(".");
		button0 = new JButton("0");
		button00 = new JButton("00");
		buttonBkSpa = new JButton("Backspace");
		buttonE = new JButton("Enter");
		margen = new JPanel();

		addButton(button7, 0, 0, 1, 1, GridBagConstraints.BOTH, 1, 1);
		addButton(button8, 1, 0, 1, 1, GridBagConstraints.BOTH, 1, 1);
		addButton(button9, 2, 0, 1, 1, GridBagConstraints.BOTH, 1, 1);

		addButton(button4, 0, 1, 1, 1, GridBagConstraints.BOTH, 1, 1);
		addButton(button5, 1, 1, 1, 1, GridBagConstraints.BOTH, 1, 1);
		addButton(button6, 2, 1, 1, 1, GridBagConstraints.BOTH, 1, 1);

		addButton(button1, 0, 2, 1, 1, GridBagConstraints.BOTH, 1, 1);
		addButton(button2, 1, 2, 1, 1, GridBagConstraints.BOTH, 1, 1);
		addButton(button3, 2, 2, 1, 1, GridBagConstraints.BOTH, 1, 1);

		addButton(buttonP, 0, 3, 1, 1, GridBagConstraints.BOTH, 1, 1);
		addButton(button0, 1, 3, 1, 1, GridBagConstraints.BOTH, 1, 1);
		addButton(button00, 2, 3, 1, 1, GridBagConstraints.BOTH, 1, 1);

		addButton(margen, 3, 0, 1, 4, GridBagConstraints.BOTH, 0.0, 0.0);
		
		addButton(buttonBkSpa, 4, 0, 1, 2, GridBagConstraints.BOTH, 0.0, 0.0);
		addButton(buttonE, 4, 2, 1, 2, GridBagConstraints.BOTH, 0.0, 0.0);
	}

	/**
	 * 
	 * @param keyPadListener
	 */
	public void addKeyPadListener(KeyPadListener keyPadListener) {
		addButtonAction(button7, keyPadListener, NumericSigKeyPad.LABEL_7);
		addButtonAction(button8, keyPadListener, NumericSigKeyPad.LABEL_8);
		addButtonAction(button9, keyPadListener, NumericSigKeyPad.LABEL_9);
		addButtonAction(button4, keyPadListener, NumericSigKeyPad.LABEL_4);
		addButtonAction(button5, keyPadListener, NumericSigKeyPad.LABEL_5);
		addButtonAction(button6, keyPadListener, NumericSigKeyPad.LABEL_6);
		addButtonAction(button1, keyPadListener, NumericSigKeyPad.LABEL_1);
		addButtonAction(button2, keyPadListener, NumericSigKeyPad.LABEL_2);
		addButtonAction(button3, keyPadListener, NumericSigKeyPad.LABEL_3);
		addButtonAction(buttonP, keyPadListener, NumericSigKeyPad.LABEL_P);
		addButtonAction(button0, keyPadListener, NumericSigKeyPad.LABEL_0);
		addButtonAction(button00, keyPadListener, NumericSigKeyPad.LABEL_00);
		addButtonAction(buttonBkSpa, keyPadListener, NumericSigKeyPad.BKSPACE_LABEL);
		addButtonAction(buttonE, keyPadListener, NumericSigKeyPad.ENTER_LABEL);
	}

}
