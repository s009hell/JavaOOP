package Demo;

import Work.Circle;
import Work.Rectangle;
import Work.Square;
import Work.Triangle;

public class Main {
    public static void main(String[] args) {
        Square square1 = new Square(7.0);
        Square square2 = new Square(2.0);
        Square square3 = new Square(11.0);

        Triangle triangle1 = new Triangle(0.0, 0.0, 1.0, 2.0, 0.0, 1.0);
        Triangle triangle2 = new Triangle(11.0, 2.0, 1.0, 2.0, 7.0, 6.0);
        Triangle triangle3 = new Triangle(0.0, 0.0, 5.0, 4.0, 1.0, 11.0);

        Rectangle rectangle1 = new Rectangle(2, 3);
        Rectangle rectangle2 = new Rectangle(10, 11);
        Rectangle rectangle3 = new Rectangle(1, 2);

        Circle circle1 = new Circle(15);
        Circle circle2 = new Circle(3);
        Circle circle3 = new Circle(7);
    }
}
