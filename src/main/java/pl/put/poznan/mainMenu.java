package pl.put.poznan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class mainMenu {
    private JButton button1;
    private JPanel myPanel;
    private JLabel myLabel;
    private JButton happeningsButton;
    private JButton projectsButton;
    private JFrame myFrame;
    private informationWindow infWindow;
    private HappeningsForm hapForm;
    private ProjectsForm proForm;

    public mainMenu() {
        infWindow = null;
        myFrame = new JFrame();
        myFrame.setSize(480, 640);
        myFrame.setResizable(false);
        myFrame.add(myPanel, BorderLayout.CENTER); // add panel to window
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // set exit operation
        myFrame.setTitle("Projekt"); // set window title
        myFrame.setVisible(true);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (infWindow == null)
                    infWindow = new informationWindow();
                else if(!infWindow.isOpen()) {
                    infWindow = null;
                    infWindow = new informationWindow();
                }
            }
        });
        happeningsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (hapForm == null)
                    hapForm = new HappeningsForm();
                else if(!hapForm.isOpen()) {
                    hapForm = null;
                    hapForm = new HappeningsForm();
                }
            }
        });
        projectsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (proForm == null)
                    proForm = new ProjectsForm();
                else if(!proForm.isOpen()) {
                    proForm = null;
                    proForm = new ProjectsForm();
                }
            }
        });
    }
}
