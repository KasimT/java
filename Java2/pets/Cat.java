public class Cat implements Animal {
   private String name;
    
   public Cat (String name) {
      this.name = name;
   }
    public String getName() {
      return name;
   }
   
   public String makeSound() {
      return "meow";
   }
   public String toString() {
      return name+ " the cat";
   }
   
}
