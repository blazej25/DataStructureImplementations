package Heap;

import CustomExceptions.EmptyListException;

public interface Heap<E extends Comparable<E>> {

    int size();
    boolean isEmpty();
    E peek() throws EmptyListException;
    E first() throws EmptyListException;
    void add(E element);
}
