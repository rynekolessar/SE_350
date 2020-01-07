package subclass;
public class M9 {
  public static void main(String[] argv) {
    O o = new X();
    I i = o.getI();
    i.f();
  }
}
interface I { public void f(); }
class O {
  I getI() { return new I() {
      public void f() {
        O.this.p(); // static or dynamic binding?
      }};
  }
  void p() { System.out.println("O.p"); }
}
class X extends O {
  void p() {System.out.println("OO.p");}
}
