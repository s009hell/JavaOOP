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

        if (strings.isEmpty()) {
            System.out.println("Файл пустой.");
        } else {
            for (String s : strings) {
                System.out.println(s);
            }
        }

        System.out.println();

        /* Есть список из целых чисел. Удалить из него все четные числа. В
        этой задаче новый список создавать нельзя */

        System.out.println("Результат удаления четных чисел:");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        ArrayList<Integer> firstInts = new ArrayList<>(Arrays.asList(1, 2, 2, 3, 4, 4, 5, 5, 6, 7, 7, 8, 9, 10, 10));

        for (int i = 0; i < firstInts.size(); i++) {
            if (firstInts.get(i) % 2 == 0) {
                firstInts.remove(i);
                i--;
            }
        }

        System.out.println(firstInts);

        System.out.println(System.lineSeparator());

        /* Есть список из целых чисел, в нём некоторые числа могут
        повторяться. Надо создать новый список, в котором будут
        элементы первого списка в таком же порядке, но без повторений */

        System.out.println("Результат удаления повторных чисел:");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        ArrayList<Integer> secondInts = new ArrayList<>(Arrays.asList(1, 2, 2, 3, 4, 4, 5, 5, 6, 7, 7, 8, 9, 10, 10));
        ArrayList<Integer> newInts = new ArrayList<>();

        for (Integer number : secondInts) {
            if (newInts.contains(number)) {
                continue;
            }

            newInts.add(number);
        }

        System.out.println(newInts);
    }
}