package ru.academitschool.oop.shelestov.demo;

import ru.academitschool.oop.shelestov.work.Person;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("Евгений", 12);
        Person p2 = new Person("Евгений", 29);
        Person p3 = new Person("Евгений", 49);
        Person p4 = new Person("Иван", 15);
        Person p5 = new Person("Иван", 14);
        Person p6 = new Person("Петр", 24);
        Person p7 = new Person("Петр", 66);
        Person p8 = new Person("Максим", 17);
        Person p9 = new Person("Владимир", 45);
        Person p10 = new Person("Дмитрий", 39);

        ArrayList<Person> persons = new ArrayList<>(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10));

        List<String> uniqueNames = persons.stream()
                .map(Person::getName)
                .distinct()
                .collect(Collectors.toList());

        System.out.println("Имена: " + uniqueNames.stream()
                .collect(Collectors.joining(", ", "", ".")));

        System.out.println();

        OptionalDouble averageAge = persons.stream().filter(person -> person.getAge() < 18)
                .mapToDouble(Person::getAge)
                .average();

        if (averageAge.isEmpty()) {
            System.out.println("Несовершеннолетних в списке персон нет.");
        } else {
            System.out.println("Средний  возраст несовершеннолетних: " + averageAge.getAsDouble());
        }

        System.out.println();
        System.out.println("Средний возраст по именам: ");

        Map<String, Double> middleAgeOfNames = persons.stream().collect(Collectors.groupingBy(Person::getName, Collectors.averagingDouble(Person::getAge)));

        middleAgeOfNames.forEach((name, age) -> System.out.println(name + ": " + age));

        System.out.println();
        System.out.println("Люди в возрасте от 20 до 45 в порядке убывания:");

        String names = persons.stream()
                .filter(x -> x.getAge() >= 20 && x.getAge() <= 45)
                .sorted((person1, person2) -> person2.getAge() - person1.getAge())
                .map(Person::getName)
                .collect(Collectors.joining(", ", "[", "]"));

        System.out.println(names);
    }
}
