package pl.put.poznan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ChangePasswordForm {
    private JPanel panel1;
    private JTextField textField2;
    private JButton saveAndExitButton;
    private JButton cancelButton;
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;
    private JPasswordField passwordField3;
    private JLabel WarningLabel;
    private JFrame myFrame;

    public boolean isOpen() {
        return myFrame.isShowing();
    }

    public ChangePasswordForm(final informationWindow infWindow) {
        myFrame = new JFrame();
        myFrame.setLocation(650, 370);
        myFrame.setSize(500, 280);
        myFrame.setResizable(false);
        myFrame.add(panel1, BorderLayout.CENTER);
        myFrame.setTitle("Projekt");
        myFrame.setVisible(true);
        saveAndExitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WarningLabel.setText("");
                if (passwordField1.getText().equals(infWindow.getPassword())) {
                    if (passwordField2.getText().equals(passwordField3.getText())) {
                        infWindow.ChangePassword(passwordField2.getText());
                        myFrame.dispose();
                    }
                    else {
                        WarningLabel.setText("Passwords aren't identical");
                    }
                }
                else {
                    WarningLabel.setText("Old password doesn't match with your current password");
                }
                passwordField1.setText("");
                passwordField2.setText("");
                passwordField3.setText("");
                passwordField1.grabFocus();
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myFrame.dispose();
            }
        });
        passwordField1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 10) {
                    passwordField2.grabFocus();
                }
            }
        });
        passwordField2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 10) {
                    passwordField3.grabFocus();
                }
            }
        });
        passwordField3.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 10) {
                    WarningLabel.setText("");
                    if (passwordField1.getText().equals(infWindow.getPassword())) {
                        if (passwordField2.getText().equals(passwordField3.getText())) {
                            infWindow.ChangePassword(passwordField2.getText());
                            myFrame.dispose();
                        } else {
                            WarningLabel.setText("Passwords aren't identical");
                        }
                    } else {
                        WarningLabel.setText("Old password doesn't match with your current password");
                    }
                    passwordField1.setText("");
                    passwordField2.setText("");
                    passwordField3.setText("");
                    passwordField1.grabFocus();
                }
            }
        });
    }
}
