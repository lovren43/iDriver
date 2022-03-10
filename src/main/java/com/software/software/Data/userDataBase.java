package com.software.software.Data;
import java.util.Map;
import com.software.software.actors.User;

public interface userDataBase {
    //public void addArea(area a);
    // public void addDriver(Driver driver);
    public void addUser(User user) ;
    // public void addCompRide(Ride ride);
    // public void addRideRequest(Ride rideRequest);
    //public Map<Integer,Driver> getDriversList();
    public Map<Integer,User> getUsersList();
    // public Map<Integer,Ride> getRidesList();
    // public Map<Integer,Ride> getRideRequest();
    //public Map<Integer,Driver> getPendingDrivers();
    //public void addAdminDiscountArea(Areas area);
    //public void addPendingDrivers(Driver d);
    //public Driver getPendingDriverById(int id);
    //public Driver getActiveDriverById(int id);
    //public void removePendingDriver(int driverId);
    // public Ride getRideById(int id);
    // public void pushOffer(Ride offeredRide);
    // public ArrayList<Ride> getOffers(int rideId);
    public User getUserById(int id);
    //public Map<Integer, Ride> getAvailbleRides(int driverId);
    //public Map<Integer, area> getAvailbleAreas();
    // public area getAreaById(int id);
    // public void setDriverRate(int rate,int driverId);
    // public ArrayList<Integer> getDriverRates(int driverId);
    // public double getAvgRate(int driverId);
    public User getUserByPhoneNumber(String phoneNumber);
    public User getUserByEmail(String email);
    public User getUserByUserName(String name);
    // public Driver getDriverByUserName(String userName);
    // public Driver getDriverByPhoneNumber(String phoneNumber);
    // public Driver getDriverByEmail(String email);
}

