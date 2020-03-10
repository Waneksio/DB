package pl.put.poznan;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Table {
    public String tableName;
    public int columnsCount;
    public List<String> attributes;
    public List<Record> mRecords;
    public int[] keyAttributes;
    public Table(String name, List<Record> records, int[] keyAttribs) {
        this.tableName = name;
        this.attributes = new ArrayList<>();
        keyAttributes = new int[keyAttribs.length];
        System.arraycopy(keyAttribs, 0, keyAttributes, 0, keyAttribs.length);
        int i = 0;
        for (Record record : records) {
            attributes.add(record.mColName);
            i++;
        }
        mRecords = new ArrayList<Record>();
        mRecords.addAll(records);
        this.columnsCount = i;
    }
}
