package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    final int width = (int) screen.getWidth();
    final int height = (int) screen.getHeight();
    final int PROPORTION = 2;
        
    private final JFrame frame = new JFrame();

    public SimpleGUI(SimpleController c) {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel jp = new JPanel();
        JPanel jpBelow = new JPanel();
        jp.setLayout(new BorderLayout());
        jpBelow.setLayout(new BorderLayout());
        JTextField jtf = new JTextField();
        JTextArea jta = new JTextArea();
        JButton print = new JButton("Print");
        JButton history = new JButton("Show History");
        
        jp.add(jtf, BorderLayout.NORTH);
        jp.add(jpBelow, BorderLayout.SOUTH);
        jp.add(jta);
        jpBelow.add(print, BorderLayout.LINE_START);
        jpBelow.add(history, BorderLayout.LINE_END);
        frame.setContentPane(jp);

        print.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                c.setString(jtf.getText());
                c.printString();
            }
        });

        history.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                for (String s : c.getPrintHistory()) {
                    jta.append(s + "\n");   
                }
            }
            
        });
    }

    private void display() {
    
    frame.setSize(width / PROPORTION, height / PROPORTION);
    frame.setLocationByPlatform(true);
    frame.setVisible(true);

    }

    public static void main(String[] args) {
        new SimpleGUI(new SimpleController()).display();
    }
}
