package hw2;

public class MyLinked {
    static class Node {
        public Node() {
        }

        public double item;
        public Node next;
    }

    int N;
    Node first;

    public MyLinked() {
        first = null;
        N = 0;
        assert checkInvariants();
    }

    /**
     * @param k
     * @return item at kth index
     */
    public double get(int k) {
        Node current = first;
        int count = 0;
        while (current != null)
        {
            if (count == k)
                return current.item;
            count++;
            current = current.next;
        }
        return 0;
    }

    private boolean checkInvariants() {
        assert ((N != 0) || (first == null));
        Node x = first;
        for (int i = 0; i < N; i++) {
            if (x == null) {
                return false;
            }
            x = x.next;
        }
        assert (x == null);
        return true;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public void add(double item) {
        Node newfirst = new Node();
        newfirst.item = item;
        newfirst.next = first;
        first = newfirst;
        N++;
    }

    // delete the kth element
    public void delete(int k) {
        if (k < 0 || k >= N) { throw new IllegalArgumentException(); }
        if(k==0) {
            first = first.next;
        } else {
            Node temp = first;
            int i = 0;
            while(i < k-1) {
                temp = temp.next;
                i++;
            }
            temp.next = temp.next.next;
        }
        N--;
        assert checkInvariants();
    }

    // reverse the list "in place"... without creating any new nodes
    public void reverse() {
        Node prev = null, curr = first, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
    }

    // removes an element rather than an item at an index
    public void remove(double item) {
        while (first.item == item) {
            first = first.next;
            N--;
        }
        Node temp = first;
        while (temp.next != null) {
            if (temp.next.item == item) {
                temp.next = temp.next.next;
                N--;
            } else {
                temp = temp.next;
            }
        }
        assert checkInvariants();
    }
}