package edu.upc.dsa.models;

import edu.upc.dsa.util.RandomUtils;

public class Bike {

    String id;
    String model;
    double km;

    public Bike(String id, String model, double km) {
        this.id = id;
        this.model = model;
        this.km = km;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getKm() {
        return km;
    }

    public void setKm(double km) {
        this.km = km;
    }
}
