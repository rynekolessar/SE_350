package singleton.two.main;          
import singleton.two.S;
import singleton.two.SObject;
public class Main {
  public static void main (String[] args) {
    System.out.println(SObject.get().inc());
    System.out.println(SObject.get().inc());
  }
}
