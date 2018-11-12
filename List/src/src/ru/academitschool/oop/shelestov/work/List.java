package src.ru.academitschool.oop.shelestov.work;


import java.util.*;

public class List<T> {
    private int size = 0;
    private ListItem<T> head = null;

    //получение размера списка
    public int getSize() {
        return size;
    }

    //получение значение первого элемента
    public T getFirstData() {
        if (size == 0) {
            throw new NoSuchElementException("Список не содержит элементов.");
        }

        return head.getData();
    }

    //получение значения по указанному индексу
    public T getData(int index) {
        return getNode(index).getData();
    }

    //изменение значения по указанному индексу
    public T setData(int index, T value) {
        ListItem<T> item = getNode(index);
        T oldValue = item.getData();
        item.setData(value);

        return oldValue;
    }

    //получение узла по индексу
    private ListItem<T> getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Некорректный индекс.");
        }

        ListItem<T> item = head;

        for (int i = 0; i < index; i++) {
            item = item.getNext();
        }

        return item;
    }

    //удаление элемента по индексу
    public T removeNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Некорректный индекс.");
        }

        T oldValue;

        if (index == 0) {
            oldValue = removeHead().getData();
        } else {
            ListItem<T> previousItem = getNode(index - 1);
            ListItem<T> currentItem = previousItem.getNext();
            oldValue = currentItem.getData();
            ListItem<T> nextItem = currentItem.getNext();
            previousItem.setNext(nextItem);
            size--;
        }

        return oldValue;
    }

    //вставка элемента в начало
    public void addNodeToHead(T data) {
        ListItem<T> item = new ListItem<>(data);

        if (head == null) {
            head = item;
        } else {
            item.setNext(head);
            head = item;
        }

        size++;
    }

    //вставка элемента по индексу
    public void addNode(int index, T data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Некорректный индекс.");
        }

        if (index == 0) {
            addNodeToHead(data);
        } else {
            ListItem<T> item = new ListItem<>(data);
            ListItem<T> previousItem = getNode(index - 1);
            ListItem<T> currentItem = previousItem.getNext();
            previousItem.setNext(item);
            item.setNext(currentItem);
            size++;
        }
    }

    //удаление узла по значению, пусть выдает true, если элемент был удален
    public boolean removeNode(T value) {
        if (size == 0) {
            throw new NoSuchElementException("Список не содержит элементов.");
        }

        if (Objects.equals(value, head.getData())) {
            head = head.getNext();
            size--;
            return true;
        }

        ListItem<T> currentItem = head.getNext();
        ListItem<T> previousItem = head;

        while (currentItem != null) {
            if (Objects.equals(value, currentItem.getData())) {
                previousItem.setNext(currentItem.getNext());
                size--;
                return true;
            } else {
                previousItem = currentItem;
                currentItem = currentItem.getNext();
            }
        }

        return false;
    }

    //+++удаление первого элемента, пусть выдает значение элемента
    public ListItem<T> removeHead() {
        ListItem<T> oldItem = head;
        head = head.getNext();
        size--;

        return oldItem;
    }

    //разворот списка за линейное время
    public void reverse() {
        ListItem<T> previousItem = null;
        ListItem<T> item = head;

        while (item != null) {
            ListItem<T> nextItem = item.getNext();
            item.setNext(previousItem);
            previousItem = item;
            item = nextItem;
        }

        head = previousItem;
    }

    //копирование списка
    public List<T> copy() {
        List<T> newList = new List<>();

        if (size == 0) {
            return newList;
        }

        ListItem<T> item = new ListItem<>(head.getData());
        newList.head = item;
        ListItem<T> nextItem = head.getNext();

        while (nextItem != null) {
            ListItem<T> targetItem = new ListItem<>(nextItem.getData());
            item.setNext(targetItem);
            item = targetItem;
            nextItem = nextItem.getNext();
        }

        newList.size = size;

        return newList;
    }

    public String toString() {
        if (size == 0) {
            return "[Список не содержит элементов.]";
        }

        StringBuilder sb = new StringBuilder();

        sb.append("[");

        ListItem<T> item = head;

        for (int i = 0; i < size - 1; i++) {
            sb.append(item.getData()).append(", ");
            item = item.getNext();
        }

        sb.append(item.getData()).append("]");

        return sb.toString();
    }
}
