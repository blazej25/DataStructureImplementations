package BinaryTree;

import java.util.Objects;

public class BinaryTree<E> {

    private E value;
    private BinaryTree<E> left;
    private BinaryTree<E> right;

    public BinaryTree() {}

    public BinaryTree(E value, BinaryTree<E> left, BinaryTree<E> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
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
        return Objects.equals(getValue(), that.getValue()) && Objects.equals(getLeft(), that.getLeft()) && Objects.equals(getRight(), that.getRight());
    }
}
