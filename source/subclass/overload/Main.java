package subclass.overload;

class B {
  public void m(String s) { System.out.println("B::m"); }
}
class D extends B { 
  public void m(Object o) { System.out.println("D::m"); }
}

class Main {
  private void Main() {}
  public static void main(String[] args) {
    new B().m("?");
    new D().m("?");
    ((B)new D()).m("?");
    new D().m((Object)"?");
  }
}
