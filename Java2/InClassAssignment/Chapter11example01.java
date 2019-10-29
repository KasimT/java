import java.util.*;

public class Chapter11example01 {

   public static void main(String[] args ) {
   
      Set<String> theList = new HashSet<>();
      
      theList.add("abcd");
      theList.add("efgh");
      theList.add("ijkl");
      theList.add("mnop");
      
      theList.add("abc");
      theList.add("efg");
      theList.add("hij");
      
      theList.add("ab");
      theList.add("cd");
      
      theList.add("abcd123");
      
      Set<String> answerSet;
      
      answerSet = makeStringMap(theList);
      System.out.println(answerSet);
   }
   public static Set<String> makeStringMap(Set<String> initSet) {
   
      Map<Integer, Set<String>> theMap = new TreeMap<>();
      
      for(String x : initSet) {  
         int size = x.length();
         if (theMap.containsKey(size)) {//not first time
            theMap.get(size).add(x); // get set from map add new string to set
         
         }
         else {// first time
            Set<String> temp = new TreeSet<>();
            temp.add(x);
            theMap.put(size, temp); //ADD the size + the new set of string
         }
         // THE MAP is now built
         
      }
      //System.out.println("DEBUG" + theMap.toString()); 
      for (int i : theMap.keySet()) {
         System.out.println("There are " + theMap.get(i).size() + " words of length " + i +".");
      }
      // Find the biggest set
      int biggestSetSize = 0;// keep track of the biggest set
      int bestLength = 0; // Keep track if who has the biggest set
      for (int i : theMap.keySet() ) {
         if (theMap.get(i).size() > biggestSetSize ) {
            biggestSetSize = theMap.get(i).size();
            bestLength = i;
         }    
      }
      // Now have found the biggest set, and who it belongs too
      return theMap.get(bestLength);
   }
}