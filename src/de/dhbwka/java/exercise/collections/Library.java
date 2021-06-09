package de.dhbwka.java.exercise.collections;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author Yannik Schiebelhut
 */
public class Library extends JFrame {

	private final JTextField title = new JTextField();
	private final JTextField author = new JTextField();
	private final JTextField year = new JTextField();
	private final JTextField publisher = new JTextField();

	private final File libraryFile = new File("src/de/dhbwka/java/exercise/collections/library.csv");
	private final ArrayList<Book> library = new ArrayList<>();

	public Library() {
		this.setTitle("Library");
		JPanel wrapper = new JPanel();
		this.setLayout(new FlowLayout());
		wrapper.setLayout(new GridLayout(3, 1));

		JPanel data = new JPanel();
		data.setLayout(new GridLayout(4, 2, 5, 5));
		data.add(new JLabel("Title"));
		data.add(title);
		data.add(new JLabel("Author"));
		data.add(author);
		data.add(new JLabel("Year"));
		data.add(year);
		data.add(new JLabel("Publisher"));
		data.add(publisher);
		wrapper.add(data);

		JButton save = new JButton("Save entry");
		wrapper.add(save);
		save.addActionListener(e -> {
			try {
				Book b = new Book(title.getText(), author.getText(), Integer.parseInt(year.getText()), publisher.getText());
				if (!library.contains(b)) {
					library.add(b);
					try (PrintWriter p = new PrintWriter(new FileWriter(libraryFile, true))) {
						p.println(b);
					}
				}
			} catch (NumberFormatException | IOException numberFormatException) {
				numberFormatException.printStackTrace();
			}
		});


		JPanel order = new JPanel();
		order.add(new JLabel("Ordered output:"));
		JButton titleBtn = new JButton("Title");
		order.add(titleBtn);
		titleBtn.addActionListener(e -> {
//			Comparator<Book> c = new Comparator<Book>() {
//				@Override
//				public int compare(Book o1, Book o2) {
//					return o1.getTitle().compareToIgnoreCase(o2.getTitle());
//				}
//			};
			Comparator<Book> c = (o1, o2) -> o1.getTitle().compareToIgnoreCase(o2.getTitle());
			System.out.println(library);
			library.sort(c);
			System.out.println(library);
			displayLibrary();
		});
		JButton authorBtn = new JButton("Author");
		order.add(authorBtn);
		authorBtn.addActionListener(e -> {
			Comparator<Book> c = (o1, o2) -> o1.getAuthor().compareToIgnoreCase(o2.getAuthor());
			System.out.println(library);
			library.sort(c);
			System.out.println(library);
			displayLibrary();
		});

		JButton yearBtn = new JButton("Year");
		order.add(yearBtn);
		yearBtn.addActionListener(e -> {
//			Comparator<Book> c = (o1, o2) -> o1.getYear() - o2.getYear();
			System.out.println(library);
//			library.sort(c);
			library.sort(Comparator.comparingInt(Book::getYear));
			System.out.println(library);
			displayLibrary();
		});
		JButton publisherBtn = new JButton("Publisher");
		order.add(publisherBtn);
		publisherBtn.addActionListener(e -> {
			Comparator<Book> c = (o1, o2) -> o1.getPublisher().compareToIgnoreCase(o2.getPublisher());
			System.out.println(library);
			library.sort(c);
			System.out.println(library);
			displayLibrary();
		});
		wrapper.add(order);

		this.add(wrapper);
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

		initLibrary();
	}

	private void initLibrary() {
		try (BufferedReader br = new BufferedReader(new FileReader(libraryFile))) {
			while (br.ready()) {
				String curLine = br.readLine();
				String[] bookData = curLine.split(";");
				library.add(new Book(bookData[0], bookData[1], Integer.parseInt(bookData[2]), bookData[3]));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void displayLibrary() {
		StringBuilder s = new StringBuilder();
		for (Book b : library) {
			s.append(b);
			s.append(System.lineSeparator());
		}
		JOptionPane.showMessageDialog(this, s.toString());
	}

	public static void main(String[] args) {
		new Library();
	}
}
