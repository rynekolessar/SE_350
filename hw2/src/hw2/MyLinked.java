package hw2;

public class MyLinked {
    static class Node {
        public Node() { }
        public double item;
        public Node next;
    }

    int N;
    Node first;
    
    public MyLinked () {
        first = null;
        N = 0;
        assert checkInvariants ();
    }


    private boolean checkInvariants() {
        assert((N != 0) || (first == null));
        Node x = first;
        for (int i = 0; i < N; i++) {
            if (x==null) {
                return false;
            }
            x = x.next;
        }
        assert(x == null);
        return true;
    }

    public boolean isEmpty () { return first == null; }
    public int size () { return N; }

    public void add (double item) {
        Node newfirst = new Node ();
        newfirst.item = item;
        newfirst.next = first;
        first = newfirst;
        N++;
    }

    // delete the kth element
    public void delete (int k) {
        // TODO
        if (k < 0 || k >= N) throw new IllegalArgumentException ();
        
        assert checkInvariants ();
    }

    // reverse the list "in place"... without creating any new nodes
    public void reverse () {
        Node prev = null, curr = first, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            assert(next == curr.next && prev.next == curr); // TODO: Fix this, always false
        }
        assert checkInvariants();
    }

    // removes an element rather than an item at an index
    public void remove (double item) {
    	// TODO
        
        assert checkInvariants ();
    }

// TODO: CONVERT THE FOLLOWING TO JUNIT TESTS
// In a separate junit test file
/*
    private static void testDelete () {
        MyLinked b = new MyLinked ();
        b.add (1);
        print ("singleton", b);
        b.delete (0);
        print ("deleted", b);
        for (double i = 1; i < 13; i++) {
            b.add (i);
        }
        print ("bigger list", b);
        b.delete (0);
        print ("deleted at beginning", b);
        b.delete (10);
        print ("deleted at end", b);
        b.delete (4);
        print ("deleted in middle", b);
    }
    private static void testReverse () {
        MyLinked b = new MyLinked ();
        b.reverse ();
        print ("reverse empty", b);
        b.add (1);
        print ("singleton", b);
        b.reverse ();
        print ("reverse singleton", b);
        b.add (2);
        print ("two", b);
        b.reverse ();
        print ("reverse two", b);
        b.reverse ();
        print ("reverse again", b);
        for (double i = 3; i < 7; i++) {
            b.add (i);
            b.add (i);
        }
        print ("bigger list", b);
        b.reverse ();
        print ("reversed", b);
    }
    private static void testRemove () {
        MyLinked b = new MyLinked ();
        b.remove (4);
        print ("removed 4 from empty", b);
        b.add (1);
        b.remove (4);
        print ("removed 4 from singelton", b);
        b.remove (1);
        print ("removed 1 from singelton", b);
        for (double i = 1; i < 5; i++) {
            b.add (i);
            b.add (i);
        }
        for (double i = 1; i < 5; i++) {
            b.add (i);
            b.add (i);
            b.add (i);
            b.add (i);
            b.add (i);
        }
        print ("longer list", b);
        b.remove (9);
        print ("removed all 9s", b); // does nothing
        b.remove (3);
        print ("removed all 3s", b);
        b.remove (1);
        print ("removed all 1s", b);
        b.remove (4);
        print ("removed all 4s", b);
        b.remove (2);
        print ("removed all 2s", b); // should be empty
    }
*/
}

































