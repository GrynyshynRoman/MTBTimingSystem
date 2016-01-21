package com.RomanGrynyshyn.database;


import com.RomanGrynyshyn.engine.Rider;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class RiderSupport extends DB implements RiderSupportInterface {
    @Override
    public void addRider(Rider rider) {
        Connection connection = null;
        Statement statement = null;
        String query = "INSERT INTO timingsystemdb.riders (number, name)" +
                "VALUES ('" + rider.getRiderNumber() + "','" + rider.getRiderName() + "')";
        try {
            connection = openConnection();
            statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("rider added");
        } catch (SQLException sqlEX) {
            sqlEX.printStackTrace();
        } finally {
            closeConnection(connection);
            closeStatement(statement);
        }
    }

    @Override
    public void editRider(Rider rider) {

    }

    @Override
    public Rider findRider(Rider rider) {
        return null;
    }

    @Override
    public void deleteRider(Rider rider) {

    }


}
