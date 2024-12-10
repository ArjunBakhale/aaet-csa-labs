public class Hamster extends Pet {
    private int speed;

    public Hamster(String name, int age, int speed) {
        super(name, age);
        this.speed = speed;
    }

    @Override
    public String makeSound() {
        return "Squeak!";
    }

    @Override
    public String getFavoriteActivity() {
        return "Running on hamster wheel";
    }

    public void run() {
        System.out.println(getName() + " is running!");
    }
}