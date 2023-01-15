package UI;

import java.sql.*;

public class DatabaseCon {
    static final String driver="org.postgresql.Driver";
    static final String URL="jdbc:postgresql://localhost:5432/social_media";
    static final String user="postgres";
    static final String password="darius2002";

    Connection connection;
    Statement statement;
    ResultSet resultSet;

    public DatabaseCon() {
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    public ResultSet getResultSet() {
        return resultSet;
    }

    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

    public void executeQuery(String query){
        try {
            Class.forName(driver);

            connection= DriverManager.getConnection(URL, user, password);
            statement= connection.createStatement();
            statement.executeQuery(query);
            connection.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public int executeSelection(String query, Object[] var, int col) {
        int index = 0;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(URL, user, password);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                var[index++] = resultSet.getObject(col);
            }
            connection.close();
            return index;
        } catch (Exception e) {
            return index;
        }
    }
    public void oneString(String query, String sol, int col) {
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(URL, user, password);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                sol=resultSet.getString(col);
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
