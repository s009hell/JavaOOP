package src.ru.academitschool.oop.shelestov;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        /* Прочитать в список все строки из файла */

        ArrayList<String> strings = new ArrayList<>();

        try (Scanner scanner = new Scanner(new FileInputStream("input.txt"), "windows-1251")) {
            while (scanner.hasNextLine()) {
                strings.add(scanner.nextLine());
            }
        } catch (IOException exc) {
            System.out.println("Ошибка при чтении файла.");
        }

        System.out.println("Строки из файла:");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        if (strings.size() == 0) {
            System.out.println("Файл пустой.");
        } else {
            for (String s : strings) {
                System.out.println(s);
            }
        }

        System.out.println();

        /* Есть список из целых чисел. Удалить из него все четные числа. В
        этой задаче новый список создавать нельзя */

        ArrayList<Integer> ints = new ArrayList<>(Arrays.asList(1, 2, 2, 3, 4, 4, 5, 5, 6, 7, 7, 8, 9, 10, 10));

        for (int i = 0; i < ints.size(); i++) {
            if (ints.get(i) % 2 == 0) {
                ints.remove(i);
                i--;
            }
        }

        System.out.println();

        System.out.println("Результат удаления четных чисел:");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        for (int number : ints) {
            System.out.print(number + " ");
        }

        System.out.println(System.lineSeparator());

        /* Есть список из целых чисел, в нём некоторые числа могут
        повторяться. Надо создать новый список, в котором будут
        элементы первого списка в таком же порядке, но без повторений */

        ArrayList<Integer> ints2 = new ArrayList<>(Arrays.asList(1, 2, 2, 3, 4, 4, 5, 5, 6, 7, 7, 8, 9, 10, 10));
        ArrayList<Integer> newInts = new ArrayList<>();

        newInts.add(ints2.get(0));

        for (int i : ints2) {
            if (i <= newInts.get(newInts.size() - 1)) {
                continue;
            }

            newInts.add(i);
        }

        System.out.println("Результат удаления повторных чисел:");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        for (int i : newInts) {
            System.out.print(i + " ");
        }
    }
}
