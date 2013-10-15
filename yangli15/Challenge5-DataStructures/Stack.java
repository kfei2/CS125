//UIUC CS125 FALL 2013 MP. File: Stack.java, CS125 Project: Challenge5-DataStructures, Version: 2013-10-14T16:24:13-0500.541025911
//@author yangli15
public class Stack {
	
	String[] stack = new String[0];
	/** Adds a value to the top of the stack.*/
	
	public void push(String value){
		String[] newStack = new String[stack.length+1];
		newStack[0] = value;
		for(int i = 0; i < stack.length; i++)
			newStack[i+1] = stack[i];
		stack = newStack;
	}
	
	/** Removes the topmost string. If the stack is empty, returns null. */
	public String pop() {
		if(isEmpty())
			return null;
		else
		{
			String top = stack[0];
			String[] newStack = new String[stack.length-1];
			for(int i = 0; i < newStack.length; i++)
				newStack[i] = stack[i+1];
			stack = newStack;
			return top;
		}
	}
	
	/** Returns the topmost string but does not remove it. If the stack is empty, returns null. */
	public String peek() {
		if(isEmpty())
			return null;
		else
			return stack[0];
	}
	
	/** Returns true iff the stack is empty */
	public boolean isEmpty() {
		return length() == 0;
	}

	/** Returns the number of items in the stack. */
	public int length() {
		return stack.length;
	}
	
	/** Returns a string representation of the stack. Each string is separated by a newline. Returns an empty string if the stack is empty. */
	public String toString() {
		String output = "";
		if(length() > 0)
		{
			for(int i = 0; i < stack.length; i++)
				output = stack[i] + "\n" + output;
		}
		return output;
	}
}
