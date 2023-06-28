package core;

import java.util.ArrayList;

import javax.sound.midi.Patch;

public class CheckValid {
    // check name
    public static boolean checkName (String name){
        if (name.length() == 0) return false;
        for (int i = 0 ; i < name.length() ; i++){
            if (name.charAt(i) >= '1' && name.charAt(i) <= '9') return false;
        }
        return true;
    }
    // check id
    public static int checkID (String id){
        ArrayList <String> idList = GetList.getList("src\\data\\id.txt");
        if (id.length() != 6) return 0;
        for (int i = 0 ; i < id.length() ; i++ ){
            if (id.charAt(i) < '0' || id.charAt(i) > '9') return 0;
        }
        String temp = "SE"+id;
        for (String string : idList) {
            if (string.compareTo(temp) == 0) return -1;
        }
        return 1;
    }
    // check email
    public static int checkEmail (String email){
        ArrayList <String> elist = GetList.getList("src\\data\\email.txt");
        if (email.length() == 0) return 0;
        int indxAt = -1;
        indxAt = email.indexOf("@gmail.com");
        if (indxAt < 1) return 0; 
        for (String string : elist) {
            if (email.compareTo(string) == 0) return -1;
        }
        return 1;
    }
    // check day of birth
    public static boolean checkValidDay (int day, int month, int year){
        if (year < 1990 || year > 2006) return false;
        if (month < 1 || month > 12) return false;
        if (day < 1 || day > 31 ) return false;
        if (year % 4 == 0 && year % 100 != 0) {
            if (month == 2) {
                if (day < 1 || day > 29) return false;
            }
        }
        else {
            if (month == 2) {
                if (day < 1 || day > 28) return false;
            }
            else if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                if (day < 1 || day > 31) return false;
            }
            else {
                if (day < 1 || day > 30) return false;
            }
        }
        return true;
    }
    // File address
    static final String subjectFile = "D:\\VScode\\ProjectBE1\\Student_Management\\Student_Management\\src\\data\\";
    // check Subject nname input

    public static boolean checkSubName (String name, String Patch){
        if(name.length() == 0) {
            System.out.println("you should give this subject a name! please Re-Enter");
            return false;
        }
        if(name.length() > 200) {
            System.out.println("your subject name is too long, please make it shor enought");
            return false;
        }
        ArrayList <String> nameList = GetList.getList(Patch);
        for(String string : nameList) {
            if(string.equals(name)){
                System.out.println("subject name is already exited. Please Re-Enter");
                return false;
            }               // nameList -> string
        }
        return true;
    }

    public static boolean checkSubId(String id) {
        ArrayList <String> idList = GetList.getList(subjectFile + "SubjectId.txt");
        for (String string : idList){
            if(id.equals(string)) {
                System.out.println("The subject id already exited! please Re-Enter");
                return false;
            }
        }
        if(id.length() == 0) {
            System.out.println("you should give your subject a id");
            return false;
        }
        if(id.length() > 30) {
            System.out.println("Your subject id is too long to remember, please Re-Enter subject id, I fogot it.");
            return false;
        }
        return true;
    }

    public static boolean checkSubcredit (String credit){

    try {
        int number = Integer.parseInt(credit);

        if(number < 0) {
            System.out.println("your subject credit neeed to be a positive integers. Please Re-Enter!");
            return false;
        }
        if(number > 30) {
            System.out.println("your subject credit is to hight. please Re-Enter!");
            return false;
        }
    } catch (NumberFormatException e) {
        System.out.println("your subject credit need to be a number. please Re-Enter!");
        return false;
    }
        return true;
    }
}
