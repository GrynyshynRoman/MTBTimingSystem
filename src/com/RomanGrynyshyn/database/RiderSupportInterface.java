package com.RomanGrynyshyn.database;

import com.RomanGrynyshyn.engine.Rider;

public interface RiderSupportInterface {
    void addRider(Rider rider);
    void deleteRider(Rider rider);
    void editRider(Rider rider);
    Rider findRider(Rider rider);
}
