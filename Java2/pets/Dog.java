public class Dog implements Animal {   
   private String name;
   
   public Dog (String name) {
      this.name = name;
   }
    public String getName() {
      return name;
   }
   public String makeSound() {
      return "woof";
   }
   public String toString() {
      return name+ " the dog";
   }
   
}
