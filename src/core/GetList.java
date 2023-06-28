package core;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class GetList {
    public static ArrayList <String> getList (String path){
        ArrayList <String> list = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));                       
            String line;
            do {
                line = reader.readLine();
                if (line != null){
                        list.add(line);
                }
            } while (line != null);
            reader.close();
        }
        catch (Exception exception){
            System.out.println("Cannot Read :  "+path);
        }
        return list;
    }
    
    public static ArrayList <String> getListDel (String path, String del){
        ArrayList <String> list = new ArrayList<>();
        int flag = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));                       
            String line;
            do {
                line = reader.readLine();
                if (line.equals(del)) {
                } else if (line != null){
                    list.add(line);
                }
            } while (line != null);
            reader.close();
        }
        catch (Exception exception){
            // System.out.println("Cannot Read :  " +path);
        }
        return list;
    }

    public static ArrayList <String> getListDel (String path, String del, int select){
        ArrayList <String> list = new ArrayList<>();
        int flag = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));                       
            String line;
            do {
                line = reader.readLine();
                if (line.equals(del) && flag == select) {
                    flag = 1;
                } else if (line != null){
                    list.add(line);
                }
                flag++;
            } while (line != null);
            reader.close();
        }
        catch (Exception exception){
            // System.out.println("Cannot Read :  " +path);
        }
        return list;
    }
}


