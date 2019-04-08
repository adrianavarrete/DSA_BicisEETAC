package edu.upc.dsa;

import edu.upc.dsa.models.Bike;
import edu.upc.dsa.models.User;
import edu.upc.dsa.throwable.BikeNotFoundException;
import edu.upc.dsa.throwable.StationNotFoundException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class MyBikeTest {


    @Before
    public void inicio() throws StationNotFoundException {


        MyBikeImpl.getInstance().addStation("wdqd",23,4,"hola");
        MyBikeImpl.getInstance().addUser("Manolo","García","a@a.es");

        String id = MyBikeImpl.getInstance().getIdStation(0);
        MyBikeImpl.getInstance().addBike("j",2,id);

    }


    @Test
    public void addUser() {

        MyBikeImpl.getInstance().addUser("Adria", "Navarrete", "de@gmail.com");
        assertEquals(2,MyBikeImpl.getInstance().getUsers().size());

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

        List<User> listUsers = MyBikeImpl.getInstance().getUsers();


        String idStation = MyBikeImpl.getInstance().getIdStation(0);
        String idUser = MyBikeImpl.getInstance().getIdUser(0,listUsers);
        String idBike = MyBikeImpl.getInstance().getIdBike(0, idStation);

        Bike hola = MyBikeImpl.getInstance().getBike(idStation,idUser,idBike);


    }

    @Test
    public void getUserTest(){
        List<User> list = MyBikeImpl.getInstance().getUsers();
        assertEquals(1,list.size());


    }
    @Test
    public void bikesByUserTest() throws StationNotFoundException, BikeNotFoundException {

        List<User> listUsers = MyBikeImpl.getInstance().getUsers();
        String idStation = MyBikeImpl.getInstance().getIdStation(0);
        String idUser = MyBikeImpl.getInstance().getIdUser(0,listUsers);
        String idBike = MyBikeImpl.getInstance().getIdBike(0, idStation);

        Bike hola = MyBikeImpl.getInstance().getBike(idStation,idUser,idBike);
        List<Bike> listBikesbyUser = MyBikeImpl.getInstance().bikesByUser(idUser);
        assertEquals(1,listBikesbyUser.size());

    }

    @Test
    public void bikesByStationTest() throws StationNotFoundException {

        String idStation = MyBikeImpl.getInstance().getIdStation(0);
        List<Bike> list = MyBikeImpl.getInstance().bikesByStation(idStation);
        assertEquals(1,list.size());

    }


}
