package edu.upc.dsa;

import edu.upc.dsa.models.Bike;
import edu.upc.dsa.throwable.BikeNotFoundException;
import edu.upc.dsa.throwable.StationNotFoundException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MyBikeTest {

    @Test
    public void addUser() {

        MyBikeImpl.getInstance().addUser("Adria", "Navarrete", "de@gmail.com");

    }


   @Before
   public void inicio() throws StationNotFoundException {


       MyBikeImpl.getInstance().addStation("wdqd",23,4,"hola");
       MyBikeImpl.getInstance().addUser("Manolo","García","a@a.es");

       String id = MyBikeImpl.getInstance().getIdStation(0);
       MyBikeImpl.getInstance().addBike("j",2,id);

   }



    @Test
    public void addStationTest() {
        MyBikeImpl.getInstance().addStation("prueba",23,4,"hola");
        assertEquals(2,MyBikeImpl.getInstance().getNumstations());
    }

    @Test
   public void addBikeTest() throws StationNotFoundException {

        String id = MyBikeImpl.getInstance().getIdStation(0);

        MyBikeImpl.getInstance().addBike("j",2,id);

    }

    @Test
    public void getBikeTest() throws BikeNotFoundException, StationNotFoundException {
        String idStation = MyBikeImpl.getInstance().getIdStation(0);
        String idUser = "a";
        String idBike = MyBikeImpl.getInstance().getIdBike(0, idStation);

        Bike hola = MyBikeImpl.getInstance().getBike(idStation,idUser,idBike);

    }


}
