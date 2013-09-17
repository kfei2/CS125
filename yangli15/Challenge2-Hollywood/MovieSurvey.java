//UIUC CS125 FALL 2013 MP. File: MovieSurvey.java, CS125 Project: Challenge2-Hollywood, Version: 2013-09-17T10:27:34-0500.202751508
/**
 * A program to run a simple survey and report the results. See MovieSurvey.txt
 * for more information. TODO: add your netid to the line below
 * 
 * @author yangli15
 */
public class MovieSurvey {
	public static void main(String[] arg) {
		//introduction
		TextIO.putln("Welcome. We're interested in how people are watching movies this year.");
		TextIO.putln("Thanks for your time. - The WRITERS GUILD OF AMERICA.");
		TextIO.putln("Please tell us about how you've watched movies in the last month.");
		
		//asks movie number questions
		TextIO.putln("How many movies have you seen at the cinema?");
		TextIO.putln("How many movies have you seen using a DVD or VHS player?");
		TextIO.putln("How many movies have you seen using a Computer?");
		
		//stores the inputs in the variables, and calculates total number of movies
		int cinema = TextIO.getlnInt();
		int player = TextIO.getlnInt();
		int computer = TextIO.getlnInt();
		int total = cinema + player + computer;
		double atCinema = (((double)cinema) / ((double)total)) * 100.0;
		double outsideCinema = 100.0 - atCinema;
		
		//prints the output.
		TextIO.putln("Summary: " + cinema + " Cinema movies, " + player + " DVD/VHS movies, " + computer + " Computer movies");
		TextIO.putln("Total: " + total + " movies");
		TextIO.put("Fraction of movies seen at a cinema: ");
		TextIO.putf("%.2f", atCinema);
		TextIO.putln("%");
		TextIO.put("Fraction of movies seen outside of a cinema: ");
		TextIO.putf("%.2f", outsideCinema);
		TextIO.putln("%");
	}
}
