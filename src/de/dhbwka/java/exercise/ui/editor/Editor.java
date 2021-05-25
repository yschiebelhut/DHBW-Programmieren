/**
 *
 */
package de.dhbwka.java.exercise.ui.editor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * @author Yannik Schiebelhut
 *
 */
public class Editor extends JFrame {

    JTextPane textPane = new JTextPane();
    File activeFile;

    public Editor() {
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
        save.setEnabled(false);
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
        // TODO only enable if text is selected
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


        this.add(menu, BorderLayout.NORTH);

        JScrollPane scrollPane = new JScrollPane(textPane);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        this.add(scrollPane);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setVisible(true);


        // Action Listeners
        neu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO if text != "", ask if user wants to save
                textPane.setText("");
                save.setEnabled(false);
                activeFile = null;
            }
        });

        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fc = new JFileChooser();
                if (fc.showOpenDialog(Editor.this) == JFileChooser.APPROVE_OPTION) {
                    activeFile = new File(fc.getSelectedFile().getAbsolutePath());
                    try (BufferedReader br = new BufferedReader(new FileReader(activeFile))) {
                        StringBuilder s = new StringBuilder();
                        while (br.ready()) {
                            s.append(br.readLine());
                            s.append("\n");
                        }
                        if (s.length() > 0) {
                            s.deleteCharAt(s.length() - 1);
                        }
                        textPane.setText(s.toString());
                        save.setEnabled(true);
                    } catch (FileNotFoundException fileNotFoundException) {
                        fileNotFoundException.printStackTrace();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            }
        });

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try (PrintWriter p = new PrintWriter(new FileWriter(activeFile))) {
                    p.print(textPane.getText());
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO ask!
                System.exit(0);
            }
        });
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        new Editor();
    }

}
