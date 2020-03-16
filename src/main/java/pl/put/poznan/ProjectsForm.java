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

public class ProjectsForm {
    private JFrame myFrame;
    private JButton cancelButton;
    private JButton joinProjectButton;
    private JPanel myPanel;
    private JList list1;
    private JTextField textField1;
    private JButton searchButton;
    private ResultSet rs;
    private List<String> projectNames;
    private DefaultListModel model;

    public boolean isOpen() {
        return myFrame.isShowing();
    }

    public ProjectsForm(Table table, final String id, final Connection connection) {
        rs = null;
        projectNames = new ArrayList<>();
        Controller controller = new Controller();
        String query = "select * from projects order by start_date";
        try {
            rs = Controller.getResultSet(connection, query);
            while (rs.next()) {
                projectNames.add(rs.getString(1));
                String insert = "";
                insert += rs.getString(1);
                insert += " ";
                insert += rs.getString(4);
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
        joinProjectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = list1.getSelectedIndex();
                if (index == -1)
                    return;
                String name = projectNames.get(index);
                String memberId = id;
                ResultSet resultSet = null;
                String query = "select * from projects_participations where worker = " + memberId + " AND project_id = '" + name + "'";
                System.out.println(query);
                try {
                    resultSet = Controller.getResultSet(connection, query);
                    if (resultSet.next()) {
                        new ErrorWindow("You've already joined this project");
                        return;
                    }
                } catch (SQLException ex) {
                    new ErrorWindow("You cannot join this project");
                    ex.printStackTrace();
                    return;
                }
                if (resultSet == null)
                    return;
                query = "insert into projects_participations (worker, project_id) values (" + memberId + ", '" + name + "')";
                try {
                    Statement stmt = connection.createStatement();
                    stmt.executeUpdate(query);
                } catch (SQLException ex) {
                    new ErrorWindow("You cannot join this project");
                    ex.printStackTrace();
                    return;
                }
                new ErrorWindow("You've joined to the project!");
            }
        });
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultListModel newModel = new DefaultListModel();
                list1.setModel(newModel);
                String text = textField1.getText();
                for (int i = 0; i < model.size(); i++) {
                    if (model.elementAt(i).toString().contains(text)) {
                        newModel.addElement(model.elementAt(i));
                    }
                }
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                myFrame.dispose();
            }
        });
    }

    private void createUIComponents() {
        model = new DefaultListModel();
        list1 = new JList(model);
    }
}
