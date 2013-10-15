//UIUC CS125 FALL 2013 MP. File: Queue.java, CS125 Project: Challenge5-DataStructures, Version: 2013-10-14T16:24:13-0500.541025911
//@author yangli15
public class Queue {
	
	private double[] list = new double[0];
	
	/** Adds the value to the front of the queue.
	 * Note the queue automatically resizes as more items are added. */
	public void add(double value) {
		double[] newList = new double[list.length+1];
		newList[0] = value;
		
		for(int i = 0; i < list.length;i++)
			newList[i+1] = list[i];
		
		list = newList;
	}
	/** Removes the value from the end of the queue. If the queue is empty, returns 0 */
	public double remove() {
		if(list.length == 0)
			return 0;
		else
		{
			double endValue = list[list.length-1];
			double[] newList = new double[list.length-1];
			for(int i = 0; i < newList.length;i++)
				newList[i] = list[i];
			list = newList;
			return endValue;
		}
	}
	
	/** Returns the number of items in the queue. */
	public int length() {
		return list.length;
	}
	
	/** Returns true iff the queue is empty */
	public boolean isEmpty() {
		return length() == 0;
	}
	
	/** Returns a comma separated string representation of the queue. */
	public String toString() {
		if(isEmpty())
			return "";
		else
		{
			String output = "";
			output = output + list[list.length-1];
			for(int i = list.length-2; i > -1; i--)
				output = output + "," + list[i];
			return output;
		}
	}
}
