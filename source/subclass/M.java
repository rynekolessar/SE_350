package subclass;
class C {
  public int x = 0;
  public void m() {
    System.out.println("In C::m() x=" + this.x);
    this.p();
  }
  public void p() {
    System.out.println("In C::p() x=" + this.x);
  }
}
class D extends C {
  public int x = 42;
  public void p() {
    System.out.println("In D::p() x=" + this.x);
  }
}
class M {
  public static void main(String[] args) {
    D o = new D();
    System.out.println("o.x=" + o.x);
    o.m();
  }
}
