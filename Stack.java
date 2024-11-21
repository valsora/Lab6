public class Stack<T> {
    public T[] data;
    private int size;

    @SuppressWarnings("unchecked")
    public Stack(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    public T peek() {
        if (size > 0) {
            return data[size - 1];
        }
        return null;
    }

    public T pop() {
        if (size > 0) {
            T lastItem = data[size - 1];
            data[size - 1] = null;
            size--;
            return lastItem;
        }
        return null;
    }

    public void push(T item) {
        if (size < data.length) {
            data[size] = item;
            size++;
        }
    }
}
