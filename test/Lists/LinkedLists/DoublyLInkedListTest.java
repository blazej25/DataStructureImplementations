package Lists.LinkedLists;

import Lists.LinkedLists.Resources.LinkedList;

public class DoublyLInkedListTest extends LinkedListTest{

    @Override
    protected LinkedList<Integer> createList() {
        return new DoublyLinkedList<>();
    }
}
