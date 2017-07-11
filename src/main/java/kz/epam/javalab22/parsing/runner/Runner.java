package kz.epam.javalab22.parsing.runner;

import kz.epam.javalab22.parsing.entity.CompositeText;
import kz.epam.javalab22.parsing.iostream.FileReader;
import kz.epam.javalab22.parsing.iostream.FileWriter;
import kz.epam.javalab22.parsing.operation.Corrector;
import kz.epam.javalab22.parsing.operation.Parser;

import java.io.IOException;

public class Runner {
    private final static String INPUT_FILE = "text.txt";
    private final static String OUTPUT_FILE = "textOutput.txt";
    private static final String ENCODING = "UTF-8";

    public static void main(String[] args) throws IOException {

        CompositeText text = Parser.parseText(FileReader.read(INPUT_FILE, ENCODING));
        FileWriter.write(OUTPUT_FILE, text.toString(), ENCODING);

        Corrector.correct(text);
        System.out.println(text);

    }

}
