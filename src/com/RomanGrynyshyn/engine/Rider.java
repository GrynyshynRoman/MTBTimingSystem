package com.RomanGrynyshyn.engine;

public class Rider {
    private static int ridersCounter;
    private String riderFirstName;
    private String riderLastName;
    private String riderCategory;
    private int riderNumber;
    private double riderTime;
    private long riderStartTime;
    private long riderFinishitime;

    public void setRiderFirstName(String riderFirstName){
        this.riderFirstName=riderFirstName;
    }
    public void setRiderLastNameName(String riderLastName){
        this.riderLastName=riderLastName;
    }
    public void setRiderCategory(String riderCategory){
        this.riderCategory=riderCategory;
    }
    public void  setRiderNumber(int riderNumber){
        this.riderNumber=riderNumber;
    }
    public void setRiderTime(double riderTime){
        this.riderTime=riderTime;
    }
    public void setRiderStartTime(long riderStartTime){
        this.riderStartTime=riderStartTime;
    }
    public void setRiderFinishitime(long riderFinishitime){
        this.riderFinishitime=riderFinishitime;
    }
    public String getRiderFirstName(){
        return riderFirstName;}
    public String getRiderLastName(){
        return riderLastName;}
    public String getRiderCategory(){
        return riderCategory;}
    public int getRiderNumber(){
        return riderNumber;}
    public double getRiderTime(){
        return riderTime;}
    public long getRiderStartTime(){
        return riderStartTime;}
    public long getRiderFinishitime(){
        return riderFinishitime;}

    Rider(){
        ridersCounter++;
    }


}
