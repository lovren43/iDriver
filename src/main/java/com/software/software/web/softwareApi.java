package com.software.software.web;
import java.util.ArrayList;
import com.software.software.Data.DataBase;
import com.software.software.Data.driverDataBase;
import com.software.software.Data.rideDataBase;
import com.software.software.Data.userDataBase;
import com.software.software.actors.Driver;
import com.software.software.actors.Role;
import com.software.software.actors.User;
import com.software.software.control.Admin;
import com.software.software.operations.driverOperations;
import com.software.software.operations.userOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/software")
public class softwareApi {
    userDataBase userDataBase=DataBase.getInstance();
    rideDataBase rideDataBase=DataBase.getInstance();
    driverDataBase driverDataBase=DataBase.getInstance();
    
    @PostMapping("/signUp/user")
    public boolean userSignUp(
        @RequestParam(name="userName") String userName,
        @RequestParam(name="password") String password,
        @RequestParam(name="birthday") String birthday,
        @RequestParam(name="email")    String email,
        @RequestParam(name="phoneNumber") String phoneNumber){
        return User.signUp(birthday,userName,phoneNumber,email,password,Role.user);
    }

    @PostMapping("/signIn/user")
    public boolean UserSignIn(
        @RequestParam(name="userName") String userName,
        @RequestParam(name="password") String password ){
            return userDataBase.getUserByUserName(userName).signIn(password);
        }

    @PostMapping ("/signIn/user/requestRide")
    public void requestRide(
        @RequestParam(name="sourceAreaId")int sourceAreaId,
        @RequestParam(name="numberOfPassingers")int numberOfPassingers,
        @RequestParam(name="userId")int userID,
        @RequestParam(name="destinationAreaId")int destinationAreaId){
            userOperations.requestRide(destinationAreaId,sourceAreaId, numberOfPassingers,userID);
        }
    
    @PostMapping ("/signIn/user/requestRide/cancelRideRequest") 
    public void cancelRideRequest(@RequestParam(name="rideId")int rideId){
        userOperations.cancelRideRequest(rideId);
    }

    @GetMapping("/signIn/user/requestRide/getOffers")
    public ArrayList<String> getOffers(@RequestParam (name="rideId")int rideId){
        ArrayList<String> offers=new ArrayList<String>();
        for (int i=0; i<rideDataBase.getOffers(rideId).size(); i++){
            offers.add(rideDataBase.getOffers(rideId).get(i).getDriver().getDriverId()+" "+rideDataBase.getOffers(rideId).get(i).getPrice());
        }
        return offers;
    }
    @PostMapping("/signIn/user/requestRide/getOffers/acceptOffer")
    public void acceptOffer(
       @RequestParam(name="rideId")int rideId,
       @RequestParam(name="driverId")int driverId){
           userOperations.acceptOffer(rideId, driverId);
    }
    @PostMapping("/signIn/user/setDriverRate")
    public void setDriverRate(
        @RequestParam (name="driverId")int driverId,
        @RequestParam (name="Rate")int rate){
            driverDataBase.setDriverRate(driverId, rate);
    }

    @PostMapping("/signUp/driver")
    public boolean driverSignUp(
        @RequestParam(name="DriverName") String userName,
        @RequestParam(name="password") String password,
        @RequestParam(name="licenseNumber") int licensNumber,
        @RequestParam(name="nationalId")int nationalId,
        @RequestParam(name="email")    String email,
        @RequestParam(name="birthday") String birthday,
        @RequestParam(name="availbleSets")int availbleSets,
        @RequestParam(name="phoneNumber") String phoneNumber,
        @RequestParam(name="favAreaId") int favAreaId){
            return Driver.signUp(userName, password, licensNumber, nationalId, email, birthday, availbleSets, phoneNumber, rideDataBase.getAreaById(favAreaId));
        }

    @PostMapping("/signIn/driver")
    public boolean DriverSignIn(
        @RequestParam(name="userName") String userName,
        @RequestParam(name="password") String password ){
            return driverDataBase.getDriverByUserName(userName).signIn(password);
        }

    @GetMapping("/signIn/driver/showAvailbleRides")
    public ArrayList<String> showAvailbleRides(
        @RequestParam(name="driverId") int driverId ){
            ArrayList<String> rides=new ArrayList<String>();
            for (int ride=0; ride<driverDataBase.getActiveDriverById(driverId).getAvailbleRide().size(); ride++){
                rides.add(driverDataBase.getActiveDriverById(driverId).getAvailbleRide().get(ride).toString());
            }
            return rides;
        } 
    
    @PostMapping("/signIn/driver/makeOffer")
    public void makeOffer(
        @RequestParam (name="price")int price,
        @RequestParam(name="driverId") int driverId,
        @RequestParam(name="rideId") int rideId){
        driverOperations.mkOffer(price,driverId,rideId);
    }

    @GetMapping("/signIn/driver/getRates")
    public ArrayList<Integer> getRates(@RequestParam(name="ID")int id){
        return driverDataBase.getDriverRates(id);
    }

    @PostMapping("/signIn/admin")
    public boolean adminSignIn(
        @RequestParam(name="adminUserName") String adminUserName,
        @RequestParam(name="adminPassword") String adminPassword){
            return Admin.signIn(adminUserName, adminPassword);
        }

    @GetMapping("/signIn/admin/listPendingDrivers")
    public ArrayList<String> listPendingDrivers(){
        return Admin.listPendingDrivers();
    }
 
    @PostMapping("/signIn/admin/approveDriver")
    public void approveDriver(@RequestParam (name="driverId")int driverId){
        Admin.approveDriver(driverId);
    }

      @PostMapping("/signIn/admin/suspend/user")
    public void suspendUser(@RequestParam (name="userId")int userId){
        Admin.suspendUser(userId);
    }
    @PostMapping("/signIn/admin/suspend/driver")
    public void suspendDriver(@RequestParam (name="driverId")int driverId){
        Admin.suspendDriver(driverId);
    }
    @GetMapping ("/signIn/admin/showEvents")
    public String getEvents(@RequestParam(name="rideId")int rideId){
        return Admin.getEvents(rideId);
    }
}
