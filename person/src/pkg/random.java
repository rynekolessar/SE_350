package pkg;
import person.Unit;

/**
 * Meant to test if a class outside the person package can access the Unit Interface
 */

public class random implements Unit {

    public double ycomp() {
        return 0;
    }

    public String toString() {
        return super.toString();
    }
}
