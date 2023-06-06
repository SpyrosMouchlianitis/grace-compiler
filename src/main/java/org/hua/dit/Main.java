package org.hua.dit;

import java_cup.runtime.Symbol;

import java.io.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Reader r = new FileReader(args[0]);
        Lexer l = new Lexer(r);

        try {
            Symbol token = l.next_token();
            while (token.sym != Symbols.EOF) {
                System.out.println("Token type: " + token + " lexeme: " + l.yytext());
                token = l.next_token();
            }

            l.yyclose();
            r.close();
            r = new FileReader(args[0]);
            l = new Lexer(r);
            Parser p = new Parser(l);

            Object result = p.debug_parse().value;
            System.out.println("Success!");
        } catch(Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
