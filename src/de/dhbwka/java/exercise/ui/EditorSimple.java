/**
 * 
 */
package de.dhbwka.java.exercise.ui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

/**
 * @author Yannik Schiebelhut
 *
 */
public class EditorSimple extends JFrame {
	
	public EditorSimple() {
		this.setTitle("Editor");
		
		JMenuBar menu = new JMenuBar();
		
		JMenu file = new JMenu("File");
		menu.add(file);
		JMenuItem neu = new JMenuItem("New");
		file.add(neu);
		JMenuItem open = new JMenuItem("Open");
		file.add(open);
		file.addSeparator();
		JMenuItem close = new JMenuItem("Close");
		file.add(close);
		file.addSeparator();
		JMenuItem save = new JMenuItem("Save");
		file.add(save);
		JMenuItem saveAs = new JMenuItem("Save as");
		file.add(saveAs);
		file.addSeparator();
		JMenu sendto = new JMenu("Send to");
		JMenuItem mail = new JMenuItem("Email receipient");
		sendto.add(mail);
		file.add(sendto);
		JMenuItem props = new JMenuItem("Properties");
		file.add(props);
		file.addSeparator();
		JMenuItem quit = new JMenuItem("Quit");
		file.add(quit);
		
		JMenu edit = new JMenu("Edit");
		menu.add(edit);
		JMenuItem undo = new JMenuItem("Undo");
		edit.add(undo);
		JMenuItem redo = new JMenuItem("Redo");
		edit.add(redo);
		edit.addSeparator();
		JMenuItem cut = new JMenuItem("Cut");
		edit.add(cut);
		JMenuItem copy = new JMenuItem("Copy");
		edit.add(copy);
		JMenuItem paste = new JMenuItem("Paste");
		edit.add(paste);
		edit.addSeparator();
		JMenuItem delete = new JMenuItem("Delete");
		edit.add(delete);
		JMenuItem markall = new JMenuItem("Mark all");
		edit.add(markall);
		edit.addSeparator();
		JMenuItem search = new JMenuItem("Search...");
		edit.add(search);
		JMenuItem replace = new JMenuItem("Replace...");
		edit.add(replace);
		JMenuItem gotolocation = new JMenuItem("Go to...");
		edit.add(gotolocation);
		
		JTextArea textarea = new JTextArea();
		
		this.add(menu, BorderLayout.NORTH);
		this.add(textarea);
		
		this.setSize(800, 600);
		this.setVisible(true);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new EditorSimple();
	}

}
