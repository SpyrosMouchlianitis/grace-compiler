package org.hua.dit.ast;

import org.hua.dit.errors.SemanticException;
import org.hua.dit.symbol.SymbolTable;
import org.hua.dit.types.BasicType;

public class If extends Stmt {
    private Cond cond;
    private Stmt then_stmt;
    private Stmt else_stmt;

    public If(Cond cond, Stmt then_stmt) {
        this.cond = cond;
        this.then_stmt = then_stmt;
    }

    public If(Cond cond, Stmt then_stmt, Stmt else_stmt) {
        this.cond = cond;
        this.then_stmt = then_stmt;
        this.else_stmt = else_stmt;
    }

    public String toString() {
        if (else_stmt != null) {
            return "If(" + cond + "then" + then_stmt + "else" + else_stmt + ")";
        } else {
            return "If(" + cond + "then" + then_stmt + ")";
        }
    }

    @Override
    public void sem(SymbolTable tbl) throws SemanticException {
        cond.typeCheck(tbl, BasicType.Bool);
        then_stmt.sem(tbl);
        if (else_stmt != null) {
            else_stmt.sem(tbl);
        }
    }
}
