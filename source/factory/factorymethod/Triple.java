package factory.factorymethod;
interface Iterator {
  Object next();
  boolean hasNext();
}
interface Triple {
  Object first();
  Object second();
  Object third();
  Iterator newIterator();
}
class FieldTriple implements Triple {
  private Object _one; Object _two; Object _three;
  public FieldTriple(Object one, Object two, Object three) {
    _one = one; _two = two; _three = three;
  }
  public Object first()  { return _one; }
  public Object second() { return _two; }
  public Object third()  { return _three; }
  public Iterator newIterator() { return new TheIterator(); }

  private class TheIterator implements Iterator {
    private int _i;
    public boolean hasNext() { return _i < 3; }
    public Object next() {
      _i++;
      switch (_i) {
        case 1: return _one;
        case 2: return _two;
        case 3: return _three;
      }
      throw new java.util.NoSuchElementException();
    }
  }
}
class ArrayTriple implements Triple {
  private Object[] _a = new Object[3];
  public ArrayTriple(Object one, Object two, Object three) {
    _a[0] = one; _a[1] = two; _a[2] = three;
  }
  public Object first()  { return _a[0]; }
  public Object second() { return _a[1]; }
  public Object third()  { return _a[2]; }
  public Iterator newIterator() { return new TheIterator(); }
  
  private class TheIterator implements Iterator {
    private int _i = -1;
    public boolean hasNext() { return _i < 2; }
    public Object next() {
      _i++;
      if (_i <= 2)
        return _a[_i];
      else
        throw new java.util.NoSuchElementException();
    }
  }
}
