import java.util.*;
import java.io.*;

public class InClassRecExample {

   public static void main (String[] args) {
      writeSquares(8);
      System.out.print(isPalindrome("yes"));
   
   }
   public static void writeSquares (int n) {
      if (n < 1) { // NOt positive square number
         System.out.print("");
      }
      if (n == 1) { // if interger is 1 print 1
         System.out.print(1+ " ");
         return;
      }
      if (n % 2 == 0) { // if number is divisible by two run method again with next interger and 
        writeSquares(n-1); //run method again with next decreasing number         System.out.print(n*n + " "); // square the number
      }
      else { // if number isn't divisible by two 
         System.out.print(n*n + " "); // square the number
         writeSquares(n-1);// run method again with next decreasing number
      } 
   }
   public static boolean isPalindrome ( String word) {
      if(word.length() < 2) { // Zero- or one-character string is a palindrome.
         return true;
      } 
      if(word.charAt(0)  == word.charAt(word.length()-1)){ //If first and last characters are same, it's a palindrome and we run the method again removing the first and last character
         word = word.substring(1, word.length() - 1);  
         return isPalindrome(word);
      }
      else if(word.charAt(0) != word.charAt(word.length()-1)) { //If first and last characters are different, it's NOT a palindrome
         return false;
      } 
      return isPalindrome(word); // Otherwise it's palindrome only if the sub string is palindrome.
   }
}