package edu.upc.dsa;

import edu.upc.dsa.models.Bike;
import edu.upc.dsa.models.Station;
import edu.upc.dsa.models.User;

import java.util.List;

public interface MyBike {

    public static final int numMaxStations = 15;

    public void addUser(User user);
    public void addStation(Station station);
    public void addBike(Bike bike);
    public List<Bike> bikesByStationOrderByKms(List<Bike> listBikes);
    public Bike getBike(String id);
    public List<Bike> bikesByUser(User user);


    
    
}
