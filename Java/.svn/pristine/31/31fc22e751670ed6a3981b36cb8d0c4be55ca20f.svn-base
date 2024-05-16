package com.fgo.gui.tools.keyboard;

import com.ibm.sureview.factory.FactoryTable;
import com.ibm.sureview.factory.I18NDynamicFactory;
import com.ibm.sureview.factory.I18NFactory;
import com.ibm.sureview.guiComponent.ResolutionSensitiveComponent;
import com.ibm.sureview.guiComponent.TouchButton;
import com.ibm.sureview.resource.ResourceChangeEvent;
import com.ibm.sureview.resource.ResourceChangeListener;
import java.awt.AWTEventMulticaster;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;
import javax.swing.JPanel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class NumericKeyPad extends JPanel implements ActionListener, ResourceChangeListener, ResolutionSensitiveComponent{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static final String COPYRIGHT = "\n\nProperty of Almacenes Flamingo\n(C) Copyright Almacenes Flamingo. 2017. All Rights Reserved.\n\n";
static String copyright()
  {
    return "\n\nLicensed Materials - Property of Almacenes Flamingo\n(C) Copyright Almacenes Flamingo. 2017. All Rights Reserved.\n\n";
  }
  
  private static Log log = LogFactory.getLog(NumericKeyPad.class);
  public static final int TOTAL_NUMBER_BUTTONS = 10;
  public static final String ONE_COMMAND = "1";
  public static final String TWO_COMMAND = "2";
  public static final String THREE_COMMAND = "3";
  public static final String FOUR_COMMAND = "4";
  public static final String FIVE_COMMAND = "5";
  public static final String SIX_COMMAND = "6";
  public static final String SEVEN_COMMAND = "7";
  public static final String EIGHT_COMMAND = "8";
  public static final String NINE_COMMAND = "9";
  public static final String ZERO_COMMAND = "0";
  public static final String PERIOD_COMMAND = ".";
  public static final String DOUBLE_ZERO_COMMAND = "00";
  public static final String NEGATIVE_COMMAND = "-";
  public static final String BLANK_COMMAND = " ";
  protected String[] numberLabels;
  protected String[] commands;
  protected String periodLabel;
  protected String blankLabel;
  protected String negativeLabel;
  protected String dZeroLabel;
  protected ResourceBundle buttonText;
  protected TouchButton[] numberButtons;
  protected TouchButton periodButton;
  protected TouchButton dZeroButton;
  protected ActionListener actionListener = null;
  
  public NumericKeyPad(int rows, int columns)
  {
    this.numberButtons = new TouchButton[rows * columns];
    this.numberLabels = new String[10];
    this.commands = new String[10];
    
    createBundles();
    setLayout(new GridLayout(rows, columns));
    initializeNumberLabels();
    initializeNonNumericLabels();
    initializeNumberPad();
    setOpaque(false);
  }
  
  public void addActionListener(ActionListener l)
  {
    removeActionListener(l);
    
    this.actionListener = AWTEventMulticaster.add(this.actionListener, l);
  }
  
  public void removeActionListener(ActionListener l)
  {
    this.actionListener = AWTEventMulticaster.remove(this.actionListener, l);
  }
  
  public void actionPerformed(ActionEvent e)
  {
    if (this.actionListener != null) {
      this.actionListener.actionPerformed(new ActionEvent(this, 1001, e.getActionCommand()));
    }
  }
  
  protected void initializeNumberLabels()
  {
    this.commands[0] = "0";
    this.commands[1] = "1";
    this.commands[2] = "2";
    this.commands[3] = "3";
    this.commands[4] = "4";
    this.commands[5] = "5";
    this.commands[6] = "6";
    this.commands[7] = "7";
    this.commands[8] = "8";
    this.commands[9] = "9";
    for (int i = 0; i < 10; i++) {
      this.numberLabels[i] = this.buttonText.getString(this.commands[i]);
    }
  }
  
  protected void initializeNonNumericLabels()
  {
    this.periodLabel = this.buttonText.getString(".");
    this.negativeLabel = this.buttonText.getString("-");
    this.blankLabel = " ";
    this.dZeroLabel = this.buttonText.getString("00");
  }
  
  protected void initializeNumberPad()
  {
    for (int i = 0; i < 10; i++)
    {
      this.numberButtons[i] = createTouchButton(this.numberLabels[i]);
      this.numberButtons[i].setDefaultIconAllowed(false);
      this.numberButtons[i].addActionListener(this);
      this.numberButtons[i].setActionCommand(this.commands[i]);
    }
    this.periodButton = createTouchButton(this.blankLabel);
    this.periodButton.setDefaultIconAllowed(false);
    this.periodButton.setActionCommand(" ");
    this.periodButton.addActionListener(this);
    this.dZeroButton = createTouchButton(this.dZeroLabel);
    this.dZeroButton.setDefaultIconAllowed(false);
    this.dZeroButton.setActionCommand("00");
    this.dZeroButton.addActionListener(this);
    
    add(this.numberButtons[7]);
    add(this.numberButtons[8]);
    add(this.numberButtons[9]);
    add(this.numberButtons[4]);
    add(this.numberButtons[5]);
    add(this.numberButtons[6]);
    add(this.numberButtons[1]);
    add(this.numberButtons[2]);
    add(this.numberButtons[3]);
    add(this.periodButton);
    add(this.numberButtons[0]);
    add(this.dZeroButton);
  }
  
  public void setDecimalAllowed(boolean allowed)
  {
    if (allowed)
    {
      this.periodButton.setText(this.periodLabel);
      this.periodButton.setActionCommand(".");
    }
    else if (!this.periodButton.getText().equals(this.negativeLabel))
    {
      this.periodButton.setText(this.blankLabel);
      this.periodButton.setActionCommand(" ");
    }
  }
  
  public void setNegativeAllowed(boolean allowed)
  {
    if (allowed)
    {
      this.periodButton.setText(this.negativeLabel);
      this.periodButton.setActionCommand("-");
    }
    else if (!this.periodButton.getText().equals(this.periodLabel))
    {
      this.periodButton.setText(this.blankLabel);
      this.periodButton.setActionCommand(" ");
    }
  }
  
  public TouchButton createTouchButton(String text)
  {
    String id = "default-keypad-number-button";
    TouchButton tb = FactoryTable.getGUIComponentFactory().makeConfigurableTouchButton(id);
    if (tb == null) {
      tb = FactoryTable.getGUIComponentFactory().makeTouchButton();
    }
    tb.setText(text);
    
    return tb;
  }
  
  public void createBundles()
  {
    I18NFactory factory = FactoryTable.getI18NFactory();
    boolean dynamicNLS = (factory instanceof I18NDynamicFactory);
    if (dynamicNLS) {
      this.buttonText = ((I18NDynamicFactory)factory).makeButtonLabelBundle(getTextCategory(), this);
    } else {
      this.buttonText = factory.makeButtonLabelBundle();
    }
  }
  
  protected String getTextCategory()
  {
    return null;
  }
  
  public void resourceChange(ResourceChangeEvent evt)
  {
    String category = evt.getCategory();
    String myCategory = getTextCategory();
    if ((myCategory == null) && (category.equals("undefined"))) {
      resetText();
    } else if ((myCategory != null) && (myCategory.equals(category))) {
      resetText();
    }
  }
  
  public void resetText()
  {
    createBundles();
    
    initializeNumberLabels();
    initializeNonNumericLabels();
    this.dZeroButton.setText(this.dZeroLabel);
  }
  
  public void setEnabled(boolean enable)
  {
    for (int i = 0; i < this.numberButtons.length; i++)
    {
      TouchButton curButton = this.numberButtons[i];
      if (curButton != null) {
        curButton.setEnabled(enable);
      }
    }
    if (this.periodButton != null) {
      this.periodButton.setEnabled(enable);
    }
    if (this.dZeroButton != null) {
      this.dZeroButton.setEnabled(enable);
    }
  }
  
  public void resolutionUpdate(int width, int height)
  {
    log.debug("Resolution Update detected for a NumberPad object. New Resolution is " + width + "x" + height + ".");
    
    Component[] children = getComponents();
    for (int i = 0; i < children.length; i++)
    {
      Component curChild = children[i];
      log.debug("Checking child: " + curChild);
      if ((curChild instanceof ResolutionSensitiveComponent)) {
        ((ResolutionSensitiveComponent)curChild).resolutionUpdate(width, height);
      }
      curChild.invalidate();
    }
    revalidate();
  }
  
  public void resolutionUpdate(Dimension dimension)
  {
    resolutionUpdate(dimension.width, dimension.height);
  }
  
}
