package org.hua.dit.ast;

import org.hua.dit.errors.SemanticException;
import org.hua.dit.symbol.SymbolTable;

import java.util.List;

public class StringLiteral extends Expr {
    private String string;

    public StringLiteral(String string) {
        this.string = string;
    }

    public String toString() {
        return "StringLiteral(" + string.toString() + ")";
    }

    @Override
    public void sem(SymbolTable tbl) throws SemanticException {

    }
}
