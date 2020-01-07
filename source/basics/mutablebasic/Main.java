package basics.mutablebasic;
import basics.immutabledata.Pair;
public class Main {
  private Main() {}
  static public void main (final String[] args) {
    final PairBuilder pb1 = new PairBuilder();
    pb1.setFirst(new Integer(42));
    pb1.setSecond("dog");
    System.out.println(pb1);
    final Pair p1 = pb1.toPair();
    System.out.println(p1);
    final PairBuilder pb2 = new PairBuilder();
    final Pair p2 = pb2.toPair();
  }
}
final class PairBuilder {
  private Comparable _x;
  private Comparable _y;
  public PairBuilder() { }
  public void setFirst(Comparable x) { _x = x; }
  public void setSecond(Comparable y) { _y = y; }
  public Pair toPair() {
    if (_x == null || _y == null)
      throw new NullPointerException();
    return new Pair(_x,_y);
  }
}    
