package src.ru.academitschool.oop.shelestov.demo;

import src.ru.academitschool.oop.shelestov.work.HashTable;

public class Main {
    public static void main(String[] args) {
        HashTable<String> ht = new HashTable<>(167);
        System.out.println(ht.size());
    }
}
