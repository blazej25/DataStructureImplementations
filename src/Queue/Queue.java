package Queue;

import CustomExceptions.EmptyListException;

public interface Queue<E> {

    int size();
    boolean isEmpty();
    E peek() throws EmptyListException;
    E dequeue() throws EmptyListException;
    void enqueue(E element);
}
