
package Shapes;

public abstract class Shapes {
    public abstract double area();
    public abstract String getDescription();

    public void printInfo() {
        System.out.println(getDescription());
        System.out.printf("Area: %.2f square units\n\n", area());
    }
}