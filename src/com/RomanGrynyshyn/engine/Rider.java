package com.RomanGrynyshyn.engine;



public class Rider implements Comparable<Rider> {
    private String name;
    private String category;
    private String number;
    private long time;
    private long startTime;
    private long finishtime;

    public void setFinishtime(long finishtime) {
        this.finishtime = finishtime;
    }
    public long getFinishtime() {

        return finishtime;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public void setTime(long time) {
        this.time = time;
    }
    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }
    public String getName() {
        return name;
    }
    public String getCategory() {
        return category;
    }
    public String getNumber() {
        return number;
    }
    public long getTime() {
        return time;
    }
    public long getStartTime() {
        return startTime;
    }
    public long calculateRiderTime() {
        return time = finishtime - startTime;
    }
    @Override
    public String toString() {
        return "Rider{" +
                "category='" + category + '\'' +
                ", name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", time=" + time +
                ", startTime=" + startTime +
                '}';
    }

    public String showRiderTimeAsString(){
        int min=0;
        int sec=0;
        int ms=0;
        min=(int) time /60000;
        sec=(int)(time -min*60000)/1000;
        ms=(int)(time -sec*1000-min*60000);
        String timeOutput=(min+":"+sec+":"+ms);
        return timeOutput;
    }

    public int compareTo(Rider rider) {
        return Double.compare(time, rider.time);
    }
}
