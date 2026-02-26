package Lists.LinkedLists;

import CustomExceptions.EmptyListException;

public interface LinkedList<E> {

    int size();
    boolean isEmpty();
    E first() throws EmptyListException;
    E last() throws EmptyListException;
    void addFirst(E element);
    void addLast(E element);
    E removeFirst() throws EmptyListException;
    E removeLast() throws EmptyListException;
}
