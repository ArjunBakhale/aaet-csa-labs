package Shapes;

public class ShapeCalculator {
    public static void printAllShapes(Shape[] shapes) {
        System.out.println("Shape Information:");
        for (Shape shape : shapes) {
            shape.printInfo();
        }
    }

    public static double getTotalArea(Shape[] shapes) {
        double totalArea = 0;
        for (Shape shape : shapes) {
            totalArea += shape.area();
        }
        return totalArea;
    }

    public static void main(String[] args) {
        Shape[] shapes = new Shape[] {
                new Circle(5.0),
                new Rectangle(4.0, 6.0),
                new Triangle(8.0, 3.0),
                new Circle(3.0),
                new Rectangle(5.0, 5.0)
        };

        printAllShapes(shapes);

        System.out.println("Total area of all shapes: " + String.format("%.2f", getTotalArea(shapes)) + " square units");
    }
}