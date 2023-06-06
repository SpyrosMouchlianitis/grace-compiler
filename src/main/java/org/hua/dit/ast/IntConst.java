package org.hua.dit.ast;

import org.hua.dit.errors.SemanticException;
import org.hua.dit.symbol.SymbolEntry;
import org.hua.dit.symbol.SymbolTable;
import org.hua.dit.types.BasicType;

public class IntConst extends Expr {
    private Integer number;
    private String id;
    public IntConst(Integer number) {
        this.number = number;
    }
    public IntConst(String id) {
        this.id = id;
    }

    public String toString() {
        return "IntConst(" + number.toString() + ")";
    }

    @Override
    public void sem(SymbolTable tbl) throws SemanticException {
        SymbolEntry entry = tbl.lookup(id);
        if (entry == null) {
            throw new SemanticException("Variable " + id + " has not been declared");
        }
        type = entry.getType();
    }
}
