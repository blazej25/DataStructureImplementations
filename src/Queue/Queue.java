package Queue;

import CustomExceptions.EmptyListException;

public interface Queue<E> {

    int size();
    boolean isEmpty();
    E peak() throws EmptyListException;
    E dequeue() throws EmptyListException;
    void enqueue(E element);
}
