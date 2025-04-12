import arrayl.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("Hello");
        list.add("World");
        System.out.println(list);

        System.out.println(list.get(0));

        list.addFirst("Banan");

        System.out.println(Arrays.toString(list.toArray()));

        list.removeFirst();
        System.out.println(Arrays.toString(list.toArray()));

        System.out.println(list.exists("Apple"));

        System.out.println(list.indexOf("Hello"));
    }
}