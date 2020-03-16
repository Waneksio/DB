package pl.put.poznan;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import pl.put.poznan.Table;

import javax.management.Query;

public class Controller {
    public List<Table> tables = new ArrayList<Table>();
    Controller() {
        Record address = new Record("address", DataType.T_TEXT, 50, new String[] {"rooms"});
        Record warrantName = new Record("name", DataType.T_TEXT, 50, new String[] {"workers", "members"});
        Record positionName = new Record("name", DataType.T_TEXT, 50, new String[] {"workers"});
        Record buildingAddress = new Record("address", DataType.T_TEXT, 50, "buildings");
        Record name = new Record("name", DataType.T_TEXT, 50);
        Record start_date = new Record("start_date", DataType.T_DATE, -1);
        Record location = new Record("location", DataType.T_TEXT, 50);
        Record people = new Record("people", DataType.T_NUMBER, 4, true);
        Record member = new Record("member", DataType.T_NUMBER, 5, "members");
        Record happening_name = new Record("happening_name", DataType.T_TEXT, 50, "happenings");
        Record happening_start = new Record("happening_start", DataType.T_DATE, -1);
        Record id = new Record("id", DataType.T_ID, 5, true);
        Record surname = new Record("surname", DataType.T_SINGLE_WORD, 50);
        Record email = new Record("email", DataType.T_EMAIL, 100);
        Record phone_nr = new Record( "phone_nr", DataType.T_PHONE, 9, true);
        Record warrant = new Record("warrant", DataType.T_SINGLE_WORD, 9, "warrants");
        Record sponsor = new Record("sponsor", DataType.T_TEXT, 50, "sponsors");
        Record salary = new Record("salary", DataType.T_NUMBER, 6);
        Record description = new Record("description", DataType.T_TEXT, 200);
        Record notes = new Record("notes", DataType.T_TEXT, 200);
        Record end_date = new Record("end_date", DataType.T_DATE, -1, true);
        Record worker = new Record("worker", DataType.T_NUMBER, 5, "workers");
        Record project_id = new Record("project_id", DataType.T_TEXT, 50, "projects");
        Record room_nr = new Record("room_nr", DataType.T_NUMBER, 4, new String[] {"workers"});
        Record alms = new Record("alms", DataType.T_NUMBER, 10, true);
        Record privileges_list = new Record("privileges_list", DataType.T_TEXT, 200);
        Record position = new Record("position", DataType.T_SINGLE_WORD, 50, "positions");
        Record building = new Record("building", DataType.T_TEXT, 50, "buildings");
        Record room = new Record("room", DataType.T_NUMBER, 4, "rooms");
        Record id_prac = new Record("id_prac", DataType.T_NUMBER, 6);
        Record nazwisko = new Record("nazwisko", DataType.T_SINGLE_WORD, 15, true);
        Record etat = new Record("etat", DataType.T_SINGLE_WORD, 10, true, "etaty");
        Record id_szefa = new Record("id_szefa", DataType.T_NUMBER, 6, true);
        Record zatrudniony = new Record("zatrudniony", DataType.T_DATE, -1, true);
        Record placa_pod = new Record("placa_pod", DataType.T_NUMBER, 7, true);
        Record placa_dod = new Record("placa_dod", DataType.T_NUMBER, 6, true);
        Record id_zesp = new Record("id_zesp", DataType.T_NUMBER, 4, true, "zespoly");
        List<Record> buildings = new ArrayList<Record>();
        buildings.add(address);
        buildings.add(name);
        List<Record> happenings = new ArrayList<Record>();
        happenings.add(name);
        happenings.add(start_date);
        happenings.add(location);
        happenings.add(people);
        List<Record> happenings_participations =new ArrayList<Record>();
        happenings_participations.add(member);
        happenings_participations.add(happening_name);
        happenings_participations.add(happening_start);
        List<Record> members = new ArrayList<Record>();
        members.add(id);
        members.add(name);
        members.add(surname);
        members.add(email);
        members.add(phone_nr);
        members.add(warrant);
        List<Record> organization_details = new ArrayList<Record>();
        organization_details.add(sponsor);
        organization_details.add(happening_name);
        organization_details.add(happening_start);
        List<Record> positions = new ArrayList<Record>();
        positions.add(positionName);
        positions.add(salary);
        List<Record> projects = new ArrayList<Record>();
        projects.add(name);
        projects.add(description);
        projects.add(notes);
        projects.add(start_date);
        projects.add(end_date);
        List<Record> projects_participations = new ArrayList<>();
        projects_participations.add(worker);
        projects_participations.add(project_id);
        List<Record> rooms = new ArrayList<Record>();
        rooms.add(room_nr);
        rooms.add(buildingAddress);
        List<Record> sponsors = new ArrayList<Record>();
        sponsors.add(name);
        sponsors.add(alms);
        List<Record> warrants = new ArrayList<Record>();
        warrants.add(warrantName);
        warrants.add(privileges_list);
        List<Record> workers = new ArrayList<Record>();
        workers.add(id);
        workers.add(name);
        workers.add(surname);
        workers.add(email);
        workers.add(position);
        workers.add(phone_nr);
        workers.add(warrant);
        workers.add(building);
        workers.add(room);
        List<Record> pracownicy = new ArrayList<Record>();
        pracownicy.add(id_prac);
        pracownicy.add(nazwisko);
        pracownicy.add(etat);
        pracownicy.add(id_szefa);
        pracownicy.add(zatrudniony);
        pracownicy.add(placa_pod);
        pracownicy.add(placa_dod);
        pracownicy.add(id_zesp);
        tables.add(new Table("buildings", buildings, new int[] {1}));
        tables.add(new Table("happenings", happenings, new int[] {1, 2}));
        tables.add(new Table("happenings_participations", happenings_participations, new int[] {1, 2, 3}));
        tables.add(new Table("members", members, new int[] {1}, new int[] {1, 2, 3}));
        tables.add(new Table("organization_details", organization_details, new int[] {1, 2, 3}));
        tables.add(new Table("positions", positions, new int[] {1}));
        tables.add(new Table("projects", projects, new int[] {1, 4}));
        tables.add(new Table("projects_participations", projects_participations, new int[] {1, 2}));
        tables.add(new Table("rooms", rooms, new int[] {1, 2}));
        tables.add(new Table("sponsors", sponsors, new int[] {1}));
        tables.add(new Table("warrants", warrants, new int[] {1}));
        tables.add(new Table("workers", workers, new int[] {1}, new int[] {1, 2, 3}));
        tables.add(new Table("pracownicy", pracownicy, new int[] {1}));
    }

    boolean existsInTable (Connection connection, String tableName, List<String> keyColumns, List<String> keyValues) throws SQLException {
        String query = "select * from " + tableName + " where ";
        for (int i = 0; i < keyValues.size(); i++) {
            query += keyColumns.get(i) + " = " + keyValues.get(i);
            if (i < keyValues.size() - 1)
                query += " AND ";
        }
        System.out.println(query);
        ResultSet rs = getResultSet(connection, query);
        return rs.next();
    }

    boolean updateTable(Connection connection, String tableName, String columns, String records, List<String> keyValues, List<String> keyColumns, boolean change, List<String> columnsArray, List<String> recordsArray, List<String> oldValues) throws SQLException {
        if (!change) {
            Table temporaryTable = getTableByName(tableName);
            int j = 0;
            for (String keyColumn : keyColumns) {
                Record temporaryRecord = getRecordByName(temporaryTable, keyColumn);
                for (String relatedTableName : temporaryRecord.mRelated) {
                    Table relatedTable = getTableByName(relatedTableName);
                    for (Record record : relatedTable.mRecords) {
                        if (record.mForeignKey != null) {
                            if (record.mForeignKey.equals(tableName)) {
                                if (isColliding(relatedTableName, connection, record.mColName, oldValues.get(j), record.mDataType)) {
                                    for (int i = 0; i < keyValues.size(); i++) {
                                        if (!keyValues.get(i).equals(oldValues.get(i)))
                                            return false;
                                    }
                                }
                            }
                        }
                    }
                }
                j++;
            }
        }
        Statement stmt;
        stmt = connection.createStatement();

        if (keyValues.isEmpty() && (change)) {
            String query = "insert into " + tableName + " (" + columns + ") values (" + records + ")";
            System.out.println(query);
            stmt.executeUpdate(query);
            return true;
        }
        String checkQuery = "select * from " + tableName + " WHERE ";
        for (int i = 0; i < keyValues.size(); i++) {
            checkQuery += keyColumns.get(i) + " = " + keyValues.get(i);
            if (i < keyValues.size() - 1)
                checkQuery += " AND ";
        }

        System.out.println(checkQuery);

        ResultSet rs = stmt.executeQuery(checkQuery);

        if (rs.next()) {
            if (change)
                return false;
        }

        if (change) {
            String query = "insert into " + tableName + " (" + columns + ") values (" + records + ")";
            System.out.println(query);
            stmt.executeUpdate(query);
            return true;
        }
        else {
            String query = "update " + tableName + " set ";
            for (int i = 0; i < columnsArray.size(); i++) {
                query += columnsArray.get(i) + " = " + recordsArray.get(i);
                if (i < columnsArray.size() - 1)
                    query += ", ";
            }
            query += " where ";
            for (int i = 0; i < keyColumns.size(); i++) {
                query += keyColumns.get(i) + " = " + oldValues.get(i);
                if (i < keyColumns.size() - 1)
                    query += " AND ";
            }
            System.out.println(query);
            stmt.executeQuery(query);
            return true;
        }
    }

    private boolean isColliding(String tableName, Connection connection, String columnName, String valueToCheck, DataType dataType) throws SQLException{
        String query = "select * from " + tableName + " where " + columnName + " = " + valueToCheck;
        System.out.println(query);
        ResultSet rs = getResultSet(connection, query);
        return rs.next();
    }

    private Table getTableByName(String name) {
        for (Table table : tables) {
            if (table.tableName.equals(name))
                return table;
        }
        return null;
    }

    private Record getRecordByName(Table table, String name) {
        for (Record record : table.mRecords) {
            if (record.mColName.equals(name))
                return record;
        }
        return null;
    }

    boolean deleteFromTable(Connection connection, String tableName, List<String> keyColumns, List<String> keyValues) throws SQLException {
        Table temporaryTable = getTableByName(tableName);
        int j = 0;
        for (String keyColumn : keyColumns) {
            Record temporaryRecord = getRecordByName(temporaryTable, keyColumn);
            for (String relatedTableName : temporaryRecord.mRelated) {
                Table relatedTable = getTableByName(relatedTableName);
                for (Record record : relatedTable.mRecords) {
                    if (record.mForeignKey != null) {
                        if (record.mForeignKey.equals(tableName)) {
                            if (isColliding(relatedTableName, connection, record.mColName, keyValues.get(j), record.mDataType)) {
                                return false;
                            }
                        }
                    }
                }
            }
            j++;
        }

        String checkQuery = "select * from " + tableName + " where ";
        for (int i = 0; i < keyValues.size(); i++) {
            checkQuery += keyColumns.get(i) + " = " + keyValues.get(i);
            if (i < keyValues.size() - 1)
                checkQuery += " AND ";
        }

        Statement stmt;
        stmt = connection.createStatement(); //(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

        ResultSet rs = stmt.executeQuery(checkQuery);

        if(!rs.next())
            return false;

        String query = "delete from " + tableName + " where ";

        for (int i = 0; i < keyColumns.size(); i++) {
            query += keyColumns.get(i) + " = " + keyValues.get(i);
            if (i < keyColumns.size() - 1)
                query += " AND ";
        }

        stmt.executeQuery(query);
        return true;
    }

    static ResultSet getResultSet(Connection connection, String query) throws SQLException{
        Statement stmt;
        stmt = connection.createStatement();

        ResultSet resultSet;
        resultSet = stmt.executeQuery(query);

        return resultSet;
    }

    static Connection login (String login, String password) throws SQLException {
        Connection connection = null;
        Properties connectionProps = new Properties();
        connectionProps.put("user", login);
        connectionProps.put("password", password);

        connection = DriverManager.getConnection("jdbc:oracle:thin:@//admlab2.cs.put.poznan.pl:1521/" + "dblab02_students.cs.put.poznan.pl", connectionProps);
        return connection;
    }

    Table displayResult(Connection connection, String query, String tableName, String[][] target, int[] keyIndexes, String[] colNames) throws SQLException{
        int columnsCount = 0;
        Table resultTable = null;
        String finalQuery = "";
        finalQuery += query;
        for (Table table : tables) {
            if (table.tableName.equals(tableName)) {
                finalQuery += " order by " + table.attributes.get(0);
                columnsCount = table.columnsCount;
                resultTable = table;
                int i = 0;
                for (int index : table.keyAttributes) {
                    keyIndexes[i] = index;
                    i++;
                }

                i = 0;
                for (String colName : table.attributes) {
                    colNames[i] = colName;
                    i++;
                }

                break;
            }
        }
        ResultSet rs = this.getResultSet(connection, finalQuery);
        int j = 0;
        while (rs.next()) {
            if (j > 18)
                break;
            for (int i = 1; i < columnsCount + 1; i++) {
                target[j][i] = rs.getString(i);
            }
            j++;
        }
        return resultTable;
    }

    List<String> getId (Connection connection, String tableName) throws SQLException{
        List<String> result = new ArrayList<String>();
        String query = "select * from ";
        query += tableName;
        int columnCount = 0;
        int[] keyIndexes = new int[] {};
        for (Table table : tables) {
            if (table.tableName.equals(tableName)) {
                keyIndexes = table.keyAttributes;
                columnCount = table.columnsCount;
            }
        }
        System.out.println(keyIndexes);
        ResultSet rs = this.getResultSet(connection, query);
        while (rs.next()) {
            String partialResult = "";
            for (int i = 0; i < columnCount; i++) {
                for (int index : keyIndexes) {
                    if (i + 1 == index) {
                        if ((i > 0) && (!partialResult.equals("")))
                            partialResult += ", ";
                        partialResult += rs.getString(i + 1);
                    }
                }
            }
            result.add(partialResult);
        }
        return result;
    }

    int[] getColumnsToDisplay(String tableName) {
        for (Table table : tables) {
            if (table.tableName == tableName) {
                return table.mColsToDisplay;
            }
        }
        return new int[] {};
    }

    Table getTable (String tableName) {
        for (Table table : tables) {
            if (table.tableName == tableName) {
                return table;
            }
        }
        return null;
    }
}

