package com.software.software.actors;
import com.software.software.Validation.Validation;

public class personInfo {
    private String birthday;
    private String userName;
    private String phoneNumber;
    private String email;
    private String password;
    private Role role;
    private Status currentStatus;

    public personInfo(String birthday,String userName,String phoneNumber,String email, String password,Role role,Status currStatus) {
        this.birthday=birthday;
        if (Validation.isValidUserName(userName)){
            this.userName=userName;
        }
        if (Validation.isValidPhoneNum(phoneNumber)){
            this.phoneNumber=phoneNumber;
        }
        if (Validation.isValidEmail(email)){
            this.email=email;
        }
        if (Validation.isValidPassword(password)){
            this.password=password;
        }
        this.role=role;
        this.currentStatus=currStatus;
    }

    public String getBirthday(){
        return birthday;
    }
    public void setBirthday(String day){
        birthday=day;
    }
    public String getUserName() {
        return this.userName;
    }

    public boolean setUserName(String userName) {
        if (Validation.isValidUserName(userName)){
            this.userName=userName;
            return true;
        }
        else{
            return false;
        }
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public boolean setPhoneNumber(String phone) {
        if (Validation.isValidPhoneNum(phone)){
            this.phoneNumber = phone;
            return true;
        }
        else{
            return false;
        }
        
    }

    public String getEmail() {
        return this.email;
    }

    public boolean setEmail(String email) {
        if (Validation.isValidEmail(email)){
            this.email = email;
            return true;
        }
        else{
            return false;
        }
        
    }

    public String getPassword() {
        return this.password;
    }

    public boolean setPassword(String password) {
        if (Validation.isValidPassword(password)) {
            this.password = password;
            return true;
        }
        else{
            return false;
        }
    }

    public Role getRole() {
        return this.role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Status getCurrentStatus() {
        return this.currentStatus;
    }

    public void setCurrentStatus(Status currentStatus) {
        this.currentStatus = currentStatus;
    }
}