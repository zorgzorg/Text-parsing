package kz.epam.javalab22.parsing.operation;

import kz.epam.javalab22.parsing.entity.CompositeText;
import kz.epam.javalab22.parsing.entity.Symbol;
import kz.epam.javalab22.parsing.entity.Text;

import java.util.List;

/**
 * В тексте после буквы Р, если она не последняя в слове, ошибочно напечатана буква А вместо О.
 * Внести исправления в текст.
 */

public class Corrector {
    private static final String WRONG_SYMBOL = "а";
    private static final String CORRECT_SYMBOL = "о";
    private static final String SEARCHED_SYMBOL = "р";

    public static void correct(CompositeText text){
        Symbol symbolNew = new Symbol(CORRECT_SYMBOL.charAt(0));

        for(Text paragraph: text.getChildComponent()){
            for(Text sentence: ((CompositeText) paragraph).getChildComponent()){
                for(Text word: ((CompositeText) sentence).getChildComponent()){
                    if(word.toString().contains(SEARCHED_SYMBOL+WRONG_SYMBOL) ||
                       word.toString().contains(SEARCHED_SYMBOL.toUpperCase()+WRONG_SYMBOL) ||
                       word.toString().contains((SEARCHED_SYMBOL+WRONG_SYMBOL).toUpperCase()) ||
                       word.toString().contains(SEARCHED_SYMBOL+WRONG_SYMBOL.toUpperCase())
                       ){
                       List<Text> symbols = ((CompositeText) word).getChildComponent();
                         for(int i = 0; i < symbols.size(); i++) {
                            Symbol symbol = (Symbol) symbols.get(i);
                            if(SEARCHED_SYMBOL.equals(symbol.toString()) || SEARCHED_SYMBOL.toUpperCase().equals(symbol.toString())) {
                                if(i < symbols.size()) {
                                    Symbol symbolNext = (Symbol) symbols.get(i + 1);
                                    if(WRONG_SYMBOL.equals(symbolNext.toString()) || WRONG_SYMBOL.toUpperCase().equals(symbolNext.toString())) {
                                        if(WRONG_SYMBOL.toUpperCase().equals(symbolNext.toString())) {
                                            symbolNew = new Symbol(CORRECT_SYMBOL.toUpperCase().charAt(0));
                                        }
                                        symbols.set(i + 1, symbolNew);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

}
