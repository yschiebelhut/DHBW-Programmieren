/**
 * 
 */
package de.dhbwka.java.exercise.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.*;

/**
 * @author Yannik Schiebelhut
 *
 */
public class ComponentFrame extends JFrame {
	
	public ComponentFrame() {
		this.setTitle("Several basic Swing components");
		this.setLayout(new FlowLayout());
		JPanel jp = new JPanel();
		JLabel label = new JLabel("JLabel");
		JTextField textfield = new JTextField("JTextField");
		JPasswordField passwordfield = new JPasswordField("JPasswordField");
		JButton btn = new JButton("JButton");
		JToggleButton toggleBtn = new JToggleButton("JToggleButton");
		JCheckBox checkbox = new JCheckBox("JCheckBox");
		String[] opts = {"Foo", "Bar", "Toe"};
		JComboBox<String> combobox = new JComboBox<String>(opts);
		
		ButtonGroup btngrp = new ButtonGroup();
		JRadioButton r1 = new JRadioButton("Radio-Button-1");
		JRadioButton r2 = new JRadioButton("Radio-Button-2");
		JRadioButton r3 = new JRadioButton("Radio-Button-3");
		btngrp.add(r1);
		btngrp.add(r2);
		btngrp.add(r3);
		
		JPanel jp2 = new JPanel();
		jp2.add(r1);
		jp2.add(r2);
		jp2.add(r3);
		
		jp.add(label);
		jp.add(textfield);
		jp.add(textfield);
		jp.add(passwordfield);
		jp.add(btn);
		jp.add(toggleBtn);
		jp.add(checkbox);
		jp.add(combobox);
		this.add(jp);
		this.add(jp2);
		this.setSize(750, 150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	

	/**
	 * @param args
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

		ComponentFrame cf = new ComponentFrame();
//		new ComponentFrame();

	}

}
