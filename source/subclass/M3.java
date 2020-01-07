package subclass;

// Super
public class M3 {
  public static void main(String[] argv) {
    (new C3()).p();
  }
}
class A3 {
  void p() {System.out.println("A.p");}
  void f() {System.out.println("A.f");}
}
class B3 extends A3 {
  void p() {
    super.f(); // static or dynamic binding?
    this.f();  // static or dynamic binding?
    System.out.println("B.p");
  }

  void f() {
    System.out.println("B.f");
  }
}
class C3 extends B3 {
  void f() {System.out.println("C.f");}
}
