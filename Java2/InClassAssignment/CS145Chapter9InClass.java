public class CS145Chapter9InClass
{
   public static void main(String[] args)
   {
      Animal[] pets = new Animal[6];
      pets[0] = new Dog("Fred");
      pets[1] = new Dog("Ben");
      pets[2] = new Cat("Sue");
      pets[3] = new Cat("Julie");
      pets[4] = new Kitten("Maria");
      pets[5] = new Puppy("Lee");
 
      for(int i = 0; i < pets.length; i++)
      {
         System.out.print(pets[i]);
         System.out.println(" says " + pets[i].makeSound() );
      }
   }
}