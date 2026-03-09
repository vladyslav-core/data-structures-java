package queue;

public class Main {
    public static void main(String[] args) {

        LinkedQueue<Integer> queue = new LinkedQueue<>();

        System.out.println("=== ENQUEUE ===");

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);

        System.out.println(queue);

        System.out.println("\n=== SIZE ===");
        System.out.println(queue.size());

        System.out.println("\n=== PEEK ===");
        System.out.println(queue.peek());

        System.out.println("\n=== DEQUEUE ===");
        System.out.println(queue.dequeue());
        System.out.println(queue);

        System.out.println("\n=== DEQUEUE MULTIPLE ===");
        System.out.println(queue.dequeue(2));
        System.out.println(queue);

        System.out.println("\n=== ISEMPTY ===");
        System.out.println(queue.isEmpty());

    }
}
