package com.software.software.Data;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import com.software.software.Zone.Areas;
import com.software.software.Zone.area;
import com.software.software.actors.Driver;
import com.software.software.actors.User;
import com.software.software.ride.Ride;

public class DataBase implements userDataBase, driverDataBase ,rideDataBase, adminDataBase{
    private static DataBase DB;
    private Map<Integer,Driver> driversList=new HashMap<Integer,Driver>();
    private Map<Integer,User>usersList=new HashMap<Integer,User>();
    private Map<Integer,Ride> compridesList = new HashMap<Integer,Ride>();
    private Map<Integer,Ride>RideRequest=new HashMap<Integer,Ride>();
    private Map<Integer,Driver>pendingDrivers=new HashMap<Integer,Driver>();
    private ArrayList<Areas> adminDiscontsAreas=new ArrayList<>();
    private Map<Integer,ArrayList<Ride>> offers=new HashMap<Integer,ArrayList<Ride>>();
    private Map<Integer, area> availbleAreas=new HashMap<Integer,area>();
    private Map<String,User> usersEmail=new HashMap<String,User>();
    private Map<String,User> usersPhoneNumebr=new HashMap<String,User>();
    private Map<String,Driver> driversEmail=new HashMap<String,Driver>();
    private Map<String,Driver> driversPhoneNumebr=new HashMap<String,Driver>();
    private Map<String,Driver> driversUserName=new HashMap<String,Driver>();
    private Map<String,User> usersName=new HashMap<String,User>();
    private Map<Integer,ArrayList<Integer>> driverRates=new HashMap<Integer,ArrayList<Integer>>();
    private Map<Integer,Double> driverAvgRate=new HashMap<Integer,Double>();
    private DataBase(){};
    public static synchronized DataBase getInstance() {
        if (DB == null) {
            DB = new DataBase();
            return DB;
        } else {
            return DB;
        }
    }


    public void addArea(area a){
        availbleAreas.put(a.getAreaId(), a);
    }
    public void pushOffer(Ride offeredRide){
       if(offers.get(offeredRide.getRideId())!=null){
           ArrayList<Ride> offeredRides=offers.get(offeredRide.getRideId());
           offers.remove(offeredRide.getRideId());
           offers.put(offeredRide.getRideId(), offeredRides);
       }
       else{
           ArrayList<Ride> of=new ArrayList<Ride>();
           offers.put(offeredRide.getRideId(), of);
       }
    }

    public Map<Integer, Ride> getCompridesList() {
        return this.compridesList;
    }

    public void setCompridesList(Map<Integer, Ride> compridesList) {
        this.compridesList = compridesList;
    }

    public void addDriver(Driver driver) {
        this.driversList.put(driver.getDriverId(),driver);
        driversEmail.put(driver.getPersonInfo().getEmail(),driver);
        driversPhoneNumebr.put(driver.getPersonInfo().getPhoneNumber(),driver);
        driversUserName.put(driver.getPersonInfo().getUserName(),driver);
    }

    public void addUser(User user) {
        this.usersList.put(user.getUserId(),user);
        usersEmail.put(user.getPersonInfo().getEmail(),user);
        usersPhoneNumebr.put(user.getPersonInfo().getPhoneNumber(), user); 
        usersName.put(user.getPersonInfo().getUserName(), user);
    }

    public void addCompRide(Ride ride) {
        this.compridesList.put(ride.getRideId(),ride);
    }

    public void addRideRequest(Ride r) {
        this.RideRequest.put(r.getRideId(),r);
    }

    public Map<Integer,Driver> getDriversList() {
        return this.driversList;
    }

    public Map<Integer,User> getUsersList() {
        return this.usersList;
    }

    public Map<Integer,Ride> getRidesList() {
        return this.RideRequest;
    }

    public Map<Integer,Ride> getRideRequest() {
        return this.RideRequest;
    }

    public Map<Integer,Driver> getPendingDrivers() {
        return this.pendingDrivers;
    }

    public void addPendingDrivers(Driver driver) {
        this.pendingDrivers.put(driver.getDriverId(),driver);
        driversEmail.put(driver.getPersonInfo().getEmail(),driver);
        driversPhoneNumebr.put(driver.getPersonInfo().getPhoneNumber(),driver);
        driversUserName.put(driver.getPersonInfo().getUserName(),driver);
    }

    public void addAdminDiscountArea(area area){
        this.adminDiscontsAreas.add(area);
    }

    public Driver getActiveDriverById(int id){
        return driversList.get(id);
    }

    public Driver getPendingDriverById(int id){
        return driversList.get(id);
    }

    public Ride getRideById(int id){
        return RideRequest.get(id);
    }

    public Driver getDriverByEmail(String email){
        return driversEmail.get(email);
    }

    public Driver getDriverByPhoneNumber(String phoneNumber){
        return driversPhoneNumebr.get(phoneNumber);
    }

    public Driver getDriverByUserName(String userName){
        return driversUserName.get(userName);
    }

    public User getUserByEmail(String email){
        return usersEmail.get(email);
    }

    public User getUserByPhoneNumber(String phoneNumber){
        return usersPhoneNumebr.get(phoneNumber);
    }

    public User getUserByUserName(String name){
        return usersName.get(name);
    }

    public ArrayList<Ride> getOffers(int rideId){
        return offers.get(rideId);
    }

    public User getUserById(int id){
        return usersList.get(id);
    }

    public Map<Integer, Ride> getAvailbleRides(int driverID){
        return getActiveDriverById(driverID).getAvailbleRide();
    }

    public Map<Integer, area> getAvailbleAreas(){
        return availbleAreas;
    }
    
    public area getAreaById(int id){
        return availbleAreas.get(id);
    }
    public void removePendingDriver(int driverId){
        pendingDrivers.remove(driverId);
    }

    public void setDriverRate(int rate, int driverId) {
        if (driverRates.get(driverId)!=null){
            ArrayList<Integer> temp=driverRates.get(driverId);
            driverRates.remove(driverId);
            temp.add(rate);
            driverRates.put(driverId,temp);
            Double currentAvgRate=driverAvgRate.get(driverId);
            currentAvgRate=(currentAvgRate+rate)/2;
            driverAvgRate.remove(driverId);
            driverAvgRate.put(driverId,currentAvgRate);
        }
        else{
            ArrayList<Integer> temp=new ArrayList<Integer>();
            temp.add(rate);
            driverRates.put(driverId,temp);
            driverAvgRate.put(driverId, (double)rate);
        }
    }
    
    public ArrayList<Integer> getDriverRates(int driverId) {
        return driverRates.get(driverId);
    }
    public double getAvgRate(int driverId){
        return driverAvgRate.get(driverId);
    }
}

