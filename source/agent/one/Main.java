package agent.one;
import agent.Agent;
import agent.AgentQueue;
import agent.AgentQueueLinked;

public class Main {
  public static void main (String[] args) {
    AgentQueue time = new AgentQueueLinked();
    Agent a = new Tiger(time);
    time.enqueue(0,a);
    time.run(100);
  }
}

class Tiger implements Agent {
  private AgentQueue _time;
  public Tiger(AgentQueue time) { _time = time; }
  public void run() {
    System.out.println("It's " + _time.currentTime() + " and I'm alive!");
    _time.enqueue(10+_time.currentTime(), this);
  }
}  
