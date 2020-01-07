package singleton.one.main;
import singleton.one.S;
public class Main {
  public static void main (String[] args) {
    System.out.println(S.instance.inc());
    System.out.println(S.instance.inc());
  }
}
