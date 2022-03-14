package com.software.software.actors;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.software.software.Data.DataBase;
import com.software.software.Data.rideDataBase;
import com.software.software.Validation.Validation;
import com.software.software.Zone.Areas;
import com.software.software.Zone.area;
import com.software.software.ride.Ride;

public class Driver extends Person implements Observer {
    private rideDataBase rideDataBase=DataBase.getInstance();
    private int driverID;
    private int nationalId;
    private int driverLicenseNumber;
    private int availbleSets;
    private ArrayList<Areas> favAreas = new ArrayList<>();
    private Map <Integer,Ride> availbleRide=new HashMap<Integer,Ride>();
    private static int counter=0;

    private void setDriverID(){
        counter++;
        driverID=counter;
    }

    public int getDriverId(){
        return driverID;
    }

    public int getAvailbleSets() {
        return availbleSets;
    }

    public void setAvailbleSets(int availbleSets) {
        this.availbleSets = availbleSets;
    }

    public Driver(String userName,String password,int licensNumber,int nationalId,String email,
    String birthday,int availbleSets,String phoneNumber,area favArea) {
        setDriverID();
        personInfo drivePersonInfo=new personInfo(birthday, userName, phoneNumber, email, password, Role.driver, Status.PENDING);
        this.setPersonInfo(drivePersonInfo);
        this.availbleSets=availbleSets;
        this.nationalId=nationalId;
        this.favAreas.add(favArea);
        this.driverLicenseNumber=licensNumber;
    }

    public Map<Integer,Ride> getAvailbleRide() {
        return this.availbleRide;
    }

    public void addFavArea(int areaId, int driverId) {
        favAreas.add(rideDataBase.getAreaById(areaId));
        rideDataBase.getAreaById(areaId).registDriver(driverDataBase.getActiveDriverById(driverId));
    }

    public void removeFavArea(int areaId, int driverId){
        favAreas.remove(rideDataBase.getAreaById(areaId));
        rideDataBase.getAreaById(areaId).removeDriver(driverDataBase.getActiveDriverById(driverId));
    }
    public int getNationalId() {
        return this.nationalId;
    }

    public void setNationalId(int nationalId) {
        this.nationalId = nationalId;
    }

    public int getDriverLicenseNumber() {
        return this.driverLicenseNumber;
    }

    public void setDriverLicenseNumber(int driverLicenseNumber) {
        this.driverLicenseNumber = driverLicenseNumber;
    }

    public ArrayList<Areas> getFavAreas() {
        return this.favAreas;
    }

    public void update(Ride r){
        availbleRide.put(r.getRideId(), r);
    }

    public static boolean signUp(String userName,String password,int licensNumber,int nationalId,String email,
    String birthday,int availbleSets,String phoneNumber,area favArea){
        if (Validation.isValidEmail(email) && Validation.isValidPassword(password)
         && Validation.isValidPhoneNum(phoneNumber) && Validation.isValidUserName(userName)){
            Driver driver=new Driver(userName, password, licensNumber, nationalId, email,
            birthday, availbleSets, phoneNumber, favArea);
            driverDataBase.addDriver(driver);
            return true;
        }
        else{
            return false;
        }
     }
     public void removeAvailbleRide(int rideId){
         availbleRide.remove(rideId);
     }
    //  public static boolean signIn(String userName,String password){
    //      return driverDataBase.getDriverByUserName(userName).getPersonInfo().getPassword().equals(password);
    //  }

    public String toString() {
        String var10000 = this.getPersonInfo().getUserName();
        return "Driver name is " + var10000 + " Driver phone number " + this.getPersonInfo().getPhoneNumber();
    }
    
}
