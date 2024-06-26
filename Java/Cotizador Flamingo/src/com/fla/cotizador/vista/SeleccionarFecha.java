package com.fla.cotizador.vista;

import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.jdesktop.swingx.JXDatePicker;

public class SeleccionarFecha extends JDialog {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Seleccione la fecha:");
        JPanel panel = new JPanel();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(400, 400, 250, 100);

        JXDatePicker picker = new JXDatePicker();
        picker.setDate(Calendar.getInstance().getTime());
        picker.setFormats(new SimpleDateFormat("dd/MM/yyyy"));
        picker.setBounds(10, 25, 90, 25);

        panel.add(picker);
        frame.getContentPane().add(panel);

        frame.setVisible(true);
}
}