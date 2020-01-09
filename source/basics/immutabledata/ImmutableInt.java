package basics.immutabledata;

public class ImmutableInt {
	
	final int x; 

	ImmutableInt(int x) { this.x = x;}

	int get() { return x; }

	ImmutableInt set(int y) { return new ImmutableInt(y); }

	public static void main (String[] args) {
		ImmutableInt i = new ImmutableInt(3);
		ImmutableInt k = i.set(3);
	}
}