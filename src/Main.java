import CustomExceptions.EmptyListException;
import Heap.*;
import Lists.DynamicList.DynamicListArray;
import Lists.DynamicList.List;

public class Main {

    static void main() throws EmptyListException {
        Heap<Integer> heap = new ListHeap<Integer>();

        heap.add(5);
        heap.add(1);
        heap.add(2);

        System.out.println(heap.first());
        System.out.println(heap.first());
        heap.add(4);
        System.out.println(heap.first());
        heap.add(7);
        System.out.println(heap.first());
        System.out.println(heap.first());
    }
}
