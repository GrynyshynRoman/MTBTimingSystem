package com.RomanGrynyshyn.gui;

import javax.swing.*;
import java.awt.*;

public class RegistrationWindow {
    private String[] categories={"Amateur", "Elite", "Junior", "Master", "Woman"};

    private JPanel regWindow=new JPanel();
    private JLabel nameLabel=new JLabel("Name");
    public JTextField riderName=new JTextField(20);
    private JLabel categoryLabel = new JLabel("Category");
    public JTextField riderCategory=new JTextField(10);
    public JComboBox selectCategory=new JComboBox();
    private JLabel numberLabel= new JLabel("Number");
    public JTextField riderNumber=new JTextField(5);
    JButton addRider=new JButton("Add Rider");

    public void comboBoxFill(){
        for (int i=0;i<5; i++)
            selectCategory.addItem(categories[i]);
        }


    public RegistrationWindow(){
        regWindow.add(nameLabel);
        regWindow.add(riderName);
        regWindow.add(categoryLabel);
        regWindow.add(selectCategory);
        regWindow.add(riderCategory);
        regWindow.add(numberLabel);
        regWindow.add(riderNumber);
        regWindow.add(addRider);


        GridLayout grid1=new GridLayout(6,2);
        regWindow.setLayout(grid1);
        comboBoxFill();

        JFrame frame=new JFrame("Registration");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(regWindow);
        frame.setSize(500,250);
        frame.setVisible(true);
        RegistrationEngine registration=new RegistrationEngine(this);
        addRider.addActionListener(registration);
        selectCategory.addActionListener(registration);
    }







}
