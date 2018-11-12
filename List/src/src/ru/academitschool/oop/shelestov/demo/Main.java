package src.ru.academitschool.oop.shelestov.demo;

import src.ru.academitschool.oop.shelestov.work.List;

public class Main {
    public static void main(String[] args) {
        List<String> list = new List<>();

        list.addNode(0, "Элемент 3");
        System.out.println("Вставка элемента по индексу 0: "+ list);

        list.addNodeToHead("Элемент 1");
        System.out.println("Вставка элемента в начало: "+ list);

        list.addNode(1, "Элемент 2");
        System.out.println("Вставка элемента по индексу 1: "+ list);

        list.addNode(3, "Элемент 6");
        System.out.println("Вставка элемента по индексу 3: "+ list);

        list.addNode(4, "Элемент 5");
        System.out.println("Вставка элемента по индексу 4: "+ list);

        System.out.println("Получение значения по индексу 3: " + list.getData(3));
        System.out.println("Получение значения первого элемента: " + list.getFirstData());
        System.out.println("Получение размера списка: " + list.getSize());

        System.out.println("Изменение значения по индексу 3 (Значение 4): " + list.setData(3, "Элемент 4"));
        System.out.println("Результат: " + list);

        List<String> list2 = list.copy();
        System.out.println("Копирование списка: " + list2);

        list2.reverse();
        System.out.println("Разворот списка: " + list2);

        System.out.println("Удаление значения по индексу 3: " + list.removeNode(3));
        System.out.println("Результат: " + list);

        System.out.println("Удаление элемента по значению (Элемент 4): " + list.removeNode("Элемент 4"));
        System.out.println("Результат: " + list);

        System.out.println("Удаление элемента по значению (Элемент 3): " + list.removeNode("Элемент 3"));
        System.out.println("Результат: " + list);

        System.out.println("Удаление первого элемента: " + list.removeHead());
        System.out.println("Результат: " + list);
    }
}
