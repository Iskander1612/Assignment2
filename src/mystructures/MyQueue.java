package mystructures;

import interfaces.MyList;

public class MyQueue<T extends Comparable<T>> {
    private final MyList<T> list;

    public MyQueue(MyList<T> list) {
        this.list = list;
    }

    public void enqueue(T item) {
        list.addLast(item);
    }

    public T dequeue() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty");
        T value = list.getFirst();
        list.removeFirst();
        return value;
    }

    public T peek() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty");
        return list.getFirst();
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public int size() {
        return list.size();
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
