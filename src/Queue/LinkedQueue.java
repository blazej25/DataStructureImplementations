package Queue;

import CustomExceptions.EmptyListException;
import Lists.LinkedLists.LinkedList;
import Lists.LinkedLists.SinglyLinkedList;

public class LinkedQueue<E> implements Queue<E>{

    private LinkedList<E> list;

    public LinkedQueue() {
        list = new SinglyLinkedList<>();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public E peak() throws EmptyListException {
        return list.first();
    }

    @Override
    public E dequeue() throws EmptyListException {
        return list.removeFirst();
    }

    @Override
    public void enqueue(E element) {
        list.addLast(element);
    }
}
