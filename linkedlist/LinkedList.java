package linkedlist;


public class LinkedList<E> {

    private Node<E> head;
    private int size;


    // --- Constructor ---
    public LinkedList() {
        this.size = 0;
    }


    // ======================== Methods ===========================

    public void add(E value) {
        Node<E> newNode = new Node<>(value);

        if (head == null) {
            head = newNode;
        } else {
            Node<E> cursor = head;
            while (cursor.next != null) {
                cursor = cursor.next;
            }
            cursor.next = newNode;
        }
        size++;
    }

    public void add(int index, E value) {
        checkPositionIndex(index);

        Node<E> newNode = new Node<>(value);

        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node<E> previousNode = searchNode(index - 1);
            newNode.next = previousNode.next;
            previousNode.next = newNode;
        }
        size++;
    }


    public int size() {
        return size;
    }


    public E get(int index) {
        checkElementIndex(index);

        return searchNode(index).value;
    }





    public E remove(int index) {
        checkElementIndex(index);

        if (index == 0) {
            E removedValue = head.value;
            head = head.next;
            size--;
            return removedValue;
        }

        Node<E> previousNode = searchNode(index - 1);

        E removedValue = previousNode.next.value;
        previousNode.next = previousNode.next.next;
        size--;

        return removedValue;
    }


    @Override
    public String toString() {
        StringBuilder builder  = new StringBuilder("[");
        Node<E> cursor = head;

        while (cursor != null) {
            builder.append(cursor.value);
            if (cursor.next != null) {
                builder.append(", ");
            }
            cursor = cursor.next;
        }

        builder.append("]");
        return builder.toString();
    }

    // ======================== Helper =============================

    private void checkPositionIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    private void checkElementIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    private Node<E> searchNode(int index) {
        Node<E> cursor = head;

        for (int i = 0; i < index; i++) {
            cursor = cursor.next;
        }
        return cursor;
    }
}
