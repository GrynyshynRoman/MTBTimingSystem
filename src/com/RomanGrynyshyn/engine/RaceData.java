package com.RomanGrynyshyn.engine;

import java.util.*;

public class RaceData   {
    private static int ridersCount =0;
    private static Map<String,Rider> juniors =new LinkedHashMap<>();
    private static Map<String,Rider> amateurs =new LinkedHashMap<>();
    private static Map<String,Rider> women =new LinkedHashMap<>();
    private static Map<String,Rider> masters =new LinkedHashMap<>();
    private static Map<String,Rider> elite =new LinkedHashMap<>();

    private static Map<String,Rider> juniorsResults =new LinkedHashMap<>();
    private static Map<String,Rider> amateursResults =new LinkedHashMap<>();
    private static Map<String,Rider> womenResults =new LinkedHashMap<>();
    private static Map<String,Rider> mastersResults =new LinkedHashMap<>();
    private static Map<String,Rider> eliteResults =new LinkedHashMap<>();

    public void setRiderData(Rider rider){
    switch (rider.getCategory()){
        case "Junior":
            juniors.put(rider.getNumber(),rider);
            break;
        case "Amateur":
            amateurs.put(rider.getNumber(),rider);
            break;
        case "Elite":
            elite.put(rider.getNumber(),rider);
            break;
        case "Master":
            masters.put(rider.getNumber(),rider);
            break;
        case "Woman":
            women.put(rider.getNumber(), rider);
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
                rider= women.get(number);
        }
        return rider;
    }
    public void setRiderResult(Rider rider){
        switch (rider.getCategory()){
            case "Junior":
                juniorsResults.put(rider.getNumber(),rider);
                break;
            case "Amateur":
                amateursResults.put(rider.getNumber(),rider);
                break;
            case "Elite":
                eliteResults.put(rider.getNumber(),rider);
                break;
            case "Master":
                mastersResults.put(rider.getNumber(),rider);
                break;
            case "Woman":
                womenResults.put(rider.getNumber(), rider);
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
                rider= womenResults.get(number);
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
                map= women;
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
                map= womenResults;
        }

        return sortByResults(map);
    }
    public Map<String,Rider> sortByResults(Map<String,Rider> map){

        List<Rider> riderArray = new ArrayList<>(map.values());
        Collections.sort(riderArray);
        Map<String,Rider> mapToReturn=new LinkedHashMap<>();
        for(Rider rider:riderArray){
            mapToReturn.put(rider.getNumber(),rider);
        }
        return mapToReturn;
    }
    public void setRidersCount(){
        ridersCount++;
    }
    public int getRidersCount(){return ridersCount;}







}
