package org.hua.dit.ast;

import org.hua.dit.errors.SemanticException;
import org.hua.dit.symbol.SymbolTable;

import java.util.List;
import java.util.StringJoiner;

public class FuncDef extends AST {
    private Header header;
    private List<LocalDef> localDefList;
    private Block block;

    public FuncDef(Header header, List<LocalDef> localDefList, Block block) {
        this.header = header;
        this.localDefList = localDefList;
        this.block = block;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        StringJoiner sj = new StringJoiner(",", "FuncDef(", ")");
        sj.add(header.toString());
        for (LocalDef localDef : localDefList) {
            sj.add(localDef.toString());
        }
        sj.add(block.toString());
        return sj.toString();
    }

    @Override
    public void sem(SymbolTable tbl) throws SemanticException {
        header.sem(tbl);
        for (LocalDef localDef : localDefList) {
            localDef.sem(tbl);
        }
        block.sem(tbl);
    }
}
