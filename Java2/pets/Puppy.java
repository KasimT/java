public class Puppy extends Dog {
    
   public String getname() {
      return name;
   }
   public Puppy (String name) {
      super(name);
   }
   public String toString() {
      return super.getName()+" the puppies";
   }
}