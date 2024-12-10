

public class ShapeCalculator {
    public static void printAllShapes(Shapes[] shapes) {
        System.out.println("Shape Information:");
        for (Shapes shape : shapes) {
            shape.printInfo();
        }
    }

    public static double getTotalArea(Shapes[] shapes) {
        double totalArea = 0;
        for (Shapes shape : shapes) {
            totalArea += shape.area();
        }
        return totalArea;
    }

    public static void main(String[] args) {
        Shapes[] shapes = new Shapes[] {
                new Circle(5.0),
                new Rectangle(4.0, 6.0),
                new Triangle(8.0, 3.0),
                new Circle(3.0),
                new Rectangle(5.0, 5.0)
        };

        printAllShapes(shapes);

        System.out.printf("Total area of all shapes: %.2f square units\n",
                getTotalArea(shapes));
    }
}