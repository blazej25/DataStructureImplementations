package Lists.LinkedLists;

import CustomExceptions.EmptyListException;
import Lists.LinkedLists.Resources.LinkedList;
import Lists.LinkedLists.Resources.SingleNode;

public class CircularLinkedList<E> implements LinkedList<E> {

    int size;
    SingleNode<E> tail;

    public CircularLinkedList() {
        this.tail = null;
        this.size = 0;
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

        return tail.getNext().getValue();
    }

    @Override
    public E last() throws EmptyListException {
        if (isEmpty()) throw new EmptyListException();

        return tail.getValue();
    }

    @Override
    public void addFirst(E element) {
        SingleNode<E> newNode = new SingleNode<>(element, null);

        if (isEmpty()) {
            size++;
            newNode.setNext(newNode);
            tail = newNode;
            return;
        }

        newNode.setNext(tail.getNext());
        tail.setNext(newNode);
        size++;
    }

    @Override
    public void addLast(E element) {
        addFirst(element);
        tail = tail.getNext();
    }

    @Override
    public E removeFirst() throws EmptyListException {
        if (isEmpty()) throw new EmptyListException();

        E value = tail.getNext().getValue();
        size--;

        if(size == 0) {
            tail = null;
            return value;
        }

        tail.setNext(tail.getNext().getNext());
        return value;
    }

    @Override
    public E removeLast() throws EmptyListException {
        if (isEmpty()) throw new EmptyListException();
        if (size == 1) return removeFirst();

        SingleNode<E> previous = tail.getNext();
        E value = tail.getValue();

        while (previous.getNext() != tail) {
            previous = previous.getNext();
        }

        previous.setNext(tail.getNext());
        tail = previous;
        size--;
        return value;
    }
}
