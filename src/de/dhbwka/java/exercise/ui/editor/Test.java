package de.dhbwka.java.exercise.ui.editor;

import javax.swing.*;

/**
 * @author Yannik Schiebelhut
 */
public class Test extends JFrame {
    public Test() {
        JButton btn = new JButton("a Button");
        this.add(btn);

        btn.addActionListener(e -> {
            Object[] options = {"a", "b", "c"};

            int answer = JOptionPane.showOptionDialog(this, "choose an option", "option dialog",
                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);

            switch (answer) {
                case JOptionPane.YES_OPTION:
                    System.out.println("a");
                    break;
                case JOptionPane.NO_OPTION:
                    System.out.println("b");
                    break;
                case JOptionPane.CANCEL_OPTION:
                    System.out.println("c");
                    break;
            }
        });

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 300);
        this.setVisible(true);

    }

    public static void main(String[] args) {
        new Test();
    }
}
