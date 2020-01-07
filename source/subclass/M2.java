package subclass;

// Class methods
public class M2 {
  public static void main(String[] argv) {
    (new B2()).m();
  }
}
class A2 {
  void m() {
    System.out.println("A.m");
    this.p(); // static or dynamic binding?
  }
  static void p() {System.out.println("A.p");}
}
class B2 extends A2 {
  static void p() {System.out.println("B.p");}
}
