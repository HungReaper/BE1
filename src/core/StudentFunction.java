package core;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

import gui.Main;

public class StudentFunction {
    static int sizeList;

    public static void studentFunction (){
        boolean quit = false;
        while (!quit){
            Main.clearConsole();
            System.out.println("----STUDENT FUNCTION----");
            Menu.menuStudent();
            int choice2 = Main.choice(6);
            switch (choice2){
                case 1:
                    int choice3;
                    do {
                        Main.clearConsole();
                        showList();
                        System.out.println("\nExit?\n  1. yes\n  2.no ");
                        choice3 = Main.choice(2);
                    } while (choice3 == 2);
                    break;
                case 2:
                    int choice4;
                    do {
                        Main.clearConsole();
                        addInfor();
                        System.out.println("\nExit?\n  1. yes\n  2.no ");
                        choice4 = Main.choice(2);
                    } while (choice4 == 2);
                    break;
                case 3:
                    int choice5;
                    do {
                        Main.clearConsole();
                        showList();
                        read_updateInfor();
                        System.out.println("\nReturn?\n  1. Student Functions\n  2. Choose another student ");
                        choice5 = Main.choice(2);
                    } while(choice5 == 2);
                    break;
                case 4:
                    int choice6;
                    do {
                        Main.clearConsole();
                        showList();
                        System.out.println("Choose student to delete");
                        int select = Main.choice(sizeList);
                        deleteStudent(select-1);
                        System.out.println("\nContinue deleting?\n  1. Yes\n  2. No ");
                        choice6 = Main.choice(2);
                    } while (choice6 == 1);
                    break;
                case 5:
                    int choice7;
                    do {
                        Main.clearConsole();
                        showList();
                        System.out.println("Choose student");
                        int select = Main.choice(sizeList);
                        showTranscript(select);
                        System.out.println("\nExit?\n  1. Yes\n  2. Choose another student ");
                        choice7 = Main.choice(2);
                    } while (choice7 == 2);
                    break;      
                case 6:
                    quit = true;
                    break;    
            }
        }
        
    return;
    }
    //read and update
    public static void read_updateInfor() {
        boolean quit = false;
        String filenameFromID = "";
        ArrayList<String> idList = GetList.getList("D:\\VScode\\ProjectBE1\\Student_Management\\Student_Management\\src\\data\\id.txt");
        ArrayList <String> emailList = GetList.getList("D:\\VScode\\ProjectBE1\\Student_Management\\Student_Management\\src\\data\\email.txt");
        ArrayList <String> subList = GetList.getList("D:\\VScode\\ProjectBE1\\Student_Management\\Student_Management\\src\\data\\SubjectName.txt");
        int sizeID = idList.size();
        System.out.println("Choose a student to read or update");
        int select = Main.choice(sizeID+1);
        filenameFromID = idList.get(select-1);
        ArrayList <String> infor = GetList.getList("src\\data\\"+filenameFromID+".txt");
        while (!quit) {
            int section = 0;
            do {
                // read
                showInfor(infor);
                // update
                System.out.println("\n--Update--");
                Menu.menuUpdate();
                System.out.println("\nWhat section do you want to update -> ");
                section = Main.choice(5);
                switch (section) {
                    // update email
                    case 1:
                        System.out.print("New Email : ");
                        String newEmail = setEmail();
                        infor.set(2, newEmail);
                        emailList.set(select-1, newEmail);
                        try {
                            Formatter file = new Formatter("src\\data\\"+filenameFromID+".txt");
                            for (String string : infor) {
                                file.format(string+"\n");
                            }
                            file.close();
                        }
                        catch (Exception exception){
                            System.out.println("Cannot over write student file !");
                        }
                        try {
                            Formatter file = new Formatter("src\\data\\email.txt");
                            for (String string : emailList) {
                                file.format(string+"\n");
                            }
                            file.close();
                        }
                        catch (Exception exception){
                            System.out.println("Cannot over write email file !");
                        }
                        break;
                    // day of birth
                    case 2:
                        System.out.println("New Day of Birth : ");
                        String newDoB = setDayofBirth();
                        infor.set(3, newDoB);
                        try {
                            Formatter file = new Formatter("src\\data\\"+filenameFromID+".txt");
                            for (String string : infor){
                                file.format(string+"\n");
                            }
                            file.close();
                        }
                        catch (Exception exception){
                            System.out.println("Cannot over write student file");
                        }
                        break;
                    // grade
                    case 3:
                        int choice8;
                        System.out.println("---Update grade---");
                        do {
                           infor = updateGrade(infor, subList);
                            try {
                                Formatter file = new Formatter("D:\\VScode\\ProjectBE1\\Student_Management\\Student_Management\\src\\data\\"+filenameFromID+".txt");
                                for (String string : infor) {
                                    file.format(string+"\n");
                                }
                                file.close();
                            }
                            catch (Exception exception){
                                System.out.println("Cannot over write student file !");
                            }
                            System.out.println("Continue to update?\n  1. Yes\n  2. No");
                            choice8 = Main.choice(2);
                        } while (choice8 == 1);
                        Main.clearConsole();
                        break;
                    case 4:
                        int choice9;
                        ArrayList <String> subIDList = GetList.getList("D:\\VScode\\ProjectBE1\\Student_Management\\Student_Management\\src\\data\\SubjectID.txt");
                        do {
                            SubjectFuntion.showList();
                            infor = joinSubject(infor, subIDList, subList);
                            try {
                                Formatter file = new Formatter ("D:\\VScode\\ProjectBE1\\Student_Management\\Student_Management\\src\\data\\"+filenameFromID+".txt");
                                for (String string : infor) {
                                    file.format(string+"\n");
                                }
                                file.close();
                            }
                            catch (Exception exception){
                                System.out.println("Cannot over write student file !");
                            }
                            System.out.println("Add another subject?\n  1. Yes\n  2. No");
                            choice9 = Main.choice(2);
                        } while (choice9 == 1);
                        break;
                    case 5:
                        quit = true;
                        break;
                }
            } while (section != 5);
        }
    }

    // show list
    public static void showList() {
        System.out.println("---Student List---");
        ArrayList<String> studentList = GetList.getList("src\\data\\studentList.txt");
        int i = 1;
        for (String stu : studentList) {
            System.out.println(i + ". " + stu);
            i++;
        }
        sizeList = i-1;
        return;
    }

    // create
    public static void addInfor() {
        System.out.println("---Create New Student---");
        String name = "";
        String id = "";
        String email = "";
        int day = 0;
        int month = 0;
        int year = 0;
        boolean check;
        Student student = new Student();
        DayOfBirth dob;
        // enter name
        do {
            try {
                check = true;
                Scanner scan = new Scanner(System.in);
                System.out.print("- Name : ");
                name = scan.nextLine();

                if (CheckValid.checkName(name) == false) {
                    System.out.println("Your name not valid! Re-eneter");
                    check = false;
                }
            } catch (Exception exception) {
                check = false;
                System.out.println("Your name not valid! Re-eneter");
            }
        } while (!check);
        student.setName(name);
        // enter id
        do {
            try {
                check = true;
                Scanner scan = new Scanner(System.in);
                System.out.print("- ID (6 numbers): SE");
                id = scan.nextLine();
                if (CheckValid.checkID(id) == 0) {
                    System.out.println("Your ID not valid! Re-eneter");
                    check = false;
                } else if (CheckValid.checkID(id) == -1) {
                    System.out.println("ID has existed! Re-eneter");
                    check = false;
                }
            } catch (Exception exception) {
                check = false;
                System.out.println("Your ID not valid! Re-eneter");
            }
        } while (!check);
        student.setId(id);
        // set mail
        System.out.print("- Email : ");
        email = setEmail();
        student.setEmail(email);
        // enter day of birth
        System.out.println("Day of Birth");
        do {
            try {
                check = true;
                Scanner scan = new Scanner(System.in);
                System.out.print("- Day : ");
                day = scan.nextInt();
                System.out.print("- Month : ");
                month = scan.nextInt();
                System.out.print("- Year : ");
                year = scan.nextInt();
                if (CheckValid.checkValidDay(day, month, year) == false) {
                    check = false;
                    System.out.println("Your day of birth is not valid! Re-enter!");
                }
            } catch (Exception exception) {
                check = false;
                System.out.println("Your day of birth is not valid! Re-enter!");
            }
        } while (!check);
        dob = new DayOfBirth(day, month, year);
        student.setDob(dob);
        // write to a file
        // D:\\VScode\\ProjectBE1\\Student_Management\\Student_Management\\src\\data
        try {
            Formatter file = new Formatter("src\\data\\SE" + id + ".txt");
            file.format(student.getName() + "\n" + student.getId() + "\n" + student.getEmail() + "\n"+ student.getDob().getDay() + " / " + student.getDob().getMonth() + " / "+ student.getDob().getYear() + "\n");                                           
            file.close();
        } catch (Exception exception) {
            System.out.println("Error: Cannot create student file");
        }
        try {
            File idFile = new File("src\\data\\id.txt");
            FileWriter fwritter = new FileWriter(idFile, true);
            BufferedWriter bwritter = new BufferedWriter(fwritter);
            bwritter.write("SE" + student.getId() + "\n");
            bwritter.close();
        } catch (Exception exception) {
            System.out.println("Cannot open id.txt");
        }
        try {
            File emailFile = new File("src\\data\\email.txt");
            FileWriter fwritter = new FileWriter(emailFile, true);
            BufferedWriter bwritter = new BufferedWriter(fwritter);
            bwritter.write(student.getEmail() + "\n");
            bwritter.close();
        } catch (Exception exception) {
            System.out.println("Cannot open email.txt");
        }
        try {
            File idFile = new File("src\\data\\studentList.txt");
            FileWriter fwritter = new FileWriter(idFile, true);
            BufferedWriter bwritter = new BufferedWriter(fwritter);
            bwritter.write(student.getName() + "\n");
            bwritter.close();
        } catch (Exception exception) {
            System.out.println("Cannot open studentList.txt");
        }
        return;
    }

    // show infor
    public static void showInfor(ArrayList <String> infor) {
        Main.clearConsole();
        try {
            System.out.println("---Student's Information---");
            System.out.println("   - Name : " + infor.get(0));
            System.out.println("   - ID : " + infor.get(1));
            System.out.println("   - Email : " + infor.get(2));
            System.out.println("Day of birth : "+infor.get(3));
        }
        catch (Exception e){
            System.out.println("Cannot show information");
        }
    }

    // delete student
    public static void deleteStudent (int select){
        ArrayList<String> idList = GetList.getList("D:\\VScode\\ProjectBE1\\Student_Management\\Student_Management\\src\\data\\id.txt");
        String fileName = idList.get(select);
        ArrayList <String> inforList = GetList.getList("D:\\VScode\\ProjectBE1\\Student_Management\\Student_Management\\src\\data\\"+fileName+".txt");
        // student will not be deleted when joined the subject
        if (inforList.size() >= 5){
            System.out.println("This student joined subject. Cannot delete!");
            return;
        }
        ArrayList<String> studentList = GetList.getList("D:\\VScode\\ProjectBE1\\Student_Management\\Student_Management\\src\\data\\studentList.txt");
        ArrayList<String> emailList = GetList.getList("D:\\VScode\\ProjectBE1\\Student_Management\\Student_Management\\src\\data\\email.txt");
        studentList.add(""); idList.add(""); emailList.add("");
        for (int i = select ; i < idList.size()-1 ; i++){
            studentList.set(i, studentList.get(i+1));
            idList.set(i, idList.get(i+1));
            emailList.set(i,emailList.get(i+1));
        }
        try {
            File file = new File ("D:\\VScode\\ProjectBE1\\Student_Management\\Student_Management\\src\\data\\"+fileName+".txt");
            if (file.delete()){
                System.out.println(file.getName()+" is deleted");
            }
        }
        catch (Exception exception){
            System.out.println("File cannot delete");
        }
        try {
            Formatter newStudentFile = new Formatter("D:\\VScode\\ProjectBE1\\Student_Management\\Student_Management\\src\\data\\studentList.txt");
            for (String string : studentList) {
                newStudentFile.format(string+"\n");
            }
            newStudentFile.close();
            Formatter newidFile = new Formatter("D:\\VScode\\ProjectBE1\\Student_Management\\Student_Management\\src\\data\\id.txt");
            for (String string : idList) {
                newidFile.format(string+"\n");
            }
            newidFile.close();
            Formatter newEmailFile = new Formatter("D:\\VScode\\ProjectBE1\\Student_Management\\Student_Management\\src\\data\\email.txt");
            for (String string : emailList) {
                newEmailFile.format(string+"\n");
            }
            newEmailFile.close();
            Fix.deleteNullRow("D:\\VScode\\ProjectBE1\\Student_Management\\Student_Management\\src\\data\\studentList.txt");
            Fix.deleteNullRow("D:\\VScode\\ProjectBE1\\Student_Management\\Student_Management\\src\\data\\id.txt");
            Fix.deleteNullRow("D:\\VScode\\ProjectBE1\\Student_Management\\Student_Management\\src\\data\\email.txt");
        }
        catch (Exception exception){
            System.out.println("Cannot delete from list");
        }
    }
    
    // update grade
    public static ArrayList <String> updateGrade (ArrayList <String> list , ArrayList <String> subList){
        boolean flag = false;
        int line = -1;
        double labScore , progressScore , finalScore , ave = 0.0;
        ArrayList <String> gradeList = new ArrayList<String>(list);
        SubjectFuntion.showList();
        System.out.println("Choose subject to update grade ");
        int subSelect = Main.choice(subList.size());
        //System.out.println(subList.get(subSelect-1));
        for (int i = 4 ; i < list.size() ; i++){
            String[] tempSub = list.get(i).split(" , ");
            if (tempSub[0].compareTo(subList.get(subSelect-1)) == 0){
                //System.out.println(list.get(i));
                flag = true;
                line = i;
                break;
            }
        }
        if (flag){
            try {
                System.out.print("Lab grade : ");
                labScore = setGrade();
                System.out.print("Progress grade : ");
                progressScore = setGrade();
                System.out.print("Final grade : ");
                finalScore = setGrade();
                ave = (labScore + progressScore + finalScore)/3;
                DecimalFormat df = new DecimalFormat("0.0#");
                String rounded = df.format(ave);
                gradeList.set(line, subList.get(subSelect-1)+ " , " + String.valueOf(labScore) + " , " + String.valueOf(progressScore)+ " , " + String.valueOf(finalScore)+" , "+rounded);
            }
            catch (Exception exception){
                System.out.println("Cannot set grade");
            }

        }
        else {
            System.out.println("The student has not joined yet!");
        }
        return gradeList;
    }
    // join subject
    public static ArrayList <String> joinSubject (ArrayList <String> list , ArrayList <String> subIDList , ArrayList <String> subList){
        ArrayList <String> newList = new ArrayList<>(list);
        int size = subIDList.size();
        System.out.println("Choose subject to join");
        int select = Main.choice(size);
        for (int i = 0 ; i < list.size() ; i++){
            String [] temp = list.get(i).split(" , ");
            if (temp[0].compareTo(subList.get(select-1)) == 0){
                System.out.println("The subject has existed in profile");
                return newList;
            }
        }
        newList.add(subList.get(select-1));
        getNameToSubFile(select-1, newList.get(0));
        return newList;
    }
    // add student into subject file
    public static void getNameToSubFile (int select , String name){
        ArrayList <String> subIDList = GetList.getList("D:\\VScode\\ProjectBE1\\Student_Management\\Student_Management\\src\\data\\SubjectID.txt");
        String fileName = "D:\\VScode\\ProjectBE1\\Student_Management\\Student_Management\\src\\data\\" + subIDList.get(select) + ".txt";
        ArrayList <String> inforSubList = GetList.getList(fileName);
        inforSubList.add(name);
        try {
            Formatter file = new Formatter(fileName);
            for (String string : inforSubList) {
                file.format(string+"\n");
            }
            file.close();
        }
        catch (Exception exception){
            System.out.println("Cannot write student name to subject file");
        }
    }
    // show transcipt
    public static void showTranscript (int select){
        ArrayList <String> idList = GetList.getList("D:\\VScode\\ProjectBE1\\Student_Management\\Student_Management\\src\\data\\id.txt");
        String fileName = idList.get(select-1);
        // read list  // remove from 0 -> 3
        ArrayList <String> sub_gradeList = GetList.getList("D:\\VScode\\ProjectBE1\\Student_Management\\Student_Management\\src\\data\\"+fileName+".txt");
        try {
            for (int i = 4 ; i < sub_gradeList.size() ; i++){
                String[] temp = sub_gradeList.get(i).split(" , ");
                System.out.println("+ "+temp[0]);
                if (temp.length == 1) 
                    continue;
                else {
                    System.out.println("  - Lab : "+temp[1]);
                    System.out.println("  - Progress : "+temp[2]);
                    System.out.println("  - Final : "+temp[3]);
                    System.out.println("  - Average : "+temp[4]);
                    System.out.println("");
                }
            }
        }
        catch (Exception exception){
            System.out.println("No Grade!");
        }
    }
    // set new email
    public static String setEmail() {
        boolean check;
        String newEmail = "";
        do {
            try {
                check = true;
                Scanner scan = new Scanner(System.in);
                newEmail = scan.nextLine();
                if (CheckValid.checkEmail(newEmail) == 0) {
                    check = false;
                    System.out.println("Your Email not valid! Re-eneter");
                } else if (CheckValid.checkEmail(newEmail) == -1) {
                    System.out.println("Email has existed! Re-eneter");
                    check = false;
                }
            } catch (Exception exception) {
                check = false;
                System.out.println("Your Email not valid! Re-eneter");
            }
        } while (!check);
        return newEmail;
    }
    // set day of birth
    public static String setDayofBirth (){
        boolean check;
        int day = 0, month = 0 , year = 0;
        do {
            try {
                check = true;
                Scanner scan = new Scanner(System.in);
                System.out.print("- Day : ");
                day = scan.nextInt();
                System.out.print("- Month : ");
                month = scan.nextInt();
                System.out.print("- Year : ");
                year = scan.nextInt();
                if (CheckValid.checkValidDay(day, month, year) == false) {
                    check = false;
                    System.out.println("Your day of birth is not valid! Re-enter!");
                }
            } catch (Exception exception) {
                check = false;
                System.out.println("Your day of birth is not valid! Re-enter!");
            }
        } while (!check);
        String strDoB = new String (day+" / "+month+" / "+year);
        return strDoB;
    }
     // set valid grade
    public static double setGrade (){
        boolean check;
        double grade = 0.0;
        do {
            check = true;
            try {
                Scanner scan = new Scanner(System.in);
                grade = scan.nextDouble();
                if (grade < 0.0 || grade > 10.0){
                    check = false;
                    System.out.println("Grade is not valid");
                }
            }
            catch (Exception exception){
                check = false;
                System.out.println("Grade is not valid");
            }
        } while (!check);
        return grade;
    }
}
