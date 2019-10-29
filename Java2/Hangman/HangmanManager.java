/* 
 * Class HangmanManger is the class that handles most of the functionality that goes behind making the game. 
 * This class help the computer generate a new word from a list of words everytime the user picks a new letter.
 * @author Kasim Tiba
 * @version 2.0
 */
import java.util.*;

public class HangmanManager {
   private int length;
   private int MAX;
   private String word; 
   private String pattern = " ";	
   private Set<String>Words;
   private SortedSet<Character>IGuessed = new TreeSet<>();	
   private Map<String,Set<String>> PatternMap = new TreeMap<>();
   

/**
   * The main constructor for this class
   * @param Dictionary is an empty list of strings that will be filled using the retrieve words method
   * @param length is a designated length for a word which is chosen by the user
   * @param MAX is the max amount of guesses that a user can have before the program ends
*/  		
   public  HangmanManager (List<String>Dictionary,int length,int MAX) { 
      this.MAX = MAX;
      this.length = length;
      if(length < 1 || MAX < 0) {
         throw new IllegalArgumentException();
      }
      Words = retrieveWords(Dictionary,length);
      for(int i = 0;i<length;i++) {
         pattern+="-";
      }          		
   }     
		   
/**
   * The client calls this method to get access to the current set pf word
   * @return the set of words back to the HangmanManger
*/ 	
   public Set<String>words() {
      return Words;
   }
   
/**
   * The client calls this method to find out how many guesses the player has left.
   * @return the number of guesses left to the user
*/ 	
   public int guessesLeft() {
      return MAX;
   }

	
/**
   *The client calls this method to find out the current set of letters that have been guessed by the user.
   * @return the set of letters guessed by the user
*/ 
   public SortedSet<Character>guesses() {
      return IGuessed;
   }
 
   
/**
   * This method returns the pattern of characters guessed successfully
   * @return pattern guessed successfully i.e "--e-a"
*/ 
   public String pattern() {
      return pattern;
   }

/**
   * This method retrieves a list of words from a text file based on the number of characters in the word and places them into a list.
   * @param dictionary is an empty list of strings 
   * @param length is a designated length for a word 
   * @return A list filled with words that have the designated length 
*/
   public Set<String> retrieveWords(List<String> dictionary, int length) {	
      Set<String> returnSet = new TreeSet();	
      
      for(int i = 0;i<dictionary.size();i++) {
         if(dictionary.get(i).length() == length) {
            returnSet.add(dictionary.get(i));
         }
      }	
      return returnSet;      
   }
   
/**
   * This method gets called when there is only one word in the words set
*/ 	
   public void setWord() {
      for(String x : Words)
         word = x;
   }
     
/**
   *This method checks to see how may times the letter guessed by the user occurs in the game
   * and also updates the displayed on the game screen
   * @param c is the character guessed by the user
   * @return the number of instances that character appears in the word
*/ 
   public int record(char c) {   
      if(MAX < 1) {
         throw new IllegalStateException();
      }
      else if (Words.isEmpty()) {
         throw new IllegalStateException();
      }
      else if(IGuessed.contains(c)) {
         throw new IllegalArgumentException();
      }
      else {
         MAX--;		
         IGuessed.add(c);
      }		
      if(Words.size() == 1) {
         setWord();					
      }
      patternTree(c); 
      return Occurence(c);
   }
   
/**
   *This method checks to see how may times the letter guessed by the user 
   * @param c is the character guessed by the user
   * @return the number of instances that character appears in the word
*/   
   public int Occurence(char c) {
      int count = 0;			
      for(int i = 0;i<pattern.length();i++) {
         if(pattern.charAt(i) == c) {
            count++;
         }
      }		
      return count;
   }
       
/**
   * This method uses a Map to associate family patterns with the set of words that have each pattern. 
   * If there is a tie you should pick the word that occurs earlier in the Map 
   * @param c is the character guessed by the user
*/ 
   public void patternTree(char c) {
      for(String x: Words) {
         Set<String> valueSet = new HashSet<>();
         if(x.contains(""+c)) {
            String keyPattern = "";
            for(int i = 0;i<x.length();i++)  {
               if(x.charAt(i)!=c) {
                  keyPattern+='-';
               }
               else {
                  keyPattern+=c;
               }
            }
            if(!PatternMap.containsKey(keyPattern)) {
               valueSet.add(x);
               PatternMap.put(keyPattern, valueSet);
            }
            else {
               PatternMap.get(keyPattern).add(x);
            }
         }
         else {
            if(!PatternMap.containsKey(pattern())) {
               valueSet.add(x);
               PatternMap.put(pattern(), valueSet);
            }
            else {
               PatternMap.get(pattern()).add(x);
            }
         }
      }	
      resetWords();	
   }

/**
   * This method resets the set of words that the computer can pick from based on the 
	* key that has the set with the biggest size.
*/ 
	public void resetWords() {	
		int maxLength = 0;	
		String maxKey = "";		
		for(String x : PatternMap.keySet()) {
			if(PatternMap.get(x).size() > maxLength) {
				maxLength = PatternMap.get(x).size();
				maxKey = x;
			}
		}	
		pattern = maxKey;
		Words = PatternMap.get(maxKey);
		PatternMap = new HashMap<>();
	}

    
/**
   * This method resets the pattern displayed in the game
*/ 	
   public void resetPattern() {
      String temp = "";
      for(int i = 0;i<word.length();i++) {
         if(IGuessed.contains(word.charAt(i))) {
            temp+=word.charAt(i);
         }
         else {
            temp += "-";
         }     
      }  
      pattern = temp;
   }   
}