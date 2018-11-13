package src.ru.academitschool.oop.shelestov.work;

import java.util.*;

public class HashTable<T> implements Collection<T> {
    private ArrayList[] table;
    private int size;
    private int modCount;

    public HashTable() {
        table = new ArrayList[16];
    }

    public HashTable(int length) {
        table = new ArrayList[length];
    }

    private int getHash(Object o) {
        if (o == null) {
            return 0;
        }


        return Math.abs(o.hashCode()) % table.length;
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

    //+++
    @Override
    public boolean contains(Object o) {
        int index = getHash(o);

        return (size != 0 && table[index] != null && table[index].contains(o));
    }

    //---
    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private int currentIndex = -1;
            private int currentModCount = modCount;

            @Override
            public boolean hasNext() {
                return currentIndex < size - 1;
            }

            @Override
            public T next() {
                if (currentModCount != modCount) {
                    throw new ConcurrentModificationException("Коллекция изменена.");
                }

                if (currentIndex == size - 1) {
                    throw new NoSuchElementException("Элемент не найден.");
                }


                return null;
            }
        };
    }


    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];

        if (size != 0) {
            int index = 0;

            for (T element : this) {
                array[index] = element;
                index++;
            }
        }

        return array;
    }

    //+++
    @Override
    public <T1> T1[] toArray(T1[] a) {
        if (a.length < size) {
            //noinspection unchecked
            return (T1[]) Arrays.copyOf(toArray(), size, a.getClass());
        }

        //noinspection SuspiciousSystemArraycopy
        System.arraycopy(this.toArray(), 0, a, 0, size);

        if (a.length > size) {
            a[size] = null;
        }

        return a;
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

    //+++
    @Override
    public void clear() {
        if (size != 0) {
            for (int i = 0; i < table.length; i++) {
                table[i] = null;
            }

            modCount++;
            size = 0;
        }
    }
}
