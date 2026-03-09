package doublelinkedlist;

public class Main {
    static void main() {

        DoubleLinkedList<String> list = new DoubleLinkedList<>();

        System.out.println("=== Create empty list ===");
        System.out.println("List: " + list);
        System.out.println("Reverse: " + list.toStringReverse());
        System.out.println("Size: " + list.size());

        System.out.println("\n=== Add elements to the end ===");
        list.add("A");
        list.add("B");
        list.add("C");
        System.out.println("List: " + list);
        System.out.println("Reverse: " + list.toStringReverse());
        System.out.println("Size: " + list.size());

        System.out.println("\n=== Add element at index 0 ===");
        list.add(0, "Start");
        System.out.println("List: " + list);

        System.out.println("\n=== Add element in the middle ===");
        list.add(2, "Middle");
        System.out.println("List: " + list);

        System.out.println("\n=== Add element at the end using index ===");
        list.add(list.size(), "End");
        System.out.println("List: " + list);
        System.out.println("Reverse: " + list.toStringReverse());

        System.out.println("\n=== Get element at index 3 ===");
        System.out.println("Element: " + list.get(3));

        System.out.println("\n=== Remove first element ===");
        System.out.println("Removed: " + list.remove(0));
        System.out.println("List: " + list);

        System.out.println("\n=== Remove middle element ===");
        System.out.println("Removed: " + list.remove(2));
        System.out.println("List: " + list);

        System.out.println("\n=== Remove last element ===");
        System.out.println("Removed: " + list.remove(list.size() - 1));
        System.out.println("List: " + list);
        System.out.println("Reverse: " + list.toStringReverse());
        System.out.println("Size: " + list.size());


    }

}
