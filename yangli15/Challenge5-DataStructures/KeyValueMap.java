//UIUC CS125 FALL 2013 MP. File: KeyValueMap.java, CS125 Project: Challenge5-DataStructures, Version: 2013-10-14T16:24:13-0500.541025911
//@author yangli15
import java.awt.Color;

public class KeyValueMap { // aka Dictionary or Map

	private String[] keys = new String[0];
	private Color[] colors = new Color[0];
	/**
	 * Adds a key and value. If the key already exists, it replaces the original
	 * entry.
	 */
	public void add(String key, Color value) {
		boolean found = false;
		for(int i = 0; i < keys.length; i++)
			if(keys[i].equals(key))
			{
				colors[i] = value;
				found = true;
			}
		if(!found)
		{
			String[] newKeys = new String[keys.length+1];
			for(int i = 0; i < keys.length; i++)
				newKeys[i] = keys[i];
			newKeys[keys.length] = key;
			keys = newKeys;
			
			Color[] newColors = new Color[colors.length+1];
			for(int i = 0; i < colors.length; i++)
				newColors[i] = colors[i];
			newColors[colors.length] = value;
			colors = newColors;
		}
	}

	/**
	 * Returns particular Color object previously added to this map.
	 */
	public Color find(String key) {
		for(int i = 0; i < keys.length; i++)
			if(key.equals(keys[i]))
				return colors[i];
		return null;
	}

	/**
	 * Returns true if the key exists in this map.
	 */
	public boolean exists(String key) {
		for(int i = 0; i < keys.length; i++)
			if(keys[i].equals(key))
				return true;
		return false;
	}

	/**
	 * Removes the key (and the color) from this map.
	 */
	public void remove(String key) {
		if(exists(key))
		{
			String[] newKeys = new String[keys.length-1];
			Color[] newColors = new Color[colors.length-1];
			
			int index = -1;
			for(int i = 0; i < keys.length; i++)
				if(keys[i].equals(key))
					index = i;
			
			if(index > -1)
			{
				for(int i = 0; i < index; i++)
				{
					newKeys[i] = keys[i];
					newColors[i] = colors[i];
				}
				
				for(int i = index + 1; i < keys.length; i++)
				{
					newKeys[i-1] = keys[i];
					newColors[i-1] = colors[i];
				}
			}
			
			keys = newKeys;
			colors = newColors;
		}
	}

}
