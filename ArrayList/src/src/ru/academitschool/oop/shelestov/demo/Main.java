package src.ru.academitschool.oop.shelestov.demo;

import src.ru.academitschool.oop.shelestov.work.ArrayList;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> al1 = new ArrayList<>(5);
        al1.add(1);
        al1.add(2);
        al1.add(3);
        al1.add(4);
        al1.add(5);

        System.out.println("items: " + al1);
        System.out.println("size: " + al1.size());

        al1.ensureCapacity(10);
        System.out.println("ensureCapacity(10): " + al1.size());

        System.out.println("isEmpty: " + al1.isEmpty());
        System.out.println("contains(2): " + al1.contains(2));
        System.out.println("contains(6): " + al1.contains(6));
        System.out.println("toArray: " + Arrays.toString(al1.toArray()));

        Integer[] a = new Integer[5];
        System.out.println("toArray(T1[] a): " + Arrays.toString(al1.toArray(a)));

        System.out.println("remove((Integer) 3): " + al1.remove((Integer) 3));
        System.out.println("remove(1): " + al1.remove(1));



        ArrayList<Integer> al2 = new ArrayList<>(2);
        al2.add(1);
        al2.add(5);
        System.out.println("containsAll(1, 5): " + al1.containsAll(al2));

        al2.set(0, 6);
        al2.set(1, 7);
        System.out.println("containsAll(6, 7): " + al1.containsAll(al2));

        al1.addAll(al2);
        System.out.println("addAll(6, 7): " + al1);

        al1.addAll(1, al2);
        System.out.println("addAll(1, 6, 7): " + al1);

        System.out.println("indexOf(6): " + al1.indexOf(6));
        System.out.println("lastIndexOf(6): " + al1.lastIndexOf(6));

        al1.removeAll(al2);
        System.out.println("removeAll(6, 7): " + al1);

        al2.set(0, 4);
        al2.set(1, 1);
        al1.retainAll(al2);
        System.out.println("retainAll(4, 1): " + al1);

        al1.set(1, 6);
        System.out.println("set(1, 6): " + al1);

        System.out.println("get(1): " + al1.get(1));

        al1.add(1, 8);
        System.out.println("add(1, 8): " + al1);

        ArrayList<Integer> al3 = new ArrayList<>();
        al3.add(1);
        al3.add(2);
        al3.add(3);
        al3.add(4);
        al3.add(5);

        al3.trimToSize();
        System.out.println("trimToSize: " + al3);
    }
}
