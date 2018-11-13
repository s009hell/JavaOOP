package src.ru.academitschool.oop.shelestov.work;

public class ListItem<T> {
    private T data;
    private ListItem<T> next;

    ListItem(T data) {
        this.data = data;
    }

    ListItem(T data, ListItem<T> next) {
        this.data = data;
        this.next = next;
    }

    T getData() {
        return data;
    }

    void setData(T data) {
        this.data = data;
    }

    ListItem<T> getNext() {
        return next;
    }

    void setNext(ListItem<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        if (data == null) {
            return "null";
        } else {
            return data.toString();
        }
    }
}
