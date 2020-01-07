package observableByDelegation;
/**
 * Author:  Matthew Stachowski
 */

/**
 * A generic observer which a class can implement when it wants to be informed
 * of changes in observable objects.
 * 
 * @param <T>
 *            the type of object being observed
 * @param <U>
 *            the type of the optinal data argument
 * 
 * @see ObservableHelper
 */
public interface Observer<T, U> {
  /**
   * This method is called whenever the observed object is changed.
   * 
   * @param sender
   *            the object which was the source of the notification.
   * @param data
   *            an optional data parameter which encapsulates any additional
   *            data about the event
   */
  void update(T sender, U data);
}
