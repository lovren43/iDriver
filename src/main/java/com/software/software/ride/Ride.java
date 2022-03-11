package com.software.software.ride;


import java.util.ArrayList;

import com.software.software.Data.DataBase;
import com.software.software.Data.rideDataBase;
import com.software.software.Data.userDataBase;
import com.software.software.Discounts.ridePrice;
import com.software.software.Zone.area;
import com.software.software.actors.Driver;
import com.software.software.actors.Person;
import com.software.software.actors.User;

public class Ride implements ridePrice {
    userDataBase DB=DataBase.getInstance();
    rideDataBase rideDataBase=DataBase.getInstance();
    private area destinationArea=new area();
    private area sourcArea=new area();
    private int rideID=0;
    private Person user;
    private Driver driver;
    private int numberOfPassengers;
    private int price;
    private int Rate;
    private static int rideCounter=0;
    private ArrayList<event> rideEvents=new ArrayList<event>();
    public Ride(int destinationAreaId,int sourceAreaId,int userId, int numOfPassingers){
        setRideId();
        destinationArea=rideDataBase.getAreaById(destinationAreaId);
        sourcArea=rideDataBase.getAreaById(sourceAreaId);
        this.user=DB.getUserById(userId);
        this.numberOfPassengers=numOfPassingers;

    }
    
    private  void setRideId(){
        rideCounter++;
        rideID=rideCounter;
    }
    public area getDestinationArea() {
        return destinationArea;
    }

    public void setDestinationArea(area destinationArea) {
        this.destinationArea = destinationArea;
    }

    public area getSourcArea() {
        return sourcArea;
    }

    public void setSourcArea(area sourcArea) {
        this.sourcArea = sourcArea;
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
                "Source='" + sourcArea.getAreaName() + '\'' +
                        ", Destination='" + destinationArea.getAreaName() + '\'' +
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
