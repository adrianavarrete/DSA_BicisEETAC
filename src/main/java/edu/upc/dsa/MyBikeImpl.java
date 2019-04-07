package edu.upc.dsa;

import edu.upc.dsa.models.Bike;
import edu.upc.dsa.models.Station;
import edu.upc.dsa.models.User;
import edu.upc.dsa.throwable.BikeNotFoundException;
import edu.upc.dsa.throwable.StationNotFoundException;
import edu.upc.dsa.util.RandomUtils;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.*;

public class MyBikeImpl implements MyBike{

    private HashMap<String, User> users;
    private HashMap<String, Bike> bikes;
    private Station[] stations;
    private int numstations;
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
        this.bikes = new HashMap<String, Bike>();
        this.stations = new Station[numMaxStations];
        this.numstations = 0;
    }

    public void addUser(String name, String surname, String email) {

        String id = RandomUtils.getId();
        this.users.put(id, new User(id, name, surname,email));
        logger.info("User: " + id +" añadido");

    }

    public void addStation(String name, double lat, double lon, String description) {

        String id = RandomUtils.getId();

        logger.info("Numero de estaciones actuales = " + this.numstations);

        if (numstations != MyBike.numMaxStations){

            this.stations[numstations] = new Station(id, name, lat, lon, description);
            logger.info("Añadida estación " + id);
            numstations++;


        }
        else{

            logger.info("Ya se han añadido todas las estaciones posibles");

        }

    }

    public void addBike(String model, double km, String idStation) throws StationNotFoundException {
        String id = RandomUtils.getId();
        Bike bike = new Bike(id,"Orbea",2);
        int posStation = getPositionStation(this.stations,idStation);


        this.stations[posStation].addBike(bike);
        this.bikes.put(id, bike);
        logger.info("Bici añadida al hashmap de bicis ");



    }

    public List<Bike> bikesByStationOrderByKms(List<Bike> listBikes) {
        return null;
    }

    public Bike getBike(String idStation, String idUser, String idBike) throws StationNotFoundException, BikeNotFoundException {

        Bike bike = bikes.get(idBike);

        int posStation = getPositionStation(this.stations,idStation);
        int posBike = getPositionBike(this.stations[posStation].getListBikes(),idBike);

        this.stations[posStation].deleteBike(posBike);

        //falta añadir la bici al usuario


        return bike;
    }

    public List<Bike> bikesByUser(User user) {
        return null;
    }

    public int getNumstations() {
        return numstations;
    }

    public String getIdStation(int pos){
        String id = this.stations[pos].getId();
        logger.info("id = " + id );
        return id;
    }

    public int getPositionStation(Station[] array, String idStation) throws StationNotFoundException {

        int pos = -1;

        for(Station station: array)
        {
            int i = 0;

            if(station.getId() == idStation){
                pos = i;
            }
            else{

                i++;

            }
        }

        if(pos != -1){
            return pos;
        }
        else{

            logger.error("Estación " + idStation + " no encontrada");
            throw new StationNotFoundException();


        }

    }

    public int getPositionBike(List<Bike> list, String idBike) throws BikeNotFoundException {

        int pos = -1;

        for(Bike bici : list){

            int i = 0;

            if (bici.getId() == idBike){

                pos = i;

            }else{

                i++;

            }
        }

        if(pos != -1){
            return pos;
        }
        else{

            logger.error("Bici " + idBike + " no encontrada");
            throw new BikeNotFoundException();


        }
    }
}
