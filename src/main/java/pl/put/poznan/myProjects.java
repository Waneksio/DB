package pl.put.poznan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class myProjects {
    private JFrame myFrame;
    private JButton leaveButton;
    private JButton cancelButton;
    private JList list1;
    private JPanel myPanel;
    private ResultSet rs;
    private java.util.List<String> names;
    private List<String> dates;
    private DefaultListModel model;

    public myProjects(final Connection connection, Table table, final String id) {
        rs = null;
        names = new ArrayList<>();
        dates = new ArrayList<>();
        String query = "select * from projects_participations where worker = " + id;
        try {
            rs = Controller.getResultSet(connection, query);
            while (rs.next()) {
                names.add(rs.getString(2));
                String happening = "";
                happening += rs.getString(2);
                model.addElement(happening);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        myFrame = new JFrame();
        myFrame.setSize(480, 640);
        myFrame.setResizable(false);
        myFrame.add(myPanel, BorderLayout.CENTER); // add panel to window
        myFrame.setTitle("Projekt"); // set window title
        myFrame.setVisible(true);
        myFrame.setAlwaysOnTop(true);
        leaveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = list1.getSelectedIndex();
                if (index == -1)
                    return;
                String name = names.get(index);
                String query = "delete from projects_participations where worker = " + id + " AND project_id = '" + name + "'";
                System.out.println(query);
                try {
                    Statement stmt = connection.createStatement();
                    stmt.executeUpdate(query);
                } catch (SQLException exception) {
                    new ErrorWindow("Something went wrong");
                    exception.printStackTrace();
                    return;
                }
                new ErrorWindow("You left project");
                myFrame.dispose();
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myFrame.dispose();
            }
        });
    }

    private void createUIComponents() {
        model = new DefaultListModel();
        list1 = new JList(model);
    }
}
