package visualization.model;

import java.util.List;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import visualization.animator.Animator;
import visualization.animator.AnimationPainter;

/**
 * An example to model for a simple visualization.
 * The model contains lines organized in a matrix.
 * See {@link #Model(AnimationPainterBuilder, int, int)}.
 */
public class Model extends Observable implements AnimationPainter {
  private List<Agent> _agents;
  private AnimationPainter _painter;
  private int _time;

  /** Creates a model to be visualized using the <code>builder</code>.
   *  If the builder is null, no visualization is performed.
   *  The number of <code>rows</code> and <code>columns</code>
   *  indicate the number of {@link StationaryDot}s, organized as a 2D
   *  matrix.  These are separated and surrounded by horizontal and
   *  vertical {@link Line}s.  For example, calling the constructor with 1
   *  row and 2 columns generates a model of the form:
   *  <pre>
   *     |  |
   *   --@--@--
   *     |  |
   *  </pre>
   *  where <code>@</code> is a {@link StationaryDot}, <code>|</code> is a
   *  vertical {@link Line} and <code>--</code> is a horizontal {@link Line}.
   *  Each line has one {@link MovingDot}.
   *
   *  <p>
   *  The {@link AnimationPainterBuilder} is used to set up an {@link
   *  AnimationPainter}.
   *  {@link AnimationPainterBuilder#getAnimator()} is registered as
   *  an observer of this model.
   *  Callbacks to {@link AnimationPainter#paint(Object)} delegate to {@link
   *  AnimationPainterBuilder#getAnimationPainter()}.
   *  <p>
   */
  public Model(AnimationPainterBuilder builder, int rows, int columns) {
    if (rows < 0 || columns < 0 || (rows == 0 && columns == 0)) {
      throw new IllegalArgumentException();
    }
    if (builder == null) {
      builder = new NullAnimationPainterBuilder();
    }
    _agents = new ArrayList<Agent>();
    setup(builder, rows, columns);
    _painter = builder.getAnimationPainter();
    Animator a = builder.getAnimator();
    if (a != null) {
      super.addObserver(a);
    }
  }

  /**
   * When updating observers, an {@link Animator} will call back
   * here to update the display; this method delegates to the
   * {@link AnimationPainter} created by the {@link
   * AnimationPainterBuilder} passed to the constructor.
   */
  public void paint(Object arg) {
    _painter.paint(arg);
  }

  /**
   * Run the simulation for <code>duration</code> model seconds.
   */
  public void run(int duration) {
    for (int i=0; i<duration; i++) {
      _time++;
      Agent[] agents_copy = _agents.toArray(new Agent[0]);
      for (Agent a : agents_copy) {
        a.run(_time);
      }
      super.setChanged();
      super.notifyObservers();
    }
  }

  /**
   * Construct the model, establishing correspondences with the visualizer.
   */
  private void setup(AnimationPainterBuilder builder, int rows, int columns) {
    List<Line> lines = new ArrayList<Line>();
    StationaryDot[][] intersections = new StationaryDot[rows][columns];
    Boolean reverse;

    // Add Yellow Dots
    for (int i=0; i<rows; i++) {
      for (int j=0; j<columns; j++) {
        intersections[i][j] = new StationaryDot();
        builder.addStationaryDot(intersections[i][j], i, j);
        _agents.add(intersections[i][j]);
      }
    }

    // Add Horizontal Lines
    boolean eastToWest = false;
    for (int i=0; i<rows; i++) {
      for (int j=0; j<=columns; j++) {
        Line l = new Line();
        builder.addHorizontalLine(l, i, j, eastToWest);
        lines.add(l);
      }
      eastToWest = !eastToWest;
    }

    // Add Vertical Lines
    boolean southToNorth = false;
    for (int j=0; j<columns; j++) {
      for (int i=0; i<=rows; i++) {
        Line l = new Line();
        builder.addVerticalLine(l, i, j, southToNorth);
        lines.add(l);
      }
      southToNorth = !southToNorth;
    }

    // Add Red Dots
    for (Line l : lines) {
      MovingDot dot = new MovingDot();
      _agents.add(dot);
      l.accept(dot);
    }
  }
}
