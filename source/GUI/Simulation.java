package GUI;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ComponentListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

class Simulation {
  public static void main(String[] args) {
    SimulationGUI application = new SimulationGUI();
    application.open();
  }
}

class SimulationGUI extends JFrame {
  WorldView worldView;

  public void open() {
    JFrame frame = new JFrame("Simulation TEST");
    frame.addWindowListener(new WindowAdapter() {
        public void windowClosing(WindowEvent evt) {
          System.exit(0);
        }
      });
    Container content = frame.getContentPane();
    content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
    worldView = new WorldView();
    content.add(worldView);
    frame.pack();
    frame.setVisible(true);
  }
}

class WorldView extends JPanel {
  private int width = 300;
  private int height = 300;
  public WorldView() {
    setMaximumSize(new Dimension(width + 10, height + 10));
    setPreferredSize(new Dimension(width + 2, height + 2));
  }
  public void paint(Graphics g) {
    g.setColor(Color.RED);
    g.fillRect(10, 10, 100, 100);
    System.out.println("paint()");
  }
}
