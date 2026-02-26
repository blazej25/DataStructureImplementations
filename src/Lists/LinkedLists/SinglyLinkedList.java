package Lists.LinkedLists;

import CustomExceptions.EmptyListException;

public class SinglyLinkedList<E> implements LinkedList<E>{

    SingleNode<E> head;
    SingleNode<E> tail;
    int size;

    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public E first() throws EmptyListException {
        if (this.isEmpty()) throw new EmptyListException();

        return head.getValue();
    }

    @Override
    public E last() throws EmptyListException {
        if (this.isEmpty()) throw new EmptyListException();

        return tail.getValue();
    }

    @Override
    public void addFirst(E element) {
        this.head = new SingleNode<>(element, this.head);

        if (isEmpty()) this.tail = this.head;
        size++;
    }

    @Override
    public void addLast(E element) {
        if (tail == null) {
            this.addFirst(element);
            return;
        }

        this.tail.setNext(new SingleNode<>(element, null));
        this.tail = this.tail.getNext();
    }

    @Override
    public E removeFirst() throws EmptyListException {
        if (this.isEmpty()) throw new EmptyListException();
        E value = this.head.getValue();
        this.head = this.head.getNext();
        this.size--;

        return value;
    }

    @Override
    public E removeLast() throws EmptyListException {
        if (this.isEmpty()) throw new EmptyListException();
        E value = this.tail.getValue();
        SingleNode<E> newTail = head;

        while (!this.tail.equals(newTail.getNext())) {
            newTail = newTail.getNext();
        }

        newTail.setNext(null);
        this.tail = newTail;

        return value;
    }
}
