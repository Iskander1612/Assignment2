package mystructures;

import interfaces.MyList;

public class MyMinHeap<T extends Comparable<T>> {
    private final MyList<T> list;

    public MyMinHeap(MyList<T> list) {
        this.list = list;
    }

    public void insert(T item) {
        list.addLast(item);
        heapifyUp(list.size() - 1);
    }

    public T removeMin() {
        if (isEmpty()) throw new IllegalStateException("Heap is empty");
        T min = list.get(0);
        list.set(0, list.get(list.size() - 1));
        list.removeLast();
        heapifyDown(0);
        return min;
    }

    public T getMin() {
        if (isEmpty()) throw new IllegalStateException("Heap is empty");
        return list.get(0);
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public int size() {
        return list.size();
    }

    private void heapifyUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (list.get(index).compareTo(list.get(parentIndex)) < 0) {
                swap(index, parentIndex);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    private void heapifyDown(int index) {
        int size = list.size();
        while (index < size) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int smallest = index;

            if (left < size && list.get(left).compareTo(list.get(smallest)) < 0) {
                smallest = left;
            }
            if (right < size && list.get(right).compareTo(list.get(smallest)) < 0) {
                smallest = right;
            }
            if (smallest != index) {
                swap(index, smallest);
                index = smallest;
            } else {
                break;
            }
        }
    }

    private void swap(int i, int j) {
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    @Override
    public String toString() {
        return list.toString();
    }
}