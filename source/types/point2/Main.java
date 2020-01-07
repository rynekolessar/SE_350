package types.point2;
import java.awt.Color;
final class PolarPoint {
  private final double _theta;
  private final double _r;
  private final Color _color; 
  public PolarPoint(double x, double y, Color color) {
    _theta = Math.atan(y/x);
    _r = Math.sqrt(x+y);
    _color = color;
  }
  public double getX() { return _r*Math.cos(_theta); }
  public double getY() { return _r*Math.sin(_theta); }
  public Color getColor() {
    System.out.println("It's Polar!");
    return _color;
  }
}
public class Main {
  private Main() {}
  public static void main(String[] args) {
    PolarPoint r1 = new PolarPoint(0,0,Color.RED);
  }
}
