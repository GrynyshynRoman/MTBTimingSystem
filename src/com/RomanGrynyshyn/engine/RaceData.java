package com.RomanGrynyshyn.engine;

import java.util.*;

public class RaceData   {
    private static int ridersCount =0;
    private static Map<String,Rider> juniors =new LinkedHashMap<>();
    private static Map<String,Rider> amateurs =new LinkedHashMap<>();
    private static Map<String,Rider> woman =new LinkedHashMap<>();
    private static Map<String,Rider> masters =new LinkedHashMap<>();
    private static Map<String,Rider> elite =new LinkedHashMap<>();

    private static Map<String,Rider> juniorsResults =new LinkedHashMap<>();
    private static Map<String,Rider> amateursResults =new LinkedHashMap<>();
    private static Map<String,Rider> womanResults =new LinkedHashMap<>();
    private static Map<String,Rider> mastersResults =new LinkedHashMap<>();
    private static Map<String,Rider> eliteResults =new LinkedHashMap<>();

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
    public Rider getRiderData(String category, String number){
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
    public void setRiderResult(Rider rider, String category){
        switch (category){
            case "Junior":
                juniorsResults.put(rider.getRiderNumber(),rider);
                juniorsResults=sortByResults(juniorsResults);
                break;
            case "Amateur":
                amateursResults.put(rider.getRiderNumber(),rider);
                amateursResults=sortByResults(amateursResults);
                break;
            case "Elite":
                eliteResults.put(rider.getRiderNumber(),rider);
                eliteResults=sortByResults(eliteResults);
                break;
            case "Master":
                mastersResults.put(rider.getRiderNumber(),rider);
                mastersResults=sortByResults(mastersResults);
                break;
            case "Woman":
                womanResults.put(rider.getRiderNumber(),rider);
                womanResults=sortByResults(mastersResults);
        }
    }
    public Rider getRiderResult(String category, String number){
        Rider rider=new Rider();
        switch (category){
            case "Junior":
                rider= juniorsResults.get(number);
                break;
            case "Amateur":
                rider= amateursResults.get(number);
                break;
            case "Elite":
                rider= eliteResults.get(number);
                break;
            case "Master":
                rider= mastersResults.get(number);
                break;
            case "Woman":
                rider= womanResults.get(number);
        }
        return rider;
    }
    public Map<String,Rider> getCategoryData(String category){
        Map<String,Rider> map=new HashMap<>();
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
    public Map<String,Rider> getCategoryResults(String category){
        Map<String,Rider> map=new HashMap<>();
        switch (category){
            case "Junior":
                map= juniorsResults;
                break;
            case "Amateur":
                map= amateursResults;
                break;
            case "Elite":
                map= eliteResults;
                break;
            case "Master":
                map= mastersResults;
                break;
            case "Woman":
                map= womanResults;
        }
        return map;
    }
    public Map<String,Rider> sortByResults(Map<String,Rider> map){

        List<Rider> riderArray = new ArrayList<>(map.values());
        Collections.sort(riderArray);
        Map<String,Rider> mapToReturn=new LinkedHashMap<>();
        for(Rider rider:riderArray){
            mapToReturn.put(rider.getRiderNumber(),rider);
        }
        return mapToReturn;
    }
    public void setRidersCount(){
        ridersCount++;
    }
    public int getRidersCount(){return ridersCount;}







}
