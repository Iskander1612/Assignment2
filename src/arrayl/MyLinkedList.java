package arrayl;

import interfaces.MyList;
import java.util.Iterator;


public class MyLinkedList<T extends Comparable<T>> implements MyList<T> {

    private static class Node<T> {
        T value;
        Node<T> next;
        Node<T> prev;

        Node(T value) {
            this.value = value;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    @Override
    public void add(T item) {
        addLast(item);
    }

    @Override
    public void add(int index, T item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        if (index == 0) {
            addFirst(item);
        } else if (index == size) {
            addLast(item);
        } else {
            Node<T> current = getNode(index);
            Node<T> newNode = new Node<>(item);
            Node<T> prevNode = current.prev;

            prevNode.next = newNode;
            newNode.prev = prevNode;
            newNode.next = current;
            current.prev = newNode;
            size++;
        }
    }

    @Override
    public void addFirst(T item) {
        Node<T> newNode = new Node<>(item);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    @Override
    public void addLast(T item) {
        Node<T> newNode = new Node<>(item);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    @Override
    public void set(int index, T item) {
        getNode(index).value = item;
    }

    @Override
    public T get(int index) {
        return getNode(index).value;
    }

    @Override
    public T getFirst() {
        if (head == null) throw new IllegalStateException("List is empty");
        return head.value;
    }

    @Override
    public T getLast() {
        if (tail == null) throw new IllegalStateException("List is empty");
        return tail.value;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        if (index == 0) {
            removeFirst();
        } else if (index == size - 1) {
            removeLast();
        } else {
            Node<T> current = getNode(index);
            current.prev.next = current.next;
            current.next.prev = current.prev;
            size--;
        }
    }

    @Override
    public void removeFirst() {
        if (head == null) throw new IllegalStateException("List is empty");
        head = head.next;
        if (head != null) head.prev = null;
        else tail = null;
        size--;
    }

    @Override
    public void removeLast() {
        if (tail == null) throw new IllegalStateException("List is empty");
        tail = tail.prev;
        if (tail != null) tail.next = null;
        else head = null;
        size--;
    }

    @Override
    public void sort() {
        if (size < 2) return;
        for (Node<T> i = head; i != null; i = i.next) {
            for (Node<T> j = i.next; j != null; j = j.next) {
                if (i.value.compareTo(j.value) > 0) {
                    T temp = i.value;
                    i.value = j.value;
                    j.value = temp;
                }
            }
        }
    }

    @Override
    public int indexOf(Object object) {
        int index = 0;
        for (Node<T> current = head; current != null; current = current.next) {
            if (current.value.equals(object)) return index;
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        int index = size - 1;
        for (Node<T> current = tail; current != null; current = current.prev) {
            if (current.value.equals(object)) return index;
            index--;
        }
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        int i = 0;
        for (Node<T> current = head; current != null; current = current.next) {
            array[i++] = current.value;
        }
        return array;
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    private Node<T> getNode(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Node<T> current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) current = current.next;
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) current = current.prev;
        }
        return current;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                T value = current.value;
                current = current.next;
                return value;
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<T> current = head;
        while (current != null) {
            sb.append(current.value);
            if (current.next != null) sb.append(", ");
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
