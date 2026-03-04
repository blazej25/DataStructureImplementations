package Lists.LinkedLists;

public class DoublyLInkedListTest extends LinkedListTest{

    @Override
    protected LinkedList<Integer> createList() {
        return new DoublyLinkedList<>();
    }
}
