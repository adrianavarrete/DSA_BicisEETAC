package edu.upc.dsa;

import edu.upc.dsa.models.Bike;
import edu.upc.dsa.models.User;
import edu.upc.dsa.throwable.BikeNotFoundException;
import edu.upc.dsa.throwable.NumStationsFullException;
import edu.upc.dsa.throwable.StationNotFoundException;
import edu.upc.dsa.throwable.UserNotFoundException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class MyBikeTest {

    private MyBikeImpl mb;

    @Before
    public void inicio() throws StationNotFoundException, NumStationsFullException {

        this.mb = MyBikeImpl.getInstance();


        this.mb.addStation("wdqd",23,4,"hola");
        this.mb.addUser("Manolo","García","a@a.es");

        String id = this.mb.getIdStation(0);
        this.mb.addBike("j",2,id);

    }

    @After
    public void limpiar(){

        this.mb.clear();
    }




    @Test
    public void addUser() {

        this.mb.addUser("Adria", "Navarrete", "de@gmail.com");
        assertEquals(2,this.mb.getUsers().size());

    }


    @Test
    public void addStationTest() throws NumStationsFullException {
        this.mb.addStation("prueba",23,4,"hola");
        assertEquals(2, this.mb.getNumstations());

    }



    @Test
   public void addBikeTest() throws StationNotFoundException {

        String id = this.mb.getIdStation(0);

        this.mb.addBike("j",2,id);
        assertEquals(2, this.mb.bikesByStation(id).size());

    }

    @Test
    public void getBikeTest() throws BikeNotFoundException, StationNotFoundException {

        List<User> listUsers = this.mb.getUsers();


        String idStation = this.mb.getIdStation(0);
        String idUser = this.mb.getIdUser(0,listUsers);
        String idBike = this.mb.getIdBike(0, idStation);

        Bike bike = this.mb.getBike(idStation,idUser,idBike);

        assertEquals(idBike,bike.getId());



    }

    @Test
    public void getUserTest(){
        List<User> list = this.mb.getUsers();
        assertEquals(1,list.size());


    }
    @Test
    public void bikesByUserTest() throws StationNotFoundException, BikeNotFoundException, UserNotFoundException {

        List<User> listUsers = this.mb.getUsers();
        String idStation = this.mb.getIdStation(0);
        String idUser = this.mb.getIdUser(0,listUsers);
        String idBike = this.mb.getIdBike(0, idStation);

        Bike hola = this.mb.getBike(idStation,idUser,idBike);
        List<Bike> listBikesbyUser = this.mb.bikesByUser(idUser);
        assertEquals(1,listBikesbyUser.size());

    }

    @Test
    public void bikesByStationTest() throws StationNotFoundException {

        String idStation = this.mb.getIdStation(0);
        List<Bike> list = this.mb.bikesByStation(idStation);
        assertEquals(1,list.size());

    }


}
