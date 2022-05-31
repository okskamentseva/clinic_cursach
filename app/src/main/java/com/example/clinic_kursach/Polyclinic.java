package com.example.clinic_kursach;

public class Polyclinic {
    private String name, adress;

    public Polyclinic() {
    }

    public Polyclinic(String name, String adress) {
        this.name = name;
        this.adress = adress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return adress;
    }

    public void setAddress(String adress) {
        this.adress = adress;
    }
}
