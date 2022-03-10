package com.software.software.actors;
import com.software.software.Data.DataBase;
import com.software.software.Data.userDataBase;
import com.software.software.Validation.Validation;

public class User extends Person {
    static userDataBase userDataBase=DataBase.getInstance();
    public static int counter=0;
    int userId;
    public User(String birthday,String userName,String phoneNumber,String email, String password,Role role) {
        setUserId();
        personInfo userInfo=new personInfo(birthday,userName,phoneNumber,email,password,Role.user,Status.ACTIVE);
        this.setPersonInfo(userInfo);
    }
    private void setUserId(){
        counter++;
        userId=counter;
    }
    public int getUserId(){
        return userId;
    }
    public static boolean signUp(String birthday,String userName,String phoneNumber,String email, String password,Role role){
        if (Validation.isValidEmail(email) && Validation.isValidPassword(password) 
        && Validation.isValidPhoneNum(phoneNumber) && Validation.isValidUserName(userName)){
            User user=new User(birthday,userName,phoneNumber,email,password,Role.user);
            userDataBase.addUser(user);
            return true;
        }
        else{
            return false;
        }
    }

    public String toString() {
        String var10000 = this.getPersonInfo().getUserName();
        return "User name is " + var10000 + " with phone number " + this.getPersonInfo().getPhoneNumber();
    }

}
