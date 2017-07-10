package kz.epam.javalab22.parsing.operation;

import kz.epam.javalab22.parsing.entity.*;

public class Parser {
    public static final String PARAGRAPH_SPLIT_PATTERN = "(?=(\\n|\\rn|\\r))";
    public static final String SENTENCE_SPLIT_PATTERN = "(?=(\\.|!|\\?))";
    public static final String WORD_SPLIT_PATTERN = "(?<=\\s)|(?=\\s)|(?=\\p{P})|(?<=\\p{P})";

    public static CompositeText parseText(String source){
        CompositeText text = new CompositeText();
        String[] paragraphs = source.split(PARAGRAPH_SPLIT_PATTERN);

        for (String paragraph : paragraphs) {
            text.add(parseParagraph(paragraph));
        }

        return text;

    }

    private static CompositeText parseParagraph(String source){
        CompositeText paragraph = new CompositeText();
        String[] sentences = source.split(SENTENCE_SPLIT_PATTERN);

        for(String sentence: sentences){
            paragraph.add(parseSentence(sentence));
        }

        return paragraph;
    }

    private static CompositeText parseSentence(String source){
        CompositeText sentence = new CompositeText();
        String[] words = source.split(WORD_SPLIT_PATTERN);

        for(String word: words){
            sentence.add(parseWord(word));
        }

        return sentence;
    }

    private static CompositeText parseWord(String source){
        CompositeText word = new CompositeText();

        for(char symbol: source.toCharArray()){
            word.add(new Symbol(symbol));
        }

     return word;
    }
}
