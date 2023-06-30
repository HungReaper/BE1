package core;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

import gui.Main;

public class SubjectFuntion {
    static int sizeList;
    public static final String FILESUBJECT = "D:\\VScode\\ProjectBE1\\Student_Management\\Student_Management\\src\\data";
    public static final String FILESUBIDLIST = "D:\\VScode\\ProjectBE1\\Student_Management\\Student_Management\\src\\data";
    public static final String FILESUBNAME = "D:\\VScode\\ProjectBE1\\Student_Management\\Student_Management\\src\\data\\SubjectName.txt";
    public static final String FILESUBID = "D:\\VScode\\ProjectBE1\\Student_Management\\Student_Management\\src\\data\\SubjectId.txt";
    public static final String FILESUBCREDIT = "D:\\VScode\\ProjectBE1\\Student_Management\\Student_Management\\src\\data\\SubjectCredit.txt";
    public static final String FILESTUID = "D:\\VScode\\ProjectBE1\\Student_Management\\Student_Management\\src\\data\\id.txt";
    public static final String FILESTUNAME = "D:\\VScode\\ProjectBE1\\Student_Management\\Student_Management\\src\\data\\studentList.txt";
    public static void subjectFuntion (){
        boolean quit = false;
        while(!quit){
            Main.clearConsole();
            Menu.menuSubject();
            int choice1 = Main.choice(6);
            switch(choice1){
                case 1:
                    Main.clearConsole();
                    int choice2;
                    do {
                        Main.clearConsole();
                        showList();
                        System.out.println("\nExit?\n  1. yes\n  2.no ");
                        choice2 = Main.choice(2);
                    } while(choice2 == 2);
                    break;
                case 2:
                    createNewSubject();
                    break;
                case 3:
                    readAndUpdata();
                    break;
                case 4:
                    deleteSubject();
                    break;
                case 5:
                    showSubGrade();
                    break;
                case 6:
                    quit = true;
                    break;
            }
        }
    }

    public static void showList() {
        System.out.println("    --- Subject List ---\n");
        ArrayList<String> subjectList = GetList.getList(FILESUBNAME);
        int i = 1;
        for (String sub : subjectList) {
            System.out.println(i + ".   " + sub);
            i++;
        }
        sizeList = i-1;
        return;
    }

    public static void createNewSubject() {
        Main.clearConsole();
        Subject sub = new Subject();
        Scanner sc = new Scanner(System.in);
        System.out.println("-- Create New subject ---");
        String name = "";
        String id = "";
        String credit = "0";

        boolean check = true;
        do{
            do {
                check = true;
                System.out.printf("- Subject Name: ");
                name = sc.nextLine();
                check = CheckValid.checkSubName(name, FILESUBNAME);
            } while(!check);
            sub.setName(name);
            do {
                check = true;
                System.out.printf("- Subject id: ");
                id = sc.nextLine();
                id = id.toUpperCase();
                check = CheckValid.checkSubId(id);
            } while(!check);
            sub.setId(id);

            do {
                check = true;
                System.out.printf("- Subject credit: ");
                credit = sc.nextLine();
                check = CheckValid.checkSubcredit(credit);
            } while(!check);
            sub.setCredit(credit);

            WriteToFile.writtNewToFile(FILESUBIDLIST + "\\" + sub.getId() + ".txt" , sub.getName() + "\n" + sub. getId() + "\n" + sub.getCredit() + "\n");
            WriteToFile.WriteToFile(FILESUBNAME, sub.getName() + "\n");
            WriteToFile.WriteToFile(FILESUBID, sub.getId() + "\n");
            WriteToFile.WriteToFile(FILESUBCREDIT, sub.getCredit() + "\n");
        } while(!check);
    }

    public static void readAndUpdata() {
        Main.clearConsole();
        System.out.println("Chose what subject you want to update\n");
        String subIdFromName = "";
        ArrayList <String> subName = GetList.getList(FILESUBNAME);
        ArrayList <String> idList = GetList.getList(FILESUBID);
        ArrayList <String> creditlist = GetList.getList(FILESUBCREDIT);
        int sizeId = idList.size();
        showList();
        System.out.println("\n what subject you like to Read?\n");
        int select = Main.choice(sizeId + 1);
        subIdFromName = idList.get(select - 1);
        boolean quit = false;
        ArrayList <String> subInFor = GetList.getList(FILESUBIDLIST + "\\" + subIdFromName + ".txt");
        while(!quit){
            int section = select;
            do{
               showSubInFor(subInFor);
               System.out.println();
               System.out.println("--- Update ---\n");
               Menu.menuSubjectUpdate();
               System.out.println("\nWhat would you like to update?\n");
               int section1 = Main.choice(4);
               switch(section1){
                    // update name
                    case 1:
                        Main.clearConsole();
                        System.out.printf("- New Subject Name: ");
                        String newName = updateName();
                        subInFor.set(0, newName);
                        subName.set(section - 1, newName);
                        try {
                            Formatter f = new Formatter(FILESUBIDLIST + "\\" + subIdFromName + ".txt");
                            for(String string : subInFor) {
                                f.format(string + "\n");
                            }
                            f.close();
                        } catch (Exception e) {
                            System.out.println("can't not write to file list");
                        }
                        try {
                            Formatter f = new Formatter(FILESUBNAME);
                            for(String string : subName) {
                                f.format(string + "\n");
                            }
                            f.close();
                        } catch (Exception e) {
                            System.out.println("can't write to file Name");
                        }
                        break;
                    // updata id
                    case 2:
                        Main.clearConsole();
                        System.out.printf("- New subject ID: ");
                        String newId = updateId();
                        newId.toUpperCase();
                        subInFor.set(1, newId);
                        idList.set(section - 1, newId);
                        try {
                            Formatter f = new Formatter(FILESUBIDLIST + "\\" + newId + ".txt");
                            for(String string : subInFor) {
                                f.format(string + "\n");
                            }
                            f.close();
                        } catch (Exception e) {
                            System.out.println("can't write to file list");                      
                        }
                        try {
                            Formatter f = new  Formatter(FILESUBID);
                            for(String string : idList) {
                                f.format(string + "\n");
                            }
                            f.close();
                        } catch (Exception e) {
                            System.out.println("can't wirte to file txt");
                        }
                        try {
                            File f = new File(FILESUBIDLIST + "\\" + subIdFromName + ".txt");
                            f.delete();
                        } catch (Exception e) {
                            System.out.println("can't delete old file txt");
                        }
                        
                        break;
                    // updata credit
                    case 3:
                        Main.clearConsole();
                        System.out.printf("- New subject credit: ");
                        String newCredit = updateCredit();
                        subInFor.set(2, newCredit);
                        creditlist.set(section - 1, newCredit);
                        try {
                            Formatter f = new Formatter(FILESUBIDLIST + "\\" + subIdFromName + ".txt");
                            for(String string : subInFor) {
                                f.format(string + "\n");
                            }
                            f.close();
                        } catch (Exception e) {
                            System.out.println("can't wirte to file list");
                        }
                        try {
                            Formatter f = new Formatter(FILESUBCREDIT);
                            for(String string : creditlist) {
                                f.format(string + "\n");
                            }
                            f.close();
                        } catch (Exception e) {
                            System.out.println("can't wirte to file txt");
                        }
                        break;
                    case 4:
                        quit = true;
                        break;
               }

            } while(!quit);
        }
    }

    public static String updateName() {
        boolean check = true;
        String newName = "";
        do {
            check = true;
            Scanner sc = new Scanner(System.in);
            newName = sc.nextLine();
            check =  CheckValid.checkSubName(newName, FILESUBNAME);
        } while(!check);
        return newName;
    }
    
    public static String updateId() {
        boolean check = true;
        String newId = "";
        do {
            check = true;
            Scanner sc = new Scanner(System.in);
            newId = sc.nextLine();
            newId.toUpperCase();
            check = CheckValid.checkSubId(newId);
        } while(!check);
        return newId;
    }

    public static String updateCredit() {
        boolean check = true;
        String newCredit = "";
        do {
            check = true;
            Scanner sc = new Scanner(System.in);
            newCredit = sc.nextLine();
            check = CheckValid.checkSubcredit(newCredit);
        } while(!check);
        return newCredit;
    }

    public static void showSubInFor(ArrayList <String> list) {
        Main.clearConsole();
        try {
            System.out.println("--- Subject's Information ---\n");
            System.out.println("    - Name     : " + list.get(0));
            System.out.println("    - ID       : " + list.get(1));
            System.out.println("    - Credit   : " + list.get(2));
        } catch (Exception e) {
            System.out.println("can't show information");
            // TODO: handle exception
        }
        
    }
    
    // xóa Subject
    public static void deleteSubject() {
        boolean quit = false;
        String subIdFromName = "";
        do{
            boolean quit1 = true;
            Main.clearConsole();
            ArrayList <String> idList = GetList.getList(FILESUBID);
            int sizeId = idList.size();
            showList();
            System.out.println("what subject you like to delete\n");
            int select = Main.choice(sizeId + 1);
            subIdFromName = idList.get(select - 1);
            ArrayList <String> subInFor = GetList.getList(FILESUBIDLIST + "\\" + subIdFromName + ".txt");
            String delName = subInFor.get(0);
            String delId = subInFor.get(1);
            String delCredit = subInFor.get(2);
            do{
                if(subInFor.size() > 3) { // 3 kiểm tra xem có tên học sinh nhập học không
                    System.out.println("There are still students, can't not deleted.\n");
                    quit1 = true;
                } else {
                    delete(delName, delId, delCredit, subIdFromName, select - 1);
                    quit1 = true;
                }
            } while(!quit1);
            Menu.menuExit();
            if(Main.choice(2) == 1){
                quit = true;
            }

        } while(!quit);
    }

    public static void delete(String delName, String delid, String delCredit, String subIdFromName, int select) {
        try {
            ArrayList <String> newDelNameTxt = GetList.getListDel(FILESUBNAME, delName);
            ArrayList <String> newDelIdTxt = GetList.getListDel(FILESUBID, delid);
            ArrayList <String> newDelCreditTxt = GetList.getListDel(FILESUBCREDIT, delCredit, select);
            WriteToFile.writtNewToFile(FILESUBNAME, newDelNameTxt);
            WriteToFile.writtNewToFile(FILESUBID, newDelIdTxt);
            WriteToFile.writtNewToFile(FILESUBCREDIT, newDelCreditTxt);
            File f =  new File(FILESUBJECT + "//" + subIdFromName + ".txt");
            f.delete();
        } catch (Exception e) {
            System.out.println("can't delete file");
        }
    }

    public static void showSubGrade() {
        Main.clearConsole();
        Scanner sc = new Scanner(System.in);
        boolean quit = true;
        String subIdFromName = "";
        String subName = "";
        do {
            quit = true;
            ArrayList <String> idList = GetList.getList(FILESUBID);
            ArrayList <String> subjectName = GetList.getList(FILESUBNAME);
            int sizeId = idList.size();
            Main.clearConsole();
            showList();
            System.out.println("what subject you like to see grad?\n");
            int select = Main.choice(sizeId + 1);
            subIdFromName = idList.get(select - 1);
            subName = subjectName.get(select - 1);
            ArrayList <String> subInfor = GetList.getList(FILESUBJECT + "\\" + subIdFromName + ".txt");
            boolean quit1 =true;
            do{
                if(subInfor.size() > 3){
                    System.out.printf("%-25s%-16s%-20s%-20s\n", "Student name", "lab", "Prgress", "Final");
                    ArrayList <String> idStuList = GetList.getList(FILESTUID);
                    ArrayList <String> nameStuList = GetList.getList(FILESTUNAME);
                    ArrayList <String> idStu = new ArrayList<>();
                    for(int i = 3; i < subInfor.size(); i ++){
                        String string = subInfor.get(i);
                        int flag = 0;
                        for(String string2 : nameStuList) {
                            if(string.equals(string2)) {
                                String fileName = idStuList.get(flag);
                                ArrayList <String> sub_gaArrayList = GetList.getList(FILESUBJECT + "\\" +fileName + ".txt");
                                try {
                                    for(int i1 = 4; i < sub_gaArrayList.size(); i1 ++) {                               
                                        String[] temp = sub_gaArrayList.get(i1).split(" , ");
                                        if(subName.equals(temp[0])) {
                                            System.out.printf("%-25s", sub_gaArrayList.get(0));
                                            if(temp.length == 1){
                                                System.out.printf("\n");
                                                continue;
                                            }
                                            else  {
                                                System.out.printf("%-16s%-20s%-20s\n", temp[1], temp[2], temp[3]);
                                            }
                                        } 
                                    }
                                } catch (Exception e) {
                                    // TODO: handle exception
                                }

                            }
                            flag++;
                        }
                    }
                } else {
                    System.out.println("\n  There no student to show grade");
                }
                quit1 = true;
                Menu.menuExit();
                if(Main.choice(2) == 2) quit = false;

            } while(!quit1);
        } while(!quit);
    }
}
