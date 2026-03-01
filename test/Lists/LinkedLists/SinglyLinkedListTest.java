package Lists.LinkedLists;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SinglyLinkedListTest extends LinkedListTest{

    @Override
    protected LinkedList<Integer> createList() {
        return new SinglyLinkedList<>();
    }
}
