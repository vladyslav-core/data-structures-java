package linkedlist;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== LinkedList Demo ===");

        LinkedList<String> list = new LinkedList<String>();


        // --- add(E value) ---
        System.out.println("\nAdd elements:");

        list.add("A");
        list.add("B");
        list.add("C");

        System.out.println("List: " + list);


        // --- add(index, element) ---
        System.out.println("\nInsert element at index 1:");

        list.add(1, "X");

        System.out.println("List: " + list);


        // --- get(index) ---
        System.out.println("\nGet element at index 2:");

        String element = list.get(2);

        System.out.println("Element: " + element);


        // --- remove(index) ---
        System.out.println("\nRemove element at index 1:");

        String removed = list.remove(1);

        System.out.println("Removed: " + removed);
        System.out.println("List: " + list);


        // --- size() ---
        System.out.println("\nCurrent size:");

        System.out.println("Size: " + list.size());


        System.out.println("\n=== Demo finished ===");

    }
}
