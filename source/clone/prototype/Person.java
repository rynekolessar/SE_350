package clone.prototype;
public interface Person extends Comparable, Cloneable {
  public Object clone();
  public String name();
  public SSN ssn();
}
