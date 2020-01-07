package delegateObserver;
public class Main {
	
	public static void main ( String args[]){
		CounterObj co = new CounterObj();
		co.addObserver ( new CounterObserver () );
		co.inc();
		co.inc();
		co.inc();
	}

}
