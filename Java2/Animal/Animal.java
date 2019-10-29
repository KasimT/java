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
public class Animal {
    private String name;
    private int x;
    private int y;
    private int maxRange;
    
   public Animal() {
      x = 0;
      y = 0;
      name = "Rabit";
      maxRange = 10;
   }

      // constructor taking values for all fields

   public Animal(String name, int x, int y, int maxSpeed) {

      this.name = name;   
      this.x = x;    
      this.y = y;     
      if (maxRange < 2 || maxRange > 5) {
      maxRange = 2; // if max speed provided is invalid, using a default value 2
      }
      this.maxRange = maxRange;
   }

// getter methods

   public int getX() {
         return x;
   }

   public int getY() {
         return y; 
   }

   public String getName() {  
         return name;   
   }

   public String toString() {   
         return name + " at (" + x + "," + y + ")";   
   }

/* 
 * @parem returns true if two animals are in same spot
 */

   public boolean touching(Animal other) { 
         return this.x == other.x && this.y == other.y;   
   }

/* 
 * @parem moves the animal in a random direction
 */ 

   public void move() {
      int units = (int) (Math.random() * maxRange) + 1; // generating random number of spaces to move (between 1 and maxSpeed)

   // generating a random direction (0-right,1-left,2-up,3-down)
      int dir = (int) (Math.random() * 4);
      if (dir == 0) {
         x += units;// moving right
      } 
      else if (dir == 1) {
         x -= units;// moving left
      } 
      else if (dir == 2) {
         y -= units;// moving up
      } 
      else {
         y += units;// moving down
      }

   }

}