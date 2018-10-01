package Demo;

import Work.*;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Shape shapesArray[] = new Shape[12];

        shapesArray[0] = new Square(7.0);
        shapesArray[1] = new Square(2.0);
        shapesArray[2] = new Square(11.0);

        shapesArray[3] = new Triangle(0.0, 0.0, 1.0, 2.0, 0.0, 1.0);
        shapesArray[4] = new Triangle(11.0, 2.0, 1.0, 2.0, 7.0, 6.0);
        shapesArray[5] = new Triangle(0.0, 0.0, 5.0, 4.0, 1.0, 11.0);

        shapesArray[6] = new Rectangle(2, 3);
        shapesArray[7] = new Rectangle(10, 11);
        shapesArray[8] = new Rectangle(1, 2);

        shapesArray[9] = new Circle(15);
        shapesArray[10] = new Circle(3);
        shapesArray[11] = new Circle(7);

        System.out.println("Фигура с максимальной площадью:");
        System.out.println(getMaxArea(shapesArray));

        System.out.println();

        System.out.println("Фигура с вторым по величине периметром:");
        System.out.println(getSecondPerimeter(shapesArray));
    }

    private static Shape getMaxArea(Shape[] shapes) {
        Arrays.sort(shapes, new SortByArea());
        return shapes[shapes.length - 1];
    }

    private static Shape getSecondPerimeter(Shape[] shapes) {
        Arrays.sort(shapes, new SortByPerimeter());
        return shapes[shapes.length - 2];
    }
}
