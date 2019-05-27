package util;

import beans.Pizza;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBConnection {

    private static ArrayList<Connection> connections = new ArrayList<Connection>();

    public static Connection createConnection(Boolean toListConnection)
    {
        Connection con = null;
        String url = "jdbc:mysql://localhost:3306/pizza?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
        try
        {
            con = DriverManager.getConnection(url,"root",""); //attempting to connect to MySQL database
            if(toListConnection) {
                connections.add(con);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return con;
    }

    public static ResultSet makeRequestSelect(String request) {
        Connection con = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            con = DBConnection.createConnection(true); //establishing connection
            statement = con.createStatement(); //Statement is used to write queries. Read more about it.
            resultSet = statement.executeQuery(request); //Here table name is users and userName,password are columns. fetching all the records and storing in a resultSet.
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int makeRequestInsert(String request,Boolean toListConnection)
    {
        Connection con = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            con = DBConnection.createConnection(toListConnection); //establishing connection
            statement = con.createStatement(); //Statement is used to write queries. Read more about it.
            int affectedRows = statement.executeUpdate(request); //Here table name is users and userName,password are columns. fetching all the records and storing in a resultSet.

            ResultSet generatedKeys = statement.getGeneratedKeys();
            int id = 0;
            if (affectedRows != 0){
                generatedKeys.next();
                id = generatedKeys.getInt(1);
                //connections.remove(con);
            }
            con.close();
            return id;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int makeRequestInsert(String request) {
        return makeRequestInsert(request,true);
    }
    public static void clearConnections()
    {
        for(Connection con : connections)
        {
            try {
                con.close();
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
        }
        connections.clear();
    }
}
