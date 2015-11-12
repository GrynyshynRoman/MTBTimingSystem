package com.RomanGrynyshyn.engine;

import com.RomanGrynyshyn.gui.RaceWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class RaceEngine implements ActionListener {
    Rider rider;
    private Map<Integer,Rider> ridersOnTrack=new HashMap<>();
    private RaceData raceData;
    private String currentCategoryOnStart;
    private int currentNumberOnStart;


    RaceWindow parent;
    public RaceEngine(RaceWindow parent){
        this.parent=parent;
    }

    public void actionPerformed(ActionEvent e){
        Object source=e.getSource();

        if(source==parent.categoryOnStartSelect){
            JComboBox comboBox=(JComboBox) e.getSource();
            currentCategoryOnStart=comboBox.getSelectedItem().toString();
        }else if(source==parent.startButton){
            currentNumberOnStart=Integer.parseInt(parent.riderNumber.getText());
            switch (currentCategoryOnStart){
                case "Junior":
                    rider=raceData.juniorRidersData.get(currentNumberOnStart);
                    break;
                case "Amateur":
                    rider=raceData.amateurRidersData.get(currentNumberOnStart);
                    break;
                case "Elite":
                    rider=raceData.eliteRidersData.get(currentNumberOnStart);
                    break;
                case "Master":
                    rider=raceData.masterRidersData.get(currentNumberOnStart);
                    break;
                case "Woman":
                    rider=raceData.womanRidersData.get(currentNumberOnStart);
            }
            rider.setRiderStartTime(System.currentTimeMillis());
            ridersOnTrack.put(rider.getRiderNumber(),rider);
        }else if(source==parent.finishButton){
            rider.setRiderFinishitime(System.currentTimeMillis());
            rider.calculateRiderTime(rider.getRiderStartTime(),rider.getRiderFinishtime());
            parent.riderTime.setText(String.valueOf(rider.getRiderTime()));
            ridersOnTrack.remove(rider.getRiderNumber());

        }
    }











}
