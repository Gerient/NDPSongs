package sg.edu.rp.c346.id20014027.ndpsongs;

import java.io.Serializable;

public class Song implements Serializable {

    private int _id;
    private String title;
    private String singers;
    private int year;
    private int stars;

    public Song(String title, String singers, int year, int stars){
        this.title = title;
        this.singers = singers;
        this.year = year;
        this.stars = stars;
    }

    public int get_id() { return _id; }

    public String getTitle() { return title; }

    public String getSingers() { return singers; }

    public int getYear() { return year; }

    public int getStars() { return stars; }

    @Override
    public String toString() { return "ID: " + _id + " Title: " + title + " Singers: " + singers + " Year: " + year + " Stars: " + stars; }
}
