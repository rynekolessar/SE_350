package basics.collection;
import java.util.List;
import java.util.ArrayList;
import java.util.EmptyStackException;
final public class IntegerStack {
  final private List _l;
  public IntegerStack() { _l = new ArrayList(); }
  public boolean isEmpty() { return _l.isEmpty(); }
  public void push(Integer x) {
    if (x == null)
      throw new IllegalArgumentException();
    _l.add(x);
  }
  public Integer pop() {
    if (_l.isEmpty())
      throw new EmptyStackException();
    return (Integer) (_l.remove(_l.size()-1));
  }
}
