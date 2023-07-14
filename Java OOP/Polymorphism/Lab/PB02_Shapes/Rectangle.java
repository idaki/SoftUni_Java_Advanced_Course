package PB02_Shapes;


public class Rectangle extends Shape {
    private double height;
    private double width;

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    @Override
    protected void calculatePerimeter() {
        double perimeter = 2 * (this.height + this.width);
        super.setPerimeter(perimeter);
    }

    @Override
    protected void calculateArea() {
        double area = this.height * this.width;
        super.setArea(area);
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }
}
