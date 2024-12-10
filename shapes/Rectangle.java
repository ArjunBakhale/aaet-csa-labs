public class Rectangle extends Shapes {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }

    @Override
    public String getDescription() {
        return "Rectangle with width " + width + " and height " + height;
    }
}