package core;

import java.util.ArrayList;
import java.util.Formatter;

public class Fix {
    public static void deleteNullRow (String path){
        ArrayList <String> list = GetList.getList(path);
        int i = 0;
        while (i < list.size()){
            //System.out.println(i+". "+list.get(i));
            if (list.get(i) == null || list.get(i).length() == 0){
                list.remove(i);
            }
            else {
                i++;
            }
        }
        try {
            Formatter file = new Formatter(path);
            for (String string : list) {
                file.format(string+"\n");
            }
            file.close();
        }
        catch (Exception exception){
            System.out.println("Cannot fix file");
        }
    }
}
