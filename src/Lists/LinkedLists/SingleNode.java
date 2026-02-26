package Lists.LinkedLists;

import java.util.Objects;

public class SingleNode<E> {

    private E value;
    private SingleNode<E> next;

    public SingleNode(E value, SingleNode<E> next) {
        this.value = value;
        this.next = next;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public SingleNode<E> getNext() {
        return next;
    }

    public void setNext(SingleNode<E> next) {
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        SingleNode<?> that = (SingleNode<?>) o;
        return Objects.equals(getValue(), that.getValue()) && Objects.equals(getNext(), that.getNext());
    }
}
