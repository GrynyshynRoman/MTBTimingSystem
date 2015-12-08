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
    public JComboBox regCategory =new JComboBox();
    public void regCategoryFill(){
        String[] categories={"Amateur", "Elite", "Junior", "Master", "Woman"};
        for (String e:categories) regCategory.addItem(e);
        }
    private JLabel registeredRidersLabel=new JLabel("Registered Riders", SwingConstants.RIGHT);
    public JTextArea registeredRidersList=new JTextArea(5,1);

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
    public JComboBox raceCategory =new JComboBox();
    public void raceCategoryFill(){
        String[] categories ={"Amateur", "Elite", "Junior", "Master", "Woman"};
        for (String e:categories) raceCategory.addItem(e);
        }
    private JLabel ridersOnTrack=new JLabel("Riders on track");
    public JTextArea ridersOnTrackList=new JTextArea(10,1);

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
        regCategoryFill();
        GridLayout riderInfoGrid=new GridLayout(4,2,5,5);
        riderInfoPanel.setLayout(riderInfoGrid);

        //Add lists of registered riders
        JPanel registeredRidersPanel=new JPanel();
        registeredRidersPanel.add(registeredRidersLabel);
        registeredRidersPanel.add(registeredRidersList);
        registeredRidersList.setEditable(false);
        GridLayout registrGrid=new GridLayout(1,2,5,5);
        registeredRidersPanel.setLayout(registrGrid);

        JPanel registrationPanel=new JPanel();
        registrationPanel.add(riderInfoPanel);
        registrationPanel.add(registeredRidersPanel);
        GridLayout registrationLayout=new GridLayout(1,2);
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
        raceCategoryFill();

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

        /*JPanel buttonPanel=new JPanel();

        buttonPanel.add(new JLabel());
        GridLayout buttonLay=new GridLayout(2,2,5,5);
        buttonPanel.setLayout(buttonLay);*/

        JPanel racePanel=new JPanel();
        GridLayout raceLay=new GridLayout(1,3,20,20);
        racePanel.setLayout(raceLay);
        racePanel.add(startPanel);
        racePanel.add(finishPanel);
        racePanel.add(timersPanel);

        //racePanel.add(buttonPanel);
        Border lineBorder=BorderFactory.createLineBorder(Color.black);
        Border raceBorder=BorderFactory.createTitledBorder(lineBorder, "Race");
        racePanel.setBorder(raceBorder);
        return racePanel;
    }
    public JPanel CreateResultsPanel(){
        JPanel resultsPanel=new JPanel();
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
        mainFrame.setSize(600, 500);
        mainFrame.setVisible(true);

        UserWindowCore race=new UserWindowCore(this);
        addRider.addActionListener(race);
        regCategory.addActionListener(race);

        startButton.addActionListener(race);
        finishButton.addActionListener(race);
        raceCategory.addActionListener(race);




    }


}
