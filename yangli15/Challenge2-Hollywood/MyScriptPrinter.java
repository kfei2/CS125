//UIUC CS125 FALL 2013 MP. File: MyScriptPrinter.java, CS125 Project: Challenge2-Hollywood, Version: 2013-09-17T10:27:34-0500.202751508
/**
 * A program to print one actor's lines. 
 * See ScriptPrinter.txt for more information.
 * TODO: add your netid to the line below
 * @author yangli15
 */
public class MyScriptPrinter {
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		boolean output=false; //Set to true when we find the desired character
		String name=""; // Only print lines for this character
		
		TextIO.putln("Which character's lines would you like? (NEO,MORPHEUS,ORACLE)");
		name = TextIO.getln().toUpperCase();

		TextIO.readFile("thematrix.txt"); // stop reading from the keyboard- use the script

		TextIO.put(name);//TODO: Print the name here (see ScriptPrinter.txt example output for format)
		TextIO.putln("'s lines:");
		output = false; // initially don't print anything

		// This loop will read one line at a time from the script until it
		// reaches the end of the file and then TextIO.eof() will return true.
		// eof means end-of-file
		while (false == TextIO.eof()) {
			String line = TextIO.getln(); // Read the next line
			//TODO: If it's a blank line set 'output' to false		
			if(line.equals(""))
				output = false;	
			//TODO: Correct the output format (see ScriptPrinter.txt example output)
			
			//TODO: Re-order the three if statements so the output is correct

			if (line.indexOf(name) >= 0)
				output = true; // We found the character's name, time to printing their lines

			if (output)
			{
				String isOkay = line.trim().replaceFirst(name,"");
				if(!isOkay.equals(""))
					TextIO.putln(name + ":" + "\""+ isOkay + "\""); // Only print the line if 'output' is true
			}
		}
		TextIO.put("---");//TODO: Print 3 dashes here to indicate processing is complete
	}

}
