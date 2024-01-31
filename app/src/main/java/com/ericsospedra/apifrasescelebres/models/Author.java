package com.ericsospedra.apifrasescelebres.models;

public class Author {
    private int id;
    private String name;
    private int birthday;
    private String death;
    private String[] profesions;

    public Author(int id, String name, int birthday, String death, String[] profesions) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.death = death;
        this.profesions = profesions;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBirthday() {
        return birthday;
    }

    public String getDeath() {
        return death;
    }

    public String[] getProfesions() {
        return profesions;
    }
}

