package visualization.model;

import java.util.List;
import java.util.ArrayList;

/**
 * A line holds moving dots.
 */
public class Line {
  Line() { } // Created only by this package

  private List<MovingDot> _dots = new ArrayList<MovingDot>();

  public void accept(MovingDot d) {
    if (d == null) { throw new IllegalArgumentException(); }
    _dots.add(d);
  }
  public List<MovingDot> getDots() {
    return _dots;
  }
}
