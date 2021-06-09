package de.dhbwka.java.exercise.ui.event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Yannik Schiebelhut
 */
public class OwnTest extends JFrame {

    private JButton button = new JButton("Click Me!");
    private JLabel label = new JLabel("some text");

    public OwnTest() {
        this.setTitle("Test Window");
        this.setLayout(new FlowLayout());
        this.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("some other text");
            }
        });

        this.add(label);

        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new OwnTest();
    }
}
