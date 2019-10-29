import java.util.*;

public class SetExamples {

   public static void main (String[] args) {
   
      Set<Integer> mySet = new HashSet<>();
      
      mySet.add(2);
      mySet.add(8);
      mySet.add(100);
      mySet.add(99);
      
      System.out.println(mySet);
      
      // for each loop
      for(int x : mySet) {
      
         System.out.println(x*x); 
      }
   }  
}
// sets 
   // are a collection, an interface, are unindexed, must use a for each loop, removal should not be done while iterating.