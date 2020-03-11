package pl.put.poznan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class HintWindow {
    private JList myList;
    private JPanel myPanel;
    private JButton OKButton;
    private JFrame myFrame;
    private DefaultListModel model;

    public HintWindow(List<String> elements, final JTextField textField) {

        for (String element : elements) {
            model.addElement(element);
        }

        myFrame = new JFrame();
        myFrame.setLocation(650, 370);
        myFrame.setSize(500, 280);
        myFrame.setResizable(false);
        myFrame.add(myPanel, BorderLayout.CENTER);
        myFrame.setTitle("Available values");
        myFrame.setVisible(true);

        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = myList.getSelectedIndex();
                if (index == -1) {
                    myFrame.dispose();
                    return;
                }
                String value = model.get(index).toString();
                if (value.contains(" ")) {
                    value = value.substring(0, value.indexOf(" "));
                }

                textField.setText(value);
                myFrame.dispose();
            }
        });
    }

    private void createUIComponents() {
        model = new DefaultListModel();
        myList = new JList(model);
    }
}
