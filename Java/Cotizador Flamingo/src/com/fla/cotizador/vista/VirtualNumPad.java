package com.fla.cotizador.vista;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.SoftBevelBorder;
import javax.swing.text.DefaultEditorKit;
import javax.swing.text.JTextComponent;
import javax.swing.text.TextAction;

import com.fla.cotizador.util.Util;


public class VirtualNumPad extends JDialog implements MouseListener {
	private JTextField display;
	private JButton clearBtn;
	private JButton enterBtn;
	private JButton backspaceBtn;
	private JPanel buttonPanel;
    private Border raisedBorder = new SoftBevelBorder(SoftBevelBorder.RAISED);
    private Border loweredBorder = new SoftBevelBorder(SoftBevelBorder.LOWERED);

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public VirtualNumPad(JFrame ventana) {
		super(ventana, true);
		setLayout(new BorderLayout());
//		setLocationRelativeTo(ventana);
		
		setTitle("Teclado Numérico");
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/Icono_Flamingo.png")));
		setModal(true);
		display = new JTextField();

		construyeVentana();
	}

	private void construyeVentana() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if (getLongValue() > 0)
					close();
				else if (display.getText().equalsIgnoreCase("hcnm")) {
					Util.imageDialog(new JFrame(), "/images/Huvo de Pascua.png");
					display.setText("");
				} else 
					Util.okDialog("Solo valores numéricos positivos!", new JFrame(), JOptionPane.ERROR_MESSAGE);
			}
		});
		
		
		display.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
			}

			public void keyReleased(KeyEvent e) {
			}

			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				if (key == KeyEvent.VK_ENTER) {
					if (getLongValue() > 0)
						close();
					else {
						Util.okDialog("Solo valores numéricos positivos!", new JFrame(), JOptionPane.ERROR_MESSAGE);
					}
				} 
			}

		});
//		display.setEditable(false);
		display.setHorizontalAlignment(JTextField.RIGHT);
		display.setFont(new Font("SansSerif", Font.BOLD, 26));
		display.setPreferredSize(new Dimension(0, 50));
		display.setBorder(loweredBorder);
		TextFieldPopup();
		getContentPane().add(display, BorderLayout.NORTH);

		// Make button panel
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(5, 3));

		// Add digit buttons
		addButton("7");
		addButton("8");
		addButton("9");
		addButton("4");
		addButton("5");
		addButton("6");
		addButton("1");
		addButton("2");
		addButton("3");
		addButton("0");
		addButton("00");
		addButton(".");

		clearBtn = new JButton();
		clearBtn.setIcon(new ImageIcon(this.getClass().getResource("/images/Clear32.png")));
		enterBtn = new JButton();
		enterBtn.setIcon(new ImageIcon(this.getClass().getResource("/images/check32.png")));
		backspaceBtn = new JButton();
		backspaceBtn.setIcon(new ImageIcon(this.getClass().getResource("/images/BackSpace32.png")));

		adicionaListeners();

		buttonPanel.add(backspaceBtn, BorderLayout.SOUTH);
		buttonPanel.add(clearBtn, BorderLayout.SOUTH);
		buttonPanel.add(enterBtn, BorderLayout.SOUTH);

		add(buttonPanel, "Center");

		pack();
	}

	private void addButton(final String label) {
		class DigitButtonListener implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				// Don't add two decimal points
				if (label.equals(".") && display.getText().indexOf(".") != -1)
					return;

				// Append label text to button
				display.setText(display.getText() + label);
			}
		}
		JButton button = new JButton(label);
		button.setPreferredSize(new Dimension(40, 60));
		button.setBorder(raisedBorder);
		button.setFont(new Font("SansSerif", Font.BOLD, 28));
		buttonPanel.add(button);
		ActionListener listener = new DigitButtonListener();
		button.addActionListener(listener);
	}

	private void agregarAction(char keyChar) {
		display.setText(display.getText() + keyChar);
	}

	private void adicionaListeners() {
		clearBtn.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseReleased(java.awt.event.MouseEvent evt) {
				display.setText("");
				display.requestFocus();
			}
		});

		enterBtn.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseReleased(java.awt.event.MouseEvent evt) {
				if (getLongValue() > 0)
					close();
				else {
					Util.okDialog("Solo valores numéricos positivos!", new JFrame(), JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		backspaceBtn.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseReleased(java.awt.event.MouseEvent evt) {
				String s = display.getText();
				s = s.substring(0,s.length() - 1);
				display.setText(s);
				display.requestFocus();
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

	public void setVisible(boolean b, String text) {
		if (b) {
			this.display.setText(text);
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

	public int getIntegerValue() {
		if (Util.isNumeric(display.getText()))
				return Integer.parseInt(display.getText());
		else
			return 0;
	}
	
	public long getLongValue() {
		// Si se escanea la cédula
		if (display.getText().indexOf('|') > 0) {
			String cedula = display.getText().substring(0,display.getText().indexOf('|'));
			// Elimina ceros a la izquierda:
			cedula = cedula.replaceFirst("^0+(?!$)", "");
			display.setText(cedula);
		}
		if (Util.isNumeric(display.getText()))
			return Long.parseLong(display.getText());
	else
		return 0;
	}

	public void setValue(String text) {
		this.display.setText(text);
	}

	private void TextFieldPopup() {
		add(display);

		JPopupMenu menu = new JPopupMenu();
		Action cut = new DefaultEditorKit.CutAction();
		cut.putValue(Action.NAME, "Cortar");
		cut.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("control X"));
		menu.add(cut);

		Action copy = new DefaultEditorKit.CopyAction();
		copy.putValue(Action.NAME, "Copiar");
		copy.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("control C"));
		menu.add(copy);

		Action paste = new DefaultEditorKit.PasteAction();
		paste.putValue(Action.NAME, "Pegar");
		paste.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("control V"));
		menu.add(paste);

		Action selectAll = new SelectAll();
		menu.add(selectAll);

		display.setComponentPopupMenu(menu);
	}
	
	public static void main(String[] args) {
		VirtualNumPad nkp = new VirtualNumPad(new JFrame());
		nkp.setVisible(true);
		System.out.println("Valor: [" + nkp.getValue() + "]");
	}

	/**
	 * Esta clase 
	 * @author hcastaneda
	 *
	 */

	class SelectAll extends TextAction {
		private static final long serialVersionUID = 1L;

		public SelectAll() {
			super("Seleccionar todo");
			putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("control S"));
		}

		public void actionPerformed(ActionEvent e) {
			JTextComponent component = getFocusedComponent();
			component.selectAll();
			component.requestFocusInWindow();
		}
	}
}