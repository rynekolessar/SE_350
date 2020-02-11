package basics.testing;

import java.util.List;

public class pers {
	
	int age;
	String email;
	int getAge() { return age; }
	String getEmail() { return email; }
	void pp() {}
	
	
	public static void pp(List<pers> l, select o) {
		for (pers p : l) {
			if (o.test(p)) {
				p.pp();
			}
		}
	}
	
	public static void main(String[] args) {
		List<pers> l;
		final int i;
		final pers q = new pers();

		pers.pp(1, new alt());

		pers.pp(1,new select() {
			int j;
			public boolean test(pers p) { 
				j++;
				p.getAge();
				return true; 
			}
		}
		);

		pers.pp(1, new age1());
		pers.pp(1, new select() {
			public boolean test(pers p) { return p.getAge() < 32; }
		}
		);
		
		pers.pp(1,(pers p) -> { 			// Lambda Expression
			boolean b = p.getAge() > 32;
			return b;
		});

		pers.pp(1, new age2());	
	}
}