package com.RomanGrynyshyn.gui;

import com.RomanGrynyshyn.engine.RaceEngine;

import javax.swing.*;
import java.awt.*;

public class RaceWindow {
    private String[] categories={"Amateur", "Elite", "Junior", "Master", "Woman"};

    private JPanel raceWindow=new JPanel();
    private JLabel categoryOnStart=new JLabel("Category on start:");
    public JComboBox categoryOnStartSelect=new JComboBox();
    private JLabel riderNumberLab=new JLabel("riderNumber");
    public JTextField riderNumber=new JTextField();
    private JLabel riderTimeLab=new JLabel("Rider Time");
    public JTextField riderTime=new JTextField();
    public JButton startButton=new JButton("Start");
    public JButton finishButton=new JButton("Finish");


    public void comboBoxFill(){
        for (int i=0;i<5; i++)
            categoryOnStartSelect.addItem(categories[i]);
        }

    public RaceWindow(){

        raceWindow.add(categoryOnStart);
        raceWindow.add(categoryOnStartSelect);
        raceWindow.add(riderNumberLab);
        raceWindow.add(riderNumber);
        raceWindow.add(riderTimeLab);
        raceWindow.add(riderTime);
        raceWindow.add(startButton);
        raceWindow.add(finishButton);

        GridLayout grid1=new GridLayout(6,2);
        raceWindow.setLayout(grid1);
        comboBoxFill();

        JFrame frame=new JFrame("Registration");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(raceWindow);
        frame.setSize(500,250);
        frame.setVisible(true);
        RaceEngine race=new RaceEngine(this);
        startButton.addActionListener(race);
        finishButton.addActionListener(race);
        categoryOnStartSelect.addActionListener(race);


    }
}
