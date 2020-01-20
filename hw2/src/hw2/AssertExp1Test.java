package hw2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class AssertExp1Test {

    /**
     * Tests the minValue method
     */
    @Test
    void minValueTest() {
        double[] list = {1.0,2.0,3.0,4.0,5.0};
        assertEquals(1.0, AssertExp1.minValue(list));

        double[] list2 = {616.23, 18.45, 92.00, 68.3, 14.5};
        assertEquals(14.5, AssertExp1.minValue(list2));

        double[] list3 = {85.0, 100.4, 63.9, 47.0};
        assertEquals(47.0, AssertExp1.minValue(list3));
    }

    /**
     * Tests the minPosition method
     */
    @Test
    void minPositionTest() {
        double[] list = {1.0,2.0,3.0,4.0,5.0};
        assertEquals(0, AssertExp1.minPosition(list));

        double[] list2 = {616.23, 18.45, 92.00, 68.3, 14.5};
        assertEquals(4, AssertExp1.minPosition(list2));

        double[] list3 = {85.0, 100.4, 63.9, 47.0};
        assertEquals(3, AssertExp1.minPosition(list3));
    }

    /**
     * Tests the numUnique method
     */
    @Test
    void numUniqueTest() {
        double[] list = {1.0,2.0,3.0,4.0,5.0};
        assertEquals(5, AssertExp1.numUnique(list));

        double[] list2 = {18.45, 18.45, 92.0, 1234.1234};
        assertEquals(3, AssertExp1.numUnique(list2));

        double[] list3 = {1.0,1.0};
        assertEquals(1, AssertExp1.numUnique(list3));
    }

    /**
     * Tests the removeDuplicates method
     */
    @Test
    void removeDuplicatesTest() {
        final double[] list = {1.0,2.0,3.0,4.0,5.0};

        double[] list2 = {1.0,1.0,2.0,2.0,3.0,3.0,4.0,4.0,5.0,5.0};
        double[] list3 = AssertExp1.removeDuplicates(list2);

        assertArrayEquals(list,list3);
    }
}