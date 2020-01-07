package factory.factorymethod;
public class Main {
  public static void main (String[] args) {
    Triple t1 = new FieldTriple("dog", "cat", "pig");
    Triple t2 = new ArrayTriple("daisy", "rose", "tulip");
    for (Iterator i = t1.newIterator(); i.hasNext(); )
      System.out.println(i.next());
    for (Iterator i = t2.newIterator(); i.hasNext(); )
      System.out.println(i.next());
  }
}
