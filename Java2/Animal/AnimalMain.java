/**
* 
* Assignment #1
* Class: CS 145 Computer Science Java 2
* Instructor: Micheal Wood
* Assignment Practicing Objects and CLass
* @author Kasim Tiba
* @version 2.0 (Sept 30 2019)
*
*/
public class AnimalMain {
   public static void printAnimals(Animal animals[]) {
       for(Animal a: animals) {
         System.out.println(a);
      }
   }

// method to print all animals in an array (invokes toString())
   public static void main(String[] args) { 
      Animal animals[] = new Animal[5]; // creating an array of 5 animals   
      // initializing 5 animals  
      animals[0] = new Animal("Rabit", 0, 0, 0);  
      animals[1] = new Animal("Dog", 1, 1, 3);  
      animals[2] = new Animal("Cheetah", 2, 0, 5);  
      animals[3] = new Animal("Snail", 0, 2, 2);   
      animals[4] = new Animal("Deer", 1, 0, 4);
      
      // initializing counters 
      int fights = 0; 
      int rounds = 0;   
      System.out.println("Animals & Starting locations:"); // displaying animals & starting locations
      printAnimals(animals);  
      System.out.println("Fight started!");
      
      while (fights < 5) { // looping until at least 5 fights took place
         for (Animal a: animals) {  // moving all animals
            a.move();
         }
         rounds++;
         for (int i = 0; i < animals.length; i++) { // checking for fights (touching)
            for (int j = i + 1; j < animals.length; j++) {
               if (animals[i].touching(animals[j])) {  
                  fights++; // fight!
                  System.out.println("FIGHT: " + animals[i].getName() + " & " + animals[j].getName());
               }
            }
         }
         // displaying animals & locations
         printAnimals(animals);  
         System.out.println();
         System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+");  
         System.out.println();
         rounds++;
      }

/*
 at the end, displaying number of fights, rounds and final locations
 of each animal. Note: since the movements are random, sometimes it
 will take so much time to happen 5 fights
*/

      System.out.println("Total fights: " + fights);
      System.out.println("Number of rounds took: " + rounds);
      System.out.println("Animals & Ending locations:");
      printAnimals(animals);
   }

}