/**
 * 
 */
package de.dhbwka.java.exercise.ui.event;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * @author Yannik Schiebelhut
 *
 */
public class BMICalculator {

	private static JTextField weight = new JTextField();
	private static JTextField height = new JTextField();
	private static JRadioButton male = new JRadioButton("male");
	private static JRadioButton female = new JRadioButton("female");
	private static JButton calc = new JButton("Calculate");
	private static JLabel bmi = new JLabel();
	private static JLabel classification = new JLabel();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setTitle("BMI Calculator");
		frame.setLayout(new FlowLayout());

		JPanel wrapper = new JPanel(new GridLayout(5, 1));

		JPanel inputFields = new JPanel();
		inputFields.setLayout(new GridLayout(2, 2, 6, 3));
		inputFields.add(new JLabel("Weight [kg]"));
		inputFields.add(weight);
		inputFields.add(new JLabel("Body height [m]"));
		inputFields.add(height);
		wrapper.add(inputFields);
		ActionListener enterEvent = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				calc.doClick();
			}
			
		};
		weight.addActionListener(enterEvent);
		height.addActionListener(enterEvent);

		ButtonGroup buttongrp = new ButtonGroup();
		buttongrp.add(male);
		buttongrp.add(female);
		JPanel buttons = new JPanel();
		buttons.add(male);
		buttons.add(female);
		wrapper.add(buttons);
		male.addActionListener(enterEvent);
		female.addActionListener(enterEvent);

		JPanel calculate = new JPanel();
		calculate.add(calc);
		wrapper.add(calculate);
		calc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					double bmitmp = Double.parseDouble(weight.getText())
							/ Math.pow(Double.parseDouble(height.getText()), 2);
					bmi.setText(String.format("BMI: %2.2f", bmitmp));

					if (male.isSelected() || female.isSelected()) {
						int cat;
						String[] categories = { "Short weight", "Normal weight", "Overweight", "Adiposity",
								"Massive Adiposity" };
						if (male.isSelected()) {
							if (bmitmp < 20)
								cat = 0;
							else if (bmitmp >= 20 && bmitmp < 25)
								cat = 1;
							else if (bmitmp >= 25 && bmitmp < 30)
								cat = 2;
							else if (bmitmp >= 30 && bmitmp < 50)
								cat = 3;
							else
								cat = 4;
						} else {
							if (bmitmp < 19)
								cat = 0;
							else if (bmitmp >= 19 && bmitmp < 24)
								cat = 1;
							else if (bmitmp >= 24 && bmitmp < 30)
								cat = 2;
							else if (bmitmp >= 30 && bmitmp < 50)
								cat = 3;
							else
								cat = 4;
						}
						classification.setText(categories[cat]);
					} else {
						classification.setText("Select gender for classification");
					}
				} catch (Exception ec) {
					bmi.setText("Input error");
					classification.setText("");
				}

			}

		});

		wrapper.add(bmi);
		wrapper.add(classification);

		frame.add(wrapper);
		frame.pack();
		frame.setVisible(true);
	}

}
