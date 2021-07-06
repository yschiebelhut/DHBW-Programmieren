package de.dhbwka.java.exercise.java8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author Yannik Schiebelhut
 */
public class NumberGuessJava8 extends JFrame {

	int rateZahl, tipp, versuche;
	int limit = 1000;
	JButton exit, ok, neu, stat;
	JPanel p1, p2, p3, p4;
	JTextField sp;
	JTextField ein;
	JTextField aus;
	String ergfile = "src/de/dhbwka/java/exercise/java8/erg.txt";

	public NumberGuessJava8() {
		p4 = new JPanel();
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		neu = new JButton("Neues Spiel");
		ok = new JButton("ok");
		exit = new JButton("exit");
		stat = new JButton("Bester");
		JLabel s = new JLabel("Spielername");
		JLabel l = new JLabel("Zahl zwischen 1 und " + limit + " eingeben");
		sp = new JTextField("Name", 20);
		ein = new JTextField(10);
		aus = new JTextField(40);
		p4.add(s);
		p4.add(sp);
		p1.add(l);
		p1.add(ein);
		Stream.of(neu, ok, stat, exit).forEach(p2::add);
		p3.add(aus);
		setLayout(new GridLayout(4, 1));
		Stream.of(p4, p1, p2, p3).forEach(this::add);

		eventHandling();
		erzeugeZahl();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Ratespiel");
		setSize(500, 400);
		setVisible(true);
	}

	public static void main(String[] args) {
		new NumberGuessJava8();
	}

	public void eventHandling() {
		neu.addActionListener(event -> erzeugeZahl());
		exit.addActionListener(event -> System.exit(0));
		ein.addActionListener(this::okActionListener);
		ok.addActionListener(this::okActionListener);
		stat.addActionListener(event -> bester());
	}

	public void okActionListener(ActionEvent event) {
		try {
			tipp = Integer.parseInt(ein.getText());
			versuche++;
			ein.setText("");
			if (tipp > rateZahl) {
				aus.setText(" Versuch Nr. " + versuche + ": " + tipp + " zu hoch!");
			} else if (tipp < rateZahl) {
				aus.setText("Versuch Nr. " + versuche + ": " + tipp
						+ " zu niedrig!");
			} else {
				aus.setText("Versuch Nr. " + versuche
						+ ": sie haben die Zahl erraten!");
				schreibeFile();

				ok.setEnabled(false);
				ein.setEnabled(false);
			}
		} catch (NumberFormatException ee) {
			aus.setText("Falsche Eingabe");
		}
	}

	private void schreibeFile() {
		try (FileWriter f = new FileWriter(ergfile, true)) {
			String name = sp.getText();
			f.write(name + " " + versuche + " Versuche\n");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Fehler beim Schreiben");
		}
	}

	private void bester() {
		Optional<String> best;
		try {
			best = Files.readAllLines(Paths.get(ergfile)).stream()
					.map(l -> l.split(" "))
					.sorted((a, b) -> {
						return Integer.parseInt(a[1]) - Integer.parseInt(b[1]);
					})
					.map(a -> {
						return a[0] + " " + a[1] + " " + a[2];
					})
					.findFirst();
			aus.setText("Bisher Bester: " + best.get());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void erzeugeZahl() {
		ein.setText("");
		aus.setText("Neues Spiel!");
		rateZahl = (int) (Math.random() * limit + 1);
		System.out.println(rateZahl);
		versuche = 0;
		ok.setEnabled(true);
		ein.setEnabled(true);
	}
}
