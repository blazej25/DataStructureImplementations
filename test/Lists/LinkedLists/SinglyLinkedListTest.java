package Lists.LinkedLists;

import Lists.LinkedLists.Resources.LinkedList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SinglyLinkedListTest extends LinkedListTest{

    @Override
    protected LinkedList<Integer> createList() {
        return new SinglyLinkedList<>();
    }
}
