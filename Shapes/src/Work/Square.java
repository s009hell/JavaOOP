package Work;

public class Square implements Shape {
    private double sizeLength;

    public Square(double sizeLength) {
        this.sizeLength = sizeLength;
    }

    @Override
    public double getWidth() {
        return sizeLength;
    }

    @Override
    public double getHeight() {
        return sizeLength;
    }

    @Override
    public double getArea() {
        return sizeLength * sizeLength;
    }

    @Override
    public double getPerimeter() {
        return sizeLength * 4;
    }

    @Override
    public String toString() {
        return "Высота = " + getWidth() + ", ширина = " + getHeight() + ", площадь = " + getArea() + ", периметр = " + getPerimeter() + ".";
    }
}
