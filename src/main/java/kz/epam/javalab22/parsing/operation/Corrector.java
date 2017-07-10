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
    public static void correct(CompositeText text){
        Symbol symbolNew = new Symbol('o');

        for(Text paragraph: text.getChildComponent()){
            for(Text sentence: ((CompositeText) paragraph).getChildComponent()){
                for(Text word: ((CompositeText) sentence).getChildComponent()){
                    if(word.toString().contains("ра") || word.toString().contains("Ра") || word.toString().contains("РА") || word.toString().contains("рА")){
                       List<Text> symbols = ((CompositeText) word).getChildComponent();
                         for(int i = 0; i < symbols.size(); i++) {
                            Symbol symbol = (Symbol) symbols.get(i);
                            if("р".equals(symbol.toString()) || "Р".equals(symbol.toString())) {
                                if(i < symbols.size()) {
                                    Symbol symbolNext = (Symbol) symbols.get(i+1);
                                    if("а".equals(symbolNext.toString()) || "А".equals(symbolNext.toString())) {
                                        symbols.remove(i + 1);
                                        if("А".equals(symbolNext.toString())) {
                                            symbolNew = new Symbol('О');
                                        }
                                        symbols.add(i + 1, symbolNew);
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
