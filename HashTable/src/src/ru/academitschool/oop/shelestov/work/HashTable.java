package src.ru.academitschool.oop.shelestov.work;

import java.util.*;

public class HashTable<T> implements Collection<T> {
    private ArrayList<T>[] table;
    private int size;
    private int modCount;

    public HashTable() {
        //noinspection unchecked
        table = new ArrayList[16];
    }

    public HashTable(int length) {
        //noinspection unchecked
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

    //+++
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

    //+++
    @Override
    public boolean add(T t) {
        int index = getHash(t);

        if (table[index] == null) {
            table[index] = new ArrayList<>();
        }

        table[index].add(t);
        size++;
        modCount++;

        return true;
    }

    //+++
    @Override
    public boolean remove(Object o) {
        int index = getHash(o);

        if (table[index] == null) {
            return false;
        }

        if (table[index].remove(o)) {
            size--;
            modCount++;

            return true;
        }

        return false;
    }

    //+++
    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object item : c) {
            if (!contains(item)) {
                return false;
            }
        }

        return true;
    }

    //+++
    @Override
    public boolean addAll(Collection<? extends T> c) {
        boolean isAdded = false;

        for (T item : c) {
            add(item);
            isAdded = true;
        }

        return isAdded;
    }

    //+++
    @Override
    public boolean removeAll(Collection<?> c) {
        boolean isRemove = false;

        for (Object item : c) {
            remove(item);
            isRemove = true;
        }

        return isRemove;
    }

    //+++
    @Override
    public boolean retainAll(Collection<?> c) {
        boolean isRetain = false;

        for (Object item : c) {
            for (T innerItem : this) {
                if (!Objects.equals(item, innerItem)) {
                    remove(innerItem);
                    isRetain = true;
                }
            }
        }

        return isRetain;
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
