package com.software.software.Zone;
import com.software.software.actors.Driver;
import com.software.software.ride.Ride;

public interface Areas {
    public void registDriver(Driver driver);
    public void removeDriver(Driver driver);
    public void notifyDrivers(Ride ride);
}
