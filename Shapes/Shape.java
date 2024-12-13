
package Shapes;

public abstract class Shape {
    public abstract double area();
    public abstract String getDescription();

    public void printInfo() {
        System.out.println(getDescription());
        System.out.println("Area: " + area() + " square units\n");
    }
}