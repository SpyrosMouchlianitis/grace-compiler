package org.hua.dit.ast;

import org.hua.dit.errors.SemanticException;
import org.hua.dit.symbol.SymbolTable;
import org.hua.dit.types.BasicType;

public class BinOp extends Expr {
    public enum Operator {
        PLUS,
        MINUS,
        TIMES,
        DIV,
        MOD
    }

    public Operator operator;
    public Expr l, r;

    public BinOp(Operator operator, Expr l, Expr r) {
        this.operator = operator;
        this.l = l;
        this.r = r;
    }

    public String toString() {
        return "BinOp(" + l + operator + r + ")";
    }

    public void sem(SymbolTable symbolTable) throws SemanticException {
        l.typeCheck(symbolTable, BasicType.Int);
        r.typeCheck(symbolTable, BasicType.Int);
        type = BasicType.Int;
    }
}
