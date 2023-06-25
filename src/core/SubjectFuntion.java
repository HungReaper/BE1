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
<<<<<<< HEAD
    public static final String FILESUBJECT = "D:\\VScode\\ProjectBE1\\Student_Management\\Student_Management\\src\\data";
    public static final String FILESUBIDLIST = "D:\\VScode\\ProjectBE1\\Student_Management\\Student_Management\\src\\data";
    public static final String FILESUBNAME = "D:\\VScode\\ProjectBE1\\Student_Management\\Student_Management\\src\\data\\SubjectName.txt";
    public static final String FILESUBID = "D:\\VScode\\ProjectBE1\\Student_Management\\Student_Management\\src\\data\\SubjectId.txt";
    public static final String FILESUBCREDIT = "D:\\VScode\\ProjectBE1\\Student_Management\\Student_Management\\src\\data\\SubjectCredit.txt";
=======
    public static final String FILESUBJECT = "src\\data\\Subject";
    public static final String FILESUBIDLIST = "src\\data\\Subject\\SubjectId";
    public static final String FILESUBNAME = "src\\data\\Subject\\SubjectName.txt";
    public static final String FILESUBID = "src\\data\\Subject\\SubjectId.txt";
    public static final String FILESUBCREDIT = "src\\data\\Subject\\SubjectCredit.txt";
>>>>>>> b64ceb699d9b5cfd8576695cce2d0bb108798077

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
                    break;
                case 6:
                    quit = true;
                    break;
            }
        }
    }

    public static void showList() {
        System.out.println("    ---Subject List---\n");
        ArrayList<String> subjectList = GetList.getList(FILESUBNAME);
        int i = 1;
        for (String sub : subjectList) {
            System.out.println(i + ". " + sub);
            i++;
        }
        sizeList = i-1;
        return;
    }

    public static void createNewSubject() {
        Main.clearConsole();
        Subject sub = new Subject();
        Scanner sc = new Scanner(System.in);
        System.out.println("--Create New subject");
        String name = "";
        String id = "";
        String credit = "0";

        boolean check = true;
        do{
            do {
                check = true;
                System.out.println("- Subject Name: ");
                name = sc.nextLine();
                int flag = CheckValid.checkSubName(name, FILESUBNAME);
                if(flag == 1) {
                    System.out.println("you should give this subject a name! please Re-Enter");
                    check = false;
                } else if(flag == 2) {
                    System.out.println("your subject name is too long, please make it shor enought");
                    check = false;
                } else if(flag == 3) {
                    System.out.println("subject name is already exited. Please Re-Enter");
                    check = false;
                }
            } while(!check);
            sub.setName(name);
            do {
                check = true;
                System.out.println("- Subject id: ");
                id = sc.nextLine();
                id = id.toUpperCase();
                int flag = CheckValid.checkSubId(id);
                if(flag == 1) {
                    System.out.println("The subject id already exited! please Re-Enter");
                    check = false;
                } else if(flag == 2) {
                    System.out.println("you should give your subject a id");
                    check = false;
                } else if(flag == 3) {
                    System.out.println("Your subject id is too long to remember, please Re-Enter subject id, I fogot it.");
                    check = false;
                }
            } while(!check);
            sub.setId(id);

            do {
                check = true;
                System.out.println("- Subject credit");
                credit = sc.nextLine();
                int flag = CheckValid.checkSubcredit(credit);
                if(flag == 1) {
                    System.out.println("your subject credit neeed to be a positive integers. Please Re-Enter!");
                    check = false;
                } else if(flag == 3) {
                    System.out.println("your subject credit need to be a number. please Re-Enter!");
                    check = false;
                } else if(flag == 2) {
                    System.out.println("your subject credit is to hight. please Re-Enter!");
                    check = false;
                }
            } while(!check);
            sub.setCredit(credit);

<<<<<<< HEAD
            WriteToFile.writtNewToFile(FILESUBIDLIST + "\\" + sub.getId() + ".txt" , sub.getName() + "\n" + sub. getId() + "\n" + sub.getCredit() + "\n");
=======
            WriteToFile.writtNewToFile(FILESUBIDLIST + "\\" + sub.getId() + ".txt" , sub.getName() + "\n" + sub. getId() + "\n" + sub.getCredit() + "\n" + "Joined student:\n");
>>>>>>> b64ceb699d9b5cfd8576695cce2d0bb108798077
            WriteToFile.WriteToFile(FILESUBNAME, sub.getName() + "\n");
            WriteToFile.WriteToFile(FILESUBID, sub.getId() + "\n");
            WriteToFile.WriteToFile(FILESUBCREDIT, sub.getCredit() + "\n");
        } while(!check);
    }

    public static void readAndUpdata() {
        Main.clearConsole();
        System.out.println("chose what subject you want to update\n");
        String subIdFromName = "";
        ArrayList <String> subName = GetList.getList(FILESUBNAME);
        ArrayList <String> idList = GetList.getList(FILESUBID);
        ArrayList <String> creditlist = GetList.getList(FILESUBCREDIT);
        int sizeId = idList.size();
        showList();
        System.out.println("what subject you like to Read?\n");
        int select = Main.choice(sizeId + 1);
        subIdFromName = idList.get(select - 1);
        boolean quit = false;
        ArrayList <String> subInFor = GetList.getList(FILESUBIDLIST + "\\" + subIdFromName + ".txt");
        while(!quit){
            int section = 0;
            do{
               showSubInFor(subInFor);
               System.out.println();
               System.out.println("---Update---\n");
               Menu.menuSubjectUpdate();
               System.out.println("\nWhat would you like to update?\n");
               section = Main.choice(4);
               switch(section){
                    // update name
                    case 1:
                        Main.clearConsole();
                        System.out.println("New Subject Name: ");
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
                        System.out.println("New subject ID: ");
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
                        System.out.println("New subject credit: ");
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
            int flag =  CheckValid.checkSubName(newName, FILESUBNAME);
            if(flag == 1) {
                    System.out.println("you should give this subject a name! please Re-Enter");
                    check = false;
                } else if(flag == 2) {
                    System.out.println("your subject name is too long, please make it shor enought");
                    check = false;
                } else if(flag == 3) {
                    System.out.println("subject name is already exited. Please Re-Enter");
                    check = false;
                }
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
            int flag = CheckValid.checkSubId(newId);
            if(flag == 1) {
                    System.out.println("The subject id already exited! please Re-Enter");
                    check = false;
                } else if(flag == 2) {
                    System.out.println("you should give your subject a id");
                    check = false;
                } else if(flag == 3) {
                    System.out.println("Your subject id is too long to remember, please Re-Enter subject id, I fogot it.");
                    check = false;
                }
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
            int flag = CheckValid.checkSubcredit(newCredit);
            if(flag == 1) {
                System.out.println("your subject credit neeed to be a positive integers. Please Re-Enter!");
                check = false;
            } else if(flag == 3) {
                System.out.println("your subject credit need to be a number. please Re-Enter!");
                check = false;
            } else if(flag == 2) {
                System.out.println("your subject credit is to hight. please Re-Enter!");
                check = false;
            }
        } while(!check);
        return newCredit;
    }

    public static void showSubInFor(ArrayList <String> list) {
        Main.clearConsole();
        try {
            System.out.println("---Subject's Information\n");
            System.out.println("    - Name:     " + list.get(0));
            System.out.println("    - ID:       " + list.get(1));
            System.out.println("    - Credit:   " + list.get(2));
        } catch (Exception e) {
            System.out.println("can't show information");
            // TODO: handle exception
        }
        
    }
    
    public static void deleteSubject() {
        boolean quit = false;
        String subIdFromName = "";
        do{
            boolean quit1 = true;
            Main.clearConsole();
            ArrayList <String> subName = GetList.getList(FILESUBNAME);
            ArrayList <String> idList = GetList.getList(FILESUBID);
            ArrayList <String> creditlist = GetList.getList(FILESUBCREDIT);
            int sizeId = idList.size();
<<<<<<< HEAD
            System.out.println("\n---Subject Name List---");
=======
            System.out.println("\n---Subject Name List---\n");
>>>>>>> b64ceb699d9b5cfd8576695cce2d0bb108798077
            showList();
            System.out.println("what subject you like to delete\n");
            int select = Main.choice(sizeId + 1);
            subIdFromName = idList.get(select - 1);
            ArrayList <String> subInFor = GetList.getList(FILESUBIDLIST + "\\" + subIdFromName + ".txt");
            String delName = subInFor.get(0);
            String delId = subInFor.get(1);
            String delCredit = subInFor.get(2);
            do{
<<<<<<< HEAD
                if(subInFor.size() > 3) { // < 4   ->   > 3
=======
                if(subInFor.size() < 4) {
>>>>>>> b64ceb699d9b5cfd8576695cce2d0bb108798077
                    System.out.println("There are still students, can't not deleted.");
                    quit1 = true;
                } else {
                    try {
                        ArrayList <String> newdelNameTxt = GetList.getListDel(FILESUBNAME, delName);
                        Formatter f = new Formatter(FILESUBNAME);
                        for(String string : newdelNameTxt) {
                            f.format(string + '\n');
                        }
                        f.close();
                        File file = new File(FILESUBIDLIST + "\\" + subIdFromName + ".txt");
                        file.delete();
                    } catch (Exception e) {
                        System.out.println("can't delete file list");
                    }
<<<<<<< HEAD
=======

>>>>>>> b64ceb699d9b5cfd8576695cce2d0bb108798077
                }
            } while(!quit1);

        } while(!quit);

    }


}
<<<<<<< HEAD
=======

>>>>>>> b64ceb699d9b5cfd8576695cce2d0bb108798077
