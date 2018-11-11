package src.ru.academitschool.oop.shelestov.demo;

import src.ru.academitschool.oop.shelestov.work.List;
import src.ru.academitschool.oop.shelestov.work.ListItem;

public class Main {
    public static void main(String[] args) {
        List<String> list = new List<>();

        ListItem<String> li3 = new ListItem<>("Элемент 3");
        list.addNode(0, li3);
        System.out.println("Вставка элемента по индексу 0: "+ list);

        ListItem<String> li1 = new ListItem<>("Элемент 1");
        list.addNodeToHead(li1);
        System.out.println("Вставка элемента в начало: "+ list);

        ListItem<String> li2 = new ListItem<>("Элемент 2");
        list.addNode(1, li2);
        System.out.println("Вставка элемента по индексу 1: "+ list);

        ListItem<String> li4 = new ListItem<>("Элемент 6");
        list.addNode(3, li4);
        System.out.println("Вставка элемента по индексу 3: "+ list);

        ListItem<String> li5 = new ListItem<>("Элемент 5");
        list.addNode(4, li5);
        System.out.println("Вставка элемента по индексу 4: "+ list);

        System.out.println("Получение значения по индексу 3: " + list.getData(3));
        System.out.println("Получение значения первого элемента: " + list.getFirstData());
        System.out.println("Получение развема списка: " + list.getSize());

        System.out.println("Изменение значения по индексу 3 (Значение 4): " + list.setData(3, "Элемент 4"));
        System.out.println("Результат: " + list);

        List<String> list2 = list.copyList();
        System.out.println("Копирование списка: " + list2);

        list2.reverseList();
        System.out.println("Разворот списка: " + list2);

        System.out.println("Удаление значения по индексу 3: " + list.removeNode(3));
        System.out.println("Результат: " + list);

        System.out.println("Удаление элемента по значению (Элемент 4): " + list.removeNode("Элемент 4"));
        System.out.println("Результат: " + list);

        System.out.println("Удаление элемента по значению (Элемент 3): " + list.removeNode("Элемент 3"));
        System.out.println("Результат: " + list);

        System.out.println("Удаление первого элемента: " + list.removeHead());
        System.out.println("Результат: " + list);

        System.out.println("Получение узла по индексу 2: " + list.getNode(1));
    }
}
