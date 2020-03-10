package pl.put.poznan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ErrorWindow {
    private JButton button1;
    private JPanel myPanel;
    private JLabel myLabel;
    private JFrame myFrame;


    public ErrorWindow(String errorMessage) {
        myLabel.setText(errorMessage);
        myFrame = new JFrame();
        myFrame.setLocation(750, 400);
        myFrame.setSize(300, 124);
        myFrame.setResizable(false);
        myFrame.add(myPanel, BorderLayout.CENTER);
        myFrame.setTitle("Projekt");
        myFrame.setVisible(true);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myFrame.dispose();
            }
        });
    }
}
