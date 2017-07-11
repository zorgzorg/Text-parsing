package kz.epam.javalab22.parsing.iostream;

import java.io.*;

public class FileReader {
    private static final int EOF = -1;

    public static String read(String fileName, String encoding){

        String sourceText = new String();

        try {
            Reader reader = new InputStreamReader(new FileInputStream(fileName), encoding);
            BufferedReader bufferedReader = new BufferedReader(reader);
            int s;

            while ((s=bufferedReader.read())!=EOF) {
                sourceText += (char)s;
            }

            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sourceText;
    }
}
