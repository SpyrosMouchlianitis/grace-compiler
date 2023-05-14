package org.hua.dit.ast;

import org.hua.dit.errors.SemanticException;
import org.hua.dit.symbol.SymbolTable;
import org.hua.dit.types.BasicType;

public class CharConst extends Expr {
    private Character character;

    public CharConst(Character character) {
        this.character = character;
    }

    public String toString() {
        return "CharConst(" + character + ")";
    }

    @Override
    public void sem(SymbolTable tbl) throws SemanticException {
        type = BasicType.Char;
    }
}
