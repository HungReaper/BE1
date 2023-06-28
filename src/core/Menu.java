package core;

public class Menu {
    public static void mainMenu (){
        System.out.println("1. Student Functions");
        System.out.println("2. Subject Functions");
        System.out.println("3. Exit");
    }
    public static void menuStudent (){
        System.out.println("1. Show Student List");
        System.out.println("2. Create New Student");
        System.out.println("3. Read and Update");  
        System.out.println("4. Delete student");
        System.out.println("5. Show student grade report");
        System.out.println("6. Exit");
    }
    public static void menuUpdate (){
        System.out.println("1. Email");
        System.out.println("2. Day of Birth");
        System.out.println("3. Grade of subject");
        System.out.println("4. Join Subject");
        System.out.println("5. Exit");
    }

    public static void menuSubject () {
        System.out.println("1. Show Subject List.");
        System.out.println("2. Create New Subject.");
        System.out.println("3. Read and Updata.");
        System.out.println("4. Delete Subject.");
        System.out.println("5. Show Subject Grade.");
        System.out.println("6. Exit.");
    }

    public static void menuSubjectUpdate () {
        System.out.println("1. Subject Name.");
        System.out.println("2. Subject Id.");
        System.out.println("3. Subject Credit.");
        System.out.println("4. Exit.");
    }

    public static void menuExit () {
        System.out.println("\nwhat you want to do next");
        System.out.println("1. Exit");
        System.out.println("2. Continue");
    }

}
