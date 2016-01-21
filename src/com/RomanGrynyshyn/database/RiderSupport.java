package com.RomanGrynyshyn.database;

/*
public class RiderSupport extends DB implements RiderSupportInterface {
    @Override
    public void addRider(Rider rider) {
        Connection connection = null;
        Statement statement = null;
        String query = "INSERT INTO" + rider.getRiderCategory() + ".TimingSystem (number, name)\n"
                + "VALUES (" + rider.getRiderNumber() + "," + rider.getRiderName() + ")";
        try {
            connection = openConnection();
            statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException sqlEX) {
            sqlEX.printStackTrace();
        } finally {
            closeConnection(connection);
            closeStatement(statement);
        }
/*
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
}
*/