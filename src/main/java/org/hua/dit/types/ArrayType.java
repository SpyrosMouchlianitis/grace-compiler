package org.hua.dit.types;

public class ArrayType extends Type {

  private Type baseType;
  int number_of_dimensions;

  static public ArrayType IntArray = new ArrayType(BasicType.Int);
  static public ArrayType CharArray = new ArrayType(BasicType.Char);

  private BasicType basicType;

  // Constructor for ArrayType with enum only
  public ArrayType(BasicType basicType) {
    this.basicType = basicType;
  }

  // Constructor for ArrayType with enum and number of dimensions
  public ArrayType(BasicType basicType, int number_of_dimensions) {
    this.basicType = basicType;
    this.number_of_dimensions = number_of_dimensions;
  }

  public String toString() {
    return basicType.toString();
  }

  public boolean equals(Type t) {
    if (t instanceof ArrayType) {
      ArrayType that = (ArrayType) t;
      return this.basicType == that.basicType;
    }
    return false;
  }
}
