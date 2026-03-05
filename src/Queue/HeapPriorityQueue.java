package Queue;

import CustomExceptions.EmptyListException;
import Heap.*;

public class HeapPriorityQueue<E extends Comparable<E>> implements Queue<E>{

    private Heap<E> heap;

    public HeapPriorityQueue() {
        heap = new ListHeap<E>();
    }

    @Override
    public int size() {
        return heap.size();
    }

    @Override
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    @Override
    public E peek() throws EmptyListException {
        return heap.peek();
    }

    @Override
    public E dequeue() throws EmptyListException {
        return heap.first();
    }

    @Override
    public void enqueue(E element) {
        heap.add(element);
    }
}
