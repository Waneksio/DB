package pl.put.poznan;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.StringStack;

import javax.swing.*;
import javax.swing.plaf.basic.BasicSliderUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EditTable {
    private JButton showEditButton;
    private JButton deleteButton;
    private JList myList;
    private JButton addButton;
    private JPanel myPanel;
    private JFrame myFrame;
    private DefaultListModel model;
    private EditRecord editRecordWindow;

    public boolean isOpen() {
        return myFrame.isShowing();
    }

    private void createUIComponents(String[][] elements, int[] columnsToDisplay, String[] selectedRecords) {
        model = new DefaultListModel();
        int j = 0;
        for (String[] elementsArray : elements) {
            String modelText = "";
            int i = 0;
            for (String element : elementsArray) {
                for (int index : columnsToDisplay)
                {
                    if (i == index) {
                        if (element != null)
                            modelText += element + " ";
                    }
                }
                i++;
            }
            model.addElement(modelText);
            selectedRecords[j] = modelText;
            j++;
        }
    }

    public EditTable(final String table, final Connection connection) {
        String[][] elements = new String[20][20];
        final String[] selectedRecords = new String[20];
        final String query = "select * from " + table;
        final Controller controller = new Controller();
        final int[] keyIndexes = new int[4];
        final String [] colNames = new String[9];
        Table tableProperties = null;

        try {
            tableProperties = controller.displayResult(connection, query, table, elements, keyIndexes, colNames);
        }
        catch (SQLException e) {
            elements = new String[][]{{""}};
            System.out.println(e);
        }
        int[] colsToDisplay = controller.getColumnsToDisplay(table);
        createUIComponents(elements, colsToDisplay, selectedRecords);
        myList.setModel(model);
        myList.setVisibleRowCount(5);
        myFrame = new JFrame();
        myFrame.setLocation(650, 370);
        myFrame.setSize(500, 280);
        myFrame.setResizable(false);
        myFrame.add(myPanel, BorderLayout.CENTER);
        myFrame.setTitle("Projekt");
        myFrame.setVisible(true);

        final String[][] finalElements = elements;
        final Table finalTableProperties = tableProperties;
        final int columnCount = tableProperties.columnsCount;
        showEditButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = myList.getSelectedIndex();
                if (index == -1)
                    return;
                editRecordWindow = new EditRecord(columnCount, colNames, finalElements[index], connection, controller, table, false, finalTableProperties);
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editRecordWindow = new EditRecord(columnCount, colNames, finalElements[0], connection, controller, table, true, finalTableProperties);
            }
        });


        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = myList.getSelectedIndex();
                if (index == -1)
                    return;
                List<String> keyColumns = new ArrayList<String>();
                List<String> keyValues = new ArrayList<String>();
                for (int i = 0; i < finalTableProperties.columnsCount; i++) {
                    for (int keyColumn : finalTableProperties.keyAttributes) {
                        if (keyColumn == i + 1) {
                            String keyValue = "";
                            keyValue += finalElements[index][i + 1];
                            if (finalTableProperties.mRecords.get(i).mDataType != 2)
                                keyValue = "'" + keyValue + "'";
                            keyValues.add(keyValue);
                            keyColumns.add(colNames[i]);
                        }
                    }
                }
                try {
                    controller.deleteFromTable(connection, table, keyColumns, keyValues);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                new ErrorWindow("Element deleted");
                myFrame.dispose();
            }
        });
    }
    private void createUIComponents() {
        model = new DefaultListModel();
        myList = new JList(model);
    }
}
