package com.software.software.operations;
import java.util.Map;
import com.software.software.Data.DataBase;
import com.software.software.Data.rideDataBase;
import com.software.software.Zone.area;
import com.software.software.ride.event;
import com.software.software.ride.puttingPrice;

public class driverOperations {
    static rideDataBase rideDataBase=DataBase.getInstance();
    
    public static void mkOffer(int price, int driverId,int rideId) {
        event priceEvent=new puttingPrice(rideDataBase.getRideById(rideId));
        rideDataBase.getRideById(rideId).setPrice(price);
        rideDataBase.getRideById(rideId).addEvent(priceEvent);
        rideDataBase.pushOffer(rideDataBase.getRideById(rideId));
    }
    public Map<Integer, area> getAvailbleAreas(){
        return rideDataBase.getAvailbleAreas();
    }
}

