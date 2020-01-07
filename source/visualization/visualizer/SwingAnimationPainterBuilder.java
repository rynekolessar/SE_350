package visualization.visualizer;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import visualization.animator.AnimationPainter;
import visualization.animator.Animator;
import visualization.animator.SwingAnimator;
import visualization.model.AnimationPainterBuilder;
import visualization.model.Line;
import visualization.model.MP;
import visualization.model.MovingDot;
import visualization.model.StationaryDot;

/**
 * Static class for visualization parameters.
 */
class VP {
  private VP() {}
  /** Width of model elements, in meters */
  static double elementWidth = MP.dotLength;
  /** Gap between model elements, in meters */
  static double gap = 1;
  /** Width of the displayed graphics window, in pixels */
  static int displayWidth = 1000;
  /** Height of the displayed graphics window, in pixels */
  static int displayHeight = 1000;
  /** Delay introduced into each graphics update, in milliseconds */
  static int displayDelay = 5;
  /** Scalefactor relating model space to pixels, in pixels/meter */
  static double scaleFactor = 1;
}  

/**
 * Pair of a model element <code>x</code> and a translator <code>t</code>.
 */
class Element<T> {
  T x;
  Translator t;
  Element(T x, Translator t) {
    this.x = x;
    this.t = t;
  }
}

/**
 * Class for drawing the Model.
 */
class SwingAnimationPainter implements AnimationPainter {
  private List<Element<Line>> _lineElements;
  private List<Element<StationaryDot>> _stationaryDotElements;
  SwingAnimationPainter() {
    _lineElements = new ArrayList<Element<Line>>();
    _stationaryDotElements = new ArrayList<Element<StationaryDot>>();
  }    
  void addStationaryDot(StationaryDot x, Translator t) {
    _stationaryDotElements.add(new Element<StationaryDot>(x,t));
  }
  void addLine(Line x, Translator t) {
    _lineElements.add(new Element<Line>(x,t));
  }

  public void paint(Object o) {
    if (!(o instanceof Graphics)) {
      throw new IllegalStateException();
    }
    Graphics g = (Graphics) o;
    
    // draw the background elements
    for (Element<StationaryDot> e : _stationaryDotElements) {
      if (e.x.getState()) {
        g.setColor(Color.BLUE);
      } else {
        g.setColor(Color.YELLOW);
      }
      XGraphics.fillOval(g, e.t, 0, 0, MP.dotLength, VP.elementWidth);
    }
    g.setColor(Color.BLACK);
    for (Element<Line> e : _lineElements) {
      XGraphics.fillRect(g, e.t, 0, 0, MP.lineLength, VP.elementWidth);
    }

    // draw the foreground elements
    for (Element<Line> e : _lineElements) {
      g.setColor(Color.RED);
      for (MovingDot d : e.x.getDots()) {
        XGraphics.fillOval(g, e.t, d.getPosition(), 0, MP.dotLength, VP.elementWidth);
      }
    }
  }
}

/** 
 * A class for building AnimationPainters and Animators.
 */
public class SwingAnimationPainterBuilder implements AnimationPainterBuilder {
  SwingAnimationPainter _painter;
  Animator _animator;
  public SwingAnimationPainterBuilder() {
    _painter = new SwingAnimationPainter();
    _animator = new SwingAnimator("Traffic Simulator", VP.displayWidth, VP.displayHeight, VP.displayDelay);
  }
  public AnimationPainter getAnimationPainter() {
    if (_painter == null) { throw new IllegalStateException(); }
    AnimationPainter returnValue = _painter;
    _painter = null;
    return returnValue;
  }
  public Animator getAnimator() {
    if (_animator == null) { throw new IllegalStateException(); }
    Animator returnValue = _animator;
    _animator = null;
    return returnValue;
  }
  private static double skipInit = VP.gap;
  private static double skipLine = VP.gap + MP.lineLength;
  private static double skipDot = VP.gap + VP.elementWidth;
  private static double skipLineDot = skipLine + skipDot;
  public void addStationaryDot(StationaryDot d, int i, int j) {
    double x = skipInit + skipLine + j*skipLineDot;
    double y = skipInit + skipLine + i*skipLineDot;
    Translator t = new TranslatorWE(x, y, MP.dotLength, VP.elementWidth, VP.scaleFactor);
    _painter.addStationaryDot(d,t);
  }
  public void addHorizontalLine(Line l, int i, int j, boolean eastToWest) {
    double x = skipInit + j*skipLineDot;
    double y = skipInit + skipLine + i*skipLineDot;
    Translator t = eastToWest ? new TranslatorEW(x, y, MP.lineLength, VP.elementWidth, VP.scaleFactor)
                              : new TranslatorWE(x, y, MP.lineLength, VP.elementWidth, VP.scaleFactor);
    _painter.addLine(l,t);
  }
  public void addVerticalLine(Line l, int i, int j, boolean southToNorth) {
    double x = skipInit + skipLine + j*skipLineDot;
    double y = skipInit + i*skipLineDot;
    Translator t = southToNorth ? new TranslatorSN(x, y, MP.lineLength, VP.elementWidth, VP.scaleFactor)
                                : new TranslatorNS(x, y, MP.lineLength, VP.elementWidth, VP.scaleFactor);
    _painter.addLine(l,t);
  }
}

/**
 * Static class for drawing using a Translation.
 */
class XGraphics {
  private XGraphics() {}
  static void clearRect(Graphics g, Translator t, double x, double y, double w, double h) {
    g.clearRect(t.getX(x,y,w,h), t.getY(x,y,w,h), t.getWidth(w,h), t.getHeight(w,h));
  }
  static void drawOval(Graphics g, Translator t, double x, double y, double w, double h) {
    g.drawOval(t.getX(x,y,w,h), t.getY(x,y,w,h), t.getWidth(w,h), t.getHeight(w,h));
  }
  static void drawRect(Graphics g, Translator t, double x, double y, double w, double h) {
    g.drawRect(t.getX(x,y,w,h), t.getY(x,y,w,h), t.getWidth(w,h), t.getHeight(w,h));
  }
  static void fillOval(Graphics g, Translator t, double x, double y, double w, double h) {
    g.fillOval(t.getX(x,y,w,h), t.getY(x,y,w,h), t.getWidth(w,h), t.getHeight(w,h));
  }
  static void fillRect(Graphics g, Translator t, double x, double y, double w, double h) {
    g.fillRect(t.getX(x,y,w,h), t.getY(x,y,w,h), t.getWidth(w,h), t.getHeight(w,h));
  }
  static void drawString(Graphics g, Translator t, String str, double x, double y) {
    g.drawString(str, t.getX(x,y,0,0), t.getY(x,y,0,0));
  }
}

/**
 * A translator from relative model space to screen graphics.
 */
abstract class Translator {
  double _tX;
  double _tY;
  double _tWidth;
  double _tHeight;
  double _tScaleFactor;
  Translator(double tX, double tY, double tWidth, double tHeight, double tScaleFactor) {
    _tX = tX;
    _tY = tY;
    _tWidth = tWidth;
    _tHeight = tHeight;
    _tScaleFactor = tScaleFactor;
  }
  int scale(double arg) {
    return (int) Math.ceil(arg * _tScaleFactor); 
  }
  abstract int getX(double x, double y, double width, double height);
  abstract int getY(double x, double y, double width, double height);
  abstract int getWidth(double width, double height);
  abstract int getHeight(double width, double height);
}

class TranslatorWE extends Translator {
  TranslatorWE(double tX, double tY, double tWidth, double tHeight, double tScaleFactor) {
    super(tX, tY, tWidth, tHeight, tScaleFactor);
  }
  int getX(double x, double y, double width, double height) { return scale(_tX+x); }
  int getY(double x, double y, double width, double height) { return scale(_tY+y); }
  int getWidth(double width, double height) { return scale(width); }
  int getHeight(double width, double height)  { return scale(height); }
}

class TranslatorEW extends Translator {
  TranslatorEW(double tX, double tY, double tWidth, double tHeight, double tScaleFactor) {
    super(tX, tY, tWidth, tHeight, tScaleFactor);
  }
  int getX(double x, double y, double width, double height) { return scale(_tX+_tWidth-x-width); }
  int getY(double x, double y, double width, double height) { return scale(_tY+_tHeight-y-height); }
  int getWidth(double width, double height) { return scale(width); }
  int getHeight(double width, double height)  { return scale(height); }
}

class TranslatorNS extends Translator {
  TranslatorNS(double tX, double tY, double tWidth, double tHeight, double tScaleFactor) {
    super(tX, tY, tWidth, tHeight, tScaleFactor);
  }
  int getX(double x, double y, double width, double height) { return scale(_tX+y); }
  int getY(double x, double y, double width, double height) { return scale(_tY+x); }
  int getWidth(double width, double height) { return scale(height); }
  int getHeight(double width, double height)  { return scale(width); }
}

class TranslatorSN extends Translator {
  TranslatorSN(double tX, double tY, double tWidth, double tHeight, double tScaleFactor) {
    super(tX, tY, tWidth, tHeight, tScaleFactor);
  }
  int getX(double x, double y, double width, double height) { return scale(_tX+_tHeight-y-height); }
  int getY(double x, double y, double width, double height) { return scale(_tY+_tWidth-x-width); }
  int getWidth(double width, double height) { return scale(height); }
  int getHeight(double width, double height)  { return scale(width); }
}

