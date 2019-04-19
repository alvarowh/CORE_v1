package com.example.core_v1.entities;

public class item {

    String name;
    int cuantity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public item(String name, int cuantity) {
        this.name = name;
        this.cuantity = cuantity;
    }

    public int getCuantity() {
        return cuantity;
    }

    public void setCuantity(int cuantity) {
        this.cuantity = cuantity;
    }
}