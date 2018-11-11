package src.ru.academitschool.oop.shelestov.work;

import java.util.*;

public class ArrayList<T> implements List<T> {
    private T[] items;
    private int size;
    private int modCount;

    public ArrayList() {
        this(10);
    }

    public ArrayList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Вместимость не может быть отрицательной или равной 0.");
        }

        //noinspection unchecked
        items = (T[]) new Object[capacity];
    }

    public void ensureCapacity(int newCapacity) {
        if (newCapacity <= items.length) {
            return;
        }

        items = Arrays.copyOf(items, newCapacity);
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
        return indexOf(o) >= 0;
    }

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

                currentIndex++;
                return items[currentIndex];
            }

            @Override
            public void remove() {
                ArrayList.this.remove(currentIndex);
                currentModCount = modCount;
            }
        };
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(items, size);
    }


    @Override
    public <T1> T1[] toArray(T1[] a) {
        if (a.length < size) {
            //noinspection unchecked
            return (T1[]) Arrays.copyOf(items, size, a.getClass());
        }

        //noinspection SuspiciousSystemArraycopy
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
        modCount++;

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
        for (Object item : c) {
            if (!contains(item)) {
                return false;
            }
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

        ensureCapacity(size + c.size());

        System.arraycopy(items, index, items, index + c.size(), size - index);

        int tempIndex = index;
        boolean isChanged = false;

        for (T item : c) {
            items[tempIndex] = item;
            tempIndex++;
            isChanged = true;
        }

        if (isChanged) {
            size += c.size();
            modCount++;
            return true;
        }

        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean isRemove = false;

        for (Object item : c) {
            for (int i = 0; i < size; i++) {
                if (Objects.equals(items[i], item)) {
                    remove(i);
                    isRemove = true;
                    i--;
                }
            }
        }

        return isRemove;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean isRetainAll = false;

        for (int i = 0; i < size; i++) {
            if (!c.contains(items[i])) {
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
        modCount++;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Некорректный индекс.");
        }

        return items[index];
    }

    @Override
    public T set(int index, T element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Некорректный индекс.");
        }

        T temp = items[index];
        items[index] = element;

        return temp;
    }

    @Override
    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Некорректный индекс.");
        }

        if (size == items.length) {
            ensureCapacity(items.length * 2);
        }

        System.arraycopy(items, index, items, index + 1, size - index);

        items[index] = element;
        size++;
        modCount++;
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Некорректный индекс.");
        }

        T elementTemp = items[index];

        if (index < size - 1) {
            System.arraycopy(items, index + 1, items, index, size - index - 1);
        }

        items[size - 1] = null;
        size--;
        modCount++;

        return elementTemp;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; ++i) {
            if (Objects.equals(items[i], o)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; i--) {
            if (!Objects.equals(items[i], o)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("[");

        for (int i = 0; i < size; i++) {
            if (items[i] != null) {
                sb.append(items[i].toString());
            } else {
                sb.append("null");
            }

            if (i != size - 1) {
                sb.append(", ");
            }
        }

        sb.append("]");

        return sb.toString();
    }

    @Override
    public ListIterator<T> listIterator() {
        //noinspection ConstantConditions
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        //noinspection ConstantConditions
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        //noinspection ConstantConditions
        return null;
    }
}
