import java.sql.SQLOutput;

public class PetDemo {
    public static void main(String[] args) {
        Dog dog = new Dog("Ankit", 1, "Golden Retriever");
        Bird bird = new Bird("Brid", 11, "Sparrow");
        Cat cat = new Cat("Vikram", 239, false);
        Hamster hamster = new Hamster("Arjun", 17, 400);

        System.out.println("=== Pet Information ===");
        System.out.println(dog.getInfo());
        System.out.println(bird.getInfo());
        System.out.println(cat.getInfo());
        System.out.println(hamster.getInfo());


        System.out.println("\n=== Pet Sounds ===");
        System.out.println(dog.getName() + " says: " + dog.makeSound());
        System.out.println(bird.getName() + " says: " + bird.makeSound());
        System.out.println(cat.getName() + " says: " + cat.makeSound());
        System.out.println(hamster.getName() + " says: " + hamster.makeSound());

        System.out.println("\n=== Favorite Activities ===");
        System.out.println(dog.getName() + " loves " + dog.getFavoriteActivity());
        System.out.println(bird.getName() + " loves " + bird.getFavoriteActivity());
        System.out.println(cat.getName() + " loves " + cat.getFavoriteActivity());
        System.out.println(hamster.getName() + " loves " + hamster.getFavoriteActivity());

        System.out.println("\n=== Special Actions ===");
        dog.fetch();
        bird.fly();
        cat.scratch();
        hamster.run();



    }
}
