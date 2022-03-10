package com.software.software.control;
import java.util.ArrayList;

import com.software.software.Data.DataBase;
import com.software.software.Data.adminDataBase;
import com.software.software.Data.driverDataBase;
import com.software.software.Data.rideDataBase;
import com.software.software.Data.userDataBase;
import com.software.software.Zone.area;
import com.software.software.actors.Driver;
import com.software.software.actors.Status;

public class Admin {
    private static driverDataBase driverDataBase=DataBase.getInstance();
    private static rideDataBase rideDataBase=DataBase.getInstance();
    private static userDataBase userDataBase=DataBase.getInstance();
    private adminDataBase adminDataBase=DataBase.getInstance();
    private static String userName="admin";
    private static String password="admin";
    public static boolean signIn(String Name,String pass){
        if(userName.equalsIgnoreCase(Name)&&password.equalsIgnoreCase(pass)){
            return true;
        }
        else{
            return false;
        }
    }
    public String getUserName() {
        return userName;
    }
    public String getPassword() {
        return password;
    }
    public void addDiscountAreas(area area)
    {
        adminDataBase.addAdminDiscountArea(area);
    }
    public static void suspendDriver(int id){
        driverDataBase.getActiveDriverById(id).getPersonInfo().setCurrentStatus(Status.SUSPENDED);
    }

    public static void suspendUser(int id){
        
        userDataBase.getUserById(id).getPersonInfo().setCurrentStatus(Status.valueOf("SUSPENDED"));
    }
    public static ArrayList<String> listPendingDrivers(){
        ArrayList<String> pending=new ArrayList<String>();
         for(int i=0; i<driverDataBase.getPendingDrivers().size(); i++){
             pending.add(driverDataBase.getPendingDrivers().get(i).getPersonInfo().getUserName()+" "+driverDataBase.getPendingDrivers().get(i).getDriverId());
         }
         return pending;
        }
    
    public static void approveDriver( int driverID ){
        Driver driver=driverDataBase.getPendingDriverById(driverID);
        driverDataBase.getPendingDrivers().remove(driverID);
        driver.getPersonInfo().setCurrentStatus(Status.ACTIVE);
        driverDataBase.addDriver(driver);
    }
    public static String getEvents(int id){
        
        return rideDataBase.getRideById(id).getRideEvents().toString();
    }
    public void addArea(String name){
        area a=new area();
        a.setAreaName(name);
        adminDataBase.addArea(a);
    }
}

