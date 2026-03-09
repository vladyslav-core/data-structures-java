package doublelinkedlist;

public class DoubleLinkedList<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;


    // --- Constructor ---
    public DoubleLinkedList() {
        this.size = 0;
    }


    // ======================== Methods ===========================

    public void add(E value) {
        Node<E> newNode = new Node<>(value);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }

        size++;
    }


    public void add(int index, E value) {
        checkPositionIndex(index);

        if (index == size) {
            add(value);
            return;
        }

        Node<E> newNode = new Node<>(value);

        if (index == 0) {
            newNode.next = head;
            if (head != null) {
                head.prev = newNode;
            }
            head = newNode;
            size++;
            return;
        }

        Node<E> cursor = searchNode(index);

        Node<E> prevNode = cursor.prev;

        newNode.prev = prevNode;
        newNode.next = cursor;

        prevNode.next = newNode;
        cursor.prev = newNode;

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

        if (size == 1) {
            E removedValue = head.value;
            head = null;
            tail = null;
            size--;
            return removedValue;
        }

        if (index == 0) {
            E removedValue = head.value;
            Node<E> oldHead = head;
            head = head.next;
            head.prev = null;

            oldHead.next = null;

            size--;
            return removedValue;
        }

        if (index == size - 1) {
            E removedValue = tail.value;
            Node<E> oldTail = tail;
            tail = tail.prev;
            tail.next = null;

            oldTail.prev = null;

            size--;
            return removedValue;
        }

        Node<E> cursor = searchNode(index);
        E removedValue = cursor.value;

        Node<E> prevNode = cursor.prev;
        Node<E> nextNode = cursor.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;

        cursor.next = null;
        cursor.prev = null;

        size--;

        return removedValue;
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
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

    public String toStringReverse() {
        StringBuilder builder = new StringBuilder("[");
        Node<E> cursor = tail;

        while (cursor != null) {
            builder.append(cursor.value);
            if (cursor.prev != null) {
                builder.append(", ");
            }
            cursor = cursor.prev;
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
        Node<E> cursor;

        if (index < size / 2) {
            cursor = head;
            for (int i = 0; i < index; i++) {
                cursor = cursor.next;
            }
        } else {
            cursor = tail;
            for (int i = size - 1; i > index; i--) {
                cursor = cursor.prev;
            }
        }

        return cursor;
    }
}
