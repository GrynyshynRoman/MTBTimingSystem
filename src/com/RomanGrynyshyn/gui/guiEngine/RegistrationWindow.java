package com.RomanGrynyshyn.gui.guiEngine;

import com.RomanGrynyshyn.engine.RaceData;
import com.RomanGrynyshyn.engine.Rider;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrationWindow {
    private JPanel regWindow=new JPanel();
    private JLabel lab1=new JLabel("Name");
    private JTextField riderName=new JTextField(20);
    private JLabel lab2 = new JLabel("Category");
    private JTextField riderCategory=new JTextField(10);
    private JLabel lab3= new JLabel("Number");
    private JTextField riderNumber=new JTextField(5);
    private JButton addRider=new JButton("Add Rider");

    public static RaceData raceData=new RaceData();

    public RegistrationWindow(){
        addRider.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Rider rider=new Rider();
                rider.setRiderName(riderName.getText());
                rider.setRiderCategory(riderCategory.getText());
                rider.setRiderNumber(Integer.parseInt(riderNumber.getText()));
                switch(rider.getRiderCategory()){
                    case "Elite":
                        raceData.eliteRidersData.put(rider.getRiderNumber(),rider);
                        break;
                    case "Masters":
                        raceData.masterRidersData.put(rider.getRiderNumber(),rider);
                        break;
                    case "Junior":
                        raceData.juniorRidersData.put(rider.getRiderNumber(),rider);
                        break;
                    case "Woman":
                        raceData.womanRidersData.put(rider.getRiderNumber(),rider);
                        break;
                    case "Amateur":
                        raceData.amateurRidersData.put(rider.getRiderNumber(),rider);



                }

            }
        });
    }


    public void winOpen(){
        GridLayout grid1=new GridLayout(6,2);
        regWindow.setLayout(grid1);
        regWindow.add(lab1);
        regWindow.add(riderName);
        regWindow.add(lab2);
        regWindow.add(riderCategory);
        regWindow.add(lab3);
        regWindow.add(riderNumber);
        regWindow.add(addRider);

        JFrame frame=new JFrame("Registration");
        frame.setContentPane(regWindow);
        frame.setSize(500,250);
        frame.setVisible(true);
    }





}
