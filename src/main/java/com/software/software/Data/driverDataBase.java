package com.software.software.Data;
import java.util.ArrayList;
import java.util.Map;
import com.software.software.actors.Driver;

public interface driverDataBase {
    public void addDriver(Driver driver);
    public Map<Integer,Driver> getDriversList();
    public Map<Integer,Driver> getPendingDrivers();
    public void addPendingDrivers(Driver d);
    public Driver getPendingDriverById(int id);
    public Driver getActiveDriverById(int id);
    public void removePendingDriver(int driverId);
    public ArrayList<Integer> getDriverRates(int driverId);
    public double getAvgRate(int driverId);
    public Driver getDriverByUserName(String userName);
    public Driver getDriverByPhoneNumber(String phoneNumber);
    public Driver getDriverByEmail(String email);
    public void setDriverRate(int rate,int driverId);
}
