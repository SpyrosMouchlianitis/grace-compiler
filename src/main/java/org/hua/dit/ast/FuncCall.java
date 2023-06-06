package org.hua.dit.ast;

import org.hua.dit.errors.SemanticException;
import org.hua.dit.symbol.SymbolEntry;
import org.hua.dit.symbol.SymbolTable;

import java.util.List;

public class FuncCall extends Expr {
    private String id;
    private Expr expr;
    private List<Expr> exprList;
    private FuncCall funcCall;

    public FuncCall(FuncCall funcCall) {
        this.funcCall = funcCall;
    }

    public FuncCall(String id) {
        this.id = id;
    }

    public FuncCall(String id, Expr expr, List<Expr> exprList) {
        this.id = id;
        this.expr = expr;
        this.exprList = exprList;
    }

    @Override
    public String toString() {
        if (expr == null) {
            return "FuncCall(" + id + "(" + ")" + ")";
        } else if (expr != null && exprList.isEmpty()) {
            return "FuncCall(" + id + "(" + expr + ")" + ")";
        }
        return "FuncCall(" + id + "(" + expr + exprList + ")";
    }

    @Override
    public void sem(SymbolTable tbl) throws SemanticException {
        SymbolEntry entry = tbl.lookup(id);
        if (entry == null) {
            throw new SemanticException("Variable with name: " + id + " has not been declared");
        }
    }
}
