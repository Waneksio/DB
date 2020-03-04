package pl.put.poznan;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import pl.put.poznan.Table;

public class Controller {
    List<Table> tables = new ArrayList<Table>();

    Controller() {
        tables.add(new Table("buildings", 2));
        tables.add(new Table("happenings", 4));
        tables.add(new Table("happenings_participations", 3));
        tables.add(new Table("members", 6));
        tables.add(new Table("organization_details", 3));
        tables.add(new Table("positions", 2));
        tables.add(new Table("projects", 5));
        tables.add(new Table("projects_participations", 2));
        tables.add(new Table("rooms", 2));
        tables.add(new Table("sponsors", 2));
        tables.add(new Table("warrants", 2));
        tables.add(new Table("workers", 9));
    }
    void updateTable(Connection connection, String tableName, String record, String columns) throws SQLException {
        String query = "select * from " + tableName;
        Statement stmt;

        stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

        ResultSet rs;
        rs = stmt.executeQuery(query);

        int changes;
        query = "insert into " + tableName + columns + record;
        changes = stmt.executeUpdate(query);
    }

    ResultSet getResultSet(Connection connection, String query) throws SQLException{
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

    void displayResult(Connection connection, String query, String tableName) throws SQLException{
        int columnsCount = 0;
        for (Table table : tables) {
            if (table.tableName.equals(tableName)) {
                columnsCount = table.columnsCount;
                break;
            }
        }
        System.out.println(columnsCount);
        ResultSet rs = this.getResultSet(connection, query);
        while (rs.next()) {
            for (int i = 1; i < columnsCount; i++) {
                System.out.println(rs.getString(i));
            }
        }
    }
}

