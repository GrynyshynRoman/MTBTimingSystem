package com.RomanGrynyshyn.engine;

import com.RomanGrynyshyn.gui.UserWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedHashMap;
import java.util.Map;

public class UserWindowCore implements ActionListener {

    private Map<String,Rider> ridersOnTrack=new LinkedHashMap<>();
    private RaceData raceData=new RaceData();


    private static int ridersOnTrackcount=0;

    UserWindow parent;
    public UserWindowCore(UserWindow parent){
        this.parent=parent;
    }

    public void actionPerformed(ActionEvent event){
        Object actionSource=event.getSource();
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
            ShowResults();
        }else if(actionSource==parent.addRider){
            AddRider();}
    }

    public void Start(){
        Rider riderOnStart;
        String NumberOnStart;
        String categoryOnStart;
        categoryOnStart =getCategoryOnStart();
        NumberOnStart =parent.riderNumberOnStart.getText();
        riderOnStart=raceData.getRiderData(categoryOnStart, NumberOnStart);
        riderOnStart.setRiderStartTime(System.currentTimeMillis());
        ridersOnTrack.put(riderOnStart.getRiderNumber(),riderOnStart);
        ridersOnTrackcount++;
        parent.riderNumberOnStart.setText("");
    }

    public void Finish(){
        Rider riderOnFinish;
        String numberOnFinish;


        numberOnFinish =parent.riderNumberOnFinish.getText();
        riderOnFinish=ridersOnTrack.get(numberOnFinish);


        riderOnFinish.setRiderTime(riderOnFinish.calculateRiderTime());
        parent.riderTime.setText(String.valueOf(riderOnFinish.getRiderTime()));
        ridersOnTrack.remove(riderOnFinish.getRiderNumber());
        ridersOnTrackcount--;
        raceData.setRiderResult(riderOnFinish, riderOnFinish.getRiderCategory());
        parent.riderNumberOnFinish.setText("");
        }

    public void AddRider(){
        Rider rider=new Rider();
        rider.setRiderNumber(parent.riderNumber.getText());
        rider.setRiderName(parent.riderName.getText());
        rider.setRiderCategory(parent.regCategory.getSelectedItem().toString());
        raceData.setRiderData(rider,rider.getRiderCategory());
        raceData.setRidersCount();
        Map<String,Rider> registeredRiders =raceData.getCategoryData(rider.getRiderCategory());
        String text="";
        for(Rider r:registeredRiders.values()){
            text += r.getRiderName()+" "+r.getRiderCategory()+" "+r.getRiderNumber()+"\n";
        }
        parent.registeredRidersList.setText(text);
        parent.totalRiders.setText("Riders registered:"+" "+raceData.getRidersCount());
        parent.riderName.setText("");
        parent.riderNumber.setText("");
    }

    public void ShowResults(){

        String[] categories={"Junior","Woman","Master", "Amateur","Elite"};
        for(int i=0; i<=categories.length-1; i++){
            String results="";
            for (Rider rider: raceData.getCategoryResults(categories[i]).values()){
                results+="#"+rider.getRiderNumber()+" "+rider.getRiderName()+" "+rider.getRiderTime()+"\n";
                switch (categories[i]){
                    case "Junior":
                        parent.juniorsResults.setText(results);
                        break;
                    case "Amateur":
                        parent.amateursResults.setText(results);
                        break;
                    case "Elite":
                        parent.eliteResults.setText(results);
                        break;
                    case "Master":
                        parent.mastersResults.setText(results);
                        break;
                    case "Woman":
                        parent.womanResults.setText(results);

                }
            }

        }


       // parent.juniorsResults.setText();
    }


    public String getCategoryOnStart(){
        return parent.raceCategory.getSelectedItem().toString();
    }












}
