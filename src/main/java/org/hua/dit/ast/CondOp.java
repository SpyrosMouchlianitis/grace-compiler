package org.hua.dit.ast;

import org.hua.dit.errors.SemanticException;
import org.hua.dit.symbol.SymbolTable;
import org.hua.dit.types.BasicType;

public class CondOp extends Cond {
    public enum Operator {
        NOT,
        AND,
        OR,
        EQUALS,
        HASHTAG,
        LESS,
        GREATER,
        LESS_EQUAL,
        GREATER_EQUAL
    }

    public Operator operator;
    public Expr lexpr, rexpr;
    public Cond cond, lcond, rcond;

    public CondOp(Operator operator, Expr lexpr, Expr rexpr) {
        this.operator = operator;
        this.lexpr = lexpr;
        this.rexpr = rexpr;
    }

    public CondOp(Operator operator, Cond lcond, Cond rcond) {
        this.operator = operator;
        this.lcond = lcond;
        this.rcond = rcond;
    }

    public CondOp(Operator operator, Cond cond) {
        this.operator = operator;
        this.cond = cond;
    }

    public String toString() {
        if (lexpr != null && rexpr != null) {
            return "CondOp(" + lexpr + operator + rexpr + ")";
        } else if (lcond != null && rcond != null) {
            return "CondOp(" + lcond + operator + rcond + ")";
        } else {
            return "CondOp(" + operator + cond + ")";
        }
    }

    @Override
    public void sem(SymbolTable tbl) throws SemanticException {
        if (lexpr != null && rexpr != null) {
            if (lexpr.getType().equals(BasicType.Int) && rexpr.getType().equals(BasicType.Int)) {
                lexpr.typeCheck(tbl, BasicType.Int);
                rexpr.typeCheck(tbl, BasicType.Int);
                type = BasicType.Int;
            } else if (lexpr.getType().equals(BasicType.Char) && rexpr.getType().equals(BasicType.Char)) {
                lexpr.typeCheck(tbl, BasicType.Char);
                rexpr.typeCheck(tbl, BasicType.Char);
                type = BasicType.Char;
            }
        } else if (lcond != null && rcond != null) {
            lcond.typeCheck(tbl, BasicType.Bool);
            rcond.typeCheck(tbl, BasicType.Bool);
            type = BasicType.Bool;
        } else {
            cond.typeCheck(tbl, BasicType.Bool);
            type = BasicType.Bool;
        }
    }
}
