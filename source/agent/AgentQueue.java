package agent;

public interface AgentQueue {
    public long currentTime();
    public void enqueue(long waketime, Agent thing);
    public void run(int duration);
}
