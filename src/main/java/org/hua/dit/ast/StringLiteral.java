package org.hua.dit.ast;

import org.hua.dit.errors.SemanticException;
import org.hua.dit.symbol.SymbolTable;
import org.hua.dit.types.BasicType;

public class StringLiteral extends Expr {
    private String string;

    public StringLiteral(String string) {
        this.string = string;
    }

    public String toString() {
        return "StringLiteral(" + string + ")";
    }

    @Override
    public void sem(SymbolTable tbl) throws SemanticException {
        type = BasicType.String;
    }
}
