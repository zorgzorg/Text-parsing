package kz.epam.javalab22.parsing.iostream;

import java.io.*;

public class FileWriter {

    public static void write(String fileName, String text, String encoding) {
        try {
            Writer writer = new OutputStreamWriter(new FileOutputStream(fileName), encoding);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(text.toString());
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
