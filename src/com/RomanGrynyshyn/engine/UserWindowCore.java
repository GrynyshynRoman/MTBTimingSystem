package com.RomanGrynyshyn.engine;

import com.RomanGrynyshyn.gui.UserWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedHashMap;
import java.util.Map;

public class UserWindowCore implements ActionListener {

    private Map<Integer,Rider> ridersOnTrack=new LinkedHashMap<>();
    private RaceData raceData=new RaceData();
    private String categoryOnStart;
    private int NumberOnStart;
    private int numberOnFinish;
    private static int ridersOnTrackcount=0;

    UserWindow parent;
    public UserWindowCore(UserWindow parent){
        this.parent=parent;
    }

    public void actionPerformed(ActionEvent e){
        Object actionSource=e.getSource();
        Timer timer=new Timer(10,new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event){
                String text="";
                for(Rider r:ridersOnTrack.values()){
                    text+=r.getRiderNumber()+"    "+r.calculateRiderTime()+"\n";
                }
                parent.ridersOnTrackList.setText(text);}

        });
        if(actionSource==parent.startButton){
            Start();
            timer.start();
        }else if(actionSource==parent.finishButton){
            Finish();
            timer.stop();
        }else if(actionSource==parent.addRider){RiderReg();}
    }

    public void Start(){
        Rider riderOnStart;
        categoryOnStart =getCategoryOnStart();
        NumberOnStart =Integer.parseInt(parent.riderNumberOnStart.getText());
        riderOnStart=raceData.getRiderData(categoryOnStart, NumberOnStart);
        riderOnStart.setRiderStartTime(System.currentTimeMillis());
        ridersOnTrack.put(riderOnStart.getRiderNumber(),riderOnStart);
        ridersOnTrackcount++;
        parent.riderNumberOnStart.setText("");
    }

    public void Finish(){
        Rider riderOnFinish;
        numberOnFinish =Integer.parseInt(parent.riderNumberOnFinish.getText());
        riderOnFinish=ridersOnTrack.get(numberOnFinish);
        riderOnFinish.setRiderTime(riderOnFinish.calculateRiderTime());
        parent.riderTime.setText(String.valueOf(riderOnFinish.getRiderTime()));
        ridersOnTrack.remove(riderOnFinish.getRiderNumber());
        ridersOnTrackcount--;
        Map<Integer,Rider> sortedMap=raceData.sortByResults(raceData.getCategoryData(categoryOnStart));
        parent.riderNumberOnFinish.setText("");
        //ArrayList<Rider> sortedList=raceData.sortByResults(raceData.getCategoryData(categoryOnStart));
        for(Rider e : sortedMap.values()){
            if(e.getRiderTime()!=0){
                System.out.println(e.getRiderName()+" "+e.getRiderTime());
            }
        }
        System.out.println(" ");
    }

    public void RiderReg(){
        Rider rider=new Rider();
        rider.setRiderNumber(Integer.parseInt(parent.riderNumber.getText()));
        rider.setRiderName(parent.riderName.getText());
        rider.setRiderCategory(parent.regCategory.getSelectedItem().toString());
        raceData.setRiderData(rider,rider.getRiderCategory());
        raceData.addTotalRiders();
        Map<Integer,Rider> registeredRiders =raceData.getCategoryData(rider.getRiderCategory());
        String text="";
        for(Rider r:registeredRiders.values()){
            text += r.getRiderName()+" "+r.getRiderCategory()+" "+r.getRiderNumber()+"\n";

        }
        parent.registeredRidersList.setText(text);

        parent.riderName.setText("");
        parent.riderNumber.setText("");
    }
    /*public void timerAction(){
        String text="";
        double time=0;
        for(Rider r:ridersOnTrack.values()){
            time=System.currentTimeMillis()-r.getRiderStartTime();
            text+=r.getRiderNumber()+" "+time;
        }
        parent.registeredRidersList.setText(text);
    }*/

    public String getCategoryOnStart(){
        return parent.raceCategory.getSelectedItem().toString();
    }












}
