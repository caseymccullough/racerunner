package com.casey.runners.model;

import java.time.Duration;
import java.time.Instant;

public class Runner {
    private int id;

    private char gender;
    private int cohort;

    private String name;
    private String address;
    private String city;
    private String state;
    private String zip;
    private Instant startTime;
    private Instant endTime;

    public Runner(){

    }

    public Runner(int id, char gender, String name, String address, String city, String state, String zip, String startTime, String endTime) {
        this.id = id;
        this.gender = gender;
        this.cohort = (gender == 'M') ? 0 : 1; // TEMP male is 0 cohort, 1 is all non-male
        this.name = name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.startTime = Instant.parse(startTime);
        this.endTime = Instant.parse(endTime);
    }

//    GETTERS

    public int getId() {
        return id;
    }

    public char getGender() {
        return gender;
    }

    public int getCohort() {
        return cohort;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    public Instant getStartTime() {
        return startTime;
    }

    public Instant getEndTime() {
        return endTime;
    }

//    SETTERS

    public void setId(int id) {
        this.id = id;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setCohort(int cohort) {
        this.cohort = cohort;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public void setStartTime(Instant startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(Instant endTime) {
        this.endTime = endTime;
    }



    public String getRaceTime()
    {
        return humanReadableFormat (Duration.between(startTime, endTime));
    }

    private String humanReadableFormat(Duration duration) {
        return duration.toString()
                .substring(2)
                .replaceAll("(\\d[HMS])(?!$)", "$1 ")
                .toLowerCase();
    }

    @Override
    public String toString() {
        return "Runner{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", cohort='" + cohort + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", raceTime=" + getRaceTime() +
                '}';
    }
}
