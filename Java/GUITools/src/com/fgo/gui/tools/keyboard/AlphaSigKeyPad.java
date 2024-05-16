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
public class AlphaSigKeyPad extends SigKeyPad {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8232377249541840452L;

	private JButton buttonA;
	private JButton buttonB;
	private JButton buttonC;
	private JButton buttonD;
	private JButton buttonE;
	private JButton buttonF;
	private JButton buttonG;
	private JButton buttonH;
	private JButton buttonI;
	private JButton buttonJ;
	private JButton buttonK;
	private JButton buttonL;
	private JButton buttonM;
	private JButton buttonN;
	private JButton buttonÑ;
	private JButton buttonO;
	private JButton buttonP;
	private JButton buttonQ;
	private JButton buttonR;
	private JButton buttonS;
	private JButton buttonT;
	private JButton buttonU;
	private JButton buttonV;
	private JButton buttonW;
	private JButton buttonX;
	private JButton buttonY;
	private JButton buttonZ;
	private JPanel margen;
	private JButton buttonSpa;
	private JButton buttonBkSpa;
//	private JButton buttonCle;
	private JButton buttonEnt;
	private JButton buttonPoi;
	private JButton buttonLin;
	private JButton buttonCom;

	public static final String LABEL_A = "A";
	public static final String LABEL_B = "B";
	public static final String LABEL_C = "C";
	public static final String LABEL_D = "D";
	public static final String LABEL_E = "E";
	public static final String LABEL_F = "F";
	public static final String LABEL_G = "G";
	public static final String LABEL_H = "H";
	public static final String LABEL_I = "I";
	public static final String LABEL_J = "J";
	public static final String LABEL_K = "K";
	public static final String LABEL_L = "L";
	public static final String LABEL_M = "M";
	public static final String LABEL_N = "N";
	public static final String LABEL_Ñ = "Ñ";
	public static final String LABEL_O = "O";
	public static final String LABEL_P = "P";
	public static final String LABEL_Q = "Q";
	public static final String LABEL_R = "R";
	public static final String LABEL_S = "S";
	public static final String LABEL_T = "T";
	public static final String LABEL_U = "U";
	public static final String LABEL_V = "V";
	public static final String LABEL_W = "W";
	public static final String LABEL_X = "X";
	public static final String LABEL_Y = "Y";
	public static final String LABEL_Z = "Z";

	public static final String ENTER_LABEL = "ENTER";
	public static final String CLEAR_LABEL = "CLEAR";
	public static final String SPACE_LABEL = "SPACE";
	public static final String BKSPACE_LABEL = "BKSPACE";
	public static final String POINT_LABEL = ".";
	public static final String LINE_LABEL = "-";
	public static final String ARROBA_LABEL = "@";

	/**
	 * 
	 */
	public AlphaSigKeyPad() {
		super();
	}

	/**
	 * 
	 */
	protected void buildButons() {
		buttonA = new JButton("A");
		buttonB = new JButton("B");
		buttonC = new JButton("C");
		buttonD = new JButton("D");
		buttonE = new JButton("E");
		buttonF = new JButton("F");
		buttonG = new JButton("G");
		buttonH = new JButton("H");
		buttonI = new JButton("I");
		buttonJ = new JButton("J");
		buttonK = new JButton("K");
		buttonL = new JButton("L");
		buttonM = new JButton("M");
		buttonN = new JButton("N");
		buttonÑ = new JButton("Ñ");
		buttonO = new JButton("O");
		buttonP = new JButton("P");
		buttonQ = new JButton("Q");
		buttonR = new JButton("R");
		buttonS = new JButton("S");
		buttonT = new JButton("T");
		buttonU = new JButton("U");
		buttonV = new JButton("V");
		buttonW = new JButton("W");
		buttonX = new JButton("X");
		buttonY = new JButton("Y");
		buttonZ = new JButton("Z");
		buttonBkSpa = new JButton("Backspace");
		buttonSpa = new JButton("Espacio");
		//buttonCle = new JButton("Limpiar");
		buttonEnt = new JButton("Enter");
		buttonPoi = new JButton(".");
		buttonLin = new JButton("-");
		buttonCom = new JButton("@");
		margen = new JPanel();

		addButton(buttonQ, 0, 0, 1, 1, GridBagConstraints.BOTH, 1, 1);
		addButton(buttonW, 1, 0, 1, 1, GridBagConstraints.BOTH, 1, 1);
		addButton(buttonE, 2, 0, 1, 1, GridBagConstraints.BOTH, 1, 1);
		addButton(buttonR, 3, 0, 1, 1, GridBagConstraints.BOTH, 1, 1);
		addButton(buttonT, 4, 0, 1, 1, GridBagConstraints.BOTH, 1, 1);
		addButton(buttonY, 5, 0, 1, 1, GridBagConstraints.BOTH, 1, 1);
		addButton(buttonU, 6, 0, 1, 1, GridBagConstraints.BOTH, 1, 1);
		addButton(buttonI, 7, 0, 1, 1, GridBagConstraints.BOTH, 1, 1);
		addButton(buttonO, 8, 0, 1, 1, GridBagConstraints.BOTH, 1, 1);
		addButton(buttonP, 9, 0, 1, 1, GridBagConstraints.BOTH, 1, 1);

		addButton(buttonA, 0, 1, 1, 1, GridBagConstraints.BOTH, 1, 1);
		addButton(buttonS, 1, 1, 1, 1, GridBagConstraints.BOTH, 1, 1);
		addButton(buttonD, 2, 1, 1, 1, GridBagConstraints.BOTH, 1, 1);
		addButton(buttonF, 3, 1, 1, 1, GridBagConstraints.BOTH, 1, 1);
		addButton(buttonG, 4, 1, 1, 1, GridBagConstraints.BOTH, 1, 1);
		addButton(buttonH, 5, 1, 1, 1, GridBagConstraints.BOTH, 1, 1);
		addButton(buttonJ, 6, 1, 1, 1, GridBagConstraints.BOTH, 1, 1);
		addButton(buttonK, 7, 1, 1, 1, GridBagConstraints.BOTH, 1, 1);
		addButton(buttonL, 8, 1, 1, 1, GridBagConstraints.BOTH, 1, 1);
		addButton(buttonÑ, 9, 1, 1, 1, GridBagConstraints.BOTH, 1, 1);

		addButton(buttonZ, 0, 2, 1, 1, GridBagConstraints.BOTH, 1, 1);
		addButton(buttonX, 1, 2, 1, 1, GridBagConstraints.BOTH, 1, 1);
		addButton(buttonC, 2, 2, 1, 1, GridBagConstraints.BOTH, 1, 1);
		addButton(buttonV, 3, 2, 1, 1, GridBagConstraints.BOTH, 1, 1);
		addButton(buttonB, 4, 2, 1, 1, GridBagConstraints.BOTH, 1, 1);
		addButton(buttonN, 5, 2, 1, 1, GridBagConstraints.BOTH, 1, 1);
		addButton(buttonM, 6, 2, 1, 1, GridBagConstraints.BOTH, 1, 1);
		addButton(buttonPoi, 7, 2, 1, 1, GridBagConstraints.BOTH, 1, 1);
		addButton(buttonLin, 8, 2, 1, 1, GridBagConstraints.BOTH, 1, 1);
		addButton(buttonCom, 9, 2, 1, 1, GridBagConstraints.BOTH, 1, 1);

		addButton(margen, 10, 0, 1, 4, GridBagConstraints.BOTH, 0.0, 0.0);

		addButton(buttonBkSpa, 11, 0, 1, 1, GridBagConstraints.BOTH, 0.0, 0.0);
		addButton(buttonSpa,   11, 1, 1, 1, GridBagConstraints.BOTH, 0.0, 0.0);
		addButton(buttonEnt,   11, 2, 1, 1, GridBagConstraints.BOTH, 0.0, 0.0);
	}

	/**
	 * 
	 */
	protected void addKeyPadListener(KeyPadListener keyPadListener) {
		addButtonAction(buttonA, keyPadListener, AlphaSigKeyPad.LABEL_A);
		addButtonAction(buttonB, keyPadListener, AlphaSigKeyPad.LABEL_B);
		addButtonAction(buttonC, keyPadListener, AlphaSigKeyPad.LABEL_C);
		addButtonAction(buttonD, keyPadListener, AlphaSigKeyPad.LABEL_D);
		addButtonAction(buttonE, keyPadListener, AlphaSigKeyPad.LABEL_E);
		addButtonAction(buttonF, keyPadListener, AlphaSigKeyPad.LABEL_F);
		addButtonAction(buttonG, keyPadListener, AlphaSigKeyPad.LABEL_G);
		addButtonAction(buttonH, keyPadListener, AlphaSigKeyPad.LABEL_H);
		addButtonAction(buttonI, keyPadListener, AlphaSigKeyPad.LABEL_I);
		addButtonAction(buttonJ, keyPadListener, AlphaSigKeyPad.LABEL_J);
		addButtonAction(buttonK, keyPadListener, AlphaSigKeyPad.LABEL_K);
		addButtonAction(buttonL, keyPadListener, AlphaSigKeyPad.LABEL_L);
		addButtonAction(buttonM, keyPadListener, AlphaSigKeyPad.LABEL_M);
		addButtonAction(buttonN, keyPadListener, AlphaSigKeyPad.LABEL_N);
		addButtonAction(buttonÑ, keyPadListener, AlphaSigKeyPad.LABEL_Ñ);
		addButtonAction(buttonO, keyPadListener, AlphaSigKeyPad.LABEL_O);
		addButtonAction(buttonP, keyPadListener, AlphaSigKeyPad.LABEL_P);
		addButtonAction(buttonQ, keyPadListener, AlphaSigKeyPad.LABEL_Q);
		addButtonAction(buttonR, keyPadListener, AlphaSigKeyPad.LABEL_R);
		addButtonAction(buttonS, keyPadListener, AlphaSigKeyPad.LABEL_S);
		addButtonAction(buttonT, keyPadListener, AlphaSigKeyPad.LABEL_T);
		addButtonAction(buttonU, keyPadListener, AlphaSigKeyPad.LABEL_U);
		addButtonAction(buttonV, keyPadListener, AlphaSigKeyPad.LABEL_V);
		addButtonAction(buttonW, keyPadListener, AlphaSigKeyPad.LABEL_W);
		addButtonAction(buttonX, keyPadListener, AlphaSigKeyPad.LABEL_X);
		addButtonAction(buttonY, keyPadListener, AlphaSigKeyPad.LABEL_Y);
		addButtonAction(buttonZ, keyPadListener, AlphaSigKeyPad.LABEL_Z);

		addButtonAction(buttonPoi, keyPadListener, AlphaSigKeyPad.POINT_LABEL);
		addButtonAction(buttonLin, keyPadListener, AlphaSigKeyPad.LINE_LABEL);
		addButtonAction(buttonCom, keyPadListener, AlphaSigKeyPad.ARROBA_LABEL);

		addButtonAction(buttonBkSpa, keyPadListener, AlphaSigKeyPad.BKSPACE_LABEL);
		addButtonAction(buttonSpa, keyPadListener, AlphaSigKeyPad.SPACE_LABEL);
		addButtonAction(buttonEnt, keyPadListener, AlphaSigKeyPad.ENTER_LABEL);
	}

}
