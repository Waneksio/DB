package pl.put.poznan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class loginForm {
    private JPanel myPanel;
    private JFrame myFrame;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton zakończButton;
    private JButton zalogujButton;
    private JButton myButton;

    private void login(String username, String password) {

    }

    public loginForm() {
        myButton = new JButton("login");
        myButton.setLocation(10, 30);
        myButton.setSize(10, 20);
        myPanel.setSize(480, 640);
        myPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        myFrame = new JFrame();
        myFrame.setLocation(720, 370);
        myFrame.setSize(360, 280);
        myFrame.setResizable(false);
        myFrame.add(myPanel, BorderLayout.CENTER);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setTitle("Projekt");
        myFrame.setVisible(true);



        textField1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 10) {
                    passwordField1.grabFocus();
                }
            }
        });


        passwordField1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 10) {
                    textField1.setText("");
                    passwordField1.setText("");
                    textField1.grabFocus();
                    //Log-in
                }
            }
        });
    }
}
