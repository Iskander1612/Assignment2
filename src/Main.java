import arrayl.*;
import mystructures.*;

public class Main {
    public static void main(String[] args) {
        MyArrayList<String> list2 = new MyArrayList<>();
        list2.add("Hello");
        list2.add("World");
        list2.add("Salem");
        list2.add("Alem");
        System.out.println(list2);

        System.out.println(list2.get(0));

        list2.addFirst("Banan");


        list2.removeFirst();


        System.out.println(list2.exists("Apple"));

        System.out.println(list2.indexOf("Hello"));

        System.out.println(list2.toString());

System.out.println("-----------------------------------------------");


        MyLinkedList<String> list = new MyLinkedList<>();

        list.add("Hello");
        list.add("World");
        list.addFirst("Apple");
        list.addLast("Orange");
        list.add(2, "Banan");

        System.out.println(list);
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
        System.out.println(list.get(2));
        System.out.println(list.size());

        list.remove(2);
        System.out.println(list);

        list.removeFirst();
        list.removeLast();
        System.out.println(list);

        list.set(1, "Carrot");
        System.out.println(list);

        System.out.println(list.exists("Carrot"));
        System.out.println(list.indexOf("Carrot"));
        System.out.println(list.lastIndexOf("Hello"));

        Object[] array = list.toArray();
        for (Object obj : array) {
            System.out.print(obj + " ");
        }

        list.sort();
        System.out.println(list);



        MyStack<Integer> stack = new MyStack<>(new MyLinkedList<Integer>());

        stack.push(2);
        stack.push(1);
        stack.push(3);
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack);


        MyQueue<Integer> queue = new MyQueue<>(new MyLinkedList<Integer>());

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(5);
        queue.enqueue(3);

        System.out.println(queue);
        System.out.println(queue.dequeue());
        System.out.println(queue.peek());
        System.out.println(queue);

        System.out.println("-----------------------------------------");


        MyMinHeap<Integer> heap = new MyMinHeap<>(new MyArrayList<Integer>());

        heap.insert(13);
        heap.insert(21);
        heap.insert(52);
        heap.insert(18);
        heap.insert(2006);

        System.out.println(heap);
        System.out.println(heap.getMin());

        heap.removeMin();
        System.out.println(heap);

    }
}
