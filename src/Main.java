import CustomExceptions.EmptyListException;
import Heap.*;
import Lists.DynamicList.DynamicListArray;
import Lists.DynamicList.List;

public class Main {

    static void main() throws EmptyListException {
        List<Integer> list = new DynamicListArray<>();
        list.add(0, 4);
        list.add(list.size(), 1);
        list.add(list.size(), 9);
        list.add(list.size(), 0);

        Heap<Integer> heap = new ListHeap<Integer>(list);

        System.out.println(heap.first());
        System.out.println(heap.first());
        System.out.println(heap.first());
        System.out.println(heap.first());
    }
}
