package PB02_Shapes;

public class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    protected void calculatePerimeter() {
        double perimeter = 2 * Math.PI* this.radius;
        super.setPerimeter(perimeter);
    }

    @Override
    protected void calculateArea() {
    double area = Math.PI * Math.pow(this.radius, 2);
    super.setArea(area);
    }

    public final double getRadius() {
        return radius;
    }
}
