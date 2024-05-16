package com.fla.cotizador.vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import org.apache.log4j.Logger;

import com.fla.cotizador.controlador.Coordinador;
import com.fla.cotizador.modelo.Usuario;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPasswordField;

public class VentanaIngreso extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel panelLogin = new JPanel();
	private JTextField txUsuario;
	private JPasswordField txPassword;
	private Coordinador coordinador;
	private JButton okButton;
	private JButton cancelButton;
	private final String APLICACION = "COTIZADOR";
	Usuario usuario;
	private Logger log;
	private Font fontPlain = new Font("SansSerif", Font.PLAIN, 16);

	public VentanaIngreso(JFrame parent, boolean modal) {
		super(parent, modal);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		initComponents();
		setLocationRelativeTo(null);
	}

	/**
	 * Create the dialog.
	 * 
	 * @return
	 */
	public void initComponents() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaIngreso.class.getResource("/images/Icono_Flamingo.png")));
		setTitle("Inicio de sesión");
		setBounds(100, 100, 376, 200);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(panelLogin, BorderLayout.CENTER);
		panelLogin.setLayout(null);
		{
			JLabel lblCodigoUsuario = new JLabel("Cédula del usuario:");
			lblCodigoUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblCodigoUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
			lblCodigoUsuario.setBounds(10, 26, 120, 30);
			panelLogin.add(lblCodigoUsuario);
		}

		txUsuario = new JTextField();
		txUsuario.setBounds(146, 26, 200, 30);
		txUsuario.setFont(fontPlain);
		panelLogin.add(txUsuario);
		txUsuario.setColumns(10);

		JLabel lblContrasea = new JLabel("Contraseña:");
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblContrasea.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContrasea.setBounds(10, 83, 120, 30);
		panelLogin.add(lblContrasea);

		txPassword = new JPasswordField();
		txPassword.setBounds(146, 83, 200, 30);
		panelLogin.add(txPassword);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("Validar");
				okButton.setActionCommand("OK");
				okButton.addActionListener(this);
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancelar");
				cancelButton.setActionCommand("Cancel");
				cancelButton.addActionListener(this);
				buttonPane.add(cancelButton);
			}
		}
	}

	public void setCoordinador(Coordinador coordinador) {
		this.coordinador = coordinador;

	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		if (evento.getSource() == okButton) {
			// Si presionó Enter si ingresar el usuario:
			if (txUsuario.getText().length() == 0) {
				txUsuario.requestFocus();
				return;
			}
			
			// Si presionó Enter sin ingresar la contraseña:
			if (txPassword.getPassword().length == 0) {
				txPassword.requestFocus();
				return;
			}

			String sUsuario = txUsuario.getText();
			String sPassword = new String(txPassword.getPassword());

			usuario = coordinador.validarIngreso(sUsuario, sPassword, APLICACION);

			if (usuario.getCedula() == null) {
				JOptionPane.showMessageDialog(null, "Usuario o contraseña no válido");
				log.info("Intento de ingreso fallido con usuario: " + sUsuario);
				return;
			}
//				JOptionPane.showMessageDialog(null, "Bien venido " + usuario.getNombre());
			log.info("Ingreso satisfactorio con usuario: " + sUsuario);
			coordinador.asignarPrivilegios(usuario);
			coordinador.cerrarVentanaIngreso();
		}

		if (evento.getSource() == cancelButton) {
			coordinador.cerrarSistema();
		}
	}

	public void setLog(Logger log) {
		this.log = log;
	}
}
