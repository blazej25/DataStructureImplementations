package Lists.DynamicList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public abstract class ListTest {

    protected List<Integer> list;

    protected abstract List<Integer> createList();

    @BeforeEach
    void setUp() {
        list = createList();
    }

    // --------------------------------
    // Basic State Tests
    // --------------------------------

    @Test
    void newListShouldBeEmpty() {
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    // --------------------------------
    // add(index, element)
    // --------------------------------

    @Test
    void addAtZeroInEmptyList() {
        list.add(0, 10);
        assertEquals(1, list.size());
        assertEquals(10, list.get(0));
    }

    @Test
    void addAtEndShouldAppend() {
        list.add(0, 1);
        list.add(1, 2);
        list.add(2, 3);

        assertEquals(3, list.size());
        assertEquals(3, list.get(2));
    }

    @Test
    void addShouldShiftElementsRight() {
        list.add(0, 1);
        list.add(1, 3);
        list.add(1, 2); // insert in middle

        assertEquals(3, list.size());
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
    }

    @Test
    void addWithInvalidIndexShouldThrow() {
        assertThrows(IndexOutOfBoundsException.class,
                () -> list.add(1, 10)); // invalid in empty list
    }

    // --------------------------------
    // get(index)
    // --------------------------------

    @Test
    void getShouldReturnCorrectElement() {
        list.add(0, 5);
        list.add(1, 10);

        assertEquals(5, list.get(0));
        assertEquals(10, list.get(1));
    }

    @Test
    void getWithInvalidIndexShouldThrow() {
        list.add(0, 5);

        assertThrows(IndexOutOfBoundsException.class,
                () -> list.get(1));
    }

    // --------------------------------
    // set(index, element)
    // --------------------------------

    @Test
    void setShouldReplaceElement() {
        list.add(0, 1);
        list.add(1, 2);

        list.set(1, 99);

        assertEquals(99, list.get(1));
        assertEquals(2, list.size()); // size must not change
    }

    @Test
    void setWithInvalidIndexShouldThrow() {
        assertThrows(IndexOutOfBoundsException.class,
                () -> list.set(0, 5));
    }

    // --------------------------------
    // remove(index)
    // --------------------------------

    @Test
    void removeShouldShiftElementsLeft() {
        list.add(0, 1);
        list.add(1, 2);
        list.add(2, 3);

        list.remove(1); // remove middle element

        assertEquals(2, list.size());
        assertEquals(1, list.get(0));
        assertEquals(3, list.get(1));
    }

    @Test
    void removeFirstElement() {
        list.add(0, 10);
        list.add(1, 20);

        list.remove(0);

        assertEquals(1, list.size());
        assertEquals(20, list.get(0));
    }

    @Test
    void removeLastElement() {
        list.add(0, 10);
        list.add(1, 20);

        list.remove(1);

        assertEquals(1, list.size());
        assertEquals(10, list.get(0));
    }

    @Test
    void removeWithInvalidIndexShouldThrow() {
        assertThrows(IndexOutOfBoundsException.class,
                () -> list.remove(0));
    }

    // --------------------------------
    // Mixed Operations Consistency
    // --------------------------------

    @Test
    void mixedOperationsShouldMaintainCorrectState() {
        list.add(0, 1);
        list.add(1, 2);
        list.add(2, 4);
        list.add(2, 3);   // [1,2,3,4]

        list.remove(1);   // [1,3,4]
        list.set(1, 99);  // [1,99,4]

        assertEquals(3, list.size());
        assertEquals(1, list.get(0));
        assertEquals(99, list.get(1));
        assertEquals(4, list.get(2));
    }

    // --------------------------------
    // Stress / Structural Consistency
    // --------------------------------

    @Test
    void multipleInsertionsAndRemovalsShouldMaintainCorrectSize() {
        for (int i = 0; i < 100; i++) {
            list.add(i, i);
        }

        assertEquals(100, list.size());

        for (int i = 0; i < 50; i++) {
            list.remove(0);
        }

        assertEquals(50, list.size());

        for (int i = 0; i < 50; i++) {
            list.remove(list.size() - 1);
        }

        assertTrue(list.isEmpty());
    }
}