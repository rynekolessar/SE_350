package subclass.constructor;
class Main {
  public static void main(String[] argv) {
    new X();
    // new X();
  }
}
class O {
  static {
  	System.err.println("<O Static Initializer>");
  }
  {
    System.err.println("<O Initializer>");
  }
  O() {
    System.err.println("<O Constructor>");
  }
}
class X extends O {
  {
    System.err.println("<X Initializer>");
  }
  X() {
    System.err.println("<X Constructor>");
  }
}
  


//output:: (First run)
// <O Static Initializer>
// <O Initializer>
// <O Constructor>
// <X Initializer>
// <X Constructor>
