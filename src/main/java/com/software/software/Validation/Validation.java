package com.software.software.Validation;
import java.util.regex.Pattern;
import com.software.software.Data.DataBase;
import com.software.software.Data.driverDataBase;
import com.software.software.Data.userDataBase;
import com.software.software.actors.Person;

public class Validation {


    private static userDataBase userDataBase=DataBase.getInstance();
    private static driverDataBase driverDataBase=DataBase.getInstance();
    public static boolean isValidUserName(String s) {
        Pattern pattern = Pattern.compile("[A-Za-z0-9_]+");
        return s.matches(String.valueOf(pattern)) && s.length() > 3 && s.length() < 15 && isUniqueUserName(s);
    }

    private static boolean isUniqueUserName(String userName) {
        Person person=driverDataBase.getDriverByUserName(userName);
        person=userDataBase.getUserByUserName(userName);
        if (person==null){
            return true;
        }
        else{
            return false;
        }
    }

    public static boolean isValidPassword(String password) {
        String upperCaseChars = "(.*[A-Z].*)";
        String lowerCaseChars = "(.*[a-z].*)";
        String numbers = "(.*[0-9].*)";
        String specialChars = "(.*[@,#,$,%].*$)";
        return password.length() <= 15 && password.length() >= 8 && password.matches(upperCaseChars) && password.matches(lowerCaseChars) && password.matches(numbers) && password.matches(specialChars);
    }

    public static boolean isValidPhoneNum(String pnum) {
        return pnum.length() == 11 && pnum.charAt(0) == '0' && pnum.charAt(1) == '1' && isUniquePhoneNumber(pnum);
    }
    private static boolean isUniquePhoneNumber(String phoneNumber){
        Person person=driverDataBase.getDriverByPhoneNumber(phoneNumber);
        person=userDataBase.getUserByPhoneNumber(phoneNumber);
        if (person==null){
            return true;
        }
        else{
            return false;
        }

    }

    public static boolean isValidEmail(String email) {
        return email.contains("@") && isUniqueEmail(email) && email.contains(".com");
    }

    private static boolean isUniqueEmail(String email) {
        Person person=driverDataBase.getDriverByEmail(email);
        person=userDataBase.getUserByEmail(email);
        if (person==null){
            return true;
        }
        else{
            return false;
        }
    }
}
