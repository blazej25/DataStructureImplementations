package BinaryTree;

import java.util.Objects;

public class BinaryTree<E> {

    private E root;
    private BinaryTree<E> left;
    private BinaryTree<E> right;

    public BinaryTree(E root, BinaryTree<E> left, BinaryTree<E> right) {
        this.root = root;
        this.left = left;
        this.right = right;
    }

    public E getRoot() {
        return root;
    }

    public void setRoot(E root) {
        this.root = root;
    }

    public BinaryTree<E> getLeft() {
        return left;
    }

    public void setLeft(BinaryTree<E> left) {
        this.left = left;
    }

    public BinaryTree<E> getRight() {
        return right;
    }

    public void setRight(BinaryTree<E> right) {
        this.right = right;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        BinaryTree<?> that = (BinaryTree<?>) o;
        return Objects.equals(getRoot(), that.getRoot()) && Objects.equals(getLeft(), that.getLeft()) && Objects.equals(getRight(), that.getRight());
    }
}
