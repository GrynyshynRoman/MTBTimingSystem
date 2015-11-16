package com.RomanGrynyshyn.engine;

import com.RomanGrynyshyn.gui.RaceWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class RaceEngine implements ActionListener {

    private Map<Integer,Rider> ridersOnTrack=new HashMap<>();
    private RaceData raceData=new RaceData();
    private String currentCategoryOnStart;
    private int currentNumberOnStart;
    private int currentNumberOnFinish;
    private static int ridersOnTrackcount=0;


    RaceWindow parent;
    public RaceEngine(RaceWindow parent){
        this.parent=parent;
    }



    public void actionPerformed(ActionEvent e){
        Object source=e.getSource();

        if(source==parent.categoryOnStartSelect){
            JComboBox comboBox=(JComboBox) e.getSource();
            currentCategoryOnStart=comboBox.getSelectedItem().toString();
        }else if(source==parent.startButton){Start();
        }else if(source==parent.finishButton){Finish();
        }
    }
    public void Start(){
        Rider riderOnStart;
        currentNumberOnStart=Integer.parseInt(parent.riderNumberOnStart.getText());
        riderOnStart=getRiderOnStart(currentNumberOnStart);
        riderOnStart.setRiderStartTime(System.currentTimeMillis());
        ridersOnTrack.put(riderOnStart.getRiderNumber(),riderOnStart);
        ridersOnTrackcount++;
    }

    public void Finish(){
        Rider riderOnFinish;
        currentNumberOnFinish=Integer.parseInt(parent.riderNumberOnFinish.getText());
        riderOnFinish=ridersOnTrack.get(currentNumberOnFinish);
        riderOnFinish.setRiderFinishitime(System.currentTimeMillis());
        riderOnFinish.calculateRiderTime(riderOnFinish.getRiderStartTime(),riderOnFinish.getRiderFinishtime());
        parent.riderTime.setText(String.valueOf(riderOnFinish.getRiderTime()));
        ridersOnTrack.remove(riderOnFinish.getRiderNumber());
        ridersOnTrackcount--;
    }

    public Rider getRiderOnStart(int currentNumber){
        Rider rider=new Rider();
        switch (currentCategoryOnStart){
            case "Junior":
                rider=raceData.juniorRidersData.get(currentNumber);
                break;
            case "Amateur":
                rider=raceData.amateurRidersData.get(currentNumber);
                break;
            case "Elite":
                rider=raceData.eliteRidersData.get(currentNumber);
                break;
            case "Master":
                rider=raceData.masterRidersData.get(currentNumber);
                break;
            case "Woman":
                rider=raceData.womanRidersData.get(currentNumber);
        }
        return rider;
    }










}
