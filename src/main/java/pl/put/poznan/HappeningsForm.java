package pl.put.poznan;

import javax.swing.*;
import java.awt.*;

public class HappeningsForm {
    private JFrame myFrame;
    private JButton addNewEventButton;
    private JButton showDetailsButton;
    private JTable table1;
    private JPanel myPanel;

    public boolean isOpen() {
        return myFrame.isShowing();
    }

    public HappeningsForm() {
        myFrame = new JFrame();
        myFrame.setSize(480, 640);
        myFrame.setResizable(false);
        myFrame.add(myPanel, BorderLayout.CENTER); // add panel to window
        myFrame.setTitle("Projekt"); // set window title
        myFrame.setVisible(true);
    }
}
