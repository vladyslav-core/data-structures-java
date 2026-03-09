package queue;

import java.util.ArrayList;
import java.util.List;

import doublelinkedlist.DoubleLinkedList;

public class LinkedQueue<E> {

    private final DoubleLinkedList<E> list = new DoubleLinkedList<E>();


    public void enqueue(E newElement) {
        list.add(newElement);
    }


    public int size() {
       return list.size();
    }


    public E dequeue() {

        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        return list.remove(0);
    }


    public List<E> dequeue(int n) {

        if (n < 0) {
            throw new IllegalArgumentException("Count must be non-negative: " + n);
        }

        if (n > size()) {
            throw new IllegalArgumentException("Not enough elements in queue");
        }

        List<E> result = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            result.add(dequeue());
        }

        return result;
    }

    public E peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return list.get(0);
    }


    @Override
    public String toString() {
        return list.toString();
    }

    // ======================== Helper =============================

    public boolean isEmpty() {
        return size() == 0;
    }


}
