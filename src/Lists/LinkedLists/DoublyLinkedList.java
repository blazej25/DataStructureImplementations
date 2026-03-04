package Lists.LinkedLists;

import CustomExceptions.EmptyListException;

public class DoublyLinkedList<E> implements LinkedList<E>{

    private DoubleNode<E> head;
    private DoubleNode<E> tail;
    int size;

    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E first() throws EmptyListException {
        if (isEmpty()) throw new EmptyListException();

        return head.getValue();
    }

    @Override
    public E last() throws EmptyListException {
        if (isEmpty()) throw new EmptyListException();

        return tail.getValue();
    }

    @Override
    public void addFirst(E element) {
        size++;
        DoubleNode<E> newNode = new DoubleNode<>(element, null, head);

        if (size == 1) {
            head = newNode;
            tail = newNode;
            return;
        }

        head.setPrevious(newNode);
        head = newNode;
    }

    @Override
    public void addLast(E element) {
        if (isEmpty()) {
            addFirst(element);
            return;
        }

        DoubleNode<E> newNode = new DoubleNode<>(element, tail, null);
        tail.setNext(newNode);
        tail = newNode;
        size++;
    }

    @Override
    public E removeFirst() throws EmptyListException {
        if (isEmpty()) throw new EmptyListException();

        E value = head.getValue();
        size--;

        if (size == 0) {
            head = null;
            tail = null;
            return value;
        }

        head = head.getNext();
        head.setPrevious(null);
        return value;
    }

    @Override
    public E removeLast() throws EmptyListException {
        if (isEmpty()) throw new EmptyListException();

        if (size == 1) return removeFirst();

        E value = tail.getValue();
        tail = tail.getPrevious();
        tail.setNext(null);
        size--;
        return value;
    }
}
