package pl.put.poznan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class mainForm {
    private JButton edytujButton;
    private JButton dodajButton;
    private JButton usuńButton;
    private JTable table1;
    private JButton wyszukajButton;
    private JTextArea wyszukajTextArea;
    private JPanel myPanel;
    private JFrame myFrame;

    private void search(String text) {

    }

    public mainForm() {
        /*WINDOW SETUP
        --------------------------------------------------------------------------------------- */
        myPanel.setSize(480, 640);
        myPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        myFrame = new JFrame();
        myFrame.setSize(480, 640);
        myFrame.setResizable(false);
        myFrame.add(myPanel, BorderLayout.CENTER);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setTitle("Projekt");
        myFrame.setVisible(true);
        wyszukajTextArea.setMaximumSize(new Dimension(150, 13));
        wyszukajTextArea.setOpaque(true);

        /*LISTENERS
        ---------------------------------------------------------------------------------------*/
        dodajButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        usuńButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        edytujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        wyszukajTextArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 10) {
                    String text = wyszukajTextArea.getText();
                    System.out.println(text);
                    wyszukajTextArea.setText("");
                }
            }
        });

        wyszukajButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = wyszukajTextArea.getText();
                System.out.println(text);
                wyszukajTextArea.setText("");
            }
        });
    }
}
