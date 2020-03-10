package pl.put.poznan;

public class Record {
    public String mColName;
    public int mDataType; // 1 - String, 2 - int, 3 - data
    public int mCharNumber;
    public boolean mNullable;
    public Record(String colName, int dataType, int charNumber) {
        mColName = colName;
        mDataType = dataType;
        mCharNumber = charNumber;
        mNullable = false;
    }

    public Record(String colName, int dataType, int charNumber, boolean Nullable) {
        mColName = colName;
        mDataType = dataType;
        mCharNumber = charNumber;
        mNullable = Nullable;
    }
}
