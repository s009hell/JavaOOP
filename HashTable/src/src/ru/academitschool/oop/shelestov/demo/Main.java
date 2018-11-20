package src.ru.academitschool.oop.shelestov.demo;

import src.ru.academitschool.oop.shelestov.work.HashTable;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        HashTable<String> ht1 = new HashTable<>();

        //noinspection ConstantConditions
        System.out.println("isEmpty: " + ht1.isEmpty());

        ht1.add("3");
        ht1.add("1");
        ht1.add("2");
        ht1.add("5");
        ht1.add(null);
        ht1.add("0");
        ht1.add("4");

        System.out.println("isEmpty: " + ht1.isEmpty());
        System.out.println(ht1);
        System.out.println("size: " + ht1.size());

        System.out.println("contains(4): " + ht1.contains("4"));
        System.out.println("contains(6): " + ht1.contains("6"));

        System.out.println("toArray: " + Arrays.toString(ht1.toArray()));

        String[] a = new String[7];
        System.out.println("toArray(T1[] a): " + Arrays.toString(ht1.toArray(a)));

        System.out.println("remove (6): " + ht1.remove("6"));
        System.out.println("remove (3): " + ht1.remove("3"));
        System.out.println("Результат: " + ht1);

        HashTable<String> ht2 = new HashTable<>(8);
        ht2.add("1");
        ht2.add("2");
        ht2.add("9");

        System.out.println("containsAll(1, 2, 9): " + ht1.containsAll(ht2));

        ht2.remove("9");

        System.out.println("containsAll(1, 2): " + ht1.containsAll(ht2));

        System.out.println("addAll(1, 2): " + ht1.addAll(ht2));
        System.out.println("Результат: " + ht1);

        HashTable<String> ht3 = new HashTable<>(4);
        ht3.add("1");
        ht3.add("2");

        System.out.println("removeAll(1, 2): " + ht1.removeAll(ht3));
        System.out.println("Результат: " + ht1);

        ht1.add("1");
        ht1.add("2");
        ht1.add("1");
        ht1.add("2");

        System.out.println("retainAll(1, 2): " + ht1.retainAll(ht2));
        System.out.println("Результат: " + ht1);

        ht1.clear();
        System.out.println("clear: " + ht1);
    }
}
