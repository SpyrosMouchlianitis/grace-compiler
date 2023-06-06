package org.hua.dit.ast;

import org.hua.dit.errors.SemanticException;
import org.hua.dit.symbol.SymbolTable;

public class Program extends AST {
    private FuncDef funcDef;

    public Program(FuncDef funcDef) {
        this.funcDef = funcDef;
    }

    @Override
    public String toString() {
        return "Program(" + funcDef + ")";
    }

    @Override
    public void sem(SymbolTable tbl) throws SemanticException {
        this.sem(new SymbolTable());
    }
}
