package pl.put.poznan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class loginForm {
    private JPanel myPanel;
    private JFrame myFrame;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton zakończButton;
    private JButton zalogujButton;
    private JLabel Info;
    private JLabel warningLabel;
    private JButton myButton;

    private boolean login(String username, String password) {
        if (username.equals("kutas")) {
            return password.equals("dupa");
        }
        return false;
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
                    if (login(textField1.getText(), passwordField1.getText())) {
                        myFrame.dispose();
                        new mainMenu();
                    }
                    warningLabel.setText("Could not log-in");
                    textField1.setText("");
                    passwordField1.setText("");
                    textField1.grabFocus();
                }
            }
        });

        zalogujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (login(textField1.getText(), passwordField1.getText())) {
                    myFrame.dispose();
                    new mainMenu();
                }
                warningLabel.setText("Could not log-in");
                textField1.setText("");
                passwordField1.setText("");
                textField1.grabFocus();
            }
        });
        zakończButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myFrame.dispose();
            }
        });
    }
}
