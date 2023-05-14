package org.hua.dit.ast;

import org.hua.dit.errors.SemanticException;
import org.hua.dit.errors.TypeException;
import org.hua.dit.symbol.SymbolTable;
import org.hua.dit.types.Type;

public abstract class Expr extends AST {

  protected Type type;

  // check if expression is well-typed
  public void typeCheck(SymbolTable tbl, Type t) throws SemanticException {
    // analysis will populate the inferred type of Expr
    sem(tbl);
    if (getType().equals(t)) {
      throw new TypeException("Type mismatch: " +
                              "Got: " + getType() + ", " +
                              "Expected: " + t);
    }
  }

  public Type getType() { return type; }
}
