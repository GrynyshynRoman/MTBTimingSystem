package com.RomanGrynyshyn.gui;

import com.RomanGrynyshyn.engine.RaceData;
import com.RomanGrynyshyn.engine.Rider;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrationEngine implements ActionListener {

    RegistrationWindow parent;
    RegistrationEngine(RegistrationWindow parent){
        this.parent=parent;
    }
    public RaceData raceData=new RaceData();
    public void actionPerformed(ActionEvent e){
        JButton clickedButton= (JButton)e.getSource();
        Object source=e.getSource();
        if(source==parent.addRider) {
            Rider rider = new Rider();
            rider.setRiderNumber(Integer.parseInt(parent.riderNumber.getText()));
            rider.setRiderName(parent.riderName.getText());
            /* refactor for enum-type
            rider.setRiderCategory(riderCategory.getText());
            */
            switch (rider.getRiderCategory()) {
                case "Elite":
                    raceData.eliteRidersData.put(rider.getRiderNumber(), rider);
                    break;
                case "Masters":
                    raceData.masterRidersData.put(rider.getRiderNumber(), rider);
                    break;
                case "Junior":
                    raceData.juniorRidersData.put(rider.getRiderNumber(), rider);
                    break;
                case "Woman":
                    raceData.womanRidersData.put(rider.getRiderNumber(), rider);
                    break;
                case "Amateur":
                    raceData.amateurRidersData.put(rider.getRiderNumber(), rider);
                    break;
            }
        }


        }


    public RegistrationEngine(){}
}





