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

public class HappeningsForm {
    private JFrame myFrame;
    private JButton takePartButton;
    private JButton showDetailsButton;
    private JPanel myPanel;
    private JList list1;
    private DefaultListModel model;
    private ResultSet rs;
    private List<String> happeningName;
    private List<String> start_date;
    private List<String> location;
    private List<String> people;

    public boolean isOpen() {
        return myFrame.isShowing();
    }

    public HappeningsForm(Table table, final String id, final Connection connection) {
        rs = null;
        happeningName = new ArrayList<>();
        start_date = new ArrayList<>();
        Controller controller = new Controller();
        String query = "select * from happenings order by start_date";
        try {
            rs = Controller.getResultSet(connection, query);
            while (rs.next()) {
                happeningName.add(rs.getString(1));
                start_date.add(rs.getString(2));
                String insert = "";
                insert += rs.getString(1);
                insert += " ";
                insert += rs.getString(2);
                model.addElement(insert);
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
        takePartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = list1.getSelectedIndex();
                if (index == -1)
                    return;
                String name = happeningName.get(index);
                String date = start_date.get(index);
                date = date.substring(0, date.indexOf(" "));
                String memberId = id;
                ResultSet resultSet = null;
                String query = "select * from happening_participations where member = " + memberId + " AND happening_start = '" + date + "' AND happening_name = '" + name + "'";
                System.out.println(query);
                try {
                    resultSet = Controller.getResultSet(connection, query);
                    if (resultSet.next()) {
                        new ErrorWindow("You are already taking part in that event");
                        return;
                    }
                } catch (SQLException ex) {
                    new ErrorWindow("You cannot join this event");
                    ex.printStackTrace();
                }
                if (resultSet == null)
                    return;
                query = "insert into happening_participations (member, happening_name, happening_start) values (" + memberId + ", '" + name + "', '" + date + "')";
                try {
                    Statement stmt = connection.createStatement();
                    stmt.executeUpdate(query);
                } catch (SQLException ex) {
                    new ErrorWindow("You cannot join this event");
                    //ex.printStackTrace();
                }
            }
        });
    }

    private void createUIComponents() {
        model = new DefaultListModel();
        list1 = new JList(model);
    }
}
