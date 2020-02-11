package pkg;

interface Fun { public int eval(int i); }

public class Inc implements Fun { public int eval(int i) { return i + 1; } }

class TimesN implements Fun {
    private int _num;
    TimesN(int num) { _num = num; }

    public int eval(int i ) {
        return _num*i;
    }
}

class C implements Fun {
    private int f1;
    private int f2;
    C(int num1, int num2) {
        f1 = num1;
        f2 = num2;
    }

    public int eval(int i) {
        return 0;
    }

    public static void main(String[] args) {
        Fun inc = new Inc();           System.out.println(inc.eval(2));    // prints 3
        Fun t5 = new TimesN(5);   System.out.println(t5.eval(2));     // prints 10

    }
}
