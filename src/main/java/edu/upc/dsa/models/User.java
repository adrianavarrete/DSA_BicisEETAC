package edu.upc.dsa.models;

import edu.upc.dsa.util.RandomUtils;
import org.apache.log4j.Logger;

import java.util.LinkedList;
import java.util.List;

public class User {

    String id;
    List<Bike> listBikes;
    String name;
    String surname;
    String email;
    final static Logger logger = Logger.getLogger(User.class);

    public User(String id, String name, String surname, String email) {
        this.id = id;
        this.listBikes = new LinkedList<>();
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public void addBike(Bike bike){
        this.listBikes.add(bike);
        logger.info("Bici con id " + bike.getId() + "añadida al User " + this.getId());

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Bike> getListBikes() {
        return listBikes;
    }

    public void setListBikes(List<Bike> listBikes) {
        this.listBikes = listBikes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
