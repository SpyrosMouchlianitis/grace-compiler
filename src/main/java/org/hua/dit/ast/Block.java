package org.hua.dit.ast;

import org.hua.dit.errors.SemanticException;
import org.hua.dit.symbol.SymbolTable;

import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;

public class Block extends Stmt {
    private List<Stmt> stmtList;
    private Block block;

    public Block(List<Stmt> stmtList) {
        this.stmtList = stmtList;
    }
    public Block(Block block) {
        this.block = block;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        StringJoiner sj = new StringJoiner(",", "Block({", "})");
        for (Stmt stmt : stmtList) {
            sj.add(stmt.toString());
        }
        return sj.toString();
    }

    @Override
    public void sem(SymbolTable tbl) throws SemanticException {
        tbl.openScope();
        for (Stmt stmt : stmtList) {
            stmt.sem(tbl);
        }
        tbl.closeScope();
    }
}
