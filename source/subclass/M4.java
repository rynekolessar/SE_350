package subclass;

// Private methods
public class M4 {
  public static void main(String[] argv) {
    (new B4()).m();
  }
}
class A4 {
  void m() {
    System.out.println("A.m");
    this.p(); // static or dynamic binding?
  }
  private void p() {System.out.println("A.p");}
}
class B4 extends A4 {
  private void p() {System.out.println("B.p");}
}
