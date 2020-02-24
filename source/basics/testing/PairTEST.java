package basics.testing;

import junit.framework.Assert;
import junit.framework.TestCase;
import basics.immutabledata.Pair;

public class PairTEST extends TestCase {
  public PairTEST(String name) {
    super(name);
  }
  /**
   * Main program for invoking the tests, if you want a text user interface.
   */
  public static void main (String args[]) {
    //     try {
    //       new junit.textui.TestRunner().start(new String[] {
    //         "basics.testing.PairTEST" });
    //     } catch (Exception e) {
    //       e.printStackTrace();
    //     }
  }
  
  /**
   *  Constructor should throw IllegalArgumentException if either
   *  argument is null.
   */
  public void testConstructor() {
    try {
      new Pair(null,"cat");
      // constructor should have thrown exception
      Assert.fail();
    } catch (IllegalArgumentException e) { }
    try {
      new Pair("dog",null);
      // constructor should have thrown exception
      Assert.fail();
    } catch (IllegalArgumentException e) { }
    try {
      new Pair(null,null);
      // constructor should have thrown exception
      Assert.fail();
    } catch (IllegalArgumentException e) { }
    try {
      new Pair("dog","cat");
    } catch (IllegalArgumentException e) {
      // constructor should have succeeded
      Assert.fail();
    }
  }

  /**
   *  first() and second() should return references to the objects
   *  given to the constructor.
   */
  public void testFirstAndSecond() {
    Integer i = new Integer(42);
    Integer j = new Integer(91);
    Pair p = new Pair(i, j);
    Assert.assertSame(i, p.first());
    Assert.assertSame(j, p.second());
  }

  /**
   *  Here is a weaker version of the above test; this version allows
   *  Pair() to clone its arguments.
   */
  public void testFirstAndSecond_WeakerVersion() {
    Integer i = new Integer(42);
    Integer j = new Integer(91);
    Pair p = new Pair(i, j);
    Assert.assertEquals(i, p.first());
    Assert.assertEquals(j, p.second());
  }

  public void testToString() {
    Pair p = new Pair(new Integer(42), new Integer(91));
    Assert.assertEquals("Pair(42,91)", p.toString());
  }

  public void testEquals() {
    Pair p1 = new Pair(new Integer(42), new Integer(91));
    Pair p2 = new Pair(new Integer(42), new Integer(91));
    Pair p3 = new Pair(new Integer(43), new Integer(91));
    Pair p4 = new Pair(new Integer(42), new Integer(92));
    Assert.assertTrue(p1.equals(p1));
    Assert.assertTrue(p1.equals(p2));
    Assert.assertFalse(p1.equals(p3));
    Assert.assertFalse(p1.equals(p4));
    Assert.assertFalse(p1.equals(new Object()));
  }

  public void testHashCode() {
    Pair p1 = new Pair(new Integer(42), new Integer(91));
    Pair p2 = new Pair(new Integer(42), new Integer(91));
    Pair p3 = new Pair(new Integer(43), new Integer(91));
    Pair p4 = new Pair(new Integer(42), new Integer(92));
    Assert.assertEquals(p1.hashCode(), p1.hashCode());
    Assert.assertEquals(p1.hashCode(), p2.hashCode());
    Assert.assertTrue(p1.hashCode() != p3.hashCode());
    Assert.assertTrue(p1.hashCode() != p4.hashCode());
  }

  public void testCompareTo() {
    Pair p1 = new Pair(new Integer(42), new Integer(91));
    Pair p2 = new Pair(new Integer(42), new Integer(91));
    Pair p3 = new Pair(new Integer(43), new Integer(91));
    Pair p4 = new Pair(new Integer(42), new Integer(92));
    Assert.assertTrue(0 == p1.compareTo(p1));
    Assert.assertTrue(0 == p1.compareTo(p2));
    Assert.assertTrue(0 >  p1.compareTo(p3));
    Assert.assertTrue(0 >  p1.compareTo(p4));
    Assert.assertTrue(0 == p2.compareTo(p1));
    Assert.assertTrue(0 <  p3.compareTo(p1));
    Assert.assertTrue(0 <  p4.compareTo(p1));
    try {
      p1.compareTo(new Object());
      // compareTo should have thrown exception
      Assert.fail();
    } catch (ClassCastException e) { }
  }
}
