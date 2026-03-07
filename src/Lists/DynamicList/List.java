package Lists.DynamicList;

public interface List<E> {

    int size();
    boolean isEmpty();
    E get(int index) throws IndexOutOfBoundsException;
    E set(int index, E element) throws IndexOutOfBoundsException;
    void add(int index, E element) throws IndexOutOfBoundsException;
    E remove(int index) throws IndexOutOfBoundsException;

    static <G> List<G> listOf(G[] arr) {
        List<G> result = new DynamicListArray<>();

        for (int i = 0; i < arr.length; i++) {
            result.add(result.size(), arr[i]);
        }

        return result;
    };
}
