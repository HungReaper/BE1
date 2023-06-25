package core;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;

public class WriteToFile {
    //tạo file mới và ghi nội dung vào file
    public static void writtNewToFile(String patch, String content) {
        try {
            Formatter f = new Formatter(patch);
            f.format(content);
            f.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            System.out.println("fail to write to file");
            e.printStackTrace();
        }
    }

    public static void WriteToFile(String patch, String content) {
        try {
            File f = new File(patch);
            FileWriter fw = new FileWriter(f, true);
            BufferedWriter bfw = new BufferedWriter(fw);
            bfw.write(content);
            bfw.close();
        } catch (IOException e) {
            System.out.println("fail to write to file");
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    
}
