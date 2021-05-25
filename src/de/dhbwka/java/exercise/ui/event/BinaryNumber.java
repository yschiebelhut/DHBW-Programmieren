/**
 * 
 */
package de.dhbwka.java.exercise.ui.event;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

/**
 * @author Yannik Schiebelhut
 *
 */
public class BinaryNumber extends JFrame {

	JToggleButton[] buttons = new JToggleButton[8];
	JLabel output = new JLabel("0");

	public BinaryNumber() {
		ActionListener action = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int erg = 0;
				for (int i = 0; i < buttons.length; i++) {
					if (buttons[i].isSelected()) {
						erg += Math.pow(2, buttons.length - 1 - i);
					}
				}

				output.setText(Integer.toString(erg));
			}

		};

		this.setTitle("Binary Number");
		this.setLayout(new FlowLayout());

		JPanel wrapper = new JPanel();
		wrapper.setLayout(new BorderLayout());

		JPanel input = new JPanel();
		input.setLayout(new GridLayout(2, 7));

		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JToggleButton();
			buttons[i].setIcon(new ImageIcon("src/de/dhbwka/java/exercise/ui/event/off.png"));
			buttons[i].setSelectedIcon(new ImageIcon("src/de/dhbwka/java/exercise/ui/event/on.png"));
			buttons[i].addActionListener(action);
			input.add(buttons[i]);
		}

		for (int i = buttons.length - 1; i >= 0; i--) {
			input.add(new JLabel("2^" + i, JLabel.CENTER));
		}

		wrapper.add(input, BorderLayout.NORTH);
		output.setHorizontalAlignment(JLabel.CENTER);
		wrapper.add(output, BorderLayout.CENTER);
		this.add(wrapper);

		this.pack();
		this.setVisible(true);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new BinaryNumber();
	}

}
