package mystructures;

import interfaces.MyList;

public class MyStack<T extends Comparable<T>> {
    private final MyList<T> list;

    public MyStack(MyList<T> list) {
        this.list = list;
    }

    public void push(T item) {
        list.addLast(item);
    }

    public T pop() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty");
        T value = list.getLast();
        list.removeLast();
        return value;
    }

    public T peek() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty");
        return list.getLast();
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
