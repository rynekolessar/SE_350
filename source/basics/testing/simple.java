package basics.testing;

import org.jetbrains.annotations.NotNull;

/**
 * In class program from 2020-01-14
 *
 * Assertions, "white-box" testing, etc...
 */

public class simple {

    int max(int s1,int s2,int s3) {
        int x = 0;
        int res = 0;
        assert(x == Integer.max(s1,s2));
        assert(res == Integer.max(x,s3));
        return res;
    }

    int foo (int x, int y) {
        assert(y>=0); // Precondition
        int sum = x + y;

        while (y > 0) {
            y--;
            x++;
            assert(sum == x+y); // Invariant
        }
        assert(sum == x);
        return x;
    }

    static int foobar (int x) {
        x = x-1;
        return x;
    }


    static int sumAux(int[] a, int start, int end) {
        return 0;
    }

    static int sum(@NotNull int[] a) {
        assert (a != null); // or annotation above (from JetBrains Annotations)
        int res = 0;

        for (int i = 0; i < a.length; i++) {
            res += a[i];
            assert (res == sumAux(a,0,i)); // Invariant
        }

        return res;
    }

    public static void main(String[] args) {


    }
}
