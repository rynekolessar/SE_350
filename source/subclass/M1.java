package subclass;

// Instance methods
public class M1 {
  public static void main(String[] argv) {
    (new B1()).m();
  }
}
class A1 {
  void m() {
    System.out.println("A.m");
    p(); // static or dynamic binding?
  }
  void p() {System.out.println("A.p");}
}
class B1 extends A1 {
  void p() {System.out.println("B.p");}
}
