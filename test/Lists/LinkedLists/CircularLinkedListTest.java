package Lists.LinkedLists;

public class CircularLinkedListTest extends LinkedListTest{

    @Override
    protected LinkedList<Integer> createList() {
        return new CircularLinkedList<>();
    }
}
