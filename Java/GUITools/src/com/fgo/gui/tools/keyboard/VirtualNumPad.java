package com.fgo.gui.tools.keyboard;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class VirtualNumPad extends JDialog implements MouseListener {
	JTextField display;
	JButton b1;
	JButton b2;
	JButton b3;
	JButton b4;
	JButton b5;
	JButton b6;
	JButton b7;
	JButton b8;
	JButton b9;
	JButton b0;
	JButton clear;
	JButton aceptar;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public VirtualNumPad(JDialog dialogo) {
		super(new JFrame(), true);
		display = new JTextField();
		// JFrame frame = new JFrame("Teclado Num�rico");
		setTitle("Teclado Numérico");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		setLocationRelativeTo(dialogo);
		
		construyeVentana();
	}

	public VirtualNumPad() {
		super(new JFrame(), true);
		display = new JTextField();
		// JFrame frame = new JFrame("Teclado Num�rico");
		setTitle("Teclado Numérico");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		
		construyeVentana();
	}

	private void construyeVentana() {
		display.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
			}

			public void keyReleased(KeyEvent e) {
			}

			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				System.out.println("Tecla presionada: " + key);
				if (key == KeyEvent.VK_ENTER) {
					close();
				} else {
					agregarAction(e.getKeyChar());
				}
			}

		});
		display.setFont(new Font("monospaced", Font.BOLD, 20));
		display.setEditable(false);
		display.setHorizontalAlignment(JTextField.RIGHT);
		getContentPane().add(display, BorderLayout.NORTH);

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(4, 3));
		panel.setBorder(BorderFactory.createLineBorder(Color.gray, 3));
		panel.setBackground(Color.white);

		b1 = new JButton("1");
		b2 = new JButton("2");
		b3 = new JButton("3");
		b4 = new JButton("4");
		b5 = new JButton("5");
		b6 = new JButton("6");
		b7 = new JButton("7");
		b8 = new JButton("8");
		b9 = new JButton("9");
		b0 = new JButton("0");
		clear = new JButton("Borrar");
		aceptar = new JButton("Aceptar");

		adicionaListeners();

		panel.add(b1);
		panel.add(b2);
		panel.add(b3);
		panel.add(b4);
		panel.add(b5);
		panel.add(b6);
		panel.add(b7);
		panel.add(b8);
		panel.add(b9);
		panel.add(b0);
		panel.add(clear);
		panel.add(aceptar, BorderLayout.SOUTH);

		getContentPane().add(panel);

		
		pack();
		
	}

   private void agregarAction() {
	// TODO Auto-generated method stub
   }

	private void agregarAction(char keyChar) {
		display.setText(display.getText() + keyChar);
		
	}

   private void adicionaListeners() {
		b1.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseReleased(java.awt.event.MouseEvent evt) {
				String cadena = display.getText() + '1';
				display.setText(cadena);
			}
		});

		b2.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseReleased(java.awt.event.MouseEvent evt) {
				String cadena = display.getText() + '2';
				display.setText(cadena);
			}
		});

		b3.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseReleased(java.awt.event.MouseEvent evt) {
				String cadena = display.getText() + '3';
				display.setText(cadena);
			}
		});

		b4.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseReleased(java.awt.event.MouseEvent evt) {
				String cadena = display.getText() + '4';
				display.setText(cadena);
			}
		});

		b5.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseReleased(java.awt.event.MouseEvent evt) {
				String cadena = display.getText() + '5';
				display.setText(cadena);
			}
		});

		b6.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseReleased(java.awt.event.MouseEvent evt) {
				String cadena = display.getText() + '6';
				display.setText(cadena);
			}
		});

		b7.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseReleased(java.awt.event.MouseEvent evt) {
				String cadena = display.getText() + '7';
				display.setText(cadena);
			}
		});

		b8.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseReleased(java.awt.event.MouseEvent evt) {
				String cadena = display.getText() + '8';
				display.setText(cadena);
			}
		});

		b9.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseReleased(java.awt.event.MouseEvent evt) {
				String cadena = display.getText() + '9';
				display.setText(cadena);
			}
		});

		b0.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseReleased(java.awt.event.MouseEvent evt) {
				String cadena = display.getText() + '0';
				display.setText(cadena);
			}
		});

		clear.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseReleased(java.awt.event.MouseEvent evt) {
				display.setText("");
			}
		});

		aceptar.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseReleased(java.awt.event.MouseEvent evt) {
				close();
			}
		});
	}

	public void mouseClicked(MouseEvent arg0) {
	}

	public void mouseEntered(MouseEvent arg0) {
	}

	public void mouseExited(MouseEvent arg0) {
	}

	public void mousePressed(MouseEvent arg0) {
	}

	public void mouseReleased(MouseEvent arg0) {
	}

	public void setVisible(boolean b) {
		if (b) {
			display.setText("");
		}
		super.setVisible(b);
	}
	
	private void close() {
		setVisible(false);
		super.dispose();
	}
	
	public String getValue() {
		return display.getText();
	}

	public static void main(String[] args) {
		VirtualNumPad nkp = new VirtualNumPad();
		nkp.setVisible(true);
		System.out.println("Valor: [" + nkp.getValue() + "]");
	}
}