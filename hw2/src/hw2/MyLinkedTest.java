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


    }

    /**
     * Tests the delete method
     */
    @Test
    void delete() {

    }

    /**
     * Tests the reverse method
     */
    @Test
    void reverse() {

    }

    /**
     * Tests the remove method
     */
    @Test
    void remove() {

    }
}