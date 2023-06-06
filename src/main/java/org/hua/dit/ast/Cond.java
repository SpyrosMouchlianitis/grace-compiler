package org.hua.dit.ast;

import org.hua.dit.errors.SemanticException;
import org.hua.dit.errors.TypeException;
import org.hua.dit.symbol.SymbolTable;
import org.hua.dit.types.Type;

public abstract class Cond extends AST {
    protected Type type;

    public void typeCheck(SymbolTable tbl, Type t) throws SemanticException {
        sem(tbl);
        if (getType().equals(t)) {
            throw new TypeException("Type mismatch: " +
                    "Got: " + getType() + ", " +
                    "Expected: " + t);
        }
    }

    public Type getType() {
        return type;
    }
}
