package org.hua.dit;

import java.io.*;
import java_cup.runtime.Symbol;

%%

%class Lexer
%unicode
%integer
%line
%column
%cup

%eofval{
    return createSymbol(Symbols.EOF);
%eofval}

%{
    private StringBuffer sb = new StringBuffer();

    private Symbol createSymbol(int type) {
        return new Symbol(type, yyline+1, yycolumn+1);
    }

    private Symbol createSymbol(int type, Object value) {
        return new Symbol(type, yyline+1, yycolumn+1, value);
    }
%}

delim =      [\t\n\r\0\xnm]
ws    =      {delim}+
l     =      [A-Za-z_]
d     =      [0-9]
%%

"and"                   { return createSymbol(Symbols.T_and); }
"char"                  { return createSymbol(Symbols.T_char); }
"div"                   { return createSymbol(Symbols.T_div); }
"do"                    { return createSymbol(Symbols.T_do); }
"else"                  { return createSymbol(Symbols.T_else); }
"fun"                   { return createSymbol(Symbols.T_fun); }
"if"                    { return createSymbol(Symbols.T_if); }
"int"                   { return createSymbol(Symbols.T_int); }
"mod"                   { return createSymbol(Symbols.T_mod); }
"not"                   { return createSymbol(Symbols.T_not); }
"nothing"               { return createSymbol(Symbols.T_nothing); }
"or"                    { return createSymbol(Symbols.T_or); }
"ref"                   { return createSymbol(Symbols.T_ref); }
"return"                { return createSymbol(Symbols.T_return); }
"then"                  { return createSymbol(Symbols.T_then); }
"var"                   { return createSymbol(Symbols.T_var); }
"while"                 { return createSymbol(Symbols.T_while); }

{l}({l}|{d})*           { return createSymbol(Symbols.T_id); }
{d}+                    { return createSymbol(Symbols.T_num); }

"+"                     { return createSymbol(Symbols.T_plus); }
"-"                     { return createSymbol(Symbols.T_minus); }
"*"                     { return createSymbol(Symbols.T_times); }
"/"                     { return createSymbol(Symbols.T_divide); }
"#"                     { return createSymbol(Symbols.T_hashtag); }
"="                     { return createSymbol(Symbols.T_equals); }
"<>"                    { return createSymbol(Symbols.T_different); }
"<"                     { return createSymbol(Symbols.T_less); }
">"                     { return createSymbol(Symbols.T_greater); }
"<="                    { return createSymbol(Symbols.T_lessequal); }
">="                    { return createSymbol(Symbols.T_moreequal); }

"("                     { return createSymbol(Symbols.T_lpar); }
")"                     { return createSymbol(Symbols.T_rpar); }
"["                     { return createSymbol(Symbols.T_lbracket); }
"]"                     { return createSymbol(Symbols.T_rbracket); }
"{"                     { return createSymbol(Symbols.T_lcurlybracket); }
"}"                     { return createSymbol(Symbols.T_rcurlybracket); }
","                     { return createSymbol(Symbols.T_comma); }
";"                     { return createSymbol(Symbols.T_semicolon); }
":"                     { return createSymbol(Symbols.T_colon); }
"<-"                    { return createSymbol(Symbols.T_larrow); }

" "                     {}
"\""                    { return createSymbol(Symbols.T_escapedchar); }
"\'"                    { return createSymbol(Symbols.T_escapedchar); }
"\\\\"                  { return createSymbol(Symbols.T_escapedchar); }

{ws}                    {}

\\\$\\\$([\s\S]*?)\\\$\\\$      {}
\\\$.*                  {}


\"(\\.|[^\"])*\"        { return createSymbol(Symbols.T_string); }

\'([^\'\\\\]|\\\\.)*\'  { return createSymbol(Symbols.T_string); }