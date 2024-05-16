package com.fgo.gui.tools.keyboard;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;

import com.fgo.gui.tools.listener.KeyPadEvent;
import com.fgo.gui.tools.listener.KeyPadListener;

/**
 * 
 * @author fvelez
 * 
 */
public abstract class SigKeyPad extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public SigKeyPad() {
		GridBagLayout gridbag = new GridBagLayout();
		setLayout(gridbag);
		buildButons();
	}

	/**
	 * 
	 */
	protected abstract void buildButons();

	/**
	 * 
	 */
	protected abstract void addKeyPadListener(KeyPadListener keyPadListener);

	/**
	 * 
	 * @param button
	 * @param gridx
	 * @param gridy
	 * @param gridwidth
	 * @param gridheight
	 * @param fill
	 */
	protected void addButton(JComponent button, int gridx, int gridy, int gridwidth, int gridheight, int fill, double weightx, double weighty) {
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = gridx;
		constraints.gridy = gridy;
		constraints.gridwidth = gridwidth;
		constraints.gridheight = gridheight;
		constraints.weightx = weightx;
		constraints.weighty = weighty;
		constraints.fill = fill;
		add(button, constraints);
	}

	/**
	 * 
	 * @param button
	 * @param keyPadListener
	 */
	protected void addButtonAction(final JButton button, final KeyPadListener keyPadListener, final String label) {
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KeyPadEvent keyPadEvent = new KeyPadEvent();
				keyPadEvent.setLabel(label);
				keyPadEvent.setButton(button);
				keyPadListener.keyPadAction(keyPadEvent);
			}
		});
	}

}
