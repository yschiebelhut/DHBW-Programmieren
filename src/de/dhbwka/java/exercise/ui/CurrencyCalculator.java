/**
 * 
 */
package de.dhbwka.java.exercise.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 * @author Yannik Schiebelhut
 *
 */
public class CurrencyCalculator extends JFrame implements ActionListener {

	private final double CHANGE_RATE = 1.09;
	
	JButton etod = new JButton("EUR -> USD");
	JButton dtoe = new JButton("USD -> EUR");
	JButton cancel = new JButton("Cancel");
	JTextField iofield = new JTextField("Please enter amount to convert!");

	public CurrencyCalculator() {
		this.setTitle("Currency Converter");
		this.setLayout(new BorderLayout(5, 5));

		iofield.requestFocus();
		iofield.selectAll();
		
		etod.addActionListener(this);
		dtoe.addActionListener(this);
		cancel.addActionListener(this);


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

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton) e.getSource();
		if(source == this.cancel) {
			System.exit(0);
		} else {
			try {
				double amount = Double.parseDouble(this.iofield.getText());
				
				if (source == this.etod) {
					amount = amount * CHANGE_RATE;
				} else {
					amount = amount / CHANGE_RATE;
				}
				this.iofield.setText(Double.toString(round(amount)));
			} catch (NumberFormatException ne) {
				this.iofield.setText("invalid input format");
			} finally {
				iofield.requestFocus();
				iofield.selectAll();
			}
		}
	}
	
	public double round(double d) {
		BigDecimal b = new BigDecimal(d);
		BigDecimal round = b.setScale(2, BigDecimal.ROUND_HALF_EVEN);
		return round.doubleValue();
	}

}
