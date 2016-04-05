package com.RomanGrynyshyn.engine;

import com.RomanGrynyshyn.database.DB;
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
                    r.calculateRiderTime();
                    text+=r.getNumber()+"    "+r.showRiderTimeAsString()+"\n";
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
        String number=parent.riderNumberOnStart.getText();
        //String category=getCategoryOnStart();
        //Rider rider=raceData.getRiderData(category, number);
        Rider rider=DB.getRider(number);
        ridersOnTrack.put(rider.getNumber(),rider);
        ridersOnTrackcount++;
        parent.riderNumberOnStart.setText("");
        rider.setStartTime(System.currentTimeMillis());
    }

    public void Finish(){

        String number =parent.riderNumberOnFinish.getText();
        Rider rider=ridersOnTrack.get(number);
        rider.setFinishtime(System.currentTimeMillis());
        rider.calculateRiderTime();
        DB.setQualifyTime(rider);
        //parent.riderTime.setText(rider.showRiderTimeAsString());
        ridersOnTrack.remove(rider.getNumber());
        ridersOnTrackcount--;
        //raceData.setRiderResult(rider);
        parent.riderNumberOnFinish.setText("");
        }

    public void AddRider(){
        Rider rider=new Rider();
        rider.setNumber(parent.riderNumber.getText());
        rider.setName(parent.riderName.getText());
        rider.setCategory(parent.regCategory.getSelectedItem().toString());
        DB.addRider(rider);
        /*raceData.setRiderData(rider);
        raceData.setRidersCount();
        Map<String,Rider> registeredRiders =raceData.getCategoryData(rider.getCategory());
        String text="";
        for(Rider r:registeredRiders.values()){
            text += r.getNumber()+" "+r.getName()+" "+r.getCategory()+"\n";
        }
        parent.registeredRidersList.setText(text);
        parent.totalRiders.setText("Riders registered:"+" "+raceData.getRidersCount());*/
        parent.riderName.setText("");
        parent.riderNumber.setText("");
    }

    public void ShowResults(){

        String[] categories={"Junior","Woman","Master", "Amateur","Elite"};
        for(int i=0; i<=categories.length-1; i++){
            String results="";
            for (Rider rider: raceData.getCategoryResults(categories[i]).values()){
                results+="#"+rider.getNumber()+" "+rider.getName()+" "+rider.showRiderTimeAsString()+"\n";
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
    }


    public String getCategoryOnStart(){
        return parent.raceCategory.getSelectedItem().toString();
    }












}
