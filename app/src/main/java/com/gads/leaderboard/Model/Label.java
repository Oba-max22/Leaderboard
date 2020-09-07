package com.gads.leaderboard.Model;

public class Label {
    private int id;
    private String name;
    private String hours;
    private String score;
    private String country;


    public Label(int id, String name, String hours, String score, String country) {
        this.setId(id);
        this.setName(name);
        this.setHours(hours);
        this.setScore(score);
        this.setCountry(country);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
