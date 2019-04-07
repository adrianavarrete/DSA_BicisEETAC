package edu.upc.dsa;

import edu.upc.dsa.models.Bike;
import edu.upc.dsa.models.Station;
import edu.upc.dsa.models.User;
import edu.upc.dsa.throwable.StationNotFoundException;
import edu.upc.dsa.util.RandomUtils;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.List;

public class MyBikeImpl implements MyBike{

    private HashMap<String, User> users;
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
        int posStation = -1;

        for (int i = 0; i < this.numstations; i++) {
            if (idStation.equals(this.stations[i].getId())) {

                posStation = i;

            }
        }

        if(posStation != -1){

            this.stations[posStation].addBike(new Bike(id,"Orbea",2));

        }
        else{

            logger.error("Estación " + idStation + " no encontrada");
            throw new StationNotFoundException();

        }

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

    public int getNumstations() {
        return numstations;
    }

    public String getIdStation(int pos){
        String id = this.stations[pos].getId();
        logger.info("id = " + id );
        return id;
    }
}
