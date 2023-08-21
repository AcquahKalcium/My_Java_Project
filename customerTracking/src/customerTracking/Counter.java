package customerTracking;

/**
 * A counter with methods for manipulating a count..
 * @author USER
 *
 */
public class Counter {
	
	//instance variables...
	/**
	 * internal count for counter.
	 */
	int count;
	
	//constructor
	public Counter(int initialCount) {
		this.setCount (initialCount); // call setCount with given initialCount...
	}
	
	//methods
	
	/**
	 * increments the internal count by 1
	 */
	public void increment() {
		this.count++;
	}
	
	/**
	 * Returns the internal count...
	 * @return count
	 */
	public int getCount() {
		return this.count;
	}
	
	public void  setCount(int count) {
		this.count = count;
	}
	
}
