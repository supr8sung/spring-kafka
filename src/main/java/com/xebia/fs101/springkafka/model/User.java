package com.xebia.fs101.springkafka.model;

public class User {
    private String name;
    private String college;
    private int rollno;

    public User(String name, String college, int rollno) {

        this.name = name;
        this.college = college;
        this.rollno = rollno;
    }

    public String getName() {

        return name;
    }

    public String getCollege() {

        return college;
    }

    public int getRollno() {

        return rollno;
    }
}
