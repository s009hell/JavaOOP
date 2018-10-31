package src.ru.academitschool.oop.shelestov.work;

import java.util.*;

public class ArrayList<T> implements List<T> {
    private T[] items;
    private int size;

    public ArrayList() {
        this(10);
    }

    public ArrayList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Вместимость не может быть отрицательной или равной 0.");
        }

        items = (T[]) new Object[capacity];
    }

    private void ensureCapacity(int newCapacity) {
        T[] itemsTemp = (T[]) new Object[newCapacity];
        System.arraycopy(items, 0, itemsTemp, 0, size);
        items = itemsTemp;
    }

    public void trimToSize() {
        if (items.length > size) {
            items = Arrays.copyOf(items, size);
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (T element : items) {
            if (element != null && element.equals(o)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(items, size);
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        if (a.length < size) {
            return (T1[]) Arrays.copyOf(items, size, a.getClass());
        }

        System.arraycopy(items, 0, a, 0, size);

        if (a.length > size) {
            a[size] = null;
        }

        return a;
    }

    @Override
    public boolean add(T t) {
        if (size == items.length) {
            ensureCapacity(items.length * 2);
        }

        items[size] = t;
        size++;

        return true;
    }

    @Override
    public boolean remove(Object o) {
        int deletedIndex = indexOf(o);

        if (deletedIndex >= 0) {
            remove(deletedIndex);
            return true;
        }

        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        T[] tempArray = (T[]) c.toArray();

        if (size < tempArray.length) {
            return false;
        }

        for (T aTempArray : tempArray) {
            if (contains(aTempArray)) {
                continue;
            }

            return false;
        }

        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return addAll(size, c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Некорректный индекс.");
        }

        T[] tempArray = (T[]) c.toArray();

        if (size + tempArray.length > items.length) {
            ensureCapacity(size + c.size());
        }

        if (index != size) {
            System.arraycopy(items, index, items, index + tempArray.length, size - index);
        }

        System.arraycopy(tempArray, 0, items, index, tempArray.length);

        size += tempArray.length;

        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean isRemove = false;

        T[] tempArray = (T[]) c.toArray();

        for (T aTempArray : tempArray) {
            for (int j = 0; j < size; j++) {
                if (Objects.equals(items[j], aTempArray)) {
                    remove(j);
                    isRemove = true;
                }
            }
        }

        return isRemove;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean isRetainAll = false;

        for (int i = 0; i < size; i++) {
            if (!(c.contains(items[i]))) {
                remove(i);
                i++;
                isRetainAll = true;
            }
        }

        return isRetainAll;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            items[i] = null;
        }

        size = 0;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("Некорректный индекс.");
        }

        return items[index];
    }

    @Override
    public T set(int index, T element) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("Некорректный индекс.");
        }

        items[index] = element;

        return element;
    }

    @Override
    public void add(int index, T element) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("Некорректный индекс.");
        }

        if (size == items.length) {
            ensureCapacity(items.length * 2);
        }

        System.arraycopy(items, index, items, index + 1, size - index);

        items[index] = element;
        size++;
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("Некорректный индекс.");
        }

        T elementTemp = items[index];

        if (index < size - 1) {
            System.arraycopy(items, index + 1, items, index, size - index - 1);
        }

        items[size - 1] = null;
        size--;

        return elementTemp;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; ++i) {
            if (!(Objects.equals(items[i], o))) {
                continue;
            }

            return i;
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; i--) {
            if (!(Objects.equals(items[i], o))) {
                continue;
            }

            return i;
        }

        return -1;
    }

    @Override
    public String toString() {
        String s1 = Arrays.toString(items).replace("[", "{");
        return s1.replace("]", "}");
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }
}
