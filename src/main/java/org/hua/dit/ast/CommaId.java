package org.hua.dit.ast;

import org.hua.dit.errors.SemanticException;
import org.hua.dit.symbol.SymbolEntry;
import org.hua.dit.symbol.SymbolTable;

public class CommaId extends AST {
    private String id;

    public CommaId(String id) {
        this.id = id;
    }

    public String toString() {
        return "CommaId(" + "," + id + ")";
    }

    @Override
    public void sem(SymbolTable tbl) throws SemanticException {
        SymbolEntry e = tbl.lookup(id);
        if (e != null) {
            throw new SemanticException("Variable with name: " + id + " already exists");
        }
    }
}
