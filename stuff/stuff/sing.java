package stuff;

enum Day {
	SUNDAY,
	MONDAY,
	TUESDAY,
	WEDNESDAY,
	THURSDAY,
	FRIDAY,
	SATURDAY
}


public class sing {
	int x;
	private static sing s = new sing();

	private sing() {}
	static sing getInstance() {
		return s;
	}
}