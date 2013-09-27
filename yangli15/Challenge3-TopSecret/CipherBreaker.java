//UIUC CS125 FALL 2013 MP. File: CipherBreaker.java, CS125 Project: Challenge3-TopSecret, Version: 2013-09-21T12:24:57-0500.390883635
/**
 * See CipherBreaker.txt for instructions.
 * TODO: add your netid to the line below
 * 
 * @author yangli15
 */
public class CipherBreaker {

	public static void main(String[] args) {
		
		char[] alphabet = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		char[] numbers = {'0','1','2','3','4','5','6','7','8','9'};
		int[] count = new int[26];
		int digits = 0;
		int spaces = 0;
		int punctuations = 0;
		
		TextIO.putln("Text?");
		String line = TextIO.getln();
		TextIO.putln(line);
		
		//letters
		for(int i = 0; i < line.length(); i++)
		{
			for(int j = 0; j < alphabet.length; j++)
			{
				if(Character.toUpperCase(line.charAt(i))==alphabet[j])
					count[j]++;
			}
		}
		
		//digits
		for(int i = 0; i < line.length();i++)
		{
			for(int j = 0; j < 10; j++)
				if(line.charAt(i)== numbers[j])
					digits++;
		}
		
		//spaces
		for(int i = 0; i < line.length();i++)
		{
			if(line.charAt(i)== ' ')
				spaces++;
		}
		
		//punctuations "-'.!,
		for(int i = 0; i < line.length(); i++)
		{
			if(line.charAt(i)==('\"') || line.charAt(i)=='-' || line.charAt(i)=='\'' || line.charAt(i)=='.' || line.charAt(i)=='!' || line.charAt(i)=='.' || line.charAt(i)==',')
				punctuations++;
		}
		
		for(int i = 0; i < count.length; i++)
		{
			if(count[i] > 0)
				TextIO.putln(String.valueOf(alphabet[i]) + ':' + count[i]);
		}
		
		if(digits > 0)
			TextIO.putln("DIGITS:" + digits);
		
		if(spaces > 0)
			TextIO.putln("SPACES:" + spaces);
		
		if(punctuations > 0)
			TextIO.putln("PUNCTUATION:" + punctuations);
}	}
