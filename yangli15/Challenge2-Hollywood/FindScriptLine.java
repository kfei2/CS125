//UIUC CS125 FALL 2013 MP. File: FindScriptLine.java, CS125 Project: Challenge2-Hollywood, Version: 2013-09-17T10:27:34-0500.202751508
/**
 * A program to search for specific lines and print their line number.
 * See FindScriptLine.txt for more details
 * TODO: add your netid to the line below
 * @author yangli15
 */
public class FindScriptLine {

	public static void main(String[] args) {
		boolean output = false;
		String input = "";
		int lineNum = 0;
		
		TextIO.putln("Please enter the word(s) to search for");
		input = TextIO.getln();
		String fixedInput = input.toLowerCase();
		TextIO.putln("Searching for '" + input + "'");
		
		TextIO.readFile("thematrix.txt"); //reads the script.
		
		while(TextIO.eof() == false)
		{
			lineNum++;
			String line = TextIO.getln();
			if(line.equals(""))
				output = false;
			
			if(line.toLowerCase().indexOf(fixedInput) >= 0)
				output = true;
			
			if(output)
			{
				String isOkay = line.trim();
				TextIO.putln(lineNum + " - " + isOkay);
				output = false;
			}
		}
		TextIO.putln("Done Searching for '" + input + "'");
// TODO: Implement the functionality described in FindScriptLine.txt
// TODO: Test your code manually and using the automated unit tests in FindScriptLineTest		
	}
}
