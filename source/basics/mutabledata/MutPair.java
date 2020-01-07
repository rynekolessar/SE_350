package basics.mutabledata;
import basics.immutabledata.Pair;
final class MutPair implements Comparable {
  private Comparable _x;
  private Comparable _y;
  public MutPair() { }
  public MutPair(Comparable x, Comparable y) { _x = x; _y = y; }
  public void setFirst(Comparable x) { _x = x; }
  public void setSecond(Comparable y) { _y = y; }
  public Object first() { return _x; }
  public Object second() { return _y; }
  public String toString() { return "MutPair(" + _x + "," + _y + ")"; }
  public Pair toPair() {
    if (_x == null || _y == null)
      throw new NullPointerException();
    return new Pair(_x,_y);
  }
  public boolean equals(Object thatObject) {
    if (this == thatObject)
      return true;
    if (!(this.getClass().equals(thatObject.getClass())))
      return false;
    MutPair that = (MutPair) thatObject;
    return (_x == null ? that._x == null : _x.equals(that._x))
        && (_y == null ? that._y == null : _y.equals(that._y));
  }
  public int hashCode() {
    // can only hash safely on immutable fields
    return 0;
  }
  public int compareTo(Object thatObject) {
    MutPair that = (MutPair) thatObject;
    int ix = (_x == null ? (that._x == null ? 0 : -1)
                         : _x.compareTo(that._x));
    if (ix != 0)
      return ix;
    return (_y == null ? (that._y == null ? 0 : -1)
                         : _y.compareTo(that._y));
  }
  // // this should work, but Cloneable is VERY broken
  // public Object clone() {
  //   MutPair result = (MutPair) super.clone();
  //   if (_x != null && _x instanceof Cloneable)
  //     result._x = ((Cloneable)_x).clone();
  //   if (_y != null && _y instanceof Cloneable)
  //     result._y = ((Cloneable)_y).clone();
  // }
}    
