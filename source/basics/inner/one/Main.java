package basics.inner.one;
public class Main {
  private Main() {}
  static public void main (final String[] args) {
    C mc = new C(42);
    mc.f();
  }
}

interface Print { void print(); }

class C {
  int cx;
  C(int x) { cx = x; }
  class P implements Print {
    int py = 27;
    public void print() {
      System.out.println(" cx=" + Integer.toString(cx) +
                         " py=" + Integer.toString(py));
    }
  }
  void f() {
    Print p = new P();
    p.print();
  }
}

    
