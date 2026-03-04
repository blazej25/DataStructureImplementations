package Heap;

import CustomExceptions.EmptyListException;
import Lists.DynamicList.DynamicListArray;
import Lists.DynamicList.List;

import java.util.Comparator;
import java.util.Objects;

public class ListHeap<E extends Comparable<E>> implements Heap<E> {

    List<E> list;

    public ListHeap() {
        list = new DynamicListArray<>();
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
    public E peek() throws EmptyListException {
        if (isEmpty()) throw new EmptyListException();

        return list.get(0);
    }

    @Override
    public E first() throws EmptyListException{
        if (isEmpty()) throw new EmptyListException();

        E value = list.get(0);
        list.set(0, list.get(list.size() - 1));
        list.remove(list.size() - 1);
        bubbleDown(0);

        return value;
    }

    @Override
    public void add(E element) {
        if (isEmpty()) {
            list.add(0, element);
        } else {
            list.add(list.size() - 1, element);
        }

        heapify();
    }

    private void bubbleDown(int index) {
        int left = 2*index + 1;
        int right = 2*index + 2;

        if (left >= size() && right >= size()) {
            return;
        } else {
            if (list.get(index).compareTo(list.get(left)) > 0) {
                E hold = list.get(index);
                list.set(index, list.get(left));
                list.set(left, hold);
                bubbleDown(left);
                return;
            }
        }

        if (list.get(left).compareTo(list.get(right)) < 0) {
            if (list.get(index).compareTo(list.get(left)) > 0) {
                E hold = list.get(index);
                list.set(index, list.get(left));
                list.set(left, hold);
                bubbleDown(left);
            }
        } else {
            if (list.get(index).compareTo(list.get(right)) > 0) {
                E hold = list.get(index);
                list.set(index, list.get(right));
                list.set(right, hold);
                bubbleDown(right);
            }
        }
    }

    private void heapify() {
        for (int i = list.size() - 1; i > 0; i--) {
            int parent = (i - 1) / 2;

            if (list.get(parent).compareTo(list.get(i)) < 0) continue;

            E hold = list.get(parent);
            list.set(parent, list.get(i));
            list.set(i, hold);
        }
    }
}
