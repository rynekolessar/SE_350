package subclass;

// Class Fields
public class M5 {
  public static void main(String[] argv) {
    (new B5()).p();
  }
}
class A5 {
  static void m() {
    System.out.println("A.m: " + _x); // which _x?
  }
  static final int _x = 42;
}
class B5 extends A5 {
  void p() {
    this.m();
    System.out.println("B.p: " + _x); // which _x?
  }
  static final int _x = 27;
}
