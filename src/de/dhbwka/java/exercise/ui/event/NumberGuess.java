/**
 * 
 */
package de.dhbwka.java.exercise.ui.event;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Yannik Schiebelhut
 *
 */
public class NumberGuess extends JFrame {

	private JTextField playerName = new JTextField("", 20);
	private JTextField inputText = new JTextField("", 20);
	private JButton restart = new JButton("New Game");
	private JButton ok = new JButton("OK");
	private JButton best = new JButton("Best Player");
	private JButton exit = new JButton("Exit");
	private JTextField output = new JTextField("", 40);
	private int solution = 0;
	private int attempts = 0;

	private String libraryFile = "src/de/dhbwka/java/exercise/ui/event/NumberGuess.db";

	public NumberGuess() {
//		newGame();
		this.solution = 256;

		this.setTitle("Number Guessing Game");
		this.setLayout(new FlowLayout());

		JPanel wrapper = new JPanel();
		wrapper.setLayout(new GridLayout(4, 1));

		JPanel player = new JPanel();
		player.add(new JLabel("Player Name"));
		player.add(playerName);
		wrapper.add(player);

		JPanel input = new JPanel();
		input.add(new JLabel("Enter number between 1 and 1000"));
		input.add(inputText);
		wrapper.add(input);

		JPanel buttons = new JPanel();
		buttons.add(restart);
		buttons.add(ok);
		buttons.add(best);
		buttons.add(exit);
		wrapper.add(buttons);

		restart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				newGame();
				inputText.setText("");
				inputText.requestFocus();
			}

		});

		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		ActionListener check = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int inputNum = Integer.parseInt(inputText.getText());
					attempts++;
					if (inputNum == solution) {
						save(playerName.getText(), attempts);
						output.setText(String.format(String.format("Attempt #%d: %d => CORRECT!", attempts, inputNum)));
						newGame();
					} else if (inputNum < solution) {
						output.setText(String.format("Attempt #%d: %d => too small!", attempts, inputNum));
					} else {
						output.setText(String.format("Attempt #%d: %d => too big!", attempts, inputNum));
					}
				} catch (NumberFormatException ex) {
					output.setText("invalid format");
				} finally {
					inputText.requestFocus();
					inputText.selectAll();
				}
			}

		};

		ok.addActionListener(check);
		inputText.addActionListener(check);
		
		best.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO implement search for best result
			}
			
		});

		JPanel outputpanel = new JPanel();
		outputpanel.add(output);
		wrapper.add(outputpanel);

		this.add(wrapper);
		this.pack();
		this.setVisible(true);

	}

	private void save(String name, int attempts) {
		if (name.equals("")) {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");
			LocalDateTime now = LocalDateTime.now();
			name = dtf.format(now);
		}
		File db = new File(libraryFile);
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(db, true));
			pw.println(String.format("%s:%d", name, attempts));
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void newGame() {
		Random r = new Random();
		this.solution = r.nextInt(999) + 1;
		this.attempts = 0;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new NumberGuess();
	}

}
