//UIUC CS125 FALL 2013 MP. File: LinkedList.java, CS125 Project: Challenge6-RecursionSee, Version: 2013-11-05T17:51:57-0600.490903127
/**
 * @author yangli15
 *
 */
public class LinkedList {
	// Get and Set methods are NOT necessary!

	private LinkedList next;
	private final String word;
	
	/** Constructs this link.
	 * @param word ; a single word (never null).
	 * @param next ; the next item in the chain (null, if there are no more items).
	 */
	public LinkedList(String word, LinkedList next) {
		this.word = word;
		this.next = next;
	}

	/**
	 * Converts the entire linked list into a string representation.
	 */
	public String toString() {
		if (next == null)
			return word;// BASE CASE; no more recursion required

		// Recursive case:
		String restOfString = next.toString(); // Forward Recursion
		return word + ";" + restOfString;
	}

	/**
	 * Returns the number of entries in the linked list.
	 * @return number of entries.
	 */
	public int getCount() {
		if (next == null)
			return 1; // BASE CASE; no more recursion required!
		// Recursive case:
		else
			return 1 + next.getCount(); // Forward recursion
	}
	
	/** Creates a new LinkedList entry at the end of this linked list.
	 * Recursively finds the last entry then adds a new link to the end.
	 * @param word
	 */
	public void append(String word) {
		if(next == null)
			this.next = new LinkedList(word, null);
		else
			next.append(word);
	}
	/**
	 * Recursively counts the total number of letters used.
	 * 
	 * @return total number of letters in the words of the linked list
	 */
	public int getLetterCount() {
		if(next == null)
			return word.length();
		else
			return word.length() + next.getLetterCount();
		// returns the total number of letters. word1.length() +
		// word2.length()+...
		// "A" -> "CAT" -> null returns 1 + 3 = 4.
	}

	/**
	 * Recursively searches for and the returns the longest word.
	 * @return the longest word i.e. word.length() is maximal.
	 */
	public String getLongestWord() {
		// recursive searches for the longest word
		if(next == null)
			return word;
		if(this.word.length() > next.getLongestWord().length())
			return this.word;
		else
			return next.getLongestWord();
	}

	/** Converts linked list into a sentence (a single string representation).
	* Each word pair is separated by a space.
	* A period (".") is appended after the last word.
	* The last link represents the last word in the sentence.*/
	public String getSentence() {
		if(next == null)
			return this.word + ".";
		else
			return word + " " + next.getSentence();
	}
	
	/**
	 * Converts linked list into a sentence (a single string representation).
	 * Each word pair is separated by a space. A period (".") is appended after
	 * the last word. The last link represents the first word in the sentence
	 * (and vice versa). The partialResult is the partial string constructed
	 * from earlier links. This partialResult is initially an empty string. 
	 */
	public String getReversedSentence(String partialResult) {
		if(next == null)
			return word + partialResult + ".";
		else
			return next.getReversedSentence(" " + word + partialResult);
	}
	

	/** Creates a linked list of words from an array of strings.
	 * Each string in the array is a word. */
	public static LinkedList createLinkedList(String[] words) {
		if(words.length == 0)
			return null;
		else
		{
			String[] newWords = new String[words.length-1];
			for(int i = 1; i < words.length; i++)
				newWords[i-1] = words[i];
			return new LinkedList(words[0], createLinkedList(newWords));
		}
	}

	/**
	 * Searches for the following word in the linked list. Hint: use .equals not ==
	 * to compare strings.
	 * 
	 * @param word
	 * @return true if the linked list contains the word (case sensivitive)
	 */
	public boolean contains(String word) {
		if(next == null)
			return this.word.equals(word);
		else
			return this.word.equals(word) || next.contains(word);
	}

	/** Recursively searches for the given word in the linked list.
	 * If this link matches the given word then return this link.
	 * Otherwise search the next link.
	 * If no matching links are found return null.
	 * @param word the word to search for.
	 * @return The link that contains the search word.
	 */
	public LinkedList find(String word) {
		if(!this.word.equals(word) && next == null)
			return null;
		if(this.word.equals(word))
			return this;
		else
			return next.find(word);
	}

	/**
	 * Returns the last most link that has the given word, or returns null if
	 * the word cannot be found.
	 * Hint: Would forward recursion be useful?
	 * @param word the word to search for.
	 * @return the last LinkedList object that represents the given word, or null if it is not found.
	 */
	public LinkedList findLast(String word) {
		if(next == null)
		{
			if(this.word.equals(word))
				return this;
			else
				return null;
		}
		
		LinkedList result =next.findLast(word);
		if(result != null)
			return result;
		if(this.word.equals(word))
			result = this;
		return result;
			
	}

	public LinkedList insert(String string) {
		if(string.compareTo(this.word) < 0)
			return new LinkedList(string, this);
		if(next == null)
		{
			this.next = new LinkedList(string, null);
			return this;
		}
		this.next = next.insert(string);
		return this;
	}

}
