package com.software.software.actors;

public abstract class Person {
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
    public boolean signIn(String password){
        if (this.personInformation.getPassword()==password){
            return true;
        }
        else{
            return false;
        }
    }
}