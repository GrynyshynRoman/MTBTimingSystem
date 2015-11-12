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
    public Rider rider = new Rider();
    public void actionPerformed(ActionEvent e){


        Object source=e.getSource();
        if(source==parent.addRider) {
            JButton clickedButton= (JButton)e.getSource();

            rider.setRiderNumber(Integer.parseInt(parent.riderNumber.getText()));
            rider.setRiderName(parent.riderName.getText());

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
        }else if(source==parent.selectCategory){
            JComboBox clickedCombo= (JComboBox)e.getSource();
            parent.riderCategory.setText(clickedCombo.getSelectedItem().toString());
            rider.setRiderCategory(parent.riderCategory.getText());
        }


        }


    public RegistrationEngine(){}
}





