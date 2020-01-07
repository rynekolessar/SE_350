package music;
import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;
class EventGroup implements Event {
  List _events = new LinkedList();
  public void add(Event e) {
    _events.add(e);
  }
  
  public void play() {
    Iterator i = _events.iterator();
    while (i.hasNext()) {
      ((Event)(i.next())).play();
    }
  }
}
