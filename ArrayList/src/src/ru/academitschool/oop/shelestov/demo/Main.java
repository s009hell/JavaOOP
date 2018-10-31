package src.ru.academitschool.oop.shelestov.demo;

import src.ru.academitschool.oop.shelestov.work.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> al1 = new ArrayList<>();
        al1.add(1);
        al1.add(2);
        al1.add(3);

        System.out.println("items: " + al1);
        al1.trimToSize();
        System.out.println("trimToSize: " + al1);
        System.out.println("size: " + al1.size());
        System.out.println("isEmpty: " + al1.isEmpty());
        System.out.println("contains(2): " + al1.contains(2));
        System.out.println("contains(4): " + al1.contains(4));

    }
}
