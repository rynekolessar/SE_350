package subclass;

// Constructors
public class M8 {
  public static void main(String[] argv) {
    new B8();
    new C8();
  }
}
class A8 {
  A8()      {System.out.println("A()");}
}
class B8 extends A8 {
  B8() {
    this(1);
    System.out.println("B()");
  }
  B8(int x) {System.out.println("B(int)");}
}
class C8 extends B8 {
  C8()      {System.out.println("C()");}
}
