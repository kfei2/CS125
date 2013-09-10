//UIUC CS125 FALL 2013 MP. File: Factorial.java, CS125 Project: Challenge1-DebugMe, Version: 2013-09-10T10:09:27-0500.634524579

/**
 * A program to calculate a factorial. The given code may contain errors. Fix the
 * given code and add additional code to calculate a factorial and pass the unit
 * tests. Hint sometimes an 'int' just 'aint big enough.
 * 
 * @see Factorial-ReadMe.txt for details on how to complete this program.
 * @author yangli15
 */
public class Factorial {
	public static void main(String[] args) {
		int max = 0;
		long total = 1;
		System.out.println("Enter a number between 1 and 20 inclusive.");
		while (max < 1 || max >= 21)
			max = TextIO.getlnInt();
		for(int i = 0; i < max; i++)
			total *= i+1;
		TextIO.putln(total);
	}
}
