package visualization.main;

import visualization.model.Model;
import visualization.model.AnimationPainterBuilder;
import visualization.visualizer.SwingAnimationPainterBuilder;

/**
 * A static class to demonstrate the visualization aspect of
 * simulation.
 */
public class Main {
  private Main() {}
  public static void main(String[] args) {
    AnimationPainterBuilder b = new SwingAnimationPainterBuilder();
    Model m = new Model(b, 3, 2);
    
    m.run(500);
    m.run(500);

    System.exit(0);
  }
}

