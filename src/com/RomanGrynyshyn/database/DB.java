package com.RomanGrynyshyn.database;

import com.RomanGrynyshyn.engine.Rider;

import java.sql.*;

public class DB {
    protected static final String URL = "jdbc:mysql://127.0.0.1:3306/timingsystemdb?autoReconnect=true&useSSL=false";
    protected static final String USER = "Roman";
    protected static final String PASSWORD = "12345";


    public static void createTable() {

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS riders (id INT(5) NOT NULL AUTO_INCREMENT PRIMARY KEY , number VARCHAR(5)," +
                    "name VARCHAR(50),category VARCHAR(50) , qualify_time VARCHAR(15), final_time VARCHAR (15))");
            System.out.println("table created");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void addRider(Rider rider) {

        String query = "INSERT INTO timingsystemdb.riders (number, name, category, qualify_time,final_time) " +
                "VALUES ('" + rider.getNumber() + "', '" + rider.getName() + "', '" + rider.getCategory() + "',0,0);";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {
            statement.execute(query);
            System.out.println("rider added");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void editRider(Rider rider) {
        String query = "UPDATE timingsystemdb.riders SET " +
                "number=" + rider.getNumber() + "," +
                "name=" + rider.getName() + "," +
                "category=" + rider.getCategory() + "," +
                " WHERE number='" + rider.getNumber()+"'";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
            System.out.println("rider edited");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void setQualifyTime(Rider rider) {
        String query="UPDATE timingsystemdb.riders SET qualify_time="+rider.getTime()+" WHERE number=" + rider.getNumber()+";";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {
            statement.execute(query);
            System.out.println("qualify time setted");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void setFinalTime(Rider rider) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {
            statement.execute("INSERT INTO timingsystemdb.riders (final_time) VALUE " + rider.getTime());
            System.out.println("final time setted");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static Rider getRider(String number) {

        Rider findedRider = new Rider();
        findedRider.setNumber(number);
        String query="SELECT name,category FROM timingsystemdb.riders WHERE number= '" + number + "';";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement())
        {
            ResultSet set = statement.executeQuery(query);
            while (set.next()) {
                findedRider.setName(set.getString(1));
                findedRider.setCategory(set.getString(2));

            }
            if (findedRider.getName()!=null){System.out.println("rider found");}
            else System.out.println("rider not found");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return findedRider;
    }


    public static void deleteRider(Rider rider) {

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {
            ResultSet set = statement.executeQuery("DELETE * FROM riders WHERE number=" + rider.getNumber());

            System.out.println("rider deleted");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
