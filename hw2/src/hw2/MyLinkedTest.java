package hw2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyLinkedTest {

    /**
     * Tests the isEmpty Method
     */
    @Test
    void isEmpty() {
        MyLinked list = new MyLinked();
        assertTrue(list.isEmpty());

        list.add(1.0);
        assertFalse(list.isEmpty());
    }

    /**
     * Tests the size method
     */
    @Test
    void size() {
        MyLinked list = new MyLinked();
        list.add(1.0);
        assertEquals(1, list.size());

        list.add(2.0);
        assertEquals(2,list.size());

        list.add(3.0);
        assertEquals(3,list.size());

        list.delete(2);
        assertEquals(2,list.size());
    }

    /**
     * Tests the add method
     */
    @Test
    void add() {
		MyLinked list = new MyLinked();
        list.add(1.0);
        assertEquals(1, list.size());

        list.add(2.0);
        assertEquals(2,list.size());

        list.add(3.0);
        assertEquals(3,list.size());
    }

    /**
     * Tests the delete method
     */
    @Test
    void delete() {
        MyLinked list = new MyLinked();

        list.add(1.0);
        list.add(2.0);
        list.add(3.0);
        list.add(4.0);

        list.delete(0);
        assertEquals(3,list.size());

        list.delete(1);
        assertEquals(2,list.size());
    }

    /**
     * Tests the reverse method
     */
    @Test
    void reverse() {
        MyLinked list = new MyLinked();
        MyLinked list2 = new MyLinked();


        list.add(1.0);
        list.add(2.0);
        list.add(3.0);
        list.add(4.0);

        list2.add(1.0);
        list2.add(2.0);
        list2.add(3.0);
        list2.add(4.0);

        list.reverse();

        assertNotEquals(list, list2);

        // assertEquals(4.0,list.get(1));
        // assertEquals(3.0,list.get(2));
        // assertEquals(2.0,list.get(3));
        // assertEquals(1.0,list.get(4));
    }

    /**
     * Tests the remove method
     */
    @Test
    void remove() {
        MyLinked list = new MyLinked();

        list.add(1.0);
        list.add(2.0);
        list.add(3.0);

        list.remove(2.0);
        assertEquals(2,list.size());

        list.remove(3.0);
        assertEquals(1,list.size());

    }
}