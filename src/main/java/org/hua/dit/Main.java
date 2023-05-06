package org.hua.dit;

import java_cup.runtime.Symbol;

import java.io.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Reader r = new FileReader(args[0]);
        Lexer l = new Lexer(r);
        Parser p = new Parser(l);

        try {
            Object result = p.parse().value;
            System.out.println("Success!");
        } catch(Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
