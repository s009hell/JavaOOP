package src.ru.academitschool.oop.shelestov.work;

import java.util.*;

public class HashTable<T> implements Collection<T> {
    private ArrayList[] table;
    private int size;
    private int modCount;
    private final static int DEFAULT_TABLE_LENGTH = 16;

    public HashTable() {
        table = new ArrayList[DEFAULT_TABLE_LENGTH];
    }

    public HashTable(int length) {
        table = new ArrayList[length];
    }

    //+++
    @Override
    public int size() {
        return size;
    }

    //+++
    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }
}
