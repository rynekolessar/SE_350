package observableByDelegation;

public class Main {
  public static void main(String[] args) {
    Counter c = new Counter();
    c.addObserver(new Observer<Counter,Object>() {
      public void update(Counter sender, Object data) {
        System.out.println("update(" + sender + "," + data + ")");
      }});
    c.inc();
    c.inc();
    c.notifyObservers("Dog");
    c.notifyObservers("Cat");
    c.inc();
    c.inc();
    c.inc();
    c.notifyObservers("Pig");
  }
}

class Counter {
  int _j;
  public int get() {
    return _j;
  }
  public void inc() {
    _j++;
    _oh.setChanged();
  }
  public String toString() {
    return "Counter(" + _j + ")";
  }

  ObservableHelper<Counter,Object> _oh = new ObservableHelper<Counter,Object>(this);
  public void addObserver(Observer<Counter, Object> observer) {
    _oh.addObserver(observer);
  }
  public void notifyObservers(Object data) {
    _oh.notifyObservers(data);
  }
}
    
  
