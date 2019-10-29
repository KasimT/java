import java.util.*;
import java.io.*;

public class FileExplorer {

   public static void main (String[] args) {
      System.out.println("What is the starting file/directory name.?");
      Scanner key = new Scanner(System.in);
      String fileName = key.nextLine();   
      File theFile = new File(fileName);
      
      if (!theFile.exists()) {
         System.out.println("Error");
      }
      else {
         filePrint(theFile);
      }
   }
   /** This method method prints off the name of file f or all the files in
    *  the directory id f is a directory and not a file
    *
    * @@param f the starting file/directory
    */
    
   public static void filePrint (File f) {
      filePrint(f, 0);
   }
   
   private static void filePrint (File f, int level) {
   // Recursive Pattern
   // base case is if f is a file, only print name than done
      for (int i = 0; i < level; i++)
         System.out.print(" ");
         
      System.out.println(f.getName());
      if (!f.isFile()) 
          for (File subF : f.listFiles()) 
            filePrint(subF, level + 1);      
   }
   
   
}












// List<> x = f.ListFiles();