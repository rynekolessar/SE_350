package subclass;

// Instance Fields
public class M6 {
  public static void main(String[] argv) {
    (new B6()).p();
  }
}
class A6 {
  void m() {
    System.out.println("A.m: " + _x); // which _x?
  }
  final int _x = 42;
}
class B6 extends A6 {
  void p() {
    this.m();
    System.out.println("B.p: " + _x); // which _x?
  }
  final int _x = 27;
}
