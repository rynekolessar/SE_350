package delegateObserver;
import java.util.Observable;

public class ObservableObj extends Observable {
	//_o is a reference to the object that contains the
	//Observable Obj
	//this class then should always be contained.
	private Object _o;
	public ObservableObj ( Object o){ _o = o; } 
	public void setChanged() { super.setChanged(); }
	public void clearChanged () { super.clearChanged(); }
	public Object getObj(){return _o;};
}
