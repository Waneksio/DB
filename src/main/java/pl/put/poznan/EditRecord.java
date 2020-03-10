package pl.put.poznan;

import javax.swing.*;
import javax.swing.plaf.basic.BasicSliderUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;
import java.util.List;

public class EditRecord {
    private JPanel myPanel;
    private JButton saveChangesButton;
    private JButton cancelButton;
    private JButton button1;
    private JTextField textField1;
    private JButton button2;
    private JTextField textField2;
    private JButton button3;
    private JTextField textField3;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTextField textField4;
    private JButton button4;
    private JTextField textField5;
    private JButton button5;
    private JTextField textField6;
    private JButton button6;
    private JTextField textField7;
    private JButton button7;
    private JTextField textField8;
    private JButton button8;
    private JTextField textField9;
    private JButton button9;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    private JLabel label9;
    private JFrame myFrame;

    private List<JButton> buttons = new ArrayList<JButton>();
    private List<JTextField> textFields = new ArrayList<JTextField>();
    private List<JLabel> labels = new ArrayList<JLabel>();

    public boolean isOpen() {
        return myFrame.isShowing();
    }

    public EditRecord(final int columnCount, final String[] colNames, final String[] record, final Connection conn, final Controller controller, final String tableName, final boolean change, final Table table) {
        /* SETUP
        ---------------------------------------------------------------------------*/
        /* BUTTONS SETUP
        ---------------------------------------------------------------------------*/
        buttons.add(button1);
        buttons.add(button2);
        buttons.add(button3);
        buttons.add(button4);
        buttons.add(button5);
        buttons.add(button6);
        buttons.add(button7);
        buttons.add(button8);
        buttons.add(button9);

        /* TEXT FIELDS SETUP
        ---------------------------------------------------------------------------*/
        textFields.add(textField1);
        textFields.add(textField2);
        textFields.add(textField3);
        textFields.add(textField4);
        textFields.add(textField5);
        textFields.add(textField6);
        textFields.add(textField7);
        textFields.add(textField8);
        textFields.add(textField9);

        /* LABELS SETUP
        ---------------------------------------------------------------------------*/
        labels.add(label1);
        labels.add(label2);
        labels.add(label3);
        labels.add(label4);
        labels.add(label5);
        labels.add(label6);
        labels.add(label7);
        labels.add(label8);
        labels.add(label9);

        int i = 0;
        for (JLabel label : labels) {
            label.setText(colNames[i]);
            i++;
            if (i > columnCount - 1)
                break;
        }

        i = 0;

        for (JTextField textField : textFields) {
            if (table.mRecords.get(i).mDataType == 3)
                textField.setToolTipText("Date format: 'YYYY-MM-DD'");
            if (table.mRecords.get(i).mDataType == 1) {
                String message = "String of characters of a maximum length of " + table.mRecords.get(i).mCharNumber + " characters";
                textField.setToolTipText(message);
            }
            if (table.mRecords.get(i).mDataType == 2) {
                String message = "Any number of a maximum length of " + table.mRecords.get(i).mCharNumber + " digits";
                textField.setToolTipText(message);
            }
            i++;
            if (!change)
                textField.setText(record[i]);
            textField.setEditable(false);
            if (i > columnCount - 1)
                break;
        }

        i = 0;
        for (JButton button : buttons) {
            if (i < columnCount) {
                i++;
                continue;
            }
            button.setVisible(false);
            i++;
        }

        i = 0;
        for (JTextField textField : textFields) {
            if (i < columnCount) {
                i++;
                continue;
            }
            textField.setVisible(false);
            i++;
        }

        i = 0;
        for (JLabel label : labels) {
            if (i < columnCount) {
                i++;
                continue;
            }
            label.setVisible(false);
            i++;
        }

        myFrame = new JFrame();
        myFrame.setLocation(650, 260);
        myFrame.setSize(500, 500);
        myFrame.setResizable(false);
        myFrame.add(myPanel, BorderLayout.CENTER);
        myFrame.setTitle("Projekt");
        myFrame.setVisible(true);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (button1.getText() == "Edit") {
                    button1.setText("Save");
                    textField1.setEditable(true);
                }
                else {
                    button1.setText("Edit");
                    textField1.setEditable(false);
                }
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (button2.getText() == "Edit") {
                    button2.setText("Save");
                    textField2.setEditable(true);
                }
                else {
                    button2.setText("Edit");
                    textField2.setEditable(false);
                }
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (button3.getText() == "Edit") {
                    button3.setText("Save");
                    textField3.setEditable(true);
                }
                else {
                    button3.setText("Edit");
                    textField3.setEditable(false);
                }
            }
        });
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (button4.getText() == "Edit") {
                    button4.setText("Save");
                    textField4.setEditable(true);
                }
                else {
                    button4.setText("Edit");
                    textField4.setEditable(false);
                }
            }
        });
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (button5.getText() == "Edit") {
                    button5.setText("Save");
                    textField5.setEditable(true);
                }
                else {
                    button5.setText("Edit");
                    textField5.setEditable(false);
                }
            }
        });
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (button6.getText() == "Edit") {
                    button6.setText("Save");
                    textField6.setEditable(true);
                }
                else {
                    button6.setText("Edit");
                    textField6.setEditable(false);
                }
            }
        });
        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (button7.getText() == "Edit") {
                    button7.setText("Save");
                    textField7.setEditable(true);
                }
                else {
                    button7.setText("Edit");
                    textField7.setEditable(false);
                }
            }
        });
        button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (button8.getText() == "Edit") {
                    button8.setText("Save");
                    textField8.setEditable(true);
                }
                else {
                    button8.setText("Edit");
                    textField8.setEditable(false);
                }
            }
        });
        button9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (button9.getText() == "Edit") {
                    button9.setText("Save");
                    textField9.setEditable(true);
                }
                else {
                    button9.setText("Edit");
                    textField9.setEditable(false);
                }
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myFrame.dispose();
            }
        });
        saveChangesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int k = 0;
                String values = "";
                String columns = "";
                List<String> valuesArray= new ArrayList<String>();
                List<String> columnsArray = new ArrayList<String>();
                List<String> keyValues = new ArrayList<String>();
                List<String> keyColumns = new ArrayList<String>();
                for (Record record1 : table.mRecords) {
                    String valueToInsert = "";
                    if ((!record1.mNullable) && textFields.get(k).getText().equals("")) {
                        new ErrorWindow("Value " + record1.mColName + " cannot be empty");
                        return;
                    }
                    if (record1.mDataType == 2) {
                        if ((textFields.get(k).getText().matches("[^0-9]*?")) && !(textFields.get(k).getText().equals(""))) {
                            new ErrorWindow("Invalid data type at " + record1.mColName);
                            return;
                        }
                        if (textFields.get(k).getText().length() > record1.mCharNumber) {
                            new ErrorWindow("To many characters at " + record1.mColName);
                            return;
                        }
                        if (!textFields.get(k).getText().equals(""))
                            valueToInsert += textFields.get(k).getText();
                    }

                    if (record1.mDataType == 3) {
                        String dateVal = textFields.get(k).getText();
                        if (!dateVal.equals("")) {
                            if (!dateVal.matches("[1-2][0-9][0-9][0-9]-[0-1][0-9]-[0-3][0-9]")) {
                                new ErrorWindow("Invalid date format at " + record1.mColName);
                                return;
                            }
                            int index = dateVal.indexOf("-");
                            int year = Integer.parseInt(dateVal.substring(0, index));
                            dateVal = dateVal.substring(index + 1, dateVal.length());
                            index = dateVal.indexOf("-");
                            int month = Integer.parseInt(dateVal.substring(0, index));
                            int day = Integer.parseInt(dateVal.substring(index + 1, dateVal.length()));
                            if (year > 2020) {
                                new ErrorWindow("There is no such date " + record1.mColName);
                                return;
                            }
                            if (month > 12) {
                                new ErrorWindow("There is no such date " + record1.mColName);
                                return;
                            }
                            if (day > 31) {
                                new ErrorWindow("There is no such date " + record1.mColName);
                                return;
                            }
                            if (year == 2020) {
                                if (month > 3) {
                                    new ErrorWindow("There is no such date " + record1.mColName);
                                    return;
                                }
                                if (day > 11) {
                                    new ErrorWindow("There is no such date " + record1.mColName);
                                    return;
                                }
                            }
                            if (month == 2) {
                                if ((year % 4) == 0) {
                                    if ((year % 100) == 0) {
                                        if ((year % 400) == 0) {
                                            if (day > 29) {
                                                new ErrorWindow("There is no such date " + record1.mColName);
                                                return;
                                            }
                                        } else if (day > 28) {
                                            new ErrorWindow("There is no such date " + record1.mColName);
                                            return;
                                        }
                                    } else if (day > 29) {
                                        new ErrorWindow("There is no such date " + record1.mColName);
                                        return;
                                    }
                                } else if (day > 28) {
                                    new ErrorWindow("There is no such date " + record1.mColName);
                                    return;
                                }
                            }
                            if (month == 4 || month == 6 || month == 9 || month == 11) {
                                if (day > 30) {
                                    new ErrorWindow("There is no such date " + record1.mColName);
                                    return;
                                }
                            }
                        }
                        if (!textFields.get(k).getText().equals(""))
                            valueToInsert += "'" + textFields.get(k).getText() + "'";
                    }
                    if (record1.mDataType == 1) {
                        if (!(textFields.get(k).getText().matches("\\w*"))) {
                            if (!(textFields.get(k).getText().equals(""))) {
                                new ErrorWindow("Value at " + record1.mColName + " contains forbidden characters");
                                return;
                            }
                            if (textFields.get(k).getText().length() > record1.mCharNumber) {
                                new ErrorWindow("To many characters at " + record1.mColName);
                                return;
                            }
                        }
                        if (!textFields.get(k).getText().equals(""))
                            valueToInsert += "'" + textFields.get(k).getText() + "'";
                    }
                    if (valueToInsert != "") {
                        if (k != 0) {
                            values += ", ";
                            columns += ", ";
                        }
                        for (int keyAttrib : table.keyAttributes) {
                            if (keyAttrib == k + 1) {
                                keyValues.add(valueToInsert);
                                keyColumns.add(record1.mColName);
                            }
                        }
                        valuesArray.add(valueToInsert);
                        columnsArray.add(record1.mColName);
                        values += valueToInsert;
                        columns += record1.mColName;
                        k++;
                    }
                }

                System.out.println(columns);
                System.out.println(values);
                boolean result;
                try {
                    result = controller.updateTable(conn, tableName, columns, values, keyValues, keyColumns, change, columnsArray, valuesArray);
                }catch (SQLException exception) {
                    System.out.println(exception);
                    result = false;
                }
                if (!result)
                    new ErrorWindow("This element already exists");
                else
                    myFrame.dispose();
            }
        });
    }
}
