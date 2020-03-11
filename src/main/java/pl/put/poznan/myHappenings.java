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

public class myHappenings {
    private JList list1;
    private JPanel myPanel;
    private JButton leaveButton;
    private JButton cancelButton;
    private JFrame myFrame;
    private DefaultListModel model;
    private ResultSet rs;
    private List<String> names;
    private List<String> dates;

    public myHappenings(final Connection connection, Table table, final String id) {
        rs = null;
        names = new ArrayList<>();
        dates = new ArrayList<>();
        String query = "select * from happening_participations where member = " + id;
        try {
            rs = Controller.getResultSet(connection, query);
            while (rs.next()) {
                names.add(rs.getString(2));
                dates.add(rs.getString(3));
                String happening = "";
                happening += rs.getString(2);
                happening += " ";
                happening += rs.getString(3);
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
                String date = dates.get(index);
                date = date.substring(0, date.indexOf(" "));
                String query = "delete from happening_participations where member = " + id + " AND happening_name = '" + name + "' AND happening_start = '" + date + "'";
                System.out.println(query);
                try {
                    Statement stmt = connection.createStatement();
                    stmt.executeUpdate(query);
                } catch (SQLException exception) {
                    new ErrorWindow("Something went wrong");
                    exception.printStackTrace();
                }
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
