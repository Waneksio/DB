package pl.put.poznan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WarningWindow {
    private JButton YESButton;
    private JPanel myPanel;
    private JButton noButton;
    private Frame myFrame;

    public WarningWindow(EditTable editTable) {

        myFrame = new JFrame();
        myFrame.setSize(480, 640);
        myFrame.setResizable(false);
        myFrame.add(myPanel, BorderLayout.CENTER); // add panel to window
        myFrame.setTitle("Projekt"); // set window title
        myFrame.setVisible(true);
        myFrame.setAlwaysOnTop(true);
        YESButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
