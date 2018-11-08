package src.ru.academitschool.oop.shelestov.work;

import java.util.Objects;

public class List<T> {
    private int size = 0;
    private ListItem<T> head = null;

    //получение размера списка
    public int getSize() {
        return size;
    }

    //получение значение первого элемента
    public T getFirstData() {
        return head.getData();
    }

    //получение значения по указанному индексу
    public T getData(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Некорректный индекс.");
        }

        return this.getNode(index).getData();
    }

    //изменение значения по указанному индексу
    public T setData(int index, T value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Некорректный индекс.");
        }

        ListItem<T> item = this.getNode(index);
        T oldValue = item.getData();
        item.setData(value);

        return oldValue;
    }

    //получение узла по индексу
    private ListItem<T> getNode(int index) {
        ListItem<T> item = head;

        for (int i = 0; i < index; i++) {
            item = item.getNext();
        }

        return item;
    }

    //удаление элемента по индексу
    public T removeNode(int index) {
        T oldValue;

        if (index == 0) {
            oldValue = this.removeHead().getData();
        } else {
            ListItem<T> previousItem = this.getNode(index - 1);
            ListItem<T> currentItem = previousItem.getNext();
            oldValue = currentItem.getData();
            ListItem<T> nextItem = currentItem.getNext();
            previousItem.setNext(nextItem);
            size--;
        }

        return oldValue;
    }

    //вставка элемента в начало
    public void addNodeToHead(T value) {
        ListItem<T> item = new ListItem<>(value);

        if (head == null) {
            head = item;
        } else {
            item.setNext(head);
            head = item;
        }

        size++;
    }

    //вставка элемента по индексу
    public void addNode(int index, T value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Некорректный индекс.");
        }

        ListItem<T> item = new ListItem<>(value);

        if (index == 0) {
            this.addNodeToHead(value);
        } else {
            ListItem<T> previousItem = this.getNode(index - 1);
            ListItem<T> currentItem = previousItem.getNext();
            previousItem.setNext(item);
            item.setNext(currentItem);
            size++;
        }
    }

    //удаление узла по значению, пусть выдает true, если элемент был удален
    public boolean removeNode(T value) {
        ListItem<T> item = head;

        for (int i = 0; i < size; i++) {
            if (Objects.equals(value, item.getData())) {
                removeNode(i);
                return true;
            } else {
                item = item.getNext();
            }
        }

        return false;
    }

    //удаление первого элемента, пусть выдает значение элемента
    public ListItem<T> removeHead() {
        ListItem<T> oldItem = head;
        head = head.getNext();
        size--;

        return oldItem;
    }

    //разворот списка за линейное время
    public void reverseList() {
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
    public List<T> copyList() {
        List<T> newList = new List<>();

        if (size == 0) {
            return newList;
        }

        ListItem<T> item = new ListItem<>(head.getData());
        newList.head = item;
        newList.size++;
        ListItem<T> nextItem = head.getNext();

        while (nextItem != null) {
            ListItem<T> targetItem = new ListItem<>(nextItem.getData());
            item.setNext(targetItem);
            item = targetItem;
            nextItem = nextItem.getNext();
            newList.size++;
        }

        return newList;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("[");

        ListItem<T> item = head;

        for (int i = 0; i < size - 1; i++) {
            sb.append(item.getData()).append(", ");
            item = item.getNext();
        }

        sb.append((item.getData())).append("]");

        return sb.toString();
    }
}
