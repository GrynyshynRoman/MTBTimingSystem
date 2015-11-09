package com.RomanGrynyshyn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MTBTimingSystem {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {

            System.out.println("Add one more rider? Y/N");
            if (reader.readLine().equals("N")) {
                break;
            }

        }
    }
}
