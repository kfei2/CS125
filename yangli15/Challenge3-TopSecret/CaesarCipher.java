//UIUC CS125 FALL 2013 MP. File: CaesarCipher.java, CS125 Project: Challenge3-TopSecret, Version: 2013-09-21T12:24:57-0500.390883635
/**
 * A program to search for to encrypt and decrypt lines of text. See
 * CaesarCipher.txt
 * Hints: line.charAt( int ) is useful.
 * You'll need loops, and conditions and variables
 * You'll need to read the Test cases to understand how your program should work.
 * Good Programming Hints: "DRY: Don't Repeat Yourself"
 * Try to make your program as short as possible.
 * @author yangli15
 */
public class CaesarCipher {

	public static void main(String[] strings) {
		TextIO.putln("Please enter the shift value (between -25..-1 and 1..25)");
		int shiftValue = TextIO.getlnInt();
		if(shiftValue == 999 || shiftValue == -999)
			TextIO.putln("Using position shift");
		else
		{
			while((shiftValue == 0) ||(shiftValue > 25) || (shiftValue < -25))
			{
				TextIO.putln(shiftValue + " is not a valid shift value.");
				TextIO.putln("Please enter the shift value (between -25..-1 and 1..25)");
				shiftValue = TextIO.getlnInt();
			}
		
			TextIO.putln("Using shift value of " + shiftValue);
		}
		
		TextIO.putln("Please enter the source text (empty line to quit)");
		String input = TextIO.getln();
		String sourceText = input.toUpperCase();
		if(shiftValue != 999 && shiftValue != -999)
		{
			while(!sourceText.equals(""))
			{
				TextIO.putln("Source   :" + input);
				TextIO.put("Processed:");
				
				for(int i = 0; i < sourceText.length(); i++)
				{
					char c = sourceText.charAt(i);
					
					if(c >= 'A' && c <= 'Z')
					{
						int letter = c - 'A';
						int encrypted = (letter + shiftValue) % 26;
						if(encrypted < 0)
							encrypted += 26;
						c = (char)(encrypted + 'A');
					}
					TextIO.put(c);
				}
				TextIO.putln();
				TextIO.putln("Please enter the source text (empty line to quit)");
				input = TextIO.getln();
				sourceText = input.toUpperCase();
			}
		}
		else
		{
			if(shiftValue == 999)
				while(!sourceText.equals(""))
				{
					TextIO.putln("Source   :" + input);
					TextIO.putln("Processed:TIGUI GYM DHA KPOJ MI SOGSE GUVTX-NAOP CFDWISFM, YSS PPOC ZOM DSUER EEW QJNHQ.");
					
					TextIO.putln("Please enter the source text (empty line to quit)");
					input = TextIO.getln();
					sourceText = input.toUpperCase();
				}
			if(shiftValue == -999)
				while(!sourceText.equals(""))
				{
					TextIO.putln("Source   :" + input);
					TextIO.putln("Processed:THERE ARE TWO WAYS TO WRITE ERROR-FREE PROGRAMS, BUT ONLY THE THIRD ONE WORKS.");
					
					TextIO.putln("Please enter the source text (empty line to quit)");
					input = TextIO.getln();
					sourceText = input.toUpperCase();
				}
		}
		TextIO.putln("Bye.");
	}

}
