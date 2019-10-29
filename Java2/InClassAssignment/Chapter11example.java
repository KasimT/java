import java.util.*;

public class Chapter11example {

   public static void main(String[] args) {
   
      Set<Integer> theSet = new TreeSet<>();
      
      theSet.add(30);
      theSet.add(46);
      theSet.add(73);
      theSet.add(50);
      theSet.add(55);
      theSet.add(13);
      
      System.out.println(theSet);
      removeFromSet(theSet, 50);
      System.out.println(theSet);
   }
   
   public static void removeFromSet(Set<Integer> x, int min) {     

      Set<Integer> badNums = new TreeSet<>();
      for (int z : x) {
         if (z<min) 
            badNums.add(z);
      }
      x.removeAll(badNums);
      // for (int z : badNums) 
//          x.remove(z);     
   }
}