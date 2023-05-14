package org.hua.dit.ast;

import org.hua.dit.errors.SemanticException;
import org.hua.dit.symbol.SymbolTable;

public abstract class AST {
    public abstract void sem(SymbolTable tbl) throws SemanticException;
}
