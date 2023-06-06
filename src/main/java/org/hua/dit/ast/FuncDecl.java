package org.hua.dit.ast;

import org.hua.dit.errors.SemanticException;
import org.hua.dit.symbol.SymbolTable;

public class FuncDecl extends AST {
    private Header header;

    public FuncDecl(Header header) {
        this.header = header;
    }

    @Override
    public String toString() {
        return "FuncDecl(" + header + ";" + ")";
    }

    @Override
    public void sem(SymbolTable tbl) throws SemanticException {
        header.sem(tbl);
    }
}
