package Heap;

import BinaryTree.BinaryTree;
import CustomExceptions.EmptyListException;
import Queue.*;

public class BinaryTreeHeap<E extends Comparable<E>> implements Heap<E>{

    private BinaryTree<E> root;
    private int size;
    private int height;

    public BinaryTreeHeap() {
        root = new BinaryTree<E>();
        size = 0;
        height = 0;
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
    public E peek() throws EmptyListException {
        if (isEmpty()) throw new EmptyListException();

        return root.getValue();
    }

    @Override
    public E first() throws EmptyListException {
        if (isEmpty()) throw new EmptyListException();

        E value = root.getValue();

        BinaryTree<E> oneBefore = findLast();
        BinaryTree<E> last;

        if (oneBefore.getRight() == null) {
            last = oneBefore.getLeft();
            oneBefore.setLeft(null);
        } else {
            last = oneBefore.getRight();
            oneBefore.setRight(null);
        }

        last.setLeft(root.getLeft());
        last.setRight(root.getRight());
        root = last;

        bubbleDown(root);

        return value;
    }

    @Override
    public void add(E element) {
        size++;
        height = (int) Math.log(size);

        if (size == 1) {
            root = new BinaryTree<E>(element, null, null);
            return;
        }

        if (size == Math.pow(2, height)) {
            BinaryTree<E> left = findLeftmost();
            left.setLeft(new BinaryTree<E>(element, null, null));
        }
    }

    private BinaryTree<E> findLast() throws EmptyListException {
        Queue<BinaryTree<E>> queue = new LinkedQueue<BinaryTree<E>>();
        BinaryTree<E> result = root;
        queue.enqueue(root);

        while(!queue.isEmpty()) {
            BinaryTree<E> holder = queue.dequeue();

            if (holder.getLeft() != null && holder.getLeft().getLeft() == null) {
                result = holder;
            }

            queue.enqueue(holder.getLeft());
            if (holder.getRight() != null)
                queue.enqueue(holder.getRight());
        }

        return result;
    }

    private void bubbleDown(BinaryTree<E> tree) {
        BinaryTree<E> left = tree.getLeft();
        BinaryTree<E> right = tree.getRight();

        if (left != null && right != null) {
            if (tree.getValue().compareTo(left.getValue()) < 0 &&
                    tree.getValue().compareTo(right.getValue()) < 0) return;

            if (tree.getValue().compareTo((left.getValue())) > 0) {
                if (left.getValue().compareTo(right.getValue()) < 0) {
                    swap(tree, left);
                    bubbleDown(left);
                } else {
                    swap(tree, right);
                    bubbleDown(right);
                }
            }
        } else if (left != null) {
            if (tree.getValue().compareTo((left.getValue())) > 0) {
                swap(tree, left);
                bubbleDown(left);
            }
        } else {
            if (tree.getValue().compareTo((right.getValue())) > 0) {
                swap(tree, right);
                bubbleDown(right);
            }
        }
    }

    private void swap(BinaryTree<E> parent, BinaryTree<E> child) {
        E hold = parent.getValue();
        parent.setValue(hold);
        child.setValue(hold);
    }

    private BinaryTree<E> findLeftmost() {
        BinaryTree<E> current = root;

        while (current.getLeft() != null) {
            current = current.getLeft();
        }

        return current;
    }
}
