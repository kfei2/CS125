//UIUC CS125 FALL 2013 MP. File: GeocacheList.java, CS125 Project: Challenge5-DataStructures, Version: 2013-10-14T16:24:13-0500.541025911
/**
 * Complete the following GeocacheList, to ensure all unit tests pass.
 * There are several errors in the code below
 *
 * Hint: Get the Geocache class working and passing its tests first.
 */
public class GeocacheList {
	private Geocache[] data;
	private int size;

	public Geocache getGeocache(int i) {
		return data[i];
	}

	public int getSize() {
		return size;
	}

	public GeocacheList() {
		data = new Geocache[0];
		size = 0;
	}

	public GeocacheList(GeocacheList other, boolean deepCopy) {
		data = new Geocache[other.data.length];
		size = other.getSize();
		if(!deepCopy)
		{
			for(int i = 0; i < other.getSize(); i++)
				data[i] = other.data[i];
		}
		else
			for(int i = 0; i < data.length; i++)
			{
				data[i] = new Geocache(other.data[i]);
			}
	}

	public void add(Geocache p) {
		
		size++;
		if (size > data.length) {
			Geocache[] old = data;
			data = new Geocache[size * 2];
			for (int i = 0; i < old.length; i++)
				data[i] = old[i];
		}
		data[size-1] = p;
	}

	public Geocache removeFromTop() {
		if(size > 0)
		{
			size--;
			Geocache first = data[0];
			Geocache[] newList = new Geocache[data.length-1];
			for(int i = 0; i < newList.length; i++)
				newList[i] = data[i+1];
			data = newList;
			return first;
		}
		return null;
	}

	public String toString() {
		StringBuffer s = new StringBuffer("GeocacheList:");
		for (int i = 0; i < size; i++) {
			if (i > 0)
				s.append(',');
			s.append(data[i]);
		}
		return s.toString();
}	}
