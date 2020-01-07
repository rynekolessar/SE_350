package visualization.model;

/**
 * A moving dot remembers its position from the beginning of its line.
 * Moving dots have random velocity and random movement pattern:
 * when reaching the end of a line, the dot either resets its position
 * to the beginning of the line, or reverses its direction.
 */
public class MovingDot implements Agent {
  MovingDot() { } // Created only by this package

  private boolean _backAndForth = Math.round(Math.random())==1 ? true : false;
  private double _position = 0;
  private double _velocity = (int) Math.ceil(Math.random() * MP.maxVelocity);

  public double getPosition() {
    return _position;
  }
  public void run(int time) {
    if (_backAndForth) {
      if (((_position + _velocity) < 0) || ((_position + _velocity) > (MP.lineLength-MP.dotLength)))
        _velocity *= -1;
    } else {
      if ((_position + _velocity) > (MP.lineLength-MP.dotLength))
        _position = 0;
    }
    _position += _velocity;
  }
}
