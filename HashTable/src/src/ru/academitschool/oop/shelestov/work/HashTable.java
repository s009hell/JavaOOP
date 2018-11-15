package src.ru.academitschool.oop.shelestov.work;

import java.util.*;

public class HashTable<T> implements Collection<T> {
    private ArrayList<T>[] table;
    private int size;
    private int modCount;

    public HashTable() {
        this(16);
    }

    public HashTable(int length) {
        //noinspection unchecked
        table = new ArrayList[length];
    }

    private int getHash(Object o) {
        if (o == null) {
            return 0;
        }

        return Math.abs(o.hashCode() % table.length);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public boolean contains(Object o) {
        int index = getHash(o);

        return (table[index] != null && table[index].contains(o));
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private int listIndex = 0;
            private int elementIndex = -1;
            private int elementCount = 0;
            private int currentModCount = modCount;

            @Override
            public boolean hasNext() {
                return elementCount < size;
            }

            @Override
            public T next() {
                if (currentModCount != modCount) {
                    throw new ConcurrentModificationException("Коллекция изменена.");
                }

                if (!hasNext()) {
                    throw new NoSuchElementException("Элемент не найден.");
                }

                if (HashTable.this.table[listIndex] == null || HashTable.this.table[listIndex].size() == 0 || elementIndex >= HashTable.this.table[listIndex].size() - 1) {
                    elementIndex = -1;
                    listIndex++;

                    while (HashTable.this.table[listIndex] == null || HashTable.this.table[listIndex].size() == 0) {
                        listIndex++;
                    }
                }

                elementIndex++;
                elementCount++;

                return HashTable.this.table[listIndex].get(elementIndex);
            }

            @Override
            public void remove() {
                HashTable.this.remove(HashTable.this.table[listIndex].get(elementIndex));
                currentModCount = modCount;
            }
        };
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];

        int index = 0;

        for (T element : this) {
            array[index] = element;
            index++;
        }

        return array;
    }

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
        int index = getHash(t);

        if (table[index] == null) {
            table[index] = new ArrayList<>();
        }

        table[index].add(t);
        size++;
        modCount++;

        return true;
    }

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
        boolean isAdded = false;

        for (T item : c) {
            add(item);
            isAdded = true;
        }

        return isAdded;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean isRemove = false;

        for (Object item : c) {
            while (remove(item)) {
                isRemove = true;
            }
        }

        return isRemove;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean isRetain = false;

        int newSize = 0;

        for (ArrayList<T> item : table) {
            if (item != null) {
                item.retainAll(c);
                newSize += item.size();
            }
        }

        if (size != newSize) {
            size = newSize;
            isRetain = true;
        }

        return isRetain;
    }

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

    @Override
    public String toString() {
        if (size == 0) {
            return "[Список не содержит элементов.]";
        }

        StringBuilder sb = new StringBuilder();

        sb.append("[");

        for (ArrayList<T> list : table) {
            if (list == null) {
                continue;
            }

            for (T element : list) {
                sb.append(element);
                sb.append(", ");
            }
        }

        return sb.delete(sb.length() - 2, sb.length()).append("]").toString();
    }
}
