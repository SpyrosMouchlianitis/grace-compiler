package org.hua.dit.symbol;

import org.hua.dit.types.Type;

public class SymbolEntry {
    private String s;
    private Type t;

    public SymbolEntry(String s, Type t) {
      this.s = s;
      this.t = t;
    }

    public Type getType() { return t; }
}
