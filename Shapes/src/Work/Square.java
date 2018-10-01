package Work;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Square square = (Square) o;
        return Double.compare(square.sizeLength, sizeLength) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sizeLength);
    }
}
