package gui;

import core.Menu;
import core.StudentFunction;
import core.SubjectFuntion;
<<<<<<< HEAD
=======

import java.io.FileNotFoundException;
import java.util.Scanner;
>>>>>>> b64ceb699d9b5cfd8576695cce2d0bb108798077

public class Main {

    public static int choice (int max) {
        int num = 0;
        boolean check;
        do {
            try {
            check = true;
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your choice -> ");
            num = scanner.nextInt();
                if (num < 1 || num > max) {
                    check = false;  
                    System.out.println("Re-enter!");
                }
            }
            catch (Exception exception){
                check = false;
                System.out.println("Your choice is not valid ! Re-enter! ");
            }
        } while (!check);
        return num;
    }
    public static void clearConsole (){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public static void main(String[] args) throws FileNotFoundException {
        clearConsole();
        Scanner scan = new Scanner(System.in);
        boolean quit = false;
        while (!quit){
            clearConsole();
            System.out.println("----STUDENT MANAGEMENT PROGRAM-----");
            Menu.mainMenu();
            int choice1 = choice(3);
            switch (choice1) {
                case 1:
                    StudentFunction.studentFunction();
                    break;
                case 2:
<<<<<<< HEAD
=======
                    clearConsole();
>>>>>>> b64ceb699d9b5cfd8576695cce2d0bb108798077
                    SubjectFuntion.subjectFuntion();
                    break;
                case 3:
                    quit = true;
                    break;
            }
        }
    }



}
