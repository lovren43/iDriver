package com.software.software.Zone;
import java.util.HashMap;
import java.util.Map;
import com.software.software.actors.Driver;
import com.software.software.ride.Ride;

public class area implements Areas {
    private static int areaCounter=0;
    private String areaName;
    private int areaId;
    private Map <Integer,Ride> areaRides=new HashMap<Integer,Ride>();
    private Map<Integer,Driver> drivers=new HashMap<Integer,Driver>();

    public area(){
        setAreaId();
    }
    private void setAreaId(){
        areaCounter++;
        areaId=areaCounter;
    }
    public void registDriver(Driver driver){
        drivers.put(driver.getDriverId(), driver);
    }

    public void removeDriver(Driver driver){
        drivers.remove(driver.getDriverId());
    }
    public void notifyDrivers(Ride ride){
        for (Map.Entry<Integer,Driver>driver:drivers.entrySet()){
            if (driver.getValue().getAvailbleSets()==ride.getNumberOfPassenger()){
                driver.getValue().update(ride);
            }
        }
    }
    public void removeAreaRideRequest(int rideId){
        for (Map.Entry<Integer,Driver>driver:drivers.entrySet()){
            driver.getValue().removeAvailbleRide(rideId);
        }
    }
    public void addAreaRideRequest(Ride ride){
        areaRides.put(ride.getRideId(), ride);
        notifyDrivers(ride);
    }
    public void setAreaName(String name){
        areaName=name;
    }
    public String getAreaName(){
        return areaName;
    }

    public int getAreaId(){
        return areaId;
    }

    
}
