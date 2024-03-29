//UIUC CS125 FALL 2013 MP. File: Winner.java, CS125 Project: Challenge1-DebugMe, Version: 2013-09-10T10:09:27-0500.634524579

/**
 * This program prints "a","b","c" depending on who has the highest score. The
 * given code may not be correct. Fix it and additional code to pass the unit
 * tests.
 * 
 * @see Winner-ReadMe.txt for details on how to complete this program.
 * @author yangli15
 * 
 */
public class Winner {
	public static void main(String[] args) {
		System.out.println("Enter three unique integer scores.");

		int a = TextIO.getlnInt();
		int b = TextIO.getlnInt();
		int c = TextIO.getlnInt();

		TextIO.put("1st Place:");
		if(a>b && a>c)
			TextIO.put("a");
		else if(b>a && b>c)
			TextIO.put("b");
		else
			TextIO.put("c");
	}
}
