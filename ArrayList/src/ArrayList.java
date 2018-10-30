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

    // normal
    @Override
    public int size() {
        return size;
    }

    // normal
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    // normal
    @Override
    public boolean contains(Object o) {
        for (T element : items) {
            if (element.equals(o)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    // normal
    @Override
    public Object[] toArray() {
        return Arrays.copyOf(items, size);
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    // normal
    @Override
    public boolean add(T t) {
        if (size == items.length) {
            ensureCapacity(items.length * 2);
        }

        items[size] = t;
        size++;

        return true;
    }

    //normal
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
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
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

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public T set(int index, T element) {
        return null;
    }

    @Override
    public void add(int index, T element) {

    }

    // normal
    @Override
    public T remove(int index) {
        if (index < 0 || index > size - 1) {
            throw new IllegalArgumentException("Некорректный индекс.");
        }

        T elementTemp = items[index];

        if (index < size - 1) {
            int numMoved = size - index - 1;
            System.arraycopy(items, index + 1, items, index, numMoved);
        }

        items[size - 1] = null;
        size--;

        return elementTemp;
    }

    // normal
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
        return 0;
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
