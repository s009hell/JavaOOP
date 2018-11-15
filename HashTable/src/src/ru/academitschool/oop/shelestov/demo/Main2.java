package src.ru.academitschool.oop.shelestov.demo;

import java.util.ArrayList;

public class Main2 {
    public static void main(String[] args) {
        ArrayList<String> s1 = new ArrayList<>();
        ArrayList<String> s2 = new ArrayList<>();

        s1.add("1");
        s1.add("2");
        s1.add("3");
        s1.add("4");

        s2.add("9");

        s1.retainAll(s2);
        System.out.println(s1);
    }
}
