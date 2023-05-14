package org.hua.dit.ast;

import org.hua.dit.errors.SemanticException;
import org.hua.dit.errors.TypeException;
import org.hua.dit.symbol.SymbolEntry;
import org.hua.dit.symbol.SymbolTable;

public class Id extends Expr {
    private String name;

    public Id(String name) {
        this.name = name;
    }

    public String toString() {
        return "Id(" + name + ")";
    }

    public void sem(SymbolTable symbolTable) throws SemanticException {
        SymbolEntry entry = symbolTable.lookup(name);
        if (entry != null) {
            type = entry.getType();
        } else {
            throw new TypeException("Variable '" + name + "' not declared");
        }
    }
}
