package com.RomanGrynyshyn.engine;

public class Rider implements Comparable<Rider> {
    private String riderName;
    private String riderCategory;
    private String riderNumber;
    private long riderTime;
    private long riderStartTime;


    public void setRiderName(String riderName) {
        this.riderName = riderName;
    }

    public void setRiderCategory(String category) {
        this.riderCategory = category;
    }

    public void setRiderNumber(String riderNumber) {
        this.riderNumber = riderNumber;
    }

    public void setRiderTime(long riderTime) {
        this.riderTime = riderTime;
    }

    public void setRiderStartTime(long riderStartTime) {
        this.riderStartTime = riderStartTime;
    }

    public String getRiderName() {
        return riderName;
    }

    public String getRiderCategory() {
        return riderCategory;
    }

    public String getRiderNumber() {
        return riderNumber;
    }

    public long getRiderTime() {
        return riderTime;
    }

    public long getRiderStartTime() {
        return riderStartTime;
    }

    public long calculateRiderTime() {
        return riderTime = System.currentTimeMillis() - riderStartTime;
    }
    public String showRiderTimeAsString(){
        int min=0;
        int sec=0;
        int ms=0;
        min=(int)riderTime/60000;
        sec=(int)(riderTime-min*60000)/1000;
        ms=(int)(riderTime-sec*1000-min*60000);
        String timeOutput=(min+":"+sec+":"+ms);
        return timeOutput;
    }

    public int compareTo(Rider rider) {
        return Double.compare(riderTime, rider.riderTime);
    }
}
