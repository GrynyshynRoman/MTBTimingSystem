package com.RomanGrynyshyn.gui;

import com.RomanGrynyshyn.engine.UserWindowCore;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class UserWindow {

    //Registration Panel Components
    private JLabel nameLabel=new JLabel("Name",SwingConstants.RIGHT);
    private JLabel categoryLabel = new JLabel("Category",SwingConstants.RIGHT);
    private JLabel numberLabel= new JLabel("Number",SwingConstants.RIGHT);
    public JTextField riderName=new JTextField(20);
    public JTextField riderNumber=new JTextField(5);
    public JButton addRider=new JButton("Add Rider");
    public JComboBox<String> regCategory =new JComboBox<>(new String[]{"Amateur", "Elite", "Junior", "Master", "Woman"});
    private JLabel registeredRidersLabel=new JLabel("Registered Riders", SwingConstants.RIGHT);
    public JTextArea registeredRidersList=new JTextArea(5,1);
    public JLabel totalRiders=new JLabel("Riders registered: 0",SwingConstants.RIGHT);

    //Race Panel Components
    private JLabel categoryOnStart=new JLabel("Category on start:",SwingConstants.RIGHT);
    private JLabel riderNumberOnStartLab=new JLabel("Starting number",SwingConstants.RIGHT);
    private JLabel riderTimeLab=new JLabel("Rider Time",SwingConstants.RIGHT);
    private JLabel riderNumberOnFinishLab=new JLabel("Finishing number",SwingConstants.RIGHT);
    public JTextField riderNumberOnStart=new JTextField();
    public JTextField riderNumberOnFinish=new JTextField();
    public JTextField riderTime=new JTextField();
    public JButton startButton=new JButton("Start");
    public JButton finishButton=new JButton("Finish");
    public JComboBox<String> raceCategory =new JComboBox<>(new String[]{"Amateur", "Elite", "Junior", "Master", "Woman"});
    private JLabel ridersOnTrack=new JLabel("Riders on track");
    public JTextArea ridersOnTrackList=new JTextArea(10,1);

    //Results Panel Components


    private JLabel juniorsLab=new JLabel("Juniors");
    private JLabel womanLab=new JLabel("Woman");
    private JLabel mastersLab=new JLabel("Masters");
    private JLabel amateursLab=new JLabel("Amateurs");
    private JLabel eliteLab=new JLabel("Elite");
    public JTextArea juniorsResults =new JTextArea();
    public JTextArea womanResults =new JTextArea();
    public JTextArea mastersResults =new JTextArea();
    public JTextArea amateursResults =new JTextArea();
    public JTextArea eliteResults =new JTextArea();




    public JPanel CreateRegistrationInterface(){
        JPanel riderInfoPanel =new JPanel();
        riderInfoPanel.add(nameLabel);
        riderInfoPanel.add(riderName);
        riderInfoPanel.add(numberLabel);
        riderInfoPanel.add(riderNumber);
        riderInfoPanel.add(categoryLabel);
        riderInfoPanel.add(regCategory);
        riderInfoPanel.add(new JLabel());
        riderInfoPanel.add(addRider);
        GridLayout riderInfoGrid=new GridLayout(4,2,5,5);
        riderInfoPanel.setLayout(riderInfoGrid);

        //Add lists of registered riders
        JPanel registeredRidersPanel=new JPanel();
        registeredRidersPanel.add(totalRiders);
        registeredRidersPanel.add(registeredRidersLabel);
        GridLayout registerGrid=new GridLayout(2,1,5,5);
        registeredRidersPanel.setLayout(registerGrid);
        JPanel listPanel=new JPanel();
        listPanel.add(registeredRidersList);
        GridLayout listGrid=new GridLayout(1,1,5,5);
        listPanel.setLayout(listGrid);


        JPanel registrationPanel=new JPanel();
        registrationPanel.add(riderInfoPanel);
        registrationPanel.add(registeredRidersPanel);
        registrationPanel.add(listPanel);
        GridLayout registrationLayout=new GridLayout(1,3,5,5);
        registrationPanel.setLayout(registrationLayout);
        Border lineBorder=BorderFactory.createLineBorder(Color.black);
        Border regBorder=BorderFactory.createTitledBorder(lineBorder, "Registration");
        registrationPanel.setBorder(regBorder);
        return registrationPanel;
    }

    public JPanel CreateRaceInterface(){

        JPanel startPanel =new JPanel();
        startPanel.add(categoryOnStart);
        startPanel.add(raceCategory);
        startPanel.add(riderNumberOnStartLab);
        startPanel.add(riderNumberOnStart);
        startPanel.add(new JLabel());
        startPanel.add(startButton);
        GridLayout startGrid=new GridLayout(3,2,5,5);
        startPanel.setLayout(startGrid);


        JPanel finishPanel=new JPanel();
        finishPanel.add(riderNumberOnFinishLab);
        finishPanel.add(riderNumberOnFinish);
        finishPanel.add(riderTimeLab);
        finishPanel.add(riderTime);
        finishPanel.add(new JLabel());
        finishPanel.add(finishButton);
        riderTime.setEditable(false);
        GridLayout finishGrid=new GridLayout(3,2,5,5);
        finishPanel.setLayout(finishGrid);

        JPanel timersPanel=new JPanel();
        timersPanel.add(ridersOnTrack);
        timersPanel.add(ridersOnTrackList);
        GridLayout timersGrid=new GridLayout(1,2,5,5);
        timersPanel.setLayout(timersGrid);
        ridersOnTrackList.setEditable(false);

        JPanel racePanel=new JPanel();
        GridLayout raceLay=new GridLayout(1,3,20,20);
        racePanel.setLayout(raceLay);
        racePanel.add(startPanel);
        racePanel.add(finishPanel);
        racePanel.add(timersPanel);

        Border lineBorder=BorderFactory.createLineBorder(Color.black);
        Border raceBorder=BorderFactory.createTitledBorder(lineBorder, "Race");
        racePanel.setBorder(raceBorder);
        return racePanel;
    }
    public JPanel CreateResultsPanel(){
        JPanel resultsPanel=new JPanel();
        resultsPanel.add(juniorsLab);
        resultsPanel.add(womanLab);
        resultsPanel.add(mastersLab);
        resultsPanel.add(amateursLab);
        resultsPanel.add(eliteLab);
        resultsPanel.add(juniorsResults);
        resultsPanel.add(womanResults);
        resultsPanel.add(mastersResults);
        resultsPanel.add(amateursResults);
        resultsPanel.add(eliteResults);
        GridLayout resultsGrid=new GridLayout(2,5,5,5);
        resultsPanel.setLayout(resultsGrid);
        Border lineBorder=BorderFactory.createLineBorder(Color.black);
        Border resultBorder=BorderFactory.createTitledBorder(lineBorder, "Results");
        resultsPanel.setBorder(resultBorder);
        return resultsPanel;

    }



    public UserWindow(){
        //Secondary panels
        JPanel registrationPanel=CreateRegistrationInterface();
        JPanel racePanel=CreateRaceInterface();
        JPanel resultsPanel=CreateResultsPanel();
        //Main panel
        JPanel mainPanel=new JPanel();
        GridLayout raceBorder=new GridLayout(3,1,25,15);
        mainPanel.setLayout(raceBorder);
        mainPanel.add(registrationPanel);
        mainPanel.add(racePanel);
        mainPanel.add(resultsPanel);

        JFrame mainFrame=new JFrame("Timing System");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setContentPane(mainPanel);
        mainFrame.setSize(700, 500);
        mainFrame.setVisible(true);

        UserWindowCore race=new UserWindowCore(this);
        addRider.addActionListener(race);
        regCategory.addActionListener(race);

        startButton.addActionListener(race);
        finishButton.addActionListener(race);
        raceCategory.addActionListener(race);




    }


}
