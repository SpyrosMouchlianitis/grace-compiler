package org.hua.dit.ast;

import org.hua.dit.errors.SemanticException;
import org.hua.dit.symbol.SymbolTable;
import org.hua.dit.types.Type;

import java.util.Collections;
import java.util.List;

public class VarDef extends AST {
    private String id;
    private List<CommaId> commaIdList;
    private Type type;

    public VarDef(String id, List<CommaId> commaIdList, Type type) {
        this.id = id;
        this.commaIdList = commaIdList;
        this.type = type;
    }

    @Override
    public String toString() {
        return "VarDef(" + "var" + id + commaIdList + ":" + type + ";)";
    }

    @Override
    public void sem(SymbolTable tbl) throws SemanticException {
        tbl.addEntry(id, type);
    }
}
