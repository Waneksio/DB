package pl.put.poznan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class loginForm {
    private JPanel myPanel;
    private JFrame myFrame;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton zakończButton;
    private JButton zalogujButton;
    private JLabel warningLabel;
    private JButton myButton;
    private ResultSet rsWorkers;
    private ResultSet rsMembers;
    private Connection mConnection;

    private List<String> login(String username, String password) throws SQLException{
        List<String> result = new ArrayList<>();
        String warrants = "";
        String query = "select privileges_list from workers join warrants on workers.warrant = warrants.name where id = ";
        query += username + " AND surname = '" + password + "'";
        System.out.println(query);
        ResultSet rs = Controller.getResultSet(mConnection, query);
        if (rs.next()) {
            System.out.println("XD");
            warrants = rs.getString(1);
            result.add("workers");
            result.add(warrants);
        }
        if (warrants == "super_user") {
            return result;
        }

        query = "select privileges_list from members join warrants on members.warrant = warrants.name where id = ";
        query += username + " AND surname = '" + password + "'";
        System.out.println(query);
        rs = Controller.getResultSet(mConnection, query);
        if (rs.next()) {
            System.out.println(rs.getString(1));
            warrants = rs.getString(1);
            result.add("members");
            result.add(warrants);
            return result;
        }
        if (result.isEmpty()) {
            result.add("0");
            result.add("0");
        }
        return result;
    }

    public loginForm(final Connection connection) {
        final String tableName = "";
        mConnection = connection;
        try {
            rsWorkers = Controller.getResultSet(connection, "select * from workers");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            rsMembers = Controller.getResultSet(connection, "select * from members");
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
                try {
                    if (e.getKeyCode() == 10) {
                        String login = textField1.getText();
                        List<String> warrants = login(login, passwordField1.getText());
                        System.out.println(warrants.get(1));
                        if (warrants.get(1).equals("regular_user")) {
                            myFrame.dispose();
                            new mainMenu(connection, warrants.get(0), login);
                        }
                        if (warrants.get(1).equals("super_user")) {
                            myFrame.dispose();
                            new AdministartorPanel(connection);
                        }
                        warningLabel.setText("Wrong username or password");
                        textField1.setText("");
                        passwordField1.setText("");
                        textField1.grabFocus();
                    }
                } catch (SQLException exception) {
                    warningLabel.setText("Wrong username or password");
                    System.out.println(exception);
                }
            }
        });

        zalogujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String login = textField1.getText();
                    List<String> warrants = login(login, passwordField1.getText());
                    if (warrants.get(1).equals("regular_user")) {
                        myFrame.dispose();
                        new mainMenu(connection, warrants.get(0), login);
                    }
                    if (warrants.get(1).equals("super_user")) {
                        myFrame.dispose();
                        new AdministartorPanel(connection);
                    }
                    warningLabel.setText("Wrong username or password");
                    textField1.setText("");
                    passwordField1.setText("");
                    textField1.grabFocus();
                }
                catch (SQLException exception) {
                    System.out.println(exception);
                    warningLabel.setText("Wrong username or password");
                }
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
