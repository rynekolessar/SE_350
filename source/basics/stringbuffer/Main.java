package basics.stringbuffer;
public class Main {
  private Main() {}
  static public void main (String[] args) {
    StringBuffer b = new StringBuffer();
    b.append("I am ");
    b.append("a dog");
    String s = b.toString();
    System.out.println(s);
    b.append("matic jerk");
    System.out.println(s);
  }
}
