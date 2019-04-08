package edu.upc.dsa.models;

import edu.upc.dsa.util.RandomUtils;
import org.apache.log4j.Logger;

import java.util.LinkedList;
import java.util.List;

public class Station {

    String id;
    List<Bike> listBikes;
    String name;
    double lat;
    double lon;
    String description;
    final static Logger logger = Logger.getLogger(Station.class);

    public Station(String id, String name, double lat, double lon, String description) {
        this.id = id;
        this.listBikes = new LinkedList<>();
        this.name = name;
        this.lat = lat;
        this.lon = lon;
        this.description = description;
    }

    public void addBike(Bike bike){

        this.listBikes.add(bike);
        logger.info("Bici añadida en la estación " + this.id);

    }

    public void deleteBike(int posBike){

        this.listBikes.remove(posBike);
        logger.info("Eliminada bici de la estación");
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

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
