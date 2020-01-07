package singleton.two;
public class SObject {
  private SObject() {}
  private static S _instance;
  public static S get() {
    if (_instance == null) {
      if ("linux".equals(System.getProperty("os.name"))) {
        _instance = new SLinux();
      } else {
        _instance = new SOther();
      }
    }
    return _instance;
  }
}
final class SLinux implements S { 
  private int i;
  public int inc() {return ++i;}
}
final class SOther implements S {
  private int i;
  public int inc() {return --i;}
}
