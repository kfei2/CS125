//UIUC CS125 FALL 2013 MP. File: PlayListUtil.java, CS125 Project: Challenge4-Photoscoop, Version: 2013-10-05T06:40:40-0500.341111555
/**
 * Add you netid here..
 * 
 * @author yangli15
 * 
 */
public class PlayListUtil {
	/**
	 * Debug ME! Use the unit tests to reverse engineer how this method should
	 * work. Hint: Fix the formatting (shift-cmd-F) to help debug the following
	 * code
	 * 
	 * @param list
	 * @param maximum
	 */
	
	public static void list(String[] list, int maximum) 
	{
		int max = maximum;
		if(maximum == -1)
			max = list.length;
		for (int i = 0; i < max; i++)
		{
			int j = i+1;
			TextIO.putln(j + ". " + list[i]);
		}
	}

	/**
	 * Appends or prepends the title
	 * 
	 * @param list
	 * @param title
	 * @param prepend
	 *            if true, prepend the title otherwise append the title
	 * @return a new list with the title prepended or appended to the original
	 *         list
	 */
	public static String[] add(String[] list, String title, boolean prepend) {
		String[] newList = new String[list.length + 1];
		if (prepend) {
			newList[0] = title;
			for (int i = 0; i < list.length; i++)
				newList[i + 1] = list[i];
		} else {
			for (int i = 0; i < list.length; i++)
				newList[i] = list[i];
			newList[newList.length - 1] = title;
		}
		return newList;
	}

	/**
	 * Returns a new list with the element at index removed.
	 * 
	 * @param list
	 *            the original list
	 * @param index
	 *            the array index to remove.
	 * @return a new list with the String at position 'index', absent.
	 */
	public static String[] discard(String[] list, int index) {
		String[] newList = new String[list.length-1];
		if(index > -1 && index < list.length)
		{
			for(int i = 0; i < index;i++)
				newList[i] = list[i];
			for(int i = index+1; i < list.length; i++)
				newList[i-1] = list[i];
			return newList;
		}
		else
			return list;
	}

}
