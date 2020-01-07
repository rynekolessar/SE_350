package subclass;

// Constructors
public class M7 {
  public static void main(String[] argv) {
    new B7(1);
    new C7();
  }
}
class A7 {
  A7(int i) {System.out.println("A(int)");}
}
class B7 extends A7 {
  B7(int i) {
    super(i);
    System.out.println("B(int)");
  }
}
class C7 extends B7 {
  // The following will not compile!
//  C7() {System.out.println("C");}
  C7() {
    super(0);
    System.out.println("C");
  }
}
