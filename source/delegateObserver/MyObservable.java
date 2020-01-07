package delegateObserver;
import java.util.Observer;

public interface MyObservable {
	public void addObserver (Observer o);
	public void deleteObserver (Observer o);

}
