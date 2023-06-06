package org.hua.dit.ast;

import org.hua.dit.errors.SemanticException;
import org.hua.dit.symbol.SymbolTable;

public class LocalDef extends AST {
    private VarDef varDef;
    private FuncDecl funcDecl;
    private FuncDef funcDef;

    public LocalDef(FuncDef funcDef) {
        this.funcDef = funcDef;
    }

    public LocalDef(FuncDecl funcDecl) {
        this.funcDecl = funcDecl;
    }
    public LocalDef(VarDef varDef) {
        this.varDef = varDef;
    }

    @Override
    public String toString() {
        if (funcDecl != null) {
            return funcDecl.toString();
        } else if (funcDef != null) {
            return funcDef.toString();
        }
        return varDef.toString();
    }

    @Override
    public void sem(SymbolTable tbl) throws SemanticException {
        tbl.openScope();
        if (varDef != null) {
            varDef.sem(tbl);
        } else if (funcDecl != null) {
            funcDecl.sem(tbl);
        } else {
            funcDef.sem(tbl);
        }
        tbl.closeScope();
    }
}
