package util;

import beans.Pizza;

import java.sql.*;
import java.util.ArrayList;

public class DBConnection {
    public static Connection createConnection()
    {
        Connection con = null;
        String url = "jdbc:mysql://localhost:3306/pizza?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
        try
        {
            con = DriverManager.getConnection(url,"root",""); //attempting to connect to MySQL database
            System.out.println("Printing connection object "+con);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return con;
    }

    public static ResultSet makeRequest(String request)
    {
        Connection con = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            con = DBConnection.createConnection(); //establishing connection
            statement = con.createStatement(); //Statement is used to write queries. Read more about it.
            resultSet = statement.executeQuery(request); //Here table name is users and userName,password are columns. fetching all the records and storing in a resultSet.

            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
