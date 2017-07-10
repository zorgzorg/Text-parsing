package kz.epam.javalab22.parsing.entity;

public class Symbol implements Text{
    char symbol;

    public Symbol(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return ""+symbol;
    }
}
