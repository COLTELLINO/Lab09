package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private static final int PROPORTION = 2;
    private final JFrame frame = new JFrame("My Second GUI");

    final static Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    final static int sw = (int) screen.getWidth();
    final static int sh = (int) screen.getHeight();

    public SimpleGUIWithFileChooser(Controller c) {

        final JPanel jPanel = new JPanel(); 
        final JPanel jPanelUpper = new JPanel(); 
        final JButton save = new JButton("Save");
        final JTextField browseFile = new JTextField(c.getPath());
        final JButton browse = new JButton("Browse");
        final JTextArea jta = new JTextArea();        
        jPanelUpper.setLayout(new BorderLayout());
        jPanelUpper.add(browse, BorderLayout.LINE_END);
        jPanelUpper.add(browseFile, BorderLayout.CENTER);
        jPanel.setLayout(new BorderLayout());
        jPanel.add(jta, BorderLayout.CENTER);
        jPanel.add(save, BorderLayout.SOUTH);
        jPanel.add(jPanelUpper, BorderLayout.NORTH);
        browseFile.setEditable(false);
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

        browse.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {

                final JFileChooser fileChooser = new JFileChooser("File Explorer");
                fileChooser.setSelectedFile(c.getFile());
                final int result = fileChooser.showSaveDialog(frame);

                if (result == JFileChooser.APPROVE_OPTION) {
                    final File newFile = fileChooser.getSelectedFile();
                    c.setFile(newFile);
                    browseFile.setText(newFile.getPath());
                }

                else {
                    JOptionPane.showMessageDialog(frame, "An error has occurred!");
                }
            }
        });

    }
     
    public void display() {
    
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new SimpleGUIWithFileChooser(new Controller()).display();
    }   

}