package edu.upc.dsa;

import edu.upc.dsa.models.Bike;
import edu.upc.dsa.models.Station;
import edu.upc.dsa.models.User;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.List;

public class MyBikeImpl implements MyBike{

    private HashMap<String, User> users;
    private Station[] stations;
    final static Logger logger = Logger.getLogger(MyBikeImpl.class);

    private static MyBikeImpl miMyBikeImpl;

    public  static MyBikeImpl getInstance(){

        if (miMyBikeImpl == null) {

            miMyBikeImpl= new MyBikeImpl();
        }
        return miMyBikeImpl;
    }

    private MyBikeImpl (){
        this.users = new HashMap<String, User>();
        this.stations = new Station[numMaxStations];
    }

    public void addUser(User user) {

    }

    public void addStation(Station station) {

    }

    public void addBike(Bike bike) {

    }

    public List<Bike> bikesByStationOrderByKms(List<Bike> listBikes) {
        return null;
    }

    public Bike getBike(String id) {
        return null;
    }

    public List<Bike> bikesByUser(User user) {
        return null;
    }
}
