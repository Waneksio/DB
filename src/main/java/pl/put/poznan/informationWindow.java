package pl.put.poznan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class informationWindow {
    private JTable table1;
    private JPanel myPanel;
    private JButton zmieńHasłoButton;
    private JButton saveButton;
    private JTextField textField5;
    private JTextField textField1;
    private JTextField textField4;
    private JTextField textField2;
    private JTextField textField3;
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

    public informationWindow(final String id, String name, String surname, String email, String phone, String warrant, final Table table, final Connection connection) {
        Password = surname;
        textField1.setText(id);
        textField2.setText(name);
        textField4.setText(email);
        textField5.setText(phone);
        textField3.setText(warrant);
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
                    textField4.setEditable(true);
                    editButton.setText("Save");
                }
                else {
                    editButton.setText("Edit");
                    textField4.setEditable(false);
                }
            }
        });
        editButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (editButton1.getText() == "Edit") {
                    textField5.setEditable(true);
                    editButton1.setText("Save");
                    comboBox1.setEnabled(true);
                }
                else {
                    editButton1.setText("Edit");
                    textField5.setEditable(false);
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
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (passForm != null) {
                    if (passForm.isOpen())
                        return;
                }
                String newPhone = textField5.getText();
                String newEmail = textField4.getText();
                String newPassword = getPassword();
                System.out.println(table.tableName);
                String query = "update " + table.tableName + " set phone_nr = " + newPhone + ", email = '" + newEmail + "', surname = '" + newPassword + "' where id = " + id;
                System.out.println(query);
                try {
                    Statement stmt = connection.createStatement();
                    stmt.executeUpdate(query);
                } catch (SQLException exception) {
                    System.out.println(exception);
                    myFrame.dispose();
                    return;
                }
            }
        });
    }
}
