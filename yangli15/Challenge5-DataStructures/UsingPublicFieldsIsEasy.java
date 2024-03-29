//UIUC CS125 FALL 2013 MP. File: UsingPublicFieldsIsEasy.java, CS125 Project: Challenge5-DataStructures, Version: 2013-10-14T16:24:13-0500.541025911
/**
 * Complete the class method 'analyze' that takes a SimplePublicPair object as an argument
 * and returns a new SimplePublicTriple object.
 * The SimplePublicTriple needs to set up as follows:
 * x = the minimum value of 'a' and 'b'
 * y = the maximum value of 'a' and 'b'
 * description:a*b=M 
 *   where a,b, and M are replaced with the numerical values of a, b and the multiplication of a and b.
 * Your code will create a SimplePublicTriple, initializes the three fields and return a reference to the SimplePublicTriple object.
 *@author yangli15
 */
public class UsingPublicFieldsIsEasy {
	
	public static SimplePublicTriple analyze(SimplePublicPair in) {
		int x;
		int y;
		int M = in.a * in.b;
		
		if(in.a < in.b)
		{
			x = in.a;
			y = in.b;
		}
		else
		{
			x = in.b;
			y = in.a;
		}
		
		SimplePublicTriple newItem = new SimplePublicTriple();
		newItem.x = x;
		newItem.y = y;
		newItem.description = in.a + "*" + in.b + "=" + M;
		
		return newItem;
	}
}
