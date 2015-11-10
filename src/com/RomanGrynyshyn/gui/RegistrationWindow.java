package com.RomanGrynyshyn.gui;

import com.RomanGrynyshyn.engine.RaceData;

import javax.swing.*;
import java.awt.*;

public class RegistrationWindow {
    private JPanel regWindow=new JPanel();
    private JLabel nameLabel=new JLabel("Name");
    public JTextField riderName=new JTextField(20);
    private JLabel categoryLabel = new JLabel("Category");
    /* refactor fo enum-type
    public JTextField riderCategory=new JTextField(10);
    */
    private JLabel numberLabel= new JLabel("Number");
    public JTextField riderNumber=new JTextField(5);
    JButton addRider=new JButton("Add Rider");

    public static RaceData raceData=new RaceData();

    public RegistrationWindow(){
        regWindow.add(nameLabel);
        regWindow.add(riderName);
        regWindow.add(categoryLabel);
        //regWindow.add(riderCategory);
        regWindow.add(numberLabel);
        regWindow.add(riderNumber);
        regWindow.add(addRider);

        GridLayout grid1=new GridLayout(6,2);
        regWindow.setLayout(grid1);

        JFrame frame=new JFrame("Registration");
        frame.setContentPane(regWindow);
        frame.setSize(500,250);
        frame.setVisible(true);
        RegistrationEngine registration=new RegistrationEngine(this);
        addRider.addActionListener(registration);
    }







}
