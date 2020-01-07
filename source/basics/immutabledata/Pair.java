package basics.immutabledata;
final public class Pair implements Comparable {
  final private Comparable _x;
  final private Comparable _y;
  public Pair(Comparable x, Comparable y) {
    if (x == null || y == null)
      throw new IllegalArgumentException();
    _x = x;
    _y = y;
  }
  public Object first() { return _x; }
  public Object second() { return _y; }
  public String toString() { return "Pair(" + _x + "," + _y + ")"; }
  public boolean equals(Object thatObject) {
    if (this == thatObject)
      return true;
    // equals should not throw ClassCastException
    if (!(this.getClass().equals(thatObject.getClass())))
      return false;
    Pair that = (Pair) thatObject;
    return _x.equals(that._x)
        && _y.equals(that._y);
  }
  private int hcode;
  public int hashCode() {
    if (hcode == 0) {
      hcode = 17;
      hcode = 37*hcode + _x.hashCode();
      hcode = 37*hcode + _y.hashCode();
    }
    return hcode;
  }
  public int compareTo(Object thatObject) {
    // compareTo may throw ClassCastException
    Pair that = (Pair) thatObject;
    int ix = _x.compareTo(that._x);
    if (ix != 0)
      return ix;
    return _y.compareTo(that._y);
  }
}
