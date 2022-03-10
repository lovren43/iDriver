package com.software.software.ride;


import java.util.ArrayList;

import com.software.software.Data.DataBase;
import com.software.software.Data.userDataBase;
import com.software.software.Discounts.ridePrice;
import com.software.software.actors.Driver;
import com.software.software.actors.Person;
import com.software.software.actors.User;

public class Ride implements ridePrice {
    userDataBase DB=DataBase.getInstance();
    private int rideID=0;
    private String Source;
    private String Destination;
    private Person user;
    private Driver driver;
    private int numberOfPassengers;
    private int price;
    private int Rate;
    private static int rideCounter=0;
    private ArrayList<event> rideEvents=new ArrayList<event>();
    public Ride(String destination,String source,int userId, int numOfPassingers){
        setRideId();
        Destination=destination;
        Source=source;
        this.user=DB.getUserById(userId);
        this.numberOfPassengers=numOfPassingers;

    }
    private  void setRideId(){
        rideCounter++;
        rideID=rideCounter;
    }
    public int getRideId(){
        return rideID;
    }
    public void setPrice(int p) {
        this.price = p;
    }
    public int getPrice() {
        return price;
    }
    public int getRate() {
        return Rate;
    }
    public void setRate(int rate) {
        this.Rate = rate;
    }
    public Person getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public Driver getDriver() {
        return driver;
    }
    public void setDriver(Driver driver) {
        this.driver = driver;
    }
    public String getSource() {
        return Source;
    }
    public void setSource(String source) {
        Source = source;
    }
    public String getDestination() {
        return Destination;
    }
    public void setDestination(String destination) {
        Destination = destination;
    }
    public int getNumberOfPassenger() {
        return this.numberOfPassengers;
    }
    public void setNumberOfPassenger(int numberOfPassenger) {
        this.numberOfPassengers = numberOfPassenger;
    }
    public void addEvent(event e){
        rideEvents.add(e);
    }
    public ArrayList<event> getRideEvents() {
        return rideEvents;
    }

    @Override
    public String toString() {
        return
                "Source='" + Source + '\'' +
                        ", Destination='" + Destination + '\'' +
                        ", user=" + user.getPersonInfo().getUserName() +
                        ", driver=" + driver.getPersonInfo().getUserName()+
                        ", price=" + price +
                        ", Rate=" + Rate +
                        '}';
    }

    @Override
    public int getRidePrice() {
        return this.getPrice();
    }
   
}
