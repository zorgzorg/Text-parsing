package kz.epam.javalab22.parsing.iostream;

import java.io.*;

public class FileWriter {

    public static void write(String fileName, String text) {
        try {
            Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), "UTF-8"));
            out.write(text.toString());
            out.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
