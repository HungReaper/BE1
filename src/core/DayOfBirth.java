package core;

public class DayOfBirth {
    private int day;
    private int month;
    private int year;
    // cons
    public DayOfBirth () {
        // do nothing
    }
    public DayOfBirth (int day , int month , int year){
        this.day = day;
        this.month = month;
        this.year = year;
    }
    // setter
    public void setDay(int day) {
        this.day = day;
    }
    public void setMonth(int month) {
        this.month = month;
    }
    public void setYear(int year) {
        this.year = year;
    }
    //getter
    public int getDay() {
        return day;
    }
    public int getMonth() {
        return month;
    }
    public int getYear() {
        return year;
    }
}
