package Lists.LinkedLists;

import CustomExceptions.EmptyListException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public abstract class LinkedListTest {

    protected LinkedList<Integer> testList;

    protected abstract  LinkedList<Integer> createList();

    @BeforeEach
    public void setup() {
        testList = createList();
    }

    @Test
    public void singleElementTest() throws EmptyListException {
        testList.addFirst(1);
        assertEquals(1, testList.first());
    }

    @Test
    public void singleElementRemoveTest() throws EmptyListException {
        testList.addFirst(1);
        testList.removeFirst();
        assertTrue(testList.isEmpty());
    }
}