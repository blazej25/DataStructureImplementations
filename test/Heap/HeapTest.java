package Heap;

import CustomExceptions.EmptyListException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public abstract class HeapTest {

    protected Heap<Integer> heap;

    protected abstract Heap<Integer> createHeap();

    @BeforeEach
    void setup() {
        heap = createHeap();
    }

    // -----------------------------
    // Basic state tests
    // -----------------------------

    @Test
    void newHeapShouldBeEmpty() {
        assertTrue(heap.isEmpty());
        assertEquals(0, heap.size());
    }

    @Test
    void addShouldIncreaseSize() {
        heap.add(10);
        assertEquals(1, heap.size());
        assertFalse(heap.isEmpty());
    }

    // -----------------------------
    // Exception behavior
    // -----------------------------

    @Test
    void peekOnEmptyHeapShouldThrowException() {
        assertThrows(EmptyListException.class, () -> heap.peek());
    }

    @Test
    void firstOnEmptyHeapShouldThrowException() {
        assertThrows(EmptyListException.class, () -> heap.first());
    }

    // -----------------------------
    // Single element
    // -----------------------------

    @Test
    void singleElementShouldBeReturnedAsMinimum() throws EmptyListException {
        heap.add(42);

        assertEquals(42, heap.peek());
        assertEquals(42, heap.first());
        assertEquals(0, heap.size());
    }

    // -----------------------------
    // Heap property tests
    // -----------------------------

    @Test
    void smallestElementShouldBeAtRoot() throws EmptyListException {
        heap.add(10);
        heap.add(5);
        heap.add(20);
        heap.add(1);

        assertEquals(1, heap.peek());
    }

    @Test
    void addingSmallerElementShouldUpdateRoot() throws EmptyListException {
        heap.add(10);
        heap.add(20);

        assertEquals(10, heap.peek());

        heap.add(5);

        assertEquals(5, heap.peek());
    }

    // -----------------------------
    // Multiple insertions
    // -----------------------------

    @Test
    void heapShouldAlwaysExposeMinimum() throws EmptyListException {
        heap.add(8);
        heap.add(3);
        heap.add(6);
        heap.add(1);
        heap.add(9);

        assertEquals(1, heap.peek());
    }

    // -----------------------------
    // Size consistency
    // -----------------------------

    @Test
    void sizeShouldMatchNumberOfInsertions() {
        for (int i = 0; i < 100; i++) {
            heap.add(i);
        }

        assertEquals(100, heap.size());
    }

    // -----------------------------
    // Stress ordering test
    // -----------------------------

    @Test
    void heapShouldMaintainCorrectMinimumDuringRandomInsertions() throws EmptyListException {

        heap.add(50);
        heap.add(30);
        heap.add(40);
        heap.add(10);
        heap.add(20);
        heap.add(60);
        heap.add(5);

        assertEquals(5, heap.peek());
    }

}