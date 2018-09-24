package src.ru.academitschool.oop.shelestov.demo;

import src.ru.academitschool.oop.shelestov.work.Range;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите начальное число первого диапазона: ");
        double from1 = scanner.nextDouble();

        System.out.print("Введите конечное число первого диапазона: ");
        double to1 = scanner.nextDouble();

        Range range1 = new Range(from1, to1);

        System.out.println();

        System.out.print("Введите начальное число второго диапазона: ");
        double from2 = scanner.nextDouble();

        System.out.print("Введите конечное число второго диапазона: ");
        double to2 = scanner.nextDouble();

        Range range2 = new Range(from2, to2);


        System.out.println();

        System.out.println("Длина первого диапазона: от " + range1.getFrom() + " до " + range1.getTo() + " = " + range1.calculateLength());
        System.out.println("Длина первого диапазона: от " + range2.getFrom() + " до " + range2.getTo() + " = " + range2.calculateLength());

        System.out.println();

        System.out.print("Введите число на проверку вхождения в диапазоны: ");
        double numberRange = scanner.nextDouble();

        if (range1.isInside(numberRange)) {
            System.out.println("Число входит в первый диапазон.");
        } else {
            System.out.println("Число не входит в первый диапазон.");
        }

        if (range2.isInside(numberRange)) {
            System.out.println("Число входит во второй диапазон.");
        } else {
            System.out.println("Число не входит во второй диапазон.");
        }

        System.out.println();

        Range range3 = range1.getIntersection(range2);

        if (range3 == null) {
            System.out.println("Интервалы не пересекаются.");
        } else {
            System.out.println("Пересечение интервалов: от " + range3.getFrom() + " до " + range3.getTo() + ".");
        }

        System.out.println();

        Range[] rangeArray = range1.getMerge(range2);

        if (rangeArray.length == 1) {
            System.out.println("Результат слияния интервалов: от " + rangeArray[0].getFrom() + " до " + rangeArray[0].getTo() + ".");
        } else {
            System.out.println("Результат слияния интервалов: от " + rangeArray[0].getFrom() + " до " + rangeArray[0].getTo() + " и от " + rangeArray[1].getFrom() + " до " + rangeArray[1].getTo() + ".");
        }

        System.out.println();

        rangeArray = range1.getDifference(range2);

        if (rangeArray.length == 1) {
            System.out.println("Результат разности интервалов: от " + rangeArray[0].getFrom() + " до " + rangeArray[0].getTo() + ".");
        } else {
            System.out.println("Результат разности интервалов: от " + rangeArray[0].getFrom() + " до " + rangeArray[0].getTo() + " и от " + rangeArray[1].getFrom() + " до " + rangeArray[1].getTo() + ".");
        }
    }
}
