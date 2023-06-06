package org.hua.dit.ast;

import org.hua.dit.errors.SemanticException;
import org.hua.dit.symbol.SymbolTable;

public class LValue extends Expr {
    private Expr expr;
    private String string;
    private LValue lValue;

    public LValue(String lValue) {
        this.string = lValue;
    }

        public LValue(LValue lValue, Expr expr) {
        this.lValue = lValue;
        this.expr = expr;
    }

    @Override
    public String toString() {
        if (expr != null) {
            return "LValue(" + lValue + "[" + expr + "]";
        }
        return "LValue(" + string + ")";
    }

    @Override
    public void sem(SymbolTable tbl) throws SemanticException {
        expr.typeCheck(tbl, expr.getType());
    }
}
