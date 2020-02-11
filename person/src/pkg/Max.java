package pkg;

public class Max {

    public static boolean isMax(int num, int[] a) {
        for (int i : a) {
            if (i > num)
                return false;
        }
        return true;
    }

    static int max(int[] a) {
        assert (a != null && a.length > 0);
        int i, j;
        i = 0;
        j = a.length-1;
        while (i!=j) {
            assert (j >= i);
            if (a[i] < a[j]) {
                assert (i < a.length);
                i = i + 1;
            } else {
                assert ();
                j = j + 1;
            }
        }
        assert(isMax(a[i],a));
        return a[i];
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        int max = max(a);
    }
}
