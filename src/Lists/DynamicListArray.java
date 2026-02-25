package Lists;

public class DynamicListArray<E> implements List<E> {
    
    private int length;
    private E[] elements;

    public DynamicListArray() {
        this.length = 0;
        this.elements = (E[]) new Object[0];
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= length) throw new IndexOutOfBoundsException();

        return elements[index];
    }

    @Override
    public E set(int index, E element) throws IndexOutOfBoundsException {
        if (index < 0 || index >= length) throw new IndexOutOfBoundsException();

        elements[index] = element;
        return element;
    }

    @Override
    public void add(int index, Object element) throws IndexOutOfBoundsException {
        if (index < 0 || index > length) throw new IndexOutOfBoundsException();
        length++;

        if (elements.length == 0) {
            elements = (E[]) new Object[]{element};
            return;
        }

        if (length > elements.length) {
            E[] newElements = (E[]) new Object[elements.length * 2];
            for (int i = 0; i < length - 1; i++) {
                newElements[i] = elements[i];
            }

            elements = newElements;
        }

        for (int i = length-1; i > index; i--) {
            elements[i] = elements[i-1];
        }

        elements[index] = (E) element;
    }

    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= length) throw new IndexOutOfBoundsException();

        E holder = elements[index];
        for (int i = index; i < length - 1; i++) {
            elements[i] = elements[i+1];
        }
        elements[length] = null;
        length--;

        return holder;
    }

    @Override
    public String toString() {
        String result = "[";
        for (int i = 0; i < length-1; i++) {
            result += elements[i] + ", ";
        }

        result += elements[length-1] + "]";
        return result;
    }
}
