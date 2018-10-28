import java.util.List;

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
            if (element.equals(o)) {
                return true;
            }
        }

        return false;
    }
}
