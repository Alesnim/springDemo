package com.example.demo.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Action {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;


    private String name;
    private String text;


    protected Action() {}

    public Action(String name, String text){
        this.name = name;
        this.text = text;
    }

    @Override
    public String toString() {
        return String.format("%d --- Action: %s, Description: %s", id, name, text);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
