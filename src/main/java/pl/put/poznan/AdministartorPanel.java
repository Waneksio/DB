package pl.put.poznan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class AdministartorPanel {
    private JPanel myPanel;
    private JButton workersButton;
    private JButton buildingsButton;
    private JButton sponsorsButton;
    private JButton positionsButton;
    private JButton warrantsButton;
    private JButton membersButton;
    private JButton eventsButton;
    private JButton projectsButton;
    private JButton roomsButton;
    private JFrame myFrame;
    private EditTable myTable;

    public AdministartorPanel(final Connection connection) {
        myTable = null;
        myFrame = new JFrame();
        myFrame.setSize(480, 640);
        myFrame.setResizable(false);
        myFrame.add(myPanel, BorderLayout.CENTER); // add panel to window
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // set exit operation
        myFrame.setTitle("Projekt"); // set window title
        myFrame.setVisible(true);
        workersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (myTable == null)
                    myTable = new EditTable("workers", connection);
                else if (!myTable.isOpen()){
                    myTable = null;
                    myTable = new EditTable("workers", connection);
                }
            }
        });
        membersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (myTable == null)
                    myTable = new EditTable("members", connection);
                else if (!myTable.isOpen()){
                    myTable = null;
                    myTable = new EditTable("members", connection);
                }
            }
        });
        warrantsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (myTable == null)
                    myTable = new EditTable("warrants", connection);
                else if (!myTable.isOpen()){
                    myTable = null;
                    myTable = new EditTable("warrants", connection);
                }
            }
        });
        positionsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (myTable == null)
                    myTable = new EditTable("positions", connection);
                else if (!myTable.isOpen()){
                    myTable = null;
                    myTable = new EditTable("positions", connection);
                }
            }
        });
        sponsorsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (myTable == null)
                    myTable = new EditTable("sponsors", connection);
                else if (!myTable.isOpen()){
                    myTable = null;
                    myTable = new EditTable("sponsors", connection);
                }
            }
        });
        eventsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (myTable == null)
                    myTable = new EditTable("events", connection);
                else if (!myTable.isOpen()){
                    myTable = null;
                    myTable = new EditTable("events", connection);
                }
            }
        });
        projectsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (myTable == null)
                    myTable = new EditTable("projects", connection);
                else if (!myTable.isOpen()){
                    myTable = null;
                    myTable = new EditTable("projects", connection);
                }
            }
        });
        roomsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (myTable == null)
                    myTable = new EditTable("rooms", connection);
                else if (!myTable.isOpen()){
                    myTable = null;
                    myTable = new EditTable("rooms", connection);
                }
            }
        });
        buildingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (myTable == null)
                    myTable = new EditTable("buildings", connection);
                else if (!myTable.isOpen()){
                    myTable = null;
                    myTable = new EditTable("buildings", connection);
                }
            }
        });
    }
}
