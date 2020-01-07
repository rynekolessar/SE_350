package delegateObserver;
import java.util.Observable;
import java.util.Observer;
public class CounterObserver implements Observer {

	/* (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	public void update(Observable arg0, Object arg1) {
		CounterObj c = (CounterObj)((ObservableObj) arg0).getObj();
		new MessageBox ( "Counter Changed", Integer.toString(c.getI()));
	}

}
