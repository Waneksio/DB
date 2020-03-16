package pl.put.poznan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

enum DataType {
    T_TEXT,
    T_NUMBER,
    T_DATE,
    T_SINGLE_WORD,
    T_EMAIL,
    T_PHONE,
    T_ID
}

public class Record {
    public String mColName;
    public DataType mDataType;
    public int mCharNumber;
    public boolean mNullable;
    public String mForeignKey;
    public List<String> mRelated;

    public Record(String colName, DataType dataType, int charNumber) {
        mRelated = new ArrayList<>();
        mColName = colName;
        mDataType = dataType;
        mCharNumber = charNumber;
        mNullable = false;
        mForeignKey = null;
    }

    public Record(String colName, DataType dataType, int charNumber, boolean Nullable) {
        mRelated = new ArrayList<>();
        mColName = colName;
        mDataType = dataType;
        mCharNumber = charNumber;
        mNullable = Nullable;
        mForeignKey = null;
    }

    public Record(String colName, DataType dataType, int charNumber, String foreignKey) {
        mRelated = new ArrayList<>();
        mColName = colName;
        mDataType = dataType;
        mCharNumber = charNumber;
        mNullable = false;
        mForeignKey = foreignKey;
    }

    public Record(String colName, DataType dataType, int charNumber, boolean Nullable, String foreignKey) {
        mRelated = new ArrayList<>();
        mColName = colName;
        mDataType = dataType;
        mCharNumber = charNumber;
        mNullable = Nullable;
        mForeignKey = foreignKey;
    }

    public Record(String colName, DataType dataType, int charNumber, String[] foreignKeys) {
        mRelated = new ArrayList<>();
        mColName = colName;
        mDataType = dataType;
        mCharNumber = charNumber;
        mNullable = false;
        mRelated.addAll(Arrays.asList(foreignKeys));
    }
}
