/* 
 * Class Grammar is the class that handles most of functionality that goes behind making the GrammarMain program. 
 * This class is constructed using recursion and a lot of helper functions to match a recursive grammar that generates a sentence based on user input.
 *  @author Kasim Tiba
 *  @version 2.0
 */
import java.io.*;
import java.util.*;

public class GrammarSolver {   
    
   Map<String,List<String>> grammarMap = new TreeMap<>();	
	List<String> nonterminals = new ArrayList<>();	
	List<String> terminals = new ArrayList<>();	
	List<String> original;
  
/**
   * The main constructor for this class
	* @param RULES is a list of strings that contains the contents of the file
   * @throws illegal argument exception if the list is null or the list does not contain any elements
   * @throws illegal argument exception if the list contains the same non-terminal for more than 1 element.
*/     
   public GrammarSolver(List<String> RULES) {
      if(RULES.size() == 0 || RULES == null)
         throw new IllegalArgumentException(); 
      
      int index;
      String symbol;
      
      for(int i = 0; i< RULES.size(); i++) {  
         index = 0;
         symbol = "";
         
         while(RULES.get(i).charAt(index) != ':') {
            symbol += RULES.get(i).charAt(index);
            index++;
         }
         nonterminals.add(symbol.trim());
      }
      
      for(int i = 0; i < nonterminals.size(); i++) {     
         for(int j = i + 1; j < nonterminals.size(); j++)
            if(nonterminals.get(i).equals(nonterminals.get(j)))
               throw new IllegalArgumentException(); 
      }
         original = RULES;          
         String line;
         int indx;
         
         for(int i = 0 ; i < original.size(); i++) {
            indx = 0;
            line = original.get(i);
            
            while(line.charAt(indx) != '=') {
               indx++;
			   }
			   terminals.add(line.substring(indx + 1));
        }
   
      convertGrammarMap();
   }
   
/**
   * The converGrammarMap function store the contents of the grammar into a Map.
	* So the non-terminal symbols become keys and their rules become values.
	* @param String symbol is the non-terminal requested by the user
*/      
   public void convertGrammarMap() {
      String rule;
      
      for(int i = 0; i < nonterminals.size(); i++) {
      
         String symbol = nonterminals.get(i);
         String[] lineArr = terminals.get(i).split("[|]");    
         
         String line = key(lineArr);
         	 

         for(int j = 0; j < lineArr.length; j++) {
            rule = lineArr[j].trim();

            if(grammarMap.containsKey(symbol))
               grammarMap.get(symbol).add(rule);
               
            else {
               List<String> rules = new ArrayList<>();
               rules.add(rule);
               grammarMap.put(symbol, rules);
            }
         }
      }
      System.out.println("MAP!!!!! " + grammarMap);
   }
   
/**
   * The method converts a string array to a string
   * @param String[] line is a string array created using the .split() method
   * @returns a string comprising of the array's contents
*/    
   public String key (String[] line) {
      String returnString = "";
      for(int j = 0; j < line.length; j++)
			   returnString+=line[j]+" ";           
      return returnString.trim(); 
   }
   
/**
   * The contains function checks to see if the list of non-terminals contains the terminal requested by the user
   * @param String symbol is the non-terminal requested by the user
   * @throws an illegal argument exception if the symbol does not have any characters or if the symbol is null
   * @returns boolean indicating whether or not the symbol is in the list of non terminals
*/ 
	public boolean contains(String Symbol) {
		if(Symbol.length() == 0 || Symbol == null)
			throw new IllegalArgumentException("Not a proper symbol");
		return nonterminals.contains(Symbol);
	}
   
/**
   * The getSymbols converts the non-Terminal list into a sorted
   * TreeSet and returns that set
   * @returns sorted TreeSet of non-Terminals
*/ 
	public Set <String> getSymbols() {
		Set<String> nonTerminalSet = new TreeSet<>(nonterminals);	
		return nonTerminalSet;
	}
 
/**
   * This Method Generate a random occurence of the given Symbol
   * @throws an illegal argument exception if the symbol does not have any characters or if the symbol is null
   * @param String Symbol is the non-terminal requested by the user
   * @returns a generated string with a random occurrence of the given symbol
*/
   public String generate (String Symbol) {
      if(Symbol == null || Symbol.length() == 0)
			throw new IllegalArgumentException("Symbol cannot be null or empty!!");
		
		if(!grammarMap.containsKey(Symbol))
			return Symbol;
		
		Random rand = new Random(); 
      int size = grammarMap.get(Symbol).size();
      
      String rule = grammarMap.get(Symbol).get(rand.nextInt(size)+0);
       
      String[] rulesSplit = rule.split("[ \t]+");
      String sentence = ""; 
      
      for (int i = 0; i < rulesSplit.length; i++) 
         sentence += " "+ generate(rulesSplit[i]) ; 
         
      return sentence.trim();
	}
      
   
  

}