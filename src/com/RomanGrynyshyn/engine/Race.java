package com.RomanGrynyshyn.engine;

import java.util.HashMap;
import java.util.Map;

public class Race {
    Rider rider;
    private int riderOnStart;

    private Map<Integer,Rider> ridersOnTrack=new HashMap<>();





    public void start(){
        rider=new Rider();
        ridersOnTrack.put(rider.getRiderNumber(),rider);

    }
    public void finish(){

    }

}
