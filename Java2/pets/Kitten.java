public class Kitten extends Cat {
   public String name;
     
   public String getname() {
      return name;
   }
    public Kitten (String name) {
      super(name);
   }
   public String toString() {
      return super.getName()+" the kitten";
   }
}