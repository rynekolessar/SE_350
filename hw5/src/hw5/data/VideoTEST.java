package hw5.data;

import org.junit.jupiter.api.*;

public class VideoTEST {

    @Test
    public void testHashCode() {
        Assertions.assertEquals(-875826552, new VideoObj("None", 2009, "Zebra").hashCode());
        Assertions.assertEquals(-1391078111, new VideoObj("Blah", 1954, "Cante").hashCode());
    }

    @Test
    public void testEquals() {
        String title = "A";
        int year = 2009;
        String director = "Zebra";
        VideoObj a = new VideoObj(title,year,director);
        Assertions.assertEquals(a, a);
        Assertions.assertEquals(a, new VideoObj(title, year, director));
        Assertions.assertEquals(a, new VideoObj(new String(title), year, director));
        Assertions.assertEquals(a, new VideoObj(title, year, new String(director)));
        Assertions.assertNotEquals(a, new VideoObj(title + "1", year, director));
        Assertions.assertNotEquals(a, new VideoObj(title, year + 1, director));
        Assertions.assertNotEquals(a, new VideoObj(title, year, director + "1"));
        Assertions.assertNotEquals(a, new Object());
        Assertions.assertNotEquals(null, a);
    }

    @Test
    public void testCompareTo() {
        String title = "A", title2 = "B";
        int year = 2009, year2 = 2010;
        String director = "Zebra", director2 = "Zzz";
        VideoObj a = new VideoObj(title,year,director);
        VideoObj b = new VideoObj(title2,year,director);
        Assertions.assertTrue( a.compareTo(b) < 0 );
        Assertions.assertTrue( a.compareTo(b) == -b.compareTo(a) );
        Assertions.assertTrue( a.compareTo(a) == 0 );

        b = new VideoObj(title,year2,director);
        Assertions.assertTrue( a.compareTo(b) < 0 );
        Assertions.assertTrue( a.compareTo(b) == -b.compareTo(a) );

        b = new VideoObj(title,year,director2);
        Assertions.assertTrue( a.compareTo(b) < 0 );
        Assertions.assertTrue( a.compareTo(b) == -b.compareTo(a) );

        b = new VideoObj(title2,year2,director2);
        Assertions.assertTrue( a.compareTo(b) < 0 );
        Assertions.assertTrue( a.compareTo(b) == -b.compareTo(a) );

        try {
            a.compareTo(null);
            Assertions.fail();
        } catch ( NullPointerException e ) {}
    }
}
