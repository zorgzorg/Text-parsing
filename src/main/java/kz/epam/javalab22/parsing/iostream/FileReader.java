package kz.epam.javalab22.parsing.iostream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class FileReader {
    public static String read(String fileName) {
        final String DELIMITER_PATTERN = "\\Z";

        InputStream is = null;
        try {
            is = new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String sourceText = new Scanner(is).useDelimiter(DELIMITER_PATTERN).next();

        return sourceText;
    }
}
