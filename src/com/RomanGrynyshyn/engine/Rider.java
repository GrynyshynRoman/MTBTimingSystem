package com.RomanGrynyshyn.engine;

public class Rider implements Comparable<Rider>{
    private String riderName;
    private String riderCategory;
    private String riderNumber;
    private double riderTime;
    private long riderStartTime;


    public void setRiderName(String riderName){
        this.riderName=riderName;
    }
    public void setRiderCategory(String category){
        this.riderCategory=category;
    }
    public void setRiderNumber(String riderNumber){
        this.riderNumber=riderNumber;
    }
    public void setRiderTime(double riderTime){
        this.riderTime=riderTime;
    }
    public void setRiderStartTime(long riderStartTime){
        this.riderStartTime=riderStartTime;
    }
    public String getRiderName(){
        return riderName;}
    public String getRiderCategory(){
        return riderCategory;}
    public String getRiderNumber(){
        return riderNumber;}
    public double getRiderTime(){
        return riderTime;}
    public long getRiderStartTime(){
        return riderStartTime;}
    public double calculateRiderTime(){
        return riderTime=(System.currentTimeMillis()-riderStartTime)/1000.00;
    }
    public int compareTo(Rider rider){
        return Double.compare(riderTime, rider.riderTime);
    }

}
