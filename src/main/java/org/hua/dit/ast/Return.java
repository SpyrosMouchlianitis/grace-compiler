package org.hua.dit.ast;

import org.hua.dit.errors.SemanticException;
import org.hua.dit.errors.TypeException;
import org.hua.dit.symbol.SymbolEntry;
import org.hua.dit.symbol.SymbolTable;
import org.hua.dit.types.BasicType;

public class Return extends Stmt {
    private Expr expr;

    public Return() {

    }

    public Return(Expr expr) {
        this.expr = expr;
    }

    public String toString() {
        if (expr != null) {
            return "Return(" + "return" + expr + ";)";
        }
        return "Return(" + "return;" + ")";
    }

    @Override
    public void sem(SymbolTable tbl) throws SemanticException {
        SymbolEntry entry = tbl.lookup(expr.toString());
        if (entry == null) {
            throw new TypeException("Variable '" + expr + "' not declared");
        }
    }
}
