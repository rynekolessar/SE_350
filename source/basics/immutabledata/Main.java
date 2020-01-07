package basics.immutabledata;
public class Main {
  private Main() {}
  static public void main (final String[] args) {
    System.out.println(new Pair(new Integer(42), "dog"));
  }
}
