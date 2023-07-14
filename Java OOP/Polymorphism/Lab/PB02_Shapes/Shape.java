package PB02_Shapes;

public abstract class Shape {
    private double perimeter;
    private double area;


    protected abstract void calculatePerimeter();

    protected abstract void calculateArea();

    public double getPerimeter() {
        return perimeter;
    }

    public double getArea() {
        return area;
    }
    protected void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    protected void setArea(double area) {
        this.area = area;
    }
}
