package basics.mutabledata;
import basics.immutabledata.Pair;
public class Main {
  private Main() {}
  static public void main (final String[] args) {
    final MutPair mp1 = new MutPair();
    mp1.setFirst(new Integer(42));
    mp1.setSecond("dog");
    System.out.println(mp1);
    final Pair p1 = mp1.toPair();
    System.out.println(p1);
    final MutPair mp2 = new MutPair();
    final Pair p2 = mp2.toPair();
  }
}
