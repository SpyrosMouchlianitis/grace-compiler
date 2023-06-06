package org.hua.dit.types;

import org.hua.dit.types.Type;

public class RetType extends Type {
    private BasicType basicType;

    public RetType(BasicType basicType) {
        this.basicType = basicType;
    }

    public RetType() {}

    @Override
    public String toString() {
        if (basicType != null) {
            return "RetType(" + ":" + basicType + ")";
        }
        return "RetType(" + ":" + "nothing" + ")";
    }
}
