package org.hua.dit.ast;

import org.hua.dit.errors.SemanticException;
import org.hua.dit.symbol.SymbolTable;
import org.hua.dit.types.BasicType;

public class While extends Stmt {
    private Cond cond;
    private Stmt stmt;

    public While(Cond cond, Stmt stmt) {
        this.cond = cond;
        this.stmt = stmt;
    }

    public String toString() {
        return "While(" + cond + "do" + stmt + ")";
    }

    @Override
    public void sem(SymbolTable tbl) throws SemanticException {
        cond.typeCheck(tbl, BasicType.Bool);
        stmt.sem(tbl);
    }
}
