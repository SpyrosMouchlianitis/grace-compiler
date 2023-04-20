package org.hua.dit;

%%

%class Lexer
%unicode
%integer
%line
%column
%{

public static class Token {
        public static final int T_and           = 1;
        public static final int T_char          = 2;
        public static final int T_div           = 3;
        public static final int T_do            = 4;
        public static final int T_else          = 5;
        public static final int T_fun           = 6;
        public static final int T_if            = 7;
        public static final int T_int           = 8;
        public static final int T_mod           = 9;
        public static final int T_not           = 10;
        public static final int T_nothing       = 11;
        public static final int T_or            = 12;
        public static final int T_ref           = 13;
        public static final int T_return        = 14;
        public static final int T_then          = 15;
        public static final int T_var           = 16;
        public static final int T_while         = 17;
        public static final int T_id            = 18;
        public static final int T_plus          = 19;
        public static final int T_minus         = 20;
        public static final int T_times         = 21;
        public static final int T_divide        = 22;
        public static final int T_hashtag       = 23;
        public static final int T_equals        = 24;
        public static final int T_different     = 25;
        public static final int T_less          = 26;
        public static final int T_greater       = 27;
        public static final int T_lessequal     = 28;
        public static final int T_moreequal     = 29;
        public static final int T_num           = 30;
        public static final int T_lpar          = 31;
        public static final int T_rpar          = 32;
        public static final int T_lbracket      = 33;
        public static final int T_rbracket      = 34;
        public static final int T_lcurlybracket = 35;
        public static final int T_rcurlybracket = 36;
        public static final int T_comma         = 37;
        public static final int T_semicolon     = 38;
        public static final int T_colon         = 39;
        public static final int T_larrow        = 40;
        public static final int T_escapedchar   = 41;
        public static final int T_string        = 42;
        public static final int T_comment       = 43;
        public static final int T_multilinecomment       = 44;
};


%}

delim =      [\t\n\r\0\xnm]
ws    =      {delim}+
l     =      [A-Za-z_]
d     =      [0-9]
%%

"and" { return Token.T_and; }
"char" { return Token.T_char; }
"div" { return Token.T_div; }
"do" { return Token.T_do; }
"else" { return Token.T_else; }
"fun" { return Token.T_fun; }
"if" { return Token.T_if; }
"int" { return Token.T_int; }
"mod" { return Token.T_mod; }
"not" { return Token.T_not; }
"nothing" { return Token.T_nothing; }
"or" { return Token.T_or; }
"ref" { return Token.T_ref; }
"return" { return Token.T_return; }
"then" { return Token.T_then; }
"var" { return Token.T_var; }
"while" { return Token.T_while; }

{l}+            { return Token.T_id; }
{d}+            { return Token.T_num; }

"+"             { return Token.T_plus; }
"-"             { return Token.T_minus; }
"*"             { return Token.T_times; }
"/"             { return Token.T_divide; }
"#"             { return Token.T_hashtag; }
"="             { return Token.T_equals; }
"<>"            { return Token.T_different; }
"<"             { return Token.T_less; }
">"             { return Token.T_greater; }
"<="            { return Token.T_lessequal; }
">="            { return Token.T_moreequal; }

"("                     { return Token.T_lpar; }
")"                     { return Token.T_rpar; }
"["                     { return Token.T_lbracket; }
"]"                     { return Token.T_rbracket; }
"{"                     { return Token.T_lcurlybracket; }
"}"                     { return Token.T_rcurlybracket; }
","                     { return Token.T_comma; }
";"                     { return Token.T_semicolon; }
":"                     { return Token.T_colon; }
"<-"                    { return Token.T_larrow; }

" "                     {}
"\""                    { return Token.T_escapedchar; }
"\'"                    { return Token.T_escapedchar; }
"\\\\"                  { return Token.T_escapedchar; }

{ws}                    {}

/*
\\\$\\\$.*\\\$\\$       { return Token.T_multilinecomment; } /* TODO multiline comments */
\\\$.*                  { return Token.T_comment; }
*/

\"([^\"\\\\]|\\\\.)*\"  {return Token.T_string;}
\'([^\'\\\\]|\\\\.)*\'  { return Token.T_string; }