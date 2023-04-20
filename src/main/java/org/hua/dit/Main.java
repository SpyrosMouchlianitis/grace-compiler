package org.hua.dit;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Reader r = new FileReader("examples/test.grace");
        Lexer l = new Lexer(r);

        try {
            int token = l.yylex();
            while (token != Lexer.YYEOF) {
                System.out.println("Token type: " + token + " lexeme: " + l.yytext());
                token = l.yylex();
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
