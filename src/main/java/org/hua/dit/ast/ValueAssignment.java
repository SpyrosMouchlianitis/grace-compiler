package org.hua.dit.ast;

import org.hua.dit.errors.SemanticException;
import org.hua.dit.symbol.SymbolTable;
import org.hua.dit.types.Type;

public class ValueAssignment extends Stmt {
    private LValue lValue;
    private Expr expr;

    public ValueAssignment(LValue lValue, Expr expr) {
        this.lValue = lValue;
        this.expr = expr;
    }

    @Override
    public String toString() {
        return "ValueAssignment(" + lValue + "<-" + expr + ";" + ")";
    }

    @Override
    public void sem(SymbolTable tbl) throws SemanticException {
        lValue.sem(tbl);
        Type lValueType = lValue.type;
        expr.typeCheck(tbl, lValueType);
    }
}
