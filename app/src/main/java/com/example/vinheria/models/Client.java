package com.example.vinheria.models;

public class Client {
    private String name;
    private String location;
    private String contact;

    public Client(String name, String location, String contact) {
        this.name = name;
        this.location = location;
        this.contact = contact;
    }

    public String getName() { return name; }
    public String getLocation() { return location; }
    public String getContact() { return contact; }
}
