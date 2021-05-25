/**
 * 
 */
package de.dhbwka.java.exercise.ui.event;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
public class ShellGame extends JFrame {

	private JTextField playerName = new JTextField(20);
	private JButton[] shellBtn = new JButton[3];
	private JButton statistics = new JButton("Statistics");
	private JButton exit = new JButton("Exit");
	private JTextField output = new JTextField(40);
	private int attempts = 0;

	private String libraryFile = "src/de/dhbwka/java/exercise/ui/event/ShellGame.db";

	public ShellGame() {
		this.setTitle("Shell Game");
		this.setLayout(new FlowLayout());

		JPanel wrapper = new JPanel();
		wrapper.setLayout(new GridLayout(4, 1));

		JPanel player = new JPanel();
		player.add(new JLabel("Player Name"));
		player.add(playerName);
		wrapper.add(player);

		ActionListener shellListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				attempts++;
				JButton source = (JButton) e.getSource();
				Random r = new Random();
				int rand = r.nextInt(3);
				System.out.println(rand);
				System.out.println(source == shellBtn[rand]);
				if (source == shellBtn[rand]) {
					output.setText(String.format("Attempt %d wins: Ball was below shell %d", attempts, rand + 1));
					save(playerName.getText(), attempts);
					attempts = 0;
				} else {
					output.setText(String.format("Attempt %d failed: Ball was below shell %d", attempts, rand + 1));
				}
			}

		};

		JPanel playButtons = new JPanel();
		for (int i = 0; i < shellBtn.length; i++) {
			shellBtn[i] = new JButton("Shell " + (i + 1));
			shellBtn[i].addActionListener(shellListener);
			playButtons.add(shellBtn[i]);
		}
		wrapper.add(playButtons);

		JPanel controlButtons = new JPanel();
		controlButtons.add(statistics);
		controlButtons.add(exit);
		wrapper.add(controlButtons);

		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}

		});

		statistics.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				File db = new File(libraryFile);
				try {
					BufferedReader br = new BufferedReader(new FileReader(db));
					int count = 0;
					int sum = 0;
					while (br.ready()) {
						String[] line = br.readLine().split(":");
						// cannot default to second index in case that name contains colons
						sum += Integer.parseInt(line[line.length - 1]);
						count++;
					}
					output.setText(String.format("Average: Success after %.2f attempts!", Double.valueOf(sum) / count));
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});

		JPanel outputpanel = new JPanel();
		outputpanel.add(output);
		wrapper.add(outputpanel);

		this.add(wrapper);
		this.pack();
		this.setVisible(true);

	}

	private void save(String name, int attemtps) {
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

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new ShellGame();
	}

}
