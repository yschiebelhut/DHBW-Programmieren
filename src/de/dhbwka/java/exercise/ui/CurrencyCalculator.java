/**
 * 
 */
package de.dhbwka.java.exercise.ui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.border.Border;

/**
 * @author Yannik Schiebelhut
 *
 */
public class CurrencyCalculator extends JFrame {

	public CurrencyCalculator() {
		this.setTitle("Currency Converter");
		this.setLayout(new BorderLayout(5,5));
		
		JTextArea iofield = new JTextArea("Please enter amount to convert!");
		
		JButton etod = new JButton("EUR -> USD");
		JButton dtoe = new JButton("USD -> EUR");
		JButton cancel = new JButton("Cancel");
		
		this.add(iofield, BorderLayout.NORTH);
		this.add(etod, BorderLayout.WEST);
		this.add(dtoe, BorderLayout.CENTER);
		this.add(cancel, BorderLayout.EAST);
		
		this.pack();
		this.setVisible(true);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new CurrencyCalculator();
	}

}
