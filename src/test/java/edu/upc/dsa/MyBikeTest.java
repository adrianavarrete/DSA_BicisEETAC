package edu.upc.dsa;

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
   public void inicio(){

        MyBikeImpl.getInstance().addStation("wdqd",23,4,"hola");
       MyBikeImpl.getInstance().addStation("wff",23,4,"hola");
       MyBikeImpl.getInstance().addStation("wdqd",23,4,"hola");
       MyBikeImpl.getInstance().addStation("wff",23,4,"hola");
       MyBikeImpl.getInstance().addStation("wdqd",23,4,"hola");
       MyBikeImpl.getInstance().addStation("wff",23,4,"hola");
       MyBikeImpl.getInstance().addStation("wdqd",23,4,"hola");
       MyBikeImpl.getInstance().addStation("wff",23,4,"hola");
       MyBikeImpl.getInstance().addStation("wdqd",23,4,"hola");
       MyBikeImpl.getInstance().addStation("wff",23,4,"hola");
       MyBikeImpl.getInstance().addStation("wdqd",23,4,"hola");
       MyBikeImpl.getInstance().addStation("wff",23,4,"hola");
       MyBikeImpl.getInstance().addStation("wdqd",23,4,"hola");
       MyBikeImpl.getInstance().addStation("wff",23,4,"hola");
       MyBikeImpl.getInstance().addStation("wdqd",23,4,"hola");

   }



    @Test
    public void addStationTest() {
        MyBikeImpl.getInstance().addStation("prueba",23,4,"hola");
        assertEquals(15,MyBikeImpl.getInstance().getNumstations());
    }

    @Test
    public void addBikeTest() throws StationNotFoundException {

        String id = MyBikeImpl.getInstance().getIdStation(0);

        MyBikeImpl.getInstance().addBike("prueba",23,id);

    }
}
