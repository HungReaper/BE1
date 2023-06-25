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
<<<<<<< HEAD
    
     public static ArrayList <String> getListDel (String path, String del){
=======

    public static ArrayList <String> getListDel (String path, String del){
>>>>>>> b64ceb699d9b5cfd8576695cce2d0bb108798077
        ArrayList <String> list = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));                       
            String line;
            do {
                line = reader.readLine();
                if (line.equals(del)) {
<<<<<<< HEAD
                    
=======
>>>>>>> b64ceb699d9b5cfd8576695cce2d0bb108798077
                } else if (line != null){
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
}


