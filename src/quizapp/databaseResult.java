package quizapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


class databaseResult {

    private ResultSet result;
    private PreparedStatement statement;

    databaseResult(String table) throws Exception {

        String pass = "SELECT * FROM " + table;
        Class.forName("com.mysql.jdbc.Driver"); //Starts the driver class that initiates connector statements
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz", "root", ""); //connects to the root of database MYSQL
        statement = con.prepareStatement(pass); //Statemnt that converts java code to mysqlcode (QUERY)
        result = statement.executeQuery(); //result taken from mysql database
    }

    public ResultSet getResult() {
        return result;
    }

    public PreparedStatement getStatement() {
        return statement;
    }
}
