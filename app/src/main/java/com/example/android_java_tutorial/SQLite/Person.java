package com.example.android_java_tutorial.SQLite;

public class Person {

    private long id;
    private String name;
    
    public long getId() {

        return id;

    }

    public void setId(long id) {

        this.id = id;

    }

    public String getName() {

        return name;

    }

    public void setName(String comment) {

        this.name = comment;

    }

    // Will be used by the ArrayAdapter in the listview
    @Override

    public String toString() {

        return name;

    }
}
