/*Assignment #5
Class: CS 141 Computer Science Java 1
Instructor: Seunghye Jang
Name: Kasim Tiba
This Program is interactive program where you decide the size and character of the triangle, 
this program use Scanner and for loops to operate it. */

import java.util.*; //this allowed the program to run  the scanner.
public class Assignment5 { //name of the class.
   public static void main(String [] args) { // the main method tells the program to print the triangle
   //once the user input the size and character. 
     Scanner console = new Scanner(System.in);//create the scanner called console (basic i know).
     System.out.println("Enter triangle size: ");//
     int size = console.nextInt();
     System.out.println("Enter the fill character: ");
     String character = console.next();
  for (int i=1; i<=size; i++) { //this loop is design so the amount line it print is determine 
   //by the size of the triangle the user input so no greater than the size.
      for(int j=(size-i); j>=0; j--){ //this loop is also adjusted so the amount of space to the left is also determine 
   //by the size of the triangle and decreased accordingly.
         System.out.print(" "); //the space that is printed.
      } //end of second loop.
      for(int k=1; k<=((i*2)-1); k++){ //this loop is design to print the charater that the user inputed and increase accordingly
         System.out.print(character);  //this print the user character input.
      } //end of third loop.
      for(int l=(size-i); l<=0; l++) { //this loop is also adjusted so the amount of space to the right is also determine 
   //by the size of the triangle and increase accordingly.
         System.out.print(" "); //the space that is printed.
      } //end of fourth loop.
         System.out.println();// line breaker.
    } //end of first loop.
    } //end of main method.
    } //end of class.
//end of program.