package com.RomanGrynyshyn;

import com.RomanGrynyshyn.database.DB;

import java.io.IOException;

public class MTBTimingSystem {
    public static void main(String[] args) throws IOException {

        //UserWindow userWindow =new UserWindow();
        DB data=new DB();
        data.createDB();
    }
}
