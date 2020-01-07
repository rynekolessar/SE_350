package observableByDelegation;
/**
 * Author:  Matthew Stachowski
 */

import java.util.ArrayList;
import java.util.List;

/**
 * A helper class which can be used to manage an object's observers.
 * 
 * @param <T>
 *            the type of object being observed
 * @param <U>
 *            the type of the optional data argument
 * 
 * @see Observer
 */
public final class ObservableHelper<T, U> {
  private final T observed;
  private final List<Observer<T, U>> observers;
  private boolean changed = false;
  
  /**
   * Initializes a new instance of the {@link ObservableHelper} class with
   * zero observers.
   * 
   * @param observed
   *            the object being observed
   * @throws IllegalArgumentException
   *             if observed is <code>null</code>
   */
  public ObservableHelper(T observed) {
    if (observed == null)
      throw new IllegalArgumentException("observed cannot be null");
    this.observed = observed;
    this.observers = new ArrayList<Observer<T, U>>();
  }
  
  /**
   * Adds an observer to the set of observers for the observed object,
   * provided that it is not the same as some observer already in the set.
   * 
   * @param observer
   * @throws IllegalArgumentException
   *             if the parameter observer is <code>null</code>
   */
  public void addObserver(Observer<T, U> observer) {
    if (observer == null)
      throw new IllegalArgumentException("observer cannot be null");
    if (!observers.contains(observer)) {
      observers.add(observer);
    }
  }
  
  /**
   * Indicates that the observed object has no longer changed, or that it has
   * already notified all of its observers of its most recent change, so that
   * {@link #hasChanged()} will now return <code>false</code>. This method
   * is called automatically by the {@link #notifyObservers} methods.
   * 
   */
  public void clearChanged() {
    changed = false;
  }
  
  /**
   * Returns the number of observers of observed object.
   * 
   * @return the number of observers of observed object
   */
  public int countObservers() {
    return observers.size();
  }
  
  /**
   * Deletes an observer from the set of observers. Passing <code>null</code>
   * to this method will have no effect.
   * 
   * @param observer
   *            the {@link Observer} to be deleted
   */
  public void deleteObserver(Observer<T, U> observer) {
    observers.remove(observer);
  }
  
  /**
   * Clears the observer list so that the observed object no longer has any
   * observers.
   */
  public void deleteObservers() {
    this.observers.clear();
  }
  
  /**
   * Returns <code>true</code> if the observed object has changed;
   * otherwise, <code>false</code>.
   * 
   * @return <code>true</code> if the observed object has changed;
   *         otherwise, <code>false</code>
   */
  public boolean hasChanged() {
    return changed;
  }
  
  /**
   * If this object has changed, as indicated by the {@link #hasChanged()},
   * then notify all of its observers and then clear the changed state. This
   * method is equivalent to calling <code>notifyObservers(null)</code>.
   */
  public void notifyObservers() {
    notifyObservers(null);
  }
  
  /**
   * If this object has changed, as indicated by the {@link #hasChanged()},
   * then notify all of its observers and then clear the changed state.
   * 
   * @param data
   *            optional event specific data which will be passed to the
   *            observers
   */
  public void notifyObservers(U data) {
    if (hasChanged()) {
      for (Observer<T, U> observer : observers) {
        observer.update(observed, data);
      }
      clearChanged();
    }
  }
  
  /**
   * Flags the observed object as having changed.
   */
  public void setChanged() {
    changed = true;
  }
}
