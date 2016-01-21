package com.RomanGrynyshyn;

import com.RomanGrynyshyn.database.DB;
import com.RomanGrynyshyn.database.RiderSupport;
import com.RomanGrynyshyn.engine.Rider;

import java.io.IOException;

public class MTBTimingSystem {
    public static void main(String[] args) throws IOException {

        //UserWindow userWindow =new UserWindow();
        Rider rider=new Rider();
        rider.setRiderName("Roman");
        rider.setRiderNumber("12");
        rider.setRiderCategory("Elite");
        DB data=new DB();
        data.createDB();
        RiderSupport support=new RiderSupport();
        support.addRider(rider);
    }
}
