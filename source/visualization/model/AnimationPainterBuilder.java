package visualization.model;

import visualization.animator.Animator;
import visualization.animator.AnimationPainter;

/** 
 * An interface for building an {@link AnimationPainter} (with
 * corresponding {@link Animator}) realized for this {@link Model}.
 */
public interface AnimationPainterBuilder {
  /**
   *  Returns the {@link AnimationPainter}.
   *  This method may be called only once; subsequent calls throw an
   *  {@link IllegalStateException}.
   */
  public AnimationPainter getAnimationPainter();
  /**
   *  Returns the {@link Animator}.
   *  This method may be called only once; subsequent calls throw an
   *  {@link IllegalStateException}.
   */
  public Animator getAnimator();
  /**
   *  Add the {@link StationaryDot} to the display at position <code>i,j</code>.
   */
  public void addStationaryDot(StationaryDot d, int i, int j);
  /**
   *  Add the horizontal {@link Line} to the display, west of position <code>i,j</code>.
   *  If <code>eastToWest</code> is true, then line position 0 is the eastmost position.
   *  If <code>eastToWest</code> is false, then line position 0 is the westmost position.
   */
  public void addHorizontalLine(Line l, int i, int j, boolean eastToWest);
  /**
   *  Add the vertical {@link Line} to the display, north of position <code>i,j</code>.
   *  If <code>southToNorth</code> is true, then line position 0 is the southmost position.
   *  If <code>southToNorth</code> is false, then line position 0 is the northmost position.
   */
  public void addVerticalLine(Line l, int i, int j, boolean southToNorth);
}

/**
 * Null object for {@link AnimationPainterBuilder}.
 */
class NullAnimationPainterBuilder implements AnimationPainterBuilder {
  public AnimationPainter getAnimationPainter() { return null; }
  public Animator getAnimator() { return null; }
  public void addStationaryDot(StationaryDot d, int i, int j) { }
  public void addHorizontalLine(Line l, int i, int j, boolean eastToWest) { }
  public void addVerticalLine(Line l, int i, int j, boolean southToNorth) { }
}
