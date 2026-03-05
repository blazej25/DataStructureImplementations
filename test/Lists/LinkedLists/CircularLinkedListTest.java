package Lists.LinkedLists;

import Lists.LinkedLists.Resources.LinkedList;

public class CircularLinkedListTest extends LinkedListTest{

    @Override
    protected LinkedList<Integer> createList() {
        return new CircularLinkedList<>();
    }
}
