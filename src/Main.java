import arrayl.*;

public class Main {
    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("Hello");
        list.add("World");
        list.add("Salem");
        list.add("Alem");
        System.out.println(list);

        System.out.println(list.get(0));

        list.addFirst("Banan");


        list.removeFirst();


        System.out.println(list.exists("Apple"));

        System.out.println(list.indexOf("Hello"));

        System.out.println(list.toString());
    }
}