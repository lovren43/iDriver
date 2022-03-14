package com.software.software.actors;

import com.software.software.Data.DataBase;
import com.software.software.Data.driverDataBase;
import com.software.software.Data.userDataBase;

public abstract class Person {
    static driverDataBase driverDataBase=DataBase.getInstance();
    static userDataBase userDataBase=DataBase.getInstance();
    private personInfo personInformation;
    
    public personInfo getPersonInfo() {
        return this.personInformation;
    }

    public void setPersonInfo(personInfo personInfo) {
        this.personInformation = personInfo;
    }

    public boolean changePassword(String password){
        return personInformation.setPassword(password);
    }
    
    public boolean changePhoneNumber(String phoneNumber){
        return personInformation.setPhoneNumber(phoneNumber);
    }
    public static boolean signIn(String userName,String password){
        Person person=driverDataBase.getDriverByUserName(userName);
        if (person!=null){
            return person.getPersonInfo().getPassword().equals(password);
        }
        person =userDataBase.getUserByUserName(userName);
        if (person!=null){
            return person.getPersonInfo().getPassword().equals(password);
        }
        else{
            return false;
        }
    }
}