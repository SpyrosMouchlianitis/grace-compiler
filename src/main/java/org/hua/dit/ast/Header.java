package org.hua.dit.ast;

import org.hua.dit.errors.SemanticException;
import org.hua.dit.symbol.SymbolTable;
import org.hua.dit.types.RetType;

import java.util.List;

public class Header extends AST {
    private String id;
    private FparDef fparDef;
    private List<FparDef> fparDefList;
    private RetType retType;

    public Header(String id, FparDef fparDef, List<FparDef> fparDefList, RetType retType) {
        this.id = id;
        this.fparDef = fparDef;
        this.fparDefList = fparDefList;
        this.retType = retType;
    }

    @Override
    public String toString() {
        if (fparDefList.isEmpty()) {
            return "Header(" + "fun" + id + "(" + fparDef + ")" + retType + ")";
        }
        return "Header(" + "fun" + id + "(" + fparDef + ";" + fparDefList + ")" + retType + ")";
    }

    @Override
    public void sem(SymbolTable tbl) throws SemanticException {
        tbl.addEntry(id, retType);
        fparDef.sem(tbl);
        for (FparDef fpd : fparDefList) {
            fpd.sem(tbl);
        }
    }
}
