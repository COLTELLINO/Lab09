package it.unibo.mvc;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private static final int PROPORTION = 2;

    private final JFrame frame = new JFrame("My GUI");

    public SimpleGUI(Controller c) {

        final JPanel jPanel = new JPanel(); 
        jPanel.setLayout(new BorderLayout());
        final JButton save = new JButton("Save");
        final JTextArea jta = new JTextArea();        
        jPanel.add(jta, BorderLayout.CENTER);
        jPanel.add(save, BorderLayout.SOUTH);
        frame.setContentPane(jPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        save.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    c.writeOnFile(jta.getText());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
             
        });

    }

    public void display() {

        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
    
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new SimpleGUI(new Controller()).display();
    }   
}
