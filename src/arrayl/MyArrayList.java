package arrayl;

import java.util.Iterator;



public class MyArrayList<T extends Comparable<T>> implements MyList<T> {
    private Object[] elements;
    private int size;
    private static final int INITIAL_CAPACITY = 10;

    public MyArrayList() {
        elements = new Object[INITIAL_CAPACITY];
        size = 0;
    }

    private void ensureCapacity() {
        if (size >= elements.length) {
            Object[] newElements = new Object[elements.length * 2];
            for (int i = 0; i < elements.length; i++) {
                newElements[i] = elements[i];
            }
            elements = newElements;
        }
    }

    @Override
    public void add(T item) {
        ensureCapacity();
        elements[size++] = item;
    }

    @Override
    public void add(int index, T item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }

        ensureCapacity();

        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }

        elements[index] = item;
        size++;
    }


    @Override
    public void addLast(T item) {
        add(item);
    }

    @Override
    public void addFirst(T item) {
        add(0, item);
    }


    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        return (T) elements[index];
    }

    @Override
    public T getFirst() {
        if (size == 0) {
            throw new IllegalStateException("List is empty");
        }
        return get(0);
    }
    @Override
    public T getLast() {
        if (size == 0) {
            throw new IllegalStateException("List is empty");
        }
        return get(size - 1);
    }



    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }



    @Override
    public void set(int index, T item) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        elements[index] = item;
    }


    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }

        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }

        elements[size - 1] = null;
        size--;
    }


    @Override
    public void removeFirst() {
        if (size == 0) {
            throw new IllegalStateException("List is empty");
        }
        remove(0);
    }

    @Override
    public void removeLast() {
        if (size == 0) {
            throw new IllegalStateException("List is empty");
        }
        remove(size - 1);
    }

    @Override
    public int indexOf(Object object) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        for (int i = size - 1; i >= 0; i--) {
            if (elements[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        for (int i = 0; i < size; i++) {
            result[i] = elements[i];
        }
        return result;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public T next() {
                return (T) elements[index++];
            }
        };
    }


    @Override
    public void sort() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                T a = (T) elements[j];
                T b = (T) elements[j + 1];
                if (a.compareTo(b) > 0) {
                    elements[j] = b;
                    elements[j + 1] = a;
                }
            }
        }
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }



}
