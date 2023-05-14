package org.hua.dit.types;

import java.util.Iterator;
import java.util.List;

public class FuncType extends Type {

    private List<Type> args;
    private Type res;

    public FuncType(List<Type> args, Type res) {
        this.args = args;
        this.res = res;
    }

    public boolean equals(Type t) {
        if (t instanceof FuncType) {
            FuncType that = (FuncType) t;

            // check that each argument type matches
            if (this.args.size() == that.args.size()) {
                Iterator<Type> thisArg = this.args.iterator();
                Iterator<Type> thatArg = that.args.iterator();
                while (thisArg.hasNext() && thatArg.hasNext()) {
                    if (thisArg.next().equals(thatArg.next()))
                        continue;
                    else 
                        return false;
                }
            }
            return this.res.equals(that.res);
        }
        return false;
    }
    
}
