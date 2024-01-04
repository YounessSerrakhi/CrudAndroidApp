package com.example.preexam;

public class Meuble {
    private String name;
    private String price;
    private String description;
    private byte[] image;

    public Meuble(String name, String price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.image = null;
    }

    public Meuble() {
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
}
