package edu.upc.dsa;

import edu.upc.dsa.models.Bike;
import edu.upc.dsa.models.Station;
import edu.upc.dsa.models.User;
import edu.upc.dsa.throwable.BikeNotFoundException;
import edu.upc.dsa.throwable.NumStationsFullException;
import edu.upc.dsa.throwable.StationNotFoundException;
import edu.upc.dsa.throwable.UserNotFoundException;

import java.util.List;

public interface MyBike {

    public static final int numMaxStations = 15;

    public void addUser(String name, String surname, String email);
    public void addStation(String name, double lat, double lon, String description) throws NumStationsFullException;
    public void addBike(String model, double km, String idStation) throws StationNotFoundException;
    public List<Bike> bikesByStationOrderByKms(List<Bike> listBikes);
    public Bike getBike(String idStation, String idUser, String idBike) throws StationNotFoundException, BikeNotFoundException;
    public List<Bike> bikesByUser(String idUser) throws UserNotFoundException;
    public void clear();


    
    
}
