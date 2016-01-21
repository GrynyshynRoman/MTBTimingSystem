package com.RomanGrynyshyn.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DB  {
    private static final String url="jdbc:mysql://localhost:3306/TimingSystemDB";
    private static final String user="root";
    private static final String password="12345";

    private static Connection connection=null;
    private static Statement statement=null;

    protected static Connection openConnection(){
        try {
            connection = DriverManager.getConnection(url, user, password);
            return connection;
        }catch (SQLException sqlEx){
            sqlEx.printStackTrace();
        }
        return null;
    }
    protected static void closeConnection(Connection connection){
        try{
            connection.close();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
    protected static void closeStatement(Statement statement){
        try{
            statement.close();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
    public static void createDB(){
        try{
            connection=openConnection();
            statement=connection.createStatement();
            statement.executeUpdate("CREATE TABLE ");
        }catch (SQLException ex){
            ex.printStackTrace();
        }finally {
            closeStatement(statement);
            closeConnection(connection);
        }

    }

}
