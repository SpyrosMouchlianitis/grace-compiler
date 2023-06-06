package org.hua.dit.ast;

import org.hua.dit.errors.SemanticException;
import org.hua.dit.symbol.SymbolTable;
import org.hua.dit.types.Type;

public class FparDef extends AST {
    private String id;
    private Type type;

    private FparDef fparDef;

    public FparDef(String id, Type type) {
        this.id = id;
        this.type = type;
    }

    public FparDef(String id, FparDef fparDef) {
        this.id = id;
        this.fparDef = fparDef;
    }

    public FparDef(FparDef fparDef) {
        this.fparDef = fparDef;
    }

    @Override
    public String toString() {
        if (id != null && type != null) {
            return "FparDef(" + id + ":" + type + ")";
        } else if (id != null && type == null) {
            return "FparDef(" + id + "," + fparDef + ")";
        }
        return "FparDef(" + "ref" + fparDef + ")";
    }

    @Override
    public void sem(SymbolTable tbl) throws SemanticException {
        tbl.openScope();
        tbl.addEntry(id, type);
    }
}
