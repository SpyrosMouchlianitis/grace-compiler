package org.hua.dit.ast;

import org.hua.dit.errors.SemanticException;
import org.hua.dit.symbol.SymbolTable;
import org.hua.dit.types.BasicType;

public class NumConst extends Expr {
    private Integer number;
    public NumConst(Integer number) {
        this.number = number;
    }

    public String toString() {
        return "NumConst(" + number.toString() + ")";
    }

    @Override
    public void sem(SymbolTable tbl) throws SemanticException {
        type = BasicType.Int;
    }
}
