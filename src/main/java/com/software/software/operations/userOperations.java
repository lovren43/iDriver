package com.software.software.operations;
import com.software.software.Data.DataBase;
import com.software.software.Data.rideDataBase;
import com.software.software.ride.Ride;
import com.software.software.ride.acceptingPrice;
import com.software.software.ride.event;
public class userOperations {
    static rideDataBase rideDataBase=DataBase.getInstance();

    public static void requestRide(int destinationAreaId,int sourceAreaId,int numOfPassingers,int userId) {
        Ride ride = new Ride( destinationAreaId, sourceAreaId,userId, numOfPassingers);
        rideDataBase.getAreaById(destinationAreaId).addAreaRideRequest(ride);
        rideDataBase.addRideRequest(ride); 
    }

    public static void acceptOffer(int rideId,int driverId) {
        for(int i=0; i<rideDataBase.getOffers(rideId).size(); i++){
            if (rideDataBase.getOffers(rideId).get(i).getDriver().getDriverId()==driverId){
                event acceptingEvent=new acceptingPrice(rideDataBase.getOffers(rideId).get(i));
                rideDataBase.getOffers(rideId).get(i).addEvent(acceptingEvent);
                rideDataBase.addCompRide(rideDataBase.getOffers(rideId).get(i));
                rideDataBase.getRideById(rideId).getDestinationArea().removeAreaRideRequest(rideId);
                break;
            }
        };
    }
    public static void cancelRideRequest(int rideId){
        rideDataBase.getRideById(rideId).getDestinationArea().removeAreaRideRequest(rideId);
    }
}
