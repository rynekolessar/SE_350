package delegateObserver;
import java.util.Observer;

class CounterObj implements Counter {

	private ObservableObj _oo;
	private int _i;
	/* (non-Javadoc)
	 * @see Counter#inc()
	 */
	CounterObj() { _oo = new ObservableObj(this); _i=0; } 
	public void addObserver (Observer o){ _oo.addObserver(o); }
	public void deleteObserver (Observer o){ _oo.deleteObserver(o); }
	public void inc() {
		_i++;
		_oo.setChanged();
		_oo.notifyObservers();
	}
	public int getI (){ return _i;};

}
