package pl.put.poznan;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class informationWindow {
    private JTable table1;
    private JPanel myPanel;
    private JButton zmieńHasłoButton;
    private JButton saveButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JButton editButton;
    private JButton editButton1;
    private JComboBox comboBox1;
    private JFrame myFrame;
    private String Password;
    private ChangePasswordForm passForm;

    public String getPassword(){
        return Password;
    }

    public informationWindow getMe() {
        return this;
    }

    public void ChangePassword(String newPassword) {
        Password = newPassword;
    }

    public boolean isOpen() {
        return myFrame.isShowing();
    }

    public informationWindow() {
        Password = "";
        comboBox1.addItem("+48");
        comboBox1.addItem("+42");
        comboBox1.addItem("+69");
        myFrame = new JFrame();
        myFrame.setSize(480, 640);
        myFrame.setResizable(false);
        myFrame.add(myPanel, BorderLayout.CENTER); // add panel to window
        myFrame.setTitle("Projekt"); // set window title
        myFrame.setVisible(true);
        myFrame.setAlwaysOnTop(true);
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (editButton.getText() == "Edit") {
                    textField3.setEditable(true);
                    editButton.setText("Save");
                }
                else {
                    editButton.setText("Edit");
                    textField3.setEditable(false);
                }
            }
        });
        editButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (editButton1.getText() == "Edit") {
                    textField1.setEditable(true);
                    editButton1.setText("Save");
                    comboBox1.setEnabled(true);
                }
                else {
                    editButton1.setText("Edit");
                    textField1.setEditable(false);
                    comboBox1.setEnabled(false);
                }
            }
        });
        zmieńHasłoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (passForm == null)
                    passForm = new ChangePasswordForm(getMe());
                else if(!passForm.isOpen()) {
                    passForm = null;
                    passForm = new ChangePasswordForm(getMe());
                }
            }
        });
    }
}
