package Heap;

public class ListHeapTest extends HeapTest{

    @Override
    protected Heap<Integer> createHeap() {
        return new ListHeap<Integer>();
    }
}
