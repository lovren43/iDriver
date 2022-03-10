package com.software.software.Data;
import java.util.ArrayList;
import java.util.Map;

import com.software.software.Zone.area;
import com.software.software.ride.Ride;

public interface rideDataBase {
    public Map<Integer,Ride> getRidesList();
    public Map<Integer,Ride> getRideRequest();
    public void addCompRide(Ride ride);
    public void addRideRequest(Ride rideRequest);
    public Ride getRideById(int id);
    public void pushOffer(Ride offeredRide);
    public ArrayList<Ride> getOffers(int rideId);
    public area getAreaById(int id);
    public Map<Integer, area> getAvailbleAreas();
}
