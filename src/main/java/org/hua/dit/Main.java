package org.hua.dit;

import java_cup.runtime.Symbol;

import java.io.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Reader r = new FileReader("examples/test.grace");
        Lexer l = new Lexer(r);

        try {
            Symbol token = l.next_token();
            while (token.sym != Symbols.EOF) {
                System.out.println("Token type: " + token + " lexeme: " + l.yytext());
                token = l.next_token();
            }

            l.yyclose();
            r.close();
            r = new FileReader("examples/test.grace");
            l = new Lexer(r);
            Parser p = new Parser(l);

            Object result = p.debug_parse().value; // todo change to p.parse().value;
            System.out.println("Success!");
        } catch(Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
