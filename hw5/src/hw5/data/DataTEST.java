package hw5.data;

import org.junit.jupiter.api.*;

public class DataTEST {

    @Test
    public void testConstructorAndAttributes() {
        String title1 = "XX";
        String director1 = "XY";
        String title2 = " XX ";
        String director2 = " XY ";
        int year = 2002;

        Video v1 = Data.newVideo(title1, year, director1);
        Assertions.assertSame(title1, v1.title());
        Assertions.assertEquals(year, v1.year());
        Assertions.assertSame(director1, v1.director());

        Video v2 = Data.newVideo(title2, year, director2);
        Assertions.assertEquals(title1, v2.title());
        Assertions.assertEquals(director1, v2.director());
    }

    @Test
    public void testConstructorExceptionYear() {
        try {
            Data.newVideo("X", 1800, "Y");
            Assertions.fail();
        } catch (IllegalArgumentException e) { }
        try {
            Data.newVideo("X", 5000, "Y");
            Assertions.fail();
        } catch (IllegalArgumentException e) { }
        try {
            Data.newVideo("X", 1801, "Y");
            Data.newVideo("X", 4999, "Y");
        } catch (IllegalArgumentException e) {
            Assertions.fail();
        }
    }

    @Test
    public void testConstructorExceptionTitle() {
        try {
            Data.newVideo(null, 2002, "Y");
            Assertions.fail();
        } catch (IllegalArgumentException e) { }
        try {
            Data.newVideo("", 2002, "Y");
            Assertions.fail();
        } catch (IllegalArgumentException e) { }
        try {
            Data.newVideo(" ", 2002, "Y");
            Assertions.fail();
        } catch (IllegalArgumentException e) { }
    }

    @Test
    public void testConstructorExceptionDirector() {
    }

    @Test
    public void testToString() {
        String s = Data.newVideo("A",2000,"B").toString();
        Assertions.assertEquals( s, "A (2000) : B" );
        s = Data.newVideo(" A ",2000," B ").toString();
        Assertions.assertEquals( s, "A (2000) : B" );
    }
}
