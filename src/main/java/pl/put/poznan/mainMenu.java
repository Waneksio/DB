package pl.put.poznan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class mainMenu {
    private JButton button1;
    private JPanel myPanel;
    private JLabel myLabel;
    private JButton happeningsButton;
    private JButton projectsButton;
    private JButton myHappeningsButton;
    private JButton myProjectsButton;
    private JFrame myFrame;
    private informationWindow infWindow;
    private HappeningsForm hapForm;
    private ProjectsForm proForm;
    private ResultSet rs;
    private String userId;
    private String userName;
    private String userSurname;
    private String userEmail;
    private String userPhone;
    private String userWarrants;

    public void reload() {
    }

    public mainMenu(final Connection connection, final String table, String id) {
        String query = "select id, name, surname, email, phone_nr, warrant from ";
        query += table + " where id = " + id;
        Controller controller = new Controller();
        final Table myTable = controller.getTable(table);
        rs = null;
        try {
            rs = Controller.getResultSet(connection, query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            rs.next();
            userId = rs.getString(1);
            userName = rs.getString(2);
            userSurname = rs.getString(3);
            userEmail = rs.getString(4);
            userPhone = rs.getString(5);
            userWarrants = rs.getString(6);
        } catch (SQLException exception) {
            System.out.println(exception);
        }

        infWindow = null;
        myFrame = new JFrame();
        myFrame.setSize(480, 640);
        myFrame.setResizable(false);
        myFrame.add(myPanel, BorderLayout.CENTER); // add panel to window
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // set exit operation
        myFrame.setTitle("Projekt"); // set window title
        myFrame.setVisible(true);
        final String finalQuery = query;
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (infWindow == null)
                    infWindow = new informationWindow(userId, userName, userSurname, userEmail, userPhone, userWarrants, myTable, connection);
                else if(!infWindow.isOpen()) {
                    try {
                        rs = Controller.getResultSet(connection, finalQuery);
                    } catch (SQLException exception) {
                        exception.printStackTrace();
                    }
                    try {
                        rs.next();
                        userId = rs.getString(1);
                        userName = rs.getString(2);
                        userSurname = rs.getString(3);
                        userEmail = rs.getString(4);
                        userPhone = rs.getString(5);
                        userWarrants = rs.getString(6);
                    } catch (SQLException exception) {
                        System.out.println(exception);
                    }
                    infWindow = null;
                    infWindow = new informationWindow(userId, userName, userSurname, userEmail, userPhone, userWarrants, myTable, connection);
                }
            }
        });
        happeningsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (table == "workers") {
                    new ErrorWindow("This section is not available for workers");
                    return;
                }
                if (hapForm == null)
                    hapForm = new HappeningsForm(myTable, userId, connection);
                else if(!hapForm.isOpen()) {
                    hapForm = null;
                    hapForm = new HappeningsForm(myTable, userId, connection);
                }
            }
        });
        projectsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (table == "members") {
                    new ErrorWindow("This section is not available for members");
                    return;
                }
                if (proForm == null)
                    proForm = new ProjectsForm(myTable, userId, connection);
                else if(!proForm.isOpen()) {
                    proForm = null;
                    proForm = new ProjectsForm(myTable, userId, connection);
                }
            }
        });
        myHappeningsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new myHappenings(connection, myTable, userId);
            }
        });
        myProjectsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new myProjects(connection, myTable, userId);
            }
        });
    }
}
