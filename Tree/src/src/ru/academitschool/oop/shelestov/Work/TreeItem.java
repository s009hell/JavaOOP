package src.ru.academitschool.oop.shelestov.Work;

public class TreeItem<T> {
    private T data;
    private TreeItem<T> leftChild;
    private TreeItem<T> rightChild;

    TreeItem(T data) {
        this.data = data;
    }

    TreeItem(T data, TreeItem<T> leftChild, TreeItem<T> rightChild) {
        this.data = data;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public TreeItem<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeItem<T> leftChild) {
        this.leftChild = leftChild;
    }

    public TreeItem<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeItem<T> rightChild) {
        this.rightChild = rightChild;
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
