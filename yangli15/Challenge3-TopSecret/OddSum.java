//UIUC CS125 FALL 2013 MP. File: OddSum.java, CS125 Project: Challenge3-TopSecret, Version: 2013-09-21T12:24:57-0500.390883635
/**
 * Prints sum of odd numbers in a specific format.
 * TODO: add your netid to the line below
 * @author yangli15
 */
public class OddSum { 
/**
Example output if user enters 10:
Max?
1 + 3 + 5 + 7 + 9 = 25
25 = 9 + 7 + 5 + 3 + 1

Example output if user enters 11:
Max?
1 + 3 + 5 + 7 + 9 + 11 = 36
36 = 11 + 9 + 7 + 5 + 3 + 1

 */
 public static void main(String[] args) { 
	 
	 String output = "";
	 
	 int input = TextIO.getlnInt();
	 int currentNum = 1;
	 int total = 0;
	 TextIO.putln("Max?");
	 
	 while(currentNum <= input-2)
	 {
		 output += (currentNum + " + ");
		 total += currentNum;
		 currentNum += 2;
	 }
	 
	 if(input % 2 == 0)
	 {
		 output += (input-1);
		 total += input-1;
	 }
	 else
	 {
		 output += (input);
		 total += input;
	 }
	 output += (" = " + total);
	 
	 TextIO.putln(output);
	 
	 TextIO.put(total + " = ");
	 while(currentNum > 2)
	 {
		 TextIO.put(currentNum + " + ");
		 currentNum -= 2;
	 }
	 TextIO.put(1);
  } // end of main method
} // end of class 
