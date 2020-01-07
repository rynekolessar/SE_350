package agent;
import junit.framework.Assert;
import junit.framework.TestCase;

public class AgentQueueTEST extends TestCase {
  private int _scratch;

  public AgentQueueTEST(String name) {
    super(name);
  }

  public void testThatEmptySizeIsZero() {
    AgentQueueLinked q = new AgentQueueLinked();
    Assert.assertEquals(0, q.size());
  }

  public void testThatDequeueOnEmptyThrowsIndexOutOfBoundsException() {
    AgentQueueLinked q = new AgentQueueLinked();
    boolean exceptionOccurred = false;

    try {
      Agent o = q.dequeue();
    } catch (IndexOutOfBoundsException e) {
      exceptionOccurred = true;
    }

    Assert.assertTrue(exceptionOccurred);
  }

  public void testThatEnqueueFollowedByDequeueReturnsSameReference() {
    class TestThatEnqueueFollowedByDequeueReturnsSameReference
      implements Agent
    {
      public void run() {}
    }

    AgentQueueLinked q = new AgentQueueLinked();
    Agent x1 = new TestThatEnqueueFollowedByDequeueReturnsSameReference();
    q.enqueue(0, x1);
    Assert.assertSame(x1, q.dequeue());
    Assert.assertEquals(0, q.size());
  }

  public void testThatElementsAreInsertedInOrder() {
    class TestThatElementsAreInsertedInOrder implements Agent {
      public void run() {}
    }

    AgentQueueLinked q = new AgentQueueLinked();
    Agent x1 = new TestThatElementsAreInsertedInOrder();
    Agent x2 = new TestThatElementsAreInsertedInOrder();
    q.enqueue(0, x2);
    q.enqueue(1, x1);
    Assert.assertSame(x2, q.dequeue());
    Assert.assertSame(x1, q.dequeue());
    q.enqueue(1, x1);
    q.enqueue(0, x2);
    Assert.assertSame(x2, q.dequeue());
    Assert.assertSame(x1, q.dequeue());
    q.enqueue(0, x1);
    q.enqueue(0, x2);
    Assert.assertSame(x1, q.dequeue());
    Assert.assertSame(x2, q.dequeue());
    q.enqueue(0, x2);
    q.enqueue(0, x1);
    Assert.assertSame(x2, q.dequeue());
    Assert.assertSame(x1, q.dequeue());
  }

  public void testToString() {
    class TestToString implements Agent {
      public void run() {}
      public String toString() { return "x"; }
    }

    AgentQueue q = new AgentQueueLinked();
    q.enqueue(0, new TestToString());
    q.enqueue(1, new TestToString());
    Assert.assertEquals("[(0,x);(1,x)]", q.toString());
  }

  public void testCurrentTime() {
    class TestCurrentTime implements Agent {
      public void run() {}
    }

    AgentQueue q = new AgentQueueLinked();
    int expected = 1230;
    q.enqueue(expected, new TestCurrentTime());

    Assert.assertEquals(0, q.currentTime());
    q.run(expected);
    
    Assert.assertEquals(expected, q.currentTime());
  }

  public void testDoActionsAtOrBefore() {
    class TestDoActionsAtOrBefore implements Agent {
      private int _myScratch;
      TestDoActionsAtOrBefore(int myScratch) {
        _myScratch = myScratch;
      }
      public void run() {
        _scratch = _myScratch;
      }
    }

    AgentQueue q = new AgentQueueLinked();
    int time1 = 12;
    int time2 = 23;
    int value1 = 42;
    int value2 = 27;

    q.enqueue(time1, new TestDoActionsAtOrBefore(value1));

    _scratch = 0;
    q.run(time1 - 1);
    Assert.assertEquals(0, _scratch);

    _scratch = 0;
    q.run(1);
    Assert.assertEquals(value1, _scratch);

    q.enqueue(time2, new TestDoActionsAtOrBefore(value2));

    _scratch = 0;
    q.run(time2);
    Assert.assertEquals(value2, _scratch);
  }
}
