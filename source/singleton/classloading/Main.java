package singleton.classloading;

/**
 * An example from <a href="http://www.magpiebrain.com/archives/2003/09/04/of_singletons_and_static_classes"/>
 */
class A {
  private static A instance;
  public static int numInstances;
  public static A getInstance() {
    return (instance == null) ? (instance = new A()) : instance;
  }
  
  private A() {
    A.numInstances++;
    B.doNothing();  // B is loaded here, during A's constructor
  }
}

class B {
  // B caches the only instance of A
  public static A a = A.getInstance();
  public static void doNothing() {}
}

class Main {
  public static void main(String[] args) {
    System.out.println(A.getInstance() == B.a);
    System.out.println(A.numInstances);
  }
}
