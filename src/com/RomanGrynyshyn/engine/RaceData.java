package com.RomanGrynyshyn.engine;

import java.util.*;

public class RaceData   {
    private static int totalRiders=0;
    private static Map<Integer,Rider> juniors =new LinkedHashMap<>();
    private static Map<Integer,Rider> amateurs =new LinkedHashMap<>();
    private static Map<Integer,Rider> woman =new LinkedHashMap<>();
    private static Map<Integer,Rider> masters =new LinkedHashMap<>();
    private static Map<Integer,Rider> elite =new LinkedHashMap<>();



    public void setRiderData(Rider rider, String category){
    switch (category){
        case "Junior":
            juniors.put(rider.getRiderNumber(),rider);
            break;
        case "Amateur":
            amateurs.put(rider.getRiderNumber(),rider);
            break;
        case "Elite":
            elite.put(rider.getRiderNumber(),rider);
            break;
        case "Master":
            masters.put(rider.getRiderNumber(),rider);
            break;
        case "Woman":
            woman.put(rider.getRiderNumber(),rider);
    }
}
    public Rider getRiderData(String category, int number){
        Rider rider=new Rider();
        switch (category){
            case "Junior":
                rider= juniors.get(number);
                break;
            case "Amateur":
                rider= amateurs.get(number);
                break;
            case "Elite":
                rider= elite.get(number);
                break;
            case "Master":
                rider= masters.get(number);
                break;
            case "Woman":
                rider= woman.get(number);
        }
        return rider;
    }
    public Map<Integer,Rider> getCategoryData(String category){
        Map<Integer,Rider> map=new HashMap<>();
        switch (category){
            case "Junior":
                map= juniors;
                break;
            case "Amateur":
                map= amateurs;
                break;
            case "Elite":
                map= elite;
                break;
            case "Master":
                map= masters;
                break;
            case "Woman":
                map= woman;
        }
        return map;
    }
    public Map<Integer,Rider> sortByResults(Map<Integer,Rider> map){


        ArrayList<Rider> riderArray = new ArrayList<>(map.values());
        Collections.sort(riderArray);
        Map<Integer,Rider> mapToReturn=new LinkedHashMap<>();
        for(Rider rider:riderArray){
            mapToReturn.put(rider.getRiderNumber(),rider);
        }
        return mapToReturn;
    }
    public void addTotalRiders(){
        totalRiders++;
    }

   /* public ArrayList<Rider> sortByResults(Map<Integer,Rider> map){


        ArrayList<Rider> riderArray = new ArrayList<>(map.values());
        Collections.sort(riderArray);
        return riderArray;
    }*/





}
