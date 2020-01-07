package visualization.model;

/**
 * A stationary dot has a boolean state.
 */
public class StationaryDot implements Agent {
  StationaryDot() { } // Created only by this package
  
  private boolean _state;

  public boolean getState() {
    return _state;
  }
  public void run(int time) {
    if (time%40==0) {
      _state = !_state;
    }
  }
}

