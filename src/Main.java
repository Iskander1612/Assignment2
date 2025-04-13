import arrayl.*;


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


    }
}


//import arrayl.*;
//
//public class Main {
//    public static void main(String[] args) {
//        MyLinkedList<String> list = new MyLinkedList<>();
//
//        list.add("Hello");
//        list.add("World");
//        list.addFirst("Apple");
//        list.addLast("Orange");
//        list.add(2, "Banan");
//
//        System.out.println(list);
//        System.out.println(list.getFirst());
//        System.out.println(list.getLast());
//        System.out.println(list.get(2));
//        System.out.println(list.size());
//
//        list.remove(2);
//        System.out.println(list);
//
//        list.removeFirst();
//        list.removeLast();
//        System.out.println(list);
//
//        list.set(1, "Carrot");
//        System.out.println(list);
//
//        System.out.println(list.exists("Carrot"));
//        System.out.println(list.indexOf("Carrot"));
//        System.out.println(list.lastIndexOf("Hello"));
//
//        Object[] array = list.toArray();
//        for (Object obj : array) {
//            System.out.print(obj + " ");
//        }
//
//        list.sort();
//        System.out.println(list);
//    }
//}


