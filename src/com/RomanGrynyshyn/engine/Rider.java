package com.RomanGrynyshyn.engine;

public class Rider {
    private static int ridersCounter;
    private String riderName;
    private String riderCategory;
    private int riderNumber;
    private double riderTime;
    private long riderStartTime;
    private long riderFinishtime;

   // private enum riderCategories{Elite, Master, Junior, Amateur, Woman};

    public void setRiderName(String riderName){
        this.riderName=riderName;
    }
    public void setRiderCategory(String category){
        this.riderCategory=category;
       /* switch(category){
            case "Elite":
                this.riderCategory=category.name();
                break;
            case "Master":
                this.riderCategory=category.name();
                break;
            case "Junior":
                this.riderCategory=category.name();
                break;
            case Amateur:
                this.riderCategory=category.name();
                break;
            case Woman:
                this.riderCategory=category.name();
                break;
        }*/
    }
    public void setRiderNumber(int riderNumber){
        this.riderNumber=riderNumber;
    }
    public void setRiderTime(double riderTime){
        this.riderTime=riderTime;
    }
    public void setRiderStartTime(long riderStartTime){
        this.riderStartTime=riderStartTime;
    }
    public void setRiderFinishitime(long riderFinishtime){
        this.riderFinishtime=riderFinishtime;
    }
    public String getRiderName(){
        return riderName;}
    public String getRiderCategory(){
        return riderCategory;}
    public int getRiderNumber(){
        return riderNumber;}
    public double getRiderTime(){
        return riderTime;}
    public long getRiderStartTime(){
        return riderStartTime;}
    public long getRiderFinishtime(){
        return riderFinishtime;}

    public void calculateRiderTime(long riderStartTime, long riderFinishtime){
        riderTime=(riderFinishtime-riderStartTime)/1000.00;
    }

    public Rider(){
        ridersCounter++;
    }


}
