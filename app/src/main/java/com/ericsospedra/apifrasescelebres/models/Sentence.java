package com.ericsospedra.apifrasescelebres.models;


public class Sentence {
    private int id;
    private String text;
    private String programedDate;
    private Author author;

    public Sentence(int id, String text, String programedDate, Author author) {
        this.id = id;
        this.text = text;
        this.programedDate = programedDate;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getProgramedDate() {
        return programedDate;
    }

    public Author getAuthor() {
        return author;
    }
}
